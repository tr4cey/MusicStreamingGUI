import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.Serializable;

public class Playlist implements Serializable
{
    private ArrayList<Song> songs;
    String name;
    int playlistLength;
    int playlistTime;

    /**
     * Creates a default Playlist Object
     * Playlists store an ArrayList of Song Objects
     */
    public Playlist()
    {
        this.name="New Playlist";
        playlistLength = 0;
        playlistTime = 0;
        songs = new ArrayList<Song>();
    }

    /**
     * Creates a Playlist object with a given name
     * Playlists store an ArrayList of Song Objects
     * @param name The name of the Playlist
     */
    public Playlist(String name)
    {
        this.name=name;
        playlistLength = 0;
        playlistTime = 0;
        songs = new ArrayList<Song>();
    }

    /**
     * Adds the given song to the Playlist
     * @param song the song being added
     * @see Song#Song(String, String, int, int, String)
     */
    public void addSong(Song song)
    {
        if (playlistTime/60 <= 180) {
            this.songs.add(song);
            playlistTime = playlistTime + song.getLengthSec();
            playlistLength ++;
        }
    }

    /**
     * Removes a Song from the Playlist at a specific Index
     * @param index 
     */
    public void removeSong(int index)
    {
        if (playlistTime/60 > 60) {
            playlistTime -= songs.get(index).getLengthSec();
            songs.remove(index);
        }
    }

    /**
     * Sorts the Playlist by the given String
     * @param sortBy String for sorting
     */
    public void sortPlaylist(String sortBy)
    {
        if (sortBy.toLowerCase().equals("name")) {
            Collections.sort(songs, new SongsByNameComparator());
        }
        else if (sortBy.toLowerCase().equals("artist")) {
            Collections.sort(songs, new SongsByArtistComparator());
        }
        else if (sortBy.toLowerCase().equals("year")) {
            Collections.sort(songs, new SongsByYearComparator());
        }
        else if (sortBy.toLowerCase().equals("time")) {
            Collections.sort(songs, new SongsByTimeComparator());
        }
        else if (sortBy.toLowerCase().equals("genre")) {
            Collections.sort(songs, new SongsByGenreComparator());
        }
    }

    /**
     * Gets the name of PLaylist
     * @return playlist name
     */
    public String getPlaylistName()
    {
        return this.name;
    }

    /**
     * Sets the Playlist name
     * @param newName Name of Plaulist
     */
    public void setPlaylistName(String newName)
    {
        this.name = newName;
    }
    
    /**
     * Converts runTime of Playlist from seconds to minutes 
     * @return Playlist runTime in seconds
     */
    public String getPlaylistRuntimeString()
    {
        String minSec = (playlistTime/60) + "";
        minSec += ":";
        minSec += (playlistTime%60) + "";
        return minSec;
    }

     /**
     * Gets the length of the playlist in seconds
     * @param playlist The Playlist
     * @return the runTime of the playlist in seconds
     */
    public int getPlaylistRunTime(ArrayList<Song> playlist)
    {
        int runTime = 0; //in seconds
        for(int i = 0; i < playlist.size(); i++)
        {
            runTime += playlist.get(i).getLengthSec();
        }
        return runTime;
    }

    /**
     * Gets a Song from a specific index of the playlist
     * @param index index of the song
     * @return song
     */
    public Song getSong(int index)
    {
        return this.songs.get(index);
    }

    /**
     * Returns a reference to the ArrayList of Songs
     * @return songs
     */
    public ArrayList<Song> getList()
    {
        return songs;
    }

    /**
     * Returns the amount of songs that are present
     * in the playlist
     * @return the number of songs in the playlist
     */
    public int getSize()
    {
        return songs.size();
    }

}

// Comparator Classes Below

class SongsByNameComparator implements Comparator<Song>
{
    public int compare(Song a, Song b)
    {
        return a.getName().compareToIgnoreCase(b.getName());
    }
}

class SongsByArtistComparator implements Comparator<Song>
{
    public int compare(Song a, Song b)
    {
        return a.getArtist().compareToIgnoreCase(b.getArtist());
    }
}

class SongsByYearComparatpr implements Comparator<Song>
{
    public int compare(Song a, Song b)
    {
        if (a.getYear() < b.getYear()) { return 1; }
        else if (a.getYear() > b.getYear()) { return -1; }
        else { return 0; }
    }
}

class SongsByYearComparator implements Comparator<Song>
{
    public int compare(Song a, Song b)
    {
        if (a.getYear() < b.getYear()) { return 1; }
        else if (a.getYear() > b.getYear()) { return -1; }
        else { return 0; }
    }
}

class SongsByTimeComparator implements Comparator<Song>
{
    public int compare(Song a, Song b)
    {
        if (a.getLengthSec() < b.getLengthSec()) { return 1; }
        else if (a.getLengthSec() > b.getLengthSec()) { return -1; }
        else { return 0; }
    }
}

class SongsByGenreComparator implements Comparator<Song>
{
    public int compare(Song a, Song b)
    {
        return a.getGenre().compareToIgnoreCase(b.getGenre());
    }
}