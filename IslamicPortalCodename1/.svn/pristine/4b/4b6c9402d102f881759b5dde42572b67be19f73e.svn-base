/**
 * This class contains generated code from the Codename One Designer, DO NOT MODIFY!
 * This class is designed for subclassing that way the code generator can overwrite it
 * anytime without erasing your changes which should exist in a subclass!
 * For details about this file and how it works please read this blog post:
 * http://codenameone.blogspot.com/2010/10/ui-builder-class-how-to-actually-use.html
*/
package generated;

import com.codename1.ui.*;
import com.codename1.ui.util.*;
import com.codename1.ui.plaf.*;
import java.util.Hashtable;
import com.codename1.ui.events.*;

public abstract class StateMachineBase extends UIBuilder {
    private Container aboutToShowThisContainer;
    /**
     * this method should be used to initialize variables instead of
     * the constructor/class scope to avoid race conditions
     */
    /**
    * @deprecated use the version that accepts a resource as an argument instead
    
**/
    protected void initVars() {}

    protected void initVars(Resources res) {}

    public StateMachineBase(Resources res, String resPath, boolean loadTheme) {
        startApp(res, resPath, loadTheme);
    }

    public Container startApp(Resources res, String resPath, boolean loadTheme) {
        initVars();
        UIBuilder.registerCustomComponent("Button", com.codename1.ui.Button.class);
        UIBuilder.registerCustomComponent("Form", com.codename1.ui.Form.class);
        UIBuilder.registerCustomComponent("Label", com.codename1.ui.Label.class);
        UIBuilder.registerCustomComponent("List", com.codename1.ui.List.class);
        UIBuilder.registerCustomComponent("Container", com.codename1.ui.Container.class);
        UIBuilder.registerCustomComponent("ContainerList", com.codename1.ui.list.ContainerList.class);
        if(loadTheme) {
            if(res == null) {
                try {
                    if(resPath.endsWith(".res")) {
                        res = Resources.open(resPath);
                        System.out.println("Warning: you should construct the state machine without the .res extension to allow theme overlays");
                    } else {
                        res = Resources.openLayered(resPath);
                    }
                } catch(java.io.IOException err) { err.printStackTrace(); }
            }
            initTheme(res);
        }
        if(res != null) {
            setResourceFilePath(resPath);
            setResourceFile(res);
            initVars(res);
            return showForm(getFirstFormName(), null);
        } else {
            Form f = (Form)createContainer(resPath, getFirstFormName());
            initVars(fetchResourceFile());
            beforeShow(f);
            f.show();
            postShow(f);
            return f;
        }
    }

    protected String getFirstFormName() {
        return "splash";
    }

    public Container createWidget(Resources res, String resPath, boolean loadTheme) {
        initVars();
        UIBuilder.registerCustomComponent("Button", com.codename1.ui.Button.class);
        UIBuilder.registerCustomComponent("Form", com.codename1.ui.Form.class);
        UIBuilder.registerCustomComponent("Label", com.codename1.ui.Label.class);
        UIBuilder.registerCustomComponent("List", com.codename1.ui.List.class);
        UIBuilder.registerCustomComponent("Container", com.codename1.ui.Container.class);
        UIBuilder.registerCustomComponent("ContainerList", com.codename1.ui.list.ContainerList.class);
        if(loadTheme) {
            if(res == null) {
                try {
                    res = Resources.openLayered(resPath);
                } catch(java.io.IOException err) { err.printStackTrace(); }
            }
            initTheme(res);
        }
        return createContainer(resPath, "splash");
    }

    protected void initTheme(Resources res) {
            String[] themes = res.getThemeResourceNames();
            if(themes != null && themes.length > 0) {
                UIManager.getInstance().setThemeProps(res.getTheme(themes[0]));
            }
    }

    public StateMachineBase() {
    }

    public StateMachineBase(String resPath) {
        this(null, resPath, true);
    }

    public StateMachineBase(Resources res) {
        this(res, null, true);
    }

    public StateMachineBase(String resPath, boolean loadTheme) {
        this(null, resPath, loadTheme);
    }

    public StateMachineBase(Resources res, boolean loadTheme) {
        this(res, null, loadTheme);
    }

    public com.codename1.ui.Container findContainerRestInside(Component root) {
        return (com.codename1.ui.Container)findByName("ContainerRestInside", root);
    }

    public com.codename1.ui.Container findContainerRestInside() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("ContainerRestInside", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("ContainerRestInside", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findSurahSelect(Component root) {
        return (com.codename1.ui.Button)findByName("SurahSelect", root);
    }

    public com.codename1.ui.Button findSurahSelect() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("SurahSelect", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("SurahSelect", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findTasbihResetButton(Component root) {
        return (com.codename1.ui.Button)findByName("TasbihResetButton", root);
    }

    public com.codename1.ui.Button findTasbihResetButton() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("TasbihResetButton", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("TasbihResetButton", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer2(Component root) {
        return (com.codename1.ui.Container)findByName("Container2", root);
    }

    public com.codename1.ui.Container findContainer2() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container2", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container2", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer1(Component root) {
        return (com.codename1.ui.Container)findByName("Container1", root);
    }

    public com.codename1.ui.Container findContainer1() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findSurahName(Component root) {
        return (com.codename1.ui.Label)findByName("SurahName", root);
    }

    public com.codename1.ui.Label findSurahName() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("SurahName", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("SurahName", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findButton3(Component root) {
        return (com.codename1.ui.Button)findByName("Button3", root);
    }

    public com.codename1.ui.Button findButton3() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("Button3", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("Button3", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findButton2(Component root) {
        return (com.codename1.ui.Button)findByName("Button2", root);
    }

    public com.codename1.ui.Button findButton2() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("Button2", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("Button2", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabelSurahBoard(Component root) {
        return (com.codename1.ui.Label)findByName("LabelSurahBoard", root);
    }

    public com.codename1.ui.Label findLabelSurahBoard() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("LabelSurahBoard", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("LabelSurahBoard", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabelPlay(Component root) {
        return (com.codename1.ui.Label)findByName("labelPlay", root);
    }

    public com.codename1.ui.Label findLabelPlay() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("labelPlay", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("labelPlay", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findButtonPlay(Component root) {
        return (com.codename1.ui.Button)findByName("ButtonPlay", root);
    }

    public com.codename1.ui.Button findButtonPlay() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("ButtonPlay", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("ButtonPlay", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findTasbihSideBoard(Component root) {
        return (com.codename1.ui.Label)findByName("TasbihSideBoard", root);
    }

    public com.codename1.ui.Label findTasbihSideBoard() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("TasbihSideBoard", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("TasbihSideBoard", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findTasbihResetLabel(Component root) {
        return (com.codename1.ui.Label)findByName("TasbihResetLabel", root);
    }

    public com.codename1.ui.Label findTasbihResetLabel() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("TasbihResetLabel", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("TasbihResetLabel", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findButtonShowWallpaper(Component root) {
        return (com.codename1.ui.Button)findByName("ButtonShowWallpaper", root);
    }

    public com.codename1.ui.Button findButtonShowWallpaper() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("ButtonShowWallpaper", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("ButtonShowWallpaper", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findButton(Component root) {
        return (com.codename1.ui.Button)findByName("Button", root);
    }

    public com.codename1.ui.Button findButton() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("Button", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("Button", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findListAayaBG(Component root) {
        return (com.codename1.ui.Label)findByName("ListAayaBG", root);
    }

    public com.codename1.ui.Label findListAayaBG() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("ListAayaBG", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("ListAayaBG", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel1(Component root) {
        return (com.codename1.ui.Label)findByName("Label1", root);
    }

    public com.codename1.ui.Label findLabel1() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findImage(Component root) {
        return (com.codename1.ui.Label)findByName("Image", root);
    }

    public com.codename1.ui.Label findImage() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Image", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Image", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.List findListAaya(Component root) {
        return (com.codename1.ui.List)findByName("ListAaya", root);
    }

    public com.codename1.ui.List findListAaya() {
        com.codename1.ui.List cmp = (com.codename1.ui.List)findByName("ListAaya", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.List)findByName("ListAaya", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.list.ContainerList findContainerList(Component root) {
        return (com.codename1.ui.list.ContainerList)findByName("ContainerList", root);
    }

    public com.codename1.ui.list.ContainerList findContainerList() {
        com.codename1.ui.list.ContainerList cmp = (com.codename1.ui.list.ContainerList)findByName("ContainerList", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.list.ContainerList)findByName("ContainerList", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer(Component root) {
        return (com.codename1.ui.Container)findByName("Container", root);
    }

    public com.codename1.ui.Container findContainer() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainerRest(Component root) {
        return (com.codename1.ui.Container)findByName("ContainerRest", root);
    }

    public com.codename1.ui.Container findContainerRest() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("ContainerRest", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("ContainerRest", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainerSideBoard(Component root) {
        return (com.codename1.ui.Container)findByName("ContainerSideBoard", root);
    }

    public com.codename1.ui.Container findContainerSideBoard() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("ContainerSideBoard", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("ContainerSideBoard", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.List findListSurah(Component root) {
        return (com.codename1.ui.List)findByName("ListSurah", root);
    }

    public com.codename1.ui.List findListSurah() {
        com.codename1.ui.List cmp = (com.codename1.ui.List)findByName("ListSurah", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.List)findByName("ListSurah", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findListSurahBG(Component root) {
        return (com.codename1.ui.Label)findByName("ListSurahBG", root);
    }

    public com.codename1.ui.Label findListSurahBG() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("ListSurahBG", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("ListSurahBG", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findWallpaperRenderer(Component root) {
        return (com.codename1.ui.Container)findByName("wallpaperRenderer", root);
    }

    public com.codename1.ui.Container findWallpaperRenderer() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("wallpaperRenderer", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("wallpaperRenderer", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findWallpaperIcon(Component root) {
        return (com.codename1.ui.Label)findByName("wallpaperIcon", root);
    }

    public com.codename1.ui.Label findWallpaperIcon() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("wallpaperIcon", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("wallpaperIcon", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findSurahRenderer(Component root) {
        return (com.codename1.ui.Container)findByName("surahRenderer", root);
    }

    public com.codename1.ui.Container findSurahRenderer() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("surahRenderer", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("surahRenderer", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabelSurahBoardText(Component root) {
        return (com.codename1.ui.Label)findByName("LabelSurahBoardText", root);
    }

    public com.codename1.ui.Label findLabelSurahBoardText() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("LabelSurahBoardText", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("LabelSurahBoardText", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel(Component root) {
        return (com.codename1.ui.Label)findByName("Label", root);
    }

    public com.codename1.ui.Label findLabel() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findButton1(Component root) {
        return (com.codename1.ui.Button)findByName("Button1", root);
    }

    public com.codename1.ui.Button findButton1() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("Button1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("Button1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public static final int COMMAND_PrayerAlertStored = 11;
    public static final int COMMAND_AayaPrev = 7;
    public static final int COMMAND_MainScreenQuranKarim = 3;
    public static final int COMMAND_AayaNext = 6;
    public static final int COMMAND_SurahCommand4 = 4;
    public static final int COMMAND_WallpaperCommand10 = 10;
    public static final int COMMAND_MainScreenPrayerAlert = 9;
    public static final int COMMAND_MainScreenWallpapers = 8;
    public static final int COMMAND_MainScreenTasbih = 2;
    public static final int COMMAND_PrayerAlertDownload = 12;

    protected boolean onPrayerAlertStored() {
        return false;
    }

    protected boolean onAayaPrev() {
        return false;
    }

    protected boolean onMainScreenQuranKarim() {
        return false;
    }

    protected boolean onAayaNext() {
        return false;
    }

    protected boolean onSurahCommand4() {
        return false;
    }

    protected boolean onWallpaperCommand10() {
        return false;
    }

    protected boolean onMainScreenPrayerAlert() {
        return false;
    }

    protected boolean onMainScreenWallpapers() {
        return false;
    }

    protected boolean onMainScreenTasbih() {
        return false;
    }

    protected boolean onPrayerAlertDownload() {
        return false;
    }

    protected void processCommand(ActionEvent ev, Command cmd) {
        switch(cmd.getId()) {
            case COMMAND_PrayerAlertStored:
                if(onPrayerAlertStored()) {
                    ev.consume();
                    return;
                }
                break;

            case COMMAND_AayaPrev:
                if(onAayaPrev()) {
                    ev.consume();
                    return;
                }
                break;

            case COMMAND_MainScreenQuranKarim:
                if(onMainScreenQuranKarim()) {
                    ev.consume();
                    return;
                }
                break;

            case COMMAND_AayaNext:
                if(onAayaNext()) {
                    ev.consume();
                    return;
                }
                break;

            case COMMAND_SurahCommand4:
                if(onSurahCommand4()) {
                    ev.consume();
                    return;
                }
                break;

            case COMMAND_WallpaperCommand10:
                if(onWallpaperCommand10()) {
                    ev.consume();
                    return;
                }
                break;

            case COMMAND_MainScreenPrayerAlert:
                if(onMainScreenPrayerAlert()) {
                    ev.consume();
                    return;
                }
                break;

            case COMMAND_MainScreenWallpapers:
                if(onMainScreenWallpapers()) {
                    ev.consume();
                    return;
                }
                break;

            case COMMAND_MainScreenTasbih:
                if(onMainScreenTasbih()) {
                    ev.consume();
                    return;
                }
                break;

            case COMMAND_PrayerAlertDownload:
                if(onPrayerAlertDownload()) {
                    ev.consume();
                    return;
                }
                break;

        }
        if(ev.getComponent() != null) {
            handleComponentAction(ev.getComponent(), ev);
        }
    }

    protected void exitForm(Form f) {
        if("splash".equals(f.getName())) {
            exitSplash(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("wallpaper".equals(f.getName())) {
            exitWallpaper(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("wallpaperRenderer".equals(f.getName())) {
            exitWallpaperRenderer(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Tasbih".equals(f.getName())) {
            exitTasbih(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("surahRenderer".equals(f.getName())) {
            exitSurahRenderer(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("aaya".equals(f.getName())) {
            exitAaya(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("MainScreen".equals(f.getName())) {
            exitMainScreen(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("WallpaperFullScreen".equals(f.getName())) {
            exitWallpaperFullScreen(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("PrayerAlert".equals(f.getName())) {
            exitPrayerAlert(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("surah".equals(f.getName())) {
            exitSurah(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void exitSplash(Form f) {
    }


    protected void exitWallpaper(Form f) {
    }


    protected void exitWallpaperRenderer(Form f) {
    }


    protected void exitTasbih(Form f) {
    }


    protected void exitSurahRenderer(Form f) {
    }


    protected void exitAaya(Form f) {
    }


    protected void exitMainScreen(Form f) {
    }


    protected void exitWallpaperFullScreen(Form f) {
    }


    protected void exitPrayerAlert(Form f) {
    }


    protected void exitSurah(Form f) {
    }

    protected void beforeShow(Form f) {
    aboutToShowThisContainer = f;
        if("splash".equals(f.getName())) {
            beforeSplash(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("wallpaper".equals(f.getName())) {
            beforeWallpaper(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("wallpaperRenderer".equals(f.getName())) {
            beforeWallpaperRenderer(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Tasbih".equals(f.getName())) {
            beforeTasbih(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("surahRenderer".equals(f.getName())) {
            beforeSurahRenderer(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("aaya".equals(f.getName())) {
            beforeAaya(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("MainScreen".equals(f.getName())) {
            beforeMainScreen(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("WallpaperFullScreen".equals(f.getName())) {
            beforeWallpaperFullScreen(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("PrayerAlert".equals(f.getName())) {
            beforePrayerAlert(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("surah".equals(f.getName())) {
            beforeSurah(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void beforeSplash(Form f) {
    }


    protected void beforeWallpaper(Form f) {
    }


    protected void beforeWallpaperRenderer(Form f) {
    }


    protected void beforeTasbih(Form f) {
    }


    protected void beforeSurahRenderer(Form f) {
    }


    protected void beforeAaya(Form f) {
    }


    protected void beforeMainScreen(Form f) {
    }


    protected void beforeWallpaperFullScreen(Form f) {
    }


    protected void beforePrayerAlert(Form f) {
    }


    protected void beforeSurah(Form f) {
    }

    protected void beforeShowContainer(Container c) {
        aboutToShowThisContainer = c;
        if("splash".equals(c.getName())) {
            beforeContainerSplash(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("wallpaper".equals(c.getName())) {
            beforeContainerWallpaper(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("wallpaperRenderer".equals(c.getName())) {
            beforeContainerWallpaperRenderer(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Tasbih".equals(c.getName())) {
            beforeContainerTasbih(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("surahRenderer".equals(c.getName())) {
            beforeContainerSurahRenderer(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("aaya".equals(c.getName())) {
            beforeContainerAaya(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("MainScreen".equals(c.getName())) {
            beforeContainerMainScreen(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("WallpaperFullScreen".equals(c.getName())) {
            beforeContainerWallpaperFullScreen(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("PrayerAlert".equals(c.getName())) {
            beforeContainerPrayerAlert(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("surah".equals(c.getName())) {
            beforeContainerSurah(c);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void beforeContainerSplash(Container c) {
    }


    protected void beforeContainerWallpaper(Container c) {
    }


    protected void beforeContainerWallpaperRenderer(Container c) {
    }


    protected void beforeContainerTasbih(Container c) {
    }


    protected void beforeContainerSurahRenderer(Container c) {
    }


    protected void beforeContainerAaya(Container c) {
    }


    protected void beforeContainerMainScreen(Container c) {
    }


    protected void beforeContainerWallpaperFullScreen(Container c) {
    }


    protected void beforeContainerPrayerAlert(Container c) {
    }


    protected void beforeContainerSurah(Container c) {
    }

    protected void postShow(Form f) {
        if("splash".equals(f.getName())) {
            postSplash(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("wallpaper".equals(f.getName())) {
            postWallpaper(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("wallpaperRenderer".equals(f.getName())) {
            postWallpaperRenderer(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Tasbih".equals(f.getName())) {
            postTasbih(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("surahRenderer".equals(f.getName())) {
            postSurahRenderer(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("aaya".equals(f.getName())) {
            postAaya(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("MainScreen".equals(f.getName())) {
            postMainScreen(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("WallpaperFullScreen".equals(f.getName())) {
            postWallpaperFullScreen(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("PrayerAlert".equals(f.getName())) {
            postPrayerAlert(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("surah".equals(f.getName())) {
            postSurah(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void postSplash(Form f) {
    }


    protected void postWallpaper(Form f) {
    }


    protected void postWallpaperRenderer(Form f) {
    }


    protected void postTasbih(Form f) {
    }


    protected void postSurahRenderer(Form f) {
    }


    protected void postAaya(Form f) {
    }


    protected void postMainScreen(Form f) {
    }


    protected void postWallpaperFullScreen(Form f) {
    }


    protected void postPrayerAlert(Form f) {
    }


    protected void postSurah(Form f) {
    }

    protected void postShowContainer(Container c) {
        if("splash".equals(c.getName())) {
            postContainerSplash(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("wallpaper".equals(c.getName())) {
            postContainerWallpaper(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("wallpaperRenderer".equals(c.getName())) {
            postContainerWallpaperRenderer(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Tasbih".equals(c.getName())) {
            postContainerTasbih(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("surahRenderer".equals(c.getName())) {
            postContainerSurahRenderer(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("aaya".equals(c.getName())) {
            postContainerAaya(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("MainScreen".equals(c.getName())) {
            postContainerMainScreen(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("WallpaperFullScreen".equals(c.getName())) {
            postContainerWallpaperFullScreen(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("PrayerAlert".equals(c.getName())) {
            postContainerPrayerAlert(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("surah".equals(c.getName())) {
            postContainerSurah(c);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void postContainerSplash(Container c) {
    }


    protected void postContainerWallpaper(Container c) {
    }


    protected void postContainerWallpaperRenderer(Container c) {
    }


    protected void postContainerTasbih(Container c) {
    }


    protected void postContainerSurahRenderer(Container c) {
    }


    protected void postContainerAaya(Container c) {
    }


    protected void postContainerMainScreen(Container c) {
    }


    protected void postContainerWallpaperFullScreen(Container c) {
    }


    protected void postContainerPrayerAlert(Container c) {
    }


    protected void postContainerSurah(Container c) {
    }

    protected void onCreateRoot(String rootName) {
        if("splash".equals(rootName)) {
            onCreateSplash();
            aboutToShowThisContainer = null;
            return;
        }

        if("wallpaper".equals(rootName)) {
            onCreateWallpaper();
            aboutToShowThisContainer = null;
            return;
        }

        if("wallpaperRenderer".equals(rootName)) {
            onCreateWallpaperRenderer();
            aboutToShowThisContainer = null;
            return;
        }

        if("Tasbih".equals(rootName)) {
            onCreateTasbih();
            aboutToShowThisContainer = null;
            return;
        }

        if("surahRenderer".equals(rootName)) {
            onCreateSurahRenderer();
            aboutToShowThisContainer = null;
            return;
        }

        if("aaya".equals(rootName)) {
            onCreateAaya();
            aboutToShowThisContainer = null;
            return;
        }

        if("MainScreen".equals(rootName)) {
            onCreateMainScreen();
            aboutToShowThisContainer = null;
            return;
        }

        if("WallpaperFullScreen".equals(rootName)) {
            onCreateWallpaperFullScreen();
            aboutToShowThisContainer = null;
            return;
        }

        if("PrayerAlert".equals(rootName)) {
            onCreatePrayerAlert();
            aboutToShowThisContainer = null;
            return;
        }

        if("surah".equals(rootName)) {
            onCreateSurah();
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void onCreateSplash() {
    }


    protected void onCreateWallpaper() {
    }


    protected void onCreateWallpaperRenderer() {
    }


    protected void onCreateTasbih() {
    }


    protected void onCreateSurahRenderer() {
    }


    protected void onCreateAaya() {
    }


    protected void onCreateMainScreen() {
    }


    protected void onCreateWallpaperFullScreen() {
    }


    protected void onCreatePrayerAlert() {
    }


    protected void onCreateSurah() {
    }

    protected Hashtable getFormState(Form f) {
        Hashtable h = super.getFormState(f);
        if("splash".equals(f.getName())) {
            getStateSplash(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("wallpaper".equals(f.getName())) {
            getStateWallpaper(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("wallpaperRenderer".equals(f.getName())) {
            getStateWallpaperRenderer(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("Tasbih".equals(f.getName())) {
            getStateTasbih(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("surahRenderer".equals(f.getName())) {
            getStateSurahRenderer(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("aaya".equals(f.getName())) {
            getStateAaya(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("MainScreen".equals(f.getName())) {
            getStateMainScreen(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("WallpaperFullScreen".equals(f.getName())) {
            getStateWallpaperFullScreen(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("PrayerAlert".equals(f.getName())) {
            getStatePrayerAlert(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("surah".equals(f.getName())) {
            getStateSurah(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

            return h;
    }


    protected void getStateSplash(Form f, Hashtable h) {
    }


    protected void getStateWallpaper(Form f, Hashtable h) {
    }


    protected void getStateWallpaperRenderer(Form f, Hashtable h) {
    }


    protected void getStateTasbih(Form f, Hashtable h) {
    }


    protected void getStateSurahRenderer(Form f, Hashtable h) {
    }


    protected void getStateAaya(Form f, Hashtable h) {
    }


    protected void getStateMainScreen(Form f, Hashtable h) {
    }


    protected void getStateWallpaperFullScreen(Form f, Hashtable h) {
    }


    protected void getStatePrayerAlert(Form f, Hashtable h) {
    }


    protected void getStateSurah(Form f, Hashtable h) {
    }

    protected void setFormState(Form f, Hashtable state) {
        super.setFormState(f, state);
        if("splash".equals(f.getName())) {
            setStateSplash(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("wallpaper".equals(f.getName())) {
            setStateWallpaper(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("wallpaperRenderer".equals(f.getName())) {
            setStateWallpaperRenderer(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("Tasbih".equals(f.getName())) {
            setStateTasbih(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("surahRenderer".equals(f.getName())) {
            setStateSurahRenderer(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("aaya".equals(f.getName())) {
            setStateAaya(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("MainScreen".equals(f.getName())) {
            setStateMainScreen(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("WallpaperFullScreen".equals(f.getName())) {
            setStateWallpaperFullScreen(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("PrayerAlert".equals(f.getName())) {
            setStatePrayerAlert(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("surah".equals(f.getName())) {
            setStateSurah(f, state);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void setStateSplash(Form f, Hashtable state) {
    }


    protected void setStateWallpaper(Form f, Hashtable state) {
    }


    protected void setStateWallpaperRenderer(Form f, Hashtable state) {
    }


    protected void setStateTasbih(Form f, Hashtable state) {
    }


    protected void setStateSurahRenderer(Form f, Hashtable state) {
    }


    protected void setStateAaya(Form f, Hashtable state) {
    }


    protected void setStateMainScreen(Form f, Hashtable state) {
    }


    protected void setStateWallpaperFullScreen(Form f, Hashtable state) {
    }


    protected void setStatePrayerAlert(Form f, Hashtable state) {
    }


    protected void setStateSurah(Form f, Hashtable state) {
    }

    protected boolean setListModel(List cmp) {
        String listName = cmp.getName();
        if("ListAaya".equals(listName)) {
            return initListModelListAaya(cmp);
        }
        if("ListSurah".equals(listName)) {
            return initListModelListSurah(cmp);
        }
        return super.setListModel(cmp);
    }

    protected boolean initListModelListAaya(List cmp) {
        return false;
    }

    protected boolean initListModelListSurah(List cmp) {
        return false;
    }

    protected boolean setListModel(com.codename1.ui.list.ContainerList cmp) {
        String listName = cmp.getName();
        if("ContainerList".equals(listName)) {
            return initListModelContainerList(cmp);
        }
        return super.setListModel(cmp);
    }

    protected boolean initListModelContainerList(com.codename1.ui.list.ContainerList cmp) {
        return false;
    }

    protected void handleComponentAction(Component c, ActionEvent event) {
        Container rootContainerAncestor = getRootAncestor(c);
        if(rootContainerAncestor == null) return;
        String rootContainerName = rootContainerAncestor.getName();
        Container leadParentContainer = c.getParent().getLeadParent();
        if(leadParentContainer != null && leadParentContainer.getClass() != Container.class) {
            c = c.getParent().getLeadParent();
        }
        if(rootContainerName == null) return;
        if(rootContainerName.equals("wallpaper")) {
            if("ContainerList".equals(c.getName())) {
                onWallpaper_ContainerListAction(c, event);
                return;
            }
            if("ButtonShowWallpaper".equals(c.getName())) {
                onWallpaper_ButtonShowWallpaperAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("Tasbih")) {
            if("TasbihResetButton".equals(c.getName())) {
                onTasbih_TasbihResetButtonAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("aaya")) {
            if("ListAaya".equals(c.getName())) {
                onAaya_ListAayaAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("MainScreen")) {
            if("Button".equals(c.getName())) {
                onMainScreen_ButtonAction(c, event);
                return;
            }
            if("Button1".equals(c.getName())) {
                onMainScreen_Button1Action(c, event);
                return;
            }
            if("Button2".equals(c.getName())) {
                onMainScreen_Button2Action(c, event);
                return;
            }
            if("Button3".equals(c.getName())) {
                onMainScreen_Button3Action(c, event);
                return;
            }
        }
        if(rootContainerName.equals("PrayerAlert")) {
            if("Button".equals(c.getName())) {
                onPrayerAlert_ButtonAction(c, event);
                return;
            }
            if("ButtonPlay".equals(c.getName())) {
                onPrayerAlert_ButtonPlayAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("surah")) {
            if("SurahSelect".equals(c.getName())) {
                onSurah_SurahSelectAction(c, event);
                return;
            }
            if("ListSurah".equals(c.getName())) {
                onSurah_ListSurahAction(c, event);
                return;
            }
        }
    }

      protected void onWallpaper_ContainerListAction(Component c, ActionEvent event) {
      }

      protected void onWallpaper_ButtonShowWallpaperAction(Component c, ActionEvent event) {
      }

      protected void onTasbih_TasbihResetButtonAction(Component c, ActionEvent event) {
      }

      protected void onAaya_ListAayaAction(Component c, ActionEvent event) {
      }

      protected void onMainScreen_ButtonAction(Component c, ActionEvent event) {
      }

      protected void onMainScreen_Button1Action(Component c, ActionEvent event) {
      }

      protected void onMainScreen_Button2Action(Component c, ActionEvent event) {
      }

      protected void onMainScreen_Button3Action(Component c, ActionEvent event) {
      }

      protected void onPrayerAlert_ButtonAction(Component c, ActionEvent event) {
      }

      protected void onPrayerAlert_ButtonPlayAction(Component c, ActionEvent event) {
      }

      protected void onSurah_SurahSelectAction(Component c, ActionEvent event) {
      }

      protected void onSurah_ListSurahAction(Component c, ActionEvent event) {
      }

}
