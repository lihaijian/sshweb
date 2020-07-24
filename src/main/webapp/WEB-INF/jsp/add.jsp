<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add user</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/user" method="post" modelAttribute="user">
		用户名:<form:input path="username"/></br></br>
		生日:<form:input path="birthday" /></br></br>
		部门:<form:select path="dpt.id" items="${dpts}" itemValue="id" itemLabel="dptName"></form:select></br></br>
		<input type="submit" value="新增"/>
	</form:form>
	
	
</body>
</html>