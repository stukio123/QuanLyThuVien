package Object;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Sach {
    private  String maSach;
    private  String tenSach;
    private  String tenTacGia;
    private  String nhaXB;
    private int giaTien;
    private int soLuong;
    
    public Sach(String maSach, String tenSach, String tenTacGia, String nhaXB, int giaTien, int soLuong) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tenTacGia = tenTacGia;
        this.nhaXB = nhaXB;
        this.giaTien = giaTien;
        this.soLuong = soLuong;
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
     * @return the tenTacGia
     */
    public String getTenTacGia() {
        return tenTacGia;
    }

    /**
     * @param tenTacGia the tenTacGia to set
     */
    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    /**
     * @return the nhaXB
     */
    public String getNhaXB() {
        return nhaXB;
    }

    /**
     * @param nhaXB the nhaXB to set
     */
    public void setNhaXB(String nhaXB) {
        this.nhaXB = nhaXB;
    }

    /**
     * @return the giaTien
     */
    public int getGiaTien() {
        return giaTien;
    }

    /**
     * @param giaTien the giaTien to set
     */
    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
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
