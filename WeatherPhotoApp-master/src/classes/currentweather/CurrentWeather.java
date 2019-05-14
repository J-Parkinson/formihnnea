package classes.currentweather;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import lombok.Data;
import lombok.EqualsAndHashCode;
import classes.coords.Coordinate;
import classes.AbstractWeatherInformation;
import classes.SystemParameters;

import java.lang.reflect.Type;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class CurrentWeather extends AbstractWeatherInformation {
    public static final Type TYPE = TypeToken.get(CurrentWeather.class).getType();
    public static final Type TYPE_LIST = TypeToken.getParameterized(List.class, TYPE).getType();

    @SerializedName("coord")
    public Coordinate coordinate;
    public String base;
    @SerializedName("name")
    public String cityName;
    @SerializedName("id")
    public long cityId;
    public String cod;
    public String visibility;
    @SerializedName("sys")
    public SystemParameters systemParameters;
}
