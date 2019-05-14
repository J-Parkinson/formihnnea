package classes.forecast;

import classes.forecast.daily.DailyForecast;
import classes.forecast.hourly.HourlyForecast;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class ForecastInformationWeek{
    public String code;
    public String message;
    public City city;
    public int cnt;
    @SerializedName("list")
    public List<DailyForecast> forecasts;
}
