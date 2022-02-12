package demo;


import jaco.mp3.player.MP3Player;
import jaco.mp3.player.plaf.MP3PlayerUICompact;
import java.awt.Dimension;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class DemoSimpleGUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException {   
        MP3Player player = new MP3Player();
        player.setRepeat(true);
        player.addToPlayList(new File("D:/y2mate.com - Zinidin Zidan Ft Tri Suaka Buih Jadi Permadani Full Album Terbaru 2021.mp3"));

        player.setSize(new Dimension(100,100));
        player.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

        JFrame frame = new JFrame("MP3 Player");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(player);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
}
