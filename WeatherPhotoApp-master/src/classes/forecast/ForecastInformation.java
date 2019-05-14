package classes.forecast;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class ForecastInformation<T extends Forecast> {
    public String code;
    public String message;
    public City city;
    public int cnt;
    @SerializedName("list")
    public List<T> forecasts;
}
