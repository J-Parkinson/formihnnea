package utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Iterator;
import java.util.List;

import classes.currentweather.CurrentWeather;
import classes.forecast.ForecastInformationDay;
import classes.forecast.ForecastInformationWeek;
import classes.forecast.daily.DailyForecast;
import classes.forecast.hourly.HourlyForecast;
import com.google.gson.*;
import org.json.simple.JSONObject;
import classes.*;

import static java.time.temporal.ChronoUnit.DAYS;
import static utils.QueryParser.callQuery;


public class owmAPI {

    private static final String api_id_owm = "d3701ecc1c0c1202a1e0add340d8d345";
    private static final String api_id_google = "AIzaSyAhxpVJs2OH7oYj_LM8DR5Yyzdyl8eMGu0";



    public static ForecastInformationWeek getWeekForecast(Location location){
        String query = "http://api.openweathermap.org/data/2.5/forecast?q=" + location.name + "&APPID=" + api_id_owm;

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
        String query = "http://api.openweathermap.org/data/2.5/forecast?q=" + location.name + "&APPID=" + api_id_owm;

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
        String query = "http://api.openweathermap.org/data/2.5/weather?q=" + location.name + "&APPID=" + api_id_owm;

        JSONObject jsonObject = callQuery(query);

        Gson g = new Gson();
        CurrentWeather currentWeather = g.fromJson(jsonObject.toJSONString(), CurrentWeather.class);
        return currentWeather;
    }

    public static void main(String[] args) {
        System.out.println(owmAPI.autoCompleteInput("cam"));
    }

    public static List<AutocompleteLocation> autoCompleteInput(String stringLocation){
        String query = "https://maps.googleapis.com/maps/api/place/autocomplete/json?input=" + stringLocation + "&key=" + api_id_google;
        JSONObject jsonObject = callQuery(query);


        return null;
    }
}
