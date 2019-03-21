package uic.cs.marvin.musictrainingsim;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class OptionsController {

    public Label fullscreenLabel;

    @FXML
    private void mouseEnteredHandler()
    {
        fullscreenLabel.getStyleClass().add("hover");
    }

    @FXML
    private void mouseExitedHandler()
    {
        fullscreenLabel.getStyleClass().removeAll("hover");
    }

    @FXML
    private void setFullscreen()
    {
        Stage stage = (Stage) fullscreenLabel.getScene().getWindow();

        boolean isFullscreen = stage.isFullScreen();

        stage.setFullScreen(!isFullscreen);
        Options.toggleFullscreen();
    }
}
