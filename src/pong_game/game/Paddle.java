/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.game;

import pong_game.Input.MouseInput;
import pong_game.graphics.Graphics;

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
        this.yPos = -2.5f;
        this.height = 0.3f;
        this.width = 2f;
    }

    public void drawPaddle() {
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
        this.xPos = x;
    }
}
