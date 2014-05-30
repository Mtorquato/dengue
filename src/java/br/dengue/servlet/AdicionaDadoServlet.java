/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dengue.servlet;

import br.dengue.dao.DadosDAO;
import br.dengue.modelo.Dados;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdicionaDadosServlet", urlPatterns = {"/adicionaDados"})
public class AdicionaDadoServlet extends HttpServlet {

    protected void service(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

        // buscando os parâmetros no request
        String latitude = request.getParameter("latitude");
        String longitude = request.getParameter("longitude");
        String dado = request.getParameter("dados");
        // monta um objeto contato
        Dados dados = new Dados();
        dados.setLatitude(latitude);
        dados.setLongitude(longitude);
        dados.setDados(dado);

        // salva o contato
        DadosDAO dao;
        try {
            dao = new DadosDAO();
            dao.getLista();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdicionaDadoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        // imprime o nome do contato que foi adicionado

        RequestDispatcher rd = request.getRequestDispatcher("/consulta.jsp");
        rd.forward(request, response);
    }
}
