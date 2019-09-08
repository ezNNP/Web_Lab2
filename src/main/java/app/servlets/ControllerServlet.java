package app.servlets;

import app.entities.Point;
import app.model.Results;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // validation of x, y, r
        // create date of start (for working time)
        // if everything is correct then go to area check servlet
        // else add to model that arguments are wrong
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long start = System.nanoTime(); // время начала работы скрипта
        resp.setContentType("text/html");
        if (req.getParameter("r") == null) {
            // r is not valid
        }

        AreaCheckServlet areaCheckServlet = new AreaCheckServlet();
        Point point = new Point(); // point creation
        areaCheckServlet.initPoint(point, req.getParameter("x"), req.getParameter("y").replace(',', '.'), req.getParameter("r"));
        Results.getInstance().add(point);

        req.setAttribute("acs", areaCheckServlet);
        req.setAttribute("point", point);
        req.setAttribute("start", start);

        RequestDispatcher rd = req.getRequestDispatcher("result.jsp");
        rd.forward(req, resp);
    }
}
