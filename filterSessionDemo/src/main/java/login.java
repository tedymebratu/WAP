import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({"/login"})
public class login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*req.getSession().invalidate();
        resp.sendRedirect("index.jsp");*/

        String username= req.getParameter("username");
        String pass=req.getParameter("password");
        String remember=req.getParameter("remember");
        HttpSession session=req.getSession();

        if ("Theodros".equals(username) && "123".equals(pass)) {

            session.setAttribute("username", username);

            if ("yes".equals(remember)) {
                Cookie c = new Cookie("user", username);
                c.setMaxAge(30 * 24 * 60 * 60);
                resp.addCookie(c);
            } else {
                Cookie c = new Cookie("user", null);
                c.setMaxAge(0);
                resp.addCookie(c);

            }
            resp.sendRedirect("welcome.jsp");
        } else {
            session.setAttribute("err_msg", "Username and/or password invalid.");
            resp.sendRedirect("index.jsp");
        }

    }
}
