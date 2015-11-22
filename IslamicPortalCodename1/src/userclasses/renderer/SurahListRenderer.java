/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userclasses.renderer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;

import userclasses.StateMachine;

import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.List;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.list.ListCellRenderer;
import com.codename1.ui.plaf.Style;

/**
 *
 * @author Pankaj
 */
public class SurahListRenderer extends Container implements ListCellRenderer {

    Label num = new Label("");
    Label name = new Label("");
    public SurahListRenderer() {
    	super();
        try {

        	num.setUIID("LabelSurahName");
        	name.setUIID("LabelSurahName");
        	setLayout(new BorderLayout());
        	addComponent(BorderLayout.WEST,num);
        	addComponent(BorderLayout.CENTER,name);
        	num.setName("num");
        	name.setName("name");
        	num.getStyle().setMarginUnit(new byte[]{Style.UNIT_TYPE_SCREEN_PERCENTAGE,Style.UNIT_TYPE_SCREEN_PERCENTAGE,Style.UNIT_TYPE_SCREEN_PERCENTAGE,Style.UNIT_TYPE_SCREEN_PERCENTAGE});
        	num.getStyle().setMargin(0, 0, 7, 0);
        	num.getStyle().setBgTransparency(0);
        	name.getStyle().setBgTransparency(0);
        	name.getStyle().setAlignment(CENTER);
            setSmoothScrolling(true);
            InputStream inputStream = Display.getInstance().getResourceAsStream(StateMachine.class,"/surahlistbard.png");
            Image surahUnselect = Image.createImage(inputStream);
            inputStream = Display.getInstance().getResourceAsStream(StateMachine.class,"/surahselect.png");
            Image surahSelect = Image.createImage(inputStream);
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

	public Component getListCellRendererComponent(List list, Object value,
			int index, boolean isSelected) {
//      setText(value.toString());
		Hashtable hashtable = (Hashtable)value;
		num.setText((String)hashtable.get("num"));
		name.setText((String)hashtable.get("name"));
      if (isSelected) {
          setFocus(true);
      } else {
          setFocus(false);
      }
      return this;
	}



	public Component getListFocusComponent(List list) {
		// TODO Auto-generated method stub
		return null;
	}
}
