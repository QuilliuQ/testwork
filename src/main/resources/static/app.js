let stompClient = null;


function connect() {
    let socket = new SockJS('/websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function () {
        stompClient.subscribe('/arrays', function (arrays) {
            showArrays(JSON.parse(arrays.body).value);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
}

function sendLenght() {
    let value = $("#array_lenght").val()
    if(10 <= value){
        if(value <=100){
        stompClient.send("/set_array_lenght", {}, JSON.stringify({'value': value}));
        }
        else
        {
            alert("Длинна массива должна быть от 10 до 100 чисел")
        }
    }
    else{
        alert("Длинна массива должна быть от 10 до 100 чисел")
    }
}

function showArrays(arrays) {
    for (let item of arrays) {
        let row = '<tr>'
        for(let element of item.value) {
            row += `<td>${element}</td>`
        }
        row += '</tr>'
        $("#arrays").append(row);
    }
}

function autoGenerate(){
    stompClient.send("/enableAuto", {}, JSON.stringify({'value': true}));
    stompClient.send("/auto");
}


function manualGenerate(){
    stompClient.send("/enableAuto", {}, JSON.stringify({'value': false}));
    stompClient.send("/manual");
}

$(function () {
    $( "#send" ).click(function() { sendLenght(); });
    $( "#auto_generate" ).click(function() { autoGenerate(); });
    $( "#manual_generate" ).click(function() { manualGenerate(); });
});
