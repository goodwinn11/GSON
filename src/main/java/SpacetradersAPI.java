import com.google.gson.Gson;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SpacetradersAPI implements ISpaceTradersAPI{
    static HttpResponse<String> response;
    static Gson gson = new Gson();
    static String oldtoken;
    static String location;
    static String shipid;
    static String flightPlanId;
    static ArrayList<String> jsons = new ArrayList<>();

    //serverstatus
    public Status serverStatus() {
        response = Unirest.get("https://api.spacetraders.io/game/status")
                .asString();
        Status status = gson.fromJson(response.getBody(), Status.class);
        jsons.add("status = " + response.getBody().toString() + "\n");
        System.out.println("Server status " + status.status);
        return status;
    }

    //getToken
    public Token getToken(int number) {
        response = Unirest.post("https://api.spacetraders.io/users/ikos7890test" + number + "/claim").asString();
        Token token = gson.fromJson(response.getBody(), Token.class);
        jsons.add("token = " + response.getBody().toString() + "\n");
        token.printOutToken();
        oldtoken = token.token;
        return token;
    }

    //account information
    public User getAccountInformation() {
        response = Unirest.get("https://api.spacetraders.io/my/account")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        User user1 = gson.fromJson(response.getBody(), User.class);
        jsons.add("user1 = " + response.getBody().toString() + "\n");
        user1.printOutUser();
        return user1;
    }

    //get available loans
    public AvailableLoans getAvailableLoans() {
        response = Unirest.get("https://api.spacetraders.io/types/loans")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        AvailableLoans loans = gson.fromJson(response.getBody(), AvailableLoans.class);
        jsons.add("loans = " + response.getBody().toString() + "\n");
        loans.printOutAvailableLoans();
        return loans;
    }

    //get a loan
    public MyLoans getALoan(String type) {
        response = Unirest.post("https://api.spacetraders.io/my/loans?type=" + type)
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        MyLoans myloans = gson.fromJson(response.getBody(), MyLoans.class);
        jsons.add("myloans = " + response.getBody().toString() + "\n");
        myloans.printOutLoans();
        return myloans;
    }

    //get active loans
    public ActiveLoan getActiveLoans() {
        response = Unirest.get("https://api.spacetraders.io/my/loans")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        ActiveLoan activeLoan = gson.fromJson(response.getBody(), ActiveLoan.class);
        jsons.add("activeLoan = " + response.getBody().toString() + "\n");
        activeLoan.printOutActiveLoan();
        return activeLoan;
    }

    //get list of all available ships for purchase
    public ShipListings getShipsForPurchase(String system) {
        response = Unirest.get("https://api.spacetraders.io/systems/" + system + "/ship-listings")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        ShipListings shipListings = gson.fromJson(response.getBody(), ShipListings.class);
        jsons.add("shipListings = " + response.getBody().toString() + "\n");
        for (int i = 0; i < shipListings.shipListings.size(); i++) shipListings.shipListings.get(i).printOutShip();
        return shipListings;
    }

    //buy a ship
    public BuyShip buyShip(String location, String type) {
        response = Unirest.post("https://api.spacetraders.io/my/ships?location=" + location + "&type=" + type)
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        BuyShip buyShip = gson.fromJson(response.getBody(), BuyShip.class);
        jsons.add("buyShip = " + response.getBody().toString() + "\n");
        buyShip.ship.printOutShip();
        shipid = buyShip.ship.id;
        location = buyShip.ship.location;
        return buyShip;
    }

    //get my ships list
    public MyShips getShipsList() {
        response = Unirest.get("https://api.spacetraders.io/my/ships")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        MyShips myShips = gson.fromJson(response.getBody(), MyShips.class);
        jsons.add("myShips = " + response.getBody().toString() + "\n");
        System.out.println("\n\nMy ships: ");
        myShips.ships.get(0).printOutShip();
        location = myShips.ships.get(0).location;
        return myShips;
    }

    //buy fuel
    public Purchase buySomething(String good, int quantity) {
        response = Unirest.post("https://api.spacetraders.io/my/purchase-orders?shipId=" + shipid + "&good=" + good + "&quantity=" + quantity)
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        Purchase purchase = gson.fromJson(response.getBody(), Purchase.class);
        jsons.add("purchase = " + response.getBody().toString() + "\n");
        System.out.println("\n\ncredits: " + purchase.credits);
        purchase.order.printOutOrder();
        purchase.ship.printOutShip();
        return purchase;
    }

    //See marketplace
    public MarketPlace seeMarketplace() {
        response = Unirest.get("https://api.spacetraders.io/locations/" + location + "/marketplace")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        MarketPlace marketPlace = gson.fromJson(response.getBody(), MarketPlace.class);
        jsons.add("marketPlace = " + response.getBody().toString() + "\n");
        marketPlace.printOutMarketplace();
        return marketPlace;
    }

    public Locations getNearestLocation(String system) {
        response = Unirest.get("https://api.spacetraders.io/systems/" + system + "/locations")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        Locations locations = gson.fromJson(response.getBody(), Locations.class);
        jsons.add("locations = " + response.getBody().toString() + "\n");
        locations.printOutLocations();
        return locations;
    }

    //create flight plan
    public FlightPlan createFlightPlan(String destination) throws InterruptedException {
        response = Unirest.post("https://api.spacetraders.io/my/flight-plans?shipId=" + shipid + "&destination=" + destination)
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        FlightPlan flightPlan = gson.fromJson(response.getBody(), FlightPlan.class);
        jsons.add("flightPlan = " + response.getBody().toString() + "\n");
        flightPlan.flightPlan.printOutFlightPlan();
        Thread.sleep(flightPlan.flightPlan.timeRemainingInSeconds * 1000 + 2000);
        flightPlanId = flightPlan.flightPlan.id;
        return flightPlan;
    }

    //Check plan status
    public FlightPlan checkPlanStatus() {
        response = Unirest.get("https://api.spacetraders.io/my/flight-plans/" + flightPlanId)
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        FlightPlan flightPlan = gson.fromJson(response.getBody(), FlightPlan.class);
        jsons.add("flightPlan = " + response.getBody().toString() + "\n");
        flightPlan.flightPlan.printOutFlightPlan();
        return flightPlan;
    }

    //sell metals
    public Purchase sellSomething(String good, int quantity) {
        response = Unirest.post("https://api.spacetraders.io/my/sell-orders?shipId=" + shipid + "&good=" + good + "&quantity=" + quantity)
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        Purchase soldMetals = gson.fromJson(response.getBody(), Purchase.class);
        jsons.add("soldMetals = " + response.getBody().toString() + "\n");
        soldMetals.printOutPurchase();
        return soldMetals;
    }
    public void writeToFile(){
        try {
            Files.write(Paths.get("data/jsons.txt"), jsons);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
