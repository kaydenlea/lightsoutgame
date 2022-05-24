/**
 * Lightsout game extra credit
 * @author Kayden Lea
 * klea@usc.edu
 * ITP 265, Spring 2022
 * [coffee] Class Section
 **/

import java.util.Random;

public class Light{
//TODO: instance variable(s)
    boolean isOn;


//TODO: two class constants
    public static final String ON = "💡";
    public static final String OFF = "⬛";

//TODO: Default Constructor, randomly setting isOn

    public Light() {
        Random generator = new Random();
        boolean value = generator.nextBoolean();
        this.isOn = value;

    }


//TODO: void 'flip' method
    public void flip(){
        if (this.isOn){
            this.isOn = false;
        }
        else{
            this.isOn = true;
        }
    }

//TODO: method indicating light status

    public boolean isOn() {
        return isOn;
    }
}
