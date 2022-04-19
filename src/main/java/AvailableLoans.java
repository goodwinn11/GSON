import java.util.List;

public class AvailableLoans {
    public List<Loan> loans;

    public void printOutAvailableLoans(){
        for(int i =0; i< loans.size(); i++){
            System.out.println("loans: ");
            System.out.printf("\namount: %d\ncollateralRequired: %b\nrate: %d\nterms in days: %d\ntype: %s",
                    loans.get(i).amount, loans.get(i).collateralRequired, loans.get(i).rate, loans.get(i).termInDays, loans.get(i).type);
        }
    }
}
