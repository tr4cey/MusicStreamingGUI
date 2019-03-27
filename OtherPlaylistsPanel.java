
import javax.swing.*;
import java.awt.*;

public class OtherPlaylistsPanel extends JPanel
{
    private BorderLayout layout = new BorderLayout();

    private JList otherPlaylists;
    private JScrollPane oScroll;
    private JPanel songList;

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
        songList = new JPanel();
        songList.setLayout(new GridLayout(5,2));

        // To demonstrate what a lot of songs will look like
        JLabel label1 = new JLabel("Song1");
        JLabel label2 = new JLabel("Song2");
        JLabel label3 = new JLabel("Song3");
        JLabel label4 = new JLabel("Song4");
        JLabel label5 = new JLabel("Song5");
        // JLabel label6 = new JLabel("Song6");
        // JLabel label7 = new JLabel("Song7");
        // JLabel label8 = new JLabel("Song8");
        // JLabel label9 = new JLabel("Song9");
        // JLabel label10 = new JLabel("Song10");


        JButton button1 = new JButton("+");
        JButton button2 = new JButton("+");
        JButton button3 = new JButton("+");
        JButton button4 = new JButton("+");
        JButton button5 = new JButton("+");
        // JButton button6 = new JButton("+");
        // JButton button7 = new JButton("+");
        // JButton button8 = new JButton("+");
        // JButton button9 = new JButton("+");
        // JButton button10 = new JButton("+");

        songList.add(label1);
        songList.add(button1);
        songList.add(label2);
        songList.add(button2);
        songList.add(label3);
        songList.add(button3);
        songList.add(label4);
        songList.add(button4);
        songList.add(label5);
        songList.add(button5);


        this.add(songList, BorderLayout.CENTER);
    }

    public void createTitle()
    {
        title = new JLabel("Other Playlists");
        this.add(title, BorderLayout.NORTH);
    }
}