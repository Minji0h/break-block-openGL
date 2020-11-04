package pong_game.test;

import com.jogamp.newt.event.KeyEvent;
import pong_game.Input.KeyInput;
import pong_game.Input.MouseInput;
import pong_game.engine.GameLoop;
import pong_game.game.GameObject;
import pong_game.graphics.*;
import pong_game.resource.ImageResource;

/**
 *
 * @author seishuku
 */
public class TestPlayer extends GameObject {

    public float runSpeed = 2.0f;

    public TestPlayer() {
 
        //
        animations = new Animation[1];
        //
        animations[0] = new Animation();
        //
        animations[0].frames = new ImageResource[1];
//        animations[0].frames[0] = new ImageResource("../res/paper_ball.png");
//        animations[0].frames[1] = new ImageResource("../res/ball_1.jpg");

    }

    public void update() {

        float xInput = 0;
        float yInput = 0;

        if (KeyInput.getKey(KeyEvent.VK_LEFT)) {
            xInput--;
        }
        if (KeyInput.getKey(KeyEvent.VK_RIGHT)) {
            xInput++;
        }
        if (KeyInput.getKey(KeyEvent.VK_UP)) {
            yInput++;
        }
        if (KeyInput.getKey(KeyEvent.VK_DOWN)) {
            yInput--;
        }

        x += xInput * runSpeed * GameLoop.updateDelta();
        y += yInput * runSpeed * GameLoop.updateDelta();

//        Renderer.cameraX = x;
//        Renderer.cameraY = y;

        rotation = (float) Math.toDegrees(Math.atan2(MouseInput.getWorldX() - x, MouseInput.getWorldY() - y));

    }

}
