package com.sample.interview.chutesladders;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ChutesAndLadders {
    private static Map<Player, Integer> players = new HashMap<>();
    private static Map<Integer, Integer> chutesMap = new HashMap<>();
    private static Map<Integer, Integer> laddersMap = new HashMap<>();

    public static void main(String[] args) {
        // Setup the players
        initPlayers();

        // Initialize chutes information
        initLadders();

        // Initialize ladders information
        initChutes();

        // Start game
        startGame();
    }

    // Initialize laddersMap with ladder information
    public static void initLadders() {
        laddersMap.put(1, 38);
        laddersMap.put(4, 14);
        laddersMap.put(9, 31);
        laddersMap.put(21, 42);
        laddersMap.put(28, 84);
        laddersMap.put(36, 44);
        laddersMap.put(51, 67);
        laddersMap.put(71, 91);
        laddersMap.put(80, 100);
    }

    // Initialize chutesMap with chute information
    public static void initChutes() {
        chutesMap.put(98, 78);
        chutesMap.put(95, 75);
        chutesMap.put(93, 73);
        chutesMap.put(87, 24);
        chutesMap.put(64, 60);
        chutesMap.put(62, 19);
        chutesMap.put(56, 53);
        chutesMap.put(49, 11);
        chutesMap.put(47, 26);
        chutesMap.put(16, 6);
    }

    public static void initPlayers(){
        // Load player configuration information from properties file
        InputStream is = ClassLoader.getSystemResourceAsStream("players.properties");

        if(is == null) {
            // Load default player information when no configuration is found
            System.out.println("Player config file is not found! Default players will be created.");
            players.put(new Player(1, "Player 1"), 0);
            players.put(new Player(2, "Player 2"), 0);

        } else {
            // Load player details from properties file
            Properties properties = new Properties();

            try {
                properties.load(is);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Save the players information into players
            Set<Map.Entry<Object, Object>> entries = properties.entrySet();
            for (Map.Entry<Object, Object> e : entries) {
                int id = Integer.parseInt(e.getKey().toString());
                String name = e.getValue().toString();
                players.put(new Player(id, name), 0);
            }
        }

//        players.forEach(
//                (k, v) -> System.out.println(k.getName() + " -> " + v)
//        );
    }

    public static void startGame() {
        boolean gameIsOver = false;

        int step = 1;
        while(!gameIsOver) {
            for (Map.Entry<Player, Integer> e : players.entrySet()) {
                Player currentPlayer = e.getKey();
                int currentPosition = e.getValue();

                System.out.print(step++ + ": ");
                int newPosition = currentPlayer.move(
                    currentPosition,
                    chutesMap,
                    laddersMap
                );
                e.setValue(newPosition);

                // Check if there is a winner
                if (newPosition == 100) {
                    gameIsOver = true;
                    System.out.println("The winner is " + currentPlayer.getName() + "!");
                    break;
                }
            }
        }
    }
}
