<%--
  Created by IntelliJ IDEA.
  User: karnur
  Date: 26.04.18
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Form: </h1>

<form action="/addBook" method="post">
    Id: <input type="text" name="id"><br>
    Isbn: <input type="text" name="isbn"><br>
    Title: <input type="text" name="title"><br>
    Author: <input type="text" name="author"><br>
    Publisher: <input type="text" name="publisher"><br>
    Type: <input type="text" name="type"><br>
    <input type="submit" value="submit">
</form>

</body>
</html>
