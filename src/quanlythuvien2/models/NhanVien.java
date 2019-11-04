/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlythuvien2.models;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class NhanVien {
   private String tenNV;
   private boolean gioiTinh;
   private Date ngaySinh;
   private String diaChi;
   private int maTK;

   public NhanVien(String nv,boolean gt,Date ns,String dc,int matk){
       this.tenNV = nv;
       this.gioiTinh = gt;
       this.ngaySinh = ns;
       this.diaChi = dc;
       this.maTK = matk;
   }
    /**
     * @return the tenNV
     */
    public String getTenNV() {
        return tenNV;
    }

    /**
     * @param tenNV the tenNV to set
     */
    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
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
     * @return the ngaySinh
     */
    public Date getNgaySinh() {
        return ngaySinh;
    }

    /**
     * @param ngaySinh the ngaySinh to set
     */
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
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
     * @return the maTK
     */
    public int getMaTK() {
        return maTK;
    }

    /**
     * @param maTK the maTK to set
     */
    public void setMaTK(int maTK) {
        this.maTK = maTK;
    }
   
}
