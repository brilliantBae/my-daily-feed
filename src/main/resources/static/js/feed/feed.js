var rss_register_button = document.getElementById("rss-url-register-button");
//rss 주소 받아오기

rss_register_button.addEventListener("click", function (e) {
    var xhr = new XMLHttpRequest();
    var rss_url = document.getElementById("rss-url").value;
    console.log("hi");
    xhr.open("GET", 'https://api.rss2json.com/v1/api.json?rss_url='+ rss_url + '&api_key=yrtftnwo80oq3xrj3kg70iygtsqdge9d9hqaq2c1');
    xhr.send();
}, false);