/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userclasses.renderer;

import com.sun.lwuit.Component;
import com.sun.lwuit.Image;
import com.sun.lwuit.Label;
import com.sun.lwuit.List;
import com.sun.lwuit.TextArea;
import com.sun.lwuit.geom.Dimension;
import com.sun.lwuit.list.DefaultListCellRenderer;
import com.sun.lwuit.list.ListCellRenderer;
import com.sun.lwuit.plaf.Style;
import java.io.IOException;
import java.io.InputStream;
import userclasses.StateMachine;

/**
 *
 * @author Pankaj
 */
public class SurahListRenderer extends DefaultListCellRenderer {

    Image surahUnselect = null;
    Image surahSelect = null;
    
    public SurahListRenderer() {
    	super(true);
        try {
        	
            setSmoothScrolling(true);
            setShowNumbers(true);
            setShowNumbersDefault(true);
            refreshTheme();
            repaint();
            InputStream inputStream = getClass().getResourceAsStream("/res/images/surahlistbard.png");
            surahUnselect = Image.createImage(inputStream);
            inputStream = getClass().getResourceAsStream("/res/images/surahselect.png");
            surahSelect = Image.createImage(inputStream);
            getStyle().setAlignment(CENTER);
            getSelectedStyle().setAlignment(CENTER);
            getStyle().setBgTransparency(0);
            getStyle().setBgImage(surahUnselect);
            getSelectedStyle().setBgTransparency(100);
            getSelectedStyle().setBgImage(surahSelect);
            
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }

    
    
    public Component getListCellRendererComponent(List list, Object value, int index, boolean isSelected) {
        setText(value.toString());
        if (isSelected) {
            setFocus(true);
        } else {
            setFocus(false);
        }
        return this;
    }

    public Component getListFocusComponent(List list) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return null;
    }
}