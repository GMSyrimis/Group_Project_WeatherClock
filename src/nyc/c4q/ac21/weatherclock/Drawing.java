package nyc.c4q.ac21.weatherclock;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 * Created by c4q-george on 4/5/15.
 */

public class Drawing {

    private int graphicWidth;
    private int graphicHeight;
    private int graphicX;
    private int graphicY;
    private AnsiTerminal terminal;

    ArrayList<String> fullGraphic;

    public Drawing(AnsiTerminal terminal, int graphicWidth,int graphicHeight, int graphicX,int graphicY){
        this.graphicHeight=graphicHeight;
        this.graphicWidth=graphicWidth;
        this.graphicX=graphicX;
        this.graphicY=graphicY;
        this.terminal=terminal;
        terminal.moveTo(graphicY,graphicX);

        fullGraphic =  new ArrayList<String>();
        for(int i=0; i<graphicHeight; i++){
            String fullLine ="";
            for(int k=0; k<graphicWidth;k++){
                fullLine+=" ";
            }
            fullGraphic.add(fullLine);
        }
        // created an empty space
        //PRINTING GRAPHIC
        for (int i=0; i<fullGraphic.size(); i++){
            terminal.moveTo(graphicY+i, graphicX);
            terminal.write(fullGraphic.get(i));
        }
    }


    public static void drawWeather(AnsiTerminal terminal, int x, int y, String rawString)
    {

        ArrayList<String> fullPrint = new ArrayList<String>();

        String firstLine = "";
        String secondLine = "";
        String thirdLine = "";
        String fourthLine = "";
        String fifthLine = "";
        String sixthLine = "";
        String seventhLine = "";
        String eighthLine = "";
        String ninthLine = "";
        String tenthLine = "";
        String eleventhLine = "";
        String twelfthLine = "";


        String weather = rawString;
        // fill these in with the weather strings returned by the api
        String clearDay = "clearDay";
        String clearNight = "";
        String partlyCloudyDay = "";
        String partlyCloudyNight = "";
        String cloudy = "";
        String lightRain = "";
        String rainy = "";
        String thunderstorm = "";
        String snow = "";


        if(weather.equals(clearDay)){

            firstLine+=   " "+"         |         "+" ";
            secondLine+=  " "+" \\       |       / "+" ";
            thirdLine+=   " "+"  \\   ◉◉◉◉◉◉◉   /  "+" ";
            fourthLine+=  " "+"   \\ ◉◉◉◉◉◉◉◉◉ /   "+" ";
            fifthLine+=   " "+"    ◉◉◉◉◉◉◉◉◉◉◉    "+" ";
            sixthLine+=   " "+"   ◉◉◉◉◉◉◉◉◉◉◉◉◉   "+" ";
            seventhLine+= " "+"---◉◉◉◉◉◉◉◉◉◉◉◉◉---"+" ";
            eighthLine+=  " "+"    ◉◉◉◉◉◉◉◉◉◉◉    "+" ";
            ninthLine+=   " "+"     ◉◉◉◉◉◉◉◉◉     "+" ";
            tenthLine+=   " "+"    / ◉◉◉◉◉◉◉ \\    "+" ";
            eleventhLine+=" "+"   /     |     \\   "+" ";
            twelfthLine+= " "+"  /      |      \\  "+" ";

        }
        if(weather.equals(clearNight)){

            firstLine+=   " "+"                    "+" ";
            secondLine+=  " "+"      ◉◉◉◉◉◉◉◉◉     "+" ";
            thirdLine+=   " "+"     ◉◉◌◌◌◌◌◌◌◉◉    "+" ";
            fourthLine+=  " "+"    ◉◉◌  ◌◌◌  ◌◉◉   "+" ";
            fifthLine+=   " "+"   ◉◉◌   ◌◌◌◌◌◌◌◉◉  "+" ";
            sixthLine+=   " "+"   ◉◌◌◌◌◌◌◌◌◌◌ ◌◌◉  "+" ";
            seventhLine+= " "+"   ◉◉◌◌◌◌  ◌◌◌◌◌◉◉  "+" ";
            eighthLine+=  " "+"    ◉◉◌◌  ◌◌◌◌◌◉◉   "+" ";
            ninthLine+=   " "+"     ◉◉◌◌◌◌  ◌◉◉    "+" ";
            tenthLine+=   " "+"      ◉◉◉◉◉◉◉◉◉     "+" ";
            eleventhLine+=" "+"                    "+" ";
            twelfthLine+= " "+"                    "+" ";

        }
        if(weather.equals(partlyCloudyNight)){

            firstLine+=   " "+"                            "+" ";
            secondLine+=  " "+"      ◉◉◉◉◉◉◉◉◉             "+" ";
            thirdLine+=   " "+"     ◉◉◌◌◌◌◌◌◌◉◉            "+" ";
            fourthLine+=  " "+"    ◉◉◌  ◌◌◌  ◌◉◉           "+" ";
            fifthLine+=   " "+"   ◉◉◌   ◌◌◌◌◌◌◌◉◉          "+" ";
            sixthLine+=   " "+"   ◉▢▢▢▢▢▢▢▢▢▢▢▢▢▢▢▢▢▢▢▢    "+" ";
            seventhLine+= " "+"  ▢▢▢                 ▢▢▢▢  "+" ";
            eighthLine+=  " "+" ▢  ▢▢▢▢                  ▢ "+" ";
            ninthLine+=   " "+"▢       This is a cloud    ▢"+" ";
            tenthLine+=   " "+" ▢                         ▢"+" ";
            eleventhLine+=" "+"  ▢▢▢▢                ▢▢▢▢▢ "+" ";
            twelfthLine+= " "+"     ▢▢▢▢▢▢   ▢▢▢▢▢▢▢▢      "+" ";

        }
        if(weather.equals(partlyCloudyDay)){

            firstLine+=   " "+"         |                  "+" ";
            secondLine+=  " "+" \\       |       /         "+" ";
            thirdLine+=   " "+"  \\   ◉◉◉◉◉◉◉   /          "+" ";
            fourthLine+=  " "+"   \\ ◉◉◉◉◉◉◉◉◉ /           "+" ";
            fifthLine+=   " "+"    ◉◉◉◉◉◉◉◉◉◉◉             "+" ";
            sixthLine+=   " "+"    ▢▢▢▢▢▢▢▢▢▢▢▢▢▢▢▢▢▢▢▢    "+" ";
            seventhLine+= " "+"  ▢▢▢                 ▢▢▢▢  "+" ";
            eighthLine+=  " "+" ▢  ▢▢▢▢                  ▢ "+" ";
            ninthLine+=   " "+"▢       This is a cloud    ▢"+" ";
            tenthLine+=   " "+" ▢                         ▢"+" ";
            eleventhLine+=" "+"  ▢▢▢▢                ▢▢▢▢▢ "+" ";
            twelfthLine+= " "+"     ▢▢▢▢▢▢   ▢▢▢▢▢▢▢▢      "+" ";

        }
        if(weather.equals(cloudy)){

            firstLine+=   " "+"   ◍◍◍◍◍◍◍◍◍◍               "+" ";
            secondLine+=  " "+" ◍◍◍◍◍◍   ◍◍◍◍◍◍◍◍◍◍◍◍      "+" ";
            thirdLine+=   " "+"  ◍◍◍        ◍◍◍◍   ◍◍◍◍◍   "+" ";
            fourthLine+=  " "+"    ◍◍◍◍    ◍◍◍  ◍◍◍◍   ◍◍  "+" ";
            fifthLine+=   " "+"  ◍◍◍◍◍     ◍◍        ◍◍◍◍  "+" ";
            sixthLine+=   " "+"   ◍▢▢▢▢▢▢▢▢▢▢▢▢▢▢▢▢▢▢▢▢◍◍◍ "+" ";
            seventhLine+= " "+"  ▢▢▢                 ▢▢▢▢◍◍"+" ";
            eighthLine+=  " "+" ▢  ▢▢▢▢                  ▢ "+" ";
            ninthLine+=   " "+"▢     These are a clouds   ▢"+" ";
            tenthLine+=   " "+" ▢                         ▢"+" ";
            eleventhLine+=" "+"  ▢▢▢▢                ▢▢▢▢▢ "+" ";
            twelfthLine+= " "+"     ▢▢▢▢▢▢   ▢▢▢▢▢▢▢▢      "+" ";

        }
        if(weather.equals(lightRain)){

            firstLine+=   " "+"    ▢▢▢▢▢▢▢▢▢▢▢▢▢▢▢▢▢▢▢▢    "+" ";
            secondLine+=  " "+"  ▢▢▢                 ▢▢▢▢  "+" ";
            thirdLine+=   " "+" ▢  ▢▢▢▢                  ▢ "+" ";
            fourthLine+=  " "+"▢          Cloud           ▢"+" ";
            fifthLine+=   " "+" ▢                         ▢"+" ";
            sixthLine+=   " "+"  ▢▢▢▢                ▢▢▢▢▢ "+" ";
            seventhLine+= " "+"     ▢▢▢▢▢▢   ▢▢▢▢▢▢▢▢      "+" ";
            eighthLine+=  " "+"         /       /          "+" ";
            ninthLine+=   " "+"            /         /     "+" ";
            tenthLine+=   " "+"                            "+" ";
            eleventhLine+=" "+"     /         /            "+" ";
            twelfthLine+= " "+"                            "+" ";

        }
        if(weather.equals(rainy)){

            firstLine+=   " "+"    ▢▢▢▢▢▢▢▢▢▢▢▢▢▢▢▢▢▢▢▢    "+" ";
            secondLine+=  " "+"  ▢▢▢                 ▢▢▢▢  "+" ";
            thirdLine+=   " "+" ▢  ▢▢▢▢                  ▢ "+" ";
            fourthLine+=  " "+"▢          Cloud           ▢"+" ";
            fifthLine+=   " "+" ▢                         ▢"+" ";
            sixthLine+=   " "+"  ▢▢▢▢                ▢▢▢▢▢ "+" ";
            seventhLine+= " "+" /   ▢▢▢▢▢▢   ▢▢▢▢▢▢▢▢ /    "+" ";
            eighthLine+=  " "+"   //   /   /    /   /  //  "+" ";
            ninthLine+=   " "+"     /   /    / //    /  /  "+" ";
            tenthLine+=   " "+" /        //      /    /    "+" ";
            eleventhLine+=" "+"     /       /  /  /        "+" ";
            twelfthLine+= " "+"  //      /          /      "+" ";

        }
        if(weather.equals(thunderstorm)){

            firstLine+=   " "+"    ▢▢▢▢▢▢▢▢▢▢▢▢▢▢▢▢▢▢▢▢    "+" ";
            secondLine+=  " "+"  ▢▢▢                 ▢▢▢▢  "+" ";
            thirdLine+=   " "+" ▢  ▢▢▢▢                  ▢ "+" ";
            fourthLine+=  " "+"▢        Thundercloud      ▢"+" ";
            fifthLine+=   " "+" ▢                         ▢"+" ";
            sixthLine+=   " "+"  ▢▢▢▢      ___       ▢▢▢▢▢ "+" ";
            seventhLine+= " "+"   / ▢▢▢▢▢▢|   |▢▢▢▢▢▢▢▢    "+" ";
            eighthLine+=  " "+"          /   /    /        "+" ";
            ninthLine+=   " "+"    /     |  |___        /  "+" ";
            tenthLine+=   " "+"          |__   /    /      "+" ";
            eleventhLine+=" "+"     /       | /            "+" ";
            twelfthLine+= " "+"/            |/        /    "+" ";

        }
        if(weather.equals(snow)){

            firstLine+=   " "+"    ◍◍◍◍◍◍◍◍◍◍◍◍◍◍◍◍◍◍◍     "+" ";
            secondLine+=  " "+"  ◍◍◍                 ◍◍◍◍  "+" ";
            thirdLine+=   " "+" ◍◍  ◍◍◍◍                 ◍◍"+" ";
            fourthLine+=  " "+"◍           Cloud          ◍"+" ";
            fifthLine+=   " "+" ◍◍                      ◍◍◍"+" ";
            sixthLine+=   " "+"  ◍◍◍◍                ◍◍◍◍ ◞"+" ";
            seventhLine+= " "+"  ◜   ◍◍◍◍◍◍◍◍   ◍◍◍◍◍◍◍◍   "+" ";
            eighthLine+=  " "+"    ◝       ◝   ◜      ◜    "+" ";
            ninthLine+=   " "+"     ◜   ◝        ◞    ◞    "+" ";
            tenthLine+=   " "+"  ◝   ◟      ◜      ◜     ◞ "+" ";
            eleventhLine+=" "+"    ◜      ◟   ◜  ◝         "+" ";
            twelfthLine+= " "+"◟     ◝   ◟         ◟     ◜ "+" ";

        }

        fullPrint.add(firstLine);
        fullPrint.add(secondLine);
        fullPrint.add(thirdLine);
        fullPrint.add(fourthLine);
        fullPrint.add(fifthLine);
        fullPrint.add(sixthLine);
        fullPrint.add(seventhLine);
        fullPrint.add(eighthLine);
        fullPrint.add(ninthLine);
        fullPrint.add(tenthLine);
        fullPrint.add(eleventhLine);
        fullPrint.add(twelfthLine);

        terminal.setBackgroundColor(AnsiTerminal.Color.BLUE,true);
        terminal.setTextColor(AnsiTerminal.Color.YELLOW, true);

        for (int i=0; i<fullPrint.size(); i++){
            terminal.moveTo(y+i, x);
            terminal.write(fullPrint.get(i));
        }

    }

    public static void printSUN(AnsiTerminal terminal, Calendar currentTIME,Calendar sunrise, int numRows,int numCols){

        int sunriseTime = sunrise.get(Calendar.HOUR_OF_DAY);
        int current = currentTIME.get(Calendar.HOUR_OF_DAY);

        //BUILDING THE SUN ARC
        int maxHeightARC = numRows/5;
        ArrayList<Integer> coordinatesX = new ArrayList<Integer>();
        ArrayList<Integer> coordinatesY = new ArrayList<Integer>();
        int whichSun = current-sunriseTime;

        for(int posY=0; posY<maxHeightARC-4; posY++){
            int posX = (posY*posY) - 21*posY + numCols/2-4;
            coordinatesX.add(posX);
            coordinatesY.add(posY);
        }
        for(int posY=1; posY<maxHeightARC-4; posY++){
            int posX = (-1*(posY*posY)) + 21*posY + numCols/2-4;
            coordinatesX.add(posX);
            coordinatesY.add(posY);
        }

        ArrayList<String> sunTEST;
        sunTEST = Drawing.getArraylist("*");
        for (int i=0; i<sunTEST.size(); i++){
            terminal.setBackgroundColor(AnsiTerminal.Color.BLACK);
            terminal.setTextColor(AnsiTerminal.Color.YELLOW, true);
            terminal.moveTo(coordinatesY.get(whichSun)+i+2,coordinatesX.get(whichSun) );
            terminal.write(sunTEST.get(i));
        }

    }

    // pass it a terminal let it do things
    public static void getPrintLines(AnsiTerminal terminal,String rawString, int x,int y){
            ArrayList<String> fullPrint =  new ArrayList<String>();
            String firstLine =    "";
            String secondLine =   "";
            String thirdLine =    "";
            String fourthLine =   "";
            String fifthLine =    "";
            for(int i =0; i<rawString.length(); i++){
                char rawLetter = rawString.charAt(i);
                if(rawLetter == 'a'){
                    firstLine +=" "+"█████"+" ";
                    secondLine+=" "+"█   █"+" ";
                    thirdLine+= " "+"█████"+" ";
                    fourthLine+=" "+"█   █"+" ";
                    fifthLine+= " "+"█   █"+" ";
                }
                if(rawLetter == 'b'){
                    firstLine +=" "+"█████ "+" ";
                    secondLine+=" "+"█    █"+" ";
                    thirdLine+= " "+"█████ "+" ";
                    fourthLine+=" "+"█    █"+" ";
                    fifthLine+= " "+"█████ "+" ";
                }
                if(rawLetter == 'c') {
                    firstLine+=  " "+"█████"+" ";
                    secondLine+= " "+"█    "+" ";
                    thirdLine+=  " "+"█    "+" ";
                    fourthLine+= " "+"█    "+" ";
                    fifthLine+=  " "+"█████"+" ";
                }
                if(rawLetter == 'd'){
                    firstLine +=  " "+"█████ "+" ";
                    secondLine += " "+"█   ██"+" ";
                    thirdLine +=  " "+"█   ██"+" ";
                    fourthLine += " "+"█   ██"+" ";
                    fifthLine+=   " "+"█████ "+" ";
                }
                if(rawLetter == 'e'){
                    firstLine +=  " "+"█████"+" ";
                    secondLine += " "+"█    "+" ";
                    thirdLine +=  " "+"█████"+" ";
                    fourthLine += " "+"█    "+" ";
                    fifthLine +=  " "+"█████"+" ";
                }
                if(rawLetter == 'f'){
                    firstLine +=  " "+"█████"+" ";
                    secondLine += " "+"█    "+" ";
                    thirdLine +=  " "+"████ "+" ";
                    fourthLine += " "+"█    "+" ";
                    fifthLine +=  " "+"█    "+" ";
                }
                if(rawLetter == 'g'){
                    firstLine +=  " "+"█████"+" ";
                    secondLine += " "+"█    "+" ";
                    thirdLine +=  " "+"█ ███"+" ";
                    fourthLine += " "+"█   █"+" ";
                    fifthLine +=  " "+"█████"+" ";
                }
                if(rawLetter == 's'){
                    firstLine +=  " "+" █████"+" ";
                    secondLine += " "+"██    "+" ";
                    thirdLine +=  " "+" ████ "+" ";
                    fourthLine += " "+"    ██"+" ";
                    fifthLine +=  " "+"█████ "+" ";
                }
                if(rawLetter == 'h'){
                    firstLine +=" "+"█   █"+" ";
                    secondLine+=" "+"█   █"+" ";
                    thirdLine+= " "+"█████"+" ";
                    fourthLine+=" "+"█   █"+" ";
                    fifthLine+= " "+"█   █"+" ";
                }
                if(rawLetter == 'i'){
                    firstLine +=" "+"██████"+" ";
                    secondLine+=" "+"  ██  "+" ";
                    thirdLine+= " "+"  ██  "+" ";
                    fourthLine+=" "+"  ██  "+" ";
                    fifthLine+= " "+"██████"+" ";
                }
                if(rawLetter == 'r'){
                    firstLine +=" "+"████  "+" ";
                    secondLine+=" "+"█  ██ "+" ";
                    thirdLine+= " "+"████  "+" ";
                    fourthLine+=" "+"█   █ "+" ";
                    fifthLine+= " "+"█    █"+" ";
                }
                if(rawLetter == 'u'){
                    firstLine +=  " "+"█   █"+" ";
                    secondLine += " "+"█   █"+" ";
                    thirdLine +=  " "+"█   █"+" ";
                    fourthLine += " "+"█   █"+" ";
                    fifthLine+=   " "+"█████"+" ";
                }
                if(rawLetter == 't'){
                    firstLine +=  " "+"██████"+" ";
                    secondLine += " "+"  ██  "+" ";
                    thirdLine +=  " "+"  ██  "+" ";
                    fourthLine += " "+"  ██  "+" ";
                    fifthLine+=   " "+"  ██  "+" ";
                }
                if(rawLetter == 'm'){
                    firstLine +=  " "+"█    █"+" ";
                    secondLine += " "+"██  ██"+" ";
                    thirdLine +=  " "+"█ ██ █"+" ";
                    fourthLine += " "+"█    █"+" ";
                    fifthLine+=   " "+"█    █"+" ";
                }
                if(rawLetter == 'n'){
                    firstLine +=" "+"█   █"+" ";
                    secondLine+=" "+"██  █"+" ";
                    thirdLine+= " "+"█ █ █"+" ";
                    fourthLine+=" "+"█  ██"+" ";
                    fifthLine+= " "+"█   █"+" ";
                }
                if(rawLetter == 'o'){
                    firstLine +=" "+"█████"+" ";
                    secondLine+=" "+"█   █"+" ";
                    thirdLine+= " "+"█   █"+" ";
                    fourthLine+=" "+"█   █"+" ";
                    fifthLine+= " "+"█████"+" ";
                }
                if(rawLetter == 'p'){
                    firstLine +=  " "+"████ "+" ";
                    secondLine += " "+"█  ██"+" ";
                    thirdLine +=  " "+"████ "+" ";
                    fourthLine += " "+"█    "+" ";
                    fifthLine +=  " "+"█    "+" ";
                }
                if(rawLetter == 'v'){
                    firstLine +=" "+"█      █"+" ";
                    secondLine+=" "+"█      █"+" ";
                    thirdLine+= " "+" █    █ "+" ";
                    fourthLine+=" "+"  █  █  "+" ";
                    fifthLine+= " "+"   ██   "+" ";
                }
                if(rawLetter == 'w'){
                    firstLine +=" "+"█     █"+" ";
                    secondLine+=" "+"█     █"+" ";
                    thirdLine+= " "+"█  █  █"+" ";
                    fourthLine+=" "+"███ ███"+" ";
                    fifthLine+= " "+" █   █ "+" ";
                }
                if(rawLetter == 'y'){
                    firstLine +=  " "+"██   ██"+" ";
                    secondLine += " "+" █   █ "+" ";
                    thirdLine +=  " "+"  ███  "+" ";
                    fourthLine += " "+"   █   "+" ";
                    fifthLine +=  " "+"  ███  "+" ";
                }
                if(rawLetter == '0'){
                    firstLine +=  " "+"█████"+" ";
                    secondLine += " "+"█  ██"+" ";
                    thirdLine +=  " "+"█ █ █"+" ";
                    fourthLine += " "+"██  █"+" ";
                    fifthLine +=  " "+"█████"+" ";
                }
                if(rawLetter == '1'){
                    firstLine +=  " "+"  █ "+" ";
                    secondLine += " "+"  █ "+" ";
                    thirdLine +=  " "+"  █ "+" ";
                    fourthLine += " "+"  █ "+" ";
                    fifthLine +=  " "+"  █ "+" ";
                }
                if(rawLetter == '2'){
                    firstLine +=  " "+" ███ "+" ";
                    secondLine += " "+"█   █"+" ";
                    thirdLine +=  " "+"   █ "+" ";
                    fourthLine += " "+" █   "+" ";
                    fifthLine +=  " "+"█████"+" ";
                }
                if(rawLetter == '3'){
                    firstLine +=  " "+" ████ "+" ";
                    secondLine += " "+"█   ██"+" ";
                    thirdLine +=  " "+"  ███ "+" ";
                    fourthLine += " "+"█   ██"+" ";
                    fifthLine +=  " "+" ████ "+" ";
                }
                if(rawLetter == '4'){
                    firstLine +=  " "+"█  █ "+" ";
                    secondLine += " "+"█  █ "+" ";
                    thirdLine +=  " "+"█████"+" ";
                    fourthLine += " "+"   █ "+" ";
                    fifthLine +=  " "+"   █ "+" ";
                }
                if(rawLetter == '5'){
                    firstLine +=  " "+"█████"+" ";
                    secondLine += " "+"██   "+" ";
                    thirdLine +=  " "+"████ "+" ";
                    fourthLine += " "+"   ██"+" ";
                    fifthLine +=  " "+"████ "+" ";
                }
                if(rawLetter == '6'){
                    firstLine +=  " "+"█████"+" ";
                    secondLine += " "+"█    "+" ";
                    thirdLine +=  " "+"█████"+" ";
                    fourthLine += " "+"█   █"+" ";
                    fifthLine +=  " "+"█████"+" ";
                }
                if(rawLetter == '7'){
                    firstLine +=  " "+"█████"+" ";
                    secondLine += " "+"█   █"+" ";
                    thirdLine +=  " "+"   █ "+" ";
                    fourthLine += " "+"  █  "+" ";
                    fifthLine +=  " "+" █   "+" ";
                }
                if(rawLetter == '8'){
                    firstLine +=  " "+"█████"+" ";
                    secondLine += " "+"█   █"+" ";
                    thirdLine +=  " "+"█████"+" ";
                    fourthLine += " "+"█   █"+" ";
                    fifthLine +=  " "+"█████"+" ";
                }
                if(rawLetter == '9'){
                    firstLine +=  " "+"█████"+" ";
                    secondLine += " "+"█   █"+" ";
                    thirdLine +=  " "+"█████"+" ";
                    fourthLine += " "+"    █"+" ";
                    fifthLine +=  " "+"█████"+" ";
                }
                if(rawLetter == ':'){
                    firstLine +=  " "+"  "+" ";
                    secondLine += " "+"██"+" ";
                    thirdLine +=  " "+"  "+" ";
                    fourthLine += " "+"██"+" ";
                    fifthLine +=  " "+"  "+" ";
                }
                if(rawLetter == '-'){
                    firstLine +=  " "+"    "+" ";
                    secondLine += " "+"    "+" ";
                    thirdLine +=  " "+"████"+" ";
                    fourthLine += " "+"    "+" ";
                    fifthLine +=  " "+"    "+" ";
                }
                if(rawLetter == '*'){
                    firstLine +=  " "+"    |    "+" ";
                    secondLine += " "+"   █ █   "+" ";
                    thirdLine +=  " "+"--█sun█--"+" ";
                    fourthLine += " "+"   █ █   "+" ";
                    fifthLine +=  " "+"    |    "+" ";
                }
            }
            fullPrint.add(firstLine);
            fullPrint.add(secondLine);
            fullPrint.add(thirdLine);
            fullPrint.add(fourthLine);
            fullPrint.add(fifthLine);
        for (int i=0; i<fullPrint.size(); i++){
            terminal.moveTo(y+i, x);
            terminal.write(fullPrint.get(i));
        }

    }




    public static ArrayList<String> getArraylist(String rawWeekday){
        ArrayList<String> fullPrint =  new ArrayList<String>();
        String firstLine =  "";
        String secondLine = "";
        String thirdLine =  "";
        String fourthLine = "";
        String fifthLine =  "";
        for(int i =0; i<rawWeekday.length(); i++){
            char rawLetter = rawWeekday.charAt(i);
            if(rawLetter == '*'){
                firstLine +=  " "+"    |    "+" ";
                secondLine += " "+"   ¤ ¤   "+" ";
                thirdLine +=  " "+"--¤sun¤--"+" ";
                fourthLine += " "+"   ¤ ¤   "+" ";
                fifthLine +=  " "+"    |    "+" ";
            }
        }
        fullPrint.add(firstLine);
        fullPrint.add(secondLine);
        fullPrint.add(thirdLine);
        fullPrint.add(fourthLine);
        fullPrint.add(fifthLine);
       return fullPrint;
    }

    public static void printMonthCalendar(AnsiTerminal terminal, Calendar date, int x,int y) {
        ArrayList<String> calendar = new ArrayList<String>();

        // Extract year, month, and day for our date.
        int year = date.get(Calendar.YEAR);
        int month = date.get(Calendar.MONTH);
        int day = date.get(Calendar.DAY_OF_MONTH);

        // First, show the month name and year.
        String monthYear = (String) (DateTime.getMonthNames().get(month) + " " + year);
        String newLine = (String) ("\n");
        calendar.add(monthYear);
        calendar.add(newLine);
        // Start the calendar on the first day of the month.
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, 1);

        // We may need to indent the first line, since some of the days
        // in the first week may not belong to this month.
        int indent = cal.get(Calendar.DAY_OF_WEEK) - Calendar.SUNDAY;
        String indentationWithFirstLine = "";
        for (int i = 0; i < indent; ++i){
            // We use four spaces for each day, below.
            //System.out.print("    ");
            indentationWithFirstLine += "    ";
        }

        //Now print each day of the month.  Keep going until we hit the next month.
        while (cal.get(Calendar.YEAR) == year && cal.get(Calendar.MONTH) == month) {
            // Print the day of the month.  Make sure to always print exactly
            // two characters.
            int d = cal.get(Calendar.DAY_OF_MONTH);
            if (d < 10)
                indentationWithFirstLine += (' ');
            indentationWithFirstLine += (d);

            if (d == day)
                // Today!  Mark the day.
                indentationWithFirstLine += ('*');
            else
                // Not today; leave some space.
                indentationWithFirstLine += (' ');

            if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
            {
                // Saturday: move on to the next line for the next date.
                calendar.add(indentationWithFirstLine);
                System.out.println();
                cal = DateTime.getNextDay(cal);
                break;
            }
            else
                // Other days: just leave an extra space.
                indentationWithFirstLine += (' ');

            // On to the next day.
            cal = DateTime.getNextDay(cal);
            if (cal.get(Calendar.MONTH) != month) {
                calendar.add(indentationWithFirstLine);
            }
        }

        String secondLine = "";
        while (cal.get(Calendar.YEAR) == year && cal.get(Calendar.MONTH) == month) {
            // Print the day of the month.  Make sure to always print exactly
            // two characters.
            int d = cal.get(Calendar.DAY_OF_MONTH);
            if (d < 10)
                secondLine += (' ');
            secondLine += (d);

            if (d == day)
                // Today!  Mark the day.
                secondLine += ('*');
            else
                // Not today; leave some space.
                secondLine += (' ');

            if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
            {
                // Saturday: move on to the next line for the next date.
                calendar.add(secondLine);
                System.out.println();
                cal = DateTime.getNextDay(cal);
                break;
            }
            else
                // Other days: just leave an extra space.
                secondLine += (' ');

            // On to the next day.
            cal = DateTime.getNextDay(cal);
            if (cal.get(Calendar.MONTH) != month) {
                calendar.add(secondLine);
            }
        }

        String thirdLine = "";
        while (cal.get(Calendar.YEAR) == year && cal.get(Calendar.MONTH) == month) {
            // Print the day of the month.  Make sure to always print exactly
            // two characters.
            int d = cal.get(Calendar.DAY_OF_MONTH);
            if (d < 10)
                thirdLine += (' ');
            thirdLine += (d);

            if (d == day)
                // Today!  Mark the day.
                thirdLine += ('*');
            else
                // Not today; leave some space.
                thirdLine += (' ');

            if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
            {
                // Saturday: move on to the next line for the next date.
                calendar.add(thirdLine);
                System.out.println();
                cal = DateTime.getNextDay(cal);
                break;
            }
            else
                // Other days: just leave an extra space.
                thirdLine += (' ');

            // On to the next day.
            cal = DateTime.getNextDay(cal);
            if (cal.get(Calendar.MONTH) != month) {
                calendar.add(thirdLine);
            }
        }

        String fourthLine = "";
        while (cal.get(Calendar.YEAR) == year && cal.get(Calendar.MONTH) == month) {
            // Print the day of the month.  Make sure to always print exactly
            // two characters.
            int d = cal.get(Calendar.DAY_OF_MONTH);
            if (d < 10)
                fourthLine += (' ');
            fourthLine += (d);

            if (d == day)
                // Today!  Mark the day.
                fourthLine += ('*');
            else
                // Not today; leave some space.
                fourthLine += (' ');

            if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
            {
                // Saturday: move on to the next line for the next date.
                calendar.add(fourthLine);
                System.out.println();
                cal = DateTime.getNextDay(cal);
                break;
            }
            else
                // Other days: just leave an extra space.
                fourthLine += (' ');

            // On to the next day.
            cal = DateTime.getNextDay(cal);
            if (cal.get(Calendar.MONTH) != month) {
                calendar.add(fourthLine);
            }
        }

        String fifthLine = "";
        while (cal.get(Calendar.YEAR) == year && cal.get(Calendar.MONTH) == month) {
            // Print the day of the month.  Make sure to always print exactly
            // two characters.
            int d = cal.get(Calendar.DAY_OF_MONTH);
            if (d < 10)
                fifthLine += (' ');
            fifthLine += (d);

            if (d == day)
                // Today!  Mark the day.
                fifthLine += ('*');
            else
                // Not today; leave some space.
                fifthLine += (' ');

            if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
            {
                // Saturday: move on to the next line for the next date.
                calendar.add(fifthLine);
                System.out.println();
                cal = DateTime.getNextDay(cal);
                break;
            }
            else
                // Other days: just leave an extra space.
                fifthLine += (' ');

            // On to the next day.
            cal = DateTime.getNextDay(cal);
            if (cal.get(Calendar.MONTH) != month) {
                calendar.add(fifthLine);
            }
        }

        String sixthLine = "";
        while (cal.get(Calendar.YEAR) == year && cal.get(Calendar.MONTH) == month) {
            // Print the day of the month.  Make sure to always print exactly
            // two characters.
            int d = cal.get(Calendar.DAY_OF_MONTH);
            if (d < 10)
                sixthLine += (' ');
            sixthLine += (d);

            if (d == day)
                // Today!  Mark the day.
                sixthLine += ('*');
            else
                // Not today; leave some space.
                sixthLine += (' ');

            if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
            {
                // Saturday: move on to the next line for the next date.
                calendar.add(sixthLine);
                System.out.println();
                cal = DateTime.getNextDay(cal);
                break;
            }
            else
                // Other days: just leave an extra space.
                sixthLine += (' ');

            // On to the next day.

            cal = DateTime.getNextDay(cal);
            if (cal.get(Calendar.MONTH) != month) {
                calendar.add(sixthLine);
            }

        }

        for (int i=0; i<calendar.size(); i++){
            terminal.moveTo(y+i, x);
            terminal.write(calendar.get(i));
        }

    }

}
