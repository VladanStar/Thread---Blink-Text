package flashtext0102;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FlashText0102 extends Application {

    private String text = " ";

    @Override
    public void start(Stage primaryStage) {

        StackPane pane = new StackPane();
        Label lblText = new Label("Programing is fun");  // create label
        pane.getChildren().add(lblText);                // add label in pane

        // create thread
        new Thread(new Runnable() {
            
            // run thread
            @Override
            public void run() {

                try {
                    while (true) {
                        if (lblText.getText().trim().length() == 0) {
                            text = "Welcome";  // change text
                        } else {
                            text = "";
                        }
                        Platform.runLater(new Runnable() { // Platform runLater
                            @Override
                            public void run() {
                                lblText.setText(text); // update GUI
                            }
                        });
                        Thread.sleep(500); // sleep
                    }

                } catch (InterruptedException ex) {
                    ex.getStackTrace();
                }
            }
        }).start();

        Scene scene = new Scene(pane, 300, 250);

        primaryStage.setTitle("FlashText!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }

}
