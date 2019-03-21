package uic.cs.marvin.musictrainingsim;
import uic.cs.marvin.musictrainingsim.music.*;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.HashMap;

public class LessonController {

    public GridPane grid;
    private HashMap<String,Integer> keyMap;

    private String chooseKeyNote(int index){
        if(index >= 7)
            index = index-7;
        switch(index) {
            case 0:
                return "C";
            case 1:
                return "D";
            case 2:
                return "E";
            case 3:
                return "F";
            case 4:
                return "G";
            case 5:
                return "A";
            case 6:
                return "B";
            default: return "X";
        }
    }

    private String getKeyMap(int index){
        switch(index){
            case 0: return "Q";
            case 1: return "W";
            case 2: return "E";
            case 3: return "R";
            case 4: return "T";
            case 5: return "Y";
            case 6: return "U";
            case 7: return "I";
            case 8: return "O";
            case 9: return "P";
            case 10: return "1";
            case 11: return "2";
            case 12: return "3";
            case 13: return "4";
            default: return "X";


        }
    }
    @FXML
    public void initialize()
    {

        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new RowConstraints();
        row1.setPercentHeight(50);
        row2.setPercentHeight(50);
        grid.getRowConstraints().add(row1);

        for(int i = 0;  i < 14; i++)
        {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(8);
            grid.getColumnConstraints().add(col);
            VBox vbox = new VBox();
            vbox.getStyleClass().add("key");

            Text note = new Text(500,50,chooseKeyNote(i));
            Text keyButton = new Text(5,5,getKeyMap(i));
            if(i != 0 && i!=3 && i != 7 && i!=10) {
                Rectangle key = new Rectangle(50, 100);
                //Text note = new Text(500,50,chooseKeyNote(i));
                vbox.getChildren().add(0, key);
                vbox.getChildren().add(1,note);
                vbox.getChildren().add(2,keyButton);
            }
            else{
                vbox.getChildren().add(0, note);
                vbox.getChildren().add(1,keyButton);
            }


            grid.add(vbox,i,1);
        }


    }
}