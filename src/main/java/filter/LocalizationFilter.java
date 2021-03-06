package filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Filter realizing system of localization
 */
public class LocalizationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        if (req.getParameter("locale") != null) {
            req.getSession().setAttribute("locale", req.getParameter("locale"));
        }

        filterChain.doFilter(req, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
