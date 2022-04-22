import com.google.gson.Gson;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public interface ISpaceTradersAPI {
    public Status serverStatus();
    public Token getToken(int number);
    public User getAccountInformation();
    public AvailableLoans getAvailableLoans();
    public MyLoans getALoan(String type);
    public ActiveLoan getActiveLoans();
    public ShipListings getShipsForPurchase(String system);
    public BuyShip buyShip(String location, String type);
    public MyShips getShipsList();
    public Purchase buySomething(String good, int quantity);
    public MarketPlace seeMarketplace();
    public Locations getNearestLocation(String system);
    public FlightPlan createFlightPlan(String destination) throws InterruptedException;
    public FlightPlan checkPlanStatus();
    public Purchase sellSomething(String good, int quantity);
}
