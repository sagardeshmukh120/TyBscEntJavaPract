/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;


/**
 *
 * @author deshmukh_sg
 */
public class Page5 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Page2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Page2 at " + request.getContextPath() + "</h1>");
            
            out.println("<body bgcolor=orange >");
            Cookie [] ck = request.getCookies();
            for(int i=0;i<ck.length;i++)
           {
                 if(ck[i].getName().equals("visit"))
                 {
                        int count = Integer.parseInt(ck[i].getValue())+1;
                        out.println("<h1>Visit No : "+count+"</h1>");
                        ck[i] = new Cookie("visit",count+"");
                        response.addCookie(ck[i]);
                 }
                 else 
                 {
                        out.println(ck[i].getName()+ " = "+ck[i].getValue()); 
                 }
                out.println("<h1><a href=Page3 >Click to visit Page 3 </a></h1>");
                out.println("<h1><a href=Page4 >Click to visit Page 4 </a></h1>");
                out.println("<h1><a href=Page5 >Click to visit Page 5 </a></h1>");
                out.println("</body>");
                out.println("</html>");
            }
    
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
