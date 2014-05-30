/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dengue.teste;

import br.dengue.dao.DadosDAO;
import br.dengue.modelo.Dados;
import java.util.Calendar;

/**
 *
 * @author Higor
 */
public class Testar {

    public static void main(String[] args) throws ClassNotFoundException {
        
        DadosDAO json = new DadosDAO();
        json.criaArquivo();
  
    }
}
