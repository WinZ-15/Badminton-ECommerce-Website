
import DOA.AnalyticsDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AnalyticsServlet")
public class AnalyticsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AnalyticsDAO dao = new AnalyticsDAO();
        double weekSales = dao.getSalesThisWeek();
        double monthSales = dao.getSalesThisMonth();
        double totalSales = dao.getTotalSales();

        request.setAttribute("salesWeek", weekSales);
        request.setAttribute("salesMonth", monthSales);
        request.setAttribute("salesTotal", totalSales);

        request.getRequestDispatcher("seller-dashboard.jsp").forward(request, response);
    }
}
