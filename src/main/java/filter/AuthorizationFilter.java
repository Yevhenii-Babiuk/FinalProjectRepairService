package filter;

import dao.UserDAOImplement;
import model.Role;
import model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.util.Objects.nonNull;

public class AuthorizationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(final ServletRequest request,
                         final ServletResponse response,
                         final FilterChain filterChain)
            throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;
        final HttpSession session = req.getSession();

        String servletPath = req.getServletPath();
        if (servletPath.contains("/account/office")||servletPath.contains("/account/login")) {
            final String login = req.getParameter("login");
            final String password = req.getParameter("password");

            User user = new UserDAOImplement().getEntityByLogin(login);

            if (nonNull(session) && nonNull(session.getAttribute("login")) && nonNull(session.getAttribute("password"))) {

                final Role role = (Role) session.getAttribute("role");
                moveToUsersOffice(req, res, role);

            } else if (user != null) {

                final Role role = user.getRole();
                final int id = user.getId();
                if (user.getPassword().equals(password)) {
                    req.getSession().setAttribute("password", password);
                } else {
                    req.getRequestDispatcher("/account/login").forward(req, res);
                }
                req.getSession().setAttribute("id", id);
                req.getSession().setAttribute("login", login);
                req.getSession().setAttribute("role", role);
                req.getSession().setAttribute("name", user.getName());
                req.getSession().setAttribute("surname", user.getSurname());
                req.getSession().setAttribute("password", user.getPassword());
                req.getSession().setAttribute("address", user.getAddress());
                req.getSession().setAttribute("phone", user.getPhone());
                moveToUsersOffice(req, res, role);
            } else {
                req.getRequestDispatcher("/account/login").forward(req, res);
            }
        }
        if (session.getAttribute("role") == null && (servletPath.contains("/account/orders") ||
                servletPath.contains("/account/employee_add_order") ||
                servletPath.contains("/account/users") ||
                servletPath.contains("/account/add_user") ||
                servletPath.contains("/account/edit_profile") ||
                servletPath.contains("/account/add_order") ||
                servletPath.contains("/account/devices"))
        ) {
            req.getRequestDispatcher("/account/login").forward(req, res);
        }
        filterChain.doFilter(request, response);
    }

    /**
     *
     */
    private void moveToUsersOffice(final HttpServletRequest req,
                                   final HttpServletResponse res,
                                   final Role role)
            throws ServletException, IOException {

        if (role.equals(Role.ADMIN)) {
            req.getRequestDispatcher("/view/admin_office.jsp").forward(req, res);
        } else if (role.equals(Role.CLIENT)) {
            req.getRequestDispatcher("/view/client_office.jsp").forward(req, res);
        } else if (role.equals(Role.MANAGER)) {
            req.getRequestDispatcher("/view/manager_office.jsp").forward(req, res);
        } else if (role.equals(Role.MASTER)) {
            req.getRequestDispatcher("/view/master_office.jsp").forward(req, res);
        } else {
            req.getRequestDispatcher("/user/login").forward(req, res);
        }
    }

    @Override
    public void destroy() {

    }
}
