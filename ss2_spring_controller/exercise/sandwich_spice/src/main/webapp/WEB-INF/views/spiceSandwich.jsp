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
    <title>Chuển đổi tiền tệ</title>
</head>
<body>
<form action="/cv" method="post">
    <fieldset style="display: inline">
        <legend><span>Spice Sandwich</span></legend>
    <input name="condiment" type="checkbox" value="Lettuce">Lettuce
    <input name="condiment" type="checkbox" value="Tomato">Tomato
    <input name="condiment" type="checkbox" value="Mustard">Mustard
    <input name="condiment" type="checkbox" value="Sprouts">Sprouts
    <button type="submit">Enter</button>
    </fieldset>
</form>
<h4>${condiment}</h4>
</body>
</html>
