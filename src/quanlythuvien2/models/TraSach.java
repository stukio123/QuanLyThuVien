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
public class TraSach {
    
    private int maTra;
    private int maMuon;
    private Date ngayTra;
    private int ngayTre;
    private double tienPhat;
    public TraSach(int maTra, int maMuon, Date ngay, int tre, double tien){
        this.maTra = maTra;
        this.maMuon = maMuon;
        this.ngayTra = ngay;
        this.ngayTre = tre;
        this.tienPhat = tien;
    }
    
    
    public TraSach(int maMuon, Date ngay, int tre, double tien){
        this.maMuon = maMuon;
        this.ngayTra = ngay;
        this.ngayTre = tre;
        this.tienPhat = tien;
    }

    /**
     * @return the maTra
     */
    public int getMaTra() {
        return maTra;
    }

    /**
     * @param maTra the maTra to set
     */
    public void setMaTra(int maTra) {
        this.maTra = maTra;
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
     * @return the ngayTra
     */
    public Date getNgayTra() {
        return ngayTra;
    }

    /**
     * @param ngayTra the ngayTra to set
     */
    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    /**
     * @return the ngayTre
     */
    public int getNgayTre() {
        return ngayTre;
    }

    /**
     * @param ngayTre the ngayTre to set
     */
    public void setNgayTre(int ngayTre) {
        this.ngayTre = ngayTre;
    }

    /**
     * @return the tienPhat
     */
    public double getTienPhat() {
        return tienPhat;
    }

    /**
     * @param tienPhat the tienPhat to set
     */
    public void setTienPhat(double tienPhat) {
        this.tienPhat = tienPhat;
    }
    
    
    
}
