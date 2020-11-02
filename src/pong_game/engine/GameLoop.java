package pong_game.engine;

import pong_game.game.World;
import java.util.logging.Level;
import java.util.logging.Logger;
import pong_game.graphics.Renderer;

public class GameLoop {

    private static boolean running = false;

    private static int updates = 0;
    private static final int MAX_UPDATES = 5;
    private static long lastUpdateTime = 0;

    public static int targetFPS = 60;
    public static int targetTime = 1000000000 / targetFPS;

    public static void start() {
        Thread thread = new Thread() {
            public void run() {
                running = true;
                lastUpdateTime = System.nanoTime();

                while (running) {
                    long currentTime = System.nanoTime();

                    updates = 0;

                    while (currentTime - lastUpdateTime >= targetTime) {
                        World.update();
                        lastUpdateTime += targetTime;
                        updates++;
                        if (updates > MAX_UPDATES) {
                            break;
                        }
                    }
                    Renderer.render();

                    long timeTaken = System.nanoTime() - currentTime;
                    if (targetTime > timeTaken) {
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

    public static float updateDelta() {
        return 1.0f / 1000000000 * targetTime;
    }
}
