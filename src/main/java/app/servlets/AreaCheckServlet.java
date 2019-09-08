package app.servlets;

import app.entities.Point;
import app.model.Results;

import static java.lang.Math.pow;

public class AreaCheckServlet {

    void initPoint(Point point, String x, String y, String r) {
        if (validate(point, x, y, r)) {
            pointIn(point);
        }
    }

    private boolean validate(Point point, String x, String y, String r) {
        try {
            float ix = Float.parseFloat(x);
            float fy = Float.parseFloat(y);
            int ir = Integer.parseInt(r);
            point.setX(ix);
            point.setY(fy);
            point.setR(ir);
            if (ix < -5 || ix > 5 || fy <= -5 || fy >= 3 || ir < 1 || ir > 5) {
                throw new IllegalArgumentException();
            }
            point.setCorrect(true);
            return true;
        } catch (IllegalArgumentException e) {
            point.setCorrect(false);
            return false;
        }
    }

    private boolean pointIn(Point point) {
        float x = point.getX();
        float y = point.getY();
        float r = (float) point.getR();
        point.setResult(true);
        if ((x >= 0) && (y >= 0) && (x <= r / 2) && (y <= r)) {
            return true;
        } else if ((x <= 0) && (y >= 0) && (pow(x, 2) + pow(y, 2) <= pow(r / 2, 2))) {
            return true;
        } else if ((x <= 0) && (y <= 0) && (y >= -2 * x - r)) {
            return true;
        }
        point.setResult(false);
        return false;
    }

    public String resultString() {
        return Results.getInstance().list();
    }
}
