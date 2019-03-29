import java.util.ArrayList;

public class Playlist {

    private ArrayList<Song> songs;
    String name;
    int playlistLength;
    int playlistTime;

    public Playlist(String name){
        this.name=name;
        playlistLength = 0;
        playlistTime = 0;
        songs = new ArrayList<Song>();

    }
    public String getPlaylistName(){
        return this.name;
    }

    public void setPlaylistName(String newName){
        this.name = newName;
    }

    public String getPlaylistRuntime(){
        String minSec = (playlistTime/60) + "";
        minSec += ":";
        minSec += (playlistTime%60) + "";
        return minSec;
    } 

    /**
     * Gets the song from the playlist
     * @param index the index of the song needed
     * @return the song
     */

    public Song getSong(int index){
        return this.songs.get(index);
    }


    /**
     * Adds the song to the playllst
     * @param song the song being added
     */
    public void addSong(Song song){
        this.songs.add(song);
        playlistTime = playlistTime + song.getLengthSec();
        playlistLength ++;
    }


    /**
     * Gets the length of the playlist in seconds
     * @param playlist the playlist
     * @return the length of the playlist in seconds
     */

    public int playlistRunTime(ArrayList<Song> playlist){
        int runTime = 0; //in seconds
        for(int i = 0; i < playlist.size(); i++)
        {
            runTime += playlist.get(i).secLength;
        }
        return runTime;
    }

}
