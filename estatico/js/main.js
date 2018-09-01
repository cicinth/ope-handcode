function postAjax(url, data, success) {
    var params = typeof data == 'string' ? data : Object.keys(data).map(
            function(k){ return encodeURIComponent(k) + '=' + encodeURIComponent(data[k]) }
        ).join('&');

    var xhr = window.XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject("Microsoft.XMLHTTP");
    xhr.open('POST', url);
    xhr.onreadystatechange = function() {
        if (xhr.readyState>3 && xhr.status==200) { success(xhr.responseText); }
    };
    xhr.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(params);
    return xhr;
}

function getAjax(url, success) {
    var xhr = window.XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject('Microsoft.XMLHTTP');
    xhr.open('GET', url);
    xhr.onreadystatechange = function() {
        if (xhr.readyState>3 && xhr.status==200) success(xhr.responseText);
    };
    xhr.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
    xhr.send();
    return xhr;
}

function loadRandomColors() {
    //cores aleatorias
    var colors = [];  
    colors.push("#2196f3");    //--blue: #2196f3
    colors.push("#39bbb0");    //--teal: #39bbb0
    colors.push("#32c787");    //--green: #32c787
    colors.push("#cddc39");    //--lime: #cddc39
    colors.push("#ffc721");    //--amber: #ffc721
    colors.push("#ff9800");    //--orange: #ff9800
    colors.push("#ff5722");    //--deep-orange: #ff5722
    colors.push("#795548");    //--brown: #795548
    colors.push("#607d8b");    //--blue-grey: #607d8b

    $('.js-random-background-color').each(function( key, value ) {
        var rand = Math.floor(Math.random()*colors.length);    
        $(value).css("background-color", colors[rand]);
    });
}



$( document ).ready(function() {
    loadRandomColors()
});