/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.Input;

import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;
import pong_game.graphics.EventListener;
import pong_game.graphics.Renderer;

/**
 *
 * @author seishuku
 */
public class MouseInput implements MouseListener {

    private static int x = 0;
    private static int y = 0;

    public static int getx() {
        return x;

    }

    public static int getY() {
        return y;
    }

    public static float getWorldX() {
        return (Renderer.unitsWide / Renderer.getWindowWidth() * x - Renderer.unitsWide / 2) + Renderer.cameraX;
    }

    public static float getWorldY() {
        float unitsTall = Renderer.unitsWide * (float) ((float) Renderer.getWindowHeight() / (float) Renderer.getWindowWidth());
        return -(unitsTall / Renderer.getWindowHeight() * y - unitsTall / 2) + Renderer.cameraY;
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void mouseWheelMoved(MouseEvent e) {
    }

}
