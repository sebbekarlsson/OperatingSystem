package os.main;

import java.awt.Dimension;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public abstract class Element {
	public float x,y = 0;
	public float depth = 1;
	public ElementIcon icon = new ElementIcon();
	public Dimension collisionSize = new Dimension(16,16);
	private boolean mouseOver = false;
	
	public Element(float x, float y){
		this.x = x;
		this.y = y;
	}

	public void updateElement(){
		float mx = Mouse.getX();
		float my = (Display.getHeight() - Mouse.getY());
		if(mx >= x && mx <= x+collisionSize.width && my >= y && my <= y+collisionSize.height){
			mouseOver = true;
		}else{
			mouseOver = false;
		}
	}
	
	public abstract void tick();
	public void draw(){
		GL11.glPushMatrix();
		GL11.glTranslatef(x, y, depth);
		if(icon.images.size() > 0){
			icon.draw();
			
		}
		optionalDraw();
		GL11.glTranslatef(-x, -y, -depth);
		drawExtra();
		GL11.glPopMatrix();
	}
	
	public abstract void optionalDraw();

	public abstract void drawExtra();
	
	public void setCollisionSize(int width, int height){
		collisionSize.width = (int) width;
		collisionSize.height = (int) height;
	}
	
	public boolean mouseOver(){
		return mouseOver;
	}
}
