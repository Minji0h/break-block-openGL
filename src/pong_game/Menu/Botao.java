
package pong_game.Menu;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.awt.TextRenderer;
import java.awt.Color;
import java.awt.Font;
import static pong_game.graphics.EventListener.gl;
import pong_game.graphics.Renderer;


public class Botao {
    public float pontoX;
    public float pontoY;
    public float pontoX2;
    public float pontoY2;
    public int posX;
    public int posY;
    public String texto;
    
    public void Botao(){
        if(texto == "Continuar"){
        gl.glColor3f(1f, 0.85f, 0.34f);
        }else{
        gl.glColor3f(0.99f, 0.99f, 0.21f);
        }
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex2f(pontoX, pontoY);
        gl.glVertex2f(pontoX, pontoY2);
        gl.glVertex2f(pontoX2, pontoY2);
        gl.glVertex2f(pontoX2, pontoY);
        gl.glEnd();
        TextRenderer textRenderer = new TextRenderer(new Font("Comic Sans MS Negrito", Font.BOLD, 20));
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        textRenderer.beginRendering(Renderer.screenWidth, Renderer.screenHeight);
        textRenderer.setColor(Color.WHITE);
        textRenderer.draw(texto,posX ,posY);
        textRenderer.endRendering();
    }
    public float[] getPontos(){
        float vet[] = new float[4];
        vet[0] = pontoX;
        vet[1] = pontoX2;
        vet[2] = pontoY;
        vet[3] = pontoY2;
        return vet;
    }
}
