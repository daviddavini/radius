import java.applet.AudioClip;

public class Resources {
	static AudioClip main_theme;
	static boolean main_playing;
	static AudioClip evil_theme;
	static boolean evil_playing;
	static AudioClip half1_theme;
	static boolean half1_playing;
	static AudioClip half2_theme;
	static boolean half2_playing;
	static AudioClip intro_theme;
	
	static AudioClip hit_red;
	static AudioClip hit_green;
	static AudioClip hit_yellow;
	static AudioClip hit_checkpoint;
	static AudioClip next_level;
	static AudioClip fail_level;
	static boolean fail_played;
	static Main m;
	
	public Resources(Main m) {
		Resources.m = m;
		main_theme = m.getAudioClip(m.getDocumentBase(),"Sounds/main_theme.au");
		main_playing = false;
		evil_theme = m.getAudioClip(m.getDocumentBase(),"Sounds/evil_theme.au");
		evil_playing = false;
		half1_theme = m.getAudioClip(m.getDocumentBase(),"Sounds/half1_theme.au");
		half1_playing = false;
		half2_theme = m.getAudioClip(m.getDocumentBase(),"Sounds/half2_theme.au");
		half2_playing = false;
		intro_theme = m.getAudioClip(m.getDocumentBase(),"Sounds/intro.au");
		
		hit_red = m.getAudioClip(m.getDocumentBase(),"Sounds/hit_red.au");
		hit_green = m.getAudioClip(m.getDocumentBase(),"Sounds/hit_green.au");
		hit_yellow = m.getAudioClip(m.getDocumentBase(),"Sounds/hit_yellow.au");
		hit_checkpoint = m.getAudioClip(m.getDocumentBase(),"Sounds/hit_checkpoint.au");
		next_level = m.getAudioClip(m.getDocumentBase(),"Sounds/next_level.au");
		fail_level = m.getAudioClip(m.getDocumentBase(),"Sounds/fail_level.au");
		fail_played = false;
	}
}
