function add() {
    var a, b, c, d;
    a = Number(document.getElementById("num1").value);
    b = Number(document.getElementById("num2").value);
    c = a + b;
    document.getElementById("answer").value = c;
}

function sub() {
    var a, b, c;
    a = Number(document.getElementById("num1").value);
    b = Number(document.getElementById("num2").value);
    d = a - b;
    document.getElementById("answers").value = d;
}

function isInputNumber(evt) {

    var ch = String.fromCharCode(evt.which);

    if (!(/[0-9]/.test(ch))) {
        evt.preventDefault();
    }

}