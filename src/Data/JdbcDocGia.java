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
import javafx.scene.control.Alert;
import quanlythuvien2.models.DocGia;
import quanlythuvien2.models.NhanVien;

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
            s = new DocGia(rs.getInt("madocgia"), 
                    rs.getString("tendocgia"), rs.getString("gioitinh"),rs.getDate("namsinh"),
                    rs.getString("diachi"),rs.getInt("sothe"));
  
            listDG.add(s);
        }
        return listDG;
    }
    
    public static List<DocGia> getDG(String loai,String giatri) throws SQLException, ParseException {
        Connection conn = Jdbc.getConn();
        String sql = "SELECT * FROM docgia WHERE "+loai+" like N'%"+giatri+"%'";        
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        
        List<DocGia> list = new ArrayList<>();
     
        while (rs.next()) {
            DocGia s = new DocGia(rs.getInt("madocgia"), rs.getString("tendocgia"), rs.getString("gioitinh")
                    , rs.getDate("namsinh"), rs.getString("diachi"), rs.getInt("sothe"));
            list.add(s);
        }
        return list;
    }
    
    public static List<DocGia> getDG(String giatri) throws SQLException, ParseException {
        Connection conn = Jdbc.getConn();
        String sql = "SELECT * FROM docgia WHERE madocgia like N'%"+giatri+"%'";        
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        
        List<DocGia> list = new ArrayList<>();
     
        while (rs.next()) {
            DocGia s = new DocGia(rs.getInt("madocgia"), rs.getString("tendocgia"), rs.getString("gioitinh")
                    , rs.getDate("namsinh"), rs.getString("diachi"), rs.getInt("sothe"));
            list.add(s);
        }
        return list;
    }

    public static void addDocGia(DocGia dg) throws SQLException{
        Connection conn = Jdbc.getConn();
        
        String sql ="INSERT INTO docgia(madocgia,tendocgia,gioitinh,namsinh,diachi,sothe) VALUES(?,?,?,?,?,?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1,dg.getMaDG());
        stm.setString(2,dg.getTenDG());
        stm.setString(3,dg.isGioiTinh());
        stm.setDate(4,dg.getNamSinh());
        stm.setString(5,dg.getDiaChi());
        stm.setInt(6,dg.getSoThe());
        
        stm.executeUpdate();
    }
    
    
    
    public static void delDG(int a) throws SQLException{
        Connection conn = Jdbc.getConn();
        
        String sql="DELETE FROM docgia WHERE madocgia = ?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1,a);
        System.out.println(sql);
        stm.executeUpdate();
        
    }
    public static PreparedStatement ps;
    public static boolean updateDocGia(DocGia a){
        try {
            ps = Jdbc.getConn().prepareStatement("UPDATE docgia SET  tendocgia = ?, gioitinh = ?,"
                    + "namsinh = ?, diachi = ?,sothe =? where madocgia = ?");
            ps.setInt(6, a.getMaDG());
            
            ps.setString(1, a.getTenDG());
            ps.setString(2, a.isGioiTinh());
            ps.setDate(3, a.getNamSinh());
            ps.setString(4, a.getDiaChi());
            ps.setInt(5, a.getSoThe());
            return ps.executeUpdate() >0;
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Lưu thất bại, lý do: " + ex.getMessage());
            alert.show();
            return false;
        }catch(Exception ex)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Lưu thất bại, lý do: " + ex.getMessage());
            alert.show();
            return false;
        }
            
    }
}
