package classes;


import classes.coords.Coordinate;
import com.google.gson.annotations.SerializedName;

public class Location {

    public String name;

    public String id;

    public Coordinate position;



    public static Location fromId(String id){ return new Location(id, TypeLocation.ID);}

    public static Location fromName(String name){ return new Location(name, TypeLocation.NAME);}

    private Location(String value, TypeLocation mode){
        if (mode == TypeLocation.ID){
            this.id = value;
        }
        if (mode == TypeLocation.NAME){
            this.name = value;
        }
    }

    public Location(){};
}
