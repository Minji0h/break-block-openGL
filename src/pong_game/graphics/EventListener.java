package pong_game.graphics;

import OPGL_Game.World;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import pong_game.resource.ImageResource;

/**
 *
 * @author seishuku
 */
public class EventListener implements GLEventListener {

    public static GL2 gl = null;
    public static ImageResource image = null;

    public void init(GLAutoDrawable drawable) {
        gl = drawable.getGL().getGL2();
        gl.glClearColor(0, 0, 0, 1);
        gl.glEnable(GL2.GL_TEXTURE_2D);
        image = new ImageResource("../res/ball.jpg");
    }

    public void dispose(GLAutoDrawable drawable) {
    }

    public void display(GLAutoDrawable drawable) {
        gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        World.render();

//        Graphics.setColor(0, 1, 0, 1);
//        Graphics.fillRect(1, 0, 1, 1);
//        for (int i = 0; i < 1000; i++) {
//            Random rand = new Random();
//            float x = rand.nextInt(5);
//            float y = rand.nextInt(5);
//            float width = rand.nextFloat();
//            float height = rand.nextFloat();
//
//            Graphics.fillRect(x, y, width, height);
//
//        }
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
