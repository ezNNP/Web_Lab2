package app.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Point implements Serializable {
    private int x;
    private float y;
    private int r;
    private String creationDateString; // дата создания точки
    private String workingTime; // время работы
    private boolean result; // реузльтат | true - точка попала в область | false - не попала
    private boolean correct; // корректно ли были заданы значения для точки

    public Point() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        this.creationDateString = simpleDateFormat.format(date);
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

    public String getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(String workingTime) {
        this.workingTime = workingTime;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        if (Float.compare(point.y, y) != 0) return false;
        if (r != point.r) return false;
        if (!workingTime.equals(point.workingTime)) return false;
        if (result != point.result) return false;
        if (correct != point.correct) return false;
        return creationDateString.equals(point.creationDateString);
    }

    @Override
    public int hashCode() {
        int result1 = x;
        result1 = 31 * result1 + (y != +0.0f ? Float.floatToIntBits(y) : 0);
        result1 = 31 * result1 + r;
        result1 = 31 * result1 + creationDateString.hashCode();
        result1 = 31 * result1 + workingTime.hashCode();
        result1 = 31 * result1 + (result ? 1 : 0);
        result1 = 31 * result1 + (correct ? 1 : 0);
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
                ", correct=" + correct +
                '}';
    }
}
