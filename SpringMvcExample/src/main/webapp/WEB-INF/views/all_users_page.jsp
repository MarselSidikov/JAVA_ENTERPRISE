<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Владельцы машин</title>
</head>
<body>
<table>
    <tr>
        <th>Имя</th>
        <th>Возраст</th>
    </tr>
    <c:forEach items="${owners}" var="owner">
        <tr>
            <td>${owner.name}</td>
            <td>${owner.age}</td>
        </tr>
    </c:forEach>
</table>
<form method="post" action="/owners">
    <input type="text" name="name">
    <input type="text" name="age">
    <input type="text" name="color">
    <input type="submit">
</form>
</body>
</html>
