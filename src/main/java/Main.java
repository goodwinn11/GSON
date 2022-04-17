import com.google.gson.Gson;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;


public class Main {
    //    public static void main(String[] args) {
//        Albums albums = gson.fromJson(IOUtils.toString(new URL(url)), Albums.class);
//    }
    public static void main(String[] args) {

        //serverstatus
        HttpResponse<String> response = Unirest.get("https://api.spacetraders.io/game/status")
                .asString();
        Gson gson = new Gson();
        Status status = gson.fromJson(response.getBody(), Status.class);
        System.out.println("Server status " + status.status);
        //getToken
        response = Unirest.post("https://api.spacetraders.io/users/ikos7890test5/claim").asString();
        Token token = gson.fromJson(response.getBody(), Token.class);
        System.out.println("token " + token.token);
        System.out.println("username "+ token.user.username);
        System.out.println("credits "+ token.user.credits);
        System.out.println("loans "+ token.user.loans);
        System.out.println("ships "+ token.user.ships);
        response = Unirest.get("https://api.spacetraders.io/my/account")
                .header("Authorization", "Bearer 99cd7c19-629d-4192-b699-7941c8d3420d")
                .asString();
        User user1 = gson.fromJson(response.getBody(), User.class);
        System.out.println(user1.user.credits);
        System.out.println(user1.user.joinedAt);
        System.out.println(user1.user.username);
        System.out.println(user1.user.shipCount);
        System.out.println(user1.user.structureCount);


    }
}
