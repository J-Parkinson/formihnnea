package classes;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Rain {
    /**
     * Rain volume for the last 3 hours
     */
    @SerializedName("3h")
    public double rainAmt;
}
