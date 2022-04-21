



public class Main {

    public static void main(String[] args) throws InterruptedException {
        String oldtoken = "0586a3be-68c6-4487-8323-c2512fa7f0f5";

        String location = "OE-PM-TR";
        SpacetradersAPI.number = 46;
        SpacetradersAPI.serverStatus();
        SpacetradersAPI.getToken();
        SpacetradersAPI.getAccountInformation();
        SpacetradersAPI.getAvailableLoans();
        SpacetradersAPI.getALoan();
        SpacetradersAPI.getActiveLoans();
        SpacetradersAPI.getShipsForPurchase();
        SpacetradersAPI.buyShip();
        SpacetradersAPI.getShipsList();
        SpacetradersAPI.buyFuel();
        SpacetradersAPI.seeMarketplace();
        SpacetradersAPI.buyMetal();
        SpacetradersAPI.getNearestLocation();
        SpacetradersAPI.createFlightPlan();
        SpacetradersAPI.checkPlanStatus();
        SpacetradersAPI.sellMetals();


    }


}

