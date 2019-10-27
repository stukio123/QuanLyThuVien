package Data;

import Object.Sach;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class SachData {
    public static PreparedStatement ps;
    public static ResultSet rs;
    
    public static ResultSet showTextfield(String sql) {
        try {
            ps = DataBaseConnector.getConnection().prepareStatement(sql);
            return ps.executeQuery();
        } catch (Exception e) {
            return null;
        }
    }
    
     public static void InsertSach(Sach s) {
        String sql = "insert into `quanlythuvien`.`sach` values(?,?,?,?,?,?)";
        try {
            ps = DataBaseConnector.getConnection().prepareStatement(sql);
            ps.setString(1, s.getMaSach());
            ps.setString(2, s.getTenSach());
            ps.setString(3, s.getTenTacGia());
            ps.setString(4, s.getNhaXB());
            ps.setInt(5, s.getGiaTien());
            ps.setInt(6, s.getSoLuong());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Đã thêm sách thành công!" , "Thông báo", 1);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Sach không được thêm" , "Thông báo", 1);
        }
    }
    
    public boolean UpdateSach(Sach s) {
        try {
            ps = DataBaseConnector.getConnection().prepareStatement("UPDATE SACH SET  Ten_Sach = ?, Ten_Tac_gia = ?,"
                    + "Nha_xb = ?, Gia_tien = ?, So_luong = ? where Ma_Sach = ?");
            ps.setString(6, s.getMaSach());
            ps.setString(1, s.getTenSach());
            ps.setString(2, s.getTenTacGia());
            ps.setString(3, s.getNhaXB());
            ps.setInt(4, s.getGiaTien());
            ps.setInt(5, s.getSoLuong());
            return ps.executeUpdate() >0;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean DeleteSach(String ms) {
        try {
            ps = DataBaseConnector.getConnection().prepareStatement("DELETE FROM SACH WHERE Ma_Sach = ?");
            ps.setString(1, ms);
            return ps.executeUpdate() >0;
        } catch(Exception e) {
            return false;
        }
    }
}
