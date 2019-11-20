/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Data.JdbcTaiKhoan;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import quanlythuvien2.FXMLDangNhapController;

/**
 *
 * @author Admin
 */
public class DangNhap {
    
    public DangNhap() {
    }
    
    @Before
    public void setUp() {
        
    }
    @After
    public void tearDown() {
    }
    @Test
    public void testTCDN1_2_3_5_6() throws SQLException{
        FXMLDangNhapController dn = new FXMLDangNhapController();
        int actual = dn.dangNhap("", "",JdbcTaiKhoan.getTaiKhoan(), true); 
        int expected = 1;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testTCDN7_16_QL() throws SQLException{
        FXMLDangNhapController dn = new FXMLDangNhapController();
        int actual = dn.dangNhap("admin", "admin",JdbcTaiKhoan.getTaiKhoan(), true); 
        int expected = 2;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testTCDN7_16_NV() throws SQLException{
        FXMLDangNhapController dn = new FXMLDangNhapController();
        int actual = dn.dangNhap("nhanvien", "nhanvien",JdbcTaiKhoan.getTaiKhoan(), false); 
        int expected = 3;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testTCDN17() throws SQLException{
        FXMLDangNhapController dn = new FXMLDangNhapController();
        int actual = dn.dangNhap("nhanvien", "nhanvien",JdbcTaiKhoan.getTaiKhoan(), true); 
        int expected = 4;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testTCDN18() throws SQLException{
        FXMLDangNhapController dn = new FXMLDangNhapController();
        int actual = dn.dangNhap("abcdef", "123456",JdbcTaiKhoan.getTaiKhoan(), false); 
        int expected = 5;
        Assert.assertEquals(expected, actual);
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
