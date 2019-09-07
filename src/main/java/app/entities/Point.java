package app.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Point {
    private int x;
    private float y;
    private int r;
    private String creationDateString;
    private long workingTime;
    private boolean result;

    public Point(int x, float y, int r, boolean result, Date startOfWorking) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.result = result;
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        this.creationDateString = simpleDateFormat.format(date);
        this.workingTime = date.getTime() - startOfWorking.getTime();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public String getCreationDateString() {
        return creationDateString;
    }

    public void setCreationDateString(String creationDateString) {
        this.creationDateString = creationDateString;
    }

    public long getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(long workingTime) {
        this.workingTime = workingTime;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (Float.compare(point.x, x) != 0) return false;
        if (Float.compare(point.y, y) != 0) return false;
        if (r != point.r) return false;
        if (workingTime != point.workingTime) return false;
        if (result != point.result) return false;
        return creationDateString.equals(point.creationDateString);
    }

    @Override
    public int hashCode() {
        int result1 = (x != +0.0f ? Float.floatToIntBits(x) : 0);
        result1 = 31 * result1 + (y != +0.0f ? Float.floatToIntBits(y) : 0);
        result1 = 31 * result1 + r;
        result1 = 31 * result1 + creationDateString.hashCode();
        result1 = 31 * result1 + (int) (workingTime ^ (workingTime >>> 32));
        result1 = 31 * result1 + (result ? 1 : 0);
        return result1;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", creationDateString='" + creationDateString + '\'' +
                ", workingTime=" + workingTime +
                ", result=" + result +
                '}';
    }
}
