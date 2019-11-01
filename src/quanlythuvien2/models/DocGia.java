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
    private TheThuVien the;
    
    public DocGia(String ma,String ten,String nam,boolean gt,String diachi,int sothe) throws ParseException{
        this.maDG = ma;
        this.tenDG = ten;
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        this.namSinh = (Date) f.parse(nam);
        this.gioiTinh = gt;
        this.diaChi = diachi;
        
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
}
