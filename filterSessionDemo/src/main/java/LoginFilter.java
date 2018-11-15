import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginFilter implements Filter {


    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();


        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String username=request.getParameter("username");
        String password=request.getParameter("password");

        if(username == "" || password == "") {
            RequestDispatcher rd= request.getRequestDispatcher("index.jsp");

            rd.include(request,response);
            out.println("<font color=red>Username or password is empty. input again</font>");

        }
        else {
            chain.doFilter(request,response);
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {


    }

    @Override
    public void destroy() {

    }
}
