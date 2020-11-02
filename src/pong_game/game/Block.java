package pong_game.game;

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
        Graphics.setColor(0.5f, 0, 0, 1);
        Graphics.fillRect(this.x, this.y, 0.9f, 0.5f);

    }

}
