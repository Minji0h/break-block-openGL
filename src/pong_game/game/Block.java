package pong_game.game;

import com.jogamp.opengl.GL2;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import pong_game.graphics.Animation;
import static pong_game.graphics.EventListener.gl;
import pong_game.graphics.Graphics;

public class Block extends GameObject {

    private int hits;
    private int powerUp;
    private float posX;
    private float posX2;
    private float posY;
    private float posY2;
    private float r;
    private float g;
    private float b;
    
    /**
     *
     * @param posX
     * @param posX2
     * @param posY
     * @param posY2
     */
    public Block(float posX, float posX2, float posY, float posY2) {

        this.hits = 0;
        /*
        1 - normal
        2 - speed
        3 - pad-size-increase
         */
        this.powerUp = (int) (Math.random() * ((3 - 1) + 1)) + 1;
        this.posX = posX;
        this.posX2 = posX2;
        this.posY = posY;
        this.posY2 = posY2;
        float r = (float) (Math.random() * ((1 - 0) + 1)) + 0;
        float g = (float) (Math.random() * ((1 - 0) + 1)) + 0;
        float b = (float) (Math.random() * ((1 - 0) + 1)) + 0;
    }

    public void constructor(){
        gl.glColor3f(r, g, b);
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex2f(posX, posY);
        gl.glVertex2f(posX, posY2);
        gl.glVertex2f(posX2, posY2);
        gl.glVertex2f(posX2, posY);
        gl.glEnd();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
