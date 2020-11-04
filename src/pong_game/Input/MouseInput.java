/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_game.Input;
import pong_game.Input.*;
import pong_game.graphics.EventListener;
import com.jogamp.newt.event.WindowAdapter;
import com.jogamp.newt.event.WindowEvent;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.*;
import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;
import static com.jogamp.opengl.GLProfile.GL2;
import pong_game.Menu.Menu;
import pong_game.game.World;
import static pong_game.graphics.EventListener.gl;
import static pong_game.graphics.EventListener.paddle;

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

    @Override
    public void mouseClicked(MouseEvent e) {
        int botao = e.getButton();

        if (botao == MouseEvent.BUTTON1) {
            float tx;
            float ty;

            float IniciarPos[] = Menu.Iniciar.getPontos();
            float ContinuarPos[] = Menu.Continuar.getPontos();
            float RegrasPos[] = Menu.Regras.getPontos();
            float SairPos[] = Menu.Sair.getPontos();

            Menu.mouseX = (float) e.getX();
            Menu.mouseY = (float) e.getY();

            float unitsTall = Renderer.getWindowHeight() / (Renderer.getWindowWidth() / Renderer.unitsWide);

            tx = ((2 * (Renderer.unitsWide / 2) * Menu.mouseX) / Renderer.getWindowWidth()) - (Renderer.unitsWide / 2);
            ty = (((2 * (unitsTall / 2)) * (Menu.mouseY - Renderer.getWindowHeight())) / -Renderer.getWindowHeight()) - (unitsTall / 2);

            System.out.println(tx >= IniciarPos[0] && tx <= IniciarPos[1]);
            System.out.println(ty <= IniciarPos[2]);
            System.out.println(ty);
            System.out.println(IniciarPos[2]);

            if (tx >= IniciarPos[0] && tx <= IniciarPos[1] && ty <= IniciarPos[2] && ty >= IniciarPos[3]) {
                gl.glTranslatef(-Renderer.cameraX, -Renderer.cameraY, 0);
                World.render();
                gl.glTranslatef(Renderer.cameraX, Renderer.cameraY, 0);
                //player.drawLifePoints();
                paddle.drawPaddle();
                //ball.drawBall();
            } else if (tx >= ContinuarPos[0] && tx <= ContinuarPos[1] && ty <= ContinuarPos[2] && ty >= ContinuarPos[3]) {
                System.out.println("Botão 2");
            } else if (tx >= RegrasPos[0] && ty <= RegrasPos[1] && ty <= RegrasPos[2] && ty >= RegrasPos[3]) {
                System.out.println("Botão 3");
            } else if (tx >= SairPos[0] && tx <= SairPos[1] && ty <= SairPos[2] && ty >= SairPos[3]) {
                System.exit(0);
            }

        }
    }

    @Override
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
