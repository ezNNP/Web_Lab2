<%@ page import="app.entities.Point" %><%--
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
<jsp:useBean id="result" class="app.model.Results" scope="session"/>
<%
    float x = 100, y = 100, r = 1;
    if (result.getPoints().size() > 0) {
        Point last = result.getPoints().get(result.getPoints().size() - 1);
         x = last.getX();
         y = last.getY();
         r = last.getR();
        out.print(result.list());
    }
%>
<script>
    gl_x = <%= x %>;
    gl_y = <%= y %>;
    gl_r = <%= r %>;
    ord = 120 / gl_r;
    parent.drawPoint();
    gl_x = 0;
    gl_y = 0;
    gl_r = 0;
</script>
</body>
</html>
