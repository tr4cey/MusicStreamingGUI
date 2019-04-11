import java.io.*;
import java.util.*;

import javax.swing.DefaultListModel;
import javax.swing.*;

import javax.swing.event.*;


public class GUIPanel extends javax.swing.JFrame
{
    User otherUserPlaylists = new User();

    int otherUserPlaylistSelected = 0;
    int otherSongSelected = -1;
    int userPlaylistSelected = -1;

    // Song titles and playlist names are added to these for display
    private DefaultListModel<String> userSongsListDisplay = new DefaultListModel<String>();
    private DefaultListModel<String> otherUserSongsListDisplay = new DefaultListModel<String>();
    private DefaultListModel<String> userPlaylistsDisplay = new DefaultListModel<String>();
    private DefaultListModel<String> otherUserPlaylistsDisplay = new DefaultListModel<String>();


    User masterUser = new User();

    public GUIPanel()
    {
        //Add all songs playlist
        otherUserPlaylists.addPlaylist(masterPlaylist());
        //Add other premade playlists tp otherUserPlaylists
        otherPlaylists();

        displayPlaylists(otherUserPlaylists, "other");
        displaySongs(otherUserPlaylists.getPlaylist(0),"other");

        initComponents();
    }

    public void otherPlaylists()
    {
        ArrayList<Song> all = (otherUserPlaylists.getPlaylist(0)).getList();

        Playlist elton = new Playlist("Elton John");
        Playlist beatles = new Playlist("The Beatles");
        Playlist abba = new Playlist("ABBA");
        Playlist queen = new Playlist("Queen");

        for (int x = 0; x < all.size(); x++)
        {
            if(all.get(x).getArtist().equals("The Beatles"))
            {
                beatles.addSong(all.get(x));
            }
            else if(all.get(x).getArtist().equals("ABBA"))
            {
                abba.addSong(all.get(x));
            }
            else if(all.get(x).getArtist().equals("Queen"))
            {
                queen.addSong(all.get(x));
            }
            else if(all.get(x).getArtist().equals("Elton John"))
            {
                elton.addSong(all.get(x));
            }
        }

        otherUserPlaylists.addPlaylist(beatles);
        otherUserPlaylists.addPlaylist(elton);
        otherUserPlaylists.addPlaylist(abba);
        otherUserPlaylists.addPlaylist(queen);
    }

    public Playlist masterPlaylist()
    {
        Playlist master = new Playlist("All Songs");
        String file = "SongList.txt";
        String line = null;
        Scanner scan;

        String name = "n/a";
        String artist = "n/a";
        String genre = "n/a";
        int year = 0,length = 0;

        try
        {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            while((line = br.readLine()) != null)
            {
                scan = new Scanner(line);
                scan.useDelimiter("_");

                while(scan.hasNext())
                {
                    name = scan.next();
                    artist = scan.next();
                    year = Integer.parseInt(scan.next());
                    length = Integer.parseInt(scan.next());
                    genre = scan.next();
                }
                master.addSong(new Song(name,artist,year,length,genre));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return master;
    }

    void displayPlaylists(User playlists, String location) {
        DefaultListModel<String> toDisplay  =  new DefaultListModel<String>();
        ArrayList<Playlist> listOfPlaylists = playlists.getAllPlaylists();
        for (int i = 0; i < listOfPlaylists.size(); i++) {
            toDisplay.addElement(listOfPlaylists.get(i).getPlaylistName());
        }

        if (location.toLowerCase().equals("user")) {
            userPlaylistsDisplay = toDisplay;
        }
        else if (location.toLowerCase().equals("other")) {
            otherUserPlaylistsDisplay = toDisplay;
        }
    }

    void displaySongs(Playlist songs, String location) {
        DefaultListModel<String> toDisplay  =  new DefaultListModel<String>();

        for (int i = 0; i < songs.getSize(); i++) {
            toDisplay.addElement(songs.getSong(i).getName());
        }

        if (location.toLowerCase().equals("user")) {
            userSongsListDisplay = toDisplay;
        }
        else if (location.toLowerCase().equals("other")) {
            otherUserSongsListDisplay = toDisplay;
        }
    }

    void displaySongsWithStats(Playlist songs, String location) {
        DefaultListModel<String> toDisplay  =  new DefaultListModel<String>();

        for (int i = 0; i < songs.getSize(); i++) {
            toDisplay.addElement(
                songs.getSong(i).getName() +
                "  Time: " + songs.getSong(i).getLengthMin() +
                "  Artist: " + songs.getSong(i).getArtist() +
                "  Genre: " + songs.getSong(i).getGenre()
            );
        }

        if (location.toLowerCase().equals("user")) {
            userSongsListDisplay = toDisplay;
        }
        else if (location.toLowerCase().equals("other")) {
            otherUserSongsListDisplay = toDisplay;
        }
    }


    void addSongToUserPlaylist() {
        if (otherSongSelected != -1 && userPlaylistSelected != -1)
        {
            masterUser.getPlaylist(userPlaylistSelected).addSong(otherUserPlaylists.getPlaylist(otherUserPlaylistSelected).getSong(otherSongSelected));
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNewPlaylist = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnSortByName = new javax.swing.JButton();
        btnSortByArtist = new javax.swing.JButton();
        btnSortByGenre = new javax.swing.JButton();
        btnSortByTime = new javax.swing.JButton();
        btnAddToPlaylist = new javax.swing.JButton();
        btnDeletePlaylist = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        listOtherSongs = new javax.swing.JList<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        listOtherPlaylists = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        listMySongs = new javax.swing.JList<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        listUserPlaylists = new javax.swing.JList<>();
        btnDeleteSong = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnNewPlaylist.setText("+");
        btnNewPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewPlaylistActionPerformed(evt);
            }
        });

        jLabel1.setText("My Playlist");
        jLabel1.setToolTipText("");

        btnSortByName.setText("Name");
        btnSortByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortByNameActionPerformed(evt);
            }
        });

        btnSortByArtist.setText("Artist");
        btnSortByArtist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortByArtistActionPerformed(evt);
            }
        });

        btnSortByGenre.setText("Genre");
        btnSortByGenre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortByGenreActionPerformed(evt);
            }
        });

        btnSortByTime.setText("Time");
        btnSortByTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortByTimeActionPerformed(evt);
            }
        });

        btnAddToPlaylist.setText("Add to my Playlist");
        btnAddToPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToPlaylistActionPerformed(evt);
            }
        });

        btnDeletePlaylist.setText("-");
        btnDeletePlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePlaylistActionPerformed(evt);
            }
        });

        btnDeleteSong.setText("Delete Song");
        btnDeleteSong.setToolTipText("");
        btnDeleteSong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSongActionPerformed(evt);
            }
        });

        btnSave.setText("Save User");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        listOtherSongs.setModel(otherUserSongsListDisplay);
        jScrollPane6.setViewportView(listOtherSongs);

        ListSelectionModel otherSongModel;
        otherSongModel = listOtherSongs.getSelectionModel();
        otherSongModel.addListSelectionListener(new OtherSongSelectionHandler());

        listOtherPlaylists.setModel(otherUserPlaylistsDisplay);
        jScrollPane7.setViewportView(listOtherPlaylists);

        ListSelectionModel testModel;
        testModel = listOtherPlaylists.getSelectionModel();
        testModel.addListSelectionListener(new OtherPlaylistSelectionHandler());

        listMySongs.setModel(userSongsListDisplay);
        jScrollPane5.setViewportView(listMySongs);

        listUserPlaylists.setModel(userPlaylistsDisplay);
        jScrollPane8.setViewportView(listUserPlaylists);

        ListSelectionModel userSongModel;
        userSongModel = listUserPlaylists.getSelectionModel();
        userSongModel.addListSelectionListener(new UserPlaylistSelectionHandler());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNewPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeletePlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(55, 55, 55)
                        .addComponent(btnSortByName, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSortByArtist, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSortByGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSortByTime, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(btnSave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDeleteSong)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnAddToPlaylist, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jScrollPane7)
                    .addComponent(jScrollPane6))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(btnSortByName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSortByArtist, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSortByGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSortByTime, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE))
                    .addComponent(jScrollPane8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewPlaylist)
                    .addComponent(btnAddToPlaylist)
                    .addComponent(btnDeletePlaylist)
                    .addComponent(btnDeleteSong)
                    .addComponent(btnSave))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewPlaylistActionPerformed(java.awt.event.ActionEvent evt)
    {//GEN-FIRST:event_btnNewPlaylistActionPerformed
        NewPlaylistDialog nameFrame = new NewPlaylistDialog(this, true);
        nameFrame.setVisible(true);

        String playlistName = nameFrame.getName();

        masterUser.addPlaylist(new Playlist(playlistName));
        displayPlaylists(masterUser, "user");

        listUserPlaylists.setModel(userPlaylistsDisplay);
        jScrollPane8.revalidate();
        jScrollPane8.repaint();
    }//GEN-LAST:event_btnNewPlaylistActionPerformed

    private void btnDeletePlaylistActionPerformed(java.awt.event.ActionEvent evt)
    {//GEN-FIRST:event_btnDeletePlaylistActionPerformed
        masterUser.getAllPlaylists().remove(userPlaylistSelected);

        if (masterUser.getAllPlaylists().isEmpty()) {
            userPlaylistSelected = -1;
        }

        jLabel2.setText("");

        displayPlaylists(masterUser, "user");
        listUserPlaylists.setModel(userPlaylistsDisplay);
        jScrollPane8.revalidate();
        jScrollPane8.repaint();

        displaySongsWithStats(new Playlist(), "user");
        listMySongs.setModel(userSongsListDisplay);
        jScrollPane5.revalidate();
        jScrollPane5.repaint();
    }//GEN-LAST:event_btnDeletePlaylistActionPerformed

    private void btnAddToPlaylistActionPerformed(java.awt.event.ActionEvent evt)
    {//GEN-FIRST:event_btnAddToPlaylistActionPerformed
        addSongToUserPlaylist();
        displaySongsWithStats(masterUser.getPlaylist(userPlaylistSelected),"user");
        listMySongs.setModel(userSongsListDisplay);
        jScrollPane5.revalidate();
        jScrollPane5.repaint();
    }//GEN-LAST:event_btnAddToPlaylistActionPerformed

    private void btnSortByNameActionPerformed(java.awt.event.ActionEvent evt)
    {//GEN-FIRST:event_btnSortByNameActionPerformed
        masterUser.getPlaylist(userPlaylistSelected).sortPlaylist("name");

        displaySongsWithStats(masterUser.getPlaylist(userPlaylistSelected),"user");
        listMySongs.setModel(userSongsListDisplay);
        jScrollPane5.revalidate();
        jScrollPane5.repaint();
    }//GEN-LAST:event_btnSortByNameActionPerformed

    private void btnSortByArtistActionPerformed(java.awt.event.ActionEvent evt)
    {//GEN-FIRST:event_btnSortByArtistActionPerformed
        masterUser.getPlaylist(userPlaylistSelected).sortPlaylist("artist");

        displaySongsWithStats(masterUser.getPlaylist(userPlaylistSelected),"user");
        listMySongs.setModel(userSongsListDisplay);
        jScrollPane5.revalidate();
        jScrollPane5.repaint();
    }//GEN-LAST:event_btnSortByArtistActionPerformed

    private void btnSortByGenreActionPerformed(java.awt.event.ActionEvent evt)
    {//GEN-FIRST:event_btnSortByGenreActionPerformed
        masterUser.getPlaylist(userPlaylistSelected).sortPlaylist("genre");

        displaySongsWithStats(masterUser.getPlaylist(userPlaylistSelected),"user");
        listMySongs.setModel(userSongsListDisplay);
        jScrollPane5.revalidate();
        jScrollPane5.repaint();
    }//GEN-LAST:event_btnSortByGenreActionPerformed

    private void btnSortByTimeActionPerformed(java.awt.event.ActionEvent evt)
    {//GEN-FIRST:event_btnSortByTimeActionPerformed
        masterUser.getPlaylist(userPlaylistSelected).sortPlaylist("time");

        displaySongsWithStats(masterUser.getPlaylist(userPlaylistSelected),"user");
        listMySongs.setModel(userSongsListDisplay);
        jScrollPane5.revalidate();
        jScrollPane5.repaint();
    }//GEN-LAST:event_btnSortByTimeActionPerformed

    private void btnDeleteSongActionPerformed(java.awt.event.ActionEvent evt) 
    {                                              
        System.out.println("Delete Song Button Pressed");   
    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) 
    {                                        
        System.out.println("Save Button Pressed"); 
    }

    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new GUIPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToPlaylist;
    private javax.swing.JButton btnDeletePlaylist;
    private javax.swing.JButton btnNewPlaylist;
    private javax.swing.JButton btnSortByArtist;
    private javax.swing.JButton btnDeleteSong;
    private javax.swing.JButton btnSortByGenre;
    private javax.swing.JButton btnSortByName;
    private javax.swing.JButton btnSortByTime;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JList<String> listMySongs;
    private javax.swing.JList<String> listOtherPlaylists;
    private javax.swing.JList<String> listOtherSongs;
    private javax.swing.JList<String> listUserPlaylists;
    // End of variables declaration//GEN-END:variables

    // LIST LISTENERS
    class OtherPlaylistSelectionHandler implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            ListSelectionModel lsm = (ListSelectionModel)e.getSource();
            int index = lsm.getAnchorSelectionIndex();
            otherUserPlaylistSelected = index;
            displaySongs(otherUserPlaylists.getPlaylist(index),"other");
            listOtherSongs.setModel(otherUserSongsListDisplay);
            jScrollPane6.revalidate();
            jScrollPane6.repaint();
        }
    }

    class UserPlaylistSelectionHandler implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            ListSelectionModel lsm = (ListSelectionModel)e.getSource();
            int index = lsm.getAnchorSelectionIndex();
                userPlaylistSelected = index;
                if (!masterUser.getAllPlaylists().isEmpty() && index != masterUser.getAllPlaylists().size()) {
                    displaySongsWithStats(masterUser.getPlaylist(index),"user");
                    jLabel2.setText(masterUser.getPlaylist(index).name);
                    listMySongs.setModel(userSongsListDisplay);
                    jScrollPane5.revalidate();
                    jScrollPane5.repaint();
                }
        }
    }

    class OtherSongSelectionHandler implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            ListSelectionModel lsm = (ListSelectionModel)e.getSource();
            int index = lsm.getAnchorSelectionIndex();
            otherSongSelected = index;
        }
    }
}