<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>User List</title>
</head>
<body>
    <h1>User List</h1>
    <a href="/create">Create New User</a>

    <h1>Create User</h1>
    <form action="<c:url value='/create'/>" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>
        <br/>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
        <br/>
        <input type="submit" value="Create User">
    </form>

<!--     <h1>Edit User</h1> -->
<%--     <form action="<c:url value='/edit'/>" method="get"> --%>
<!--         <label for="userId">User ID:</label> -->
<!--         <input type="text" id="userId" name="userId" required> -->
<!--         <input type="submit" value="Edit User"> -->
<%--     </form> --%>
</body>
</html>
