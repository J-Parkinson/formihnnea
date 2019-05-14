package classes;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import classes.gson.SecondsDateTypeAdapter;

import java.util.Date;

@Data
public class SystemParameters {
    @SerializedName("type")
    public String type;
    @SerializedName("id")
    public String id;
    @SerializedName("message")
    public String message;
    @SerializedName("country")
    public String country;
    @JsonAdapter(SecondsDateTypeAdapter.class)
    @SerializedName("sunrise")
    public Date sunrise;
    @JsonAdapter(SecondsDateTypeAdapter.class)
    @SerializedName("sunset")
    public Date sunset;
}
