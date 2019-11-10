/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import quanlythuvien2.models.DocGia;
import quanlythuvien2.models.MuonSach;
import quanlythuvien2.models.Sach;

/**
 *
 * @author Tran Nguyen Anh
 */
public class JdbcMuonSach {
    
    public static List<MuonSach> getMS() throws SQLException, ParseException {
        Connection conn = Jdbc.getConn();
        String sql = "SELECT * FROM muonsach";        
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        
        List<MuonSach> list= new ArrayList<>();
        String a = "";
        SimpleDateFormat  sdf = new SimpleDateFormat(a);

        while (rs.next()) {
            
            MuonSach s; 
            s = new MuonSach(rs.getInt("mamuon"), rs.getInt("mathe"), rs.getString("masach"), rs.getDate("ngaymuon"),rs.getString("is_tra"));
  
            list.add(s);
           
        }
         
        
        
        return list;
    }
    
    
    public static void addMuonSach(MuonSach ms) throws SQLException{
        Connection conn = Jdbc.getConn();
        
        String sql ="INSERT INTO muonsach(mathe,masach, ngaymuon,is_tra) VALUES(?,?,?,?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1,ms.getMaThe());
        stm.setString(2,ms.getMaSach());
        stm.setDate(3,ms.getNgayMuon());
        stm.setString(4,"-");
        
        stm.executeUpdate();
    }
    
    public static PreparedStatement ps;
    public static boolean updateMuon(int ma){
        try {
            ps = Jdbc.getConn().prepareStatement("UPDATE muonsach SET is_tra = ? where mamuon = ?");
            ps.setInt(2, ma);
            ps.setString(1, "đã trả");
            
            return ps.executeUpdate() >0;
        } catch (SQLException ex) {
            Logger.getLogger(JdbcSach.class.getName()).log(Level.SEVERE, null, ex);
        }
            return false;
    }
    
    
    
    
    
    public static List<MuonSach> getMS(int giatri) throws SQLException {
        Connection conn = Jdbc.getConn();
        String sql = "SELECT * FROM muonsach WHERE mamuon like N'%1%'";        
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        
        List<MuonSach> list = new ArrayList<>();
     
        while(rs.next()) {
            MuonSach s = 
            new MuonSach(rs.getInt("mamuon"), rs.getInt("mathe"), rs.getString("masach"), rs.getDate("ngaymuon"),rs.getString("is_tra"));
            list.add(s);
        }
        return list;
    }
//    public static String soluongMuonSach(int ma) throws SQLException, ParseException {
//        Connection conn = Jdbc.getConn();
//        int sl = 0;
//        String sql = "SELECT * FROM muonsach";        
//        Statement stm = conn.createStatement();
//        ResultSet rs = stm.executeQuery(sql);
//        
//        List<MuonSach> list= new ArrayList<>();
//        String a = "";
//        SimpleDateFormat  sdf = new SimpleDateFormat(a);
//
//        while (rs.next()) {
//            
//      
//           
//        }
//        
//        return list;
//    }\\
    
    
    public static int soluong(int mathe) throws SQLException, ParseException {
        Connection conn = Jdbc.getConn();
        String sql = "SELECT * FROM muonsach";        
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        int ma = 0;
        while (rs.next()) {
           if(rs.getInt("mathe")== mathe && rs.getString("is_tra").equals("-"))
               ma++;
        }
        return ma;
    }
    
}
