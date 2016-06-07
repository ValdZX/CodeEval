package codeeval.other;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RayOfLight {
    public static final char RAY_LEFT = '\\';
    public static final char RAY_RIGHT = '/';
    public static final char X = 'X';
    public static final char WALL = '#';
    public static final char BARRIER = 'o';
    public static final char LENS = '*';
    public static final char SPACE = ' ';
    public static final int sizeX = 10;
    public static final int sizeX_1 = sizeX - 1;
    public static final int sizeY = 10;
    public static final int sizeY_1 = sizeY - 1;


    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            char[][] room = new char[sizeX][sizeY];
            WaySection[][] roomDirections = new WaySection[sizeX][sizeY];
            for (int i = 0; i < sizeX; i++) {
                room[i] = line.substring(i * sizeY, i * sizeY + sizeY).toCharArray();
            }
            Point currentStart = findStart(room);
            if (currentStart == null) {
                continue;
            }

            List<Point> points = new ArrayList<Point>();
            points.add(currentStart);
            while (!points.isEmpty()) {
                int size = points.size();
                for (int i = 0; i < size; i++) {
                    Point currentPoint = points.get(i);
                    WaySection curDir = roomDirections[currentPoint.getX()][currentPoint.getY()];
                    Direction curPointDir = currentPoint.getDirection();
                    if (curDir == null) {
                        roomDirections[currentPoint.getX()][currentPoint.getY()] = new WaySection(curPointDir);
                    } else {
                        if (!roomDirections[currentPoint.getX()][currentPoint.getY()].getDirections().contains(curPointDir)) {
                            roomDirections[currentPoint.getX()][currentPoint.getY()].addDirections(curPointDir);
                        } else {
                            points.remove(i);
                            size--;
                            continue;
                        }
                    }

                    Point nextPoint = getNextPoint(currentPoint);
                    if (nextPoint.getX() < 0 || nextPoint.getX() > sizeX_1 || nextPoint.getY() < 0 || nextPoint.getY() > sizeY_1) {
                        points.remove(i);
                        size--;
                        continue;
                    }
                    char next = room[nextPoint.getX()][nextPoint.getY()];
                    switch (next) {
                        case SPACE:
                            currentPoint.setX(nextPoint.getX());
                            currentPoint.setY(nextPoint.getY());
                            break;
                        case WALL:
                            switch (curPointDir) {
                                case UP_LEFT:
                                    if (nextPoint.getX() == 0 && nextPoint.getY() == 0) {
                                        currentPoint.setDirection(Direction.DOWN_RIGHT);
                                    } else {
                                        if (nextPoint.getX() == 0) {
                                            currentPoint.setY(currentPoint.getY() - 1);
                                            currentPoint.setDirection(Direction.DOWN_LEFT);
                                        } else if (nextPoint.getY() == 0) {
                                            currentPoint.setX(currentPoint.getX() - 1);
                                            currentPoint.setDirection(Direction.UP_RIGHT);
                                        }
                                    }
                                    break;
                                case UP_RIGHT:
                                    if (nextPoint.getX() == 0 && nextPoint.getY() == sizeY_1) {
                                        currentPoint.setDirection(Direction.DOWN_LEFT);
                                    } else {
                                        if (nextPoint.getX() == 0) {
                                            currentPoint.setY(currentPoint.getY() + 1);
                                            currentPoint.setDirection(Direction.DOWN_RIGHT);
                                        } else if (nextPoint.getY() == sizeY_1) {
                                            currentPoint.setX(currentPoint.getX() - 1);
                                            currentPoint.setDirection(Direction.UP_LEFT);
                                        }
                                    }
                                    break;
                                case DOWN_LEFT:
                                    if (nextPoint.getX() == sizeX_1 && nextPoint.getY() == 0) {
                                        currentPoint.setDirection(Direction.UP_RIGHT);
                                    } else {
                                        if (nextPoint.getX() == sizeX_1) {
                                            currentPoint.setY(currentPoint.getY() - 1);
                                            currentPoint.setDirection(Direction.UP_LEFT);
                                        } else if (nextPoint.getY() == 0) {
                                            currentPoint.setX(currentPoint.getX() + 1);
                                            currentPoint.setDirection(Direction.DOWN_RIGHT);
                                        }
                                    }
                                    break;
                                case DOWN_RIGHT:
                                    if (nextPoint.getX() == sizeX_1 && nextPoint.getY() == sizeY_1) {
                                        currentPoint.setDirection(Direction.UP_LEFT);
                                    } else {
                                        if (nextPoint.getX() == sizeX_1) {
                                            currentPoint.setY(currentPoint.getY() + 1);
                                            currentPoint.setDirection(Direction.UP_RIGHT);
                                        } else if (nextPoint.getY() == sizeY_1) {
                                            currentPoint.setX(currentPoint.getX() + 1);
                                            currentPoint.setDirection(Direction.DOWN_LEFT);
                                        }
                                    }

                                    break;
                            }
                            break;
                        case BARRIER:
                            points.remove(i);
                            size--;
                            break;
                        case LENS:
                            points.remove(i);
                            size--;
                            points.add(new Point(nextPoint.getX(), nextPoint.getY(), Direction.DOWN_LEFT));
                            points.add(new Point(nextPoint.getX(), nextPoint.getY(), Direction.DOWN_RIGHT));
                            points.add(new Point(nextPoint.getX(), nextPoint.getY(), Direction.UP_LEFT));
                            points.add(new Point(nextPoint.getX(), nextPoint.getY(), Direction.UP_RIGHT));
                            break;
                    }
                }
            }
            printRoom(room, roomDirections);
        }
    }

    private static Point findStart(char[][] room) {
        //top
        for (int i = 0; i < sizeY; i++) {
            if (room[0][i] == RAY_LEFT) {
                return new Point(0, i, Direction.DOWN_RIGHT);
            } else if (room[0][i] == RAY_RIGHT) {
                return new Point(0, i, Direction.DOWN_LEFT);
            }

        }
        //bottom
        for (int i = 0; i < sizeY; i++) {
            if (room[sizeX_1][i] == RAY_LEFT) {
                return new Point(sizeX_1, i, Direction.UP_LEFT);
            } else if (room[sizeX_1][i] == RAY_RIGHT) {
                return new Point(sizeX_1, i, Direction.UP_RIGHT);
            }
        }
        //left
        for (int i = 0; i < sizeX; i++) {
            if (room[i][0] == RAY_LEFT) {
                return new Point(i, 0, Direction.DOWN_RIGHT);
            } else if (room[i][0] == RAY_RIGHT) {
                return new Point(i, 0, Direction.UP_RIGHT);
            }
        }
        //right
        for (int i = 0; i < sizeX; i++) {
            if (room[i][sizeY_1] == RAY_LEFT) {
                return new Point(i, sizeY_1, Direction.DOWN_LEFT);
            } else if (room[i][sizeY_1] == RAY_RIGHT) {
                return new Point(i, sizeY_1, Direction.UP_LEFT);
            }
        }
        return null;
    }

    public static Point getNextPoint(Point current) {
        int x = current.getX();
        int y = current.getY();

        switch (current.getDirection()) {
            case UP_LEFT:
                return new Point(x - 1, y - 1, current.getDirection());
            case UP_RIGHT:
                return new Point(x - 1, y + 1, current.getDirection());
            case DOWN_LEFT:
                return new Point(x + 1, y - 1, current.getDirection());
            case DOWN_RIGHT:
                return new Point(x + 1, y + 1, current.getDirection());
        }
        return null;
    }

    private static void printRoom(char[][] room, WaySection[][] waySections) {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (waySections[i][j] != null && room[i][j] != LENS) {
                    boolean up_left = waySections[i][j].isUp_left();
                    boolean up_right = waySections[i][j].isUp_right();
                    boolean down_right = waySections[i][j].isDown_right();
                    boolean down_left = waySections[i][j].isDown_left();
                    if (!up_right && !down_left && !up_left && !down_right) {
                        room[i][j] = SPACE;
                    } else if ((up_left || down_right) && !up_right && !down_left) {
                        room[i][j] = RAY_LEFT;
                    } else if ((up_right || down_left) && !up_left && !down_right) {
                        room[i][j] = RAY_RIGHT;
                    } else {
                        room[i][j] = X;
                    }
                }
            }
        }

        for (int i = 0; i < sizeX; i++) {
            String line = String.valueOf(room[i]);
            System.out.println(line);
        }
        System.out.println();
    }

    private static class Point {
        int x;
        int y;
        Direction direction;

        public Point(int x, int y, Direction direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public Direction getDirection() {
            return direction;
        }

        public void setDirection(Direction direction) {
            this.direction = direction;
        }
    }

    private static class WaySection {

        List<Direction> directions = new ArrayList<Direction>();
        boolean up_left = false;
        boolean up_right = false;
        boolean down_left = false;
        boolean down_right = false;

        public WaySection(Direction direction) {
            addDirections(direction);
        }

        public List<Direction> getDirections() {
            return directions;
        }

        public void addDirections(Direction direction) {
            if (!directions.contains(direction)) {
                directions.add(direction);

                switch (direction) {
                    case UP_LEFT:
                        up_left = true;
                        break;
                    case UP_RIGHT:
                        up_right = true;
                        break;
                    case DOWN_LEFT:
                        down_left = true;
                        break;
                    case DOWN_RIGHT:
                        down_right = true;
                        break;
                }
            }
        }

        public boolean isUp_left() {
            return up_left;
        }

        public boolean isUp_right() {
            return up_right;
        }

        public boolean isDown_left() {
            return down_left;
        }

        public boolean isDown_right() {
            return down_right;
        }
    }

    private static enum Direction {
        UP_LEFT,
        UP_RIGHT,
        DOWN_LEFT,
        DOWN_RIGHT;
    }
}
