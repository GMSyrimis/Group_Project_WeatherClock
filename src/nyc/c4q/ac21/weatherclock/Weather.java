package nyc.c4q.ac21.weatherclock;

/**
 * Created by c4q-george on 4/9/15.
 */
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Calendar;

public class Weather
{

    final static URL url = HTTP.stringToURL("http://api.openweathermap.org/data/2.5/weather?q=New%20York");
    JSONObject obj;

    public Weather() {
        String doc = HTTP.get(url);
        this.obj = (JSONObject) JSONValue.parse(doc);
    }

    public String getWeather()
    {
        JSONArray weatherJSONArray = (JSONArray) obj.get("weather");
        if(weatherJSONArray == null)
            return null;
        JSONObject weatherJSONObj = (JSONObject) weatherJSONArray.get(0);
        if(weatherJSONObj == null)
            return null;
        String weatherDescription = (String)weatherJSONObj.get("main");
        if (weatherDescription == null)
            return null;
        return weatherDescription;
    }

    public String getWeatherDescription()
    {

        JSONArray weatherJSONArray = (JSONArray) obj.get("weather");
        if (weatherJSONArray == null)
            return null;
        JSONObject weatherJSONObj = (JSONObject)weatherJSONArray.get(0);
        if (weatherJSONObj == null)
            return null;
        String weatherDescription = (String)weatherJSONObj.get("description");
        if (weatherDescription == null)
            return null;
        return weatherDescription;
    }

    public Double getTemperature()
    {

        JSONObject main = (JSONObject) obj.get("main");
        if (main == null)
            return null;
        Double temperature = (Double) main.get("temp");
        if (temperature == null)
            return null;
        return temperature;
    }

    public Double getPressure()
    {

        JSONObject main = (JSONObject) obj.get("main");
        if (main == null)
            return null;
        Double pressure = (Double) main.get("pressure");
        if (pressure == null)
            return null;
        return pressure;
    }

    public Long getHumidity()
    {

        JSONObject main = (JSONObject) obj.get("main");
        if (main == null)
            return null;
        Long humidity = (Long) main.get("humidity");
        if (humidity == null)
            return null;
        return humidity;
    }

    public static String fahrenheit (Double temperature) {
        DecimalFormat df = new DecimalFormat("#.##");
        Double intoFarenheit = (temperature - 273.15) * (9.00/5.00) + 32.00;
        return df.format(intoFarenheit) + "°F";
    }

    public static String celsius (Double temperature) {
        DecimalFormat df = new DecimalFormat("#.##");
        Double intoCelsius = temperature - 273.15;
        return df.format(intoCelsius) + "°C";
    }

    public static String pressure (Double pressure) {
        DecimalFormat df = new DecimalFormat("#.##");
        Double inHg = pressure * 0.02953;
        return df.format(inHg) + "inHg";
    }

    public static String humidity (Long humidity) {
        return humidity + "%";
    }

    public Calendar getSunrise() {

        JSONObject sys = (JSONObject) obj.get("sys");
        if (sys == null) {
            return Calendar.getInstance();
        }
        Long sunriseTimestamp = (Long) sys.get("sunrise");
        if (sunriseTimestamp == null) {
            return Calendar.getInstance();
        }
        else {
            return DateTime.fromTimestamp(sunriseTimestamp);
        }
    }

    public Calendar getSunset() {
        JSONObject sys = (JSONObject) obj.get("sys");
        if (sys == null)
            return Calendar.getInstance();
        Long sunsetTimestamp = (Long) sys.get("sunset");
        if (sunsetTimestamp == null)
            return Calendar.getInstance();
        return DateTime.fromTimestamp(sunsetTimestamp);
    }
}

