import java.util.List;

public class MyLoans {
public int credits;
public MyLoan loan;
public void printOutLoans(){
        System.out.println("\n\nMy loan:");
    System.out.println("credits: "+ credits);
    System.out.println("loan: ");
    System.out.printf("due: %s\nid: %s\nrepaymentAmount: %d\nstatus: %s\ntype: %s",
                loan.due, loan.id, loan.repaymentAmount, loan.status, loan.type);
}

}
