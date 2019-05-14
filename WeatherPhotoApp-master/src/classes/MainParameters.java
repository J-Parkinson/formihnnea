package classes;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class MainParameters {
    @SerializedName("temp")
    public double temperature;
    @SerializedName("pressure")
    public double pressure;
    @SerializedName("humidity")
    public double humidity;
    @SerializedName("temp_min")
    public double minimumTemperature;
    @SerializedName("temp_max")
    public double maximumTemperature;
    @SerializedName("sea_level")
    public double seaLevelPressure;
    @SerializedName("grnd_level")
    public double groundLevelPressure;
}
