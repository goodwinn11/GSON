import java.util.List;

public class ActiveLoan {
    public List<MyLoan> loans;
    public void printOutActiveLoan(){
        System.out.println("\n\nActive Loans:");
        for(int i = 0; i< loans.size(); i++){
            System.out.printf("due: %s\nid: %s\nrepaymentAmount: %d\nstatus: %s\ntype: %s",
                    loans.get(i).due, loans.get(i).id, loans.get(i).repaymentAmount, loans.get(i).status, loans.get(i).type);
        }

    }
}
