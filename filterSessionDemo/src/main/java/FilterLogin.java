import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FilterLogin implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest in = (HttpServletRequest) request;

        HttpSession session=in.getSession();
        String username = (String) session.getAttribute("username");

        HttpServletRequest requestreal = (HttpServletRequest) request;
        String requestURI = requestreal.getRequestURI();

        String path= ((HttpServletRequest) request).getServletPath();

        ArrayList<String> allow = new ArrayList<String>(
                Arrays.asList("/index.jsp", ".js", ".css" ,"/login","/logout"));

        if (!allow.contains(path)  )

        {
            if (  username == null )

            {
                RequestDispatcher dd=request.getRequestDispatcher("/index.jsp");
                dd.forward(request, response);
            }
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
