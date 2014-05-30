/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dengue.servlet;

import br.dengue.dao.UserDAO;
import br.dengue.modelo.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Higor
 */
public class ServletValidaLogin extends HttpServlet {

    private static final long serialVersionUID = 7633293501883840556L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(); //obtem a sessao do usuario, caso exista

        User user = null;
        String login_form = request.getParameter("usuario"); // Pega o Login vindo do formulario
        String senha_form = request.getParameter("senha"); //Pega a senha vinda do formulario

        try {
            UserDAO dao = new UserDAO(); //cria uma instancia do DAO usuario
            user = dao.getUsuario(login_form, senha_form);
        } catch (Exception e) {

        }

        //se nao encontrou usuario no banco, redireciona para a pagina de erro!
        if (user == null) {
            session.invalidate();
            request.getRequestDispatcher("erroLogin.jsp").forward(request, response);
        } else {
            //se o dao retornar um usuario, coloca o mesmo na sessao
            session.setAttribute("user", user);
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);

        }

    }

}
