package com.sample.interview.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class RobotMoveTest {
    public static void main(String[] args) {
        Robot robot = new Robot(0, 0, 0);
        String path = "FRFRFRF";

        char[] ca = path.toCharArray();
        Map<Character, Consumer<Robot>> map = new HashMap<>();
        map.put('F', r -> r.F());
        map.put('L', r -> r.L());
        map.put('R', r -> r.R());

        for(int i=0; i<ca.length; i++) {
            char c = ca[i];
            map.get(c).accept(robot);
        }

        boolean res = (robot.getX() == 0 && robot.getY() == 0);
        System.out.println(res);
    }
}

class Robot {
    int x;
    int y;
    // 0: N, 1: E, 2: S, 3: W
    int direction;

    public Robot(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void F() {
        switch (direction) {
            case 0: { y++; break;}
            case 1: { x++; break;}
            case 2: { y--; break;}
            case 3: { x--; break;}
            default: break;
        }
    }

    public void L() {
        direction = (direction == 0) ? 3 : direction - 1;
    }

    public void R() {
        direction = (direction == 3) ? 0 : direction + 1;
    }
}
