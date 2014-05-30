package br.dengue.dao;

//import java.sql.Connection;
import br.dengue.modelo.Dados;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DadosDAO {

    private Connection connection;

    public DadosDAO() throws ClassNotFoundException {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Dados dados) {
        String sql = "insert into dados "
                + "(latitude,longitude,dados)"
                + " values (?,?,?)";

        try {
            // prepared statement para inserÃ§Ã£o
            PreparedStatement stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setString(1, dados.getLatitude());
            stmt.setString(2, dados.getLongitude());
            stmt.setString(3, dados.getDados());
          

            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Dados> getLista() {
        try {
            List<Dados> dadoss = new ArrayList<Dados>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from dados d join app_lista al on d.dados=al.id where resolvido=0");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto Dados
                Dados dados = new Dados();
                dados.setId(rs.getInt("id"));
                dados.setLatitude(rs.getString("latitude"));
                dados.setLongitude(rs.getString("longitude"));
                dados.setDados(rs.getString("valor"));
                dados.setResolvido(rs.getInt("resolvido"));
                dados.setIcone(rs.getString("icone"));
                // adicionando o objeto a lista
                dadoss.add(dados);
            }
            rs.close();
            stmt.close();
            return dadoss;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void altera(Dados dados) {
        String sql = "update dados set resolvido=? where id=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, dados.getResolvido());
            stmt.setInt(2, dados.getId());
//            stmt.setString(1, dados.getLatitude());
//            stmt.setString(2, dados.getLongitude());
//            stmt.setString(3, dados.getDados());
//            stmt.setInt(4, dados.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(Dados dados) {
        try {
            PreparedStatement stmt = connection.prepareStatement("delete * from dados where id=?");
            stmt.setInt(1, dados.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
     public void criaArquivo()  {
       String lat;
        int id = 0;
        String lon;
        String desc;
        String texto = "[";
      
      List<Dados> dadoss = this.getLista();
      
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