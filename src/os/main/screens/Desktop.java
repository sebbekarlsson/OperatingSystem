package os.main.screens;

import org.lwjgl.opengl.Display;

import os.main.ElementIcon;
import os.main.Screen;
import os.main.elements.BottomBar;
import os.main.elements.Cursor;

public class Desktop extends Screen {

	ElementIcon cursor_icon = new ElementIcon();
	
	public Desktop(){
		
		
		createElement(new BottomBar(0,Display.getHeight()-32));
		createElement(new Cursor(0,0));
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

}
