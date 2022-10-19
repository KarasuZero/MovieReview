
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add Review Page</title>
    </head>
    <body>
        <form method="POST" action="review-servlet">
            <table>
                <tr>
                    <td>Movie Title</td>
                    <td><input type="text" name="movieTitle" /></td>
                </tr>
                <tr>
                    <td>Movie Review</td>
                    <td><input type="text" name="movieReview" /></td>
                </tr>
                <tr>
                    <td>Movie Rating</td>
                    <td><input type="text" name="movieRating" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Add Review" /></td>
                </tr>
            </table>
        </form>
        <a href="index.jsp">Go back to main page</a>
    </body>
</html>
