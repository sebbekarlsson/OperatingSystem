package os.main.elements;





import os.main.TextureBank;

public class StartButton extends OSButton {

	
	public StartButton(float x, float y) {
		super(x, y);
		setCollisionSize(100,32);
		normal.images.add(TextureBank.START_BUTTON);
		hover.images.add(TextureBank.START_BUTTON_HOVER);
	}

	@Override
	public void tick() {
		updateButton();
		
	}

	@Override
	public void drawExtra() {
		
	}

	@Override
	public void optionalDraw() {
		// TODO Auto-generated method stub
		
	}

}
