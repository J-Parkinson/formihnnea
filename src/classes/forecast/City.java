package classes.forecast;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import classes.coords.Coordinate;

@Data
public class City {
    public long id;
    public String name;
    @SerializedName("coord")
    public Coordinate coordinate;
    public String country;
}
