var xmlHttpRequest;


function createXMLHttpRequest()
{
    if (window.XMLHttpRequest) //非IE浏览器
    {
        xmlHttpRequest = new XMLHttpRequest();
    }
    else if (window.ActiveObject)
    {
        xmlHttpRequest = new ActiveObject("Msxml2.XMLHTTP");
    }
    else
    {
        xmlHttpRequest = new ActiveObject("Microsoft.XMLHTTP");
    }
}

function showInform(categoryId,event) {

    console.log(categoryId);
    sendRequest("categoryShowJsServlet?categoryId=" + categoryId);
    var ev=event;
    var inform = document.getElementById("inform");
    inform.style.display = "block";
    inform.style.left=ev.clientX+"px";
    inform.style.top=ev.clientY+"px";
    // inform.style.left=(ev.clientX-this.offsetLeft+20)+"px";
    // inform.style.top=(ev.clientY-this.offsetTop-20)+"px";

    console.log(inform.style.left);
    //sendRequest("categoryShowJsServlet");
}

function sendRequest(url) {
    createXMLHttpRequest();
    xmlHttpRequest.open("GET",url, true);
    xmlHttpRequest.onreadystatechange = processResponse;
    xmlHttpRequest.send(null);
}

function processResponse() {
    if (xmlHttpRequest.readyState == 4) {
        if (xmlHttpRequest.status == 200) {
            var resp = xmlHttpRequest.responseText;
            //显示悬浮层
            var inform = document.getElementById("inform");
            inform.innerText = resp;
            inform.style.display = "block";


        }
    }
}

//隐藏悬浮层
function hiddenInform(event){
    var informDiv = document.getElementById('inform');
    var x=event.clientX;
    var y=event.clientY;
    var divx1 = informDiv.offsetLeft;
    var divy1 = informDiv.offsetTop;
    var divx2 = informDiv.offsetLeft + informDiv.offsetWidth;
    var divy2 = informDiv.offsetTop + informDiv.offsetHeight;
    if( x < divx1 || x > divx2 || y < divy1 || y > divy2){
        document.getElementById('inform').style.display='none';
    }
}
