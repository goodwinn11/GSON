public class User {
    UserData user;
    public void printOutUser(){
        System.out.println("\n\nAccount info:");
        System.out.println("credits: " + user.credits);
        System.out.println("joined at: " + user.joinedAt);
        System.out.println("username: " + user.username);
        System.out.println("ship count: " + user.shipCount);
        System.out.println("structure count: " + user.structureCount);
    }
}
