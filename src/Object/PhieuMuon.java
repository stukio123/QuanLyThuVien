/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import java.sql.Date;

/**
 *
 * @author Kyo
 */
public class PhieuMuon {
    private String maMuon;
    private String maKhach;
    private String maSach;
    private Date ngayMuon;
    private Date hanTra;
    
    public PhieuMuon() {
        
    }
    
    public PhieuMuon(String maMuon, String maKhach, String maSach, Date ngayMuon, Date hanTra) {
        this.maMuon = maMuon;
        this.maKhach = maKhach;
        this.maSach = maSach;
        this.ngayMuon = ngayMuon;
        this.hanTra = hanTra;
    }

    /**
     * @return the maMuon
     */
    public String getMaMuon() {
        return maMuon;
    }

    /**
     * @param maMuon the maMuon to set
     */
    public void setMaMuon(String maMuon) {
        this.maMuon = maMuon;
    }

    /**
     * @return the maKhach
     */
    public String getMaKhach() {
        return maKhach;
    }

    /**
     * @param maKhach the maKhach to set
     */
    public void setMaKhach(String maKhach) {
        this.maKhach = maKhach;
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
     * @return the ngayMuon
     */
    public Date getNgayMuon() {
        return ngayMuon;
    }

    /**
     * @param ngayMuon the ngayMuon to set
     */
    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    /**
     * @return the hanTra
     */
    public Date getHanTra() {
        return hanTra;
    }

    /**
     * @param hanTra the hanTra to set
     */
    public void setHanTra(Date hanTra) {
        this.hanTra = hanTra;
    }
}
