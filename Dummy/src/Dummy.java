import java.util.Calendar;
import java.util.Vector;

import userclasses.PrayerTime.PrayTime;


public class Dummy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrayTime prayTime = new PrayTime();
		prayTime.setTimeFormat(1);
		prayTime.setCalcMethod(1);
		Vector prayerTimes = prayTime.getPrayerTimes(Calendar.getInstance(), 28.500845208764076, 77.0817395020276, 5.5);
		prayerTimes.removeElementAt(1);
		prayerTimes.removeElementAt(prayerTimes.size()-2);
		for(int i=0;i<prayerTimes.size();i++)
		{
			System.out.println(prayerTimes.elementAt(i));
		}
	}

}

