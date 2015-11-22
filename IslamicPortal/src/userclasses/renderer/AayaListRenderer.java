/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userclasses.renderer;

import com.sun.lwuit.Component;
import com.sun.lwuit.Label;
import com.sun.lwuit.List;
import com.sun.lwuit.TextArea;
import com.sun.lwuit.geom.Dimension;
import com.sun.lwuit.list.ListCellRenderer;
import userclasses.StateMachine;

/**
 *
 * @author Pankaj
 */
public class AayaListRenderer extends TextArea implements ListCellRenderer {

    public AayaListRenderer() {
//        Dimension d = new Dimension(100, 100);
//        setPreferredSize(d);
    	setGrowByContent(true);
    }

    public Component getListCellRendererComponent(List list, Object value, int index, boolean isSelected){
        setText(value.toString());
        if (isSelected) {
            setFocus(true);
            getStyle().setBgTransparency(100);
        } else {
            setFocus(false);
            getStyle().setBgTransparency(0);
        }
        return this;
    }

    public Component getListFocusComponent(List list) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return null;
    }
}