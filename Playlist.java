import java.util.ArrayList;

public class Playlist{
    
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
    public Playlist(){
        this.name="New Playlist";
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

    public Song getSong(int index){
        return this.songs.get(index);
    }

    public void addSong(Song song){
        this.songs.add(song);
        playlistTime = playlistTime + song.getLengthSec();
        playlistLength ++;
    }

    public void sortPlaylist(){
        Collections.sort(Songs, new CompareSongs());
    }
    
}

class CompareSongs implements Comparator<Song>{
    @Override
    public int compareTo(Song a, song b) {
        return a.getName.compareToIgnoreCase(b.getName());
    }
}