package app.servlets;

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
        super.doGet(req, resp);
    }
}
