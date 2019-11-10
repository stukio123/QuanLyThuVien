package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import quanlythuvien2.models.NhanVien;

public class JdbcNhanVien {
    public static List<NhanVien> getNV() throws SQLException, ParseException {
        Connection conn = Jdbc.getConn();
        String sql = "SELECT * FROM nhanvien";        
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        
        List<NhanVien> listNV = new ArrayList<>();
        String a = "";
        while (rs.next()) {
            NhanVien s = new NhanVien(rs.getInt("manv"),rs.getString("hoten"),rs.getString("gioitinh")
                    ,rs.getDate("namsinh"),
                    rs.getString("diachi"),rs.getInt("matk"));
            listNV.add(s);
        }
        
        
        
        return listNV;
    }
    
    
    
    public static void addNhanVien(NhanVien nv) throws SQLException{
        Connection conn = Jdbc.getConn();
        
        String sql ="INSERT INTO nhanvien(manv,hoten,gioitinh,namsinh,diachi,matk) VALUES(?,?,?,?,?,?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1,nv.getMaNV());
        stm.setString(2,nv.getTenNV());
        stm.setString(3,nv.getGioiTinh());
        stm.setDate(4,nv.getNgaySinh());
        stm.setString(5,nv.getDiaChi());
        stm.setInt(6,nv.getMaTK());
        
        stm.executeUpdate();
    }
    
    
    
    public static void delNhanVien(int a) throws SQLException{
        Connection conn = Jdbc.getConn();
        
        String sql="DELETE FROM nhanvien WHERE manv = ?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1,a);
        System.out.println(sql);
        stm.executeUpdate();
        
    }
    
    
    
    public static List<NhanVien> getNV(String giatri) throws SQLException, ParseException {
        Connection conn = Jdbc.getConn();
        String sql = "SELECT * FROM nhanvien WHERE manv like N'%"+giatri+"%'";        
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        
        List<NhanVien> list = new ArrayList<>();
     
        while (rs.next()) {
            NhanVien s = new NhanVien(rs.getInt("manv"), rs.getString("hoten"), rs.getString("gioitinh")
                    , rs.getDate("namsinh"), rs.getString("diachi"), rs.getInt("matk"));
            list.add(s);
        }
        return list;
    }
}
