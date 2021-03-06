import ch.hevs.gdx2d.components.screen_management.RenderingScreen;
import ch.hevs.gdx2d.desktop.PortableApplication;
import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.ScreenManager;
import ch.hevs.gdx2d.lib.utils.Logger;
import com.badlogic.gdx.InputMultiplexer;


public class ScreenHub extends PortableApplication{
	
		static ScreenManager s = new ScreenManager();

		ScreenHub(){
			super(2000, 1000);
		}
	
	    public void onInit() {
	        setTitle("G E O M E T R Y || D A S H");
	        
	        s.registerScreen(MenuWindow.class);
	        s.registerScreen(GameWindow.class);
	        s.registerScreen(GameOverWindow.class);
	        s.registerScreen(ControlMenu.class);
	    }
	    
	    public void onGraphicRender(GdxGraphics g) {
	        s.render(g); 
	    }
	
	    public void onClick(int x, int y, int button) {
	    	// Delegate the click to the child class
	    	RenderingScreen activeScreen = s.getActiveScreen();
	    	if (activeScreen != null)
	    		activeScreen.onClick(x, y, button);
	    }
	 
	    public void onKeyDown(int keycode) {
	    	// Delegate the onKeyDown to the child class
	    	RenderingScreen activeScreen = s.getActiveScreen();
	    	if (activeScreen != null)
	    		activeScreen.onKeyDown(keycode);
	    }
	    
	    public static void main(String[] args) {
	        new ScreenHub();
	    }
}
