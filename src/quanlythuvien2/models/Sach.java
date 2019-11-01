/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlythuvien2.models;

/**
 *
 * @author Admin
 */
public class Sach {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private String theLoai;
    private String nxb;
    private int soLuong;
    
    public Sach(String ma,String ten,String tacgia,String theloai,String nxb,int sl){
        this.maSach=ma;
        this.tenSach=ten;
        this.tacGia=tacgia;
        this.theLoai=theloai;
        this.nxb=nxb;
        this.soLuong=sl;
    }
    /**
     * @return the maSach
     */
    public String getMaSach() {
        return maSach;
    }

    /**
     * @param maSach the maSach to set
     */
    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    /**
     * @return the tenSach
     */
    public String getTenSach() {
        return tenSach;
    }

    /**
     * @param tenSach the tenSach to set
     */
    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    /**
     * @return the tacGia
     */
    public String getTacGia() {
        return tacGia;
    }

    /**
     * @param tacGia the tacGia to set
     */
    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    /**
     * @return the theLoai
     */
    public String getTheLoai() {
        return theLoai;
    }

    /**
     * @param theLoai the theLoai to set
     */
    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    /**
     * @return the nxb
     */
    public String getNxb() {
        return nxb;
    }

    /**
     * @param nxb the nxb to set
     */
    public void setNxb(String nxb) {
        this.nxb = nxb;
    }

    /**
     * @return the soLuong
     */
    public int getSoLuong() {
        return soLuong;
    }

    /**
     * @param soLuong the soLuong to set
     */
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    
}
