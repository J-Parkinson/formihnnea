package classes;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Weather {
    /**
     * Weather condition id
     */
    @SerializedName("id")
    public String id;
    /**
     * Group of weather parameters (Rain, Snow, Extreme etc.)
     */
    @SerializedName("main")
    public String main;
    /**
     * Weather condition within the group
     */
    @SerializedName("description")
    public String description;
    /**
     * Weather icon id
     */
    @SerializedName("icon")
    public String icon;
}
