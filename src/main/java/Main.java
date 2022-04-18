import com.google.gson.Gson;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;


public class Main {
    //    public static void main(String[] args) {
//        Albums albums = gson.fromJson(IOUtils.toString(new URL(url)), Albums.class);
//    }
    public static void main(String[] args) {
        String oldtoken = "0586a3be-68c6-4487-8323-c2512fa7f0f5";
        //serverstatus
        HttpResponse<String> response = Unirest.get("https://api.spacetraders.io/game/status")
                .asString();
        Gson gson = new Gson();
        Status status = gson.fromJson(response.getBody(), Status.class);
        System.out.println("Server status " + status.status);
       // getToken
//        response = Unirest.post("https://api.spacetraders.io/users/ikos7890test8/claim").asString();
//        Token token = gson.fromJson(response.getBody(), Token.class);
//        System.out.println("token " + token.token);
//        System.out.println("username "+ token.user.username);
//        System.out.println("credits "+ token.user.credits);
//        System.out.println("loans "+ token.user.loans);
//        System.out.println("ships "+ token.user.ships);

        //account information
        response = Unirest.get("https://api.spacetraders.io/my/account")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        User user1 = gson.fromJson(response.getBody(), User.class);
        System.out.println("\n\nAccount info:");
        System.out.println("credits: " + user1.user.credits);
        System.out.println("joined at: " + user1.user.joinedAt);
        System.out.println("username: " + user1.user.username);
        System.out.println("ship count: " + user1.user.shipCount);
        System.out.println("structure count: " + user1.user.structureCount);
        //get available loans
        response = Unirest.get("https://api.spacetraders.io/types/loans")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();

        Loans loans = gson.fromJson(response.getBody(),Loans.class);
        System.out.println("\n\nCredits");
        System.out.println(loans.loans.get(0).amount);
        System.out.println(loans.loans.get(0).collateralRequired);
        System.out.println(loans.loans.get(0).rate);
        System.out.println(loans.loans.get(0).type);

        //get a loan

//       response = Unirest.post("https://api.spacetraders.io/my/loans?type=STARTUP")
//                .header("Authorization", "Bearer " + oldtoken)
//                .asString();
//        MyLoans myloans = gson.fromJson(response.getBody(), MyLoans.class);
//        System.out.println("Got a loan");
//        System.out.println("credits " + myloans.credits);
//        System.out.println("due " + myloans.loan.due);
//        System.out.println("id " + myloans.loan.id);
//        System.out.println("repayment " + myloans.loan.repaymentAmount);
//        System.out.println("status " + myloans.loan.status);
//        System.out.println("type " + myloans.loan.type);

        //get active loans

        response = Unirest.get("https://api.spacetraders.io/my/loans")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();
        MyLoans myLoans = gson.fromJson(response.getBody(),MyLoans.class);
        System.out.println("\n\nMy credits");
        System.out.println("due:" + myLoans.loans.get(0).due);
        System.out.println("id: " + myLoans.loans.get(0).id);
        System.out.println("repaymentAmount: " + myLoans.loans.get(0).repaymentAmount);
        System.out.println("status: " + myLoans.loans.get(0).status);
        System.out.println("type: " + myLoans.loans.get(0).type);

        //get list of all available ships for purchase
        response = Unirest.get("https://api.spacetraders.io/systems/OE/ship-listings")
                .header("Authorization", "Bearer " + oldtoken)
                .asString();

    }
}
