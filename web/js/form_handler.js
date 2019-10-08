let validX, validY, validR = false;

let gl_x = 0;
let gl_y = 0;
let gl_r = 0;
let ord = 0;

function cl() {
    document.getElementById("Y_input").value = "";
}

function chooseX(x) {
    let buttons = document.getElementById("x_buttons").getElementsByTagName("button");
    for (let o of buttons) {
        o.classList.remove("chosen")
    }

    let button = document.getElementById("x" + x);
    button.classList.add("chosen");
    validX = true;

    let field = document.getElementById("X_input");
    field.value = x;
    gl_x = x;

    enable_button();
}

function chooseR(select) {
    let r = select[select.selectedIndex].value;
    if (r !== 0) {

        validR = true;

        gl_r = r;
        ord = 120 / r;

        document.getElementById("alerts").innerText = "";

        enable_button();
    } else {
        validR = false;
        enable_button();
    }
}

function validateY() {
    let input_field = document.getElementById("Y_input");

    let text = input_field.value;

    let match = text.match(/(^-[0-4]{1}[,]{1}\d{1,7}$)|(^-[1-4]{1}$)|(^[0-2]{1}[,]{1}\d{1,7}$)|(^[0-2]{1}$)/m);

    if (match == null) {
        validY = false;
        input_field.classList.remove("valid_field");
        input_field.classList.add("invalid_field");
    } else {
        validY = true;
        input_field.classList.remove("invalid_field");
        input_field.classList.add("valid_field");
        gl_y = parseFloat(text.replace(",", "."));
    }

    enable_button();
}

function enable_button() {
    document.getElementById("submit").disabled = !(validX && validY && validR);
}