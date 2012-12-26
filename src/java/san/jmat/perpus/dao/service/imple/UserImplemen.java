/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.dao.service.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import san.jmat.perpus.dao.service.UserDao;
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public class UserImplemen implements UserDao {

    private Connection connection;
    private final String Insert = "INSERT INTO user (Nama_User,Password) VALUES (?,?) ";
    private final String Update = "UPDATE user SET Nama_User=?,Password=? WHERE Id_User=? ";
    private final String Delete = "DELETE FROM user WHERE Id_User=?";
    private final String Login = "SELECT * FROM user WHERE Nama_User=? AND Password=? ";
    private final String selecAll = "SELECT Nama_User,Password FROM user";

    public UserImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void Insert(User user) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void Update(Integer id, User user) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void Delete(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public User Login(String username, String password) throws Exception {
        User user;
        PreparedStatement statement;
        ResultSet resultSet;
        statement = null;
        resultSet = null;
        user = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(Login);
            statement.setString(1, username);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setIdUser(resultSet.getInt("Id_User"));
                user.setUserName(resultSet.getString("Nama_User"));
                user.setPassword(resultSet.getString("Password"));
               
            }
            connection.commit();
            return user;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new Exception(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                }
            }
        }

    }

    @Override
    public List<User> selectAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
