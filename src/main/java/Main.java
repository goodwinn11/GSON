



public class Main {

    public static void main(String[] args) throws InterruptedException {
        SpacetradersAPI api = new SpacetradersAPI();
        Status status = api.serverStatus();
        Token token = api.getToken(60);
        User user1 = api.getAccountInformation();
        AvailableLoans loans = api.getAvailableLoans();
        MyLoans myloans = api.getALoan("STARTUP");
        ActiveLoan activeLoan = api.getActiveLoans();
        ShipListings shipListings = api.getShipsForPurchase("OE");
        BuyShip buyShip = api.buyShip("OE-PM-TR","JW-MK-I");
        MyShips myShips = api.getShipsList();
        Purchase purchase = api.buySomething("FUEL", 20);
        MarketPlace marketPlace = api.seeMarketplace();
        purchase = api.buySomething("METALS", 10);
        Locations locations = api.getNearestLocation("OE");
        FlightPlan flightPlan = api.createFlightPlan("OE-PM");
        flightPlan = api.checkPlanStatus();
        purchase = api.sellSomething("METALS",10);
        api.writeToFile();


    }


}

