package Update;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reviewId = request.getParameter("reviewId");
        String rating = request.getParameter("rating");
        String reviewText = request.getParameter("review_text");

        String url = "jdbc:mysql://localhost:3306/foodsystem";
        String username = "root";
        String password = "Induni10@";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);

            String sql = "UPDATE user_reviews SET rating = ?, review_text = ? WHERE review_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(rating));
            stmt.setString(2, reviewText);
            stmt.setInt(3, Integer.parseInt(reviewId));

            stmt.executeUpdate();
            conn.close();

            response.sendRedirect("ReadServlet");  
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
