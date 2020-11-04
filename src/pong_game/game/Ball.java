package pong_game.game;


import pong_game.graphics.EventListener;
import pong_game.graphics.Graphics;

/**
 *
 * @author seishuku
 */
public class Ball {

    private float X;
    private float Y;
    private boolean moving;
    private final float limitTop;
    private final float limitBottom;
    private final float initialY;
    private String direction;

    public Ball() {
        this.initialY = -2.286f * 100;
        this.X = 0;
        this.Y = this.initialY;
        this.limitTop = -2.286f + 180f;
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

        float limitLeft = -390f;
        float limitRight = 390f;
        float padX = EventListener.paddle.getXPos();
        float padY = EventListener.paddle.getYPos();

        if (this.moving) {

            if (this.X <= -390f) {
                this.X = -390f;
            } else if (this.X >= 390f) {
                this.X = 390f;
            } else if (this.X + 150f >= limitRight) {
                this.X = this.X + (0.044f * 100);
            } else if (this.X + 150f <= limitLeft) {
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
