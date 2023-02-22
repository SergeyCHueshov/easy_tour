<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 22.02.2023
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<table>
    <tbody>
    <form action="user/create" method="post">
        <tr>
            <td><label>
                <input type="text" name="name" placeholder="Enter name">
            </label></td>
            <td><label>
                <input type="text" name="surname" placeholder="Enter surname">
            </label></td>
            <td><label>
                <input type="text" name="age" placeholder="Enter age">
            </label></td>
            <td><input type="submit" value="Registration"></td>
        </tr>
    </form>
    </tbody>
</table>
</table>
<table>
    <tbody>
    <form action="${pageContext.request.contextPath}/user/update" method="post">
        <td><label>
            <input type="text" name="name" placeholder="Enter new name">
        </label></td>
        <td><label>
            <input type="text" name="surname" placeholder="Enter new surname">
        </label></td>
        <td><label>
            <input type="text" name="age" placeholder="Enter new age">
        </label></td>
        <tr>
            <td><input type="submit" value="Update"></td>
        </tr>
    </form>
    </tbody>
</table>
<table>
    <tbody>
    <form action="${pageContext.request.contextPath}/user/delete" method="post">
        <tr>
            <td><input type="submit" value="Delete"></td>
        </tr>
    </form>
    </tbody>
</table>
<table>
    <tbody>
    <form action="${pageContext.request.contextPath}/tour/read" method="get">
        <tr>
            <td><input type="submit" value="Read"></td>
        </tr>
    </form>
    </tbody>
</table>
</body>
</html>
