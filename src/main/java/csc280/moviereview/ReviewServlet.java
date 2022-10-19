package csc280.moviereview;

import java.io.*;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "ReviewServlet", value = "/review-servlet")
public class ReviewServlet extends HttpServlet {
    private String message;
    private String outPut;

    private int counter;
    ArrayList<Review> ReviewList;
    ArrayList<Review> OutputList;

    public void init() {
        message = "Hello World!";
        ReviewList = new ArrayList<Review>();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        message = "in doGet";


       try {
           // reset counter and output
           OutputList.clear();
           outPut= "";
           counter = 0;

           // getting user input
           String searchInput = request.getParameter("MovieTitle");

            //search for the movie title in the arraylist
           for(Review r : ReviewList) {
               //add review to output list if title contains search input
                if(r.getTitle().toLowerCase().contains(searchInput.toLowerCase())) {
                   OutputList.add(r);
                }
            }

           //set output to be displayed
           if(OutputList.size() == 0) {
               outPut = "No reviews found";
           } else {
               for(Review r: OutputList) {
                   outPut += "Movie #" + counter + ": Tittle: " + r.getTitle() + ", Rating:  "
                           + r.getRating() + ", Review: " + r.getReview() + "\n";
                   counter++;
               }
           }


            request.setAttribute("outPut", outPut);
            RequestDispatcher dispatcher = request.getRequestDispatcher("searchResults.jsp");
            dispatcher.forward(request, response);


        } catch (Exception e) {
           //TODO handle exception cases
           message = "Error: " + e.getMessage();
        }


        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + outPut + "</h1>");
        out.println("</body></html>");


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        message = "in doPost";

        // Get the parameters from addReview.jsp
        try{
            String title = request.getParameter("movieTitle");
            String rating = request.getParameter("movieRating");
            String review = request.getParameter("movieReview");

            // Create a new Review object and add it to the ArrayList
            Review newReview = new Review(title, rating, review);
            ReviewList.add(newReview);

            //back to index.jsp
            response.sendRedirect("index.jsp");

            //for reach review in ReviewList print out the title, rating, and review
//             message = "";
//            for(Review r : ReviewList) {
//                message += "Movie Title: " + r.getTitle() + ", Movie Rating: " + r.getRating() +
//                        ", Movie Review: " + r.getReview() + " ";
//            }

        }
        catch(Exception e){
            //TODO handle exception cases
            message = "Error: " + e.getMessage();
        }

        // Print
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
  }
}