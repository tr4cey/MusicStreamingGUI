import java.util.ArrayList;

public class User {
    
    private String userName;
    private ArrayList<Playlist> playlists;


    public User(){

        userName = "John Doe";
        playlists = new ArrayList<Playlist>();
    }

    public User(String userName){
        this.userName = userName;
        playlists = new ArrayList<Playlist>();
    }

    public String getUserName(){
        return this.userName;
    }

    public ArrayList<Playlist> getAllPlaylists(){
        return this.playlists;
    }

    public Playlist getPlaylist(int index){
        return this.playlists.get(index);
    }

    public void makePlaylist(){
        this.playlists.add(new Playlist());
    }
}