package servlet;



import model.Role;
import service.AddUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


/**
 * Servlet for adding user
 */
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String parametr=null;
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            parametr = parameterNames.nextElement();
            }
        AddUser addUser = new AddUser();
        boolean isExist = addUser.addUserToDatabase(parametr);
        if (isExist && request.getSession().getAttribute("role")==null){
            out.write("/account/login");
        }else if (isExist && request.getSession().getAttribute("role")!=Role.CLIENT){
            out.write("/account/users");
        }
        else {
            out.write("/userExist");
        }
        out.close();
}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
