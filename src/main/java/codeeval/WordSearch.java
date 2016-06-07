/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Vald_ZX
 */
public class WordSearch {
    static final char[][] matrix = {
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}
    };
    static final int matL = matrix.length;
    static final int matW = matrix[0].length;

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        Stack<State> stack = new Stack<State>();
        String line;
        while ((line = in.readLine()) != null) {
            Point[] sts = getStarts(line.charAt(0));
            boolean result = false;
            good:
            for (Point point:sts) {
                stack.add(new State(point, 1, new ArrayList<Point>(line.length())));
                nextSteck:
                while (!stack.empty()) {
                    State state = stack.pop();
                    Point current = state.getPoint();
                    List<Point> pointsC = state.way;
                    for (int j = state.getNum(); j < line.length(); j++) {
                        boolean isInProcessing = false;

                        List<Point> nextPoints = new ArrayList<Point>(4);
                        int index = current.getX() - 1;
                        if (index >= 0) {
                            nextPoints.add(new Point(index, current.getY()));
                        }

                        index = current.getX() + 1;
                        if (index < matW) {
                            nextPoints.add(new Point(index, current.getY()));
                        }

                        index = current.getY() - 1;
                        if (index >= 0) {
                            nextPoints.add(new Point(current.getX(), index));
                        }
                        index = current.getY() + 1;
                        if (index < matL) {
                            nextPoints.add(new Point(current.getX(), index));
                        }

                        boolean inGONext = false;
                        for (Point point1 : nextPoints) {
                                if (pointsC.indexOf(point1) == -1) {
                                    if (getCharacter(point1) == line.charAt(j)) {
                                        inGONext = true;
                                        if (j == line.length() - 1) {
                                            result = true;
                                            break good;
                                        }
                                        if (!isInProcessing) {
                                            isInProcessing = true;
                                            pointsC.add(current);
                                            current = point1;
                                        }
                                    }
                            }
                        }
                        if (!inGONext) {
                            break nextSteck;
                        }
                    }
                }
            }
            if (result) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
    }

    public static Point[] getStarts(char c) {
        List<Point> points = new ArrayList<Point>();
        for (int i = 0; i < matrix.length; i++) {
            char[] cs = matrix[i];
            for (int j = 0; j < cs.length; j++) {
                char d = cs[j];
                if (d == c) {
                    points.add(new Point(j, i));
                }
            }
        }
        Point[] result = new Point[points.size()];
        points.toArray(result);
        return result;
    }

    public static char getCharacter(Point p) {
        return matrix[p.getY()][p.getX()];
    }
}
class State {

    private final Point p;
    private final int numSym;
    public List<Point> way;

    public State(Point p, int numSym, List<Point> way) {
        this.p = p;
        this.numSym = numSym;
        this.way = way;
    }

    public Point getPoint() {
        return p;
    }

    public int getNum() {
        return numSym;
    }
}

class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point objP = (Point) obj;
            if (x == objP.getX() && y == objP.getY()) {
                return true;
            }

        }
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return x + " " + y; //To change body of generated methods, choose Tools | Templates.
    }

}