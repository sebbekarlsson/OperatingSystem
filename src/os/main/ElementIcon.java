package os.main;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

public class ElementIcon {
	public ArrayList<Texture> images = new ArrayList<Texture>();
	public int imageIndex = 0;
	
	public Texture getCurrentImage(){
		return images.get(imageIndex);
	}
	
	public void draw(){
		
		Texture texture = getCurrentImage();
		
		if(texture != null){
			texture.bind();
		}
		
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glColor3f(1,1,1);
		GL11.glBegin(GL11.GL_QUADS);
		
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex2f(0, 0);
		
		GL11.glTexCoord2f(texture.getWidth(), 0);
		GL11.glVertex2f(texture.getImageWidth(), 0);
		
		GL11.glTexCoord2f(texture.getWidth(), texture.getHeight());
		GL11.glVertex2f(texture.getImageWidth(), texture.getImageHeight());
		
		GL11.glTexCoord2f(0, texture.getHeight());
		GL11.glVertex2f(0, texture.getImageHeight());
		
		GL11.glEnd();
	}
}
