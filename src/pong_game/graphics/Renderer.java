package pong_game.graphics;

import pong_game.Input.MouseInput;
import pong_game.graphics.EventListener;
import com.jogamp.newt.event.WindowAdapter;
import com.jogamp.newt.event.WindowEvent;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.FPSAnimator;

/**
 *
 * @author seishuku
 */
public class Renderer {

    private static GLWindow window = null;
    public static int screenWidth = 640;
    public static int screenHeight = 360;

    public static float unitsWide = 10;
    private static GLProfile profile = GLProfile.get(GLProfile.GL2);

    //Cria a janela de rendeziracao do JOGL
    public static void init() {
        GLProfile.initSingleton();
        profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities caps = new GLCapabilities(profile);
        window = GLWindow.create(caps);
        window.setSize(screenWidth, screenHeight);
        //window.setResizable(false);
        //window.setFullscreen(true);

        //Habilita o teclado : cena
        window.addGLEventListener(new EventListener());
        window.addMouseListener(new MouseInput());
                
        window.requestFocus();
//        FPSAnimator animator = new FPSAnimator(window, 60);
//        animator.start(); //inicia o loop de animacao

        //encerrar a aplicacao adequadamente
        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowDestroyNotify(WindowEvent e) {
//                animator.stop();
                System.exit(0);
            }
        });

        //window.setFullscreen(true);        
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
