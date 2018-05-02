package com.example.richard.smarttabs.userinputsounddraw;

/**
 * Created by richard on 05.03.2018.
 */

public class MicInputResult {


    public String processPitch(float pitchInHz) {

        if(pitchInHz >= 110 && pitchInHz < 123.47) {
            //A
            return "A";
        }
        else if(pitchInHz >= 123.47 && pitchInHz < 130.81) {
            //B
            return "B";
        }
        else if(pitchInHz >= 130.81 && pitchInHz < 146.83) {
            //C
            return "C";
        }
        else if(pitchInHz >= 146.83 && pitchInHz < 164.81) {
            //D
            return "D";
        }
        else if(pitchInHz >= 164.81 && pitchInHz <= 174.61) {
            //E
            return "E";
        }
        else if(pitchInHz >= 174.61 && pitchInHz < 185) {
            //F
            return "F";
        }
        else if(pitchInHz >= 185 && pitchInHz < 196) {
            //G
            return "G";
        }
        return null;
    }

    public int processPlayerCoordinate(float pitchInHz){
        if(pitchInHz >= 110 && pitchInHz < 123.47) {
            //A
            return 0;
        }
        else if(pitchInHz >= 123.47 && pitchInHz < 130.81) {
            //B
            return 40;
        }
        else if(pitchInHz >= 130.81 && pitchInHz < 146.83) {
            //C
            return 80;
        }
        else if(pitchInHz >= 146.83 && pitchInHz < 164.81) {
            //D
            return 120;
        }
        else if(pitchInHz >= 164.81 && pitchInHz <= 174.61) {
            //E
            return 160;
        }
        else if(pitchInHz >= 174.61 && pitchInHz < 185) {
            //F
            return 200;
        }
        else if(pitchInHz >= 185 && pitchInHz < 196) {
            //G
            return 240;
        }
        return 0;
    }
}
