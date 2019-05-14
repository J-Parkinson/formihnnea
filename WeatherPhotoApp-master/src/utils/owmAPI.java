package utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Iterator;

import classes.currentweather.CurrentWeather;
import classes.forecast.ForecastInformationDay;
import classes.forecast.ForecastInformationWeek;
import classes.forecast.daily.DailyForecast;
import classes.forecast.hourly.HourlyForecast;
import com.google.gson.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import classes.*;

import static java.time.temporal.ChronoUnit.DAYS;


public class owmAPI {

    private static final String api_id = "d3701ecc1c0c1202a1e0add340d8d345";

    private static JSONObject callQuery(String query){
        InputStream input;

        try{
            input = new URL(query).openStream();
        } catch (Exception e){
            System.out.println("No connection");
            return null;
        }

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject;

        try {
            jsonObject = (JSONObject) jsonParser.parse(
                    new InputStreamReader(input, "UTF-8"));
        } catch (Exception e){
            System.out.println("JSON object improperly formed.");
            return null;
        }
        return jsonObject;
    }

    public static ForecastInformationWeek getWeekForecast(Location location){
        String query = "http://api.openweathermap.org/data/2.5/forecast?q=" + location.name + "&APPID=" + api_id;

        JSONObject jsonObject = callQuery(query);

        Gson g = new Gson();

        System.out.println(jsonObject);

        ForecastInformationWeek dailyForecast = g.fromJson(jsonObject.toJSONString(), ForecastInformationWeek.class);

        //Let us remove all entries we don't need because they are not valid datapoints for a week forecast.

        Iterator<DailyForecast> forecastIterator = dailyForecast.forecasts.iterator();

        while (forecastIterator.hasNext()){
            DailyForecast df = forecastIterator.next();
            LocalDateTime ldt = LocalDateTime.ofInstant(df.dateTime.toInstant(), ZoneId.systemDefault());
            if (DAYS.between(LocalDateTime.now(), ldt) >= 1){
                forecastIterator.remove();
            }
        }

        return dailyForecast;
    }

    public static ForecastInformationDay getDayForecast(Location location){
        String query = "http://api.openweathermap.org/data/2.5/forecast?q=" + location.name + "&APPID=" + api_id;

        JSONObject jsonObject = callQuery(query);

        Gson g = new Gson();

        System.out.println(jsonObject);

        ForecastInformationDay hourlyForecast = g.fromJson(jsonObject.toJSONString(), ForecastInformationDay.class);

        //Let us remove all entries we don't need because they are not valid datapoints for a week forecast.

        Iterator<HourlyForecast> forecastIterator = hourlyForecast.forecasts.iterator();

        while (forecastIterator.hasNext()){
            HourlyForecast hf = forecastIterator.next();
            LocalDateTime ldt = LocalDateTime.ofInstant(hf.dateTime.toInstant(), ZoneId.systemDefault());
            if (DAYS.between(LocalDateTime.now(), ldt) >= 1){
                forecastIterator.remove();
            }
        }

        return hourlyForecast;
    }


    public static CurrentWeather getCurrentWeather(Location location){
        String query = "http://api.openweathermap.org/data/2.5/weather?q=" + location.name + "&APPID=" + api_id;

        JSONObject jsonObject = callQuery(query);

        Gson g = new Gson();
        CurrentWeather currentWeather = g.fromJson(jsonObject.toJSONString(), CurrentWeather.class);
        return currentWeather;
    }

    public static void main(String[] args) {
        System.out.println(owmAPI.getWeekForecast(new Location("London")).forecasts.get(4).dateTime.toString());
    }
}
