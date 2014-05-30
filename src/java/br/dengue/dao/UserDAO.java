package br.dengue.dao;

//import java.sql.Connection;
import br.dengue.modelo.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class UserDAO {

    private Connection connection;

    public UserDAO() throws ClassNotFoundException {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(User users) {
        String sql = "insert into users "
                + "(nome,dtnascimento,nivel,usuario,senha)"
                + " values (?,?,?,?,?)";

        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setString(1, users.getNome());
            stmt.setString(4, users.getUsuario());
            stmt.setString(5, users.getSenha());

            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getLista() {
        try {
            List<User> userss = new ArrayList<User>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from users");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto User
                User users = new User();
                users.setId(rs.getInt("id"));
                users.setNome(rs.getString("nome"));
              
                users.setUsuario(rs.getString("usuario"));
                users.setSenha(rs.getString("senha"));

                // adicionando o objeto à lista
                userss.add(users);
            }
            rs.close();
            stmt.close();
            return userss;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void altera(User users) {
        String sql = "update users set nome=?,usuario=?, senha=? where id=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, users.getNome());
            stmt.setString(4, users.getUsuario());
            stmt.setString(5, users.getSenha());
            stmt.setLong(6, users.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(User users) {
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from users where id=?");
            stmt.setLong(1, users.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User getUsuario( String login, String senha ){
      //  Connection c = .getConnection();
        //PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            PreparedStatement stmt = connection.prepareStatement("select id, nome from users where usuario = ? and senha = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
 
            rs = stmt.executeQuery();
 
            if ( rs.next() ){
                User users = new User();
                users.setId( rs.getInt("id") );
                users.setUsuario(login);
                users.setSenha(senha);
                users.setNome( rs.getString("nome") );
                
 
                return users;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally{
            if (rs != null ) {
                try { rs.close(); } catch (SQLException e) { ; }
                rs = null;
            }
                      
        }
        return null;
    }
}
