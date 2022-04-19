import java.util.List;

public class Locations {
    List<Location> locations;
    public void printOutLocations(){
        System.out.println("\n\nlocations:");
        for (int i = 0; i < locations.size(); i++){
            System.out.printf("\nsymbol: %s\ntype: %s\nname: %s\nx: %d\ny: %d\nisallowsConstruction: %b",
                    locations.get(i).symbol, locations.get(i).type, locations.get(i).name, locations.get(i).x, locations.get(i).y, locations.get(i).allowsConstruction);
            System.out.println("\ntraits: ");
            for (int j = 0; j < locations.get(i).traits.size(); j++){
                System.out.print( locations.get(i).traits.get(j) + " ");
            }
            System.out.println();
        }

    }
}
