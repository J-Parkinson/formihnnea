package classes;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Clouds {
    /**
     * Cloudiness, %
     */
    @SerializedName("all")
    public double cloudiness;
    
    
}
