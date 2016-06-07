package codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TheLabyrinth {
    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        List<String> labyrinthRowString = new ArrayList<String>();
        while ((line = in.readLine()) != null) {
            int count = line.length() / 101;
            for (int i = 0; i < count; i ++) {
                labyrinthRowString.add(line.substring(i * 101, (i+1) * 101));
            }
            LabyrinthWorker labyrinthWorker = new LabyrinthWorker(labyrinthRowString);
            labyrinthWorker.doIt();
        }
    }
}


enum Decorations {
    EMPTY,
    WALL,
    WAY
}

class LabyrinthWorker {

    static class Point {
        protected int i;
        protected int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        public int getJ() {
            return j;
        }

        public void setJ(int j) {
            this.j = j;
        }

        @Override
        public int hashCode() {
            return i * 1000000 + j;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Point) {
                Point point = (Point) obj;
                return this.getI() == point.getI() && this.getJ() == point.getJ();
            }
            return super.equals(obj);
        }
    }

    Decorations[][] labyrinthMatrix;
    boolean border = false;
    boolean finisch = false;
    List<List<Point>> ways = new ArrayList<List<Point>>();

    public LabyrinthWorker(List<String> labyrinthRowString) {
        labyrinthMatrix = new Decorations[labyrinthRowString.size()][labyrinthRowString.get(0).length()];
        for (int i = 0; i < labyrinthRowString.size(); i++) {
            String row = labyrinthRowString.get(i);
            for (int j = 0; j < row.length(); j++) {
                if (row.charAt(j) == '*') {
                    labyrinthMatrix[i][j] = Decorations.WALL;
                } else {
                    labyrinthMatrix[i][j] = Decorations.EMPTY;
                }
            }
        }
    }

    public void doIt() {
        Point gate = findGate();
        if (gate == null) {
            return;
        }
        List<Point> currentWay = new ArrayList<Point>();
        searchWay(gate, currentWay);
        if (ways.isEmpty()) {
            return;
        }
        currentWay = getMinimalWay();
        if (currentWay.isEmpty()) {
            return;
        }
        drawWay(currentWay);
        printLabyrinthMatrix(labyrinthMatrix);
    }

    public void printLabyrinthMatrix(Decorations[][] labyrinthMatrix) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Decorations[] decorationses: labyrinthMatrix) {
            for (Decorations decorations : decorationses) {
                switch (decorations) {
                    case EMPTY:
                        stringBuilder.append(' ');
                        break;
                    case WALL:
                        stringBuilder.append('*');
                        break;
                    case WAY:
                        stringBuilder.append('+');
                        break;
                }
            }
            stringBuilder.append('\n');
        }
        System.out.print(stringBuilder.toString());
    }

    public Point findGate() {
        for (int j = 0; j < labyrinthMatrix[0].length; j++) {
            if (labyrinthMatrix[0][j] == Decorations.EMPTY) {
                return new Point(0, j);
            }
        }
        for (int i = 0; i < labyrinthMatrix.length; i++) {
            if (labyrinthMatrix[i][0] == Decorations.EMPTY) {
                return new Point(i, 0);
            }
        }
        int bottom = labyrinthMatrix.length - 1;
        for (int i = 0; i < labyrinthMatrix[bottom].length; i++) {
            if (labyrinthMatrix[bottom][i] == Decorations.EMPTY) {
                return new Point(bottom, i);
            }
        }
        int right = labyrinthMatrix[0].length - 1;
        for (int i = 0; i < labyrinthMatrix.length; i++) {
            if (labyrinthMatrix[i][right] == Decorations.EMPTY) {
                return new Point(i, right);
            }
        }
        return null;
    }

    public void searchWay(Point gate, List<Point> currentWay) {
        if (finisch) {
            ways.add(currentWay);
            finisch = false;
            return;
        }
        currentWay.add(gate);
        if (isWayToTop(gate)) {
            Point pointTop = getPointTop(gate);
            if (!currentWay.contains(pointTop)) {
                searchWay(pointTop, new ArrayList<Point>(currentWay));
            }
        }
        if (isWayToBottom(gate)) {
            Point pointBottom = getPointBottom(gate);
            if (!currentWay.contains(pointBottom)) {
                searchWay(pointBottom, new ArrayList<Point>(currentWay));
            }
        }
        if (isWayToLeft(gate)) {
            Point pointLeft = getPointLeft(gate);
            if (!currentWay.contains(pointLeft)) {
                searchWay(pointLeft, new ArrayList<Point>(currentWay));
            }
        }
        if (isWayToRight(gate)) {
            Point pointRight = getPointRight(gate);
            if (!currentWay.contains(pointRight)) {
                searchWay(pointRight, new ArrayList<Point>(currentWay));
            }
        }
    }

    public Decorations getDecoration(Point point) {
        return labyrinthMatrix[point.getI()][point.getJ()];
    }

    public boolean isWayToLeft(Point gate) {
        if (gate.getJ() - 1 < 0) {
            return isBorder();
        }
        Point point = getPointLeft(gate);
        return getDecoration(point) == Decorations.EMPTY;
    }

    private Point getPointLeft(Point gate) {
        return new Point(gate.getI(), gate.getJ() - 1);
    }

    public boolean isWayToRight(Point gate) {
        if (gate.getJ() + 1 >= labyrinthMatrix[0].length) {
            return isBorder();
        }
        Point point = getPointRight(gate);
        return getDecoration(point) == Decorations.EMPTY;
    }

    private Point getPointRight(Point gate) {
        return new Point(gate.getI(), gate.getJ() + 1);
    }

    public boolean isWayToTop(Point gate) {
        if (gate.getI() - 1 < 0) {
            return isBorder();
        }
        Point point = getPointTop(gate);
        return getDecoration(point) == Decorations.EMPTY;
    }

    private Point getPointTop(Point gate) {
        return new Point(gate.getI() - 1, gate.getJ());
    }

    public boolean isWayToBottom(Point gate) {
        if (gate.getI() + 1 >= labyrinthMatrix.length) {
            return isBorder();
        }
        Point top = getPointBottom(gate);
        return getDecoration(top) == Decorations.EMPTY;
    }

    private Point getPointBottom(Point gate) {
        return new Point(gate.getI() + 1, gate.getJ());
    }

    private boolean isBorder() {
        if (!border) {
            border = true;
            return false;
        } else {
            finisch = true;
            return true;
        }
    }

    private void drawWay(List<Point> currentWay) {
        for (Point point : currentWay) {
            labyrinthMatrix[point.getI()][point.getJ()] = Decorations.WAY;
        }
    }

    public List<Point> getMinimalWay() {
        int min = Integer.MAX_VALUE;
        List<Point> result = new ArrayList<Point>();
        for (List<Point> way : ways) {
            if (way.size() < min) {
                min = way.size();
                result = way;
            }
        }
        return result;
    }
}