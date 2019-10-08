let canvas = document.getElementById("canvas");

canvas.addEventListener("mousedown", function(evt) {
    let mousePosition = getMousePosition(canvas, evt);
    let alerts = document.getElementById("alerts");
    if (ord !== 0 && !isNaN(ord)) {
        gl_x = (mousePosition.x - 150) / ord;
        gl_y = (150 - mousePosition.y) / ord;
        drawPoint();
        sendRequest();
        showResult();
        resizeIframe();
        alerts.innerText = "";
    } else {
        alerts.innerText = "Значение R не задано";
    }
});

function getMousePosition(canvas, evt) {
    let rect = canvas.getBoundingClientRect();
    return {
        x: evt.clientX - rect.left,
        y: evt.clientY - rect.top
    }
}

function sendRequest() {
    let http = new XMLHttpRequest();
    let url = "controller";
    let params = "x="+gl_x.toFixed(2)+"&y="+gl_y.toFixed(2)+"&r="+gl_r+"&click=true";
    http.open('POST', url);
    http.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');

    http.onreadystatechange = function() {//Call a function when the state changes.
        if(http.readyState == 4 && http.status == 200) {
            document.getElementById("iframe").contentDocument.open();
            document.getElementById("iframe").contentDocument.write(http.responseText);
            document.getElementById("iframe").contentDocument.close();
        }
    };
    http.send(params);
}