/**
 * This class contains generated code from the LWUIT resource editor, DO NOT MODIFY!
 * This class is designed for subclassing that way the code generator can overwrite it
 * anytime without erasing your changes which should exist in a subclass!
 * For details about this file and how it works please read this blog post:
 * http://lwuit.blogspot.com/2010/10/ui-builder-class-how-to-actually-use.html
*/
package generated;

import com.sun.lwuit.*;
import com.sun.lwuit.util.*;
import com.sun.lwuit.plaf.*;
import com.sun.lwuit.events.*;

public abstract class StateMachineBase extends UIBuilder {
    /**
     * this method should be used to initialize variables instead of
     * the constructor/class scope to avoid race conditions
     */
    protected void initVars() {}

    public StateMachineBase(Resources res, String resPath, boolean loadTheme) {
        startApp(res, resPath, loadTheme);
    }

    public Container startApp(Resources res, String resPath, boolean loadTheme) {
        initVars();
        UIBuilder.registerCustomComponent("ContainerList", com.sun.lwuit.list.ContainerList.class);
        if(loadTheme) {
            if(res == null) {
                try {
                    res = Resources.open(resPath);
                } catch(java.io.IOException err) { err.printStackTrace(); }
            }
            initTheme(res);
        }
        if(res != null) {
            setResourceFilePath(resPath);
            setResourceFile(res);
            return showForm("splash", null);
        } else {
            Form f = (Form)createContainer(resPath, "splash");
            beforeShow(f);
            f.show();
            postShow(f);
            return f;
        }
    }

    public Container createWidget(Resources res, String resPath, boolean loadTheme) {
        initVars();
        UIBuilder.registerCustomComponent("ContainerList", com.sun.lwuit.list.ContainerList.class);
        if(loadTheme) {
            if(res == null) {
                try {
                    res = Resources.open(resPath);
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

    public com.sun.lwuit.Container findContainerRestInside(Container root) {
        return (com.sun.lwuit.Container)findByName("ContainerRestInside", root);
    }

    public com.sun.lwuit.Button findSurahSelect(Container root) {
        return (com.sun.lwuit.Button)findByName("SurahSelect", root);
    }

    public com.sun.lwuit.Button findTasbihResetButton(Container root) {
        return (com.sun.lwuit.Button)findByName("TasbihResetButton", root);
    }

    public com.sun.lwuit.Form findDu8mmy(Container root) {
        return (com.sun.lwuit.Form)findByName("du8mmy", root);
    }

    public com.sun.lwuit.Form findSplash(Container root) {
        return (com.sun.lwuit.Form)findByName("splash", root);
    }

    public com.sun.lwuit.Button findButton3(Container root) {
        return (com.sun.lwuit.Button)findByName("Button3", root);
    }

    public com.sun.lwuit.list.ContainerList findContainerListWallpaper(Container root) {
        return (com.sun.lwuit.list.ContainerList)findByName("ContainerListWallpaper", root);
    }

    public com.sun.lwuit.Button findButton2(Container root) {
        return (com.sun.lwuit.Button)findByName("Button2", root);
    }

    public com.sun.lwuit.TextArea findTextArea(Container root) {
        return (com.sun.lwuit.TextArea)findByName("TextArea", root);
    }

    public com.sun.lwuit.Container findSurahListRenderer(Container root) {
        return (com.sun.lwuit.Container)findByName("SurahListRenderer", root);
    }

    public com.sun.lwuit.Label findTasbihSideBoard(Container root) {
        return (com.sun.lwuit.Label)findByName("TasbihSideBoard", root);
    }

    public com.sun.lwuit.Form findAaya(Container root) {
        return (com.sun.lwuit.Form)findByName("aaya", root);
    }

    public com.sun.lwuit.Label findTasbihResetLabel(Container root) {
        return (com.sun.lwuit.Label)findByName("TasbihResetLabel", root);
    }

    public com.sun.lwuit.Button findButton(Container root) {
        return (com.sun.lwuit.Button)findByName("Button", root);
    }

    public com.sun.lwuit.Label findLabel1(Container root) {
        return (com.sun.lwuit.Label)findByName("Label1", root);
    }

    public com.sun.lwuit.TextArea findName(Container root) {
        return (com.sun.lwuit.TextArea)findByName("name", root);
    }

    public com.sun.lwuit.Form findMainScreen(Container root) {
        return (com.sun.lwuit.Form)findByName("MainScreen", root);
    }

    public com.sun.lwuit.List findListAaya(Container root) {
        return (com.sun.lwuit.List)findByName("ListAaya", root);
    }

    public com.sun.lwuit.Container findContainer(Container root) {
        return (com.sun.lwuit.Container)findByName("Container", root);
    }

    public com.sun.lwuit.Container findContainerRest(Container root) {
        return (com.sun.lwuit.Container)findByName("ContainerRest", root);
    }

    public com.sun.lwuit.Container findContainerSideBoard(Container root) {
        return (com.sun.lwuit.Container)findByName("ContainerSideBoard", root);
    }

    public com.sun.lwuit.Form findWallpaper(Container root) {
        return (com.sun.lwuit.Form)findByName("wallpaper", root);
    }

    public com.sun.lwuit.Form findPrayerAlert(Container root) {
        return (com.sun.lwuit.Form)findByName("PrayerAlert", root);
    }

    public com.sun.lwuit.List findListSurah(Container root) {
        return (com.sun.lwuit.List)findByName("ListSurah", root);
    }

    public com.sun.lwuit.Form findTasbih(Container root) {
        return (com.sun.lwuit.Form)findByName("Tasbih", root);
    }

    public com.sun.lwuit.Label findLabel(Container root) {
        return (com.sun.lwuit.Label)findByName("Label", root);
    }

    public com.sun.lwuit.Button findButton1(Container root) {
        return (com.sun.lwuit.Button)findByName("Button1", root);
    }

    public com.sun.lwuit.Form findSurah(Container root) {
        return (com.sun.lwuit.Form)findByName("surah", root);
    }

    public static final int COMMAND_AayaPrev = 7;
    public static final int COMMAND_MainScreenQuranKarim = 3;
    public static final int COMMAND_AayaNext = 6;
    public static final int COMMAND_MainScreenPrayerAlert = 9;
    public static final int COMMAND_Du8mmyCommand4 = 4;
    public static final int COMMAND_MainScreenWallpapers = 8;
    public static final int COMMAND_MainScreenTasbih = 2;

    protected boolean onAayaPrev() {
        return false;
    }

    protected boolean onMainScreenQuranKarim() {
        return false;
    }

    protected boolean onAayaNext() {
        return false;
    }

    protected boolean onMainScreenPrayerAlert() {
        return false;
    }

    protected boolean onDu8mmyCommand4() {
        return false;
    }

    protected boolean onMainScreenWallpapers() {
        return false;
    }

    protected boolean onMainScreenTasbih() {
        return false;
    }

    protected void processCommand(ActionEvent ev, Command cmd) {
        switch(cmd.getId()) {
            case COMMAND_AayaPrev:
                if(onAayaPrev()) {
                    ev.consume();
                }
                return;

            case COMMAND_MainScreenQuranKarim:
                if(onMainScreenQuranKarim()) {
                    ev.consume();
                }
                return;

            case COMMAND_AayaNext:
                if(onAayaNext()) {
                    ev.consume();
                }
                return;

            case COMMAND_MainScreenPrayerAlert:
                if(onMainScreenPrayerAlert()) {
                    ev.consume();
                }
                return;

            case COMMAND_Du8mmyCommand4:
                if(onDu8mmyCommand4()) {
                    ev.consume();
                }
                return;

            case COMMAND_MainScreenWallpapers:
                if(onMainScreenWallpapers()) {
                    ev.consume();
                }
                return;

            case COMMAND_MainScreenTasbih:
                if(onMainScreenTasbih()) {
                    ev.consume();
                }
                return;

        }
    }

    protected void exitForm(Form f) {
        if("SurahListRenderer".equals(f.getName())) {
            exitSurahListRenderer(f);
            return;
        }

        if("aaya".equals(f.getName())) {
            exitAaya(f);
            return;
        }

        if("surah".equals(f.getName())) {
            exitSurah(f);
            return;
        }

        if("MainScreen".equals(f.getName())) {
            exitMainScreen(f);
            return;
        }

        if("du8mmy".equals(f.getName())) {
            exitDu8mmy(f);
            return;
        }

        if("PrayerAlert".equals(f.getName())) {
            exitPrayerAlert(f);
            return;
        }

        if("Tasbih".equals(f.getName())) {
            exitTasbih(f);
            return;
        }

        if("splash".equals(f.getName())) {
            exitSplash(f);
            return;
        }

        if("wallpaper".equals(f.getName())) {
            exitWallpaper(f);
            return;
        }

    }


    protected void exitSurahListRenderer(Form f) {
    }


    protected void exitAaya(Form f) {
    }


    protected void exitSurah(Form f) {
    }


    protected void exitMainScreen(Form f) {
    }


    protected void exitDu8mmy(Form f) {
    }


    protected void exitPrayerAlert(Form f) {
    }


    protected void exitTasbih(Form f) {
    }


    protected void exitSplash(Form f) {
    }


    protected void exitWallpaper(Form f) {
    }

    protected void beforeShow(Form f) {
        if("SurahListRenderer".equals(f.getName())) {
            beforeSurahListRenderer(f);
            return;
        }

        if("aaya".equals(f.getName())) {
            beforeAaya(f);
            return;
        }

        if("surah".equals(f.getName())) {
            beforeSurah(f);
            return;
        }

        if("MainScreen".equals(f.getName())) {
            beforeMainScreen(f);
            return;
        }

        if("du8mmy".equals(f.getName())) {
            beforeDu8mmy(f);
            return;
        }

        if("PrayerAlert".equals(f.getName())) {
            beforePrayerAlert(f);
            return;
        }

        if("Tasbih".equals(f.getName())) {
            beforeTasbih(f);
            return;
        }

        if("splash".equals(f.getName())) {
            beforeSplash(f);
            return;
        }

        if("wallpaper".equals(f.getName())) {
            beforeWallpaper(f);
            return;
        }

    }


    protected void beforeSurahListRenderer(Form f) {
    }


    protected void beforeAaya(Form f) {
    }


    protected void beforeSurah(Form f) {
    }


    protected void beforeMainScreen(Form f) {
    }


    protected void beforeDu8mmy(Form f) {
    }


    protected void beforePrayerAlert(Form f) {
    }


    protected void beforeTasbih(Form f) {
    }


    protected void beforeSplash(Form f) {
    }


    protected void beforeWallpaper(Form f) {
    }

    protected void beforeShowContainer(Container c) {
        if("SurahListRenderer".equals(c.getName())) {
            beforeContainerSurahListRenderer(c);
            return;
        }

        if("aaya".equals(c.getName())) {
            beforeContainerAaya(c);
            return;
        }

        if("surah".equals(c.getName())) {
            beforeContainerSurah(c);
            return;
        }

        if("MainScreen".equals(c.getName())) {
            beforeContainerMainScreen(c);
            return;
        }

        if("du8mmy".equals(c.getName())) {
            beforeContainerDu8mmy(c);
            return;
        }

        if("PrayerAlert".equals(c.getName())) {
            beforeContainerPrayerAlert(c);
            return;
        }

        if("Tasbih".equals(c.getName())) {
            beforeContainerTasbih(c);
            return;
        }

        if("splash".equals(c.getName())) {
            beforeContainerSplash(c);
            return;
        }

        if("wallpaper".equals(c.getName())) {
            beforeContainerWallpaper(c);
            return;
        }

    }


    protected void beforeContainerSurahListRenderer(Container c) {
    }


    protected void beforeContainerAaya(Container c) {
    }


    protected void beforeContainerSurah(Container c) {
    }


    protected void beforeContainerMainScreen(Container c) {
    }


    protected void beforeContainerDu8mmy(Container c) {
    }


    protected void beforeContainerPrayerAlert(Container c) {
    }


    protected void beforeContainerTasbih(Container c) {
    }


    protected void beforeContainerSplash(Container c) {
    }


    protected void beforeContainerWallpaper(Container c) {
    }

    protected void postShow(Form f) {
        if("SurahListRenderer".equals(f.getName())) {
            postSurahListRenderer(f);
            return;
        }

        if("aaya".equals(f.getName())) {
            postAaya(f);
            return;
        }

        if("surah".equals(f.getName())) {
            postSurah(f);
            return;
        }

        if("MainScreen".equals(f.getName())) {
            postMainScreen(f);
            return;
        }

        if("du8mmy".equals(f.getName())) {
            postDu8mmy(f);
            return;
        }

        if("PrayerAlert".equals(f.getName())) {
            postPrayerAlert(f);
            return;
        }

        if("Tasbih".equals(f.getName())) {
            postTasbih(f);
            return;
        }

        if("splash".equals(f.getName())) {
            postSplash(f);
            return;
        }

        if("wallpaper".equals(f.getName())) {
            postWallpaper(f);
            return;
        }

    }


    protected void postSurahListRenderer(Form f) {
    }


    protected void postAaya(Form f) {
    }


    protected void postSurah(Form f) {
    }


    protected void postMainScreen(Form f) {
    }


    protected void postDu8mmy(Form f) {
    }


    protected void postPrayerAlert(Form f) {
    }


    protected void postTasbih(Form f) {
    }


    protected void postSplash(Form f) {
    }


    protected void postWallpaper(Form f) {
    }

    protected void postShowContainer(Container c) {
        if("SurahListRenderer".equals(c.getName())) {
            postContainerSurahListRenderer(c);
            return;
        }

        if("aaya".equals(c.getName())) {
            postContainerAaya(c);
            return;
        }

        if("surah".equals(c.getName())) {
            postContainerSurah(c);
            return;
        }

        if("MainScreen".equals(c.getName())) {
            postContainerMainScreen(c);
            return;
        }

        if("du8mmy".equals(c.getName())) {
            postContainerDu8mmy(c);
            return;
        }

        if("PrayerAlert".equals(c.getName())) {
            postContainerPrayerAlert(c);
            return;
        }

        if("Tasbih".equals(c.getName())) {
            postContainerTasbih(c);
            return;
        }

        if("splash".equals(c.getName())) {
            postContainerSplash(c);
            return;
        }

        if("wallpaper".equals(c.getName())) {
            postContainerWallpaper(c);
            return;
        }

    }


    protected void postContainerSurahListRenderer(Container c) {
    }


    protected void postContainerAaya(Container c) {
    }


    protected void postContainerSurah(Container c) {
    }


    protected void postContainerMainScreen(Container c) {
    }


    protected void postContainerDu8mmy(Container c) {
    }


    protected void postContainerPrayerAlert(Container c) {
    }


    protected void postContainerTasbih(Container c) {
    }


    protected void postContainerSplash(Container c) {
    }


    protected void postContainerWallpaper(Container c) {
    }

    protected void onCreateRoot(String rootName) {
        if("SurahListRenderer".equals(rootName)) {
            onCreateSurahListRenderer();
            return;
        }

        if("aaya".equals(rootName)) {
            onCreateAaya();
            return;
        }

        if("surah".equals(rootName)) {
            onCreateSurah();
            return;
        }

        if("MainScreen".equals(rootName)) {
            onCreateMainScreen();
            return;
        }

        if("du8mmy".equals(rootName)) {
            onCreateDu8mmy();
            return;
        }

        if("PrayerAlert".equals(rootName)) {
            onCreatePrayerAlert();
            return;
        }

        if("Tasbih".equals(rootName)) {
            onCreateTasbih();
            return;
        }

        if("splash".equals(rootName)) {
            onCreateSplash();
            return;
        }

        if("wallpaper".equals(rootName)) {
            onCreateWallpaper();
            return;
        }

    }


    protected void onCreateSurahListRenderer() {
    }


    protected void onCreateAaya() {
    }


    protected void onCreateSurah() {
    }


    protected void onCreateMainScreen() {
    }


    protected void onCreateDu8mmy() {
    }


    protected void onCreatePrayerAlert() {
    }


    protected void onCreateTasbih() {
    }


    protected void onCreateSplash() {
    }


    protected void onCreateWallpaper() {
    }

    protected boolean setListModel(List cmp) {
        String listName = cmp.getName();
        if("ContainerListWallpaper".equals(listName)) {
            return initListModelContainerListWallpaper(cmp);
        }
        if("ListAaya".equals(listName)) {
            return initListModelListAaya(cmp);
        }
        if("ListSurah".equals(listName)) {
            return initListModelListSurah(cmp);
        }
        return super.setListModel(cmp);
    }

    protected boolean initListModelContainerListWallpaper(List cmp) {
        return false;
    }

    protected boolean initListModelListAaya(List cmp) {
        return false;
    }

    protected boolean initListModelListSurah(List cmp) {
        return false;
    }

    protected void handleComponentAction(Component c, ActionEvent event) {
        Container rootContainerAncestor = getRootAncestor(c);
        if(rootContainerAncestor == null) return;
        String rootContainerName = rootContainerAncestor.getName();
        if(rootContainerName == null) return;
        if(rootContainerName.equals("SurahListRenderer")) {
            if("name".equals(c.getName())) {
                onSurahListRenderer_NameAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("aaya")) {
            if("name".equals(c.getName())) {
                onAaya_NameAction(c, event);
                return;
            }
            if("ListAaya".equals(c.getName())) {
                onAaya_ListAayaAction(c, event);
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
        if(rootContainerName.equals("du8mmy")) {
            if("TextArea".equals(c.getName())) {
                onDu8mmy_TextAreaAction(c, event);
                return;
            }
            if("SurahSelect".equals(c.getName())) {
                onDu8mmy_SurahSelectAction(c, event);
                return;
            }
            if("name".equals(c.getName())) {
                onDu8mmy_NameAction(c, event);
                return;
            }
            if("ListSurah".equals(c.getName())) {
                onDu8mmy_ListSurahAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("Tasbih")) {
            if("TasbihResetButton".equals(c.getName())) {
                onTasbih_TasbihResetButtonAction(c, event);
                return;
            }
        }
    }

      protected void onSurahListRenderer_NameAction(Component c, ActionEvent event) {
      }

      protected void onAaya_NameAction(Component c, ActionEvent event) {
      }

      protected void onAaya_ListAayaAction(Component c, ActionEvent event) {
      }

      protected void onSurah_SurahSelectAction(Component c, ActionEvent event) {
      }

      protected void onSurah_ListSurahAction(Component c, ActionEvent event) {
      }

      protected void onMainScreen_ButtonAction(Component c, ActionEvent event) {
      }

      protected void onMainScreen_Button1Action(Component c, ActionEvent event) {
      }

      protected void onMainScreen_Button2Action(Component c, ActionEvent event) {
      }

      protected void onMainScreen_Button3Action(Component c, ActionEvent event) {
      }

      protected void onDu8mmy_TextAreaAction(Component c, ActionEvent event) {
      }

      protected void onDu8mmy_SurahSelectAction(Component c, ActionEvent event) {
      }

      protected void onDu8mmy_NameAction(Component c, ActionEvent event) {
      }

      protected void onDu8mmy_ListSurahAction(Component c, ActionEvent event) {
      }

      protected void onTasbih_TasbihResetButtonAction(Component c, ActionEvent event) {
      }

}