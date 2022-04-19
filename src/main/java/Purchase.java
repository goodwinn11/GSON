public class Purchase {
    public String credits;
    public Order order;
    public Ship ship;
    public void printOutPurchase(){
        System.out.println("\n\nPurchase:");
        System.out.println("credits: " + credits);
        order.printOutOrder();
        ship.printOutShip();
    }
}
