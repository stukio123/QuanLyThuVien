/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import quanlythuvien2.FXMLThemDocGiaController;

/**
 *
 * @author Admin
 */
public class ThemDocGia {

    public ThemDocGia() {
    }

//    @Test
//    public void testTCDG6_10_13_16_19_25() throws ParseException{
//        FXMLThemDocGiaController dg = new FXMLThemDocGiaController(); 
//        
//        int actual = dg.themDocGia("113", "Viet Tin", "Nam ", new java.sql.Date(21-05-1999), "Binh Dinh", 1751010005);
//        int expected = 2;
//        Assert.assertEquals(expected, actual);
//    }
    @Test(expected = NumberFormatException.class)
    public void testTCDG1() {
        FXMLThemDocGiaController dg = new FXMLThemDocGiaController();
        dg.themDocGia("111111111111", "Tri Quang", "Nam ", new java.sql.Date(07 - 10 - 1999), "Ca Mau", 1751010043);
    }

    @Test(expected = NumberFormatException.class)
    public void testTCDG2_3_4_5_22_23_24() throws ParseException {
        FXMLThemDocGiaController dg = new FXMLThemDocGiaController();

        dg.themDocGia("", "Viet Tin", "Nam ", new java.sql.Date(21 - 05 - 1999), "Binh Dinh", 1751010005);
    }

    @Test
    public void testTCDG7() {
        FXMLThemDocGiaController dg = new FXMLThemDocGiaController();

        int actual = dg.themDocGia("10", "Viet Tin", "Nam ", new java.sql.Date(21 - 05 - 1999), "Binh Dinh", 1751010005);
        int expected = 4;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testTCDG8_11_17_20() {
        FXMLThemDocGiaController dg = new FXMLThemDocGiaController();

        int actual = dg.themDocGia("11113", "Viet Tinnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn", "Nam ", new java.sql.Date(21 - 05 - 1999), "Binh Dinh", 1751010005);
        int expected = 5;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testTCDG9_12_18_21() {
        FXMLThemDocGiaController dg = new FXMLThemDocGiaController();

        int actual = dg.themDocGia("111112", "", "Nam ", new java.sql.Date(21 - 05 - 1999), "Binh Dinh", 1751010005);
        int expected = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testTCDG14() {
        FXMLThemDocGiaController dg = new FXMLThemDocGiaController();

        int actual = dg.themDocGia("111112", "tinn", "Nam ", new java.sql.Date(05 - 21 - 1999), "Binh Dinh", 1751010005);
        int expected = 4;
        Assert.assertEquals(expected, actual);
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
