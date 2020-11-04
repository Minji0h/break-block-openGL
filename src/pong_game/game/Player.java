package pong_game.game;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.awt.TextRenderer;
import java.awt.Color;
import java.awt.Font;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import pong_game.graphics.EventListener;
import pong_game.graphics.Renderer;

/**
 *
 * @author seishuku
 */
public class Player {

    private int life;
    public int level;
    public TextRenderer textRenderer;

    public Player() {
        this.level = 1;
        this.life = 3;
    }

    public void restartPlayer() {
        this.level = 1;
        this.life = 3;
    }

    public int getLife() {
        return this.life;
    }

    public int getLevel() {
        return this.level;
    }

    public void levelUp() {
        this.level = this.level++;
    }

    public void lifeDegree() {
        this.life = this.life--;
    }

    public void lifeAdd() {
        this.life = this.life++;
    }

    public void drawLifePoints() {
        if (EventListener.gl == null) {
            return;
        }
        GL2 gl = EventListener.gl;

        gl.glColor4f(0.5f, 0, 0, 1);
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex2f(Renderer.getWindowWidth(), Renderer.getWindowHeight());
        gl.glVertex2f(Renderer.getWindowWidth(), 200f);
        gl.glVertex2f(-Renderer.getWindowWidth(), 200f);
        gl.glVertex2f(-Renderer.getWindowWidth(), Renderer.getWindowHeight());

        gl.glEnd();
        gl.glFlush();
        textRenderer = new TextRenderer(new Font("Comic Sans MS Negrito", Font.BOLD, 30));

        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        //Retorna a largura e altura da janela
        textRenderer.beginRendering(Renderer.screenWidth, Renderer.screenHeight);
        textRenderer.setColor(Color.WHITE);
        String levelText;
        levelText = "Nivel: " + Integer.toString(level);
        textRenderer.draw(levelText, 10, Renderer.getWindowHeight() - 35);
        textRenderer.endRendering();

        textRenderer.beginRendering(Renderer.screenWidth, Renderer.screenHeight);
        textRenderer.setColor(Color.WHITE);
        String lifeText;
        lifeText = Integer.toString(life);
        textRenderer.draw(lifeText, Renderer.getWindowWidth() - 30, Renderer.getWindowHeight() - 35);
        textRenderer.endRendering();
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        gl.glFlush();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
