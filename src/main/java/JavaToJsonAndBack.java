import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JavaToJsonAndBack {
    public static void main(String[] args) {
        Albums albums = new Albums();
        albums.title = "Free Music Archive - Albums";
        albums.message = "";
        albums.total = "11259";
        albums.total_pages = 2252;
        albums.page = 1;
        albums.limit = "5";
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting().serializeNulls();
        builder.serializeNulls();
        Gson gson = builder.create();
        System.out.println(gson.toJson(albums));

        Dataset dataset = new Dataset();
        dataset.album_id="7596";
        dataset.album_title = "Album 1";
        System.out.println(gson.toJson(dataset));
        builder.serializeNulls();
        AlbumImages image = new AlbumImages();
        image.image_id = "1";
        System.out.println(gson.toJson(image));
        dataset.images.add(image);
        albums.dataset.add(dataset);
        builder.setPrettyPrinting().serializeNulls();
        System.out.println(gson.toJson(albums));

    }
}
