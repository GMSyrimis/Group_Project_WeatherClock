package nyc.c4q.ac21.weatherclock;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class Main {

    /**
     * SAMPLE CODE: Returns sunset time for the current day.
     */

    // method that returns a calendar with the sunsetTimestamp
    public static Calendar getSunset() {
        //Change the New%20York,NY to a user defined variable
        // Creating a URL object to the JSON generator
        URL url = HTTP.stringToURL("http://api.openweathermap.org/data/2.5/weather?q=New%20York,NY");
        // Goes to the webpage and saves the JSON to a String
        String doc = HTTP.get(url);
        // we create a JSONObject called obj and
        // we typecast JSONValue.parse(doc) to JSONObject
        JSONObject obj = (JSONObject) JSONValue.parse(doc);
        // New JSONObject called sys
        // This we call get on obj
        JSONObject sys = (JSONObject) obj.get("sys");
        // check if out sys JSONObject is null
        if (sys == null)
            return null;
        // Getting the sunsetTimestamp from sys
        Long sunsetTimestamp = (Long) sys.get("sunset");
        // Checking if the timestamp is null
        if (sunsetTimestamp == null)
            return null;
        // Returning a calendar with the timestamp using the DateTime class
        return DateTime.fromTimestamp(sunsetTimestamp);
    }

    /**
     * SAMPLE CODE: Displays a very primitive clock.
     */


    public static void main(String[] args) {

//--------------- TERMINAL LOGISTICS --------------------
        // Find out the size of the terminal currently.
        final int numCols = TerminalSize.getNumColumns();
        final int numRows = TerminalSize.getNumLines();
        // Create the terminal.
        final AnsiTerminal terminal = new AnsiTerminal();
        // When the program shuts down, reset the terminal to its original state.
        // This code makes sure the terminal is reset even if you kill your
        // program by pressing Control-C.
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                terminal.showCursor();
                terminal.reset();
                terminal.scroll(1);
                terminal.moveTo(numRows, 0);
            }
        });
        // Clear the screen to black.
        terminal.setBackgroundColor(AnsiTerminal.Color.BLACK);
        terminal.clear();
        // Don't show the cursor.
        terminal.hideCursor();
//------------- TERMINAL IS SET UP ----------------------



        // Get sunset time for the current day.
        Calendar sunset = getSunset();

        int xPosition = 1 + numCols / 2 - 5;
        int clockPosition = 1+numCols / 4 - 5;


        while (true) {
            //BUILDING THE SUN ARC
            int startARC = 3;
            int endARC = numCols-3;
            int maxHeightARC = numRows/5;

            ArrayList<String> sunTEST;
            sunTEST = Drawing.getPrintLines("*");

            for(int posY=0; posY<maxHeightARC; posY++){
                // posY from 0 to 15 say
                int posX = (-1*(posY*posY)) + 21*posY + numCols/2-6;
                // first part grows dramatically as posY is squared and we make it majorly negative by *-1
                // second part we add a major positive that doesn't grow exponentially
                // third we add another big positive number that is stable
                for (int i=0; i<sunTEST.size(); i++){
                    terminal.moveTo(posY+i+2, posX);
                    terminal.write(sunTEST.get(i));
                }
//                terminal.moveTo(posY, posX);
//                terminal.write("+");
            }
            for(int posY=0; posY<maxHeightARC; posY++){
                // posY from 0 to 15 say
                int posX = (posY*posY) - 21*posY + numCols/2+6;
                // first part grows dramatically as posY is squared and we make it majorly negative by *-1
                // second part we add a major positive that doesn't grow exponentially
                // third we add another big positive number that is stable
                for (int i=0; i<sunTEST.size(); i++){
                    terminal.moveTo(posY+i+2, posX);
                    terminal.write(sunTEST.get(i));
                }
//                terminal.moveTo(posY, posX);
//                terminal.write("+");
            }



            // Get the current date and time.
            Calendar cal = Calendar.getInstance();
           
            // Write the time, including seconds, in white.
            String time = DateTime.formatTime(cal, true);

            if (cal.get(Calendar.HOUR_OF_DAY) >= 12)
                time += " PM";
            else
                time += " AM";
            terminal.setTextColor(AnsiTerminal.Color.WHITE);

            ArrayList<String> fullTime;
            fullTime = Drawing.getPrintLines(time.toLowerCase());

            for (int i=0; i<fullTime.size(); i++){
                terminal.moveTo(22+i, 2);
                terminal.write("  " + fullTime.get(i) + "  ");
            }


            // Write the date in gray.
            String date = DateTime.formatDate(cal);

            terminal.setTextColor(AnsiTerminal.Color.WHITE, false);

            ArrayList<String> fullDate;
            fullDate = Drawing.getPrintLines(date);
            for (int i=0; i<fullDate.size(); i++){
                terminal.moveTo(29+i, 2);
                terminal.write("  " + fullDate.get(i) + "  ");
            }

            // Write the day of the week in green on a blue background.
            String dayOfWeek = DateTime.getDayOfWeekNames().get(cal.get(Calendar.DAY_OF_WEEK));

            terminal.setTextColor(AnsiTerminal.Color.GREEN);
            terminal.setBackgroundColor(AnsiTerminal.Color.BLUE);
            // loop through the array
            ArrayList<String> fullPrint;
            fullPrint = Drawing.getPrintLines(dayOfWeek.toLowerCase());
            for (int i=0; i<fullPrint.size(); i++){
                terminal.moveTo(37+i, 2);
                terminal.write("  " + fullPrint.get(i) + "  ");
            }

            // Set the background color back to black.
            terminal.setBackgroundColor(AnsiTerminal.Color.BLACK);

            // Write sunset time in dark yellow.
            String sunsetTime = DateTime.formatTime(sunset, false);
            terminal.setTextColor(AnsiTerminal.Color.YELLOW, false);
            terminal.moveTo(21, 2);
            terminal.write("sunset at " + sunsetTime);

            // Pause for one second, and do it again.
            DateTime.pause(1.0);
        }
    }
}
