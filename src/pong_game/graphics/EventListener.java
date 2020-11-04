package pong_game.graphics;


import pong_game.game.*;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import pong_game.Menu.Botao;
import pong_game.Menu.Menu;
import pong_game.game.Player;

import pong_game.resource.ImageResource;

/**
 *
 * @author seishuku
 */
public class EventListener implements GLEventListener {

    public static GL2 gl = null;
    public static ImageResource image = null;
    Player player = new Player();

    public static Paddle paddle = new Paddle();

    public Botao Iniciar;
    public Botao Continuar;
    public Botao Regras;
    public Botao Sair;
    public float mouseX = 0;
    public float mouseY = 0;
    public int larguraFrame;
    public int alturaFrame;



    public void init(GLAutoDrawable drawable) {
        gl = drawable.getGL().getGL2();
        gl.glClearColor(0, 0, 0, 1);
        gl.glEnable(GL2.GL_TEXTURE_2D);
        gl.glEnable(GL2.GL_BLEND);
        gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
    }

    public void dispose(GLAutoDrawable drawable) {
    }

    public void display(GLAutoDrawable drawable) {
        gl = drawable.getGL().getGL2();

        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        gl.glTranslatef(-Renderer.cameraX, -Renderer.cameraY, 0);
        World.render();
        gl.glTranslatef(Renderer.cameraX, Renderer.cameraY, 0);
        player.drawLifePoints();
        paddle.drawPaddle();

        gl.glClearColor(0, 0, 0, 1);
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity(); //lê a matriz identidade
        gl.glColor3f(1, 0, 1);
        gl.glPointSize(5);
        Menu.CarregaMenu();
        gl.glFlush();



    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        gl = drawable.getGL().getGL2();
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();

        float unitsTall = Renderer.getWindowHeight() / (Renderer.getWindowWidth() / Renderer.unitsWide);

        gl.glOrtho(-Renderer.unitsWide / 2, Renderer.unitsWide / 2, -unitsTall / 2, unitsTall / 2, -1, 1);
        gl.glMatrixMode(GL2.GL_MODELVIEW);

    }
}
