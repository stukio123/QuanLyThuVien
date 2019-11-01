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
public class TheThuVien {
    private int soThe;
    private Date ngayBatDau;
    private Date ngayKetThuc;

    public TheThuVien(int so,String ngaybd,String ngaykt) throws ParseException{
        this.soThe = so;
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyy");
        this.ngayBatDau = (Date) f.parse(ngaybd);
        this.ngayKetThuc = (Date) f.parse(ngaykt);
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

    /**
     * @return the ngayBatDau
     */
    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    /**
     * @param ngayBatDau the ngayBatDau to set
     */
    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    /**
     * @return the ngayKetThuc
     */
    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    /**
     * @param ngayKetThuc the ngayKetThuc to set
     */
    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
}
