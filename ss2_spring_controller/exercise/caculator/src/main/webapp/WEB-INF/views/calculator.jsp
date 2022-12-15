<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Welcome
  Date: 12/14/2022
  Time: 1:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Máy tính cá nhân</title>
</head>
<body>
<form id="f" action="/cv" method="post">
    <fieldset style="display: inline">
        <legend><span>Calculator</span></legend>
        Number1
        <input name="number1" type="text" >
        <select name="operator" onchange="document.getElementById('f').submit()">
            <option value="+">+</option>
            <option value="-">-</option>
            <option value="*">*</option>
            <option value="/">/</option>
        </select>
        Number2
        <input name="number2" type="text" >
    </fieldset>
</form>
<h4>${result}</h4>
</body>
</html>
