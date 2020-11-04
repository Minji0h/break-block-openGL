package pong_game;

import pong_game.engine.GameLoop;
import pong_game.game.World;
import pong_game.graphics.Renderer;
import pong_game.test.TestPlayer;

public class Main {

    public static void main(String[] args) {
        
        Renderer.init();
        GameLoop.start();

//        World.addObject(new TestPlayer());
        World.addObject(new TestPlayer());
        

    }
}
