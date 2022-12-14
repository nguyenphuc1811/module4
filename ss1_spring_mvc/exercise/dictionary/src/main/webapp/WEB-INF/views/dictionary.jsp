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
<form action="/diction">
    <fieldset style="display: inline">
        <legend><span>Translate</span></legend>
        <span>Input char</span>
        <input required type="text" name="eng">
        <button type="submit">Change</button>
    </fieldset>
</form>
<h4>${result}</h4>
</body>
</html>
