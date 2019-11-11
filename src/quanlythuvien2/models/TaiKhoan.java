package quanlythuvien2.models;



public class TaiKhoan {
    private String tk;
    private String mk;
    private int matk;
    private boolean quyenDangNhap;
    public TaiKhoan(String tk,String mk,boolean quyen){
        this.tk=tk;
        this.mk=mk;
        this.quyenDangNhap=quyen;
    }
    
    public TaiKhoan(int matk, String tk){
        
        this.matk = matk;
        this.tk=tk;
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

    /**
     * @return the matk
     */
    public int getMatk() {
        return matk;
    }

    /**
     * @param matk the matk to set
     */
    public void setMatk(int matk) {
        this.matk = matk;
    }
    
}
