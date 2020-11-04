package pong_game.game;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import pong_game.graphics.Animation;
import pong_game.graphics.Graphics;

/**
 *
 * @author seishuku
 */
public class Block extends GameObject {

    private int hits;
    private int powerUp;
    private float x;
    private float y;

    public Block(float xPos, float yPos) {

        this.hits = 0;
        /*
        1 - normal
        2 - speed
        3 - pad-size-increase
         */
        this.powerUp = (int) (Math.random() * ((3 - 1) + 1)) + 1;
        this.x = xPos;
        this.y = yPos;
        float r = (float) (Math.random() * ((1 - 0) + 1)) + 0;
        float g = (float) (Math.random() * ((1 - 0) + 1)) + 0;
        float b = (float) (Math.random() * ((1 - 0) + 1)) + 0;
        Graphics.setColor(r, g, b, 1);
        Graphics.fillRect(this.x, this.y, 0.9f, 0.5f);

    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
