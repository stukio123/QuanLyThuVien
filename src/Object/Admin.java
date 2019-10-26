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
public class Admin {
    
    private String maAdmin;
    private String password;
    
    public Admin() {
        
    }
    public Admin(String maAdmin, String password) {
        this.maAdmin = maAdmin;
        this.password = password;
    }

    /**
     * @return the maAdmin
     */
    public String getMaAdmin() {
        return maAdmin;
    }

    /**
     * @param maAdmin the maAdmin to set
     */
    public void setMaAdmin(String maAdmin) {
        this.maAdmin = maAdmin;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
