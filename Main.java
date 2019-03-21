package uic.cs.marvin.musictrainingsim;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import uic.cs.marvin.musictrainingsim.music.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.io.IOException;
import java.util.HashMap;

public class Main extends Application {


    private HashMap<String,Integer> keyMap;



    private void initKeyMap(){
        keyMap = new HashMap<String,Integer>();
        keyMap.put("Q",48); //C
        keyMap.put("2",49);
        keyMap.put("W",50); //D
        keyMap.put("3",51);
        keyMap.put("E",52); //E
        keyMap.put("R",53); //F
        keyMap.put("5",54);
        keyMap.put("T",55); //G
        keyMap.put("6",56);
        keyMap.put("Y",57); //A
        keyMap.put("7",58);
        keyMap.put("U",59); //B
        keyMap.put("I",60); //C
        keyMap.put("9",61);
        keyMap.put("O",62); //D
        keyMap.put("0",63); //Eflat = zero no o
        keyMap.put("P",64); //E
        keyMap.put("Open Bracket",65); // F
        keyMap.put("Equals",66);
        keyMap.put("Close Bracket",67); //G
        keyMap.put("Backspace",68);
        keyMap.put("Back Slash", 69);
        keyMap.put("Home",71); //This is one line on my keyboard but may need to remap for other systems
        keyMap.put("Up",72);
    }

    public void lessonMode(Stage primaryStage) throws IOException{ //temporary to test lesson menu
        Parent lessonMenuRoot = FXMLLoader.load(getClass().getResource("lesson-menu.fxml"));
        Scene lessonMenuScene = new Scene(lessonMenuRoot);
        primaryStage.setScene(lessonMenuScene);
        primaryStage.show();
    }


   /* public void lessonMode(Stage primaryStage) throws IOException{
        initKeyMap();


        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Parent lessonRoot = FXMLLoader.load(getClass().getResource("lesson.fxml"));
        Scene lessonScene = new Scene(lessonRoot,screenSize.getWidth()-50, screenSize.getHeight()/3);


        lessonScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                try{
                    MusicManager.getInstance().playNote(keyMap.get(event.getCode().getName()));
                    System.out.println(event.getCode().getName());
                }
                catch(NullPointerException e){
                    System.out.println(event.getCode().getName());
                }

            }
        });

        lessonScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                try {
                    MusicManager.getInstance().stopNote(keyMap.get(event.getCode().getName()));
                }
                catch(NullPointerException e){}
            }});

        primaryStage.setScene(lessonScene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }*/


    public void freePlayMode(Stage primaryStage) throws IOException {
        initKeyMap();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();


        primaryStage.close();
        Parent keyboardRoot = FXMLLoader.load(getClass().getResource("FreePlay.fxml"));

        Scene keyboardScene = new Scene(keyboardRoot,screenSize.getWidth()-50, screenSize.getHeight()/3);


        keyboardScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                try{
                    MusicManager.getInstance().playNote(keyMap.get(event.getCode().getName()));
                }
                catch(NullPointerException e){

                }

            }
        });

        keyboardScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                try {
                    MusicManager.getInstance().stopNote(keyMap.get(event.getCode().getName()));
                }
                catch(NullPointerException e){}
            }});

        primaryStage.setScene(keyboardScene);
        primaryStage.show();
    }

    public void optionsMenu(Stage primaryStage) throws IOException{
        Parent optionsRoot = FXMLLoader.load(getClass().getResource("options.fxml"));
        primaryStage.setTitle("Options Menu");
        primaryStage.setScene(new Scene(optionsRoot, 600, 275));
        primaryStage.show();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        /* Sets main options menu temporarily until main menu is finished */
        //Nive code start
            primaryStage.setTitle("Lesson");
            Button btn = new Button();
            btn.setText("Say 'Lesson'");
            btn.setOnAction(new EventHandler<ActionEvent>() {

                //@Override
                public void handle(ActionEvent event) {
                    System.out.println("Lesson!");
                    try {
                        lessonMode(primaryStage);
                    }
                    catch(Exception e){};

                }
            });

            Button btn1 = new Button();
            btn1.setText("Say 'Free Play'");
            btn1.setOnAction(new EventHandler<ActionEvent>() {

                //@Override
                public void handle(ActionEvent event) {
                    System.out.println("Free Play!");
                    primaryStage.close();
                    try {
                        freePlayMode(primaryStage);
                    }
                    catch (IOException e){
                        System.out.println("Oop");
                        e.printStackTrace();
                    }

                }
            });

            Button btn2 = new Button();
            btn2.setText("Say 'Options'");
            btn2.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    Parent root;
                    try {

                        optionsMenu(primaryStage);
                    }
                    catch(Exception e)
                    {
                        System.out.println(e.getMessage());
                        System.exit(-1);
                    }
                }



            });

            Button btn3 = new Button();
            btn3.setText("Say 'Quit'");
            btn3.setOnAction(new EventHandler<ActionEvent>() {

                //@Override
                public void handle(ActionEvent event) {
                    System.out.println("Quit!");
                    System.exit(1);
                }
            });

            Pane root = new Pane();


            btn.setLayoutY(0);
            btn1.setLayoutY(30);
            btn2.setLayoutY(60);
            btn3.setLayoutY(90);

            root.getChildren().add(btn);
            root.getChildren().add(btn1);
            root.getChildren().add(btn2);
            root.getChildren().add(btn3);

            primaryStage.setScene(new Scene(root, 300, 250));
            primaryStage.show();



    }


    public static void main(String[] args) {
        launch(args);
    }
}
