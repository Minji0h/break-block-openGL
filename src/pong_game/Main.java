package pong_game;

import pong_game.game.World;
import pong_game.test.TestPlayer;
import pong_game.engine.GameLoop;
import pong_game.graphics.Renderer;

/**
 *
 * @author seishuku
 */
public class Main {

    public static void main(String[] args) {
        Renderer.init();
        GameLoop.start();

        //TEST
        World.addObject(new TestPlayer());
    }
}
