package uic.cs.marvin.musictrainingsim;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


import java.awt.*;
import java.io.IOException;

public class LessonMenuController {
    public VBox Lesson1VBox;
    public VBox Lesson2VBox;

    @FXML
    private void mouseEnteredHandler(MouseEvent e){
        VBox curVBox = (VBox)(e.getSource());
        curVBox.getStyleClass().add("highlight");
    }

    @FXML
    private void mouseExitedHandler(MouseEvent e){
        VBox curVBox = (VBox)(e.getSource());
        curVBox.getStyleClass().removeAll("highlight");
        }

    @FXML
    private void playLesson1(MouseEvent e){
        System.out.println("LEsson 1 Launched!");
        VBox temp = (VBox)e.getSource();
        Stage primaryStage = (Stage) temp.getScene().getWindow();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        try {
            Parent lessonRoot = FXMLLoader.load(getClass().getResource("lesson.fxml"));
            Scene lessonScene = new Scene(lessonRoot, screenSize.getWidth() - 50, screenSize.getHeight() / 3);
            primaryStage.setScene(lessonScene);
            primaryStage.centerOnScreen();
            primaryStage.show();
        }
        catch(IOException f){
            System.out.println("Error in Lesson 1 launch");
        }

    }

    @FXML
    private void playLesson2(){System.out.println("Lesson 2 Launched!");}
}
