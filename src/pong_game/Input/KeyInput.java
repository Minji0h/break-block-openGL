package pong_game.Input;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import pong_game.graphics.EventListener;

/**
 *
 * @author seishuku
 */
public class KeyInput implements KeyListener {

    private static boolean[] keys = new boolean[256];

    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        if (EventListener.paddle != null) {
            float xpos = 0;
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    xpos = (float) EventListener.paddle.getXPos();
                    EventListener.paddle.update((float) xpos - (0.1f * 100));
                    break;
                case KeyEvent.VK_RIGHT:
                    xpos = (float) EventListener.paddle.getXPos();
                    EventListener.paddle.update((float) xpos + (0.1f * 100));
                    break;
                case KeyEvent.VK_SPACE:
                    if (!EventListener.ball.checkMoving() && EventListener.op == 1) {
                        EventListener.ball.changeMoveStatus();
                        System.out.println(EventListener.ball.toString());
                        break;
                    }
            }
        }

    }

    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    public static boolean getKey(int keyCode) {
        return keys[keyCode];
    }

}
