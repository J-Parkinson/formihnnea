package classes.coords;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coordinate {
    /**
     * City geo location, longitude
     */
    @SerializedName("lon")
    public String longitude;

    /**
     * City geo location, latitude
     */
    @SerializedName("lat")
    public String latitude;
}
