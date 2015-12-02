import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
public class Audio{
	
	private URL audioURL;
	
	AudioClip audio;
	
	public Audio(String path){
		audioURL =  Audio.class.getResource(path);
		audio = Applet.newAudioClip(audioURL);
		
	}
	
	public void play(){
		audio.play();
	}
	public void stop(){
		audio.stop();
	}	
	
	void changeVolume(double value){
		if(value < 0 || value > 100){
			value = 100;
		}else{
			value = (double) value/10;
			
		}
	}
}
