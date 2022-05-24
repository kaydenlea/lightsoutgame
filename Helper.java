import java.util.*;


/**
 * This class is meant to serve ITP 265 students as a help for getting input and error checking on input, but
 * may also be used as a general purpose class to store methods which may be needed across lots of projects.
 *
 * @author Kendra Walther and Coffee Class
 * @version Spring 2022
 */

 //NOTE: feel free to change this back to regular Helper if you use this solution!
 public class Helper{
     private Scanner sc; //declare

     public Helper(){
         sc = new Scanner(System.in); // initialize
     }
     /**
     * Prompt the user and read one word of text as a String
     * @param prompt: the question to ask the user
     * @return: a one word String - if the user enters multiple words, all other input until the return will be discarded.
     */
    public String inputWord(String prompt) {
        System.out.print(prompt + "\n>");
        String word = sc.next();
        sc.nextLine(); // remove any "garbage" (like extra whitespace or the return key) after the one word that is read in
        return word;
    }
     /**
     * Prompt the user and read one line of text as a String
     * @param prompt: the question to ask the user
     * @return: a line of user input (including spaces, until they hit enter)
     */
    public String inputLine(String prompt) {
        System.out.print(prompt + "\n>");
        return sc.nextLine();
    }

     /**
     * Prompt the user and read one word of text as a String, returns a String that matches
     * one allowed matching words passed in as parameters (case sensitive)
     * @param prompt: the question to ask the user
     * @param match1: a word the input is allowed to be
     * @param match2: a word the input is allowed to be
     * @param match3: a word the input is allowed to be
     * @return: a one word  String that matches one of the three allowed words (case-sensitive)
     */
    public String inputWord(String prompt, String match1, String match2, String match3) {
       String word = inputWord(prompt);
        //TODO: finish this method, checking for matching words
          // loop while NOT good, getting new word to check
            while(!( word.equals(match1) || word.equals(match2) || word.equals(match3) )){
                System.out.println("Sorry, " + word + " did not match the target options.\n"
                        + "Choose: " + match1 + " or " + match2 + " or " + match3);
                word = inputWord(prompt);        
            }
        // improvement: use equalsIgnoreCase above but check when returning to return 
        // exactly one of the match words
        return word; // word will be one of the "match" parameters
    }


    /**
     * Prompt the user and read an int, clearing whitespace or the enter after the number
     * @param prompt: the question to ask the user 
     * @return: an int 
     */
    public int inputInt(String prompt) {
       System.out.print(prompt + " >");
       while(!sc.hasNextInt()){
           String garbage = sc.nextLine(); // remove the non-int from the stream
           System.out.println (garbage + " was not an int.\n" + prompt + "\n>");
       }// exit while loop when there IS an int
       int answer = sc.nextInt();
       sc.nextLine(); // get rid of anything else on the stream (like the \n)
        return answer;
    }

    /**
     * Prompt the user and read an int between (inclusive) of minValue and maxValue, clearing whitespace or the enter after the number
     * @param prompt: the question to ask the user 
     * @return: an int between minValue and maxValue
     */
    public int inputInt(String prompt, int minValue, int maxValue) {
        int num = inputInt(prompt); //to get ANY number
        while (! (num >= minValue && num <= maxValue) ){
            System.out.println("Sorry " + num + " was not in the range [" 
                            + minValue + " - " + maxValue + "]");
            num = inputInt(prompt);
        }
        return num;
    }

    /**
     * Prompt the user and read a floating point number, clearing whitespace or the enter after the number
     * @param prompt: the question to ask the user 
     * @return: a double value 
     */
    public double inputDouble(String prompt) {
        System.out.print(prompt + " >");
        while(!sc.hasNextDouble()){
           String garbage = sc.nextLine(); // remove the non-int from the stream
           System.out.println (garbage + " was not a double.\n" + prompt + " >");
       }// exit while loop when there IS a double
       double answer = sc.nextDouble();
       sc.nextLine(); // get rid of anything else on the stream (like the \n)
        return answer;
    }

    /**
     * Prompt the user and read a floating point number between (inclusive) of min and max, 
     * clearing whitespace or the enter after the number
     * @param prompt: the question to ask the user 
     * @return: a double value 
     */
    public double inputDouble(String prompt, double min, double max) {
          double num = inputDouble(prompt); //to get ANY number
        while (! (num >= min && num <= max) ){
            System.out.println("Sorry " + num + " was not in the range [" 
                            + min + " - " + max + "]");
            num = inputDouble(prompt);
        }
        return num;
    }

    /**
     * Prompt the user and read a boolean value, clearing whitespace or the enter after the number
     * @param prompt: the question to ask the user 
     * @return: a boolean value 
     */
    public boolean inputBoolean(String prompt) {
         System.out.print(prompt + " >");
        while(!sc.hasNextBoolean()){
           String garbage = sc.nextLine(); // remove the non-int from the stream
           System.out.print (garbage + " was not a boolean.\n" 
                    + "you must enter \"true\" or \"false\" " + prompt + " >");
       }// exit while loop when there IS a boolean
       boolean answer = sc.nextBoolean();
       sc.nextLine(); // get rid of anything else on the stream (like the \n)
        return answer;
    }

    /**
     * Prompt the user enter yes or no (will match y/yes and n/no any case) and return true for yes and false for no.
     * @param prompt: the question to ask the user 
     * @return: a boolean value 
     */
    public boolean inputYesNo(String prompt) {
        String word = inputWord(prompt);
        while (! (isYes(word) || isNo(word) )){
            System.out.println(word + " was not good. Please type \"y\" or \"n\"");
            word = inputWord(prompt);
        }   // I know i have y/yes or n/no
        return isYes(word); // if it's not yes, it must be no according to my loop
    }
    public boolean isYes(String word){
        return word.equalsIgnoreCase("y") || word.equalsIgnoreCase("yes");
    }
    public boolean isNo(String word){
        return word.equalsIgnoreCase("n") || word.equalsIgnoreCase("no");
    }

    /**
     * A shortcut to System.out.println
     * @param msg: the line to be output
     * @return: none 
     */
    public void print(String msg){
        System.out.println(msg);   
    }
    /**
     * A shortcut to System.out.println which will surround the message with some stars to make it stand out.
     * @param msg: the line to be output
     * @return: none 
     */
    public void printFancy(String msg){
        System.out.println("********************************");
        System.out.println(msg);   
        System.out.println("********************************");
    }
  
 }
