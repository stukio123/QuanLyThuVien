package quanlythuvien.Server;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;


public class DatabaseHandler {
    public static Connection _getDBConnection(){
        final String url = "jdbc:mysql://127.0.0.1:3306/sakila";
        final String user = "root";
        final String password = "123456";
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url,user,password);
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) throws SQLException {
        Connection connection = _getDBConnection();
        
        if (connection != null)
            System.out.println("Thành công");
        else
            System.out.println("Lỗi");
    }
}
