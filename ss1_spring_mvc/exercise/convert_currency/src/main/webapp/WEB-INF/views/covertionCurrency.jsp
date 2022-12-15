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
<form action="/convert/cv">
    <fieldset style="display: inline">
        <legend><span>Chuyển đổi tiền tệ</span></legend>
    <span>
      Nhập Tiền muốn đổi
    </span>
    <input required type="number" name="ip">
    <select name="cv">
        <option value="USD">USD to VND</option>
        <option value="VND">VND to USD</option>
    </select>
    <button type="submit">Change</button>
    </fieldset>
</form>
<h4>${chat}</h4>
</body>
</html>
