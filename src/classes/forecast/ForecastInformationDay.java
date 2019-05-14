package classes.forecast;

import classes.forecast.hourly.HourlyForecast;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class ForecastInformationDay {
    public String code;
    public String message;
    public City city;
    public int cnt;
    @SerializedName("list")
    public List<HourlyForecast> forecasts;
}
