import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Playlist
{
    private ArrayList<Song> songs;
    String name;
    int playlistLength;
    int playlistTime;

    public Playlist(String name)
    {
        this.name=name;
        playlistLength = 0;
        playlistTime = 0;
        songs = new ArrayList<Song>();
    }

    public Playlist()
    {
        this.name="New Playlist";
        playlistLength = 0;
        playlistTime = 0;
        songs = new ArrayList<Song>();

    }

    /**
     * Adds the song to the playllst
     * @param song the song being added
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
     * Returns the amount of songs that are present
     * in the playlist
     * @return the number of songs in the playlist
     */
    public void removeSong(int index)
    {
        if (playlistTime/60 > 60) {
            playlistTime -= songs.get(index).getLengthSec();
            songs.remove(index);
        }
    }

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

    //Getters and Setters
    public String getPlaylistName()
    {
        return this.name;
    }

    public void setPlaylistName(String newName)
    {
        this.name = newName;
    }

    public String getPlaylistRuntimeString()
    {
        String minSec = (playlistTime/60) + "";
        minSec += ":";
        minSec += (playlistTime%60) + "";
        return minSec;
    }

     /**
     * Gets the length of the playlist in seconds
     * @param playlist the playlist
     * @return the length of the playlist in seconds
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
     * Gets the song from the playlist
     * @param index the index of the song needed
     * @return the song
     */
    public Song getSong(int index)
    {
        return this.songs.get(index);
    }

    public ArrayList<Song> getList()
    {
        return songs;
    }

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