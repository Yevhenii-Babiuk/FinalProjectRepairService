package filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

/**
 * Filter log all move user in application
 */
public class LogFilter implements Filter {

    public LogFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LogFilter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String user = null;
        try {
            user = req.getSession().getAttribute("login").toString();
        }
        catch (NullPointerException e){
            user=null;
        }
        final Logger LOG = Logger.getLogger("User action");
        String servletPath = req.getServletPath();
        LOG.info("User: "+user+" ServletPath :"+servletPath+"URL: "+ req.getRequestURL());

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("LogFilter destroy");
    }
}
