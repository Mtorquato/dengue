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

@WebServlet(name = "RemoveLivroServlet", urlPatterns = {"/removeLivro"})
public class RemoveDadoServlet extends HttpServlet {

    protected void service(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

        String idS = request.getParameter("id");
        // buscando os parâmetros no request
        Integer id = Integer.parseInt(idS);

        // monta um objeto contato
        Dados chamado = new Dados();
        chamado.setId(id);

        
        // remove o contato
        DadosDAO dao;
        try {
            dao = new DadosDAO();
            dao.remove(chamado);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdicionaDadoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        // imprime o nome do contato que foi adicionado

        RequestDispatcher rd = request.getRequestDispatcher("/consulta.jsp");
        rd.forward(request, response);
    }
}
