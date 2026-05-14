package Controllers;

import Model.User;
import Utilities.SessionUtil;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "AuthFilter", urlPatterns = {"/*"})
public class AuthFilter implements Filter {

    private static final String LOGIN = "/login";
    private static final String REGISTER = "/register";
    private static final String HOME = "/home";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // nothing needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();

        //  allow static files (CSS, images, resources)
        if (uri.endsWith(".css") || uri.endsWith(".js") ||
            uri.endsWith(".png") || uri.endsWith(".jpg") ||
            uri.contains("Resources")) {

            chain.doFilter(request, response);
            return;
        }

        //  allow pages
        if (uri.endsWith("/home") ||
            uri.endsWith("/about.html") ||
            uri.endsWith("/contact.html") ||
            uri.endsWith(LOGIN) ||
            uri.endsWith(REGISTER)) {
            chain.doFilter(request, response);
            return;
        }

        //  check login
        User user = (User) SessionUtil.getAttribute(req, "user");
        if (user == null) {
            //  not logged in , so redirect to login
            res.sendRedirect(req.getContextPath() + LOGIN);
        } else {
            //  logged in → allow access
            if (uri.endsWith(LOGIN) || uri.endsWith(REGISTER)) {
                res.sendRedirect(req.getContextPath() + "/buyerDashboard");
            } else {
                chain.doFilter(request, response);
            }
        }
    }

    @Override
    public void destroy() {
        // nothing 
    }
}