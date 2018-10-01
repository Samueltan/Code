package com.sample.interview.chutesladders;

import java.util.Map;

public class Player {
    int id;
    String name;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int move(
        int currentPosition,
        Map<Integer, Integer> chutesMap,
        Map<Integer, Integer> laddersMap
    )
    {
        int nextMove = Dice.go();
        int newPosition = currentPosition + nextMove;
        if (newPosition > 100) {
            System.out.println(name + ": \tLast move exceeded 100, stay still!");
            return currentPosition;
        }
        String moveString = name + ": \t" + currentPosition + " --> " + newPosition;

        Integer possibleChute = chutesMap.get(newPosition);
        if (possibleChute == null) {
            Integer possibleLadder = laddersMap.get(newPosition);
            if (possibleLadder == null) {
                System.out.println(moveString);
            } else {
                newPosition = possibleLadder;
                System.out.println(moveString + " --LADDER--> " + newPosition);
            }
        } else {
            newPosition = possibleChute;
            System.out.println(moveString + " --CHUTE--> " + newPosition);
        }

        return newPosition;
    }
}
