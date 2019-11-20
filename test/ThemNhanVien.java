/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.text.ParseException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import quanlythuvien2.FXMLThemNhanVienController;

/**
 *
 * @author Admin
 */
public class ThemNhanVien {
    
    public ThemNhanVien() {
    }
    //    @Test
//    public void testTCNV6_10_13_16_19_25() throws ParseException{
//        FXMLThemNhanVienController nv = new FXMLThemNhanVienController(); 
//        
//        int actual = nv.themNhanVien("113", "Viet Tin", "Nam ", new java.sql.Date(21-05-1999), "Binh Dinh", 1);
//        int expected = 2;
//        Assert.assertEquals(expected, actual);
//    }
    @Test(expected = NumberFormatException.class)
    public void testTCNV1(){
        FXMLThemNhanVienController nv = new FXMLThemNhanVienController();
        nv.themNhanVien("111111111111", "Tri Quang", "Nam ", new java.sql.Date(07 - 10 - 1999), "Ca Mau", 1);
    }
    @Test(expected = NumberFormatException.class)
    public void testTCNV2_3_4_5_22_23_24() throws ParseException {
        FXMLThemNhanVienController nv = new FXMLThemNhanVienController();

        nv.themNhanVien("", "Viet Tin", "Nam ", new java.sql.Date(21 - 05 - 1999), "Binh Dinh", 1);
    }

    @Test
    public void testTCNV7() {
        FXMLThemNhanVienController nv = new FXMLThemNhanVienController();

        int actual = nv.themNhanVien("10", "Viet Tin", "Nam ", new java.sql.Date(21 - 05 - 1999), "Binh Dinh", 1);
        int expected = 4;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testTCNV8_11_17_20() {
        FXMLThemNhanVienController nv = new FXMLThemNhanVienController();

        int actual = nv.themNhanVien("11113", "Viet Tinnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn", "Nam ", new java.sql.Date(21 - 05 - 1999), "Binh Dinh", 1);
        int expected = 5;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testTCNV9_12_18_21() {
        FXMLThemNhanVienController nv = new FXMLThemNhanVienController();

        int actual = nv.themNhanVien("111112", "", "Nam ", new java.sql.Date(21 - 05 - 1999), "Binh Dinh", 1);
        int expected = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testTCNV14() {
        FXMLThemNhanVienController nv = new FXMLThemNhanVienController();

        int actual = nv.themNhanVien("111112", "tinn", "Nam ", new java.sql.Date(05 - 21 - 1999), "Binh Dinh", 1);
        int expected = 4;
        Assert.assertEquals(expected, actual);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
