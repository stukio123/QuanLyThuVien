package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbc {
private static Connection CONN;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            CONN = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanly2","root", "123456");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static Connection getConn() {
        return CONN;
    }
//    public static void main(String[] args) {
//        Connection conn = Jdbc.getConn();
//        if(conn != null) System.out.println("thanh cong");
//        else System.out.println("that bai");
//    }
 
}

    

