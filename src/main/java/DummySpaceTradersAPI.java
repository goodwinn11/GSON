import com.google.gson.Gson;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class DummySpaceTradersAPI implements ISpaceTradersAPI{
    static HttpResponse<String> response;
    static Gson gson = new Gson();
    static String oldtoken;
    static String location;
    static String shipid;
    static String flightPlanId;


    //serverstatus
    public Status serverStatus() {
        response = Unirest.get("https://api.spacetraders.io/game/status")
                .asString();
        Status status = gson.fromJson(response.getBody(), Status.class);
        System.out.println("Server status " + status.status);
        return status;
    }

    //getToken
    public Token getToken(int number) {
        response = Unirest.post("https://api.spacetraders.io/users/ikos7890test" + number + "/claim").asString();
        Token token = gson.fromJson(response.getBody(), Token.class);
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
        user1.printOutUser();
        return user1;
    }

    //get available loans
    public AvailableLoans getAvailableLoans() {
        response = Unirest.get("https://api.spacetraders.io/types/loans")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        AvailableLoans loans = gson.fromJson(response.getBody(), AvailableLoans.class);
        loans.printOutAvailableLoans();
        return loans;
    }

    //get a loan
    public MyLoans getALoan(String type) {
        response = Unirest.post("https://api.spacetraders.io/my/loans?type=" + type)
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        MyLoans myloans = gson.fromJson(response.getBody(), MyLoans.class);
        myloans.printOutLoans();
        return myloans;
    }

    //get active loans
    public ActiveLoan getActiveLoans() {
        response = Unirest.get("https://api.spacetraders.io/my/loans")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        ActiveLoan activeLoan = gson.fromJson(response.getBody(), ActiveLoan.class);
        activeLoan.printOutActiveLoan();
        return activeLoan;
    }

    //get list of all available ships for purchase
    public ShipListings getShipsForPurchase(String system) {
        response = Unirest.get("https://api.spacetraders.io/systems/" + system + "/ship-listings")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        ShipListings shipListings = gson.fromJson(response.getBody(), ShipListings.class);
        for (int i = 0; i < shipListings.shipListings.size(); i++) shipListings.shipListings.get(i).printOutShip();
        return shipListings;
    }

    //buy a ship
    public BuyShip buyShip(String location, String type) {
        response = Unirest.post("https://api.spacetraders.io/my/ships?location=" + location + "&type=" + type)
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        BuyShip buyShip = gson.fromJson(response.getBody(), BuyShip.class);
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
        marketPlace.printOutMarketplace();
        return marketPlace;
    }

    public Locations getNearestLocation(String system) {
        response = Unirest.get("https://api.spacetraders.io/systems/" + system + "/locations")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        Locations locations = gson.fromJson(response.getBody(), Locations.class);
        locations.printOutLocations();
        return locations;
    }

    //create flight plan
    public FlightPlan createFlightPlan(String destination) throws InterruptedException {
        response = Unirest.post("https://api.spacetraders.io/my/flight-plans?shipId=" + shipid + "&destination=" + destination)
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        FlightPlan flightPlan = gson.fromJson(response.getBody(), FlightPlan.class);
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
        flightPlan.flightPlan.printOutFlightPlan();
        return flightPlan;
    }

    //sell metals
    public Purchase sellSomething(String good, int quantity) {
        response = Unirest.post("https://api.spacetraders.io/my/sell-orders?shipId=" + shipid + "&good=" + good + "&quantity=" + quantity)
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        Purchase soldMetals = gson.fromJson(response.getBody(), Purchase.class);
        soldMetals.printOutPurchase();
        return soldMetals;
    }


}
