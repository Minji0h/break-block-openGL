package pong_game;

import pong_game.engine.GameLoop;
import pong_game.graphics.Renderer;

public class Main {

    public static void main(String[] args) {
        
        Renderer.init();
        GameLoop.start();
<<<<<<< Updated upstream
//        World.addObject(new TestPlayer());
=======
        World.addObject(new TestPlayer());
        
>>>>>>> Stashed changes
    }
}
