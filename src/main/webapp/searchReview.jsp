
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title>Search Page</title>
  </head>

  <body>
    <form action="review-servlet" method="GET">
        <input type="text" name="MovieTitle" value="Enter the Name of the Movie"/>
        <input type="submit" value="Search" />
    </form>
    <a href="index.jsp">Go back to main page</a>
  </body>
</html>
