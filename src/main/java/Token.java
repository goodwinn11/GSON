public class Token {
    String token;
    UserStatus user;

    public void printOutToken(){
        System.out.println("token " + token);
        System.out.println("username " + user.username);
        System.out.println("credits " + user.credits);
        System.out.println("loans " + user.loans);
        System.out.println("ships " + user.ships);
    }
}
