package Data;

import Object.DocGia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DocGiaData {
    public static PreparedStatement ps;
    public static ResultSet rs;
    
    public DocGia dangNhap(String taiKhoan, String pass) {
        DocGia kh = null;
        try {
            ps = DataBaseConnector.getConnection().prepareStatement("SELECT * FROM quanlythuvien.khach_hang where Ma_Khach_hang = ? and Mat_Khau = ?;");
            ps.setString(1, taiKhoan);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while(rs.next()) {
                kh = new DocGia();
//                kh.setMaKhachHang(rs.getString("Ma_Khach_hang"));
//                kh.setPassword(rs.getString("Password"));
                kh.setName(rs.getString("Ten_Khach_hang"));
                kh.setBirth(rs.getDate("Ngay_sinh"));
                kh.setDiaChi(rs.getString("Dia_chi"));
                kh.setPhone(rs.getString("SDT"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DocGiaData.class.getName()).log(Level.SEVERE, null, ex);
            return kh = null;
        }
        return kh;
    }
    public static ResultSet showTextfield(String sql) {
        try {
            ps = DataBaseConnector.getConnection().prepareStatement(sql);
            return ps.executeQuery();
        } catch (Exception e) {
            return null;
        }
    }
    
     public static void InsertKhachHang(DocGia kh) {
        String sql = "INSERT INTO `quanlythuvien`.`khach_hang` (`Ma_Khach_Hang`,`Mat_Khau`, `Ten_Khach_Hang`, `Ngay_sinh`, `Dia_Chi`, `SDT`)  values(?,?,?,?,?,?);";
        try {
            ps = DataBaseConnector.getConnection().prepareStatement(sql);
            ps.setString(1, kh.getMaKhachHang());
            ps.setString(2, kh.getPassword());
            ps.setString(3, kh.getName());
            ps.setDate(4, kh.getBirth());
            ps.setString(5, kh.getDiaChi());
            ps.setString(6, kh.getPhone());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Đã thêm khách hàng thành công!" , "Thông báo", 1);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Khách hàng không được thêm" , "Thông báo", 1);
        }
    }
    
    public boolean UpdateKhachHang(DocGia kh) {
        try {
            ps = DataBaseConnector.getConnection().prepareStatement("UPDATE `quanlythuvien`.`khach_hang` SET Password = ?, Ten_Khach_hang = ?,"
                    + "Ngay_sinh = ?, Dia_chi = ?, Phone = ? where Ma_Khach_hang = ?");
            ps.setString(6, kh.getMaKhachHang());
            ps.setString(1, kh.getPassword());
            ps.setString(2, kh.getName());
            ps.setDate(3, kh.getBirth());
            ps.setString(4, kh.getDiaChi());
            ps.setString(5, kh.getPhone());
            return ps.executeUpdate() >0;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean DeleteKhachHang(String maKH) {
        try {
            ps = DataBaseConnector.getConnection().prepareStatement("DELETE FROM `quanlythuvien`.`khach_hang` WHERE Ma_Khach_hang = ?");
            ps.setString(1, maKH);
            return ps.executeUpdate() >0;
        } catch(Exception e) {
            return false;
        }
    }
}
