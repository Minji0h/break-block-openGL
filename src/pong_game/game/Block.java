package pong_game.game;

import com.jogamp.opengl.GL2;
import java.util.ArrayList;

import static pong_game.graphics.EventListener.gl;

public class Block extends GameObject {

    private int hits;
    private int powerUp;
    private static float posX;
    private static float posX2;
    private static float posY;
    private static float posY2;
    private static float r;
    private static float g;
    private static float b;
    public static Block bloquinho;
    public static ArrayList Blocos = new ArrayList();
    public static int positionX = -10;
    public static int positionY = -10;

    public Block(float posX, float posX2, float posY, float posY2) {
        hits = 0;
        powerUp = (int) (Math.random() * ((3 - 1) + 1)) + 1;
        this.posX = posX;
        this.posX2 = posX2;
        this.posY = posY;
        this.posY2 = posY2;
        float r = (float) (Math.random() * ((1 - 0) + 1)) + 0;
        float g = (float) (Math.random() * ((1 - 0) + 1)) + 0;
        float b = (float) (Math.random() * ((1 - 0) + 1)) + 0;
    }

    public int getHits() {
        return hits;
    }

    public static float getPosX() {
        return posX;
    }

    public static float getPosX2() {
        return posX2;
    }

    public static float getPosY() {
        return posY;
    }

    public static float getPosY2() {
        return posY2;
    }

    public static float getR() {
        return r;
    }

    public static float getG() {
        return g;
    }

    public static float getB() {
        return b;
    }

    public static void constructor(Block Bloquinho) {
        gl.glColor3f(1, 0, 1);
        //gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex2f(Bloquinho.posX, Bloquinho.posY);
        gl.glVertex2f(Bloquinho.posX, Bloquinho.posY2);
        gl.glVertex2f(Bloquinho.posX2, Bloquinho.posY2);
        gl.glVertex2f(Bloquinho.posX2, Bloquinho.posY);
        gl.glEnd();
    }
    public static void ConstroiOsBloquinho(){
        
        
          
           bloquinho = new Block(positionX,positionX+16,positionY, positionY + 8);
           positionX = positionX + 17;
           constructor(bloquinho);
           Blocos.add(bloquinho);

        
    }

}
