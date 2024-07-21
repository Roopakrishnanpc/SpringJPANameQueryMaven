<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html>
<html>
<head>
    <title>User List</title>
        <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>User List</h1>
    
<a href="<c:url value='/create'/>">Create New User</a>
    <h2>Users</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${users}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.email}</td>
                    <td>
                        <a href="<c:url value='/edit/${item.id}'/>">Edit</a> |
                        <a href="<c:url value='/delete/${item.id}'/>" onclick="return confirm('Are you sure you want to delete this user?');">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <h1>Create User</h1>
    <form action="${pageContext.request.contextPath}/create" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>
        <br/>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
        <br/>
        <input type="submit" value="Create User">
    </form>

    <h1>Edit User by ID</h1>
    <form action="${pageContext.request.contextPath}/user/edit" method="get">
        <label for="userId">User ID:</label>
        <input type="text" id="userId" name="userId" required>
        <input type="submit" value="Edit User">
    </form>
    <h1>Search User by Name</h1>
    <form action="${pageContext.request.contextPath}/findByName">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>
        <input type="submit" value="Search">
    </form>
        <h1>Search User by Email</h1>
    <form action="${pageContext.request.contextPath}/findByEmail">
        <label for="email">Email:</label>
        <input type="text" id="email" name="email" required>
        <input type="submit" value="Search">
    </form>
</body>
</html>
