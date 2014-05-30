/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dengue.teste;

import br.dengue.dao.ConnectionFactory;
import java.sql.Connection;

/**
 *
 * @author Higor
 */
public class TestaConexao {
    private static Connection connection;
    public static  void main(String[] args) throws ClassNotFoundException{
        TestaConexao.connection = new ConnectionFactory().getConnection();
        System.out.println("Conexao Ok");
    }
}
