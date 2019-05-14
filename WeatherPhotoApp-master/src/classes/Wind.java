package classes;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Wind {
    @SerializedName("speed")
    public double speed;
    @SerializedName("deg")
    public double direction;
}
