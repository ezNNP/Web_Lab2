package app.servlets;

import app.entities.Point;
import app.model.Results;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("x") != null && req.getParameter("y") != null && req.getParameter("r") != null) {
            HttpSession session = req.getSession();
            if (session.getAttribute("result") == null) {
                Results result = new Results();
                session.setAttribute("result", result);
            }
            long start = System.nanoTime(); // время начала работы скрипта
            resp.setContentType("text/html");

            Point point = new Point(); // point creation
            try {
                if (req.getParameter("click").equals("true")) {
                    point.setByClick(true);
                } else {
                    point.setByClick(false);
                }
            } catch (NullPointerException e) {
                point.setByClick(false);
            }

            req.setAttribute("point", point);
            req.setAttribute("start", start);

            ServletContext context = getServletContext();
            RequestDispatcher rd = context.getRequestDispatcher("/areacheck");
            rd.forward(req, resp);
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
