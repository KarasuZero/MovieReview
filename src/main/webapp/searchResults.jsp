<%--
  Created by IntelliJ IDEA.
  User: kento
  Date: 10/18/2022
  Time: 11:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Search Result Page</title>
    </head>
    <body>
        <p>In search Results</p>
        <h4><% out.print(request.getAttribute("outPut")); %></h4>
        <a href="index.jsp">Go back to main page</a>
    </body>
</html>
