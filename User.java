import java.util.ArrayList;

public class User {
    
    private String userName;
    private ArrayList<Playlist> playlists;

    /**
     * The user that will be making the 
     * playlists 
     */
    public User(){

        userName = "John Doe";
        playlists = new ArrayList<Playlist>();
    }

    /**
     * Creates a user with a username already defined 
     * @param userName the name of the user
     */
    public User(String userName){
        this.userName = userName;
        playlists = new ArrayList<Playlist>();
    }

    /**
     * Gets the username of the user 
     * @return the username 
     */
    public String getUserName(){
        return this.userName;
    }

    /**
     * Returns all the playlists of the user 
     */
    public ArrayList<Playlist> getAllPlaylists(){
        return this.playlists;
    }

    /**
     * Gets a particular playlist from all 
     * the playlists that the user has 
     * @param index the particular playlist to be selected 
     * @return the playlist that the user wants
     */
    public Playlist getPlaylist(int index){
        return this.playlists.get(index);
    }

    /**
     * Creates a playlist that is then 
     * added to the list of user's other playlists
     */
    public void makePlaylist(){
        this.playlists.add(new Playlist());
    }

    /**
     * Removes a particular playlist from the user's 
     * plaulist list. 
     * @param playlist the particular playlist to be removed
     */
    public void removePlaylist(Playlist playlist){
        this.playlists.remove(playlist);
    }
}