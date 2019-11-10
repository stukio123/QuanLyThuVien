package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import quanlythuvien2.models.Sach;

public class JdbcSach {

    public static List<Sach> getSach() throws SQLException {
        Connection conn = Jdbc.getConn();
        String sql = "SELECT * FROM sach";        
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        
        List<Sach> listSach = new ArrayList<>();
     
        while (rs.next()) {
            Sach s = new Sach(rs.getString("masach"), 
                    rs.getString("tensach"), rs.getString("tacgia"),rs.getString("theloai"),rs.getString("nhaxuatban"),rs.getInt("soluong"));
            listSach.add(s);
        }
        
        return listSach;
    }
    public static List<Sach> getSach(String loai,String giatri) throws SQLException {
        Connection conn = Jdbc.getConn();
        String sql = "SELECT * FROM sach WHERE "+loai+" like N'%"+giatri+"%'";        
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        
        List<Sach> listSach = new ArrayList<>();
     
        while (rs.next()) {
            Sach s = new Sach(rs.getString("masach"), 
                    rs.getString("tensach"), rs.getString("tacgia"),rs.getString("theloai"),rs.getString("nhaxuatban"),rs.getInt("soluong"));
            listSach.add(s);
        }
        return listSach;
    }
    public static List<Sach> getSach1(String giatri) throws SQLException {
        Connection conn = Jdbc.getConn();
        String sql = "SELECT * FROM sach WHERE masach like N'%"+giatri+"%'";        
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        
        List<Sach> listSach = new ArrayList<>();
     
        while (rs.next()) {
            Sach s = new Sach(rs.getString("masach"), 
                    rs.getString("tensach"), rs.getString("tacgia"),rs.getString("theloai"),rs.getString("nhaxuatban"),rs.getInt("soluong"));
            listSach.add(s);
        }
        return listSach;
    }
    
    
   
    

    public static void addSach(Sach a) throws SQLException{
        
        Connection conn = Jdbc.getConn();
        
        String sql ="INSERT INTO sach(masach,tensach,tacgia,theloai,nhaxuatban,soluong) VALUES(?,?,?,?,?,?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1,a.getMaSach());
        stm.setString(2,a.getTenSach());
        stm.setString(3,a.getTacGia());
        stm.setString(4,a.getTheLoai());
        stm.setString(5,a.getNxb());
        stm.setInt(6,a.getSoLuong());
        
        stm.executeUpdate();
        
        
        
    }
    
    
    
    public static void delSach(String a) throws SQLException{
        Connection conn = Jdbc.getConn();
        
        String sql="DELETE FROM sach WHERE masach = ?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1,a);
        System.out.println(sql);
        stm.executeUpdate();
        
    }
    
    
    
    public static PreparedStatement ps;
    public static boolean updateSach(Sach a){
        try {
            ps = Jdbc.getConn().prepareStatement("UPDATE sach SET  tensach = ?, tacgia = ?,"
                    + "theloai = ?, nhaxuatban = ?, soluong = ? where masach = ?");
            ps.setString(6, a.getMaSach());
            
            ps.setString(1, a.getTenSach());
            ps.setString(2, a.getTacGia());
            ps.setString(3, a.getTheLoai());
            ps.setString(4, a.getNxb());
            ps.setInt(5, a.getSoLuong());
            return ps.executeUpdate() >0;
        } catch (SQLException ex) {
            Logger.getLogger(JdbcSach.class.getName()).log(Level.SEVERE, null, ex);
        }
            return false;
    }
//     public static void main(String[] args) throws SQLException {
//       for(Sach a: getSach())
//            System.out.println(a.getTenSach());
//    }
}
