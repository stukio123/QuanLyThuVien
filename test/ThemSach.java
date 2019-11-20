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
import quanlythuvien2.FXMLThemSachController;

/**
 *
 * @author Admin
 */
public class ThemSach {
    
    public ThemSach() {
    }
    @Test
    public void testTCS4_5_6() throws SQLException{
        FXMLThemSachController s = new FXMLThemSachController();
        int actual = s.themSach("", "", "", "", "", "");
        int expected = 1;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testTCS1() throws SQLException{
        FXMLThemSachController s = new FXMLThemSachController();
        int actual = s.themSach("qsqsqsqsqsqs", "", "", "", "", "");
        int expected = 2;
        Assert.assertEquals(expected, actual);
    }
//    @Test
//    public void testTCS3_14_15() throws SQLException{
//        FXMLThemSachController s = new FXMLThemSachController();
//        int actual = s.themSach("LT07", "zxc", "zxc", "ccc", "zxc", "110");
//        int expected = 3;
//        Assert.assertEquals(expected, actual);
//    }
    @Test
    public void testTCS7_8_9_10() throws SQLException{
        FXMLThemSachController s = new FXMLThemSachController();
        String ten ="nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn";
        String tg ="nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn";
        String tl ="nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn";
        String nxb ="nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn";
        int actual = s.themSach("mmm", ten, "zxc", "zxcc","mmmm","120");
        int expected = 2;
        Assert.assertEquals(expected, actual);
    }
    @Test(expected = NumberFormatException.class)
    public void testTCS11_12_13() throws SQLException{
        FXMLThemSachController s = new FXMLThemSachController();
        s.themSach("LT06", "zxc", "zxc", "ccc", "zxc", "Tin");

    }
    @Test
    public void testTCS() throws SQLException{
        FXMLThemSachController s = new FXMLThemSachController();
        int actual = s.themSach("tyu", "kkk", "iii", "ooo", "ppp", "-10");
        int expected = 4;
        Assert.assertEquals(expected, actual);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
