package Read;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Read;

@WebServlet("/ReadServlet")
public class ReadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "jdbc:mysql://localhost:3306/foodsystem";
        String username = "root";
        String password = "Induni10@";
        
        ArrayList<Read> reviewsList = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM user_reviews";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Read review = new Read(rs.getInt("review_id"), rs.getInt("user_id"), rs.getInt("rating"), rs.getString("review_text"));
                reviewsList.add(review);
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace(); 
        }

        request.setAttribute("reviewsList", reviewsList);
        request.getRequestDispatcher("Read.jsp").forward(request, response);
    }
}
