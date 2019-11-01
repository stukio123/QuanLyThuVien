package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
        String sql = "SELECT * FROM SACH WHERE "+loai+" like N'%"+giatri+"%'";        
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
//     public static void main(String[] args) throws SQLException {
//       for(Sach a: getSach())
//            System.out.println(a.getTenSach());
//    }
}
