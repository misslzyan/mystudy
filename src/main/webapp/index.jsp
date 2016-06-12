<html>
<head>
     <style type="text/css">

         .hilite{
             background-color: blueviolet;
         }
     </style>

    <script>

        console.log(1/2);
        function mavon(){
            var answer = confirm("are you ready?");
            if(answer){
                alert("yes");
            }else{
                alert("no");
            }
        }
//        mavon();

        function debug(msg){
            var log = document.getElementById("debuglog");
            if(!log){
                log = document.createElement("div");
                log.id = "debuglog";
                log.innerHTML="<h1>debug log </h1>";
                console.log(document);
                console.log(document.body);
               document.body.appendChild(log);
            }
            var pre = document.createElement("pre");
            var text = document.createTextNode(msg);
            pre.appendChild(text);
            log.appendChild(pre);
        }

        function hide(e,reflow){
            if(reflow){
                e.style.display="none";
            }else{
                e.style.visibility="hidden";
            }
        }

        function ddd(){
            var reflow = confirm("reflow?");
            hide(document.getElementById("h"),reflow);
        }

        function hilite(e){
            if(!e.className){
                e.className="hilite";
            }else{
                e.className+="hilite";
            }
        }
    </script>
</head>
<body>
<h2>Hello World!</h2>
<input id="h" value = "hhaha"/>
<input value="wowowo"/>
<input id="button" type="button" value="dan" onclick="ddd()"/>
<input id="button2" type="button" value="hilite" onclick="hilite(this)"/>
<script>

    debug("test dwd");
</script>
</body>
</html>
