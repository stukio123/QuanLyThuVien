package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import quanlythuvien2.models.TraSach;

public class JdbcTraSach {
    
    public static List<TraSach> getTS() throws SQLException, ParseException {
        Connection conn = Jdbc.getConn();
        String sql = "SELECT * FROM trasach";        
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        
        List<TraSach> list= new ArrayList<>();

        while (rs.next()) {
            
            TraSach s; 
            s = new TraSach(rs.getInt("matra"), 
                    rs.getInt("mamuon"), rs.getDate("ngaytra"),rs.getInt("ngaytre"),rs.getDouble("tienphat"));
  
            list.add(s);
           
        }
        return list;
    }
    
    public static int maTra() throws SQLException, ParseException {
        Connection conn = Jdbc.getConn();
        String sql = "SELECT * FROM trasach";        
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        int ma = 0;
        while (rs.next()) {
           ma = rs.getInt("matra");
        }
        return ma;
    }
    
    public static void addTraSach(TraSach ts) throws SQLException, ParseException{
        Connection conn = Jdbc.getConn();
        
        String sql ="INSERT INTO trasach(mamuon,ngaytra,ngaytre,tienphat) VALUES(?,?,?,?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1,ts.getMaMuon());
        stm.setDate(2,ts.getNgayTra());
        stm.setInt(3,ts.getNgayTre());
        stm.setDouble(4,ts.getTienPhat());
        
        stm.executeUpdate();
    }
}
