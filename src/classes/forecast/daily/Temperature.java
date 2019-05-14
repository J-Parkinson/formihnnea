package classes.forecast.daily;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Temperature {
    public double day;
    public double min;
    public double max;
    public double night;
    @SerializedName("eve")
    public double evening;
    @SerializedName("morn")
    public double morning;
}
