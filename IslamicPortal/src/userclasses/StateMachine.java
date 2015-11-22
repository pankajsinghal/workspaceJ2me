package userclasses;

import generated.StateMachineBase;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import userclasses.Network.CellInfo;
import userclasses.Network.GetCellIdCoordinates;
import userclasses.json.JSONArray;
import userclasses.json.JSONObject;
import userclasses.renderer.AayaListRenderer;
import userclasses.renderer.SurahListRenderer;

import com.nokia.mid.network.SIMState;
import com.sun.lwuit.Button;
import com.sun.lwuit.Component;
import com.sun.lwuit.Container;
import com.sun.lwuit.Dialog;
import com.sun.lwuit.Form;
import com.sun.lwuit.Image;
import com.sun.lwuit.Label;
import com.sun.lwuit.List;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.io.NetworkManager;
import com.sun.lwuit.io.services.ImageDownloadService;
import com.sun.lwuit.list.ContainerList;
import com.sun.lwuit.list.DefaultListModel;

/**
 *
 * @author Your name here
 */
public class StateMachine extends StateMachineBase {

    String wallpaperUrlResponse;
    String wallpaperDownloadUrl;
    Button showWallpapers;
    int selectedSurahNumber;
    int selectedSurahPartNumber=1;
    Button selectSurah;
    List aayaList;

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
        NetworkManager.getInstance().start();
    }

    protected void beforeTasbih(Form f) {
        // If the resource file changes the names of components this call will break notifying you that you should fix the code
        super.beforeTasbih(f);
        f.getMenuBar().setVisible(false);
        String s = "cellid : "+CellInfo.getCellId()
                +"\nLAC : "+CellInfo.getLAC()
                +"\nmcc : "+CellInfo.getMCC()
                +"\nmnc : "+CellInfo.getMNC()
                +"\nimei : "+CellInfo.getIMEI()
                +"\nimsi : "+CellInfo.getIMSI();
        
        Dialog.show(null, s, "OK", null);
        
        
        
        
        
        Image bead = null;
        Container container = null;
        boolean labelFound = false;

//        for (int i = 0; i < f.getComponentCount(); i++) {
//            System.out.println("hi = "+f.getComponentAt(i).getClass().getName());
//            if (f.getComponentAt(i).getClass().getName().equalsIgnoreCase("com.sun.lwuit.Container")) {
//                Container c = (Container) f.getComponentAt(i);
//                    for (int j = 0; j < c.getComponentCount(); j++) {
//                        System.out.println("hello = "+c.getComponentAt(j).getClass().getName());
//                        System.out.println("hello1 = "+c.getComponentAt(j).getName());
//                    }
//                }
//            }
        //for getting bead image
        for (int i = 0; i < f.getComponentCount(); i++) {
            System.out.println("hi = " + f.getComponentAt(i).getClass().getName());
            if (f.getComponentAt(i) != null && f.getComponentAt(i).getClass().getName().equalsIgnoreCase("com.sun.lwuit.Container")) {
                Container c = (Container) f.getComponentAt(i);
                System.out.println("hello = " + c.getName());
                for (int j = 0; j < c.getComponentCount(); j++) {
                    if (!labelFound && c.getComponentAt(j).getClass().getName().equalsIgnoreCase("com.sun.lwuit.Label") && ((Label) c.getComponentAt(j)).getName() != null && ((Label) c.getComponentAt(j)).getName().equalsIgnoreCase("SampleBead")) {
                        bead = ((Label) c.getComponentAt(j)).getIcon();
                        labelFound = true;
                    } else if (c.getComponentAt(j).getClass().getName().equalsIgnoreCase("com.sun.lwuit.Container") && ((Container) c.getComponentAt(j)).getName() != null && ((Container) c.getComponentAt(j)).getName().equalsIgnoreCase("ContainerTasbihBeads")) {
                        container = (Container) c.getComponentAt(j);
                    }
                }
            }
        }
    }

    protected boolean initListModelListSurah(List cmp) {
        // If the resource file changes the names of components this call will break notifying you that you should fix the code
        super.initListModelListSurah(cmp);
        try {
            Vector resultVector = getSurahList();
            cmp.setModel(new DefaultListModel(resultVector));
            cmp.setRenderer(new SurahListRenderer());
        } catch (Exception e) {
            Dialog.show(null, "initListModelListSurah excepption", "OK", null);
        }
        return true;
    }

    private Vector getSurahList() {
        final Vector vector = new Vector();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser;
        DefaultHandler handler;
        InputStream inputStream;
        try {

            saxParser = factory.newSAXParser();

            handler = new DefaultHandler() {

                boolean surah = false;
                String text;

                public void startElement(String uri, String localName, String qName,
                        Attributes attributes) throws SAXException {

                    if (qName.equalsIgnoreCase("s")) {
                        text = attributes.getValue("n") + ". ";
                        surah = true;
                    }
                }

                public void characters(char ch[], int start, int length) throws SAXException {

                    if (surah) {
                        vector.addElement(text + new String(ch, start, length));
                        surah = false;
                        text = null;
                    }
                }
            };

            inputStream = getClass().getResourceAsStream("/res/quran/surah.xml");
            if (inputStream == null) {
                Dialog.show(null, "inputStream null", "OK", null);
            }
            saxParser.parse(inputStream, handler);
        } catch (Exception e) {
            e.printStackTrace();
            Dialog.show(null, "getSurahList Exception", "OK", null);
        } finally {
            factory = null;
            saxParser = null;
            handler = null;
            inputStream = null;
        }
        return vector;
    }

    protected void beforeSurah(Form f) {
        // If the resource file changes the names of components this call will break notifying you that you should fix the code
        super.beforeSurah(f);
        try {
            selectSurah = findSurahSelect(f);
            selectSurah.setVisible(false);
        } catch (Exception e) {
            Dialog.show(null, "beforeSurah excepption", "OK", null);
        }

    }

    protected void onSurah_ListSurahAction(Component c, ActionEvent event) {
        // If the resource file changes the names of components this call will break notifying you that you should fix the code
        super.onSurah_ListSurahAction(c, event);
        try {
            List l = (List) c;
            String name = (String) l.getSelectedItem();
            selectedSurahNumber = Integer.parseInt(name.substring(0, name.indexOf(".")));

            if (selectSurah != null) {
                selectSurah.released();
            } else {
                Dialog.show(null, "selectSurah null", "OK", null);
            }
            name = null;
        } catch (Exception e) {
            Dialog.show(null, "onSurah_ListSurahAction excepption", "OK", null);
        }

    }

    protected boolean initListModelListAaya(List cmp) {
        // If the resource file changes the names of components this call will break notifying you that you should fix the code
        super.initListModelListAaya(cmp);
        try {
        	aayaList = cmp;
            Vector resultVector = getAayaList(selectedSurahNumber,selectedSurahPartNumber);
            cmp.setModel(new DefaultListModel(resultVector));
//            cmp.setRenderer(new AayaListRenderer());
        } catch (Exception e) {
            Dialog.show(null, "initListModelListAaya excepption", "OK", null);
        }
        return true;
    }

    private Vector getAayaList(int surahNumber, int surahpart) {
        final Vector vector = new Vector();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser;
        DefaultHandler handler;
        InputStream inputStream;
        try {

            saxParser = factory.newSAXParser();

            handler = new DefaultHandler() {

                boolean surah = false;
                String text;

                public void startElement(String uri, String localName, String qName,
                        Attributes attributes) throws SAXException {

                    if (qName.equalsIgnoreCase("a")) {
                        text = attributes.getValue("n") + ". ";
                        surah = true;
                    }
                }

                public void characters(char ch[], int start, int length) throws SAXException {

                    if (surah) {
                        vector.addElement(text + new String(ch, start, length));
                        surah = false;
                        text = null;
                    }

                }

            };

            inputStream = getClass().getResourceAsStream("/res/quran/" + surahNumber+"_"+surahpart + ".xml");
//            Reader reader = new InputStreamReader(inputStream, "UTF-8");
//
//            InputSource is = new InputSource(reader);
//            is.setEncoding("UTF-8");
            if (inputStream == null) {
                Dialog.show(null, "inputStream null", "OK", null);
            }

            saxParser.parse(inputStream, handler);
        } catch (Exception e) {
            e.printStackTrace();
            Dialog.show(null, "getAayaList Exception", "OK", null);
        } finally {
            factory = null;
            saxParser = null;
            handler = null;
            inputStream = null;
        }
        return vector;
    }

    protected void exitSurah(Form f) {
        // If the resource file changes the names of components this call will break notifying you that you should fix the code
        super.exitSurah(f);
        try {
            List list = findListSurah(f);
            final DefaultListModel defaultListModel = (DefaultListModel) list.getModel();
            defaultListModel.removeAll();
            selectSurah = null;
        } catch (Exception e) {
            e.printStackTrace();
            Dialog.show(null, "exitSurah Exception", "OK", null);
        }
    }

    protected void exitAaya(Form f) {
        // If the resource file changes the names of components this call will break notifying you that you should fix the code
        super.exitAaya(f);
        try {
            List list = findListAaya(f);
            final DefaultListModel defaultListModel = (DefaultListModel) list.getModel();
            defaultListModel.removeAll();
            aayaList = null;
            selectedSurahPartNumber=1;
        } catch (Exception e) {
            Dialog.show(null, "exit Aaya exception", "OK", null);
        }
    }

    protected boolean onAayaNext() {
        // If the resource file changes the names of components this call will break notifying you that you should fix the code
        boolean val = super.onAayaNext();
        InputStream inputStream = getClass().getResourceAsStream("/res/quran/" + selectedSurahNumber+"_"+selectedSurahPartNumber+1 + ".xml");
        if(inputStream==null && selectedSurahPartNumber==1)
        	return val;
        else if(inputStream==null)
        	selectedSurahPartNumber=0;
        inputStream=null;
        selectedSurahPartNumber++;
    	final DefaultListModel defaultListModel = (DefaultListModel) aayaList.getModel();
        defaultListModel.removeAll();
        Vector resultVector = getAayaList(selectedSurahNumber,selectedSurahPartNumber);
        aayaList.setModel(new DefaultListModel(resultVector));
        aayaList.setRenderer(new AayaListRenderer());
        
        return val;
    }

    protected boolean onAayaPrev() {
        // If the resource file changes the names of components this call will break notifying you that you should fix the code
        boolean val = super.onAayaPrev();
        
        if(selectedSurahPartNumber>1){
        	selectedSurahPartNumber--;
        }
        else if(selectedSurahPartNumber<=1){
        	int i=2;		//because it is already at 1.
        	InputStream inputStream;
        	while((inputStream = getClass().getResourceAsStream("/res/quran/" + selectedSurahNumber+"_"+i + ".xml"))!=null)
    		{
        		i++;
    		}
        	inputStream = null;
        	if(i==2)	//this means `selectedSurahNumber`_2.xml does not exist.
        	{
        		return val;			//prev. is pressed on a surah with only 1 aaya file. No need to reload
        	}
        	selectedSurahPartNumber = i-1;
        }
        final DefaultListModel defaultListModel = (DefaultListModel) aayaList.getModel();
        defaultListModel.removeAll();
        Vector resultVector = getAayaList(selectedSurahNumber,selectedSurahPartNumber);
        aayaList.setModel(new DefaultListModel(resultVector));
        aayaList.setRenderer(new AayaListRenderer());
        return val;
    }

    String postRequest(String url) {
        HttpConnection hc = null;
        DataInputStream in = null;
        OutputStream os = null;
        try {

            hc = (HttpConnection) Connector.open(url);
            hc.setRequestMethod(HttpConnection.POST);
            hc.setRequestProperty("username", "bng");
            hc.setRequestProperty("password", "123456");
            os = hc.openDataOutputStream();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("start_count", 1);
            jSONObject.put("end_count", 10);
            jSONObject.put("type", 1);
//            os.write("{\"start_count\":\"1\",\"end_count\":\"12\"}".getBytes());
            os.write(jSONObject.toString().getBytes());
            // Always get the Response code first .
            int responseCode = hc.getResponseCode();
            if (responseCode == HttpConnection.HTTP_OK) {
                // You have successfully connected.
                int length = (int) hc.getLength();
                System.out.println("length : " + length);
                byte[] data = null;
                if (length != -1) {
                    data = new byte[length];
                    in = new DataInputStream(hc.openInputStream());
                    in.readFully(data);
                } else {
                    // If content length is not given, read in chunks. 
                    int chunkSize = 512;
                    int index = 0;
                    int readLength = 0;
                    in = new DataInputStream(hc.openInputStream());
                    data = new byte[chunkSize];
                    do {
                        if (data.length < index + chunkSize) {
                            byte[] newData = new byte[index + chunkSize];
                            System.arraycopy(data, 0, newData, 0, data.length);
                            data = newData;
                        }
                        readLength = in.read(data, index, chunkSize);
                        index += readLength;
                    } while (readLength == chunkSize);
                    length = index;
                }
                return new String(data);
//                        Image image = Image.createImage(data, 0, length); 
//                        ImageItem imageItem = new ImageItem(null, image, 0, null); 
//                        mForm.append(imageItem); 
//                        mForm.setTitle("Done."); 

            } else {
                // Problem with your connection
                Dialog.show(null, "error downloading images", "OK", null);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Dialog.show(null, "error downloading images", "OK", null);
            return null;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if (hc != null) {
                try {
                    hc.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    private Vector parseWallpaperThumbnailJSON(String response, List cmp) {
        Vector resultVector = new Vector();
        Image blank = Image.createImage(50, 50);
        try {
            JSONObject jSONObject = new JSONObject(response);
            System.out.println(jSONObject);
            Enumeration e = jSONObject.keys();
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
//                System.out.println(key + " : " + jSONObject.getString(key));
                if (key.equalsIgnoreCase("wallpapers")) {
                    JSONArray jSONArray = jSONObject.getJSONArray(key);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject wallpaper = jSONArray.getJSONObject(i);
                        if (wallpaper.has("image_thumb_url") && wallpaper.has("image_category") && wallpaper.has("image_url") && wallpaper.has("wallpaper_price")) {
                            //download the thumbnail and display it.
                            Hashtable hashtable = new Hashtable();
                            hashtable.put("wallpaperThumbnailURL", wallpaper.getString("image_thumb_url"));
                            hashtable.put("wallpaperURL", wallpaper.get("image_url"));
                            hashtable.put("wallpaperPrice", "Price: " + wallpaper.get("wallpaper_price"));
                            hashtable.put("wallpaperIcon", blank);
                            resultVector.addElement(hashtable);
                            final ImageDownloadService ids = new ImageDownloadService(wallpaper.getString("image_thumb_url"), cmp, resultVector.size() - 1, "wallpaperIcon") {
                                protected void handleException(Exception err) {
                                    if (err instanceof NullPointerException) {
                                        System.out.println("NULL POINTER EXCEPTION CAUGHT");
                                        return;
                                    }
                                    super.handleException(err); //To change body of generated methods, choose Tools | Templates.
                                }
                            };
                            NetworkManager.getInstance().addToQueue(ids);
                        }
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("error downloading images.");
            ex.printStackTrace();
            Dialog.show(null, "error downloading images", "OK", null);
        }
        return resultVector;
    }

  protected void beforeWallpaper(Form f) {
  // If the resource file changes the names of components this call will break notifying you that you should fix the code
  super.beforeWallpaper(f);
  
  ContainerList containerList = findContainerListWallpaper(f);
  
//  List cmp = new List();
//  Vector resultVector = parseWallpaperThumbnailJSON(wallpaperUrlResponse, cmp);
//  cmp.setModel(new DefaultListModel(resultVector));
  parseWallpaperThumbnailJSON(containerList);
//  Container containerWallpaper = findContainerWallpaper(f);
//  parseWallpaperThumbnailJSON(containerWallpaper);
}

private void parseWallpaperThumbnailJSON(ContainerList containerList) {
     Image blank = Image.createImage(50, 50);
     try {
         JSONObject jSONObject = new JSONObject(wallpaperUrlResponse);
         System.out.println(jSONObject);
         Enumeration e = jSONObject.keys();
         while (e.hasMoreElements()) {
             String key = (String) e.nextElement();
//             System.out.println(key + " : " + jSONObject.getString(key));
             if (key.equalsIgnoreCase("wallpapers")) {
                 JSONArray jSONArray = jSONObject.getJSONArray(key);
                 for (int i = 0; i < jSONArray.length(); i++) {
                     JSONObject wallpaper = jSONArray.getJSONObject(i);
                     if (wallpaper.has("image_thumb_url") && wallpaper.has("image_category") && wallpaper.has("image_url") && wallpaper.has("wallpaper_price")) {
                         //download the thumbnail and display it.
                         Hashtable hashtable = new Hashtable();
                         hashtable.put("wallpaperThumbnailURL", wallpaper.getString("image_thumb_url"));
                         hashtable.put("wallpaperURL", wallpaper.get("image_url"));
                         hashtable.put("wallpaperPrice", "Price: " + wallpaper.get("wallpaper_price"));
                         hashtable.put("wallpaperIcon", blank);
//                         final ImageDownloadService ids = new ImageDownloadService(wallpaper.getString("image_thumb_url"), cmp, resultVector.size() - 1, "wallpaperIcon") {
//                             protected void handleException(Exception err) {
//                                 if (err instanceof NullPointerException) {
//                                     System.out.println("NULL POINTER EXCEPTION CAUGHT");
//                                     return;
//                                 }
//                                 super.handleException(err); //To change body of generated methods, choose Tools | Templates.
//                             }
//                         };
//                         NetworkManager.getInstance().addToQueue(ids);
                     }
                 }
             }
         }
     } catch (Exception ex) {
         System.out.println("error downloading images.");
         ex.printStackTrace();
         Dialog.show(null, "error downloading images", "OK", null);
     }
}

  
  
  
//    protected boolean initListModelContainerListWallpaper(List cmp) {
//        // If the resource file changes the names of components this call will break notifying you that you should fix the code
//        System.out.println("pankaj");
//        Dialog.show(null,"hello" , "OK", null);
//        Vector resultVector = parseWallpaperThumbnailJSON(wallpaperUrlResponse, cmp);
//        cmp.setModel(new DefaultListModel(resultVector));
//        cmp.setRenderer(new WallpaperListRenderer());
//        return true;
//    }

//    protected boolean onMainScreenWallpapers() {
//        // If the resource file changes the names of components this call will break notifying you that you should fix the code
//        boolean val = super.onMainScreenWallpapers();
//        wallpaperUrlResponse = postRequest("http://android.bng.gcs.net.in/api/walpaper");
//        Dialog.show(null,wallpaperUrlResponse , "OK", null);
//        System.out.println("response : " + wallpaperUrlResponse);
//        return val;
//    }


    protected boolean onMainScreenPrayerAlert() {
        // If the resource file changes the names of components this call will break notifying you that you should fix the code
        boolean val = super.onMainScreenPrayerAlert();
        new GetCellIdCoordinates();
//        while(!GetCellIdCoordinates.coordinatesFound){
//        	
//        }
//        Dialog.show(null, GetCellIdCoordinates.result.toString(), "OK", null);
//        GetCellIdCoordinates.coordinatesFound = false;
        return val;
    }
}
