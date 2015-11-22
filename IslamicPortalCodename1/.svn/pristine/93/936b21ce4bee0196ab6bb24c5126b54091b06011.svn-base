package userclasses.quran;

import java.io.InputStream;

import userclasses.StateMachine;

import com.codename1.media.MediaManager;
import com.codename1.ui.Display;
import com.codename1.ui.Form;

public class Player implements Runnable {

	public static int i=1;
	public static Form f;
	
	public Player() {
		// TODO Auto-generated constructor stub
	}
	public void run() {
		i++;
		if(i<=5){
			InputStream inputStream = Display.getInstance().getResourceAsStream(this.getClass(), "/"+i+".m4a");
	        try {
	        	StateMachine.stateMachine.findLabelPlay(f).setText("playing : "+i);
				 StateMachine.media = MediaManager.createMedia(inputStream, "audio/m4a",this);
				 StateMachine.media.prepare();
				 StateMachine.media.play();
				 f.revalidate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				StateMachine.media = null;
				e.printStackTrace();
			}
		}
	}

}
