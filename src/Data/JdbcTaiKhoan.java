/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import quanlythuvien2.models.TaiKhoan;

/**
 *
 * @author Admin
 */
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
    
    
//    
//    public static void main(String[] args) throws SQLException {
//       for(TaiKhoan a: getTaiKhoan())
//            System.out.println(a.isQuyenDangNhap());
//    }
}
