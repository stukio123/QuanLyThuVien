/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import quanlythuvien2.FXMLSachController;

/**
 *
 * @author Admin
 */
public class Sach {
    
    public Sach() {
    }
    @Test
    public void testTCS16_17(){
        FXMLSachController s = new FXMLSachController();
        int actual = s.suaSach("TH-10", "", "Trương Hoàng Vinh", "Giáo Trình", "DDH Mở", "50");
        int expected = 1;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testTCS18_19_20_21(){
        FXMLSachController s = new FXMLSachController();
        int actual = s.suaSach("TH-10", "Xử lý ảnhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh", "Trương Hoàng Vinh", "Giáo Trình", "DDH Mở", "50");
        int expected = 3;
        Assert.assertEquals(expected, actual);
    }
    @Test(expected = NumberFormatException.class)
    public void testTCS22_23_24(){
        FXMLSachController s = new FXMLSachController();
        s.suaSach("TH-10", "Xử Lý Ảnh", "Trương Hoàng Vinh", "Giáo Trình", "DDH Mở", "aaaa");
    }
    @Test
    public void testTCS25_26(){
        FXMLSachController s = new FXMLSachController();
        int actual = s.suaSach("TH-10", "Toán Tin Học", "Trương Hoàng Vinh", "Giáo Trình", "DH Mở", "50");
        int expected = 2;
        Assert.assertEquals(expected, actual);
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
