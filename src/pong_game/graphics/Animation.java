package pong_game.graphics;

import pong_game.resource.ImageResource;

/**
 *
 * @author seishuku
 */
public class Animation {

    public ImageResource[] frames;

    public int currentFrame = 0;

    public int fps = 8;

    private long lastFrameTime = 0;

    public boolean loop = true;

    public void play() {
        long currentTime = System.nanoTime();

        if (currentTime > lastFrameTime + 1000000000 / fps) {
            currentFrame++;
            if (frames != null) {
                if (currentFrame >= frames.length) {

                    if (loop) {
                        currentFrame = 0;
                    } else {
                        currentFrame--;
                    }
                    lastFrameTime = currentTime;

                }
            }
        }
    }

    public ImageResource getImage() {
        if (frames != null) {
            return frames[currentFrame];
        } else {
            return null;
        }
    }
}
