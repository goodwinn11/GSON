import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Ships {
    public String type;
    @SerializedName("class")
    public String shipClass;
    public int maxCargo;
    public int loadingSpeed;
    public int speed;
    public String manufacturer;
    public int plating;
    public int weapons;
    public List<PurchaseLocations> purchaseLocations;

    public void printOutShip(){
        for(int j = 0; j < purchaseLocations.size(); j++){
            System.out.println("\n\nКорабль:");
            System.out.printf("\nType: %s\nclass: %s\nmaxCargo: %d\nloadingSpeed: %d\nspeed: %d\nmanufacturer: %s\nplating: %d\nweapons: %d \n\nsystem: %s\nlocation: %s\nprice: %d" ,
                    type, shipClass, maxCargo, loadingSpeed, speed, manufacturer, plating, weapons, purchaseLocations.get(j).system, purchaseLocations.get(j).location, purchaseLocations.get(j).price);
        }

    }
}
