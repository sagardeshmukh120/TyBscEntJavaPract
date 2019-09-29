/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypack;

import java.io.*;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


/**
 *
 * @author deshmukh_sg
 */
public class QuizServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 3.2 Final//EN\">");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet QuizServlet</title>");            
            //out.println("</head>");
            //out.println("<body>");
            out.println("<h1>Servlet QuizServlet at " + request.getContextPath() + "</h1>");
            
            out.println("<form action=ShowResult >");
            try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qadb","root","");
                    Statement stmt = con.createStatement();
                    ResultSet res = stmt.executeQuery("select * from quiz");
                    out.println("<table border=1 >");
                    int qno=0;

                    while(res.next())
                    {
                        qno++;
                        out.println("<tr><td>"+res.getString(1)+"</td>");
                        out.println("<td>"+res.getString(2)+"</td></tr>");
                        out.println("<tr><td><input type=radio name="+qno+" value="+res.getString(3)+"></td><td>"+res.getString(3)+"</td></tr>");
                        out.println("<tr><td><input type=radio name="+qno+" value="+res.getString(4)+"></td><td>"+res.getString(4)+"</td></tr>");
                        out.println("<tr><td><input type=radio name="+qno+" value="+res.getString(5)+"></td><td>"+res.getString(5)+"</td></tr>");
                        out.println("<tr><td><input type=radio name="+qno+" value="+res.getString(6)+"></td><td>"+res.getString(6)+"</td></tr>");
                    }
                }
            catch(Exception e)
            {   
                out.println(e);
            }
            out.println("</table>");
            out.println("<input type=reset >");
            out.println("<input type=submit value=SUBMIT >");
            out.println("</form>"); } }
            
            
           // out.println("</body>");
           // out.println("</html>");
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


