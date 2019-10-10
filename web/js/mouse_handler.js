let canvas = document.getElementById("canvas");

canvas.addEventListener("mousedown", function(evt) {
    let mousePosition = getMousePosition(canvas, evt);
    let alerts = document.getElementById("alerts");
    if (ord !== 0 && !isNaN(ord)) {
        gl_x = (mousePosition.x - 150) / ord;
        gl_y = (150 - mousePosition.y) / ord;
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
    let x = document.getElementById("hiddenX");
    let y = document.getElementById("hiddenY");
    let r = document.getElementById("hiddenR");
    x.value = gl_x.toFixed(2);
    y.value = gl_y.toFixed(2);
    r.value = gl_r;

    let form = document.getElementById("hidden_form");
    form.submit();
}