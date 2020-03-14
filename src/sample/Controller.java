package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class Controller {
    int howManyClicked = 0;
    int cowsP1;
    int bullsP1;
    int cowsP2;
    int bullsP2;
    String wordP1;
    String wordP2;
    String guessWordP1;
    String guessWordP2;
    WhichPlayer whichPlayer = WhichPlayer.PLAYER_ONE;


    //<editor-fold desc="TextFields">
    @FXML
    private TextField p2Guess;

    @FXML
    private TextField mainScreen;

    @FXML
    private TextField p1Guess;

    @FXML
    private TextField p1LastWord;

    @FXML
    private TextField p1CowsLastWord;

    @FXML
    private TextField p1BullsLastWord;

    @FXML
    private TextField p1BestWord;

    @FXML
    private TextField p1CowsBestWord;

    @FXML
    private TextField p1BullsBestWord;

    @FXML
    private TextField p2LastWord;

    @FXML
    private TextField p2CowsLastWord;

    @FXML
    private TextField p2BullsLastWord;

    @FXML
    private TextField p2BestWord;

    @FXML
    private TextField p2CowsBestWord;

    @FXML
    private TextField p2BullsBestWord;

    //</editor-fold>

    //<editor-fold desc="Labels">
    @FXML
    private Label guess1Length;

    @FXML
    private Label guess2Length;
    //</editor-fold>

    @FXML
    private Button buttonDone;
    @FXML
    private Button checkButton;

    int howManyCows(String wordToGuess, String guessWord) {
        int cows = 0;

        for (int i = 0; i < guessWord.length(); i++) {
            if (wordToGuess.contains(Character.toString(guessWord.charAt(i)))) {
                cows++;
                for (int j = 0; j < wordToGuess.length(); j++) {
                    if (wordToGuess.charAt(j) == guessWord.charAt(i)) {
                        wordToGuess = wordToGuess.substring(0, j) + wordToGuess.substring(j + 1);
                        break;
                    }
                }
            }
        }
        return cows;
    }

    int howManyBulls(String word, String guessWord) {
        int bulls = 0;
        for (int i = 0;  i < word.length() && i < guessWord.length(); i++) {
            if (guessWord.charAt(i) == word.charAt(i)) {
                bulls++;
            }

        }
        return bulls;
    }

    @FXML
    void buttonDoneAction(ActionEvent event) {
        switch (howManyClicked) {
            case 0:
                howManyClicked++;
                mainScreen.setFont(Font.font("Verdana", 16));
                mainScreen.setText("Player 1: Please enter the key word for Player 2: (click)");
                break;
            case 1:
                howManyClicked++;
                mainScreen.setText("");
                mainScreen.setEditable(true);
                break;
            case 2:
                howManyClicked++;
                wordP1 = mainScreen.getText();
                wordP1 = wordP1.replaceAll("\\s+", "").toLowerCase();
                if(wordP1.length() < 1) {
                    mainScreen.setFont(Font.font("Verdana", 14));
                    mainScreen.setText("Your word has to have at least one character! Enter a new one:");
                    howManyClicked--;
                    howManyClicked--;
                }else {
                    mainScreen.setText("Word saved!");
                    guess2Length.setText(guess2Length.getText() + wordP1.length());
                    mainScreen.setEditable(false);
                }
                break;
            case 3:
                howManyClicked++;
                mainScreen.setText("Player 2: Please enter the key word for Player 1: (click)");
                break;
            case 4:
                howManyClicked++;
                mainScreen.setText("The word can't be longer than " + wordP1.length() + " character/s!");
                break;

            case 5:
                howManyClicked++;
                mainScreen.setEditable(true);
                mainScreen.setText("");
                break;
            case 6:
                howManyClicked++;
                mainScreen.setEditable(false);
                wordP2 = mainScreen.getText();
                wordP2 = wordP2.replaceAll("\\s+", "").toLowerCase();
                if (wordP1.length() < wordP2.length()) {
                    mainScreen.setFont(Font.font("Verdana", 12));
                    mainScreen.setText("Your word can't be longer than your opponent's! (at most: " + wordP1.length() + " character/s)");
                    howManyClicked--;
                    howManyClicked--;
                }else if(wordP2.length() < 1){
                    mainScreen.setFont(Font.font("Verdana", 14));
                    mainScreen.setText("Your word has to have at least one character! Enter a new one:");
                    howManyClicked--;
                    howManyClicked--;
                }
                else{
                    guess1Length.setText(guess1Length.getText()+wordP2.length());
                    mainScreen.setText("Word saved!");
                }
                break;
            case 7:
                howManyClicked++;
                mainScreen.setAlignment(Pos.CENTER);
                mainScreen.setFont(Font.font("Verdana", 24));
                mainScreen.setText("GUESSING TIME!");
                p1CowsBestWord.setText("0");
                p1CowsLastWord.setText("0");
                p1BullsBestWord.setText("0");
                p1BullsLastWord.setText("0");
                p2CowsBestWord.setText("0");
                p2CowsLastWord.setText("0");
                p2BullsBestWord.setText("0");
                p2BullsLastWord.setText("0");
                break;
            case 8:
                howManyClicked--;
                mainScreen.setAlignment(Pos.CENTER_LEFT);
                mainScreen.setFont(Font.font("Verdana", 16));
                mainScreen.setText("Player 1: fill 'Guess the word' label and check!");
                checkButton.setDisable(false);
                p1Guess.setEditable(true);
                break;

        }
    }

    @FXML
    void checkButtonAction(ActionEvent event) {
        mainScreen.setFont(Font.font("Verdana", 16));
        buttonDone.setDisable(true);
        switch (whichPlayer) {
            case PLAYER_ONE:
                guessWordP1 = p1Guess.getText().toLowerCase();
                p1LastWord.setText(guessWordP1);

                cowsP1 = howManyCows(wordP2, guessWordP1);
                bullsP1 = howManyBulls(wordP2, guessWordP1);

                p1LastWord.setText(guessWordP1);
                p1CowsLastWord.setText(Integer.toString(cowsP1));
                p1BullsLastWord.setText(Integer.toString(bullsP1));
                if(bullsP1 > Integer.parseInt(p1BullsBestWord.getText())){
                    p1BestWord.setText(guessWordP1);
                    p1BullsBestWord.setText(Integer.toString(bullsP1));
                    p1CowsBestWord.setText(Integer.toString(cowsP1));
                }
                else if(bullsP1 == Integer.parseInt(p1BullsBestWord.getText()) && cowsP1 > Integer.parseInt(p1CowsBestWord.getText())){
                    p1BestWord.setText(guessWordP1);
                    p1BullsBestWord.setText(Integer.toString(bullsP1));
                    p1CowsBestWord.setText(Integer.toString(cowsP1));
                }
                mainScreen.setAlignment(Pos.CENTER_LEFT);
                mainScreen.setText("Player 2: fill 'Guess the word' label and check!");
                p1Guess.setText("");
                p1Guess.setEditable(false);
                p2Guess.setEditable(true);
                if(wordP2.equals(guessWordP1)){
                    mainScreen.setAlignment(Pos.CENTER);
                    mainScreen.setFont(Font.font("Verdana", 24));
                    mainScreen.setText("WINNER WINNER PLAYER 1");
                    p2Guess.setEditable(false);
                    checkButton.setDisable(true);
                }
                whichPlayer = WhichPlayer.PLAYER_TWO;
                break;

            case PLAYER_TWO:
                guessWordP2 = p2Guess.getText().toLowerCase();
                p2LastWord.setText(guessWordP2);

                cowsP2 = howManyCows(wordP1, guessWordP2);
                bullsP2 = howManyBulls(wordP1, guessWordP2);

                p2LastWord.setText(guessWordP2);
                p2CowsLastWord.setText(Integer.toString(cowsP2));
                p2BullsLastWord.setText(Integer.toString(bullsP2));
                if(bullsP2 > Integer.parseInt(p2BullsBestWord.getText())){
                    p2BestWord.setText(guessWordP2);
                    p2BullsBestWord.setText(Integer.toString(bullsP2));
                    p2CowsBestWord.setText(Integer.toString(cowsP2));
                }
                else if(bullsP2 == Integer.parseInt(p2BullsBestWord.getText()) && cowsP2 > Integer.parseInt(p2CowsBestWord.getText())){
                    p2BestWord.setText(guessWordP2);
                    p2BullsBestWord.setText(Integer.toString(bullsP2));
                    p2CowsBestWord.setText(Integer.toString(cowsP2));
                }
                mainScreen.setAlignment(Pos.CENTER_LEFT);
                mainScreen.setText("Player 1: fill 'Guess the word' label and check!");
                p2Guess.setText("");
                p2Guess.setEditable(false);
                p1Guess.setEditable(true);
                if(wordP1.equals(guessWordP2)){
                    mainScreen.setAlignment(Pos.CENTER);
                    mainScreen.setFont(Font.font("Verdana", 24));
                    mainScreen.setText("WINNER WINNER PLAYER 2");
                    p1Guess.setEditable(false);
                    checkButton.setDisable(true);
                }
                whichPlayer = WhichPlayer.PLAYER_ONE;
                break;
        }
    }


}




