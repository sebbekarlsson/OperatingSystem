package os.main;


import java.awt.Dimension;
import java.util.ArrayList;


import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import os.main.screens.Desktop;

public class Main{
	
	public static int WIDTH = 640;
	public static int HEIGHT = WIDTH / 16 * 9;
	public static int SCALE = 3;
	public static Dimension FRAMESIZE = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
	
	public static ArrayList<Screen> screens = new ArrayList<Screen>();
	public static int screenIndex = 0;

	
	public static void main(String[] args){
		new Main();
		
	}
	
	public Main(){
		Display.setTitle("Operating System");
		setDisplayMode(FRAMESIZE.width, FRAMESIZE.height, true);
		try {
			Display.create();
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Mouse.setGrabbed(true);
			Mouse.create();
		} catch (LWJGLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthFunc(GL11.GL_LEQUAL);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, Display.getWidth(), Display.getHeight(), 0, -1, 24);
		
		
		screens.add(new Desktop());
		
		while(!Display.isCloseRequested()){
			GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT | GL11.GL_COLOR_BUFFER_BIT);
			GL11.glClearColor(1, 1, 1, 1);
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			GL11.glLoadIdentity();
			
			
			GL11.glPushMatrix();
			GL11.glTranslatef(0, 0, -1);
			
			
			for(int i = 0; i < getCurrentScreen().elements.size(); i++){
				Element e = getCurrentScreen().elements.get(i);
				e.updateElement();
				e.tick();
				e.draw();
			}
			
			getCurrentScreen().tick();
			getCurrentScreen().draw();
			GL11.glTranslatef(-0, -0, 1);
			GL11.glPopMatrix();
			
			
			
			if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
				System.exit(0);
			}
			Display.sync(60);
			Display.update();
		}
		System.exit(0);
	}
	
	public void setDisplayMode(int width, int height, boolean fullscreen) {
		 
	    // return if requested DisplayMode is already set
	    if ((Display.getDisplayMode().getWidth() == width) && 
	        (Display.getDisplayMode().getHeight() == height) && 
	    (Display.isFullscreen() == fullscreen)) {
	        return;
	    }
	 
	    try {
	        DisplayMode targetDisplayMode = null;
	         
	    if (fullscreen) {
	        DisplayMode[] modes = Display.getAvailableDisplayModes();
	        int freq = 0;
	                 
	        for (int i=0;i<modes.length;i++) {
	            DisplayMode current = modes[i];
	                     
	        if ((current.getWidth() == width) && (current.getHeight() == height)) {
	            if ((targetDisplayMode == null) || (current.getFrequency() >= freq)) {
	                if ((targetDisplayMode == null) || (current.getBitsPerPixel() > targetDisplayMode.getBitsPerPixel())) {
	                targetDisplayMode = current;
	                freq = targetDisplayMode.getFrequency();
	                        }
	                    }
	 
	            // if we've found a match for bpp and frequence against the 
	            // original display mode then it's probably best to go for this one
	            // since it's most likely compatible with the monitor
	            if ((current.getBitsPerPixel() == Display.getDesktopDisplayMode().getBitsPerPixel()) &&
	                        (current.getFrequency() == Display.getDesktopDisplayMode().getFrequency())) {
	                            targetDisplayMode = current;
	                            break;
	                    }
	                }
	            }
	        } else {
	            targetDisplayMode = new DisplayMode(width,height);
	        }
	 
	        if (targetDisplayMode == null) {
	            System.out.println("Failed to find value mode: "+width+"x"+height+" fs="+fullscreen);
	            return;
	        }
	 
	        Display.setDisplayMode(targetDisplayMode);
	        Display.setFullscreen(fullscreen);
	             
	    } catch (LWJGLException e) {
	        System.out.println("Unable to setup mode "+width+"x"+height+" fullscreen="+fullscreen + e);
	    }
	}
	
	public static Screen getCurrentScreen(){
		return screens.get(screenIndex);
	}

}
