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
        System.out.println("AuthFilter init");
    }

    @Override
    public void doFilter(final ServletRequest request,
                         final ServletResponse response,
                         final FilterChain filterChain)
            throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;

        String servletPath = req.getServletPath();
        if (servletPath.contains("/user/")) {
            final String login = req.getParameter("login");
            final String password = req.getParameter("password");

            UserDAOImplement findUser = new UserDAOImplement();
            User user = findUser.getEntityByLogin(login);

            final HttpSession session = req.getSession();

            if (nonNull(session) && nonNull(session.getAttribute("login")) && nonNull(session.getAttribute("password"))) {

                final Role role = (Role) session.getAttribute("role");
                moveToUsersOffice(req, res, role);

            } else if (user != null) {

                final Role role = user.getRole();

                req.getSession().setAttribute("password", password);
                req.getSession().setAttribute("login", login);
                req.getSession().setAttribute("role", role);
                moveToUsersOffice(req, res, role);
            } else {
                req.getRequestDispatcher("/user/login").forward(req, res);
            }
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
