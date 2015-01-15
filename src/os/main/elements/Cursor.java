package os.main.elements;

import java.util.ArrayList;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import os.main.Element;
import os.main.ElementIcon;
import os.main.TextureBank;

public class Cursor extends Element {

	ArrayList<ElementIcon> cursorPointers = new ArrayList<ElementIcon>();
	public static int cursorId = 0;
	
	ElementIcon cursor_pointer = new ElementIcon();
	ElementIcon cursor_click = new ElementIcon();
	
	public Cursor(float x, float y) {
		super(x, y);
		cursor_pointer.images.add(TextureBank.CURSOR_POINTER);
		cursor_click.images.add(TextureBank.CURSOR_CLICK);
		
		cursorPointers.add(cursor_pointer);
		cursorPointers.add(cursor_click);
		
		depth = 0;
	}

	@Override
	public void tick() {
		icon = cursorPointers.get(cursorId);
		x = Mouse.getX();
		y = Display.getHeight() - Mouse.getY();
		
		
	}

	@Override
	public void optionalDraw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawExtra() {
		// TODO Auto-generated method stub
		
	}
	
	public static void setCursor(int id){
		cursorId = id;
	}

}
