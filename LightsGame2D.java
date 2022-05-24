/**
 * Lightsout game extra credit
 * @author Kayden Lea
 * klea@usc.edu
 * ITP 265, Spring 2022
 * [coffee] Class Section
 **/
import java.util.Arrays;

public class LightsGame2D {
    private static Helper helper;
    //TODO: methods!
    private String[] alpha1 = {"A", "B", "C", "D", "E"}; //instance variables and setting up the arrays
    private Light [] gameArray;
    private int size; //variable to maintain size of the array
    public LightsGame2D() {
        helper = new Helper(); //asks for input for the size from the user and creates the array based on that
        this.size = helper.inputInt("How big of a light grid would you like to have [3-5]", 3, 5);
        this.gameArray = new Light[this.size*this.size];
        for (int i = 0; i<this.gameArray.length; i++){
            this.gameArray[i] = new Light();
        }
        displayBoard();

    }

    public static void main(String args[]) {
        LightsGame2D myGame = new LightsGame2D();
        myGame.play();

    }

    private void displayBoard(){ //function that creates the display for the board
        System.out.print(" ");
        for (int i=0; i<this.size; i++){//this loop prints the alphabet
            System.out.print(" " + alpha1[i]);
        }
        int index = 0; //index for a separate addition to index
        System.out.println();
        for (int i=0; i<this.size; i++){ //first loop to print out number that comes before the lights
            System.out.print(i+1);
            for (int x=0; x <this.size;x++) {
                if (this.gameArray[index].isOn()) { //prints the lights based on the emoji
                    System.out.print(Light.ON + " ");
                } else {
                    System.out.print(Light.OFF+ " ");
                }
                index+=1;

            }
            System.out.println();
        }
    }

    private int getColumnLetterAsNumber(String column){//gets column number through binary search
        int index = Arrays.binarySearch(this.alpha1, column);
        return index;
    }

    private boolean winStatus(){ //determines if the user has won the game or not if all the lights are switched off
        boolean win = false;
        for (int i = 0; i < this.gameArray.length; i++) {
            if (this.gameArray[i].isOn() == false){
                win = true;
            }
            else{
                win = false;
                return win;
            }
        }
        return win;
    }

    private String getValidLetter(){ //determines if the user has inputted a valid letter in the range that they chose
        boolean validLetter = false;
        String column = "";
        while (!validLetter){
            column = helper.inputWord("Please enter the column letter of the light: ").toUpperCase();
            for (int i= 0; i <size;i++) {
                if (alpha1[i].equals(column)){
                    validLetter= true;
                }
            }
            if (!validLetter){
                System.out.println("That is not a valid column letter");
//            column = helper.inputWord("Please enter the column letter of the light: ").toUpperCase();
            }
        }
        return column;
    }

    private void play() { //main play method
        boolean quit = false;
        while (!quit) {
            if (winStatus()){ //ends loop if they win
                System.out.println("Winner!");
                break;
            }
            //asks for user input for row and column
            int row = helper.inputInt("Please enter the row number of the light (or 0 to quit): ", 0, this.size);
            if (row == 0) { //if user enters 0 they can quit
                System.out.println("Thanks for playing");
                quit = true;
                break;

            }
            String columnChar = getValidLetter(); //calls the valid letter method
            int columnIndex = getColumnLetterAsNumber(columnChar);
            int guess = (this.size*(row-1) + columnIndex); //equation to determine index in the array for lights
            this.gameArray[guess].flip(); //flips the user's answer
            if (guess == 0){ //different if and else ifs to flip different lights based on its locaiton
                this.gameArray[guess+1].flip();
                this.gameArray[guess + this.size].flip();
                displayBoard();
            }
            else if(guess == this.size-1){
                this.gameArray[guess-1].flip();
                this.gameArray[guess+1].flip();
                displayBoard();
            }
            else if(guess ==(this.size * this.size)-1){
                this.gameArray[guess-this.size].flip();
                this.gameArray[guess-1].flip();
                displayBoard();
            }
            else if(guess ==(this.size* this.size)-this.size){
                this.gameArray[guess+1].flip();
                this.gameArray[guess-this.size].flip();
                displayBoard();
            }
            else if (row == this.size){
                this.gameArray[guess+1].flip();
                this.gameArray[guess-1].flip();
                this.gameArray[guess-this.size].flip();
                displayBoard();
            }
            else if (row ==1){
                this.gameArray[guess+1].flip();
                this.gameArray[guess-1].flip();
                this.gameArray[guess+this.size].flip();
                displayBoard();
            }
            else if (columnIndex == 0){
                this.gameArray[guess+1].flip();
                this.gameArray[guess+this.size].flip();
                this.gameArray[guess-this.size].flip();
                displayBoard();
            }
            else if (columnIndex == this.size-1){
                this.gameArray[guess-1].flip();
                this.gameArray[guess+this.size].flip();
                this.gameArray[guess-this.size].flip();
                displayBoard();
            }
            else{
                this.gameArray[guess + this.size].flip();
                this.gameArray[guess-this.size].flip();
                this.gameArray[guess+1].flip();
                this.gameArray[guess-1].flip();
                displayBoard();
            }
        }
        //asks user if they would like to play again
        boolean playAgain = helper.inputYesNo("Would you like to play again?");
        if (playAgain){
            LightsGame2D myGame = new LightsGame2D();
            myGame.play();
        }
    }
}