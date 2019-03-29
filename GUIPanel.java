import javax.swing.*;
import java.awt.*;

public class GUIPanel extends JFrame
{
    BorderLayout bd = new BorderLayout();
    private static final int FRAME_WIDTH = 1080;
    private static final int FRAME_HEIGHT = 720;

    public GUIPanel()
    {
        this.setLayout(bd);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        createMyPlaylistsPanel();
        createCurPlaylistPanel();
        createOtherPlaylistsPanel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createMyPlaylistsPanel()
    {
        JPanel myPanel = new MyPlaylistsPanel();
        myPanel.setPreferredSize( new Dimension( 100, 200 ) );
        this.add(myPanel, BorderLayout.WEST);
    }
    public void createCurPlaylistPanel()
    {
        JPanel currentPanel = new CurPlaylistPanel();
        currentPanel.setPreferredSize( new Dimension( 100, 200 ) );
        this.add(currentPanel, BorderLayout.CENTER);
    }
    public void createOtherPlaylistsPanel()
    {
        JPanel otherPanel = new OtherPlaylistsPanel();
        otherPanel.setPreferredSize( new Dimension( 100, 200 ) );
        this.add(otherPanel, BorderLayout.EAST);
    }
}
