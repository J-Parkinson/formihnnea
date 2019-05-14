package classes;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AbstractWeatherInformation extends AbstractWeatherResponse {
    @SerializedName("main")
    public MainParameters mainParameters;
    public Wind wind;
    public Clouds clouds;
    public Rain rain;
    public Snow snow;
}
