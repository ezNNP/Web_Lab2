function loadCanvas() {
    let canvas = document.getElementById("canvas");
    let context = canvas.getContext("2d");
    context.fillStyle = "#03A9F4"; // цвет для заливки фигур
    context.strokeStyle = "#03A9F4";


    // рисуем фигуры
    context.beginPath();
    context.arc(150, 150, 60, -Math.PI / 2, Math.PI, true); // круг
    context.lineTo(150, 150);
    context.fill();
    context.fillRect(150, 150, 60, -120); // прямоугольник
    context.moveTo(90, 150);
    context.lineTo(150, 270);
    context.lineTo(150, 150);
    context.fill();
    context.closePath();
    context.stroke();

    context.strokeStyle = "#000000";
    context.fillStyle = "#000000";
    // рисуем ось x
    context.beginPath();
    context.moveTo(0, 150);
    context.lineTo(300, 150);
    context.lineTo(295, 145);
    context.moveTo(300, 150);
    context.lineTo(295, 155);

    // рисуем ось y
    context.moveTo(150, 300);
    context.lineTo(150, 0);
    context.lineTo(145, 5);
    context.moveTo(150, 0);
    context.lineTo(155, 5);
    context.closePath();
    context.stroke();

    context.font = "18px Serif";
    context.fillText("x", 290, 140);
    context.fillText("y", 135, 15);
    context.fillText("R", 160, 35);
    context.fillText("R/2", 160, 95);
    context.fillText("-R/2", 160, 214);
    context.fillText("-R", 160, 274);
    context.fillText("-R", 20, 140);
    context.fillText("-R/2", 70, 140);
    context.fillText("R/2", 197, 140);
    context.fillText("R", 265, 140);

    context.beginPath();
    // верхний R по x
    context.moveTo(145, 30);
    context.lineTo(155, 30);

    // верхний R/2 по x
    context.moveTo(145, 90);
    context.lineTo(155, 90);

    // нижний R/2 по x
    context.moveTo(145, 210);
    context.lineTo(155, 210);

    // нижний R по х
    context.moveTo(145, 270);
    context.lineTo(155, 270);

    // левый R по х
    context.moveTo(30, 145);
    context.lineTo(30, 155);

    // левый R/2 по х
    context.moveTo(90, 145);
    context.lineTo(90, 155);

    // правый R/2 по х
    context.moveTo(210, 145);
    context.lineTo(210, 155);

    // правый R по х
    context.moveTo(270, 145);
    context.lineTo(270, 155);
    context.closePath();


    context.stroke();
}

function drawPoint() {
    let canvas = document.getElementById("canvas");
    let context = canvas.getContext("2d");
    context.clearRect(0, 0, 300, 300);
    loadCanvas();
    context.fillStyle = "#FF3333";
    let width = 6;
    let height = 6;
    context.fillRect(150 + gl_x * ord - width/2, 150 - gl_y * ord - height/2, width, height);
}