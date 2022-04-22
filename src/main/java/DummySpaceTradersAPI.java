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
    public static String statusJson = "{\"status\":\"spacetraders is currently online and available to play\"}";
    public static String tokenJson = "{\"token\":\"494903e2-e809-4e99-85f0-64c325f3a6cf\",\"user\":{\"username\":\"ikos7890test68\",\"credits\":0,\"ships\":[],\"loans\":[]}}";
    public static String user1Json = "{\"user\":{\"username\":\"ikos7890test68\",\"shipCount\":0,\"structureCount\":0,\"joinedAt\":\"2022-04-22T02:13:32.039Z\",\"credits\":0}}";
    public static String loansJson = "{\"loans\":[{\"type\":\"STARTUP\",\"amount\":200000,\"rate\":40,\"termInDays\":2,\"collateralRequired\":false}]}";
    public static String myloansJson = "{\"credits\":200000,\"loan\":{\"id\":\"cl29stjma58004015s6hhipd4u6\",\"due\":\"2022-04-24T02:13:33.967Z\",\"repaymentAmount\":280000,\"status\":\"CURRENT\",\"type\":\"STARTUP\"}}";
    public static String activeLoanJson = "{\"loans\":[{\"id\":\"cl29stjma58004015s6hhipd4u6\",\"due\":\"2022-04-24T02:13:33.967Z\",\"repaymentAmount\":280000,\"status\":\"CURRENT\",\"type\":\"STARTUP\"}]}";
    public static String shipListingsJson = "{\"shipListings\":[{\"type\":\"JW-MK-I\",\"class\":\"MK-I\",\"maxCargo\":50,\"loadingSpeed\":25,\"speed\":1,\"manufacturer\":\"Jackshaw\",\"plating\":5,\"weapons\":5,\"purchaseLocations\":[{\"system\":\"OE\",\"location\":\"OE-PM-TR\",\"price\":21125}]},{\"type\":\"JW-MK-II\",\"class\":\"MK-II\",\"maxCargo\":100,\"loadingSpeed\":25,\"speed\":2,\"manufacturer\":\"Jackshaw\",\"plating\":10,\"weapons\":10,\"purchaseLocations\":[{\"system\":\"OE\",\"location\":\"OE-PM-TR\",\"price\":83300}]},{\"type\":\"GR-MK-I\",\"class\":\"MK-I\",\"maxCargo\":100,\"loadingSpeed\":100,\"speed\":1,\"manufacturer\":\"Gravager\",\"plating\":10,\"weapons\":5,\"purchaseLocations\":[{\"system\":\"OE\",\"location\":\"OE-PM-TR\",\"price\":42650}]},{\"type\":\"ZA-MK-II\",\"class\":\"MK-II\",\"maxCargo\":100,\"loadingSpeed\":100,\"speed\":2,\"manufacturer\":\"Zetra\",\"plating\":5,\"weapons\":5,\"purchaseLocations\":[{\"system\":\"OE\",\"location\":\"OE-PM-TR\",\"price\":72700},{\"system\":\"OE\",\"location\":\"OE-UC-OB\",\"price\":72700}]},{\"type\":\"ZA-MK-III\",\"class\":\"MK-III\",\"maxCargo\":300,\"loadingSpeed\":100,\"speed\":2,\"manufacturer\":\"Zetra\",\"plating\":10,\"weapons\":10,\"purchaseLocations\":[{\"system\":\"OE\",\"location\":\"OE-PM-TR\",\"price\":213900},{\"system\":\"OE\",\"location\":\"OE-UC-OB\",\"price\":213900}]},{\"type\":\"EM-MK-I\",\"class\":\"MK-I\",\"maxCargo\":50,\"loadingSpeed\":25,\"speed\":2,\"manufacturer\":\"Electrum\",\"plating\":5,\"weapons\":10,\"purchaseLocations\":[{\"system\":\"OE\",\"location\":\"OE-PM-TR\",\"price\":37750}]},{\"type\":\"HM-MK-I\",\"class\":\"MK-I\",\"maxCargo\":50,\"loadingSpeed\":25,\"speed\":3,\"manufacturer\":\"Hermes\",\"plating\":20,\"weapons\":5,\"purchaseLocations\":[{\"system\":\"OE\",\"location\":\"OE-PM-TR\",\"price\":57525}]},{\"type\":\"GR-MK-II\",\"class\":\"MK-II\",\"maxCargo\":300,\"loadingSpeed\":500,\"speed\":1,\"manufacturer\":\"Gravager\",\"plating\":10,\"weapons\":5,\"purchaseLocations\":[{\"system\":\"OE\",\"location\":\"OE-UC-AD\",\"price\":125550},{\"system\":\"OE\",\"location\":\"OE-NY\",\"price\":125550}]},{\"type\":\"GR-MK-III\",\"class\":\"MK-III\",\"maxCargo\":500,\"loadingSpeed\":500,\"speed\":1,\"manufacturer\":\"Gravager\",\"plating\":10,\"weapons\":10,\"purchaseLocations\":[{\"system\":\"OE\",\"location\":\"OE-UC-AD\",\"price\":203210},{\"system\":\"OE\",\"location\":\"OE-NY\",\"price\":203210}]},{\"type\":\"HM-MK-III\",\"class\":\"MK-III\",\"maxCargo\":300,\"loadingSpeed\":100,\"speed\":4,\"manufacturer\":\"Hermes\",\"plating\":20,\"weapons\":5,\"purchaseLocations\":[{\"system\":\"OE\",\"location\":\"OE-UC-AD\",\"price\":445200}]},{\"type\":\"TD-MK-I\",\"class\":\"MK-I\",\"maxCargo\":3000,\"loadingSpeed\":1000,\"speed\":2,\"manufacturer\":\"Tiddalik\",\"plating\":10,\"weapons\":5,\"restrictedGoods\":[\"FUEL\"],\"purchaseLocations\":[{\"system\":\"OE\",\"location\":\"OE-UC-AD\",\"price\":473600}]}]}";
    public static String buyShipJson = "{\"credits\":178875,\"ship\":{\"id\":\"cl29stl0058020115s687izw5gk\",\"location\":\"OE-PM-TR\",\"x\":-20,\"y\":5,\"cargo\":[],\"spaceAvailable\":50,\"type\":\"JW-MK-I\",\"class\":\"MK-I\",\"maxCargo\":50,\"loadingSpeed\":25,\"speed\":1,\"manufacturer\":\"Jackshaw\",\"plating\":5,\"weapons\":5}}";
    public static String myShipsJson = "{\"ships\":[{\"id\":\"cl29stl0058020115s687izw5gk\",\"location\":\"OE-PM-TR\",\"x\":-20,\"y\":5,\"cargo\":[],\"spaceAvailable\":50,\"type\":\"JW-MK-I\",\"class\":\"MK-I\",\"maxCargo\":50,\"loadingSpeed\":25,\"speed\":1,\"manufacturer\":\"Jackshaw\",\"plating\":5,\"weapons\":5}]}";
    public static String buySomethingJson = "{\"credits\":178815,\"order\":{\"good\":\"FUEL\",\"quantity\":20,\"pricePerUnit\":3,\"total\":60},\"ship\":{\"id\":\"cl29stl0058020115s687izw5gk\",\"location\":\"OE-PM-TR\",\"x\":-20,\"y\":5,\"cargo\":[{\"good\":\"FUEL\",\"quantity\":20,\"totalVolume\":20}],\"spaceAvailable\":30,\"type\":\"JW-MK-I\",\"class\":\"MK-I\",\"maxCargo\":50,\"loadingSpeed\":25,\"speed\":1,\"manufacturer\":\"Jackshaw\",\"plating\":5,\"weapons\":5}}";
    public static String marketPlaceJson = "{\"marketplace\":[{\"symbol\":\"CONSTRUCTION_MATERIALS\",\"volumePerUnit\":1,\"pricePerUnit\":132,\"spread\":3,\"purchasePricePerUnit\":135,\"sellPricePerUnit\":129,\"quantityAvailable\":4526},{\"symbol\":\"METALS\",\"volumePerUnit\":1,\"pricePerUnit\":4,\"spread\":1,\"purchasePricePerUnit\":5,\"sellPricePerUnit\":3,\"quantityAvailable\":88716},{\"symbol\":\"FUSION_REACTORS\",\"volumePerUnit\":6,\"pricePerUnit\":20398,\"spread\":197,\"purchasePricePerUnit\":20595,\"sellPricePerUnit\":20201,\"quantityAvailable\":18},{\"symbol\":\"FUEL\",\"volumePerUnit\":1,\"pricePerUnit\":2,\"spread\":1,\"purchasePricePerUnit\":3,\"sellPricePerUnit\":1,\"quantityAvailable\":87066}]}";
    public static String locationsJson = "{\"locations\":[{\"symbol\":\"OE-PM\",\"type\":\"PLANET\",\"name\":\"Prime\",\"x\":-19,\"y\":3,\"allowsConstruction\":false,\"traits\":[\"METAL_ORES\",\"SOME_NATURAL_CHEMICALS\"]},{\"symbol\":\"OE-PM-TR\",\"type\":\"MOON\",\"name\":\"Tritus\",\"x\":-20,\"y\":5,\"allowsConstruction\":false,\"traits\":[\"NATURAL_CHEMICALS\"]},{\"symbol\":\"OE-CR\",\"type\":\"PLANET\",\"name\":\"Carth\",\"x\":4,\"y\":-13,\"allowsConstruction\":false,\"traits\":[\"METAL_ORES\",\"NATURAL_CHEMICALS\",\"ABUNDANT_RARE_METAL_ORES\",\"ABUNDANT_TECHNOLOGICAL_RUINS\"]},{\"symbol\":\"OE-KO\",\"type\":\"PLANET\",\"name\":\"Koria\",\"x\":-49,\"y\":1,\"allowsConstruction\":false,\"traits\":[\"SOME_NATURAL_CHEMICALS\",\"SOME_RARE_METAL_ORES\"]},{\"symbol\":\"OE-UC\",\"type\":\"PLANET\",\"name\":\"Ucarro\",\"x\":-17,\"y\":-72,\"allowsConstruction\":false,\"traits\":[\"SOME_METAL_ORES\",\"ARABLE_LAND\"]},{\"symbol\":\"OE-UC-AD\",\"type\":\"MOON\",\"name\":\"Ado\",\"x\":-15,\"y\":-73,\"allowsConstruction\":false,\"traits\":[\"SOME_METAL_ORES\",\"SOME_RARE_METAL_ORES\",\"TECHNOLOGICAL_RUINS\"]},{\"symbol\":\"OE-UC-OB\",\"type\":\"MOON\",\"name\":\"Obo\",\"x\":-17,\"y\":-74,\"allowsConstruction\":false,\"traits\":[\"SOME_METAL_ORES\",\"NATURAL_CHEMICALS\",\"SOME_TECHNOLOGICAL_RUINS\"]},{\"symbol\":\"OE-NY\",\"type\":\"ASTEROID\",\"name\":\"Nyon\",\"x\":43,\"y\":-46,\"allowsConstruction\":true,\"traits\":[\"SOME_NATURAL_CHEMICALS\",\"RARE_METAL_ORES\"]},{\"symbol\":\"OE-BO\",\"type\":\"GAS_GIANT\",\"name\":\"Bo\",\"x\":-59,\"y\":60,\"allowsConstruction\":true,\"traits\":[\"SOME_HELIUM_3\",\"TECHNOLOGICAL_RUINS\"]},{\"symbol\":\"OE-W-XV\",\"type\":\"WORMHOLE\",\"name\":\"Wormhole\",\"x\":5,\"y\":-101,\"allowsConstruction\":false,\"traits\":[],\"messages\":[\"Extensive research has revealed a partially functioning warp gate harnessing the power of an unstable but traversable wormhole.\",\"The scientific community has determined a means of stabilizing the ancient structure.\",\"Enter at your own risk.\",\"GET https://api.spacetraders.io/locations/OE-W-XV/structures\",\"POST https://api.spacetraders.io/structures/:structureId/deposit shipId=:shipId good=:goodSymbol quantity=:quantity\",\"POST https://api.spacetraders.io/my/warp-jumps shipId=:shipId\"]}]}";
    public static String flightPlanJson = "{\"flightPlan\":{\"id\":\"cl29stoap58053215s67ry8aaam\",\"shipId\":\"cl29stl0058020115s687izw5gk\",\"createdAt\":\"2022-04-22T02:13:40.033Z\",\"arrivesAt\":\"2022-04-22T02:14:16.031Z\",\"destination\":\"OE-PM\",\"departure\":\"OE-PM-TR\",\"distance\":2,\"fuelConsumed\":1,\"fuelRemaining\":19,\"terminatedAt\":null,\"timeRemainingInSeconds\":35}}";
    public static String flightPlanStatusJson = "{\"flightPlan\":{\"id\":\"cl29stoap58053215s67ry8aaam\",\"shipId\":\"cl29stl0058020115s687izw5gk\",\"createdAt\":\"2022-04-22T02:13:40.033Z\",\"arrivesAt\":\"2022-04-22T02:14:16.031Z\",\"destination\":\"OE-PM\",\"departure\":\"OE-PM-TR\",\"distance\":2,\"fuelConsumed\":1,\"fuelRemaining\":19,\"terminatedAt\":\"2022-04-22T02:14:11.241Z\",\"timeRemainingInSeconds\":0}}";
    public static String soldMetalsJson = "{\"credits\":179175,\"order\":{\"good\":\"METALS\",\"quantity\":10,\"pricePerUnit\":41,\"total\":410},\"ship\":{\"id\":\"cl29stl0058020115s687izw5gk\",\"location\":\"OE-PM\",\"x\":-19,\"y\":3,\"cargo\":[{\"good\":\"FUEL\",\"quantity\":19,\"totalVolume\":19}],\"spaceAvailable\":31,\"type\":\"JW-MK-I\",\"class\":\"MK-I\",\"maxCargo\":50,\"loadingSpeed\":25,\"speed\":1,\"manufacturer\":\"Jackshaw\",\"plating\":5,\"weapons\":5}}";

    //serverstatus
    public Status serverStatus() {
        response = Unirest.get("https://api.spacetraders.io/game/status")
                .asString();
        Status status = gson.fromJson(statusJson, Status.class);
        System.out.println("Server status " + status.status);
        return status;
    }

    //getToken
    public Token getToken(int number) {
        response = Unirest.post("https://api.spacetraders.io/users/ikos7890test" + number + "/claim").asString();
        Token token = gson.fromJson(tokenJson, Token.class);
        token.printOutToken();
        oldtoken = token.token;
        return token;
    }

    //account information
    public User getAccountInformation() {
        response = Unirest.get("https://api.spacetraders.io/my/account")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        User user1 = gson.fromJson(user1Json, User.class);
        user1.printOutUser();
        return user1;
    }

    //get available loans
    public AvailableLoans getAvailableLoans() {
        response = Unirest.get("https://api.spacetraders.io/types/loans")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        AvailableLoans loans = gson.fromJson(loansJson, AvailableLoans.class);
        loans.printOutAvailableLoans();
        return loans;
    }

    //get a loan
    public MyLoans getALoan(String type) {
        response = Unirest.post("https://api.spacetraders.io/my/loans?type=" + type)
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        MyLoans myloans = gson.fromJson(myloansJson, MyLoans.class);
        myloans.printOutLoans();
        return myloans;
    }

    //get active loans
    public ActiveLoan getActiveLoans() {
        response = Unirest.get("https://api.spacetraders.io/my/loans")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        ActiveLoan activeLoan = gson.fromJson(activeLoanJson, ActiveLoan.class);
        activeLoan.printOutActiveLoan();
        return activeLoan;
    }

    //get list of all available ships for purchase
    public ShipListings getShipsForPurchase(String system) {
        response = Unirest.get("https://api.spacetraders.io/systems/" + system + "/ship-listings")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        ShipListings shipListings = gson.fromJson(shipListingsJson, ShipListings.class);
        for (int i = 0; i < shipListings.shipListings.size(); i++) shipListings.shipListings.get(i).printOutShip();
        return shipListings;
    }

    //buy a ship
    public BuyShip buyShip(String location, String type) {
        response = Unirest.post("https://api.spacetraders.io/my/ships?location=" + location + "&type=" + type)
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        BuyShip buyShip = gson.fromJson(buyShipJson, BuyShip.class);
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
        MyShips myShips = gson.fromJson(myShipsJson, MyShips.class);
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
        Purchase purchase = gson.fromJson(buySomethingJson, Purchase.class);
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
        MarketPlace marketPlace = gson.fromJson(marketPlaceJson, MarketPlace.class);
        marketPlace.printOutMarketplace();
        return marketPlace;
    }

    public Locations getNearestLocation(String system) {
        response = Unirest.get("https://api.spacetraders.io/systems/" + system + "/locations")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        Locations locations = gson.fromJson(locationsJson, Locations.class);
        locations.printOutLocations();
        return locations;
    }

    //create flight plan
    public FlightPlan createFlightPlan(String destination) throws InterruptedException {
        response = Unirest.post("https://api.spacetraders.io/my/flight-plans?shipId=" + shipid + "&destination=" + destination)
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        FlightPlan flightPlan = gson.fromJson(flightPlanJson, FlightPlan.class);
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
        FlightPlan flightPlan = gson.fromJson(flightPlanStatusJson, FlightPlan.class);
        flightPlan.flightPlan.printOutFlightPlan();
        return flightPlan;
    }

    //sell metals
    public Purchase sellSomething(String good, int quantity) {
        response = Unirest.post("https://api.spacetraders.io/my/sell-orders?shipId=" + shipid + "&good=" + good + "&quantity=" + quantity)
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        Purchase soldMetals = gson.fromJson(soldMetalsJson, Purchase.class);
        soldMetals.printOutPurchase();
        return soldMetals;
    }


}
