/**
 * Your application code goes here
 */

package userclasses;

import generated.StateMachineBase;

import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.util.Resources;

/**
 * 
 * @author Your name here
 */
public class StateMachine extends StateMachineBase {

	public StateMachine(String resFile) {
		super(resFile);
		// do not modify, write code in initVars and initialize class members
		// there,
		// the constructor might be invoked too late due to race conditions that
		// might occur
	}

	/**
	 * this method should be used to initialize variables instead of the
	 * constructor/class scope to avoid race conditions
	 */
	protected void initVars(Resources res) {
	}

	@Override
	protected boolean initListModelContainerList(
			com.codename1.ui.list.ContainerList cmp) {
		System.out.println("pankaj");
		cmp.setLayout(new GridLayout(2, 2));
		cmp.setModel(new com.codename1.ui.list.DefaultListModel(
				new String[] {
						"Item 1", "Item 2",
						"Item 3", "Item 4",
						"Item 5", "Item 6", 
						"Item 7", "Item 8", 
						"Item 9", "Item 10",
						"Item 11", "Item 12",
						"Item 13", "Item 14",
						"Item 15", "Item 16", 
						"Item 17", "Item 18", 
						"Item 19", "Item 20"}));
//		cmp.refreshTheme();
//		cmp.revalidate();
		return true;
	}

	@Override
	protected void beforeMain(Form f) {	
//		try {
			TextArea area = findTextArea(f);
//			
//			try {
//				LocationManager.getLocationManager().getCurrentLocation();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			int[] methods = { (Location.MTA_ASSISTED | Location.MTE_CELLID
//					| Location.MTE_SHORTRANGE | Location.MTY_NETWORKBASED) };
//			// Retrieve the location provider
//			provider = LocationUtil.getLocationProvider(methods, null);
//			
//			Dialog.show(null, "1", "OK", null);
//			location = provider.getLocation(50000);
//			Dialog.show(null, "2", "OK", null);
//			coordinates = location.getQualifiedCoordinates();
//			Dialog.show(null, "3", "OK", null);
//			area.setText(coordinates.getLatitude() + "\n"
//					+ coordinates.getLongitude());
//			Dialog.show(null, "4", "OK", null);
//		} catch (SecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (LocationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
