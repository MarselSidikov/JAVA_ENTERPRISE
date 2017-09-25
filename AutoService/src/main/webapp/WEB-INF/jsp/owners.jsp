<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ page import="ru.itis.models.Human" %>--%>
<%--<%@ page import="java.util.ArrayList" %>--%>

<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 25.09.2017
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
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
    <%--<%--%>
        <%--ArrayList<Human> owners = (ArrayList<Human>) request.getAttribute("owners");--%>
        <%--for (Human owner : owners) {--%>
    <%--%>--%>
    <%--<tr>--%>
        <%--<td><%=owner.getName()%></td>--%>
        <%--<td><%=owner.getAge()%></td>--%>
    <%--</tr>--%>
    <%--<%}%>--%>
    <c:forEach items="${owners}" var="owner">
        <tr>
            <td>${owner.name}</td>
            <td>${owner.age}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
