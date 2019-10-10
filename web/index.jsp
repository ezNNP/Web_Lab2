<%@ page import="app.entities.Point" %><%--
  Created by IntelliJ IDEA.
  User: grigoriy
  Date: 2019-09-06
  Time: 00:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="result" class="app.model.Results" scope="session"/>
<%
  int listSize = result.listSize();
  float x = 100, y = 100, r = 1;
  try {
    if (result.getPoints().size() > 0) {
      Point last = result.getPoints().get(result.getPoints().size() - 1);
      x = last.getX();
      y = last.getY();
      r = last.getR();
    }
    int i = Integer.parseInt(request.getParameter("ref"));
    if (i == 1) {
      result.clearList();
      response.sendRedirect("index.jsp");
    } else {
      throw new Exception();
    }
  } catch (Exception e) {}
%>
<html lang="ru">
<head>
  <meta charset="UTF-8">
  <title>Лаба 2</title>
  <!-- Подключение css -->
  <link href="css/style.css" rel="stylesheet">
  <link href="css/result.css" rel="stylesheet">
  <!-- Подключение JS -->
  <script type="text/javascript" src="js/form_handler.js"></script>
  <script type="text/javascript" src="js/result_shower.js"></script>
  <script type="text/javascript" src="js/canvas_drawer.js"></script>
  <script>
    function drawLastPoint() {
      gl_x = <%= x %>;
      gl_y = <%= y %>;
      gl_r = <%= r %>;
      ord = 120 / gl_r;
      drawPoint();
    }
  </script>
</head>
<body onload="cl(); loadCanvas(); validateCounter(<% out.print(listSize + 2); %>); resizeIframe(); drawLastPoint()">
<!-- Шапка -->
<div class="content">
  <div class="header block">
    <h1>Жаворонков Григорий Игоревич</h1>
    <h3>Группа: P3202</h3>
    <h3>Вариант: 20214</h3>
  </div>
  <div class="container block">
    <p>Введите X, Y, R в полях ниже и узнайте, попала ли точка в фигуру, сгенерированную генератором генерируемых вариантов</p>
    <form id="hidden_form" action="controller" method="get" target="result" style="display: none; height: 0; width: 0">
      <input name="x" id="hiddenX">
      <input name="y" id="hiddenY">
      <input name="r" id="hiddenR">
      <input name="click" value="true">
    </form>
    <form id="form" action="controller" method="get" target="result">
      <div id="X" class="prop">
        <span class="property">X</span>
        <span id="x_buttons">
          <button id="x-4" type="button" onclick="chooseX(-4)">-4</button>
          <button id="x-3" type="button" onclick="chooseX(-3)">-3</button>
          <button id="x-2" type="button" onclick="chooseX(-2)">-2</button>
          <button id="x-1" type="button" onclick="chooseX(-1)">-1</button>
          <button id="x0" type="button" onclick="chooseX(0)">0</button>
          <button id="x1" type="button" onclick="chooseX(1)">1</button>
          <button id="x2" type="button" onclick="chooseX(2)">2</button>
          <button id="x3" type="button" onclick="chooseX(3)">3</button>
          <button id="x4" type="button" onclick="chooseX(4)">4</button>
        </span>
        <input id="X_input" name="x" class="hidden">
      </div>
      <div id="Y" class="prop">
        <span class="property">Y</span>
        <input id="Y_input" oninput="validateY()" name="y" placeholder="(-5 ... 3)" autocomplete="off">
      </div>
      <div id="R" class="prop">
        <span class="property">R</span>
        <select name="r" id="r_select" onchange="chooseR(this)">
          <option value="0"></option>
          <option value="1">1</option>
          <option value="1.5">1.5</option>
          <option value="2">2</option>
          <option value="2.5">2.5</option>
          <option value="3">3</option>
        </select>
      </div>
      <button type="submit" id="submit" disabled onclick="showResult(); resizeIframe()">Чекнуть</button>
    </form>
    <canvas width="300" height="300" id="canvas"></canvas>
    <p id="alerts"></p>
  </div>
  <div id="result" class="block <% if (listSize == 0) { out.print("hidden"); }%>">
  <iframe src="result.jsp" name="result" frameBorder="0" seamless  id="iframe"></iframe>
  <a href="index.jsp?ref=1">Начать заново</a>
</div>
</div>
<script type="text/javascript" src="js/mouse_handler.js"></script>
</body>
</html>
