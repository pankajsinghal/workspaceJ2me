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
            return showForm("main", null);
        } else {
            Form f = (Form)createContainer(resPath, "main");
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
        return createContainer(resPath, "main");
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

    public com.sun.lwuit.TextArea findName(Container root) {
        return (com.sun.lwuit.TextArea)findByName("name", root);
    }

    public com.sun.lwuit.Container findRenderer(Container root) {
        return (com.sun.lwuit.Container)findByName("renderer", root);
    }

    public com.sun.lwuit.list.ContainerList findContainerList(Container root) {
        return (com.sun.lwuit.list.ContainerList)findByName("ContainerList", root);
    }

    public com.sun.lwuit.Form findMain(Container root) {
        return (com.sun.lwuit.Form)findByName("main", root);
    }

    protected void exitForm(Form f) {
        if("main".equals(f.getName())) {
            exitMain(f);
            return;
        }

        if("renderer".equals(f.getName())) {
            exitRenderer(f);
            return;
        }

    }


    protected void exitMain(Form f) {
    }


    protected void exitRenderer(Form f) {
    }

    protected void beforeShow(Form f) {
        if("main".equals(f.getName())) {
            beforeMain(f);
            return;
        }

        if("renderer".equals(f.getName())) {
            beforeRenderer(f);
            return;
        }

    }


    protected void beforeMain(Form f) {
    }


    protected void beforeRenderer(Form f) {
    }

    protected void beforeShowContainer(Container c) {
        if("main".equals(c.getName())) {
            beforeContainerMain(c);
            return;
        }

        if("renderer".equals(c.getName())) {
            beforeContainerRenderer(c);
            return;
        }

    }


    protected void beforeContainerMain(Container c) {
    }


    protected void beforeContainerRenderer(Container c) {
    }

    protected void postShow(Form f) {
        if("main".equals(f.getName())) {
            postMain(f);
            return;
        }

        if("renderer".equals(f.getName())) {
            postRenderer(f);
            return;
        }

    }


    protected void postMain(Form f) {
    }


    protected void postRenderer(Form f) {
    }

    protected void postShowContainer(Container c) {
        if("main".equals(c.getName())) {
            postContainerMain(c);
            return;
        }

        if("renderer".equals(c.getName())) {
            postContainerRenderer(c);
            return;
        }

    }


    protected void postContainerMain(Container c) {
    }


    protected void postContainerRenderer(Container c) {
    }

    protected void onCreateRoot(String rootName) {
        if("main".equals(rootName)) {
            onCreateMain();
            return;
        }

        if("renderer".equals(rootName)) {
            onCreateRenderer();
            return;
        }

    }


    protected void onCreateMain() {
    }


    protected void onCreateRenderer() {
    }

    protected boolean setListModel(List cmp) {
        String listName = cmp.getName();
        if("ContainerList".equals(listName)) {
            return initListModelContainerList(cmp);
        }
        return super.setListModel(cmp);
    }

    protected boolean initListModelContainerList(List cmp) {
        return false;
    }

    protected void handleComponentAction(Component c, ActionEvent event) {
        Container rootContainerAncestor = getRootAncestor(c);
        if(rootContainerAncestor == null) return;
        String rootContainerName = rootContainerAncestor.getName();
        if(rootContainerName == null) return;
        if(rootContainerName.equals("main")) {
            if("name".equals(c.getName())) {
                onMain_NameAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("renderer")) {
            if("name".equals(c.getName())) {
                onRenderer_NameAction(c, event);
                return;
            }
        }
    }

      protected void onMain_NameAction(Component c, ActionEvent event) {
      }

      protected void onRenderer_NameAction(Component c, ActionEvent event) {
      }

}
