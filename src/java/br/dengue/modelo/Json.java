/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dengue.modelo;

import br.dengue.dao.DadosDAO;
import br.dengue.modelo.Dados;
import br.dengue.servlet.AdicionaDadoServlet;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Higor
 */
public class Json {

    public void criaArquivo() throws ClassNotFoundException {
       String lat;
        int id = 0;
        String lon;
        String desc;
        String texto = "[";
      DadosDAO dao = new DadosDAO();
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
    }
}
