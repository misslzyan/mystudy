window.onload=function(){
    var divs = document.getElementsByTagName("div");//找出所有的div标签

    for(var i = 0;i<divs.length;i++){
        var div = divs[i];

        if(div.addEventListener){
            div.addEventListener("click",hide,false);
        }else{
            div.attachEvent("onclick",hide);
        }
    }

    function hide(event){
        event.target.style.visibility="hidden";
    }
}