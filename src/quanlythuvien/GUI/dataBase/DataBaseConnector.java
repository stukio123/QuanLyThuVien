package quanlythuvien.GUI.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import quanlythuvien.model.Sach;


public class DataBaseConnector {
    
    private static Connection conn = null;
    private static Statement stmt = null;
    private static DataBaseConnector handler = null;
    
    public static DataBaseConnector getInstance() {
        if (handler == null) {
            handler = new DataBaseConnector();
        }
        return handler;
    }
    
    //Thực hiện kết nối database MySQL
    public static Connection getDBConnection(){
        final String url = "jdbc:mysql://127.0.0.1:3306/quanlythuvien";
        final String user = "root";
        final String password = "123456";

        try{
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = (Connection) DriverManager.getConnection(url, user, password);
        }catch(SQLException e){
              e.printStackTrace();
        }
        return (conn);
      }  
    
    //Thực thi truy vấn
    public ResultSet execQuery(String query) {
        ResultSet result;
        try {
            stmt = conn.createStatement();
            result = stmt.executeQuery(query);
        }
        catch (SQLException ex) {
            System.out.println("Exception at execQuery:dataHandler" + ex.getLocalizedMessage());
            return null;
        }
        finally {
        }
        return result;
    }
    
    //
    public boolean execAction(String query) {
        try {
            stmt = conn.createStatement();
            stmt.execute(query);
            return true;
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error:" + ex.getMessage(), "Error Occured", JOptionPane.ERROR_MESSAGE);
            System.out.println("Exception at execQuery:dataHandler" + ex.getLocalizedMessage());
            return false;
        }
        finally {
        }
        
    }
    
    public static boolean insertNewBook(Sach sach) {
        try {
            PreparedStatement statement = DataBaseConnector.getInstance().getDBConnection().prepareStatement(
                    "INSERT INTO sach(TenSach,MaTacGia,MaTheLoai,MaNXB,TrangThai) VALUES(?,?,?,?,?)");
            statement.setString(1, sach.getId());
            statement.setString(2, sach.getTitle());
            statement.setString(3, sach.getAuthor());
            statement.setString(4, sach.getPublisher());
            statement.setString(5, sach.getAvailability());
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error:" + ex.getMessage(), "Error Occured", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public DataBaseConnector(){
    }
//    public static void main(String[] args) 
//    {
//        Connection c = getDBConnection();
//        if (c == null) {
//            System.out.println("Không thể kết nối tới Server");
//        } else {
//            System.out.println("Kết nối thành công");
//        }
////        String qu = "CREATE TABLE `quanlythuvien`.`user` (\n" +
////            "  `username` VARCHAR(16) NOT NULL,\n" +
////            "  `email` VARCHAR(255) NULL,\n" +
////            "  `password` VARCHAR(32) NOT NULL,\n" +
////            "  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP);";
////        try{
////            stmt = conn.createStatement();
////            stmt.execute(qu);
////        }catch(SQLException ex)
//////        {
////            System.out.println("Exception at execQuery:dataHandler" + ex.getLocalizedMessage());
////        }
//        Sach book = new Sach("1","1","1","1","1");
//        boolean result = DataBaseConnector.insertNewBook(book);
//    }
    
}
