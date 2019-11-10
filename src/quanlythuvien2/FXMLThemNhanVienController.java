/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlythuvien2;

import Data.JdbcDocGia;
import Data.JdbcNhanVien;
import Data.JdbcTaiKhoan;
import Data.JdbcTheThuVien;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import quanlythuvien2.models.DocGia;
import quanlythuvien2.models.NhanVien;
import quanlythuvien2.models.TaiKhoan;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class FXMLThemNhanVienController implements Initializable {
    @FXML
    private JFXTextField txtTenNV;
    @FXML
    private JFXDatePicker txtNamSinh;
    @FXML
    private JFXTextField txtDiaChi;
    @FXML
    private JFXComboBox<String> cbMaTK;
    @FXML
    private JFXRadioButton rdNam;
    @FXML
    private JFXRadioButton rdNu;
    
    @FXML 
    private JFXTextField txtMaNV;

    @FXML
    private JFXButton btThem;
    @FXML
    private JFXButton btHuy;
    public void btThemHandler(ActionEvent event) throws ParseException, SQLException{

        
        int ma = 0;
        Date d = Date.valueOf(this.txtNamSinh.getValue());
        String gt = "Nữ";
        for(TaiKhoan tk: JdbcTaiKhoan.getTaiKhoan1()){
            if(tk.getTk().equals(this.cbMaTK.getValue())){
                ma = tk.getMatk();
   
            }
            
            
        }
        
            JOptionPane.showMessageDialog(null, ma, "Thông báo", 1);
        
        if (this.rdNam.isSelected()) gt = "Nam";
        NhanVien nv = new NhanVien(Integer.parseInt(this.txtMaNV.getText()),
                this.txtTenNV.getText(),gt,d,this.txtDiaChi.getText(),
                ma);
        
           JdbcNhanVien.addNhanVien(nv);
            
         Stage stage = (Stage)btThem.getScene().getWindow();
        stage.close();
    } 
    
    public void btHuyHandler(ActionEvent event){
        Stage stage = (Stage)btHuy.getScene().getWindow();
        stage.close();
     }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
      
       
        try {
            List<String> maTK = JdbcTaiKhoan.getTaiKhoan2();
             this.cbMaTK.getItems().addAll(maTK);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
           
    }    
        
    
}
