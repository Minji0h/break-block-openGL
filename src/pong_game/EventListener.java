/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

/**
 *
 * @author seishuku
 */
public class EventListener implements GLEventListener {

    public void init(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClearColor(0, 0, 0, 1);
    }

    public void dispose(GLAutoDrawable drawable) {
    }

    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        gl.glColor3f(0, 0, 1);
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex2f(-1, -1f);
        gl.glVertex2f(1f, -1f);
        gl.glVertex2f(1f, 1f);
        gl.glVertex2f(-1f, 1f);
        gl.glEnd();
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();

        float unitsTall = Renderer.getWindowHeight() / (Renderer.getWindowWidth() / Renderer.unitsWide);

        gl.glOrtho(-Renderer.unitsWide / 2, Renderer.unitsWide / 2, -unitsTall / 2, unitsTall / 2, -1, 1);
        gl.glMatrixMode(GL2.GL_MODELVIEW);

    }

}
