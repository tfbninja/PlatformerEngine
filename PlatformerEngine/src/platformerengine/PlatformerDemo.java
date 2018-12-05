package platformerengine;

import java.io.FileNotFoundException;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Tim Barber
 */
public class PlatformerDemo extends Application {

    private static final int WIDTH = 426;
    private static final int HEIGHT = 520;
    private static final String BGCOLOR = "EEEEEE";

    public void start(Stage stage) throws FileNotFoundException {
        HBox root = new HBox();

        //Creating an image
        Image player = new Image("player.png");

        PlatformerGame game = new PlatformerGame(WIDTH, HEIGHT, 50, 50, BGCOLOR, player);

        game.draw();

        root.getChildren().add(game.getCanvas());

        Scene scene = new Scene(root, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.setTitle("Platformer Demo");

        final long startNanoTime = System.nanoTime();
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;

                game.clearBG();
                game.drawPlayer();
            }
        }.start();
        stage.show();

        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                game.mouseClicked(event);
                game.draw();
                game.mouseMoved(event);
            }
        });
        /*
         * scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
         * public void handle(KeyEvent eventa) {
         * board.keyPressed(eventa);
         * board.drawBlocks();
         * }
         * });
         */

        scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent eventb) {
                game.draw();
                game.mouseMoved(eventb);

            }
        });

    }

    public static void main(String args[]) {
        launch(args);
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
