<%--
  Created by IntelliJ IDEA.
  User: Welcome
  Date: 12/16/2022
  Time: 11:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Saving config email</title>
</head>
<body>
<%--style="border: 1px solid chartreuse; border-collapse: collapse; border--%>
<table border="1">
    <h4>${mess}</h4>
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>Languages</th>
        <th>PageSize</th>
        <th>Signature</th>
    </tr>

    <c:forEach var="config" items="${configList}" varStatus="stt">
        <tr>
            <td>${stt.count}</td>
            <td>${config.name}</td>
            <td>${config.languages}</td>
            <td>${config.pageSize}</td>
            <td>${config.signature}</td>
            <td><a href="/edit/${config.name}">Edit</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
