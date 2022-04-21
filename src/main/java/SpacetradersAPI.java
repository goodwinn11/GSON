import com.google.gson.Gson;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class SpacetradersAPI {
    static int number;
    static HttpResponse<String> response;
    static Gson gson = new Gson();
    static String oldtoken;
    static String location;
    static String shipid;
    static String flightPlanId;


    //serverstatus
    public static void serverStatus() {
        response = Unirest.get("https://api.spacetraders.io/game/status")
                .asString();
        Status status = gson.fromJson(response.getBody(), Status.class);
        System.out.println("Server status " + status.status);
    }

    //getToken
    public static String getToken() {
        response = Unirest.post("https://api.spacetraders.io/users/ikos7890test" + number + "/claim").asString();
        Token token = gson.fromJson(response.getBody(), Token.class);
        token.printOutToken();
        oldtoken = token.token;
        return oldtoken;
    }

    //account information
    public static void getAccountInformation() {
        response = Unirest.get("https://api.spacetraders.io/my/account")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        User user1 = gson.fromJson(response.getBody(), User.class);
        user1.printOutUser();
    }

    //get available loans
    public static void getAvailableLoans() {
        response = Unirest.get("https://api.spacetraders.io/types/loans")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        AvailableLoans loans = gson.fromJson(response.getBody(), AvailableLoans.class);
        loans.printOutAvailableLoans();
    }
    //get a loan
    public static void getALoan(){
        response = Unirest.post("https://api.spacetraders.io/my/loans?type=STARTUP")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        MyLoans myloans = gson.fromJson(response.getBody(), MyLoans.class);
        myloans.printOutLoans();
    }
     //get active loans
    public static void getActiveLoans(){
        response = Unirest.get("https://api.spacetraders.io/my/loans")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        ActiveLoan activeLoan = gson.fromJson(response.getBody(), ActiveLoan.class);
        activeLoan.printOutActiveLoan();
    }
      //get list of all available ships for purchase
    public static void getShipsForPurchase(){
        response = Unirest.get("https://api.spacetraders.io/systems/OE/ship-listings")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        ShipListings shipListings = gson.fromJson(response.getBody(), ShipListings.class);
        for (int i = 0; i < shipListings.shipListings.size(); i++) shipListings.shipListings.get(i).printOutShip();

    }
       //buy a ship
    public static void buyShip(){
        response = Unirest.post("https://api.spacetraders.io/my/ships?location=OE-PM-TR&type=JW-MK-I")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        BuyShip buyShip = gson.fromJson(response.getBody(), BuyShip.class);
        buyShip.ship.printOutShip();
        shipid = buyShip.ship.id;
        location = buyShip.ship.location;
    }

        //get my ships list
    public static void getShipsList(){
        response = Unirest.get("https://api.spacetraders.io/my/ships")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        MyShips myShips = gson.fromJson(response.getBody(), MyShips.class);
        System.out.println("\n\nMy ships: ");
        myShips.ships.get(0).printOutShip();
        location = myShips.ships.get(0).location;
    }

       //buy fuel
        public static void buyFuel(){
            response = Unirest.post("https://api.spacetraders.io/my/purchase-orders?shipId=" + shipid + "&good=FUEL&quantity=20")
                    .header("Authorization", "Bearer " + oldtoken)
                    .asString();
            Purchase purchase = gson.fromJson(response.getBody(), Purchase.class);
            System.out.println("\n\ncredits: " + purchase.credits);
            purchase.order.printOutOrder();
            purchase.ship.printOutShip();
        }
    //See marketplace
        public static void seeMarketplace(){
            response = Unirest.get("https://api.spacetraders.io/locations/" + location + "/marketplace")
                    .header("Authorization", "Bearer " + oldtoken)
                    .asString();
            MarketPlace marketPlace = gson.fromJson(response.getBody(), MarketPlace.class);
            marketPlace.printOutMarketplace();
        }

        //buy metal
        public static void buyMetal(){
            response = Unirest.post("https://api.spacetraders.io/my/purchase-orders?shipId=" + shipid + "&good=METALS&quantity=10")
                    .header("Authorization", "Bearer " + oldtoken)
                    .asString();
            Purchase purchase2 = gson.fromJson(response.getBody(), Purchase.class);
            purchase2.printOutPurchase();
        }
        //get nearest locations
        public static void getNearestLocation(){
            response = Unirest.get("https://api.spacetraders.io/systems/OE/locations")
                    .header("Authorization", "Bearer " + oldtoken)
                    .asString();
            Locations locations = gson.fromJson(response.getBody(), Locations.class);
            locations.printOutLocations();
        }

        //create flight plan
    public static void createFlightPlan() throws InterruptedException {
        response = Unirest.post("https://api.spacetraders.io/my/flight-plans?shipId=" + shipid + "&destination=OE-PM")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        FlightPlan flightPlan = gson.fromJson(response.getBody(), FlightPlan.class);
        flightPlan.flightPlan.printOutFlightPlan();
        Thread.sleep(40000);
        flightPlanId = flightPlan.flightPlan.id;
    }
            //Check plan status
    public static void checkPlanStatus(){
        response = Unirest.get("https://api.spacetraders.io/my/flight-plans/" + flightPlanId)
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        FlightPlan flightPlan = gson.fromJson(response.getBody(), FlightPlan.class);
        flightPlan.flightPlan.printOutFlightPlan();
    }

        //sell metals
    public static void sellMetals(){
        response = Unirest.post("https://api.spacetraders.io/my/sell-orders?shipId=" + shipid + "&good=METALS&quantity=10")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        Purchase soldMetals = gson.fromJson(response.getBody(), Purchase.class);
        soldMetals.printOutPurchase();
    }








}
