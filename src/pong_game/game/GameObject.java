package pong_game.game;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import pong_game.graphics.*;

/**
 *
 * @author seishuku
 */
public class GameObject {

    public float x = 0;
    public float y = 0;

    public float width = 1;
    public float height = 1;

    public float rotation = 0;

    public Animation[] animations;
    public int currentAnimation = 0;

    public void update() {

    }

    public void render() {
        Graphics.DrawBlocks();
        animations[currentAnimation].play();
        Graphics.setRotation(rotation);
        if (animations[currentAnimation].getImage() != null) {
            Graphics.drawImage(animations[currentAnimation].getImage(), x, y, width, height);
        }
        Graphics.setRotation(0);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
