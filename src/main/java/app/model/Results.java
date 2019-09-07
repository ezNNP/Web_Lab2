package app.model;

import app.entities.Point;

import java.util.ArrayList;
import java.util.List;

public class Results {
    private static Results instance = new Results();
    private List<Point> points;

    public static Results getInstance() {
        return instance;
    }

    private Results() {
        points = new ArrayList<Point>();
    }

    public void add(Point point) {
        points.add(point);
    }

    public String list() {
        String res = "";

        // create <table>content</table> string and return it

        return res;
    }

}
