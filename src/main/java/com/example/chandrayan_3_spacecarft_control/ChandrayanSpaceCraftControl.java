package com.example.chandrayan_3_spacecarft_control;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ChandrayanSpaceCraftControl {

    @Getter
    private int x;
    @Getter
    private int y;
    @Getter
    private int z;
    @Getter
    private Direction direction;
    List<Direction> commndsHistory = new ArrayList<>();

    public ChandrayanSpaceCraftControl(int x, int y, int z, Direction direction) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.direction = direction;
        commndsHistory.add(direction);
    }

    public void sendCommands(String[] commands) {
        for (String command : commands) {
            if(!commndsHistory.isEmpty() && commndsHistory.get(commndsHistory.size() -1).equals(Direction.Up) && (command.equals("l") || command.equals("r"))){
                direction = commndsHistory.get(commndsHistory.size() -2);
            }
            sendCommand(command);
            if(!commndsHistory.get(commndsHistory.size() -1).equals(Direction.Up))
                commndsHistory.add(direction);
        }
    }

    private void sendCommand(String command) {
        switch (command) {
            case "f":
                moveForward();
                break;
            case "b":
                moveBackward();
                break;
            case "l":
                turnLeft();
                break;
            case "r":
                turnRight();
                break;
            case "u":
                turnUp();
                break;
            case "d":
                turnDown();
                break;
            default:
                // Ignore invalid commands
                break;
        }
    }

    private void moveForward() {
        switch (direction) {
            case N:
                y++;
                break;
            case S:
                y--;
                break;
            case E:
                x++;
                break;
            case W:
                x--;
                break;
            case Up:
                z++;
                break;
            case Down:
                z--;
                break;
        }
    }

    private void moveBackward() {
        switch (direction) {
            case N:
                y--;
                break;
            case S:
                y++;
                break;
            case E:
                x--;
                break;
            case W:
                x++;
                break;
            case Up:
                z--;
                break;
            case Down:
                z++;
                break;
        }
    }

    private void turnLeft() {
        switch (direction) {
            case N:
                direction = Direction.W;
                break;
            case S:
                direction = Direction.E;
                break;
            case E:
                direction = Direction.N;
                break;
            case W:
                direction = Direction.S;
                break;
            case Up:
            case Down:
                // No change in direction for Up or Down
                break;
        }
    }

    private void turnRight() {
        switch (direction) {
            case N:
                direction = Direction.E;
                break;
            case S:
                direction = Direction.W;
                break;
            case E:
                direction = Direction.S;
                break;
            case W:
                direction = Direction.N;
                break;
        }
    }

    private void turnUp() {
        if (direction != Direction.Up && direction != Direction.Down) {
            direction = Direction.Up;
        }
    }

    private void turnDown() {
        if (direction != Direction.Up && direction != Direction.Down) {
            direction = Direction.Down;
        }
    }


}
