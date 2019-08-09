package filter;

import util.MySQLConnector;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Connection;


public class JdbcFilter extends MySQLConnector implements Filter {


    @Override
    public void init(FilterConfig fConfig) {
        System.out.println("JDBCFilter init");
    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String servletPath = req.getServletPath();
        if (servletPath.contains("/")) {
            Connection connection = null;
            try {
                connection = getConnection();
                connection.setAutoCommit(false);
                filterChain.doFilter(servletRequest, servletResponse);
                connection.commit();
            } catch (Exception e ) {
                rollbackQuietly(connection);
            }
        }
        else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
