package quanlythuvien2.models;

import java.sql.Date;

public class NhanVien {
   private String tenNV;
   private String gioiTinh;
   private Date ngaySinh;
   private String diaChi;
   private int maTK;

   private int maNV;
    public NhanVien(int ma,String nv,String gt,Date ns,String dc,int matk){
       this.tenNV = nv;
       this.maNV = ma;
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

    /**
     * @return the maNV
     */
    public int getMaNV() {
        return maNV;
    }

    /**
     * @param maNV the maNV to set
     */
    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    /**
     * @return the gioiTinh
     */
    public String getGioiTinh() {
        return gioiTinh;
    }

    /**
     * @param gioiTinh the gioiTinh to set
     */
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
   
}
