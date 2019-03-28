
import javax.swing.*;
import java.awt.*;

public class OtherPlaylistsPanel extends JPanel
{
    private BorderLayout layout = new BorderLayout();

    private JList<String> otherPlaylists;
    private DefaultListModel<String> listModel = new DefaultListModel<String>();
    private JScrollPane oScroll;
    private JScrollPane songList;

    private JLabel title;

    public OtherPlaylistsPanel()
    {
        this.setLayout(layout);
        createTitle();
        createOtherPlaylists();
    }

    public void createOtherPlaylists()
    {
        createSongList();
        otherPlaylists.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        otherPlaylists.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        otherPlaylists.setVisibleRowCount(-1);
        oScroll = new JScrollPane(otherPlaylists);
        this.add(oScroll, BorderLayout.CENTER);
        JButton addButton = new JButton("+");
        this.add(addButton, BorderLayout.SOUTH);
    }

    public void createSongList()
    {
       // To demonstrate what a lot of songs will look like
       for (int i = 1; i < 11; i++) {
           listModel.addElement("Song " + i);
       }

        otherPlaylists = new JList<String>(listModel);
    }

    public void createTitle()
    {
        title = new JLabel("Other Playlists");
        this.add(title, BorderLayout.NORTH);
    }
}