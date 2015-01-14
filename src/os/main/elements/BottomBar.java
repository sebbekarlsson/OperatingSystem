package os.main.elements;

import java.util.ArrayList;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import os.main.Element;

public class BottomBar extends Element {

	public ArrayList<Element> elements = new ArrayList<Element>();
	
	public BottomBar(float x, float y) {
		super(x, y);
		setCollisionSize(Display.getWidth(),32);
		elements.add(new StartButton(x,y));
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void drawExtra() {
	
		
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		for(int i = 0; i < elements.size(); i++){
			Element e = elements.get(i);
			e.updateElement();
			e.draw();
			e.tick();
			e.x = i*e.collisionSize.width;
		}
		
	}

	@Override
	public void optionalDraw() {
	
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glColor3f(48/255f, 48/255f, 48/255f);
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glVertex2f(0, 0);
		GL11.glVertex2f(Display.getWidth(), 0);
		GL11.glVertex2f(Display.getWidth(), 32);
		GL11.glVertex2f(0, 32);
		GL11.glEnd();
		
	}

}
