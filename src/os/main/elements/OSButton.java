package os.main.elements;

import org.lwjgl.input.Mouse;

import os.main.Element;
import os.main.ElementIcon;
import os.main.OSButtonListener;

public class OSButton extends Element {

	protected ElementIcon normal = new ElementIcon();
	protected ElementIcon hover = new ElementIcon();
	public OSButtonListener listener;
	
	public OSButton(float x, float y) {
		super(x, y);
		setCollisionSize(64,32);
		//normal.images.add(TextureBank.BUTTON);
		//hover.images.add(TextureBank.BUTTON_HOVER);
		
		icon = normal;
	}

	@Override
	public void tick() {
	
		
	}
	
	public void updateButton(){
		if(mouseOver()){
			if(Mouse.isButtonDown(0)){
				if(listener != null){
					listener.clicked();
				}
			}
			icon = hover;
			Cursor.setCursor(1);
		}else{
			icon = normal;
			Cursor.setCursor(0);
		}
	}

	@Override
	public void optionalDraw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawExtra() {
		// TODO Auto-generated method stub
		
	}
	
	public void addOSButtonListener(OSButtonListener listener){
		this.listener = listener;
	}

}
