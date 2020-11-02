/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game;

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

    //Cria a janela de rendeziracao do JOGL
    public static void init() {
        GLProfile.initSingleton();
        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities caps = new GLCapabilities(profile);
        window = GLWindow.create(caps);
        window.setSize(screenWidth, screenHeight);
        //window.setResizable(false);
        //window.setFullscreen(true);

        //Habilita o teclado : cena
        window.addGLEventListener(new EventListener());

        //window.requestFocus();
        FPSAnimator animator = new FPSAnimator(window, 60);
        animator.start(); //inicia o loop de animacao

        //encerrar a aplicacao adequadamente
        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowDestroyNotify(WindowEvent e) {
                animator.stop();
                System.exit(0);
            }
        });

        //window.setFullscreen(true);        
        window.setVisible(true);
    }

    public static int getWindowWidth() {
        return window.getWidth();

    }

    public static int getWindowHeight() {
        return window.getHeight();

    }

    public static void main(String[] args) {
        init();
    }
}
