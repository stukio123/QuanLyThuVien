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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import quanlythuvien2.models.DocGia;
import quanlythuvien2.models.NhanVien;

/**
 *
 * @author Admin
 */
public class JdbcNhanVien {
    public static List<NhanVien> getNV() throws SQLException, ParseException {
        Connection conn = Jdbc.getConn();
        String sql = "SELECT * FROM nhanvien";        
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        
        List<NhanVien> listNV = new ArrayList<>();
        String a = "";
                while (rs.next()) {
         
             
            NhanVien s = new NhanVien(rs.getString("hoten"), 
                     rs.getBoolean("gioitinh"),rs.getDate("ngaysinh"),
                    rs.getString("diachi"),rs.getInt("matk"));
  
            listNV.add(s);
        }
        
        
        
        return listNV;
    }
}
