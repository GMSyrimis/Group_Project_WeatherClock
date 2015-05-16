package nyc.c4q.ac21.weatherclock;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Weather weatherData = new Weather();

        Scanner scanner = new Scanner(System.in);
        System.out.println("How would you like to view your time? ( Military / Standard )");
        String viewTime = scanner.nextLine();


        final int numCols = TerminalSize.getNumColumns();
        final int numRows = TerminalSize.getNumLines();
        final AnsiTerminal terminal = new AnsiTerminal();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                terminal.showCursor();
                terminal.reset();
                terminal.scroll(1);
                terminal.moveTo(numRows, 0);
            }
        });
        terminal.setBackgroundColor(AnsiTerminal.Color.BLACK);
        terminal.clear();
        terminal.hideCursor();

        int blueBannerGraphicX=5;
        int blueBannerGraphicY=numRows/3;
        int blueBannerGraphicWidth=numCols-6;
        int blueBannerGraphicHeight=numRows/3+7;

        int centerBlockGraphicWidth=numCols/3+10;
        int centerBlockGraphicHeight=numRows/3+15;
        int centerBlockGraphicX=numCols/2-centerBlockGraphicWidth/2;
        int centerBlockGraphicY=numRows/5+2;


        Calendar sunrise = weatherData.getSunrise();
        String sunriseTime = DateTime.formatTime(sunrise, false);

        if (sunrise.get(Calendar.HOUR_OF_DAY) >= 12)
            sunriseTime += " PM";
        else
            sunriseTime += " AM";

        Calendar sunset = weatherData.getSunset();
        String sunsetTime = DateTime.formatTime(sunset, false);
        if (sunset.get(Calendar.HOUR_OF_DAY) >= 12)
            sunsetTime += " PM";
        else
            sunsetTime += " AM";


        String weatherDESC = weatherData.getWeatherDescription();
        String w = new String(weatherDESC);
        String humidity = weatherData.getHumidity()+"";
        String h= new String(humidity);
        String pressure = weatherData.getPressure()+"";
        String p = new String(pressure);
        String temp = weatherData.getTemperature()+"";
        String t = new String(temp);
        String wea = weatherData.getWeather();

        while (true) {
            terminal.setBackgroundColor(AnsiTerminal.Color.BLUE, false);
            Drawing banner = new Drawing(terminal,blueBannerGraphicWidth,blueBannerGraphicHeight,blueBannerGraphicX,blueBannerGraphicY);

            terminal.setBackgroundColor(AnsiTerminal.Color.BLUE,true);
            Drawing centerBlock = new Drawing(terminal,centerBlockGraphicWidth,centerBlockGraphicHeight,centerBlockGraphicX,centerBlockGraphicY);

            Calendar cal = Calendar.getInstance();
            String time = DateTime.formatTime(cal, true);
            if(viewTime.equalsIgnoreCase("Standard") || viewTime.equalsIgnoreCase("12 hours"))
            {
                if(cal.get(Calendar.HOUR_OF_DAY) >= 12)
                    time += " PM";
                else
                    time += " AM";
                terminal.setTextColor(AnsiTerminal.Color.WHITE);
                Drawing.getPrintLines(terminal,time.toLowerCase(),numCols/2-30,numRows/5+2);
            }
            else if(viewTime.equalsIgnoreCase("Military") || viewTime
                    .equalsIgnoreCase("24 hours"))
            {
                int hour = cal.get(Calendar.HOUR_OF_DAY);
                if(hour == 0)
                {
                    String militaryTime = "0" + hour + time.substring(2);
                    terminal.setTextColor(AnsiTerminal.Color.WHITE);
                    Drawing.getPrintLines(terminal,militaryTime.toLowerCase(),numCols/2-30,numRows/5+2);
                }
                else if(hour > 0 && hour < 10)
                {
                    String militaryTime = "0" + hour + time.substring(1);
                    terminal.setTextColor(AnsiTerminal.Color.WHITE);
                    Drawing.getPrintLines(terminal,militaryTime.toLowerCase(),numCols/2-30,numRows/5+2);
                }
                else
                {
                    String militaryTime = hour + time.substring(2);
                    terminal.setTextColor(AnsiTerminal.Color.WHITE);
                    Drawing.getPrintLines(terminal,militaryTime.toLowerCase(),numCols/2-30,numRows/5+2);
                }
            }

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

            String dayOfWeek = DateTime.getDayOfWeekNames().get(cal.get(Calendar.DAY_OF_WEEK));
            terminal.setTextColor(AnsiTerminal.Color.GREEN);
            terminal.setBackgroundColor(AnsiTerminal.Color.BLUE,true);
            Drawing.getPrintLines(terminal,dayOfWeek.toLowerCase(),numCols/2-30,numRows/5*4-3);

            terminal.setBackgroundColor(AnsiTerminal.Color.BLUE,false);
            terminal.setTextColor(AnsiTerminal.Color.YELLOW, false);
            terminal.moveTo(numRows / 3, numCols - 19);
            terminal.write("Sunset at " + sunsetTime);
            terminal.setBackgroundColor(AnsiTerminal.Color.BLUE,false);
            terminal.setTextColor(AnsiTerminal.Color.YELLOW, true);
            terminal.moveTo(numRows / 3, 5);
            terminal.write("Sunrise at " + sunriseTime);
            if (cal.getTime().before(sunset.getTime())&&cal.getTime().after(sunrise.getTime())) {
                Drawing.printSUN(terminal, cal, sunrise, numRows, numCols);
            }
            Drawing.drawWeather(terminal, numCols / 2 - 12, numRows / 2 - 6, wea);

            terminal.moveTo(numRows / 2 + 6, numCols / 2 - 6);
            terminal.write(w);
            terminal.moveTo(numRows / 3 + 5, numCols / 6 * 5 - 7);
            terminal.write(h + "% humidity");
            terminal.moveTo(numRows / 3 + 2 + 5, numCols / 6 * 5 - 7);
            terminal.write(p + " pressure");
            terminal.moveTo(numRows / 3 + 4 + 5, numCols / 6 * 5 - 7);
            terminal.write(t + " temperature");

            DateTime.pause(1.0);
        }
    }
}
