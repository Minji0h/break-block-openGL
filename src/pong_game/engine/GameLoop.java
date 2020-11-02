package pong_game.engine;

import OPGL_Game.World;
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

                int fps = 0;

                long lastFpsCheck = System.nanoTime();

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
                    fps++;
                    if (System.nanoTime() >= lastFpsCheck + 100000000) {
                        System.out.println(fps);
                        fps = 0;
                        lastFpsCheck = System.nanoTime();

                    }
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
}
