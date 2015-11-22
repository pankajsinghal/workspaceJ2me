/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userclasses.renderer;

import java.io.IOException;
import java.io.InputStream;

import userclasses.StateMachine;

import com.codename1.ui.Component;
import com.codename1.ui.Display;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.List;
import com.codename1.ui.list.CellRenderer;
import com.codename1.ui.list.ListCellRenderer;

/**
 *
 * @author Pankaj
 */
public class WallpaperListRenderer extends Label implements CellRenderer {

    
    public WallpaperListRenderer() {
        	setName("wallpaperIcon");
            setSmoothScrolling(true);
        
    }

	public Component getCellRendererComponent(Component list, Object model,
			Object value, int index, boolean isSelected) {
        setText(value.toString());
        if (isSelected) {
        	requestFocus();
        } else {
        }
        return this;
    }

	public Component getFocusComponent(Component list) {
		// TODO Auto-generated method stub
		return null;
	}
}
