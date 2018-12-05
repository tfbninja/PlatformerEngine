package platformerengine;

//import javafx.application.Application;
//import javafx.event.EventHandler;
//import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 *
 * @author Tim Barber
 */
public class PlatformerGame {

    private int playerX;
    private int playerY;
    private Image playerIcon;

    private Canvas canvas;
    private int width;
    private int height;

    private String bgColor;

    public PlatformerGame() {
        playerX = 0;
        playerY = 0;

        bgColor = "FFFFFF";
    }

    public PlatformerGame(int width, int height, int playerXPos, int playerYPos, String BGCOLOR, Image playerImage) {
        // Player attributes
        this.playerX = playerXPos;
        this.playerY = playerYPos;
        this.playerIcon = playerImage;

        // Canvas attributes
        this.width = width;
        this.height = height;
        canvas = new Canvas(width, height);
        bgColor = BGCOLOR;

    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void clearBG() {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // draw background
        gc.setFill(Color.web(this.bgColor));
        gc.fillRect(0, 0, width, height);
    }

    public void drawPlayer() {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // draw player
        gc.drawImage(playerIcon, playerX, playerY);
    }

    public void draw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.drawImage(playerIcon, playerX, playerY);

    }

    public void keyPressed(KeyEvent k) {

    }

    public void mouseClicked(MouseEvent m) {

    }

    public void mouseMoved(MouseEvent m) {

    }
}


/*
 * The MIT License
 *
 * Copyright (c) 2018 Tim Barber.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
