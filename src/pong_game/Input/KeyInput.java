package pong_game.Input;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;

/**
 *
 * @author seishuku
 */
public class KeyInput implements KeyListener {

    private static boolean[] keys = new boolean[256];

    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    public static boolean getKey(int keyCode) {
        return keys[keyCode];
    }

}
