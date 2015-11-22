package com.bng.coordinates;

import javax.microedition.location.Location;
import javax.microedition.location.LocationException;
import javax.microedition.location.LocationProvider;
import javax.microedition.location.QualifiedCoordinates;

import com.nokia.mid.location.LocationUtil;

public class a {

	public static double[] a() {
		double[] cor = new double[2];
		cor[0] = 0;
		cor[1] = 0;
		try {
			LocationProvider provider;
			Location location;
			QualifiedCoordinates coordinates;

			// Specify the retrieval method to Online/Cell-ID
			int[] methods = { (Location.MTA_ASSISTED | Location.MTE_CELLID
					| Location.MTE_SHORTRANGE | Location.MTY_NETWORKBASED) };
			// Retrieve the location provider
			System.out.println(1);
			provider = LocationUtil.getLocationProvider(methods, null);
			System.out.println(2);
			location = provider.getLocation(50000);
			System.out.println(3);
			coordinates = location.getQualifiedCoordinates();
			System.out.println(4);
			cor[0] = coordinates.getLatitude();
			System.out.println(5);
			cor[1] = coordinates.getLongitude();
			System.out.println(6);
		} catch (NoClassDefFoundError ex) {
			System.out
					.println("Cell-ID retrieval not supported on this device");
		} catch (InterruptedException e) {
			System.out.println("Location retrieval was interrupted");
		} catch (LocationException x) {
			System.out.println("Location could not be retreived");
		}

		return cor;
	}

}
