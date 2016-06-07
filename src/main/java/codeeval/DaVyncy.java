package codeeval;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * @author Vald_ZX
 */
public class DaVyncy {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {

            Map<Point, ResultComb> map = new HashMap<Point, ResultComb>();// First point i,j, second coint,
            String[] lines = line.split(";");
            for (int i = 0; i < lines.length; i++) {
                lines[i] = lines[i].replaceAll("([^A-Za-z.' ]+)", "");
                //lines[i] = lines[i].replaceAll("([^A-Za-z. ]+)", "");
                lines[i] = lines[i].replaceAll("  ", " ");
                System.out.println(lines[i]);

            }
            if (lines.length <= 1) {
                return;
            }
            List<String> linesList = new ArrayList<String>(Arrays.asList(lines));
            int inc = 1;
            for (String strI : lines) {
                if (strI.length() == 0) {
                    linesList.remove(strI);
                    continue;
                }
                for (String strJ : lines) {
                    if (strI.contains(strJ)) {
                        linesList.remove(strJ);
                        break;
                    } else if (strJ.contains(strI)) {
                        linesList.remove(strI);
                        break;
                    }
                }
                inc++;
            }


            String[] newLines = new String[linesList.size()];
            linesList.toArray(newLines);

            inc = 1;
            for (int i = 0; i < newLines.length; i++) {
                for (int j = inc; j < newLines.length; j++) {
                    String first = newLines[i];
                    String second = newLines[j];
                    ResultComb rc = new ResultComb(first, second);

                    if (rc.getPower() > 1) {
                        if (rc.getSide()) {
                            rc.setSide(false);
                            if (rc.getPower() != first.length())
                                map.put(new Point(j, i), rc);
                        } else {
                            if (rc.getPower() != second.length())
                                map.put(new Point(i, j), rc);
                        }
                    }
                }
                inc++;
            }
            List<Point> fromDelete = new ArrayList<Point>();
            Point[] points = new Point[map.keySet().size()];
            map.keySet().toArray(points);

            inc = 1;
            for (Point pointI : points) {
                for (Point pointJ : points) {
                    if (pointI.x == pointJ.x) {
                        ResultComb rcI = map.get(pointI);
                        ResultComb rcJ = map.get(pointJ);

                        if ((newLines[pointI.y].length() - rcI.getPower()) > (newLines[pointJ.y].length() - rcJ.getPower())) {
                            fromDelete.add(pointJ);
                        } else {
                            fromDelete.add(pointI);
                        }
                    }
                }
                inc++;
            }
            for (Point point : fromDelete) {
                map.remove(point);
            }
            //find first
            //Point first = findFirst(map);
            Point first = findFirst(map);
            if (first == null) {
                return;
            }
            //Connect
            String result = newLines[first.x];
            while (first != null) {
                ResultComb rc = map.get(first);

                try {
                    result += newLines[first.y].substring(newLines[first.x].length() - rc.getIndex());
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                int findin = first.y;
                map.remove(first);
                first = findPoint(map, findin);

            }
            System.out.println(result);
            System.out.println(line);
        }
    }

    private static Point findPoint(Map<Point, ResultComb> map, int findin) {
        for (Point p1 : map.keySet()) {
            if (p1.x == findin)
                return p1;
        }
        return null;
    }

    private static Point findFirst(Map<Point, ResultComb> map) {
        boolean flag = false;
        Point p = null;
        for (Point p1 : map.keySet()) {
            p = p1;
            for (Point p2 : map.keySet()) {
                if (p1.equals(p2)) {
                    continue;
                }

                if (p1.x == p2.y) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                flag = false;
            } else {
                break;
            }
        }


        return p;
    }

    private static class ResultComb {
        private int power;
        private int index;
        private boolean side;//false = B, true = L

        public ResultComb(int power, int index, boolean side) {
            this.power = power;
            this.index = index;
            this.side = side;
        }

        public ResultComb(String first, String second) {
            ResultComb B = beginCombine(first, second);
            B.setSide(false);
            ResultComb L = beginCombine(second, first);
            L.setSide(true);

            if (B.getPower() > L.getPower()) {
                this.power = B.getPower();
                this.index = B.getIndex();
                this.side = B.getSide();
            } else {
                this.power = L.getPower();
                this.index = L.getIndex();
                this.side = L.getSide();
            }
        }

        public ResultComb beginCombine(String first, String second) {
            //find begin            
            int powerB = 0;
            int indexB = 0;
            int temp;
            int memTemp = 0;
            int incSecond = 0;
            all:
            while (true) {
                String subStr = first.substring(memTemp);
                temp = subStr.indexOf(second.charAt(0));
                if (temp == -1) {
                    break all;
                }
                indexB = memTemp + temp;
                for (int i = temp; i < subStr.length(); i++, incSecond++) {
                    if (subStr.charAt(i) == second.charAt(incSecond)) {
                        temp++;
                        if (i == subStr.length() - 1 || incSecond == second.length() - 1) {
                            powerB = incSecond + 1;
                            break all;
                        }
                    } else {
                        memTemp += temp;
                        incSecond = 0;
                        powerB = 0;
                        indexB = 0;
                        break;
                    }
                }

            }
            if (indexB < first.length()) {
                this.index = indexB;
                this.power = powerB;
            } else {
                System.out.println("Way");
            }
            return new ResultComb(powerB, indexB, false);
        }

        public int getPower() {
            return this.power;
        }

        public boolean getSide() {
            return this.side;
        }

        public void setSide(boolean side) {
            this.side = side;
        }

        public int getIndex() {
            return this.index;
        }
    }
}
