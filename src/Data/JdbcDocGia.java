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
import quanlythuvien2.models.DocGia;

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
}
