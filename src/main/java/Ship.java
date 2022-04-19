import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Ship {
    public List<Cargo> cargo;
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
        System.out.println("\n\nMain ship:");
        System.out.println("\ncargo:");
        for(int i = 0; i < cargo.size(); i++){
            System.out.printf("\ngood: %s\nquantity: %d\ntotalVolume: %d",
                    cargo.get(i).good, cargo.get(i).quantity, cargo.get(i).totalVolume);
            System.out.println();
        }
        System.out.printf("\n\nclass: %s\nid: %s\nlocation: %s\nmanufacturer: %s\nmaxCargo: %d\nplating: %d\nspaceAvailable: %d\nspeed: %d\ntype: %s\nweapons: %d\nx: %d\ny: %d",
                shipClass, id, location, manufacturer, maxCargo, plating, spaceAvailable, speed, type, weapons, x, y);
    }
}
