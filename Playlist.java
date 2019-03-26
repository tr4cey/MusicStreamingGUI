import java.util.ArrayList;

public class Playlist {
    
    private ArrayList<Song> songs;

    public Playlist(){

        songs = new ArrayList<Song>();

    }

    public Song getSong(int index){
        return this.songs.get(index);
    }

    public void addSong(Song song){
        this.songs.add(song);
    }

}