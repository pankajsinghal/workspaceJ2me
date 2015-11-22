/* This file was created by Nokia Developer's Suite for J2ME(TM) */

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class SystemProperties extends MIDlet implements CommandListener {
    private static final String[] SYSPROPLISTS = {
        "CLDC&MIDP", "Optional packages", "MMAPI (JSR-135)", "Bluetooth API (JSR-82)", "FileConnection API (JSR-75)", 
        "WMA (JSR-120/205)", "SATSA API (JSR-177)", "Web Services API (JSR-172)", "AMMS API (JSR-234)", 
        "Scalable 2D Vector Graphics API (JSR-226)", "Mobile 3D Graphics API (JSR-184)", "S60 3rd Ed. FP2 system properties", "Other"
    };
    private static final String[] CLDC_MIDPPROPS = {
        "microedition.profiles", "microedition.configuration", "microedition.locale", "microedition.platform", 
        "microedition.encoding", "microedition.commports", "microedition.hostname", "microedition.jtwi.version", 
        "microedition.msa.version"
    };
    private static final String[] OPT_SYSPROPS = {
        "microedition.media.version", "microedition.pim.version", "microedition.m3g.version", "microedition.location.version", 
        "bluetooth.api.version", "microedition.io.file.FileConnection.version", "microedition.global.version", 
        "microedition.chapi.version", "microedition.sip.version", "wireless.messaging.version", "microedition.amms.version",
        "microedition.m2g.version", "microedition.payment.version", "microedition.contactless.version", "microedition.sensor.version", 
        "obex.api.version"
    };
    private static final String[] MMAPI_SYSPROPS = {
        "supports.mixing", "supports.audio.capture", "supports.video.capture", "supports.recording", "audio.encodings", 
        "video.encodings", "video.snapshot.encodings", "streamable.contents"
    };
    private static final String[] BT_SYSPROPS = {
        "bluetooth.l2cap.receiveMTU.max", "bluetooth.connected.devices.max", "bluetooth.connected.inquiry", 
        "bluetooth.connected.page", "bluetooth.connected.inquiry.scan", "bluetooth.connected.page.scan", 
        "bluetooth.master.switch", "bluetooth.sd.trans.max", "bluetooth.sd.attr.retrievable.max"
    };
    private static final String[] FILE_API_SYSPROPS = { 
        "fileconn.dir.photos", "fileconn.dir.videos", "fileconn.dir.graphics", "fileconn.dir.tones", 
        "fileconn.dir.music", "fileconn.dir.recordings", "fileconn.dir.memorycard", "fileconn.dir.private", 
        "fileconn.dir.photos.name", "fileconn.dir.videos.name", "fileconn.dir.graphics.name", "fileconn.dir.tones.name",
        "fileconn.dir.music.name", "fileconn.dir.recordings.name", "fileconn.dir.memorycard.name", 
        "fileconn.dir.private.name", "fileconn.dir.roots.names", "file.separator"
    };
    private static final String[] WMA_SYSPROPS = {
        "wireless.messaging.sms.smsc", "wireless.messaging.mms.mmsc"
    };
    private static final String[] SATSA_SYSPROPS = {
        "microedition.satsa.crypto.version", "microedition.satsa.apdu.version", "microedition.satsa.pki.version",
        "microedition.smartcardslots"
    };
    private static final String[] WEB_SERVICES_SYSPROPS = {
        "xml.jaxp.subset.version", "xml.rpc.subset.version"
    };
    private static final String[] AMMS_SYSPROPS = {
        "tuner.modulations", "audio.samplerates", "audio3d.simultaneouslocations", "camera.orientations",
        "camera.resolutions", "supports.mediacapabilities"
    };
    private static final String[] M2G_SYSPROPS = {
        "microedition.m2g.svg.baseProfile", "microedition.m2g.svg.version"
    };
    private static final String[] M3G_SYSPROPS = {
        "supportAntialiasing", "supportTrueColor", "supportDithering", "supportMipmapping", 
        "supportPerspectiveCorrection", "supportLocalCameraLighting", "maxLights", 
        "maxViewportWidth", "maxViewportHeight", "maxViewportDimension", "maxTextureDimension", 
        "m3gRelease", "maxSpriteCropDimension", "numTextureUnits", "maxTransformsPerVertex"
    };     
    private static final String[] S60_3RD_FP2_SYSPROPS = {
        // These system properties are Nokia proprietary system properties supported
        // by S60 3rd Edition Feature Pack 2 (and newer S60) devices. Note, that the access to 
        // com.nokia.mid.imsi system property is limited with com.nokia.mid.mobinfo.IMSI permission.
        // By default this permission is available only in manufacturer and operator domain. 
        "com.nokia.mid.imei", "com.nokia.mid.imsi", "com.nokia.mid.networkid", "com.nokia.mid.networksignal",
        "com.nokia.mid.networkavailability", "com.nokia.mid.batterylevel", "com.nokia.mid.countrycode",
        "com.nokia.mid.dateformat", "com.nokia.mid.timeformat"
    };
    private static final String[] OTHER_SYSPROPS = {
        "com.nokia.mid.dateformat", "com.nokia.mid.timeformat", "com.nokia.network.access", "com.nokia.mid.imei",
        "com.nokia.memoryramfree"
    };
    private List list;
    private SysPropForm form;
    private Command exitCommand;
    private Command memCommand;    
    protected boolean bt = false;
    protected boolean m3g = false;    

    public SystemProperties() {
        list = new List("System properties", List.IMPLICIT, SYSPROPLISTS, null);
        form = new SysPropForm(SYSPROPLISTS[0], this, CLDC_MIDPPROPS);
        exitCommand = new Command("Exit", Command.EXIT, 1);
        memCommand = new Command("Memory status", Command.SCREEN, 1);
        list.addCommand(memCommand);        
        list.addCommand(exitCommand);
        list.setCommandListener(this);
        Display.getDisplay(this).setCurrent(list);
    }

    protected void startApp() throws MIDletStateChangeException {
    }

    protected void pauseApp() {
    }

    protected void destroyApp(boolean p1) {
    }

    public void commandAction(Command c, Displayable d) {
        if (c == List.SELECT_COMMAND) {
            int index = list.getSelectedIndex();
            if (index == 0) {
                form.update(SYSPROPLISTS[0], CLDC_MIDPPROPS);
            }
            if (index == 1) {
                form.update(SYSPROPLISTS[1], OPT_SYSPROPS);
            }
            if (index == 2) {
                form.update(SYSPROPLISTS[2], MMAPI_SYSPROPS);
            }
            if (index == 3) {
                bt = true;
                form.update(SYSPROPLISTS[3], BT_SYSPROPS);
            }
            if (index == 4) {
                form.update(SYSPROPLISTS[4], FILE_API_SYSPROPS);
            }
            if (index == 5) {
                form.update(SYSPROPLISTS[5], WMA_SYSPROPS);
            }
            if (index == 6) {
                form.update(SYSPROPLISTS[6], SATSA_SYSPROPS);
            }
            if (index == 7) {
                form.update(SYSPROPLISTS[7], WEB_SERVICES_SYSPROPS);
            }
            if (index == 8) {
                form.update(SYSPROPLISTS[8], AMMS_SYSPROPS);
            }
            if (index == 9) {
                form.update(SYSPROPLISTS[9], M2G_SYSPROPS);
            }
            if (index == 10) {
                m3g = true;
                form.update(SYSPROPLISTS[10], M3G_SYSPROPS);
            }
            if (index == 11) {
                form.update(SYSPROPLISTS[11], S60_3RD_FP2_SYSPROPS);
            }
            if (index == 12) {
                form.update(SYSPROPLISTS[12], OTHER_SYSPROPS);
            }
            Display.getDisplay(this).setCurrent(form);
        }
        if (c == memCommand) {
            showMemory();
        }        
        if (c == exitCommand) {
            quitApp();
        }
    }

    public void quitApp() {
        destroyApp(true);
        notifyDestroyed();
    }
    
    protected void showList() {
        Display.getDisplay(this).setCurrent(list);
    }
    
    private void showMemory() {
        Alert alert = new Alert("Memory status");
        String freemem = "" + Runtime.getRuntime().freeMemory();
        String totalmem = "" + Runtime.getRuntime().totalMemory();
        alert.setString("Free/Total mem: " + freemem + "/" + totalmem);
        alert.setTimeout(Alert.FOREVER);
        Display.getDisplay(this).setCurrent(alert, list);
    }    
}
