<%@ page import="app.entities.Point" %><%--
  Created by IntelliJ IDEA.
  User: grigoriy
  Date: 2019-09-07
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="result" class="app.model.Results" scope="session"/>
<html>
<head>
    <title></title>
    <link href="css/result.css" rel="stylesheet">
</head>
<body>
<table>
    <tr>
        <th>X</th>
        <th>Y</th>
        <th>R</th>
        <th>Начало работы</th>
        <th>Время работы</th>
        <th>Реузльтат</th>
    </tr>
    <%
    Point current;
    for (int i = result.listSize() - 1; i >= 0; i--) {
        current = result.getPoints().get(i);
        float x = current.getX();
        float y = current.getY();
        float r = current.getR();
        String workingTime = current.getWorkingTime();
        String creationString = current.getCreationDateString();
        String in = current.isResult() ? "Попала" : "Не попала";

        if (current.isCorrect()) {%>
    <tr>
        <td><%= x %></td>
        <td><%= y %></td>
        <td><%= r %></td>
        <td><%= creationString %></td>
        <td><%= workingTime %></td>
        <td><%= in %></td>
    </tr>
        <% } else { %>
    <tr><td colspan='6'><b>Неверные аргументы</b></td></tr>
        <% }
        }
        %>
</table>
<script>
    parent.drawPoint();
</script>
</body>
</html>
