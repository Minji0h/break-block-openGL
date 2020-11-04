package pong_game.game;

import com.jogamp.opengl.GL2;
import java.util.ArrayList;

import static pong_game.graphics.EventListener.gl;
import pong_game.graphics.Renderer;

public class Block extends GameObject {

    private final int hits;
    private final int powerUp;
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

    public static void ConstroiOsBloquinho() {
        positionX = -150;
        positionY = 55;

        for (int i = 0; i <= 200; i++) {
            if (positionX > Renderer.getWindowHeight()) {
                positionY = positionY - 6;
                positionX = -150;
            }
            bloquinho = new Block(positionX, positionX + 19, positionY, positionY - 5);
            positionX = positionX + 20;
            constructor(bloquinho);
            Blocos.add(bloquinho);
        }

    }
    public float[] getPontos(){
        float vet[] = new float[4];
        vet[0] = posX;
        vet[1] = posX2;
        vet[2] = posY;
        vet[3] = posY2;
        return vet;
    }

}
