import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Ship {
    public List<Integer> cargo;
    @SerializedName("class")
    public String shipClass;
    public String id;
    public String location;
    public String manufacturer;
    public int maxCargo;
    public int plating;
    public int spaceAvailable;
    public int speed;
    public String type;
    public int weapons;
    public int x;
    public int y;

    public void printOutShip(){
        System.out.println("\nBought ship:");
        System.out.printf("\nclass: %s\nid: %s\nlocation: %s\nmanufacturer: %s\nmaxCargo: %d\nplating: %d\nspaceAvailable: %d\nspeed: %d\ntype: %s\nweapons: %d\nx: %d\ny: %d",
                shipClass, id, location, manufacturer, maxCargo, plating, spaceAvailable, speed, type, weapons, x, y);
    }
}
