package Data;

import java.sql.Connection;
import java.sql.DriverManager;


public class DataBaseConnector {
    
    private  static Connection conn = null;
    
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlythuvien", "root", "123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
//      Test kết nối
//    public static void main(String[] args) {
//        try{
//            conn = DataBaseConnector.getConnection();
//            System.out.println("Kết nối thành công");
//        }
//        catch(Exception e) {
//            System.out.println("Kết nối thất bại");
//        }
//    }
}
