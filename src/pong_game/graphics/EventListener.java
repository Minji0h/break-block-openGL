package pong_game.graphics;

import pong_game.game.*;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.util.gl2.GLUT;
import pong_game.Menu.Botao;
import pong_game.Menu.Menu;
import pong_game.game.Player;

import pong_game.game.*;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import pong_game.resource.ImageResource;

/**
 *
 * @author seishuku
 */
public class EventListener implements GLEventListener {

    public static GL2 gl = null;
    public static ImageResource image = null;
    public static int op = 0;
    Player player = new Player();

    public static Paddle paddle = new Paddle();
    public static Ball ball = new Ball();
    //public static Block bloquinho = new Block();

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

    @Override
    public void display(GLAutoDrawable drawable) {
        gl = drawable.getGL().getGL2();
        GLUT glut = new GLUT();
        gl.glClearColor(1, 1, 1, 1);
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity(); //ler a matriz identidade

        switch (op) {
            case 0:
                gl.glClearColor(0, 0, 0, 1);
                gl.glPushMatrix();
                gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
                gl.glColor3f(1, 0, 1);
                gl.glPointSize(5);
                Menu.CarregaMenu();
                gl.glFlush();
                break;
            case 1:
                gl.glClearColor(0, 0, 0, 1);
                gl.glPushMatrix();

                gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);

                gl.glClear(GL2.GL_COLOR_BUFFER_BIT);

                gl.glTranslatef(-Renderer.cameraX, -Renderer.cameraY, 0);
                gl.glTranslatef(Renderer.cameraX, Renderer.cameraY, 0);
                World.render();
                player.drawLifePoints();
                paddle.drawPaddle();
                ball.drawBall();

                Block.ConstroiOsBloquinho();

                break;
            case 2:
                System.out.println("SAIR");
                break;
            case 3:
                System.out.println("CARALHO");
                break;
        }
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        gl = drawable.getGL().getGL2();
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();

        float unitsTall = Renderer.getWindowHeight() / (Renderer.getWindowWidth() / Renderer.unitsWide);

        gl.glOrtho(-Renderer.unitsWide / 2, Renderer.unitsWide / 2, -unitsTall / 2, unitsTall / 2, -1, 1);
        gl.glMatrixMode(GL2.GL_MODELVIEW);

    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
