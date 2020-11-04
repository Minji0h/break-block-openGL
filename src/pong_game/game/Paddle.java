/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.game;


import pong_game.Input.MouseInput;
import pong_game.graphics.Graphics;
import pong_game.graphics.Renderer;

/**
 *
 * @author seishuku
 */
public class Paddle {

    private float xPos;
    private float yPos;
    private float height;
    private float width;

    public Paddle() {
        this.xPos = 0;
        this.yPos = -70.5f;
        this.height = 5f;
        this.width = 100f;
    }

    public float getHeight() {
        return this.height;
    }

    public float getWidth() {
        return this.width;
    }

    public void drawPaddle() {
//        Graphics.setColor(0.196078f, 0.8f, 0.6f, 1);
        Graphics.setColor(1, 1, 0, 1);

        Graphics.createPaddle(this.xPos, this.yPos, this.width, this.height);
    }

    public float getXPos() {
        return this.xPos;
    }

    public float getYPos() {
        return this.yPos;
    }

    public void setXPos(float x) {
        this.xPos = x;
    }

    public void setYPos(float y) {
        this.yPos = y;
    }

    public void setWidth(float w) {
        this.width = w;
    }

    public void update(float x) {
        if (x > 95f) {
            return;
        } else if (x < -(95f)) {
            return;
        }
        this.xPos = x;
        System.out.println(xPos);
    }

}
