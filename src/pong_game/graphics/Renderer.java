package pong_game.graphics;

import pong_game.Input.*;
import com.jogamp.newt.event.WindowAdapter;
import com.jogamp.newt.event.WindowEvent;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.*;
import pong_game.Menu.Menu;

/**
 *
 * @author seishuku
 */
public class Renderer {

    private static GLWindow window = null;
    public static int screenWidth = 640;
    public static int screenHeight = 360;

    public static float unitsWide = 300;

    public static float unitsWide = 1000;

    private static GLProfile profile = GLProfile.get(GLProfile.GL2);

    public static float cameraX = 0;
    public static float cameraY = 0;

    //Cria a janela de rendeziracao do JOGL
    public static void init() {
        GLProfile.initSingleton();
        profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities caps = new GLCapabilities(profile);
        window = GLWindow.create(caps);
        window.setSize(screenWidth, screenHeight);
        window.setResizable(false);
        window.addGLEventListener(new EventListener());
        window.addMouseListener(new MouseInput());
        window.addKeyListener(new KeyInput());

        window.requestFocus();


        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowDestroyNotify(WindowEvent e) {
                System.exit(0);
            }
        });

      
        window.setVisible(true);

    }

    public static void render() {
        if (window == null) {
            return;
        }
        window.display();
    }

    public static GLProfile getProfile() {
        return profile;
    }

    public static int getWindowWidth() {
        return window.getWidth();

    }

    public static int getWindowHeight() {
        return window.getHeight();
    }

}
