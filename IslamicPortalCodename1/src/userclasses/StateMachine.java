package userclasses;

import generated.StateMachineBase;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

import userclasses.json.JSONArray;
import userclasses.json.JSONException;
import userclasses.json.JSONObject;
import userclasses.quran.Player;
import userclasses.renderer.AayaListRenderer;
import userclasses.renderer.SurahListRenderer;
import userclasses.renderer.WallpaperListRenderer;

import com.codename1.components.Progress;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.io.services.ImageDownloadService;
import com.codename1.javascript.JSObject;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.List;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.list.ContainerList;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.util.Resources;
import com.codename1.xml.Element;
import com.codename1.xml.XMLParser;

/**
 *
 * @author Your name here
 */
public class StateMachine extends StateMachineBase {

	public static StateMachine stateMachine;
	
	public static Media media;
	
    String wallpaperUrlResponse;
    String wallpaperDownloadUrl;
    Button showWallpapers;
    int selectedSurahNumber;
    int selectedSurahPartNumber=1;
    Button selectSurah;
    String surahBoardText;
    
    
    String surahVoiceUrlResponse;
    
    public StateMachine(String resFile) {
        super(resFile);
        // do not modify, write code in initVars and initialize class members there,
        // the constructor might be invoked too late due to race conditions that might occur
    }

    /**
     * this method should be used to initialize variables instead of the
     * constructor/class scope to avoid race conditions
     */
    protected void initVars() {
    	stateMachine = this;
        NetworkManager.getInstance().start();
    }

    

	String postRequest(String url) {
		String response=null;
		ConnectionRequest request = new ConnectionRequest() {
			protected void readResponse(InputStream input) {
				// just read from the response input stream
				byte[] data = null;
				if (getResponseCode() == 200) {
					// If content length is not given, read in chunks.
					int length = 0;
					DataInputStream in = null;
					int chunkSize = 512;
					int index = 0;
					int readLength = 0;
					in = new DataInputStream(input);
					data = new byte[chunkSize];
					do {
						if (data.length < index + chunkSize) {
							byte[] newData = new byte[index + chunkSize];
							System.arraycopy(data, 0, newData, 0, data.length);
							data = newData;
						}
						try {
							readLength = in.read(data, index, chunkSize);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						index += readLength;
					} while (readLength == chunkSize);
					length = index;
				}
				wallpaperUrlResponse = new String(data);
				
			}
			
			protected void postResponse() {
				// invoked on the EDT after processing is complete to allow the
				// networking code
				// to update the UI
			}

			protected void buildRequestBody(OutputStream os) {
				// writes post data, by default this �just works� but if you
				// want to write this
				// manually then override this

				try {
					JSONObject jSONObject = new JSONObject();
					jSONObject.put("start_count", 1);
					jSONObject.put("end_count", 10);
					jSONObject.put("type", 1);
					// os.write("{\"start_count\":\"1\",\"end_count\":\"12\"}".getBytes());
					os.write(jSONObject.toString().getBytes());

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		request.setUrl(url);
		request.setPost(true);
		request.addRequestHeader("username", "bng");
		request.addRequestHeader("password", "123456");
		Progress progress = new Progress("Please Wait...", request);
		progress.setDisposeOnCompletion(true);
		NetworkManager.getInstance().addToQueue(request);
		progress.show();
		return response;
	}
    
    protected boolean onMainScreenWallpapers() {
        // If the resource file changes the names of components this call will break notifying you that you should fix the code
        boolean val = super.onMainScreenWallpapers();
        postRequest("http://android.bng.gcs.net.in/api/walpaper");
        System.out.println("response : " + wallpaperUrlResponse);
        return val;
    }

    @Override
	protected void beforeWallpaper(Form f) {
		showWallpapers = findButtonShowWallpaper(f);
	}

	@Override
    protected boolean initListModelContainerList(ContainerList cmp) {
      cmp.setLayout(new GridLayout(4, 2));
      cmp.setModel(new DefaultListModel(parseWallpaperThumbnailJSON(wallpaperUrlResponse, cmp)));
      cmp.setRenderer(new WallpaperListRenderer());
        return true;
    }
    
    public Vector parseWallpaperThumbnailJSON(String response, ContainerList cmp) {
        Vector resultVector = new Vector();
        Image blank = Image.createImage(50, 50);
        try {
            JSONObject jSONObject = new JSONObject(response);
            System.out.println(jSONObject);
            Enumeration e = jSONObject.keys();
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                System.out.println(key + " : " + jSONObject.getString(key));
                if (key.equalsIgnoreCase("wallpapers")) {
                    JSONArray jSONArray = jSONObject.getJSONArray(key);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject wallpaper = jSONArray.getJSONObject(i);
                        if (wallpaper.has("image_thumb_url") && wallpaper.has("image_category") && wallpaper.has("image_url") && wallpaper.has("wallpaper_price")) {
                            //download the thumbnail and display it.
//                        	Dialog.show(null,"i = "+i , "OK", null);
                            Hashtable hashtable = new Hashtable();
                            hashtable.put("wallpaperThumbnailURL", wallpaper.getString("image_thumb_url"));
                            hashtable.put("wallpaperURL", wallpaper.get("image_url"));
                            hashtable.put("wallpaperPrice", "Price: " + wallpaper.get("wallpaper_price"));
                            hashtable.put("wallpaperIcon", blank);
                            resultVector.addElement(hashtable);
                            ImageDownloadService ids = new ImageDownloadService(wallpaper.getString("image_thumb_url"), cmp, resultVector.size() - 1, "wallpaperIcon");
//                            {
//                                protected void handleException(Exception err) {
//                                    if (err instanceof NullPointerException) {
//                                        System.out.println("NULL POINTER EXCEPTION CAUGHT");
//                                        return;
//                                    }
//                                    super.handleException(err); //To change body of generated methods, choose Tools | Templates.
//                                }
//                            };
                            NetworkManager.getInstance().addToQueue(ids);
                        }
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Dialog.show(null, "error downloading images. "+ex.getMessage(), "OK", null);
        }
        return resultVector;
        
    }

//    @Override
//    protected boolean initListModelContainerList(com.codename1.ui.list.ContainerList cmp) {
//    	
//    	NativeCoordinates coordinates = (NativeCoordinates) NativeLookup.create(NativeCoordinates.class);
//    	 Dialog.show(null, "is supported : "+coordinates.isSupported(), "OK", null);
//    	
//    	if(coordinates!=null)
//    	{
//    		double[] a = coordinates.getCoordinates();
//    		Dialog.show(null, "native returned : "+a, "OK", null);
//    		if(a!=null)cmp.setModel(new com.codename1.ui.list.DefaultListModel(new String[] {""+a[0], ""+a[1]}));
//    		else cmp.setModel(new com.codename1.ui.list.DefaultListModel(new String[] {"getcoordinates was null"}));
//    	}
//    	else 
//    		cmp.setModel(new com.codename1.ui.list.DefaultListModel(new String[] {"nothing"}));
//    	
//        return true;
//    }


    @Override
    protected void onWallpaper_ContainerListAction(Component c, ActionEvent event) {
    	try {
    		ContainerList l = (ContainerList) c;
    		Hashtable name = (Hashtable) l.getSelectedItem();
    		StringBuilder builder = new StringBuilder();
    		builder.append("wallpaperThumbnailURL : "+name.get("wallpaperThumbnailURL"));
    		builder.append("\nwallpaperURL : "+name.get("wallpaperURL"));
    		builder.append("\nwallpaperPrice : "+name.get("wallpaperPrice"));
    		builder.append("\nwallpaperIcon : "+name.get("wallpaperIcon"));
    		
    		Dialog.show(null, builder.toString(), "OK", null);
    		
    		if(showWallpapers==null)
    	    	Dialog.show(null, "Error Displaying Wallpaper", "OK", null);
    		else {
    			wallpaperDownloadUrl = (String)name.get("wallpaperURL");
    			showWallpapers.released();
    		}
    		
        } catch (Exception e) {
        	e.printStackTrace();
            Dialog.show(null, "onWallpaper_ContainerListAction excepption", "OK", null);
        }
    
    }

    @Override
    protected void beforeWallpaperFullScreen(final Form f) {
        final Label image = findImage(f);
//        ImageDownloadService ids = new ImageDownloadService(wallpaperDownloadUrl, image);
        ImageDownloadService ids = new ImageDownloadService(wallpaperDownloadUrl, new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                if (ae.getSource() != null) {
                    ImageDownloadService imageDownloadService = (ImageDownloadService) ae.getSource();
                    Image i = imageDownloadService.getResult();
                    if (i.getHeight() > i.getWidth()) {
                        int h = Display.getInstance().getDisplayHeight()
                                - f.getTitleComponent().getPreferredH()
                                - ((f.getSoftButtonCount() < 1) ? 0 : f.getSoftButton(0).getParent().getPreferredH());
                        if(i.getHeight()>h) i = i.scaledHeight(h);
                    } else {
                        int w = Display.getInstance().getDisplayWidth();
                        if(i.getWidth()>w) i = i.scaledWidth(w);
                    }
                    image.setIcon(i);
                }
            }
        });
        Progress p = new Progress("please wait..", ids);
        p.setDisposeOnCompletion(true);
        NetworkManager.getInstance().addToQueue(ids);
        p.show();
    }

    @Override
    protected boolean initListModelListSurah(List cmp) {
    	
    	cmp.setRenderer(new SurahListRenderer());
    	
    	InputStream inputStream = Display.getInstance().getResourceAsStream(this.getClass(), "/surah.xml");
    	XMLParser parser = new XMLParser();
    	Element element = parser.parse(new InputStreamReader(inputStream)).getChildAt(0);

    	Vector surahs = new Vector(element.getNumChildren());
    	
    	
    	
    	for(int i=0;i<element.getNumChildren();i++){
    		Hashtable hashtable = new Hashtable();
    		hashtable.put("num", element.getChildAt(i).getAttribute("n"));
    		hashtable.put("name", element.getChildAt(i).getChildAt(0).getText());
    		surahs.add(hashtable);
//    		System.out.println(element.getChildAt(i).getAttribute("n") +" -----  " + element.getChildAt(i).getChildAt(0).getText());
    	}
    	System.out.println(surahs.size());
    	cmp.setModel(new com.codename1.ui.list.DefaultListModel(surahs));
//    	System.out.println(element.toString());
    	
        return true;
    }

    @Override
    protected void beforeSurah(Form f) {
    	selectSurah = findSurahSelect(f);
    }

    @Override
    protected void onSurah_ListSurahAction(Component c, ActionEvent event) {
    	try {
    		List l = (List) c;
    		Hashtable name = (Hashtable) l.getSelectedItem();
    		
    		selectedSurahNumber = Integer.parseInt((String)name.get("num"));
    		selectedSurahPartNumber = 1;
    		surahBoardText = (String)name.get("name");
    		StringBuilder builder = new StringBuilder();
    		builder.append("num : "+name.get("num"));
    		builder.append("\name : "+name.get("name"));
    		
    		Dialog.show(null, builder.toString(), "OK", null);
    		
    		if(selectSurah==null)
    	    	Dialog.show(null, "Error Displaying Aaya's", "OK", null);
    		else {
    			selectSurah.released();
    		}
    		
        } catch (Exception e) {
        	e.printStackTrace();
            Dialog.show(null, "onSurah_ListSurahAction excepption", "OK", null);
        }
    
    }

    @Override
    protected void beforeAaya(Form f) {
    	Label label = findLabelSurahBoardText(f);
    	label.setText(surahBoardText);
    }

    @Override
    protected boolean initListModelListAaya(List cmp) {
    	cmp.setRenderer(new AayaListRenderer());
    	String filename = "/"+selectedSurahNumber+"_"+selectedSurahPartNumber+".xml";
    	System.out.println(filename);
    	InputStream inputStream = Display.getInstance().getResourceAsStream(this.getClass(), filename);
    	XMLParser parser = new XMLParser();
    	Element element = null;
		try {
			element = parser.parse(new InputStreamReader(inputStream,"UTF-8")).getChildAt(0);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	Vector surahs = new Vector(element.getNumChildren());
    	
    	
    	
    	for(int i=0;i<element.getNumChildren();i++){
    		Hashtable hashtable = new Hashtable();
    		hashtable.put("numLeft", element.getChildAt(i).getAttribute("n"));
    		hashtable.put("name", element.getChildAt(i).getChildAt(0).getText());
    		surahs.add(hashtable);
//    		System.out.println(element.getChildAt(i).getAttribute("n") +" -----  " + element.getChildAt(i).getChildAt(0).getText());
    	}
    	System.out.println(surahs.size());
    	cmp.setModel(new com.codename1.ui.list.DefaultListModel(surahs));
//    	System.out.println(element.toString());

        return true;
    }

    @Override
    protected void beforePrayerAlert(Form f) {
    	Player.f = f;
    }

    @Override
    protected boolean onPrayerAlertStored() {
    	try {
    		System.out.println(media==null?"null":"not null");
			if(media ==null || !media.isPlaying()){
    		media = MediaManager.createMedia(Display.getInstance().getResourceAsStream(this.getClass(), "/"+Player.i+".m4a"), "audio/m4a", new Player());
			media.play();
			}
			else{
				Dialog.show(null, "already playing", "OK", null);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			media=null;
			e.printStackTrace();
		}
        return true;
    }

    @Override
    protected boolean onPrayerAlertDownload() {
    	
    	final String BASE_URL="http://android.bng.gcs.net.in/api/voices";
        
    	postRequestVoice(BASE_URL,0);
    	ArrayList arrayList = new ArrayList();
    	try {
			JSONObject jsonObject = new JSONObject(surahVoiceUrlResponse);
			JSONArray jsonArray = jsonObject.getJSONObject("voice").getJSONArray("sound_info");
//			parseSurahVoiceThumbnailJSON(jsonArray);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	return true;
    }
    

	String postRequestVoice(String url,final int i) {
		String response=null;
		ConnectionRequest request = new ConnectionRequest() {
			protected void readResponse(InputStream input) {
				// just read from the response input stream
				byte[] data = null;
				System.out.println(getResponseCode());
				if (getResponseCode() == 200) {
					// If content length is not given, read in chunks.
					int length = 0;
					DataInputStream in = null;
					int chunkSize = 512;
					int index = 0;
					int readLength = 0;
					in = new DataInputStream(input);
					data = new byte[chunkSize];
					do {
						if (data.length < index + chunkSize) {
							byte[] newData = new byte[index + chunkSize];
							System.arraycopy(data, 0, newData, 0, data.length);
							data = newData;
						}
						try {
							readLength = in.read(data, index, chunkSize);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						index += readLength;
					} while (readLength == chunkSize);
					length = index;
				}
				surahVoiceUrlResponse = new String(data);
				
			}
			
			protected void postResponse() {
				// invoked on the EDT after processing is complete to allow the
				// networking code
				// to update the UI
				System.out.println(surahVoiceUrlResponse);
			}

			protected void buildRequestBody(OutputStream os) {
				// writes post data, by default this �just works� but if you
				// want to write this
				// manually then override this
				if(i==1) return;
				try {
					JSONObject jSONObject = new JSONObject();
					jSONObject.put("recorded_by", "Saurabh Saxena");
					jSONObject.put("sourate_no", 1);
					// os.write("{\"start_count\":\"1\",\"end_count\":\"12\"}".getBytes());
					os.write(jSONObject.toString().getBytes());
					
					System.out.println(jSONObject);

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		request.setUrl(url);
		request.setPost(true);
		request.addRequestHeader("username", "bng");
		request.addRequestHeader("password", "123456");
		request.addRequestHeader("app_version", "1.9");
		request.addRequestHeader("device_type", "android");
		Progress progress = new Progress("Please Wait...", request);
		progress.setDisposeOnCompletion(true);
		NetworkManager.getInstance().addToQueue(request);
		progress.show();
		return response;
	}

}

