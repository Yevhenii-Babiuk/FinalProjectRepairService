package servlet;

import model.Role;
import service.GetOrderWithDetails;
import service.InsertOrder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;


/**
 * Servlet for viewing all orders and  adding new orders
 */
public class OrdersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String parametr = null;
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            parametr = parameterNames.nextElement();
        }
        InsertOrder insertOrder = new InsertOrder();
        if (request.getSession().getAttribute("role").equals(Role.CLIENT)) {
            insertOrder.setOrderFromClient(parametr);
        }else {
            insertOrder.setOrderFromEmployee(parametr);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("orders", new GetOrderWithDetails().getOrder());
        request.getRequestDispatcher("/view/orders.jsp").forward(request, response);
    }
}
