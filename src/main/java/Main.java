



public class Main {
static boolean dummy;

    public static void main(String[] args) throws InterruptedException {
        dummy = true;
        SpacetradersAPI api = new SpacetradersAPI();
        if(dummy) {
            api = new DummySpaceTradersAPI();
        }

        Status status = api.serverStatus();
        Token token = api.getToken(68);
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

