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
    public static Status serverStatus() {
        response = Unirest.get("https://api.spacetraders.io/game/status")
                .asString();
        Status status = gson.fromJson(response.getBody(), Status.class);
        System.out.println("Server status " + status.status);
        return status;
    }

    //getToken
    public static Token getToken() {
        response = Unirest.post("https://api.spacetraders.io/users/ikos7890test" + number + "/claim").asString();
        Token token = gson.fromJson(response.getBody(), Token.class);
        token.printOutToken();
        oldtoken = token.token;
        return token;
    }

    //account information
    public static User getAccountInformation() {
        response = Unirest.get("https://api.spacetraders.io/my/account")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        User user1 = gson.fromJson(response.getBody(), User.class);
        user1.printOutUser();
        return user1;
    }

    //get available loans
    public static AvailableLoans getAvailableLoans() {
        response = Unirest.get("https://api.spacetraders.io/types/loans")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        AvailableLoans loans = gson.fromJson(response.getBody(), AvailableLoans.class);
        loans.printOutAvailableLoans();
        return loans;
    }
    //get a loan
    public static MyLoans getALoan(){
        response = Unirest.post("https://api.spacetraders.io/my/loans?type=STARTUP")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        MyLoans myloans = gson.fromJson(response.getBody(), MyLoans.class);
        myloans.printOutLoans();
        return myloans;
    }
     //get active loans
    public static ActiveLoan getActiveLoans(){
        response = Unirest.get("https://api.spacetraders.io/my/loans")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        ActiveLoan activeLoan = gson.fromJson(response.getBody(), ActiveLoan.class);
        activeLoan.printOutActiveLoan();
        return activeLoan;
    }
      //get list of all available ships for purchase
    public static ShipListings getShipsForPurchase(){
        response = Unirest.get("https://api.spacetraders.io/systems/OE/ship-listings")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        ShipListings shipListings = gson.fromJson(response.getBody(), ShipListings.class);
        for (int i = 0; i < shipListings.shipListings.size(); i++) shipListings.shipListings.get(i).printOutShip();
        return shipListings;
    }
       //buy a ship
    public static BuyShip buyShip(){
        response = Unirest.post("https://api.spacetraders.io/my/ships?location=OE-PM-TR&type=JW-MK-I")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        BuyShip buyShip = gson.fromJson(response.getBody(), BuyShip.class);
        buyShip.ship.printOutShip();
        shipid = buyShip.ship.id;
        location = buyShip.ship.location;
        return buyShip;
    }

        //get my ships list
    public static MyShips getShipsList(){
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
        public static Purchase buyFuel(){
            response = Unirest.post("https://api.spacetraders.io/my/purchase-orders?shipId=" + shipid + "&good=FUEL&quantity=20")
                    .header("Authorization", "Bearer " + oldtoken)
                    .asString();
            Purchase purchase = gson.fromJson(response.getBody(), Purchase.class);
            System.out.println("\n\ncredits: " + purchase.credits);
            purchase.order.printOutOrder();
            purchase.ship.printOutShip();
            return purchase;
        }
    //See marketplace
        public static MarketPlace seeMarketplace(){
            response = Unirest.get("https://api.spacetraders.io/locations/" + location + "/marketplace")
                    .header("Authorization", "Bearer " + oldtoken)
                    .asString();
            MarketPlace marketPlace = gson.fromJson(response.getBody(), MarketPlace.class);
            marketPlace.printOutMarketplace();
            return marketPlace;
        }

        //buy metal
        public static Purchase buyMetal(){
            response = Unirest.post("https://api.spacetraders.io/my/purchase-orders?shipId=" + shipid + "&good=METALS&quantity=10")
                    .header("Authorization", "Bearer " + oldtoken)
                    .asString();
            Purchase purchase2 = gson.fromJson(response.getBody(), Purchase.class);
            purchase2.printOutPurchase();
            return purchase2;
        }
        //get nearest locations
        public static Locations getNearestLocation(){
            response = Unirest.get("https://api.spacetraders.io/systems/OE/locations")
                    .header("Authorization", "Bearer " + oldtoken)
                    .asString();
            Locations locations = gson.fromJson(response.getBody(), Locations.class);
            locations.printOutLocations();
            return locations;
        }

        //create flight plan
    public static FlightPlan createFlightPlan() throws InterruptedException {
        response = Unirest.post("https://api.spacetraders.io/my/flight-plans?shipId=" + shipid + "&destination=OE-PM")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        FlightPlan flightPlan = gson.fromJson(response.getBody(), FlightPlan.class);
        flightPlan.flightPlan.printOutFlightPlan();
        Thread.sleep(40000);
        flightPlanId = flightPlan.flightPlan.id;
        return flightPlan;
    }
            //Check plan status
    public static FlightPlan checkPlanStatus(){
        response = Unirest.get("https://api.spacetraders.io/my/flight-plans/" + flightPlanId)
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        FlightPlan flightPlan = gson.fromJson(response.getBody(), FlightPlan.class);
        flightPlan.flightPlan.printOutFlightPlan();
        return flightPlan;
    }

        //sell metals
    public static Purchase sellMetals(){
        response = Unirest.post("https://api.spacetraders.io/my/sell-orders?shipId=" + shipid + "&good=METALS&quantity=10")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        Purchase soldMetals = gson.fromJson(response.getBody(), Purchase.class);
        soldMetals.printOutPurchase();
        return soldMetals;
    }








}
