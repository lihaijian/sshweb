<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsonTest</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jq/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#jsonTest").click(function(){
			var url = this.href;
			var args = {};
			$.post(url,args,function(data){
				for(var i=0;i<data.length;i++){
					var id = data[i].id;
					var username = data[i].username;
					alert("====id:"+id+",username="+username);
				}
			});
			return false;
		});
	});
</script>
</head>
<body>
	<a id="jsonTest" href="${pageContext.request.contextPath}/jsonTest">jsonTest</a>
</body>
</html>