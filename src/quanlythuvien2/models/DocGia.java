/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlythuvien2.models;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Admin
 */
public class DocGia {
    private String maDG;
    private String tenDG;
    private Date namSinh;
    private boolean gioiTinh;
    private String diaChi;
    private int soThe;
    public DocGia(String ma,String ten,boolean gt,Date nam,String diachi,int sothe) throws ParseException{
        this.maDG = ma;
        this.tenDG = ten;
       
        this.namSinh = nam;
        this.gioiTinh = gt;
        this.diaChi = diachi;
        this.soThe = sothe;
    }
    public DocGia(String ma,String ten,int the){
        this.maDG = ma;
        this.tenDG = ten;
        this.soThe = the;
    }

    /**
     * @return the maDG
     */
    public String getMaDG() {
        return maDG;
    }

    /**
     * @param maDG the maDG to set
     */
    public void setMaDG(String maDG) {
        this.maDG = maDG;
    }

    /**
     * @return the tenDG
     */
    public String getTenDG() {
        return tenDG;
    }

    /**
     * @param tenDG the tenDG to set
     */
    public void setTenDG(String tenDG) {
        this.tenDG = tenDG;
    }

    /**
     * @return the namSinh
     */
    public Date getNamSinh() {
        return namSinh;
    }

    /**
     * @param namSinh the namSinh to set
     */
    public void setNamSinh(Date namSinh) {
        this.namSinh = namSinh;
    }

    /**
     * @return the gioiTinh
     */
    public boolean isGioiTinh() {
        return gioiTinh;
    }

    /**
     * @param gioiTinh the gioiTinh to set
     */
    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    /**
     * @return the diaChi
     */
    public String getDiaChi() {
        return diaChi;
    }

    /**
     * @param diaChi the diaChi to set
     */
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    /**
     * @return the soThe
     */
    public int getSoThe() {
        return soThe;
    }

    /**
     * @param soThe the soThe to set
     */
    public void setSoThe(int soThe) {
        this.soThe = soThe;
    }
}
