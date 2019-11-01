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
public class TaiKhoan {
    private String tk;
    private String mk;
    private boolean quyenDangNhap;
    public TaiKhoan(String tk,String mk,boolean quyen){
        this.tk=tk;
        this.mk=mk;
        this.quyenDangNhap=quyen;
    }

    /**
     * @return the tk
     */
    public String getTk() {
        return tk;
    }

    /**
     * @param tk the tk to set
     */
    public void setTk(String tk) {
        this.tk = tk;
    }

    /**
     * @return the mk
     */
    public String getMk() {
        return mk;
    }

    /**
     * @param mk the mk to set
     */
    public void setMk(String mk) {
        this.mk = mk;
    }

    /**
     * @return the quyenDangNhap
     */
    public boolean isQuyenDangNhap() {
        return quyenDangNhap;
    }

    /**
     * @param quyenDangNhap the quyenDangNhap to set
     */
    public void setQuyenDangNhap(boolean quyenDangNhap) {
        this.quyenDangNhap = quyenDangNhap;
    }
    
}
