package pong_game.game;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import pong_game.graphics.EventListener;
import pong_game.graphics.Graphics;
import pong_game.graphics.Renderer;

/**
 *
 * @author seishuku
 */
public class Ball {

    private float X;
    private float Y;
    private boolean moving;
    private float limitTop;
    private float limitBottom;
    private float initialY;
    private String direction;

    public Ball() {
        this.initialY = -62.5f;
        this.X = 0;
        this.Y = this.initialY;
        this.limitTop = -60.286f;
        this.limitBottom = 0;
        this.direction = null;
        this.moving = false;

    }

    public void drawBall() {
        Graphics.setColor(1, 1, 1, 1);
        Graphics.createBall(this.getX(), this.getY());
    }

    public boolean checkMoving() {
        return this.moving;
    }

    public void changeMoveStatus() {
        this.moving = !this.moving;
        this.direction = "up";

    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public float getX() {
        return X;
    }

    public void setX(float X) {
        this.X = X;
    }

    public float getY() {
        return Y;
    }

    public void setY(float Y) {
        this.Y = Y;
    }

    public void movingBall() {

        float limitLeft = -95f;
        float limitRight = 95f;
        float padX = EventListener.paddle.getXPos();
        float padY = EventListener.paddle.getYPos();

        if (this.moving) {

            if (this.X <= -390f) {
                this.X = -390f;
            } else if (this.X >= 390f) {
                this.X = 390f;
            } else if (this.X + 5f >= limitRight) {
                this.X = this.X + (0.044f * 100);
            } else if (this.X + 5f <= limitLeft) {
                this.X = this.X - (0.044f * 100);
            }
            if (this.Y <= initialY - 100) {
                this.Y = initialY;
            } else if (this.Y >= initialY) {
                this.Y = this.Y + (0.044f * 100);
            }

        } else {
            this.X = EventListener.paddle.getXPos();
        }
    }
}
