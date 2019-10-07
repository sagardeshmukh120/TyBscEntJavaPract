package mypack;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.ejb.EJB;

public class CCServlet extends HttpServlet {
@EJB CCBean obj;
@Override
public void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException 
{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        double amt = Double.parseDouble(request.getParameter("amt"));
        if(request.getParameter("type").equals("r2d"))
        {
            out.println("<h1>"+amt+ " Rupees = "+obj.r2Dollor(amt)+" Dollors</h1>");
        }
        if(request.getParameter("type").equals("d2r"))
        {
            out.println("<h1>"+amt+ " Dollors = "+obj.d2Rupees(amt)+" Rupees</h1>");
        }
    }
}