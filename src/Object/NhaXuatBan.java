/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

/**
 *
 * @author Kyo
 */
public class NhaXuatBan {
    private String maNXB;
    private String tenNXB;
    
    public NhaXuatBan() {
        
    }
    
    public NhaXuatBan(String maNXB, String tenNXB) {
        this.maNXB = maNXB;
        this.tenNXB = tenNXB;
    }

    /**
     * @return the maNXB
     */
    public String getMaNXB() {
        return maNXB;
    }

    /**
     * @param maNXB the maNXB to set
     */
    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }

    /**
     * @return the tenNXB
     */
    public String getTenNXB() {
        return tenNXB;
    }

    /**
     * @param tenNXB the tenNXB to set
     */
    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }
}
