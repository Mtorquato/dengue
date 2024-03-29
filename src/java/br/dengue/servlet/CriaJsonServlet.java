/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.dengue.servlet;

import br.dengue.dao.DadosDAO;
import br.dengue.modelo.Dados;
import br.dengue.teste.CriaJson;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Higor
 */
@WebServlet(name = "CriaJsonServlet", urlPatterns = {"/CriaJsonServlet"})
public class CriaJsonServlet extends HttpServlet {

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
      
       String lat;
        int id = 0;
        String lon;
        String desc;
        String texto = "[";
      
      DadosDAO dao = null;
        try {
            dao = new DadosDAO();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CriaJsonServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
      List<Dados> dadoss = dao.getLista();
      
      for (Dados dado : dadoss){
            texto += " {";
            texto += "\"id\":" + dado.getId() + ",";
            texto += "\"latitude\":" + dado.getLatitude() + ",";
            texto += "\"longitude\":" + dado.getLongitude() + ",";
            texto += "\"icone\":\"" + dado.getIcone() + "\",";
            texto += "\"valor\":\"" + dado.getDados() + "\"";
            texto += " },";
      }
        int tamanho = texto.length(); 
        texto = texto.substring(0, tamanho-1); 
        
        texto += "]";

        FileWriter arquivo;

        try {
            arquivo = new FileWriter(new File("web/js/pontos.json"));
            arquivo.write(texto);
            arquivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
       RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);  
        
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
