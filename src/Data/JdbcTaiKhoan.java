package Data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import quanlythuvien2.models.TaiKhoan;

public class JdbcTaiKhoan {
    
    public static List<TaiKhoan> getTaiKhoan() throws SQLException {
        Connection conn = Jdbc.getConn();
        String sql = "SELECT * FROM taikhoan";        
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        
        List<TaiKhoan> listTK = new ArrayList<>();
        while (rs.next()) {
            TaiKhoan tk = new TaiKhoan(rs.getString("tentk"), 
                    rs.getString("matkhau"), rs.getBoolean("quyen"));
            listTK.add(tk);
        }
        
        return listTK;
    }

     public static List<TaiKhoan> getTaiKhoan1() throws SQLException {
        Connection conn = Jdbc.getConn();
        
        List<TaiKhoan> tentk = new ArrayList<>();
        String sql = "SELECT * FROM taikhoan";        
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        
        while (rs.next()) {
            
            TaiKhoan tk = new TaiKhoan(rs.getInt("matk"),rs.getString("tentk"));
            tentk.add(tk);
        }
        
        return tentk;
    }

    public static List<String> getTaiKhoan2() throws SQLException {
        Connection conn = Jdbc.getConn();
        
        List<String> tentk = new ArrayList<>();
        String sql = "SELECT * FROM taikhoan";        
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        
        while (rs.next()) {
            
            String ten = rs.getString("tentk");
            tentk.add(ten);
        }
        
        return tentk;
    }
 
}
