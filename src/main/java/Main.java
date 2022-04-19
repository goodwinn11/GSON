import com.google.gson.Gson;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;



public class Main {

    public static void main(String[] args) throws InterruptedException {
        String oldtoken = "0586a3be-68c6-4487-8323-c2512fa7f0f5";

        String location = "OE-PM-TR";
        //serverstatus
        HttpResponse<String> response = Unirest.get("https://api.spacetraders.io/game/status")
                .asString();
        Gson gson = new Gson();
        Status status = gson.fromJson(response.getBody(), Status.class);
        System.out.println("Server status " + status.status);
        //getToken
        response = Unirest.post("https://api.spacetraders.io/users/ikos7890test28/claim").asString();
        Token token = gson.fromJson(response.getBody(), Token.class);
        System.out.println("token " + token.token);
        System.out.println("username " + token.user.username);
        System.out.println("credits " + token.user.credits);
        System.out.println("loans " + token.user.loans);
        System.out.println("ships " + token.user.ships);
        oldtoken = token.token;
        //account information
        response = Unirest.get("https://api.spacetraders.io/my/account")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        User user1 = gson.fromJson(response.getBody(), User.class);
        System.out.println("\n\nAccount info:");
        System.out.println("credits: " + user1.user.credits);
        System.out.println("joined at: " + user1.user.joinedAt);
        System.out.println("username: " + user1.user.username);
        System.out.println("ship count: " + user1.user.shipCount);
        System.out.println("structure count: " + user1.user.structureCount);

        //get available loans
        response = Unirest.get("https://api.spacetraders.io/types/loans")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();

        AvailableLoans loans = gson.fromJson(response.getBody(), AvailableLoans.class);
        loans.printOutAvailableLoans();

        //get a loan

        response = Unirest.post("https://api.spacetraders.io/my/loans?type=STARTUP")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        MyLoans myloans = gson.fromJson(response.getBody(), MyLoans.class);
        myloans.printOutLoans();

        //get active loans

        response = Unirest.get("https://api.spacetraders.io/my/loans")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        ActiveLoan activeLoan = gson.fromJson(response.getBody(), ActiveLoan.class);
       activeLoan.printOutActiveLoan();

        //get list of all available ships for purchase
        response = Unirest.get("https://api.spacetraders.io/systems/OE/ship-listings")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        ShipListings shipListings = gson.fromJson(response.getBody(), ShipListings.class);
        for (int i = 0; i < shipListings.shipListings.size(); i++) shipListings.shipListings.get(i).printOutShip();

        //buy a ship
        response = Unirest.post("https://api.spacetraders.io/my/ships?location=OE-PM-TR&type=JW-MK-I")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        BuyShip buyShip = gson.fromJson(response.getBody(), BuyShip.class);
        buyShip.ship.printOutShip();
        String shipid = buyShip.ship.id;
        String shipLocation = buyShip.ship.location;


        //get my ships list
        response = Unirest.get("https://api.spacetraders.io/my/ships")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        MyShips myShips = gson.fromJson(response.getBody(), MyShips.class);
        System.out.println("\n\nMy ships: ");
        myShips.ships.get(0).printOutShip();
        location = myShips.ships.get(0).location;

        //buy fuel
        response = Unirest.post("https://api.spacetraders.io/my/purchase-orders?shipId=" + shipid + "&good=FUEL&quantity=20")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        Purchase purchase = gson.fromJson(response.getBody(), Purchase.class);
        System.out.println("\n\ncredits: " + purchase.credits);
        purchase.order.printOutOrder();
        purchase.ship.printOutShip();

        //See marketplace
        response = Unirest.get("https://api.spacetraders.io/locations/" + location + "/marketplace")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        MarketPlace marketPlace = gson.fromJson(response.getBody(), MarketPlace.class);
        marketPlace.printOutMarketplace();

        //buy metal
        response = Unirest.post("https://api.spacetraders.io/my/purchase-orders?shipId=" + shipid + "&good=METALS&quantity=10")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        Purchase purchase2 = gson.fromJson(response.getBody(), Purchase.class);
        purchase2.printOutPurchase();

        //get nearest locations
        response = Unirest.get("https://api.spacetraders.io/systems/OE/locations")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        Locations locations = gson.fromJson(response.getBody(), Locations.class);
        locations.printOutLocations();

        //create flight plan
        response = Unirest.post("https://api.spacetraders.io/my/flight-plans?shipId=" + shipid + "&destination=OE-PM")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        FlightPlan flightPlan = gson.fromJson(response.getBody(), FlightPlan.class);
        flightPlan.flightPlan.printOutFlightPlan();
        Thread.sleep(120000);
        String flightPlanId = flightPlan.flightPlan.id;

        //Check plan status
        response = Unirest.get("https://api.spacetraders.io/my/flight-plans/" + flightPlanId)
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        flightPlan = gson.fromJson(response.getBody(), FlightPlan.class);
        flightPlan.flightPlan.printOutFlightPlan();

        //sell metals
        response = Unirest.post("https://api.spacetraders.io/my/sell-orders?shipId=" + shipid + "&good=METALS&quantity=10")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        Purchase soldMetals = gson.fromJson(response.getBody(), Purchase.class);
        soldMetals.printOutPurchase();

    }


}

