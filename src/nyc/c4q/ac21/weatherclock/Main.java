package nyc.c4q.ac21.weatherclock;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class Main {

    /**
     * SAMPLE CODE: Returns sunset time for the current day.
     */

    public static Calendar getSunrise() {
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
            return Calendar.getInstance();//REMOVE ME
        // Getting the sunsetTimestamp from sys
        Long sunriseTimestamp = (Long) sys.get("sunrise");
        // Checking if the timestamp is null
        if (sunriseTimestamp == null)
            return Calendar.getInstance();//REMOVE ME
        // Returning a calendar with the timestamp using the DateTime class
        return DateTime.fromTimestamp(sunriseTimestamp);
    }


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
            return Calendar.getInstance();//REMOVE ME
        // Getting the sunsetTimestamp from sys
        Long sunsetTimestamp = (Long) sys.get("sunset");
        // Checking if the timestamp is null
        if (sunsetTimestamp == null)
            return Calendar.getInstance();//REMOVE ME
        // Returning a calendar with the timestamp using the DateTime class
        return DateTime.fromTimestamp(sunsetTimestamp);
    }




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


        int blueBannerGraphicX=5;
        int blueBannerGraphicY=numRows/3;
        int blueBannerGraphicWidth=numCols-6;
        int blueBannerGraphicHeight=numRows/3+7;

        int centerBlockGraphicWidth=numCols/3+10;
        int centerBlockGraphicHeight=numRows/3+15;
        int centerBlockGraphicX=numCols/2-centerBlockGraphicWidth/2;
        int centerBlockGraphicY=numRows/5+2;


        Calendar sunrise = getSunrise();
        String sunriseTime = DateTime.formatTime(sunrise, false);

        if (sunrise.get(Calendar.HOUR_OF_DAY) >= 12)
            sunriseTime += " PM";
        else
            sunriseTime += " AM";
        Calendar sunset = getSunset();
        String sunsetTime = DateTime.formatTime(sunset, false);
        if (sunset.get(Calendar.HOUR_OF_DAY) >= 12)
            sunsetTime += " PM";
        else
            sunsetTime += " AM";


        while (true) {


            terminal.setBackgroundColor(AnsiTerminal.Color.BLUE, false);
            Drawing banner = new Drawing(terminal,blueBannerGraphicWidth,blueBannerGraphicHeight,blueBannerGraphicX,blueBannerGraphicY);

            terminal.setBackgroundColor(AnsiTerminal.Color.BLUE,true);
            Drawing centerBlock = new Drawing(terminal,centerBlockGraphicWidth,centerBlockGraphicHeight,centerBlockGraphicX,centerBlockGraphicY);


            // Get the current date and time and continuously updates.
            Calendar cal = Calendar.getInstance();

            String time = DateTime.formatTime(cal, true);
            if (cal.get(Calendar.HOUR_OF_DAY) >= 12)
                time += " PM";
            else
                time += " AM";
            terminal.setTextColor(AnsiTerminal.Color.WHITE);
            terminal.setBackgroundColor(AnsiTerminal.Color.BLUE,true);
            Drawing.getPrintLines(terminal,time.toLowerCase(),numCols/2-30,numRows/5+2);


//            String date = DateTime.formatDate(cal);
//            terminal.setTextColor(AnsiTerminal.Color.WHITE, false);
//            Drawing.getPrintLines(terminal,date,20,20);


            //Prints Daylight Savings Time
            boolean isDST = DST.isDST(cal);
            String dstInEffect = "";
            if(isDST == true) {
                dstInEffect += "In Effect";
            } else {
                dstInEffect += "Not In Effect";
            }
            terminal.moveTo(33, 10);
            terminal.setTextColor(AnsiTerminal.Color.WHITE);
            terminal.setBackgroundColor(AnsiTerminal.Color.BLUE,false);
            terminal.write("Daylight Savings Time: " + dstInEffect);


            //Prints National Holiday -- should we have it to print nothing if it isn't a national holiday?
            HashMap<Calendar, String> holidays = Holidays.getHolidays("National holiday");
            if(holidays.containsKey(cal))
            {
                terminal.moveTo(35, 10);
                terminal.setTextColor(AnsiTerminal.Color.WHITE);
                terminal.setBackgroundColor(AnsiTerminal.Color.BLUE,false);
                terminal.write("national holiday:  " + holidays.get(cal));
            }
            else
            {
                terminal.moveTo(35, 10);
                terminal.setTextColor(AnsiTerminal.Color.WHITE);
                terminal.setBackgroundColor(AnsiTerminal.Color.BLUE,false);
                terminal.write("national holiday:  " + "not a national holiday");
            }


            Drawing.printMonthCalendar(terminal,cal,12,numRows/5*2);

            // GOODISH
            String dayOfWeek = DateTime.getDayOfWeekNames().get(cal.get(Calendar.DAY_OF_WEEK));
            terminal.setTextColor(AnsiTerminal.Color.GREEN);
            terminal.setBackgroundColor(AnsiTerminal.Color.BLUE,true);
//            terminal.moveTo(numRows/5,numCols/2-dayOfWeek.length()/2);
//            terminal.write(dayOfWeek);
            Drawing.getPrintLines(terminal,dayOfWeek.toLowerCase(),numCols/2-30,numRows/5*4-3);

            //GOOD
            terminal.setBackgroundColor(AnsiTerminal.Color.BLUE,false);
            terminal.setTextColor(AnsiTerminal.Color.YELLOW, false);
            terminal.moveTo(numRows / 3, numCols - 19);
            terminal.write("Sunset at " + sunsetTime);
            //GOOD
            terminal.setBackgroundColor(AnsiTerminal.Color.BLUE,false);
            terminal.setTextColor(AnsiTerminal.Color.YELLOW, true);
            terminal.moveTo(numRows / 3, 5);
            terminal.write("Sunrise at " + sunriseTime);
            //GOOD
            Drawing.printSUN(terminal,cal,sunrise,numRows,numCols);
            Drawing.drawWeather(terminal,numCols/2-12,numRows/2-6,"clearDay");

            // Pause for one second, and do it again.
            DateTime.pause(1.0);
        }
    }
}
