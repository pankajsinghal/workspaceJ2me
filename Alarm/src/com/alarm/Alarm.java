package com.alarm;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.io.PushRegistry;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.DateField;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.ItemStateListener;
import javax.microedition.midlet.MIDlet;
 
 
 
public class Alarm extends MIDlet implements ItemStateListener,
        CommandListener {
    private Display display; // Reference to display object
    private Form fmMain; // The main form
    private Command cmAlarm; // Start the timer
    private Command cmReset; // Reset to current date/time
    private Command cmExit; // Exit the MIDlet
    private DateField dfAlarmTime; // How long to sleep
    private int dateIndex; // Index of the DateField on the Form
    private Date currentTime; // Current time...changes when pressing reset
    private Timer tm; // The timer - keeps track of system time
    private AlarmTimer tt; // The task
    private boolean dateOK = false; // Was the user input valid?
 
    public Alarm() {
        display = Display.getDisplay(this);
 
// The main form
        fmMain = new Form("When to sound the alarm:");
 
// Save today's date
        currentTime = new Date();
 
// DateField with todays date as a default
        dfAlarmTime = new DateField("", DateField.DATE_TIME);
        dfAlarmTime.setDate(currentTime);
 
// All the commands/buttons
        cmAlarm = new Command("Sleep", Command.SCREEN, 1);
        cmReset = new Command("Reset", Command.SCREEN, 1);
        cmExit = new Command("Exit", Command.EXIT, 1);
 
// Add to form and listen for events
        dateIndex = fmMain.append(dfAlarmTime);
        fmMain.addCommand(cmAlarm);
        fmMain.addCommand(cmReset);
        fmMain.addCommand(cmExit);
        fmMain.setCommandListener(this);
        fmMain.setItemStateListener(this);
    }
 
    public void startApp() {
        display.setCurrent(fmMain);
    }
 
    public void pauseApp() {
    }
 
    public void destroyApp(boolean unconditional) {
//    	try {
//			PushRegistry.registerAlarm(Alarm.class.getName(), System.currentTimeMillis()+10000);
//		} catch (ConnectionNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    }
 
    public void itemStateChanged(Item item) {
        if (item == dfAlarmTime) {
// If the user selected date and/or time that is earlier
// than today, set a flag. We are using getTime()
// method of the Date class, which returns the # of
// milliseconds since January 1, 1970
            if (dfAlarmTime.getDate().getTime() < currentTime.getTime())
                dateOK = false;
            else
                dateOK = true;
        }
    }
 
    public void commandAction(Command c, Displayable s) {
        if (c == cmAlarm) {
        	try {
				PushRegistry.registerAlarm(Alarm.class.getName(), System.currentTimeMillis()+10000);
			} catch (ConnectionNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	
//            if (dateOK == false) {
//                Alert al = new Alert("Unable to set alarm",
//                        "Please choose another date and time.", null, null);
//                al.setTimeout(Alert.FOREVER);
//                al.setType(AlertType.ERROR);
//                display.setCurrent(al);
//            } else {
//// Create a new timer
//                tm = new Timer();
//                tt = new AlarmTimer();
// 
//// Amount of time to delay
//                long amount = dfAlarmTime.getDate().getTime() -
//                        currentTime.getTime();
//                tm.schedule(tt,amount);
// 
//// Remove the commands
//                fmMain.removeCommand(cmAlarm);
//                fmMain.removeCommand(cmReset);
// 
//// Remove the DateField
//                fmMain.delete(dateIndex);
// 
//// Change the Form message
//                fmMain.setTitle("Sleeping...");
//            }
        } else if (c == cmReset) {
// Reset to the current date/time
            dfAlarmTime.setDate(currentTime = new Date());
        } else if (c == cmExit) {
            destroyApp(false);
            notifyDestroyed();
        }
    }
 
// Handle the timer task
    private class AlarmTimer extends TimerTask {
        public final void run() {
            Alert al = new Alert("Time to wake up!");
            al.setTimeout(Alert.FOREVER);
            al.setType(AlertType.ALARM);
            AlertType.ERROR.playSound(display);
            display.setCurrent(al);
            
// Cancel this timer task
            cancel();
        }
    }
}