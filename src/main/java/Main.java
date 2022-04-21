



public class Main {

    public static void main(String[] args) throws InterruptedException {
        String oldtoken = "0586a3be-68c6-4487-8323-c2512fa7f0f5";

        String location = "OE-PM-TR";
        SpacetradersAPI.number = 51;
        Status status = SpacetradersAPI.serverStatus();
        Token token = SpacetradersAPI.getToken();
        User user1 = SpacetradersAPI.getAccountInformation();
        AvailableLoans loans = SpacetradersAPI.getAvailableLoans();
        MyLoans myloans = SpacetradersAPI.getALoan();
        ActiveLoan activeLoan = SpacetradersAPI.getActiveLoans();
        ShipListings shipListings = SpacetradersAPI.getShipsForPurchase();
        BuyShip buyShip = SpacetradersAPI.buyShip();
        MyShips myShips = SpacetradersAPI.getShipsList();
        Purchase purchase = SpacetradersAPI.buyFuel();
        MarketPlace marketPlace = SpacetradersAPI.seeMarketplace();
        purchase = SpacetradersAPI.buyMetal();
        Locations locations = SpacetradersAPI.getNearestLocation();
        FlightPlan flightPlan = SpacetradersAPI.createFlightPlan();
        flightPlan = SpacetradersAPI.checkPlanStatus();
        purchase = SpacetradersAPI.sellMetals();


    }


}

