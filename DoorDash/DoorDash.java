import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.StackPane;
import javafx.geometry.Insets;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import java.io.File;
import javafx.scene.control.Label;
import java.util.Collections;
import java.util.Random;

/********************************************************************************************************************
 * CS1083 - JavaFX Project - Door Dash
 * 
 * Purpose: To create a JavaFX game for Dr McNally's fortnite stream.
 * 
 * Game: Door Dash
 * 
 * How to Play: At the start of each round the player selects a door, once chosen, 
 *              the door will reveal what’s behind it, the options are -1 coin, 0 coins , +1 coin, +2 coins.
 *               
 *              Once the player makes it through all five rounds of doors, they can choose to cash out 
 *              their jar of coins and end the game, or they can forfeit their earnings and attempt to win higher 
 *              prizes in the Lightning Round. 
 *               
 *              During the lighting round there is a set of four doors, 
 *              behind two doors is a Lose Everything option, behind another is a Keep your Current Jar, 
 *              and behind the last Double’s your Coins. 
 *
 * 
 * @authors - Zach Davis, Nicolas Serrano, Taryn Cail
 * @version - 20.0
 * @date - Winter 2024
 *********************************************************************************************************************/

public class DoorDash extends Application 
{
    // Declaring my Instance Data
    private static int points = 0;
    private static int round = 1;
    Label pointsLabel;
    Label roundLabel;
    
    @Override
    public void start(Stage primaryStage) 
    {
        // Creating the main BorderPane for the layout
        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-color: lightblue;");
        
        // Creating the stackpane for the buttons and doors
        StackPane doorsAndButtons = new StackPane();
        
        // Creating HBoxes for the doors and the buttons behind them
        HBox doorImages = new HBox();
        doorImages.setSpacing(30);
        HBox doorButtons = new HBox();
        doorButtons.setSpacing(30);
        

        // Create an HBox for the door buttons with spacing
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);

        /******************************************
         * Creating the Door Images
         *****************************************/
        // Door 1 ImageView
        Image door1Image = new Image("door1.png");
        ImageView door1ImageView = new ImageView(door1Image);
        // Setting ImageView to be transparent so mouse can click through it
        door1ImageView.setMouseTransparent(true);
        // Door 1 size
        door1ImageView.setFitWidth(200);
        door1ImageView.setFitHeight(400);
        // Door 2 ImageView
        Image door2Image = new Image("door2.png");
        ImageView door2ImageView = new ImageView(door2Image);
        // Setting ImageView to be transparent so mouse can click through it
        door2ImageView.setMouseTransparent(true);
        // Door 2 size
        door2ImageView.setFitWidth(200);
        door2ImageView.setFitHeight(400);
        // Door 3 ImageView
        Image door3Image = new Image("door3.png");
        ImageView door3ImageView = new ImageView(door3Image);
        // Setting ImageView to be transparent so mouse can click through it
        door3ImageView.setMouseTransparent(true);
        // Door 3 Size
        door3ImageView.setFitWidth(200);
        door3ImageView.setFitHeight(400);
        // Door 4 ImageView
        Image door4Image = new Image("door4.png");
        ImageView door4ImageView = new ImageView(door4Image);
        // Setting ImageView to be transparent so mouse can click through it
        door4ImageView.setMouseTransparent(true);
        // Door 4 size
        door4ImageView.setFitWidth(200);
        door4ImageView.setFitHeight(400);
        
        
        /******************************************
         * Placing the Door Images in the HBox
         *****************************************/
        doorImages.getChildren().addAll(door1ImageView, door2ImageView, door3ImageView, door4ImageView);
         
        
        /*****************************************
         * Creating the Title Image
         ****************************************/
        Image titleImage = new Image("title.png");
        ImageView titleImageView = new ImageView(titleImage);
        titleImageView.setFitWidth(775);
        titleImageView.setFitHeight(175);
        
        
    
        /*****************************************
         * Creating the Jar 0 Image
         *****************************************/
        Image jar0Image = new Image("jar0.png");
        ImageView jar0ImageView = new ImageView(jar0Image);
        jar0ImageView.setFitWidth(220);
        jar0ImageView.setFitHeight(300);
        
        
        /******************************************
         * Creating Scoresheet Image
         *****************************************/
        Image scoresheetImage = new Image("scoresheet.png");
        ImageView scoresheetImageView = new ImageView(scoresheetImage);
        scoresheetImageView.setFitWidth(200);
        scoresheetImageView.setFitHeight(250);
        
        
        /******************************************
         * Creating the reset, reveal, end, next 
         * and lightning round button images
         ******************************************/
        Image resetImage = new Image("reset.png");
        ImageView resetImageView = new ImageView(resetImage);
        Image revealImage = new Image("reveal.png");
        ImageView revealImageView = new ImageView(revealImage);
        Image endImage = new Image("end.png");
        ImageView endImageView = new ImageView(endImage);
        Image nextImage = new Image("next.png");
        ImageView nextImageView = new ImageView(nextImage);
        
        
        /******************************************
         * Creating the Door Buttons
         *****************************************/
        // Button 1
        Button door1 = new Button("-1");
        door1.setPrefSize(200, 400);
        door1.setOnAction(event ->
        {
            // Changing the points label by -1
            points--;
            pointsLabel.setText("Current Score: " + points);
            
            // Creating a new stage for the video player with a title
            Stage videoStage = new Stage();
            videoStage.setTitle("You lost 1 point!");
            
            // Setting up the media player for the video
            String videoFile = "JarEmpty.mp4";
            Media media = new Media(new File(videoFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            MediaView mediaView = new MediaView(mediaPlayer);
            
            // Setting the width and height of the mediaView
            mediaView.setFitWidth(800);
            mediaView.setFitHeight(500);
            
            // Creating a StackPane in order to center the video
            StackPane mediaPane = new StackPane();
            mediaPane.getChildren().add(mediaView);
            mediaPane.setStyle("-fx-background-color: rgb(161, 217, 231);");
            
            // Setting the scene and showing the video
            Scene scene = new Scene(mediaPane);
            videoStage.setScene(scene);
            mediaPlayer.play();
            videoStage.show();
        }
        );
        
        
        // Button 2
        Button door2 = new Button("0");
        door2.setPrefSize(200, 400);
        door2.setOnAction(event ->
        {
            // This button does not change the points therefore there is no
            // change to the label code here.
            
            // Creating a new stage for the video player with a title
            Stage videoStage = new Stage();
            videoStage.setTitle("You got 0 points!");
            
            // Setting up the media player for the video
            String videoFile = "JarZero.mp4";
            Media media = new Media(new File(videoFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            MediaView mediaView = new MediaView(mediaPlayer);
            
            // Setting the width and height of the mediaView
            mediaView.setFitWidth(800);
            mediaView.setFitHeight(500);
            
            // Creating a StackPane in order to center the video
            StackPane mediaPane = new StackPane();
            mediaPane.getChildren().add(mediaView);
            mediaPane.setStyle("-fx-background-color: rgb(161, 217, 231);");
            
            // Setting the scene and showing the video
            Scene scene = new Scene(mediaPane);
            videoStage.setScene(scene);
            mediaPlayer.play();
            videoStage.show();
        }
        );
        
        // Button 3
        Button door3 = new Button("+1");
        door3.setPrefSize(200, 400);
        door3.setOnAction(event ->
        {
            // Changing the points label by +1
            points++;
            pointsLabel.setText("Current Score: " + points);
            
            // Creating a new stage for the video player with a title
            Stage videoStage = new Stage();
            videoStage.setTitle("You got 1 point!");
            
            // Setting up the media player for the video
            String videoFile = "JarFill.mp4";
            Media media = new Media(new File(videoFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            MediaView mediaView = new MediaView(mediaPlayer);
            
            // Setting the width and height of the mediaView
            mediaView.setFitWidth(800);
            mediaView.setFitHeight(500);
            
            // Creating a StackPane in order to center the video
            StackPane mediaPane = new StackPane();
            mediaPane.getChildren().add(mediaView);
            mediaPane.setStyle("-fx-background-color: rgb(161, 217, 231);");
            
            // Setting the scene and showing the video
            Scene scene = new Scene(mediaPane);
            videoStage.setScene(scene);
            mediaPlayer.play();
            videoStage.show();
        }
        );
        
        // Button 4
        Button door4 = new Button("+2");
        door4.setPrefSize(200, 400);
        door4.setOnAction(event ->
        {
            // Changing the points label by +2
            points++;
            points++;
            pointsLabel.setText("Current Score: " + points);
            
            // Creating a new stage for the video player with a title
            Stage videoStage = new Stage();
            videoStage.setTitle("You got 2 points!");
            
            // Setting up the media player for the video
            String videoFile = "JarFill2.mp4";
            Media media = new Media(new File(videoFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            MediaView mediaView = new MediaView(mediaPlayer);
            
            // Setting the width and height of the mediaView
            mediaView.setFitWidth(800);
            mediaView.setFitHeight(500);
            
            // Creating a StackPane in order to center the video
            StackPane mediaPane = new StackPane();
            mediaPane.getChildren().add(mediaView);
            mediaPane.setStyle("-fx-background-color: rgb(161, 217, 231);");
            
            // Setting the scene and showing the video
            Scene scene = new Scene(mediaPane);
            videoStage.setScene(scene);
            mediaPlayer.play();
            videoStage.show();
        }
        );
        
        // Creating an array for the buttons and making them transparent
        Button[] arrayOfDoorButtons = new Button[]{door1, door2, door3, door4};
        for (int i = 0; i < arrayOfDoorButtons.length; i ++)
        {
            arrayOfDoorButtons[i].setOpacity(0);
        }
        
        
        // Give an initial shuffle to the array of buttons
        Random rand = new Random();
        for (int i = 0; i < arrayOfDoorButtons.length; i++) 
            {
                int randomIndexToSwap = rand.nextInt(arrayOfDoorButtons.length);
                Button temp = arrayOfDoorButtons[randomIndexToSwap];
                arrayOfDoorButtons[randomIndexToSwap] = arrayOfDoorButtons[i];
                arrayOfDoorButtons[i] = temp;
            }
        
        /******************************************
         * Placing the Door Images in the HBox
         *****************************************/
        doorButtons.getChildren().addAll(arrayOfDoorButtons);
        
        
        /******************************************
         * Placing the Door Images and Door buttons
         * in the StackPane
         *****************************************/
         doorsAndButtons.getChildren().addAll(doorImages, doorButtons);
        
        
        /********************************************
         * Creating a label that displays the current
         * amount of points the player has.
         ********************************************/
        pointsLabel = new Label();
        pointsLabel.setText("Current Score: " + points);
        pointsLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        
        
        
        
        /********************************************
         * Creating a label that displays the current
         * round the player is on.
        ********************************************/
        roundLabel = new Label();
        roundLabel.setText("Current Round: " + round);
        roundLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
         
        
        
        /*********************************************
         * Creating a VBox (leftImagesBox) to hold the 
         * scoresheet, and another HBox (rightImagesBox) 
         * to hold the jar and HBox.
         ********************************************/
        // Create an VBox to hold the Jar
        VBox rightImagesBox = new VBox(10);
        // Placing the HBox and jar image in the VBox
        rightImagesBox.getChildren().addAll(roundLabel, pointsLabel, jar0ImageView);
        // Center aligning the jar, buttons and label and adding spacing to it
        rightImagesBox.setAlignment(Pos.CENTER);
        rightImagesBox.setPadding(new Insets(20, 20, 20, 0));
        
        // Create a VBox to hold the scoresheet
        VBox leftImagesBox = new VBox(10);
        // Placing the scoresheet in the VBox
        leftImagesBox.getChildren().addAll(scoresheetImageView);
        // Center aligning the scoresheet and adding spacing to it
        leftImagesBox.setAlignment(Pos.CENTER);
        leftImagesBox.setPadding(new Insets(20, 20, 20, 20));
        
        

        
        /********************************************
         * Creating the reset, reveal, end and next
         * buttons.
         ********************************************/
        // Reset Button
        Button resetButton = createBottomButton();
        // Setting the Reset Buttons graphic
        resetButton.setGraphic(resetImageView);
        // Setting the Reset Buttons size
        resetImageView.setFitWidth(resetButton.getPrefWidth());
        resetImageView.setFitHeight(resetButton.getPrefHeight());
        // Reset button action
        resetButton.setOnAction(event -> 
        {
            // Reset points and round
            points = 0;
            round = 1;
    
            // Update labels
            pointsLabel.setText("Current Score: " + points);
            roundLabel.setText("Current Round: " + round);
            
            
            //Shuffle buttons behind the doors        
            for (int i = 0; i < arrayOfDoorButtons.length; i++) 
            {
                int randomIndexToSwap = rand.nextInt(arrayOfDoorButtons.length);
                Button temp = arrayOfDoorButtons[randomIndexToSwap];
                arrayOfDoorButtons[randomIndexToSwap] = arrayOfDoorButtons[i];
                arrayOfDoorButtons[i] = temp;
            }
        
            // Reset the HBox with the new order of buttons and the images
            doorButtons.getChildren().setAll(arrayOfDoorButtons);                
            for (int i = 0; i < arrayOfDoorButtons.length; i ++)
            {
                arrayOfDoorButtons[i].setOpacity(0);
            }
        }
        );
        
        
        // Reveal Button        
        Button revealButton = createBottomButton();
        // Setting the Reveal Buttons graphic
        revealButton.setGraphic(revealImageView);
        // Setting the Reveal Buttons size
        revealImageView.setFitWidth(revealButton.getPrefWidth());
        revealImageView.setFitHeight(revealButton.getPrefHeight());
        // Reveal button action
        revealButton.setOnAction(event -> 
        {
            //Set the buttons to be visible
            for (int i = 0; i < arrayOfDoorButtons.length; i ++)
                {
                    arrayOfDoorButtons[i].setOpacity(100);
                }
        });
        
        
        // End Button
        Button endButton = createBottomButton();
        // Setting the End Buttons graphic
        endButton.setGraphic(endImageView);
        // Setting the End Buttons size
        endImageView.setFitWidth(endButton.getPrefWidth());
        endImageView.setFitHeight(endButton.getPrefHeight());
        // End button action
        endButton.setOnAction(event -> 
        {
            // Create a new stage for displaying points
            Stage pointsStage = new Stage();
            pointsStage.setTitle("Points Summary");
            String summary="";
            // Create a label to display points
            Label pointsSummaryLabel = new Label("Total Points: " + points);
            pointsSummaryLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
            
            
            // Create a VBox to hold the label
            VBox vbox = new VBox(20);
            vbox.getChildren().add(pointsSummaryLabel);
            
            if(points < 4)
            {
                summary = "0 V bucks";
            }
            else if (points < 7)
            {
                summary = "500 V bucks";
            }
            else if (points < 9)
            {
                summary = "1000 V bucks";
            }
            else if (points < 11)
            {
                summary = "1500 V bucks";
            }
            else
            {
                summary = "2000 V bucks";
            }
            Label resultsLabel = new Label("You won: " + summary);
            resultsLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
            
            vbox.getChildren().add(resultsLabel);
            vbox.setAlignment(Pos.CENTER);
            vbox.setPadding(new Insets(20));
            
            // Create scene and set it to the stage
            Scene scene = new Scene(vbox, 300, 200);
            pointsStage.setScene(scene);
            
            // Show the stage
            pointsStage.show();
        }
        );
        
        // Next Button
        Button nextButton = createBottomButton();
        // Setting the Next Buttons graphic
        nextButton.setGraphic(nextImageView);
        // Setting the Next Buttons size
        nextImageView.setFitWidth(nextButton.getPrefWidth());
        nextImageView.setFitHeight(nextButton.getPrefHeight());
        // Next Button Action
        nextButton.setOnAction(e -> 
        {
            round = round + 1;
            
            //Limit the regular rounds to 4
            if (round <=4)
            {
                // Update labels
                roundLabel.setText("Current Round: " + round);
        
                //code to shuffle doors of buttons 
                for (int i = 0; i < arrayOfDoorButtons.length; i++) 
                {
                    int randomIndexToSwap = rand.nextInt(arrayOfDoorButtons.length);
                    Button temp = arrayOfDoorButtons[randomIndexToSwap];
                    arrayOfDoorButtons[randomIndexToSwap] = arrayOfDoorButtons[i];
                    arrayOfDoorButtons[i] = temp;
                }
                // Update the HBox with the new order of buttons
                doorButtons.getChildren().setAll(arrayOfDoorButtons);
                for (int i = 0; i < arrayOfDoorButtons.length; i ++)
                {
                    arrayOfDoorButtons[i].setOpacity(0);
                }
                
            }
            
            //code to prompt user if they would like to go to the lightning round (if(rounds > 4))
            
        }
        );
        
        //
        
        

        // Create an HBox for the buttons in the bottom part
        HBox bottomButtonBox = new HBox(20);
        bottomButtonBox.getChildren().addAll(resetButton, revealButton, endButton, nextButton);
        bottomButtonBox.setAlignment(Pos.CENTER);
        bottomButtonBox.setPadding(new Insets(10, 10, 10, 10));

        // Adding everything to the Borderpane
        borderPane.setTop(titleImageView);
        BorderPane.setMargin(titleImageView, new Insets(20, 0, 0, 0));
        BorderPane.setAlignment(titleImageView, Pos.CENTER);

        borderPane.setCenter(doorsAndButtons);
        borderPane.setAlignment(doorsAndButtons, Pos.CENTER);
        borderPane.setLeft(leftImagesBox);
        borderPane.setRight(rightImagesBox);
        borderPane.setBottom(bottomButtonBox);
        borderPane.setAlignment(bottomButtonBox, Pos.CENTER);
        
        // Create the scene with the BorderPane as the main layout
        Scene myScene = new Scene(borderPane, 1450, 850);

        // Set the scene for the primaryStage
        primaryStage.setScene(myScene);
        primaryStage.setTitle("Door Dash");
        primaryStage.setWidth(1490);
        primaryStage.setHeight(810);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    

    /**********************************************************************
     * Method: Create Bottom Button
     *
     * Purpose: To create the buttons for below the doors that have a blue 
     *          background until an image is inserted and have a pre-set 
     *          size.
     *********************************************************************/
    private Button createBottomButton() 
    {
        Button button = new Button();
        button.setPrefSize(150, 75);
        button.setStyle("-fx-background-color: lightblue;");
        return button;
    }

    /**********************************************************************
     * Method: lightningRound
     * 
     * Purpose: To start the lightning round once the player has completed
     *          4 rounds in the regular round and choses to move on.
     *********************************************************************/
    private void lightningRound()
    {
        // Creating the main BorderPane for the layout
        BorderPane borderPane2 = new BorderPane();
        borderPane2.setStyle("-fx-background-color: lightblue;");
        
        // Creating the stackpane for the buttons and doors
        StackPane doorsAndButtons2 = new StackPane();
        
        // Creating HBoxes for the doors and the buttons behind them
        HBox doorImages2 = new HBox();
        HBox doorButtons2 = new HBox();
        
        /******************************************
         * Creating the Lightning Door Images
         *****************************************/
        /******************************************
         * Creating the Door Images
         *****************************************/
        // Door 1 ImageView
        Image door1Image2 = new Image("door1.png");
        ImageView door1ImageView2 = new ImageView(door1Image2);
        // Setting ImageView to be transparent so mouse can click through it
        door1ImageView2.setMouseTransparent(true);
        // Door 1 size
        door1ImageView2.setFitWidth(200);
        door1ImageView2.setFitHeight(400);
        // Door 2 ImageView
        Image door2Image2 = new Image("door2.png");
        ImageView door2ImageView2 = new ImageView(door2Image2);
        // Setting ImageView to be transparent so mouse can click through it
        door2ImageView2.setMouseTransparent(true);
        // Door 2 size
        door2ImageView2.setFitWidth(200);
        door2ImageView2.setFitHeight(400);
        // Door 3 ImageView
        Image door3Image2 = new Image("door3.png");
        ImageView door3ImageView2 = new ImageView(door3Image2);
        // Setting ImageView to be transparent so mouse can click through it
        door3ImageView2.setMouseTransparent(true);
        // Door 3 Size
        door3ImageView2.setFitWidth(200);
        door3ImageView2.setFitHeight(400);
        // Door 4 ImageView
        Image door4Image2 = new Image("door4.png");
        ImageView door4ImageView2 = new ImageView(door4Image2);
        // Setting ImageView to be transparent so mouse can click through it
        door4ImageView2.setMouseTransparent(true);
        // Door 4 size
        door4ImageView2.setFitWidth(200);
        door4ImageView2.setFitHeight(400);
        
        
        /******************************************
         * Placing the Door Images in the HBox
         *****************************************/
         doorImages2.getChildren().addAll(door1ImageView2, door2ImageView2, door3ImageView2, door4ImageView2);
         
        
        /*****************************************
         * Creating the Title Image
         ****************************************/
        Image titleImage2 = new Image("lightningTitle.png");
        ImageView titleImageView2 = new ImageView(titleImage2);
        titleImageView2.setFitWidth(775);
        titleImageView2.setFitHeight(175);
        
        
        /******************************************
         * Creating Scoresheet Image
         *****************************************/
        Image scoresheetImage2 = new Image("lightningScoresheet.png");
        ImageView scoresheetImageView2 = new ImageView(scoresheetImage2);
        scoresheetImageView2.setFitWidth(200);
        scoresheetImageView2.setFitHeight(250);
        
        
        // THIS NEEDS TO BE CHANGED TO AN ARRAY THAT CAN CHANGE WITH BUTTON
        /*****************************************
         * Creating the Jar 0 Image
         *****************************************/
        Image jar0Image = new Image("jar0.png");
        ImageView jar0ImageView = new ImageView(jar0Image);
        jar0ImageView.setFitWidth(220);
        jar0ImageView.setFitHeight(300);
        
        
        /******************************************
         * Creating the reset, reveal, end, next 
         * and lightning round button images
         ******************************************/
        Image resetImage = new Image("reset.png");
        ImageView resetImageView = new ImageView(resetImage);
        Image revealImage = new Image("reveal.png");
        ImageView revealImageView = new ImageView(revealImage);
        Image endImage = new Image("end.png");
        ImageView endImageView = new ImageView(endImage);
        
        
        /******************************************
         * Creating the Door Buttons
         *****************************************/
        // Button 1
        Button door1 = new Button("Lose Everything");
        door1.setPrefSize(200, 400);
        door1.setOnAction(event ->
        {
            // Changing the points to zero
            points = 0;
            pointsLabel.setText("Current Score: " + points);
            
            // Creating a new stage for the video player with a title
            Stage videoStage = new Stage();
            videoStage.setTitle("You lost everything!");
            
            // Setting up the media player for the video
            String videoFile = "JarEmpty.mp4";
            Media media = new Media(new File(videoFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            MediaView mediaView = new MediaView(mediaPlayer);
            
            // Setting the width and height of the mediaView
            mediaView.setFitWidth(800);
            mediaView.setFitHeight(500);
            
            // Creating a StackPane in order to center the video
            StackPane mediaPane = new StackPane();
            mediaPane.getChildren().add(mediaView);
            mediaPane.setStyle("-fx-background-color: rgb(161, 217, 231);");
            
            // Setting the scene and showing the video
            Scene scene = new Scene(mediaPane);
            videoStage.setScene(scene);
            mediaPlayer.play();
            videoStage.show();
        }
        );
        
        
        // Button 2
        Button door2 = new Button("Lose Everything");
        door2.setPrefSize(200, 400);
        door2.setOnAction(event ->
        {
            // Changing the points to zero
            points = 0;
            pointsLabel.setText("Current Score: " + points);
            
            // Creating a new stage for the video player with a title
            Stage videoStage = new Stage();
            videoStage.setTitle("You lost Everything!");
            
            // Setting up the media player for the video
            String videoFile = "JarZero.mp4";
            Media media = new Media(new File(videoFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            MediaView mediaView = new MediaView(mediaPlayer);
            
            // Setting the width and height of the mediaView
            mediaView.setFitWidth(800);
            mediaView.setFitHeight(500);
            
            // Creating a StackPane in order to center the video
            StackPane mediaPane = new StackPane();
            mediaPane.getChildren().add(mediaView);
            mediaPane.setStyle("-fx-background-color: rgb(161, 217, 231);");
            
            // Setting the scene and showing the video
            Scene scene = new Scene(mediaPane);
            videoStage.setScene(scene);
            mediaPlayer.play();
            videoStage.show();
        }
        );
        
        // Button 3
        Button door3 = new Button("Keep Your Current Jar");
        door3.setPrefSize(200, 400);
        door3.setOnAction(event ->
        {
            // This button does not change the points, therefore there is
            // no code here related to that.
            
            // Creating a new stage for the video player with a title
            Stage videoStage = new Stage();
            videoStage.setTitle("You get to keep your jar!");
            
            // Setting up the media player for the video
            String videoFile = "JarFill.mp4";
            Media media = new Media(new File(videoFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            MediaView mediaView = new MediaView(mediaPlayer);
            
            // Setting the width and height of the mediaView
            mediaView.setFitWidth(800);
            mediaView.setFitHeight(500);
            
            // Creating a StackPane in order to center the video
            StackPane mediaPane = new StackPane();
            mediaPane.getChildren().add(mediaView);
            mediaPane.setStyle("-fx-background-color: rgb(161, 217, 231);");
            
            // Setting the scene and showing the video
            Scene scene = new Scene(mediaPane);
            videoStage.setScene(scene);
            mediaPlayer.play();
            videoStage.show();
        }
        );
        
        // Button 4
        Button door4 = new Button("Double Your Points!");
        door4.setPrefSize(200, 400);
        door4.setOnAction(event ->
        {
            // Changing the points label by doubling them
            points = points * 2;
            pointsLabel.setText("Current Score: " + points);
            
            // Creating a new stage for the video player with a title
            Stage videoStage = new Stage();
            videoStage.setTitle("You got 2 points!");
            
            // Setting up the media player for the video
            String videoFile = "JarFill2.mp4";
            Media media = new Media(new File(videoFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            MediaView mediaView = new MediaView(mediaPlayer);
            
            // Setting the width and height of the mediaView
            mediaView.setFitWidth(800);
            mediaView.setFitHeight(500);
            
            // Creating a StackPane in order to center the video
            StackPane mediaPane = new StackPane();
            mediaPane.getChildren().add(mediaView);
            mediaPane.setStyle("-fx-background-color: rgb(161, 217, 231);");
            
            // Setting the scene and showing the video
            Scene scene = new Scene(mediaPane);
            videoStage.setScene(scene);
            mediaPlayer.play();
            videoStage.show();
        }
        );
        
        // Creating an array for the buttons
        Button[] arrayOfDoorButtons2 = new Button[]{door1, door2, door3, door4};
        
        /******************************************
         * Placing the Door Images in the HBox
         *****************************************/
        doorButtons2.getChildren().addAll(door1, door2, door3, door4);
        
        
        /******************************************
         * Placing the Door Images and Door buttons
         * in the StackPane
         *****************************************/
         doorsAndButtons2.getChildren().addAll(doorButtons2, doorImages2);
         
         /*********************************************
         * Creating a VBox (leftImagesBox) to hold the 
         * scoresheet, and another HBox (rightImagesBox) 
         * to hold the jar and HBox.
         ********************************************/
        // Create an VBox to hold the Jar
        VBox rightImagesBox = new VBox(10);
        // Placing the HBox and jar image in the VBox
        rightImagesBox.getChildren().addAll(roundLabel, pointsLabel, jar0ImageView);
        // Center aligning the jar, buttons and label and adding spacing to it
        rightImagesBox.setAlignment(Pos.CENTER);
        rightImagesBox.setPadding(new Insets(20, 20, 20, 0));
        
        // Create a VBox to hold the scoresheet
        VBox leftImagesBox = new VBox(10);
        // Placing the scoresheet in the VBox
        leftImagesBox.getChildren().addAll(scoresheetImageView2);
        // Center aligning the scoresheet and adding spacing to it
        leftImagesBox.setAlignment(Pos.CENTER);
        leftImagesBox.setPadding(new Insets(20, 20, 20, 20));
        
        

        /********************************************
         * Creating the reset, reveal and end
         * buttons.
         ********************************************/
        // Reset Button
        Button resetButton = createBottomButton();
        // Setting the Reset Buttons graphic
        resetButton.setGraphic(resetImageView);
        // Setting the Reset Buttons size
        resetImageView.setFitWidth(resetButton.getPrefWidth());
        resetImageView.setFitHeight(resetButton.getPrefHeight());
        // Reset button action
        resetButton.setOnAction(event -> 
        {
            // Reset points and round
            points = 0;
            round = 1;
    
            // Update labels
            pointsLabel.setText("Current Score: " + points);
            roundLabel.setText("Current Round: " + round);
        }
        );
        
        
        // Reveal Button        
        Button revealButton = createBottomButton();
        // Setting the Reveal Buttons graphic
        revealButton.setGraphic(revealImageView);
        // Setting the Reveal Buttons size
        revealImageView.setFitWidth(revealButton.getPrefWidth());
        revealImageView.setFitHeight(revealButton.getPrefHeight());
        // ACTION FOR BUTTON NEEDED HERE
        
        // End Button
        Button endButton = createBottomButton();
        // Setting the End Buttons graphic
        endButton.setGraphic(endImageView);
        // Setting the End Buttons size
        endImageView.setFitWidth(endButton.getPrefWidth());
        endImageView.setFitHeight(endButton.getPrefHeight());
        // End button action
        endButton.setOnAction(event -> 
        {
            // Create a new stage for displaying points
            Stage pointsStage = new Stage();
            pointsStage.setTitle("Points Summary");
            String summary="";
            // Create a label to display points
            Label pointsSummaryLabel = new Label("Total Points: " + points);
            pointsSummaryLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
            
            
            // Create a VBox to hold the label
            VBox vbox = new VBox(20);
            vbox.getChildren().add(pointsSummaryLabel);
            
            if(points < 4)
            {
                summary = "0 V bucks";
            }
            else if (points < 7)
            {
                summary = "500 V bucks";
            }
            else if (points < 9)
            {
                summary = "1000 V bucks";
            }
            else if (points < 11)
            {
                summary = "1500 V bucks";
            }
            else
            {
                summary = "2000 V bucks";
            }
            Label resultsLabel = new Label("You won: " + summary);
            resultsLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
            
            vbox.getChildren().add(resultsLabel);
            vbox.setAlignment(Pos.CENTER);
            vbox.setPadding(new Insets(20));
            
            // Create scene and set it to the stage
            Scene scene = new Scene(vbox, 300, 200);
            pointsStage.setScene(scene);
            
            // Show the stage
            pointsStage.show();
        }
        );
        
        
        // Create an HBox for the buttons in the bottom part
        HBox bottomButtonBox = new HBox(20);
        bottomButtonBox.getChildren().addAll(resetButton, revealButton, endButton);
        bottomButtonBox.setAlignment(Pos.CENTER);
        bottomButtonBox.setPadding(new Insets(10, 10, 10, 10));

        // Adding everything to the Borderpane
        borderPane2.setTop(titleImageView2);
        borderPane2.setMargin(titleImageView2, new Insets(20, 0, 0, 0));
        borderPane2.setAlignment(titleImageView2, Pos.CENTER);

        borderPane2.setCenter(doorsAndButtons2);
        borderPane2.setLeft(leftImagesBox);
        borderPane2.setRight(rightImagesBox);
        borderPane2.setBottom(bottomButtonBox);
        borderPane2.setAlignment(bottomButtonBox, Pos.CENTER);
        
        // Create the scene with the BorderPane as the main layout
        Scene myScene = new Scene(borderPane2, 1450, 850);
        Stage secondaryStage = new Stage();
        
        // Set the scene for the secondaryStage
        secondaryStage.setScene(myScene);
        secondaryStage.setTitle("Door Dash");
        secondaryStage.setWidth(1490);
        secondaryStage.setHeight(810);
        secondaryStage.setResizable(false);
        secondaryStage.show();
    }
}
