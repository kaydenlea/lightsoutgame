
/**
 * Lightsout game extra credit
 * @author Kayden Lea
 * klea@usc.edu
 * ITP 265, Spring 2022
 * [coffee] Class Section
 **/
public class LightsOutGame1D{
    private Helper helper;
    private Light [] gameArray; //initialized variables
//TODO: constructor


    public LightsOutGame1D() {
        helper = new Helper();
        //asks fo rinput for the number of lights the user wants
        int lights = helper.inputInt("Number of lights, between 3 and 15", 3, 15);
        this.gameArray = new Light[lights]; //creates array based on the input
        for (int i = 0; i<this.gameArray.length; i++){
            this.gameArray[i] = new Light();
        }
    }

public static void main(String args[]) {
    LightsOutGame1D myGame = new LightsOutGame1D();
    // testing emoji print:
    System.out.println("⬛💡 Welcome to Light's Out! 💡 ⬛ ");
    myGame.play(); //add back in when ready.
}

//TODO: method: displaying game board
    private void displayEmojiBoard() { //emoji game board that replaces it with the correlating emoji
        for (int i = 0; i < this.gameArray.length; i++) {
            if (this.gameArray[i].isOn()) {
                System.out.print(Light.ON + " ");
            } else {
                System.out.print(Light.OFF+ " ");
            }
        }
        System.out.println();
        for (int i = 0; i < this.gameArray.length; i++) {

            System.out.print(i +" ");
        }
    }

    private void displayStarBoard() { //star board that prints loops of the stars and lines
        for (int x = 0; x<4;x++) {
            for (int i = 0; i < this.gameArray.length; i++) {
                if (this.gameArray[i].isOn()) {
                    System.out.print("|****");
                } else {
                    System.out.print("|    ");
                }

            }
            System.out.print("|");
            System.out.println();
        }
        for (int i = 0; i < this.gameArray.length; i++) {
            System.out.print("    "+ i);
        }
        System.out.println();
    }

    private boolean displayBoardChoice(int boardChoice){ //methdo to help choose which board the user wants
        helper = new Helper();
        if (boardChoice == 1){

            return true;
        }
        else{

            return false;
        }
    }

    private boolean winStatus(){// determines if there is a win
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

//TODO: method(s): playing the game
//NOTE: make sure to use 'play' as method name, as referenced in main()
    public void play(){
        helper = new Helper();
        //asks user if for the board choice they want
        int boardChoice= helper.inputInt("Choose Emoji board (1) or Star board (2)", 1, 2);
        if (displayBoardChoice(boardChoice)){ //displays the right one
            displayEmojiBoard();
        }
        else{
            displayStarBoard();
        }
        boolean quit = false;
        while (!quit) {
            if (winStatus()){ //if they win ends the loop
                System.out.println("Winner!");
                quit = true;
                break;
            }

            //asks user what light they want or if they want to quit
            int lightSelection = helper.inputInt("\nWhich light do you select (or -1 to quit)?", -1, this.gameArray.length);

            if (lightSelection == -1){
                System.out.println("Quit");
                quit = true;
            }
            else{ //flips based on location
                this.gameArray[lightSelection].flip();
                if (lightSelection != this.gameArray.length-1){ //for the edges so flips are within range
                   this.gameArray[lightSelection+1].flip();
                }
                if (lightSelection != 0) {
                    this.gameArray[lightSelection - 1].flip();
                }
                if (displayBoardChoice(boardChoice)){ //displays the right boardchoice
                    displayEmojiBoard();
                }
                else{
                    displayStarBoard();
                }

            }
        }
        }

}
