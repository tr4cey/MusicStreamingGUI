import javax.swing.*;
import java.awt.*;

public class GUIPanel extends JFrame
{
    private static final int  TEXT_AREA_WIDTH = 20;
    private static final int TEXT_AREA_HEIGHT = 20;

    private JPanel mainPanel = new JPanel(new BorderLayout());

    private JTextArea myPlaylistsTextArea = new JTextArea(TEXT_AREA_WIDTH, TEXT_AREA_HEIGHT);
    private JTextArea addPlaylistsTextArea = new JTextArea(TEXT_AREA_WIDTH, TEXT_AREA_HEIGHT);


    private JLabel myPlaylists = new JLabel("My playlists: ") ;
    private JLabel addplaylists = new JLabel("Add Playlist:");



    public GUIPanel()
    {
        WestPanel();
        CentrePanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void WestPanel()
    {

        myPlaylistsTextArea.setEditable(false);

        JPanel westTopPanel = new JPanel(new BorderLayout());
        JPanel westCentrePanel = new JPanel(new BorderLayout());
        JPanel westPanel = new JPanel(new BorderLayout());

        westTopPanel.add(myPlaylists, BorderLayout.CENTER);
        westCentrePanel.add(myPlaylistsTextArea, BorderLayout.CENTER);

        JScrollPane scrollPaneSavings = new JScrollPane(myPlaylistsTextArea);

        westCentrePanel.add(scrollPaneSavings);

        westPanel.add(westTopPanel, BorderLayout.NORTH);
        westPanel.add(westCentrePanel, BorderLayout.CENTER);

        mainPanel.add(westPanel, BorderLayout.WEST);

        add(mainPanel);
    }

    public void CentrePanel()
    {

        addPlaylistsTextArea.setEditable(false);

        JPanel centreTopPanel = new JPanel(new BorderLayout());
        JPanel centreCentrePanel = new JPanel(new BorderLayout());
        JPanel centrePanel = new JPanel(new BorderLayout());

        centreTopPanel.add(addplaylists, BorderLayout.CENTER);
        centreCentrePanel.add(addPlaylistsTextArea, BorderLayout.CENTER);

        centrePanel.add(centreTopPanel, BorderLayout.NORTH);
        centrePanel.add(centreCentrePanel, BorderLayout.CENTER);

        JScrollPane scroll = new JScrollPane(addPlaylistsTextArea);

        centreCentrePanel.add(scroll);

        mainPanel.add(centrePanel, BorderLayout.CENTER);

        add(mainPanel);
    }
}
