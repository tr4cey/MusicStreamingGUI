
import javax.swing.*;
import java.awt.*;

public class OtherPlaylistsPanel extends JPanel
{
    private BorderLayout layout = new BorderLayout();
    
    private JList otherPlaylists;
    private JScrollPane oScroll;
    private JTextArea songList;

    private JLabel title;

    public OtherPlaylistsPanel()
    {
        this.setLayout(layout);
        createTitle();
        createSongList();
        createOtherPlaylists();
    }

    public void createOtherPlaylists()
    {
        otherPlaylists = new JList();
        otherPlaylists.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        otherPlaylists.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        otherPlaylists.setVisibleRowCount(-1);

        oScroll = new JScrollPane(otherPlaylists);

        this.add(oScroll, BorderLayout.SOUTH);
    }

    public void createSongList()
    {
        songList = new JTextArea(100,100);
        songList.setText("Song 1\nSong 2\nSong 3");
        this.add(songList, BorderLayout.CENTER);
    }

    public void createTitle()
    {
        title = new JLabel("Other Playlists");
        this.add(title, BorderLayout.NORTH);    
    }
}