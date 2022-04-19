import java.util.List;

public class MarketPlace {
    List<Product> marketplace;
    public void printOutMarketplace(){
        System.out.println("\n\nMarketplace: ");
        for(int i = 0; i < marketplace.size(); i++){
            System.out.printf("\n\npricePerUnit: %d\npurchasePricePerUnit: %d\nquantityAvailable: %d\nsellPricePerUnit: %d\nspread: %d\nsymbol: %s\nvolumePerUnit: %d",
                    marketplace.get(i).pricePerUnit, marketplace.get(i).purchasePricePerUnit, marketplace.get(i).quantityAvailable,
                    marketplace.get(i).sellPricePerUnit, marketplace.get(i).spread, marketplace.get(i).symbol, marketplace.get(i).volumePerUnit);
        }
    }
}
