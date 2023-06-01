package main.java;

import main.java.util.Database;

import javax.swing.*;

public class Main {

    public static JFrame window;

    public static void main(String[] args) {

        /*
        Database.uploadMap("resources/maps/worldV1.txt", 0);
        Database.uploadMap("resources/maps/worldV2.txt", 1);
        Database.uploadMap("resources/maps/worldV3.txt", 2);
        */


        Database.retrieveMapsAndCreateFiles();

        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Crop Quest");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        gamePanel.getConfig().loadConfig();

        if (gamePanel.isFullScreenOn()) {
            window.setUndecorated(true);
        }

        window.pack(); // Use the JPanel component to determine window configuration

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.setUpGame();
        gamePanel.startGameThread();
    }
}
