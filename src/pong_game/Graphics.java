/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game;

import com.jogamp.opengl.GL2;

/**
 *
 * @author seishuku
 */
public class Graphics {

    // cores
    private static float red = 1;
    private static float green = 1;
    private static float blue = 1;
    private static float alpha = 1;

    // rotação
    private static float rotation = 0;

    public static void fillRect(float x, float y, float width, float height) {
        GL2 gl = EventListener.gl;

        gl.glTranslatef(x, y, 0);
        gl.glRotatef(-rotation, 0, 0, 1);

        gl.glColor4f(red, green, blue, alpha);
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex2f(-width / 2, -height / 2);
        gl.glVertex2f(width / 2, -height / 2);
        gl.glVertex2f(width / 2, height / 2);
        gl.glVertex2f(-width / 2, height / 2);
        gl.glEnd();

        gl.glRotatef(rotation, 0, 0, 1);
        gl.glTranslatef(-x, -y, 0);
    }

    public static void setColor(float r, float g, float b, float a) {
        red = Math.max(0, Math.min(1, r));
        green = Math.max(0, Math.min(1, g));
        blue = Math.max(0, Math.min(1, b));
        alpha = Math.max(0, Math.min(1, a));
    }

    private static void setRotation(float r) {
        rotation = r;
    }
}
