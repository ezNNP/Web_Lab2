<%@ page import="app.servlets.AreaCheckServlet" %>
<%@ page import="app.entities.Point"%>
<%@ page import="app.model.Results" %>
<%--
  Created by IntelliJ IDEA.
  User: grigoriy
  Date: 2019-09-07
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="css/result.css" rel="stylesheet">
</head>
<body>
<%
    try {
        AreaCheckServlet areaCheckServlet = (AreaCheckServlet) request.getAttribute("acs");
        Point point = (Point) request.getAttribute("point");
        long start = (Long) request.getAttribute("start");
        long finish = System.nanoTime();
        point.setWorkingTime((finish - start) / 1000000 + "," + (finish - start) % 1000000 + " мс");
        out.flush();
        out.print(areaCheckServlet.resultString());
        out.close();
    } catch (NullPointerException e) {
        out.flush();
        out.print(Results.getInstance().list());
        out.close();
    }

%>
</body>
</html>
