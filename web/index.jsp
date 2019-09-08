<%@ page import="app.model.Results" %><%--
  Created by IntelliJ IDEA.
  User: grigoriy
  Date: 2019-09-06
  Time: 00:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  try {
    int i = Integer.parseInt(request.getParameter("ref"));
    if (i == 1) {
      Results.getInstance().clearList();
      response.sendRedirect("index.jsp");
    } else {
      throw new Exception();
    }
  } catch (Exception e) {}

  // create flag to understand if it is a click request or not
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
</head>
<body onload="cl(); loadCanvas(); validateCounter(<% out.print(Results.getInstance().listSize() + 2); %>); resizeIframe()">
<!-- Шапка -->
<div class="content">
  <div class="header block">
    <h1>Жаворонков Григорий Игоревич</h1>
    <h3>Группа: P3202</h3>
    <h3>Вариант: 202008</h3>
  </div>
  <div class="container block">
    <p>Введите X, Y, R в полях ниже и узнайте, попала ли точка в фигуру, сгенерированную генератором генерируемых вариантов</p>
    <form id="form" action="controller" method="post" target="result">
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
        <span id="r_buttons">
          <button id="r1" type="button" onclick="chooseR(1)">1</button>
          <button id="r2" type="button" onclick="chooseR(2)">2</button>
          <button id="r3" type="button" onclick="chooseR(3)">3</button>
          <button id="r4" type="button" onclick="chooseR(4)">4</button>
          <button id="r5" type="button" onclick="chooseR(5)">5</button>
        </span>
        <input id="R_input" name="r" class="hidden">
      </div>
      <button type="submit" id="submit" disabled onclick="drawPoint(); showResult(); resizeIframe()">Чекнуть</button>
    </form>
    <canvas width="300" height="300" id="canvas"></canvas>
  </div>
  <div id="result" class="block <% if (Results.getInstance().listSize() == 0) { out.print("hidden"); }%>">
  <iframe src="result.jsp" name="result" frameBorder="0" seamless scrolling="no" id="iframe"></iframe>
  <a href="index.jsp?ref=1">Начать заново</a>
</div>
</div>
<script type="text/javascript" src="js/mouse_handler.js"></script>
</body>
</html>
