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

    public void addNewPlayList()
    {
        JPanel buttonPanel = new JPanel(new GridLayout(1,2));
        JButton addButton = new JButton("+");
        JButton removeButton = new JButton("-");
        // add button actions here...

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }
}