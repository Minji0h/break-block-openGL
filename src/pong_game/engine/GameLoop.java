package pong_game.engine;

import OPGL_Game.World;
import java.util.logging.Level;
import java.util.logging.Logger;
import pong_game.graphics.Renderer;

public class GameLoop {

    private static boolean running = false;
    public static int targetFPS = 60;
    public static int targetTime = 1000000000 / targetFPS;

    public static void start() {
        Thread thread = new Thread() {
            public void run() {
                running = true;

                while (running) {
                    long startTime = System.nanoTime();

                    World.update();

                    Renderer.render();

                    long timeTaken = System.nanoTime() - startTime;
                    if (timeTaken < targetTime) {
                        try {
                            Thread.sleep((targetTime - timeTaken) / 1000000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(GameLoop.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        };
        thread.setName("Game Loop");
        thread.start();
    }
}
