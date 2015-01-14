package os.main.elements;



import os.main.Element;
import os.main.ElementIcon;

import os.main.TextureBank;

public class StartButton extends Element {

	ElementIcon normal = new ElementIcon();
	ElementIcon hover = new ElementIcon();
	
	public StartButton(float x, float y) {
		super(x, y);
		setCollisionSize(100,32);
		normal.images.add(TextureBank.START_BUTTON);
		hover.images.add(TextureBank.START_BUTTON_HOVER);
	}

	@Override
	public void tick() {
		if(mouseOver()){
			icon = normal;
			Cursor.setCursor(1);
		}else{
			icon = hover;
			Cursor.setCursor(0);
		}
		
	}

	@Override
	public void drawExtra() {
		
	}

	@Override
	public void optionalDraw() {
		// TODO Auto-generated method stub
		
	}

}
