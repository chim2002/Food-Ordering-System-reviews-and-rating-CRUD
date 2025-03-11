package Create;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String userId = request.getParameter("user_id");
        String rating = request.getParameter("rating");
        String reviewText = request.getParameter("review_text");

        // Database connection
        String url = "jdbc:mysql://localhost:3306/foodsystem";
        String username = "root";  
        String password = "Induni10@";  

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);

           
            String sql = "INSERT INTO user_reviews (user_id, rating, review_text) VALUES (?, ?, ?)";//Query
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(userId));
            stmt.setInt(2, Integer.parseInt(rating));
            stmt.setString(3, reviewText);

            int result = stmt.executeUpdate();
            if (result > 0) {
                
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Review submitted successfully!');");
                out.println("location='ReadServlet';"); 
                out.println("</script>");
            	
            	//out.println("<script type=\"text>/javascript\"> alter('Review submitted successfully!'); location='ReadServlet';</script>");
            	
            } else {
                
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Failed to submit review.');");
                out.println("location='Create.jsp';");
                out.println("</script>");
            }

            conn.close();
        } catch (Exception e) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Database connection error: " + e.getMessage() + "');");
            out.println("location='Create.jsp';");
            out.println("</script>");
            e.printStackTrace();
        }
    }
}
