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
import java.util.ArrayList;
import java.util.List;
import quanlythuvien2.models.TheThuVien;

/**
 *
 * @author Admin
 */
public class JdbcTheThuVien {
    public static List<Integer> getTheThuVien() throws SQLException, ParseException{
        List<Integer> the = new ArrayList<>();
        Connection conn = Jdbc.getConn();
        Statement stm = conn.createStatement();
        
        ResultSet rs = stm.executeQuery("SELECT * FROM thethuvien");
        while (rs.next()) {
            int so = rs.getInt("sothe");
//            String nbt = rs.getDate("ngaybatdau").toString();
//            String nkt = rs.getDate("ngayketthuc").toString();
            
            the.add(so);
        }
        return the;
    }
}
