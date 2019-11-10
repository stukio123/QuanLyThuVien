/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlythuvien2.models;

import java.sql.Date;

/**
 *
 * @author Tran Nguyen Anh
 */
public class MuonSach {
    private int maThe;
    private String maSach;
    private Date ngayMuon;
    private int maMuon;
    private String isTra;
    
    public MuonSach(int the, String sach, Date ngay, String tra){
        this.maThe = the;
        this.maSach = sach;
        this.ngayMuon = ngay;
        this.isTra = tra;
    }
    
    public MuonSach(int mamuon, int the, String sach, Date ngay,String tra){
        
        this.maThe = the;
        this.maSach = sach;
        this.ngayMuon = ngay;
        this.maMuon = mamuon;
        this.isTra = tra;
    }

    /**
     * @return the maThe
     */
    public int getMaThe() {
        return maThe;
    }

    /**
     * @param maThe the maThe to set
     */
    public void setMaThe(int maThe) {
        this.maThe = maThe;
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
     * @return the maMuon
     */
    public int getMaMuon() {
        return maMuon;
    }

    /**
     * @param maMuon the maMuon to set
     */
    public void setMaMuon(int maMuon) {
        this.maMuon = maMuon;
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
     * @return the isTra
     */
    public String getIsTra() {
        return isTra;
    }

    /**
     * @param isTra the isTra to set
     */
    public void setIsTra(String isTra) {
        this.isTra = isTra;
    }
}
