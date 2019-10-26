package Data;

import Object.Admin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AdminData {
    public static PreparedStatement ps;
    public static ResultSet rs;
    
    public Admin dangNhap(String taiKhoan, String pass) {
        Admin ad = null;
        try{
            ps = DataBaseConnector.getConnection().prepareStatement("SELECT * FROM quanlythuvien.quan_tri where Ma_Admin = ? and Password = ?;");
            ps.setString(1, taiKhoan);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while(rs.next()) {
                ad = new Admin();
//                kh.setMaKH(rs.getString("Ma_Khach_hang"));
//                kh.setPass(rs.getString("Password"));
//                
           }
        }
        catch(Exception e) {
            return ad = null;
        }
        return ad;
    }
    
    public static ResultSet showTextfield(String sql) {
        try {
            ps = DataBaseConnector.getConnection().prepareStatement(sql);
            return ps.executeQuery();
        } catch (Exception e) {
            return null;
        }
        
    }
    
    public boolean UpdateAdmin(Admin ad) {
        try {
            ps = DataBaseConnector.getConnection().prepareStatement("UPDATE QUAN_TRI SET Password = ? where Ma_Admin = ?");
            ps.setString(2, ad.getMaAdmin());
            ps.setString(1, ad.getPassword());
            return ps.executeUpdate() >0;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean DeleteAdmin(String maAd) {
        try {
            ps = DataBaseConnector.getConnection().prepareStatement("DELETE FROM QUAN_TRI WHERE Ma_Admin = ?");
            ps.setString(1, maAd);
            return ps.executeUpdate() >0;
        } catch(Exception e) {
            return false;
        }
    }
}
