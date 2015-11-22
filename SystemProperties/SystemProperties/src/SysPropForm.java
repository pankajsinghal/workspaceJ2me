/* This file was created by Nokia Developer's Suite for J2ME(TM) */

import javax.microedition.lcdui.*;
import javax.bluetooth.LocalDevice;
import javax.microedition.m3g.Graphics3D;
import java.util.Hashtable;

public class SysPropForm extends Form implements CommandListener {
private Command backCommand;
private Command exitCommand;
private SystemProperties midlet;
private String[] items;

    public SysPropForm(String title, SystemProperties midlet, String[] list) {
        super(title);
        items = list;
        this.midlet = midlet;
        backCommand = new Command("Back", Command.BACK, 1);
        exitCommand = new Command("Exit", Command.EXIT, 1);
        addCommand(backCommand);
        addCommand(exitCommand);
        setCommandListener(this);
    }

    protected void update(String title, String[] list) {
        this.setTitle(title);
        items = list;
        this.deleteAll();
        for (int i = 0; i < items.length; i++) {
            append(items[i] + ":\n");
            if (midlet.bt) {
                append(LocalDevice.getProperty(items[i]) + "\n");
            }
            else if (midlet.m3g) {
                // Properties "maxViewportWidth" and "maxViewportHeight" were 
                // added in M3G 1.1, in case of M3G 1.0 this MIDlet returns 
                // "null" for these properties.
                // Property "m3gRelease" is not mandated by the specification, but
                // it is a implementation specific property.
                Hashtable g3dtable = new Hashtable();
                g3dtable = Graphics3D.getProperties();
                Object property = g3dtable.get(list[i]);
                if (property != null) append(property.toString() + "\n");
                else append("null\n");
            }            
            else append(System.getProperty(items[i]) + "\n");
        }  
    }

    public void commandAction(Command c, Displayable d) {
        if (c == backCommand) {
            midlet.showList();
            midlet.bt = false;
            midlet.m3g = false;            
        }
        if (c == exitCommand) {
            midlet.quitApp();
        }
    }
}
