import javax.swing.*;
import java.awt.*;
import java.util.concurrent.locks.ReadWriteLock;

public class CurPlaylistPanel extends JPanel
{
    private BorderLayout layout = new BorderLayout();

    private JTextArea songList;
    private JScrollPane songScroll;
    private JLabel title;

    public CurPlaylistPanel()
    {
        this.setLayout(layout);
        createTitle();
        createSongsList();
    }

    public void createTitle()
    {
        title = new JLabel("Current Playlist");
        this.add(title, BorderLayout.NORTH);
    }
    public void createSongsList()
    {
        songList = new JTextArea(100,100);
        songList.setPreferredSize( new Dimension( 100, 100 ) );
        songList.setText("Song 1\nSong 2\nSong 3");
        songList.setEditable(false);

        songScroll = new JScrollPane(songList);
        this.add(songList, BorderLayout.CENTER);
    }
}