<%@ page pageEncoding="UTF-8"%>
<html>
	<head>
		<script>
			function testDate(){
				var now = new Date(2016,5,13);
				console.log(now.getDay());
			}
			testDate();
			var a = typeof "a";
			var b = typeof new String("a");
			console.log(a);
			console.log(b);
			console.log(b==a);
			var c = "a";
			var d = new String("a");
			var e="a";
			console.log(d==c);
			console.log(d===c);
			console.log(e===c);
			
			//类型转换
			console.log("类型转换："+("0"==false)); 
			console.log("undefined==false:"+(undefined==false));
			console.log("[]-->string:"+String([]));
			console.log("[9,3]-->string:"+String([9,3]));
			console.log("Object(null):"+Object(null));
			
			//字符串转数字
			console.log("NaN:"+(-"1"));
			console.log("NaN:"+(-"a"));
			
			//此处判断的是索引处是否有值。
			var data=[7,8,9];
			console.log("0" in data);
			console.log(1 in data);
			console.log(2 in data);
			console.log(3 in data);
		</script>
	</head>
</html>