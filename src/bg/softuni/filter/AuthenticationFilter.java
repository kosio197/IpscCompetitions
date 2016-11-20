package bg.softuni.filter;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import bg.softuni.model.user.User;

public class AuthenticationFilter implements Filter, Serializable {
    private static final long serialVersionUID = -4228299401214104677L;

    public static final String PATH_INDEX = "/index.jsp";
    public static final String PATH_LOGIN = "/page/login.html";
    public static final String PATH_COMPETITITONS = "/page/competitions.html";
    public static final String PATH_REGISTER = "/page/userRegister.html";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestedPath = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());

        if (PATH_LOGIN.equals(requestedPath) || PATH_INDEX.equals(requestedPath) || PATH_LOGIN.equals(requestedPath) ||
                PATH_COMPETITITONS.equals(requestedPath) || PATH_REGISTER.equals(requestedPath)) {
            chain.doFilter(request, response);
            return;
        }

        HttpSession session = httpRequest.getSession();
        User loggedUser = (User) session.getAttribute("LOGGED_USER");

        if (loggedUser == null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(PATH_LOGIN);
            requestDispatcher.forward(request, response);
            return;
        } else {
            chain.doFilter(request, response);
            return;
        }
    }
}
