package app.servlets;

import app.entities.Point;
import app.model.Results;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static java.lang.Math.pow;

public class AreaCheckServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Point point = (Point)req.getAttribute("point");

        initPoint(point, req.getParameter("x"), req.getParameter("y").replace(',', '.'), req.getParameter("r"));

        HttpSession session = req.getSession();
        long start = (Long) req.getAttribute("start");
        Results result = (Results)session.getAttribute("result");
        long finish = System.nanoTime();
        point.setWorkingTime((finish - start) / 1000000 + "," + (finish - start) % 1000000 + " мс");

        result.add(point);

        RequestDispatcher rd = req.getRequestDispatcher("result.jsp");
        rd.forward(req, resp);
    }

    private void initPoint(Point point, String x, String y, String r) {
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
            if (point.isByClick() && ir >= 1 && ir <= 5) { // if point is setted by click then we won't check that for x and y parameters
                point.setCorrect(true);
                return true;
            } else if (point.isByClick()) {
                point.setCorrect(false);
                return false;
            }
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
}
