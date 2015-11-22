
import com.nokia.mid.location.LocationUtil;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;
import javax.microedition.lcdui.Form;
import javax.microedition.location.LocationProvider;
import javax.microedition.location.Location;
import javax.microedition.location.LocationException;
import javax.microedition.location.QualifiedCoordinates;

public class GetCellIdCoordinates extends MIDlet implements Runnable, CommandListener
{	
        LocationProvider provider;
        Location location;
        QualifiedCoordinates coordinates;
        Thread t;
        Form f;
        Display display;
        Command exitCommand=new Command("Exit", Command.EXIT,0);
    protected void startApp() throws MIDletStateChangeException  
    {
        display = Display.getDisplay(this);        
        f=new Form("Current Location!");
        f.append("Getting current location by using Cell ID...");
        f.addCommand(exitCommand);
        f.setCommandListener(this);
        display.setCurrent(f);       
        t=new Thread(this);
        t.start();
    }

    protected void destroyApp(boolean unconditional)
                    throws MIDletStateChangeException {
    }
    
    protected void pauseApp() {
    }

    public void run() 
    {
        int[] methods = {(Location.MTA_ASSISTED | Location.MTE_CELLID | Location.MTE_SHORTRANGE | Location.MTY_NETWORKBASED)};
        try {
            // Retrieve the location provider
            provider = LocationUtil.getLocationProvider(methods, null);
            location=provider.getLocation(50000);
            coordinates=location.getQualifiedCoordinates();
            f.deleteAll();
            f.append("Latitude:"+coordinates.getLatitude()+"\n");
            f.append("Longitude:"+coordinates.getLongitude());
        } catch (Exception ex) 
        {
            f.deleteAll();
            f.append("Location could not be retreived");
        
        }

    }

    public void commandAction(Command c, Displayable d) {
        if(c==exitCommand)
        {            
            try {
                destroyApp(false);
                notifyDestroyed();
                } 
            catch (MIDletStateChangeException ex) {
            }
        }
    }
}