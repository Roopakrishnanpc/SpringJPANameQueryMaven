<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
    <h1>Edit User</h1>
    <form:form method="post" action="${pageContext.request.contextPath}/edit" modelAttribute="user">
        <form:hidden path="id" />
        <p>
            <label for="name">Name:</label>
            <form:input path="name" type="text" id="name"/>
        </p>
        <p>
            <label for="email">Email:</label>
            <form:input path="email" type="email" id="email"/>
        </p>
        <p>
            <input type="submit" value="Update"/>
        </p>
    </form:form>
</body>
</html>
