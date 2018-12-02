package login;

/**
 *
 * @author win
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class loginDAO {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(loginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static boolean validate(String name,String pass){
      boolean status = false;
      String url = "jdbc:mysql://localhost/testdemo?useSSL=false&allowMultiQueries=true";
      try{
          Connection con = DriverManager.getConnection(url,"root", "Rishabh123");
          PreparedStatement ps = con.prepareStatement("select * from kalia where First_Name=? and Password=?");
                  ps.setString(1, name);
                  ps.setString(2, pass);
                  ResultSet rs = ps.executeQuery();
                  status = rs.next();
      }
      catch(Exception e){
          System.out.println(e);
      }
      return status;
    }
}



