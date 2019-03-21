package uic.cs.marvin.musictrainingsim;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private void mouseEnteredHandler(MouseEvent e){
        Label curLabel = (Label)(e.getSource());
        curLabel.getStyleClass().add("highlight");
    }

    @FXML
    private void mouseExitedHandler(MouseEvent e){
        Label curLabel = (Label)(e.getSource());
        curLabel.getStyleClass().removeAll("highlight");
    }

    @FXML
    private void launchLessonMenu(MouseEvent e){
        Label curLabel = (Label)(e.getSource());
        Stage stage = (Stage)curLabel.getScene().getWindow();
    }

    private void launchFreePlay(){

    }

    private void launchOptions(){

    }

    private void exit(){

    }
}
