<%@ page import="app.entities.Point"%>
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
<jsp:useBean id="result" class="app.model.Results" scope="session"/>
<% out.print(result.list()); %>
</body>
</html>
