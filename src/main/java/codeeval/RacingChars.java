package codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RacingChars {
    enum Direction {
        STRAIGHT('|'),
        RIGHT('\\'),
        LEFT('/');
        char value;

        Direction(char value) {
            this.value = value;
        }

        public char getValue() {
            return value;
        }
    }

    int position = -1;

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        RacingChars racingChars = new RacingChars();
        while ((line = in.readLine()) != null) {
            racingChars.run(line);
        }
    }

    public void run(String line) {
        int nextPos = getWay(line, position);
        if (position != -1) {
            Direction direction = getDirection(position, nextPos);
            drawLine(line, nextPos, direction);
        } else {
            drawLine(line, nextPos, Direction.STRAIGHT);
        }
        position = nextPos;
    }

    private int getWay(String line, int previousPosition) {
        int gate = line.indexOf("C");
        int under = line.indexOf("_");
        if (previousPosition == -1) {
            if (gate != -1) {
                return gate;
            }
            if (under != -1) {
                return under;
            }
        }
        int dist = previousPosition - gate;
        if (dist <= 1 && dist >= -1) {
            return gate;
        }
        dist = previousPosition - under;
        if (dist <= 1 && dist >= -1) {
            return under;
        }
        return -1;
    }

    private void drawLine(String line, int position, Direction direction) {
        StringBuilder builder = new StringBuilder(line);
        if(position >= 0) {
            builder.setCharAt(position, direction.getValue());
        }
        System.out.println(builder.toString());
    }

    private Direction getDirection(int position, int nextPos){
        if(position > nextPos){
            return Direction.LEFT;
        } else if (position < nextPos){
            return Direction.RIGHT;
        } else {
            return Direction.STRAIGHT;
        }
    }
}