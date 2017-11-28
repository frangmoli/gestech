/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Usuario.Usuario;
import Usuario.ControladorUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class IniciarSesion extends HttpServlet {

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
        
        String usuario = request.getParameter("usr_alias");
        String password = request.getParameter("usr_password");  
        
        Usuario user = new Usuario(usuario, password);
        ControladorUsuario cu = new ControladorUsuario();
        HttpSession sesion = request.getSession();
        switch(cu.validar(user) ){
                case 1:
                   
                    sesion.setAttribute("user", usuario);
                    sesion.setAttribute("nivel", "1");
//                    response.sendRedirect("index.html");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            
                case 2:
                    
                    sesion.setAttribute("user", usuario);
                    sesion.setAttribute("nivel", "2");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                break;        
                
                default:
                    response.getWriter().print("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">"
                            + "<div style=\"max-width: 380px;padding: 15px 35px 45px;\"class=\"container-fluid\"><div class=\"alert alert-danger\">\n" +
"  <strong>Usuario o password incorrectos!</strong><a href=\"ingresar.jsp\" class=\"alert-link\"> Volver</a>.\n" +
"</div></div>"); 
                
                    break;  
        
            
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
