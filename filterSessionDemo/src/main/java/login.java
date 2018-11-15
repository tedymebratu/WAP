import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        ServletContext sc = this.getServletContext();

        UsersData usersData = new UsersData();


        InitializeMap initializeMap = new InitializeMap(usersData);

        User user = new User(req.getParameter("username"), req.getParameter("password"));

        String username = req.getParameter("username");

        if (usersData.getUsersMap().containsKey(username)) {

            HttpSession session = req.getSession();
            session.setAttribute("username", user);

            if(req.getParameter("rememberMe") != null) {

                Cookie myuser = new Cookie("user", "username");
                myuser.setMaxAge(24 * 60 * 60 * 30);
                resp.addCookie(myuser);
            }else {
                Cookie myuser = new Cookie("user", "username");
                myuser.setMaxAge(60 * 60 * 30);
                resp.addCookie(myuser);


            }
            resp.sendRedirect("welcome.jsp");

        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getSession().invalidate();
        resp.sendRedirect("index.jsp");

    }
}
