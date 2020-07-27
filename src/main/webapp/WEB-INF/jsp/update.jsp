<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upate user</title>                                                             <!-- modelAttribute与model中的属性值绑定 -->
	<form:form action="${pageContext.request.contextPath}/user/${user.id}" method="put" modelAttribute="user">
		<form:hidden path="id"/>
		用户名:<form:input path="username"/></br></br>
		生日:<form:input path="birthday"/></br></br>
		邮箱:<form:input path="email" /></br></br>
		身高:<form:input path="height" /></br></br>
		部门:<form:select path="dpt.id" items="${dpts}" itemValue="id" itemLabel="dptName"></form:select></br></br>
		<input type="submit" value="修改"/>
	</form:form>
	
</head>
<body>

</body>
</html>