/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.scene.control.TableView;
import javax.swing.JOptionPane;

import net.proteanit.sql.DbUtils;

/**
 *
 * @author Kyo
 */
public class UpdateTable {
    public static PreparedStatement ps = null;
    public static ResultSet rs = null;
    public static Connection con = DataBaseConnector.getConnection();
    
    public static void LoadData (String sql,TableView tb) {
//        try{
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//            tb.setItems((DbUtils.resultSetToTableModel(rs)));
//        }
//        catch(Exception e) {
//            JOptionPane.showMessageDialog(null, e ,"Thông báo lỗi",1);
//        }
    }
    
    public static ResultSet ShowTextField(String sql) {
        try{
            ps = con.prepareStatement(sql);
            return ps.executeQuery(); 
        }
        catch(Exception e) {
            return null;
            //JOptionPane.showMessageDialog(null, e, "Thông báo lỗi", 1);
        }
    }
}
