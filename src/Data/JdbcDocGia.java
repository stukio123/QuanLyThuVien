/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.format;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import quanlythuvien2.models.DocGia;
import quanlythuvien2.models.Sach;

/**
 *
 * @author Admin
 */
public class JdbcDocGia {
    
    public static List<DocGia> getDG() throws SQLException, ParseException {
        Connection conn = Jdbc.getConn();
        String sql = "SELECT * FROM docgia";        
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        
        List<DocGia> listDG = new ArrayList<>();
        String a = "";
        SimpleDateFormat  sdf = new SimpleDateFormat(a);

        while (rs.next()) {
            
            DocGia s; 
            s = new DocGia(rs.getString("madocgia"), 
                    rs.getString("tendocgia"), rs.getBoolean("gioitinh"),rs.getDate("namsinh"),
                    rs.getString("diachi"),rs.getInt("sothe"));
  
            listDG.add(s);
        }
        
        
        
        return listDG;
    }
    
    
    
    
    public static void addDocGia(DocGia dg) throws SQLException{
        Connection conn = Jdbc.getConn();
        
        String sql ="INSERT INTO docgia(madocgia,tendocgia,gioitinh,namsinh,diachi,sothe) VALUES(?,?,?,?,?,?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1,dg.getMaDG());
        stm.setString(2,dg.getTenDG());
        stm.setBoolean(3,dg.isGioiTinh());
        stm.setDate(4,dg.getNamSinh());
        stm.setString(5,dg.getDiaChi());
        stm.setInt(6,dg.getSoThe());
        
        stm.executeUpdate();
    }
}
