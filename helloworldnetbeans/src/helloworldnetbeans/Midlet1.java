/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworldnetbeans;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.TextBox;
import javax.microedition.lcdui.TextField;
import javax.microedition.lcdui.Ticker;
import javax.microedition.midlet.*;

/**
 * @author Pankaj
 */
public class Midlet1 extends MIDlet implements CommandListener {

    private Command exitCommand = new Command("exit", Command.EXIT, 1);
    private Command navCommand = new Command("go", Command.SCREEN, 1);
    private Command backCommand = new Command("back", Command.BACK, 1);
    
    Form form;
    
    private Display display;
    TextBox t;

    public Midlet1() {
        display = Display.getDisplay(this);
    }

    public void startApp() {
        t = new TextBox("Hello", "Welcome to MIDP Programming", 256, 0);
        t.addCommand(exitCommand);
        t.addCommand(navCommand);
        t.setCommandListener(this);
        display.setCurrent(t);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable s) {
        if (c == exitCommand) {
            destroyApp(false);
            notifyDestroyed();
        }
        if(c==navCommand){
            form = new Form("pankaj");
            display.setCurrent(form);
            TextBox box = new TextBox("sin", "sin", 20, TextField.ANY);
            form.addCommand(backCommand);
            form.setCommandListener(this);
        }
        if(c==backCommand){
            display.setCurrent(t);
        }
    }
}
