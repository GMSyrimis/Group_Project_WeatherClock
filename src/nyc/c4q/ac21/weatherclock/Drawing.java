package nyc.c4q.ac21.weatherclock;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by c4q-george on 4/5/15.
 */

public class Drawing {


    public static ArrayList<String> getPrintLines(String rawWeekday){

        ArrayList<String> fullPrint =  new ArrayList<String>();

        String firstLine =  "";
        String secondLine = "";
        String thirdLine =  "";
        String fourthLine = "";
        String fifthLine =  "";

        for(int i =0; i<rawWeekday.length(); i++){

            char rawLetter = rawWeekday.charAt(i);

            if(rawLetter == 'a'){
                firstLine +=" "+"         "+" ";
                secondLine+=" "+"         "+" ";
                thirdLine+= " "+"███████  "+" ";
                fourthLine+=" "+"██   ██ █"+" ";
                fifthLine+= " "+"█████████"+" ";
            }
            if(rawLetter == 'b'){
                firstLine +=" "+"██     "+" ";
                secondLine+=" "+"██     "+" ";
                thirdLine+= " "+"███████"+" ";
                fourthLine+=" "+"██   ██"+" ";
                fifthLine+= " "+"███████"+" ";
            }
            if(rawLetter == 'c') {
                firstLine+=  " "+"      "+" ";
                secondLine+= " "+"      "+" ";
                thirdLine+=  " "+"██████"+" ";
                fourthLine+= " "+"██    "+" ";
                fifthLine+=  " "+"██████"+" ";
            }
            if(rawLetter == 'd'){
                firstLine +=  " "+"     ██"+" ";
                secondLine += " "+"     ██"+" ";
                thirdLine +=  " "+"███████"+" ";
                fourthLine += " "+"██   ██"+" ";
                fifthLine+=   " "+"███████"+" ";
            }
            if(rawLetter == 'e'){
                firstLine +=  " "+"       "+" ";
                secondLine += " "+"  ███  "+" ";
                thirdLine +=  " "+"██   ██"+" ";
                fourthLine += " "+"██ ██  "+" ";
                fifthLine +=  " "+" █████ "+" ";
            }
            if(rawLetter == 'f'){
                firstLine +=  " "+" █████ "+" ";
                secondLine += " "+"██   ██"+" ";
                thirdLine +=  " "+"████   "+" ";
                fourthLine += " "+"██     "+" ";
                fifthLine +=  " "+"██     "+" ";
            }
            if(rawLetter == 'g'){
                firstLine +=  " "+" █████ "+" ";
                secondLine += " "+"██   ██"+" ";
                thirdLine +=  " "+" ██████"+" ";
                fourthLine += " "+"     ██"+" ";
                fifthLine +=  " "+"  ████ "+" ";
            }
            if(rawLetter == 's'){
                firstLine +=  " "+" █████ "+" ";
                secondLine += " "+"██     "+" ";
                thirdLine +=  " "+" █████ "+" ";
                fourthLine += " "+"     ██"+" ";
                fifthLine +=  " "+" █████ "+" ";
            }
            if(rawLetter == 'h'){
                firstLine +=" "+"██     "+" ";
                secondLine+=" "+"██     "+" ";
                thirdLine+= " "+"███████"+" ";
                fourthLine+=" "+"██   ██"+" ";
                fifthLine+= " "+"██   ██"+" ";
            }
            if(rawLetter == 'i'){
                firstLine +=" "+"██"+" ";
                secondLine+=" "+"  "+" ";
                thirdLine+= " "+"██"+" ";
                fourthLine+=" "+"██"+" ";
                fifthLine+= " "+"██"+" ";
            }
            if(rawLetter == 'r'){
                firstLine +=" "+"      "+" ";
                secondLine+=" "+"      "+" ";
                thirdLine+= " "+"█████ "+" ";
                fourthLine+=" "+"██  ██"+" ";
                fifthLine+= " "+"██    "+" ";
            }
            if(rawLetter == 'u'){
                firstLine +=  " "+"       "+" ";
                secondLine += " "+"       "+" ";
                thirdLine +=  " "+"██   ██"+" ";
                fourthLine += " "+"██   ██"+" ";
                fifthLine+=   " "+"███████"+" ";
            }
            if(rawLetter == 't'){
                firstLine +=  " "+"      "+" ";
                secondLine += " "+"  ██  "+" ";
                thirdLine +=  " "+"██████"+" ";
                fourthLine += " "+"  ██  "+" ";
                fifthLine+=   " "+"  ████"+" ";
            }
            if(rawLetter == 'm'){
                firstLine +=  " "+"       "+" ";
                secondLine += " "+"█      "+" ";
                thirdLine +=  " "+"███████"+" ";
                fourthLine += " "+"██ ██ █"+" ";
                fifthLine+=   " "+"██ ██ █"+" ";
            }
            if(rawLetter == 'n'){
                firstLine +=" "+"       "+" ";
                secondLine+=" "+"█      "+" ";
                thirdLine+= " "+"███████"+" ";
                fourthLine+=" "+"██   ██"+" ";
                fifthLine+= " "+"██   ██"+" ";
            }
            if(rawLetter == 'o'){
                firstLine +=" "+"       "+" ";
                secondLine+=" "+"       "+" ";
                thirdLine+= " "+"███████"+" ";
                fourthLine+=" "+"██   ██"+" ";
                fifthLine+= " "+"███████"+" ";
            }
            if(rawLetter == 'p'){
                firstLine +=  " "+"██████ "+" ";
                secondLine += " "+"██   ██"+" ";
                thirdLine +=  " "+"██████ "+" ";
                fourthLine += " "+"██     "+" ";
                fifthLine +=  " "+"██     "+" ";
            }
            if(rawLetter == 'v'){
                firstLine +=" "+"      "+" ";
                secondLine+=" "+"      "+" ";
                thirdLine+= " "+"██  ██"+" ";
                fourthLine+=" "+" █  █ "+" ";
                fifthLine+= " "+"  ██  "+" ";
            }
            if(rawLetter == 'y'){
                firstLine +=  " "+"██   ██"+" ";
                secondLine += " "+"██   ██"+" ";
                thirdLine +=  " "+" ██████"+" ";
                fourthLine += " "+"     ██"+" ";
                fifthLine +=  " "+"  ████ "+" ";
            }
            if(rawLetter == '0'){
                firstLine +=  " "+"███████"+" ";
                secondLine += " "+"██   ██"+" ";
                thirdLine +=  " "+"██   ██"+" ";
                fourthLine += " "+"██   ██"+" ";
                fifthLine +=  " "+"███████"+" ";
            }
            if(rawLetter == '1'){
                firstLine +=  " "+"██"+" ";
                secondLine += " "+"██"+" ";
                thirdLine +=  " "+"██"+" ";
                fourthLine += " "+"██"+" ";
                fifthLine +=  " "+"██"+" ";
            }
            if(rawLetter == '2'){
                firstLine +=  " "+" ████  "+" ";
                secondLine += " "+"█    ██"+" ";
                thirdLine +=  " "+"   ██  "+" ";
                fourthLine += " "+" ██    "+" ";
                fifthLine +=  " "+"███████"+" ";
            }
            if(rawLetter == '3'){
                firstLine +=  " "+" █████ "+" ";
                secondLine += " "+"█    ██"+" ";
                thirdLine +=  " "+"   ███ "+" ";
                fourthLine += " "+"█    ██"+" ";
                fifthLine +=  " "+" █████ "+" ";
            }
            if(rawLetter == '4'){
                firstLine +=  " "+"██   ██  "+" ";
                secondLine += " "+"██   ██  "+" ";
                thirdLine +=  " "+"█████████"+" ";
                fourthLine += " "+"     ██  "+" ";
                fifthLine +=  " "+"     ██  "+" ";
            }
            if(rawLetter == '5'){
                firstLine +=  " "+"███████"+" ";
                secondLine += " "+"██     "+" ";
                thirdLine +=  " "+"██████ "+" ";
                fourthLine += " "+"     ██"+" ";
                fifthLine +=  " "+"██████ "+" ";
            }
            if(rawLetter == '6'){
                firstLine +=  " "+"███████"+" ";
                secondLine += " "+"██     "+" ";
                thirdLine +=  " "+"███████"+" ";
                fourthLine += " "+"██   ██"+" ";
                fifthLine +=  " "+"███████"+" ";
            }
            if(rawLetter == '7'){
                firstLine +=  " "+"████████"+" ";
                secondLine += " "+"█    ██ "+" ";
                thirdLine +=  " "+"    ██  "+" ";
                fourthLine += " "+"   ██   "+" ";
                fifthLine +=  " "+"  ██    "+" ";
            }
            if(rawLetter == '8'){
                firstLine +=  " "+"███████"+" ";
                secondLine += " "+"██   ██"+" ";
                thirdLine +=  " "+"███████"+" ";
                fourthLine += " "+"██   ██"+" ";
                fifthLine +=  " "+"███████"+" ";
            }
            if(rawLetter == '9'){
                firstLine +=  " "+"███████"+" ";
                secondLine += " "+"██   ██"+" ";
                thirdLine +=  " "+"███████"+" ";
                fourthLine += " "+"     ██"+" ";
                fifthLine +=  " "+"███████"+" ";
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


        return fullPrint;
    }


    public static void main(String[] args){
        ArrayList<String> fullPrint;

        fullPrint = getPrintLines("thursday");

        for (String lines : fullPrint){
            System.out.println(lines);
        }
    }
}
