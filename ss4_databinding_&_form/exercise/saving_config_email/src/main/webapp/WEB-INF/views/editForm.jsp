<%--
  Created by IntelliJ IDEA.
  User: Welcome
  Date: 12/16/2022
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form action="/edit/save" method="post" modelAttribute="config">
    <fieldset style="display: inline">
        <form:hidden path="name"/>
        <table>
            <tr>
                <th>
                    <form:label path="languages">Languages: </form:label>
                </th>
                <td>
                    <form:select path="languages" items="${listLanguages}"/>
                </td>
            </tr>
            <tr>
                <th>
                    <form:label path="pageSize">PageSize: </form:label>
                </th>
                <td>
                    <form:select path="pageSize" items="${listSize}"/>
                </td>
            </tr>
            <tr>
                <th>
                    <form:label path="filter">Filter: </form:label>
                </th>
                <td>
                    <form:checkbox path="filter"/>
                </td>
            </tr>
            <tr>
                <th>
                    <form:label path="signature"/>
                </th>
                <td>
                    <form:textarea path="signature"/>
                </td>
            </tr>
            <tr>
                <td>
                <form:button>Submit</form:button>
                </td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>
