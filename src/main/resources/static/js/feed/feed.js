var rss_register_button = document.getElementById("rss-url-register-button");
//rss 주소 받아오기

rss_register_button.addEventListener("click", function (e) {
    var xhr = new XMLHttpRequest();
    var rss_url = document.getElementById("rss-url").value;
    var api_key = 'yrtftnwo80oq3xrj3kg70iygtsqdge9d9hqaq2c1';
    // 서버에서 응답이 오면 load 이벤트 발생
    xhr.addEventListener("load", function (ev) {
        // 받은 데이터 가지고 동적 html 만들어서 넣어주기.
        var html = document.querySelector("#latest-news-list").innerHTML;
        // 서버로 부터 받은 데이터 타입은 String, js 의 json 객체로 변환해주어야 한다.
        var jsonobj = JSON.parse(this.responseText);

        var resultHTML = "";
        var items = jsonobj.items;
        for(var i=0; i <items.length; i++){
            resultHTML += html.replace("{title}", items[i].title)
                .replace("{content}", items[i].description)
                .replace("{img}", items[i].thumbnail)
                .replace("{pubDate}", items[i].pubDate)
                .replace("{author}", items[i].author);
        }
        document.querySelector("#camera-list").innerHTML = resultHTML;
    });
    xhr.open("GET", 'https://api.rss2json.com/v1/api.json?rss_url='+ rss_url + '&api_key=' + api_key);
    xhr.send();
}, false);



