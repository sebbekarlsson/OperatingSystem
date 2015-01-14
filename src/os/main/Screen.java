package os.main;

import java.util.ArrayList;

public abstract class Screen {
	public ArrayList<Element> elements = new ArrayList<Element>();
	
	public abstract void tick();
	public abstract void draw();
	
	public void createElement(Element element){
		elements.add(element);
	}
	
	public void destroyElement(Element element){
		elements.remove(element);
	}
}
