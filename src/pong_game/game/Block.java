package pong_game.game;

import com.jogamp.opengl.GL2;
import java.util.ArrayList;

import static pong_game.graphics.EventListener.gl;
import pong_game.graphics.Renderer;

public class Block extends GameObject {

    private final int hits;
    private static int powerUp;
    private static float posX;
    private static float posX2;
    private static float posY;
    private static float posY2;
    private static float r;
    private static float g;
    private static float b;
    public static Block bloquinho;
    public static ArrayList<Block> Blocos = new ArrayList();
    public static int positionX = -10;
    public static int positionY = -10;

    public Block(float posX, float posX2, float posY, float posY2, int powerUp) {
        hits = 0;
        this.powerUp = powerUp;
        this.posX = posX;
        this.posX2 = posX2;
        this.posY = posY;
        this.posY2 = posY2;
    }

    public static void constructor(Block Bloquinho) {
        switch (powerUp){
            case 1:
                gl.glColor3f(0.90f, 0.22f, 0.27f);
                break;
            case 2:
                gl.glColor3f(0.11f, 0.20f, 0.34f);
                break;             	
            
        }
        
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
        int powerUps = 0;

        for (int i = 0; i <= 100; i++) {
            System.out.println(positionX);
            if (positionX >= Renderer.getWindowHeight()/2) {
                positionY = positionY - 6;
                positionX = -150;
                
            }
            if(i==7 || i==10 || i == 25 || i == 35||i == 76){
                powerUps = 1;
            }
            else{
                powerUps = 2;
            }
            bloquinho = new Block(positionX, positionX + 19, positionY, positionY - 5, powerUps);
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
    public void DropaBloquinho(Block Bloquinho){
        Blocos.remove(Bloquinho);
    }

}
