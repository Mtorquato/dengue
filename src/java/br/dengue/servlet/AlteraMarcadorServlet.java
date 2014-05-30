/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dengue.servlet;

import br.dengue.dao.DadosDAO;
import br.dengue.modelo.Dados;
import br.dengue.modelo.Json;
import br.dengue.teste.CriaJson;
import java.io.IOException;
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
 * @author bubulindao
 */
@WebServlet(name = "AlteraMarcadorServlet", urlPatterns = {"/alteraMarcador"})
public class AlteraMarcadorServlet extends HttpServlet {

    protected void service(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

        // buscando os parâmetros no request
        int id = Integer.parseInt(request.getParameter("idMarkerStatus"));
        int resolvido = Integer.parseInt(request.getParameter("statusMarcador"));
        
        // monta um objeto contato
        Dados dados = new Dados();
        dados.setId(id);
        dados.setResolvido(resolvido);


        // salva os dados
        DadosDAO dao;
        
        try {
            dao = new DadosDAO();
            dao.altera(dados);
            dao.criaArquivo();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlteraMarcadorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
        
// Ele tava redirecionando para a pagina consulta-casos, mas está comentado por uma possivel inutilidade! SHUASAHU :X :X
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }
}
