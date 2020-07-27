<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main page</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jq/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".deluser").click(function(){
			var href = $(this).attr("href");
			$("#delform").attr("action",href).submit();
			return false;
		});
	});
</script>

</head>

<body>
	<form action="${pageContext.request.contextPath}/convertuser" method="post">
		请输入id,username,dptid:<input type="text" name="user"> <!-- id,username,dptid -->
		<input type="submit" value="提交">
	</form>
	
    <form id="delform" action="" method="post">
    	<input type="hidden" name="_method" value="delete">
    </form>
	<table border="1">
		<tr>
			<td>id</td>
			<td>用户名</td>
			<td>部门id</td>
			<td>生日</td>
			<td>身高</td>
			<td>邮箱</td>
			<td>部门名称</td>
			<td>操作</td>
		</tr>

		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.id}</td>
				<td>${user.username}</td>
				<td>${user.dpt.id}</td>
				<td>${user.birthday}</td>
				<td>${user.height}</td>
				<td>${user.email}</td>
				<td>${user.dpt.dptName}</td>
				<td><a
					href="${pageContext.request.contextPath}/user/${user.id}">修改</a>|<a
					class="deluser"
					href="${pageContext.request.contextPath}/user/${user.id}">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}/user">新增</a>

</body>
</html>