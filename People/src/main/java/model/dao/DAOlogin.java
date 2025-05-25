
package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import start.Routes;
import model.entity.user;


public class DAOlogin {
    
    private final String SQL_READ_LOGIN = "select * from login.usuarios WHERE (usuario = ?) AND (psswd = ?) ";
    
    public Connection connect() throws SQLException {
        Connection conn;
        conn = DriverManager.getConnection(Routes.DB.getDbServerAddress() + Routes.DB.getDbServerComOpt(), Routes.DB.getDbServerUser(), Routes.DB.getDbServerPassword());
        return conn;
    }
      public void disconnect(Connection conn) throws SQLException {
        conn.close();
    }
      
      public user readLogin(String user ,String psswd) throws SQLException {
     user userReturn = null;
    Connection conn;
        PreparedStatement instruction;
        ResultSet rs;
        conn = connect();
        instruction = conn.prepareStatement(SQL_READ_LOGIN);
        instruction.setString(1,user);
        instruction.setString(2,psswd);
        rs = instruction.executeQuery();
        
          while (rs.next()) {
              String dbuser = rs.getString("usuario");
              String dbpsswd = rs.getString("psswd");
              userReturn = new user(dbuser , dbpsswd);
              
          }
           rs.close();
        instruction.close();
        disconnect(conn);
        return userReturn;
}
}