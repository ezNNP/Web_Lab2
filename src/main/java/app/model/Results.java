package app.model;

import app.entities.Point;

import java.util.ArrayList;
import java.util.List;

public class Results {
    private List<Point> points;

    public Results() {
        points = new ArrayList<Point>();
    }

    public void add(Point point) {
        points.add(point);
    }

    public int listSize() {
        return points.size();
    }

    public void clearList() {
        points = new ArrayList<Point>();
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }
}
