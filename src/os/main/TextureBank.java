package os.main;

import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class TextureBank {
	
	public static Texture BUTTON = loadTexture("images/btn1.png");
	public static Texture BUTTON_HOVER = loadTexture("images/btn2.png");
	
	public static Texture START_BUTTON_HOVER = loadTexture("images/startbtn2.png");
	public static Texture START_BUTTON = loadTexture("images/startbtn.png");
	
	public static Texture CURSOR_POINTER = loadTexture("images/cursor.png");
	public static Texture CURSOR_CLICK = loadTexture("images/pointer.png");

	public static Texture loadTexture(String path){
		Texture t = null;
		try {
			t = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return t;
	}
}
