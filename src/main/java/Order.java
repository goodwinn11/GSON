public class Order {
    public String good;
    public int pricePerUnit;
    public int quantity;
    public int total;
    public void printOutOrder(){
        System.out.println("\n\norder:");
        System.out.printf("\ngood: %s\npricePerUnit: %d\nquantity: %d\ntotal: %d",
                good, pricePerUnit, quantity, total);
    }
}
