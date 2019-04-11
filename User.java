import java.util.ArrayList;

public class User {

    private String userName;
    private ArrayList<Playlist> playlists;

    /**
     * Creates a default User object that will be making the playlists
     */
    public User(){
        userName = "John Doe";
        playlists = new ArrayList<Playlist>();
    }

    /**
     * Creates a User object with a given username
     * User objects make and contain playlists
     * @param userName the name of the user
     * @see Playlist#Playlist(String)
     */
    public User(String userName){
        this.userName = userName;
        playlists = new ArrayList<Playlist>();
    }

    /**
     * Gets the username of the current user
     * @return userName
     */
    public String getUserName(){
        return this.userName;
    }

    /**
     * Gets all the playlists of the current user
     * @return An ArrayList of Playlist objects
     */
    public ArrayList<Playlist> getAllPlaylists(){
        return this.playlists;
    }

    /**
     * Gets a particular playlist from all the playlists that the user has
     * @param index the particular playlist to be selected
     * @return the playlist that the user selects
     */
    public Playlist getPlaylist(int index) {
            return this.playlists.get(index);
    }

    /**
     * Creates a playlist that is then
     * added to the list of user's other playlists
     * @see Playlist
     */
    public void makePlaylist(){
        this.playlists.add(new Playlist());
    }

    /**
     * Adds an already populated Playlist object to the
     * current User's playlist list
     * @param playlist
     * @see Playlist
     */
    public void addPlaylist(Playlist playlist){
        this.playlists.add(playlist);
    }

    /**
     * Removes a specific playlist from the user's playlist list.
     * @param playlist the particular playlist to be removed
     */
    public void removePlaylist(Playlist playlist){
        this.playlists.remove(playlist);
    }
}