package classes.forecast.hourly;

import classes.Weather;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import lombok.Data;
import lombok.EqualsAndHashCode;
import classes.gson.ISOStringDateTypeAdapter;
import classes.AbstractWeatherInformation;
import classes.forecast.Forecast;
import classes.forecast.ForecastInformation;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class HourlyForecast extends AbstractWeatherInformation implements Forecast {
    public static final Type TYPE = new TypeToken<ForecastInformation<HourlyForecast>>() {
    }.getType();
    public static final Type TYPE_LIST = TypeToken.getParameterized(List.class, TYPE).getType();

    @JsonAdapter(ISOStringDateTypeAdapter.class)
    @SerializedName("dt_txt")
    public Date calculationDate;

    public Weather getWeather(){
        return weather.get(0);
    }
}
