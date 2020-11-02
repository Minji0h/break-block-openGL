package pong_game.game;

import pong_game.game.GameObject;
import java.util.ArrayList;
import pong_game.graphics.Renderer;

/**
 *
 * @author seishuku
 */
public class World {

    private static ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
    private static ArrayList<Block> blocks = new ArrayList<Block>();
    private static float maxHeight = Renderer.getWindowHeight() - 50;
    private static float maxWidth = Renderer.getWindowWidth() - 50;

    ;

    public static void update() {

        for (GameObject go : gameObjects) {
            go.update();
        }

    }

    public static void render() {
        for (GameObject go : gameObjects) {
            go.render();
        }

        Player player = new Player();
        player.drawLifePoints();

        for (float i = 0; i < 100; i++) {
            float height = maxHeight % 3;
            Block block = new Block((maxWidth - 0.9f) - i, 0);
            blocks.add(block);
        }
    }

    public static void addObject(GameObject go) {
        gameObjects.add(go);
    }
}
