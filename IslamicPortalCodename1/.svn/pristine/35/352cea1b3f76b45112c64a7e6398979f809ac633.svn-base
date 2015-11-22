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
import com.codename1.ui.TextArea;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.list.ListCellRenderer;
import com.codename1.ui.plaf.Style;

/**
 *
 * @author Pankaj
 */
public class AayaListRenderer extends Container implements ListCellRenderer {

    Label numLeft = new Label("");
    TextArea name = new TextArea("");
    Label numRight = new Label("");
    Label star = new Label("");
    public AayaListRenderer() {
    	super();
        try {

        	numLeft.setUIID("LabelAayaLeft");
        	name.setUIID("LabelAayaName");
        	numRight.setUIID("LabelAayaRight");
        	star.setUIID("LabelAayaStar");
        	
        	numLeft.setName("LabelAayaLeft");
        	name.setName("LabelAayaName");
        	numRight.setName("LabelAayaRight");
        	star.setName("LabelAayaStar");
        	
        	numLeft.getStyle().setMarginUnit(new byte[]{Style.UNIT_TYPE_SCREEN_PERCENTAGE,Style.UNIT_TYPE_SCREEN_PERCENTAGE,Style.UNIT_TYPE_SCREEN_PERCENTAGE,Style.UNIT_TYPE_SCREEN_PERCENTAGE});
        	numLeft.getStyle().setMargin(0, 0, 7, 0);
        	numLeft.getStyle().setBgTransparency(0);
        	
        	name.getStyle().setBgTransparency(0);
        	name.getStyle().setAlignment(CENTER);
        	name.setGrowByContent(true);
        	name.setRows(1);
        	name.setColumns(3);
        	name.setFocusable(true);
        	name.setGrowLimit(-1);
        	
        	numRight.getStyle().setBgTransparency(0);
        	
        	star.getStyle().setBgTransparency(0);
        	star.getStyle().setBgImage(Image.createImage("/surahstar.png"));
        	

        	Container containerStar = new Container(new LayeredLayout());
        	containerStar.addComponent(star);
        	containerStar.addComponent(numRight);
        	
        	
        	setLayout(new BorderLayout());
        	addComponent(BorderLayout.EAST,numLeft);
        	addComponent(BorderLayout.CENTER,name);
        	addComponent(BorderLayout.WEST,containerStar);
        	
            setSmoothScrolling(true);
//            getStyle().setAlignment(CENTER);
//            getSelectedStyle().setAlignment(CENTER);
//            getStyle().setBgTransparency(0);
//            getSelectedStyle().setBgTransparency(100);
            
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }

	public Component getListCellRendererComponent(List list, Object value,
			int index, boolean isSelected) {
//      setText(value.toString());
		Hashtable hashtable = (Hashtable)value;
		numLeft.setText((String)hashtable.get("numLeft"));
		name.setText((String)hashtable.get("name"));
      if (isSelected) {
          setFocus(true);
      } else {
          setFocus(false);
      }

      setHeight(name.getHeight());
      revalidate();
      System.out.println(getHeight()+" : "+name.getHeight());
      if(getHeight()<name.getHeight())
      {
	      setHeight(name.getHeight());
	      revalidate();
	      System.out.println("revalidated");
      }
      return this;
	}



	public Component getListFocusComponent(List list) {
		// TODO Auto-generated method stub
		return null;
	}
}
