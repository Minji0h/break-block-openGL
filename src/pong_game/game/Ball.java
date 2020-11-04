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
    private float limitTop;
    private float limitBottom;
    private float initialY;
    private String directionVertical;
    private String directionHorizontal;

    public Ball() {
        this.initialY = -62.5f;
        this.X = 0;
        this.Y = this.initialY;
        this.limitTop = -60.286f;
        this.limitBottom = 0;
        this.directionVertical = null;
        this.directionHorizontal = null;
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
        this.directionVertical = "up";
        int rand = (int) Math.random() + 99;
        if (rand > 0) {
            this.directionHorizontal = "right";
        } else {
            this.directionHorizontal = "left";
        }

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
        if (this.moving) {
            String col = verifyColision();
            if (col != "Nop") {
                if (col == "right") {
                    this.directionHorizontal = "left";
                } else if (col == "left") {
                    this.directionHorizontal = "right";
                } else if (col == "paddle right") {
                    this.directionVertical = "up";
                    this.directionHorizontal = "right";

                } else if (col == "paddle left") {
                    this.directionVertical = "up";
                    this.directionHorizontal = "left";
                } else if (col == "top right") {
                    this.directionHorizontal = "left";
                    this.directionVertical = "down";
                } else if (col == "top left") {
                    this.directionHorizontal = "right";
                    this.directionVertical = "down";
                } else if (col == "bottom") {
                    this.directionVertical = "down";

                } else if (col == "top") {
                    this.directionVertical = "down";
                    int rand = (int) Math.random();
                    if (rand == 1) {
                        this.directionHorizontal = "right";
                    } else {
                        this.directionHorizontal = "left";
                    }
                }
            }
            if (this.directionHorizontal == "right") {
                this.X = this.X + 0.5f;
            } else if (this.directionHorizontal == "left") {
                this.X = this.X - 0.5f;
            }
            if (this.directionVertical == "down") {
                this.Y = this.Y - 0.5f;
            } else if (this.directionVertical == "up") {
                this.Y = this.Y + 0.5f;
            }
        } else {
            this.X = EventListener.paddle.getXPos();
        }
    }

    private String verifyColision() {
        float paddleX = EventListener.paddle.getXPos();
        float paddleY = EventListener.paddle.getYPos();
        float paddleWidth = EventListener.paddle.getWidth();
        float paddleHeight = EventListener.paddle.getHeight() / 2;
        if ((this.Y == paddleY + (paddleHeight * 2))) {
            if (this.X <= paddleX + paddleWidth) {
                if (this.X >= paddleX - paddleWidth) {
                    if (this.X > paddleX - paddleWidth && this.X < paddleX) {
                        return "paddle left";
                    }
                    if (this.X < paddleX + paddleWidth && this.X > paddleX) {
                        return "paddle right";

                    }
                }
            }
        } else if (this.X == 95f) {
            return "right";
        } else if (this.X == -95f) {
            return "left";
        } else if (this.Y == 60f && this.X == 95f) {
            return "top right";
        } else if (this.Y == 60f && this.X == -95f) {
            return "top left";
        } else if (this.Y > -(paddleY + paddleHeight)) {
            return "bottom";
        } else if (this.Y == 70f) {
            return "top";
        }

        return "Nop";

    }
}
