//package userclasses.Network;
//
//import java.util.Calendar;
//import java.util.Vector;
//
//import userclasses.PrayerTime.PrayTime;
//
//import com.codename1.location.Location;
//import com.codename1.location.LocationManager;
//import com.codename1.ui.Dialog;
//
//public class GetCellIdCoordinates implements Runnable {
//
//	Calendar calendar = Calendar.getInstance();
//
//	LocationProvider provider;
//	Location location;
//	QualifiedCoordinates coordinates;
//	Thread t;
//	public static StringBuffer result = new StringBuffer();
//	public static boolean coordinatesFound = false;
//	public GetCellIdCoordinates(){
//		coordinatesFound = false;
//		t = new Thread(this);
//		t.start();
//	}
//
//	public void run() {
//		try {
//			// Specify the retrieval method to Online/Cell-ID
//			int[] methods = { (Location.MTA_ASSISTED | Location.MTE_CELLID
//					| Location.MTE_SHORTRANGE | Location.MTY_NETWORKBASED) };
//			// Retrieve the location provider
//			provider = LocationManager.getLocationManager().getLocationProvider(methods, null);
//			location = provider.getLocation(50000);
//			coordinates = location.getQualifiedCoordinates();
//			result.append("Latitude:" + coordinates.getLatitude() + "\n");
//			result.append("Longitude:" + coordinates.getLongitude()+"\n");
//			result.append(calendar.getTimeZone().getID()+"\n");
//			result.append(calendar.getTimeZone().getRawOffset()/(1000*60*60f)+"\n");
//			PrayTime prayTime = new PrayTime();
//			prayTime.setTimeFormat(1);
//			prayTime.setCalcMethod(Integer.valueOf(1+""));
//			Vector prayerTimes = prayTime.getPrayerTimes(Calendar.getInstance(), coordinates.getLatitude(), coordinates.getLongitude(), calendar.getTimeZone().getRawOffset()/(1000*60*60f));
//			prayerTimes.removeElementAt(1);
//			prayerTimes.removeElementAt(prayerTimes.size()-2);
//			for(int i=0;i<prayerTimes.size();i++)
//			{
//				result.append(prayerTimes.elementAt(i)+"\n");
//			}
//			result.append(System.getProperty("com.nokia.mid.countrycode")+"\n");
//			result.append(System.getProperty("com.nokia.mid.networkid")+"\n");
//			Dialog.show(null, GetCellIdCoordinates.result.toString(), "OK", null);
//			coordinatesFound = true;
//		} catch (NoClassDefFoundError ex) {
//			result.append("Cell-ID retrieval not supported on this device");
//			coordinatesFound = true;
//		} catch (InterruptedException e) {
//			result.append("Location retrieval was interrupted");
//			coordinatesFound = true;
//		} catch (LocationException x) {
//			result.append("Location could not be retreived");
//			coordinatesFound = true;
//		}
//
//	}
//	
//	public long getTime(String time,int addflag)
//	{
//	  String hour=time.substring(0, time.indexOf(":"));
//	  String min=time.substring(time.indexOf(":")+1);
//	  Calendar alarm = Calendar.getInstance();
//	  alarm.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hour));
//	  alarm.set(Calendar.MINUTE, Integer.parseInt(min));
//	  if(addflag==1) alarm.set(Calendar.DATE, alarm.get(Calendar.DATE)+1);
//	  return alarm.getTime().getTime();
//	}
//	
//	
//}