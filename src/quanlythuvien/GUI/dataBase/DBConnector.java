package quanlythuvien.GUI.dataBase;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public final class DBConnector {
    
    //private static DBConnector handler;
    public DBConnector(){
    }
    //private static Connection conn = null;
    //private static Statement stmt = null;
   
    public static Connection getDBConnection(){
        final String url = "jdbc:mysql://127.0.0.1:3306/quanlythuvien";
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
    

    public static void main(String[] args) {
        Connection c = getDBConnection();
        if (c == null) {
            System.out.println("something wrong");
        } else {
            System.out.println("ok");
        }
    }
    
//    public ResultSet execQuery(String query)
//    {
//        ResultSet result;
//        try{
//            stmt = conn.createStatement();
//            result = stmt.executeQuery(query);
//        }catch (SQLException e){
//            System.out.println("Exception at excQuery: dataHandler" + e.getLocalizedMessage());
//            return null;
//        }finally{
//        }
//        return result;
//    }
//    
//    public boolean execAction(String qu){
//        try{
//            stmt = conn.createStatement();
//            stmt.execute(qu);
//            return true;
//        }catch(SQLException e){
//            JOptionPane.showMessageDialog(null,"Error: " + e.getMessage(), "Error Occured",JOptionPane.ERROR_MESSAGE);
//            System.out.println("Exception at excQuery: dataHandler" + e.getLocalizedMessage());
//            return false;
//        }finally{
//        }
//    }
}

