package os.main.elements;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import os.main.Element;

public class OSFrame extends Element {

	public int width = 640;
	public int height = 480;
	
	public OSFrame(float x, float y) {
		super(x, y);
		setCollisionSize(width,height);
	}

	@Override
	public void tick() {
		updateOSFrame();
		
	}

	@Override
	public void optionalDraw() {
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		
		GL11.glColor3f(100/255f, 100/255f, 100/255f);
		GL11.glBegin(GL11.GL_QUADS);
		
		GL11.glVertex2f(0, 0);
		GL11.glVertex2f(width, 0);
		GL11.glVertex2f(width, height);
		GL11.glVertex2f(0, height);
		
		GL11.glEnd();
		
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glColor3f(48/255f, 48/255f, 48/255f);
		GL11.glBegin(GL11.GL_QUADS);
		
		GL11.glVertex2f(0, 0);
		GL11.glVertex2f(width, 0);
		GL11.glVertex2f(width, 32);
		GL11.glVertex2f(0, 32);
		
		GL11.glEnd();
		
	}
	
	public void updateOSFrame(){
		float mx = Mouse.getX();
		float my = Display.getHeight() - Mouse.getY();
		
		if(mx >= x && mx <= x+collisionSize.width && my >= y && my <= y+32){
			if(Mouse.isButtonDown(0)){
				x = (mx-(width/2));
				y = (my-16);
			}
		}
	}

	@Override
	public void drawExtra() {
		// TODO Auto-generated method stub
		
	}

}
