package Delete;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int reviewId = Integer.parseInt(request.getParameter("reviewId"));

        String url = "jdbc:mysql://localhost:3306/foodsystem";
        String username = "root";
        String password = "Induni10@";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);

            String sql = "DELETE FROM user_reviews WHERE review_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, reviewId);

            stmt.executeUpdate();
            conn.close();

            response.sendRedirect("ReadServlet"); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
