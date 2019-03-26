import java.util.ArrayList;

public class Playlist {

    private ArrayList<Song> songs;

    public Playlist(){

        songs = new ArrayList<Song>();

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
    }


    /**
     * Gets the length of the playlist in seconds
     * @param playlist the playlist
     * @return the length of the playlist in seconds
     */

    public String playlistLength(ArrayList<Song> playlist)
    {

        int length = 0;

        for(int i = 0; i < playlist.size(); i++)
        {
            length += playlist.get(i).secLength;
        }
    }

}
