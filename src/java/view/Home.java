/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Prato;

/**
 *
 * @author rafa
 */
public class Home extends HttpServlet {

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
            out.println("<title>Servlet Home</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Spoleto</h1>");

            
            
            HttpSession session = request.getSession();
            
            
            Prato pratoUsuario = null;
            
            if(session != null){
                pratoUsuario = (Prato) session.getAttribute("p");
            }
            
            if(pratoUsuario == null) {
                pratoUsuario = new Prato();
            }
            
            if(pratoUsuario.getMassa() == null) {
                out.println("<br/> Escolha uma massa <a href=\"Massas.html\">aqui</a>");
            }
            else {
                out.println("<br/> Massa selecionada: " + pratoUsuario.getMassa() + ". <a href=\"Massas.html\">(trocar)</a>");
            }
            if(pratoUsuario.getMolho() == null) {
                out.println("<br/> Escolha um molho <a href=\"Molhos.html\">aqui</a>");
            }
            else {
                out.println("<br/> Massa selecionada: " + pratoUsuario.getMolho() + ". <a href=\"Molhos.html\">(trocar)</a>");
            }
            if(pratoUsuario.getIngredientes() == null || pratoUsuario.getIngredientes().isEmpty() ) {
                out.println("<br/> Escolha ingredientes <a href=\"Ingredientes.html\">aqui</a>");
            }
            else {
                out.println("<br/> Ingredientes selecionados: <br/>");
                for (String ingrediente : pratoUsuario.getIngredientes()) {
                    out.println(ingrediente + "<br/>");
                }
                out.println("<br/> Escolha mais ingredientes <a href=\"Ingredientes.html\">aqui</a>");
            }
                
            
            out.println("<br/> ");
            out.println("");
            out.println("<a href=\"Enviar.html\">Enviar Pedido</a>");
            
            out.println("</body>");
            out.println("</html>");
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
