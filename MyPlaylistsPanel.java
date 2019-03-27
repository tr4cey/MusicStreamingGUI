
import java.awt.BorderLayout;

import javax.swing.*;
import java.awt.*;

public class MyPlaylistsPanel extends JPanel
{
    private BorderLayout layout = new BorderLayout();

    private JList myPlaylists;
    private JScrollPane mpScroll;
    private JLabel title;

    public MyPlaylistsPanel()
    {
        this.setLayout(layout);
        createTitle();
        createMyPlaylists();
        addNewPlayList();
    }

    public void createMyPlaylists()
    {
        myPlaylists = new JList();
        myPlaylists.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        myPlaylists.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        myPlaylists.setVisibleRowCount(-1);
        mpScroll = new JScrollPane(myPlaylists);
        this.add(mpScroll, BorderLayout.CENTER);
    }

    public void createTitle()
    {
        title = new JLabel("My Playlists");
        this.add(title, BorderLayout.NORTH);
    }

    public void addNewPlayList() {
        JButton button = new JButton("+");
        // add button actions here...
        this.add(button,BorderLayout.SOUTH);
    }
}