import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/support")
public class HelloServlet<ticketNo> extends HttpServlet {

    private static int ticketNo;

    public static  int getTicketNo() {
        return ticketNo;
    }


    @Override
    public void init() throws ServletException {
        ticketNo++;
    }
/*
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Servlet "+ this.getServletName() + " has started");
    }*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.print("<html><head><title>Test</title></head><body>");
        out.print("<form method='post'>");
        out.print("<Label>Name <input type='text' name='name'/></Label><br /><br />");
        out.print("<Label>Email <input type='text' name='email'/></Label><br /><br />");
        out.print("<Label>Problem <input type='text' name='problem'/></Label><br /><br />");
        out.print("<textarea rows='5' cols='20'></textarea><br /><br />");
        out.print("<input type='submit' value='Help'/>");
        out.print("</form>");
        out.print("</body></html>");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        ServletContext sc=this.getServletContext();
        out.print("<html><head><title>Test</title></head><body>");
        out.print("Thank you " + req.getParameter("name") +
        " for contacting us. You should receive reply from us with in 24 hrs in your email address "+req.getParameter("email")+
         "<br />" +" Let us know in our support email " +sc.getInitParameter("support-email")  +" if you don’t receive reply within 24 hrs. " +
         "Please be sure to attach your reference no. " +getTicketNo()+" in your email.");
        out.print("</body></html>");

    }
}
