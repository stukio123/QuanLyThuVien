/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlythuvien2;

import Data.JdbcDocGia;
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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javax.swing.JOptionPane;
import quanlythuvien2.models.DocGia;
import quanlythuvien2.models.TheThuVien;

/**
 * FXML Controller class
 *
 * @author Tran Nguyen Anh
 */
public class FXMLThemDocGiaController implements Initializable {
    @FXML
    private JFXTextField txtMaDG;
    @FXML
    private JFXTextField txtTenDG;
    @FXML
    private JFXDatePicker txtNamSinh;
    @FXML
    private JFXTextField txtDiaChi;
    @FXML
    private JFXTextField txtSoThe;
    @FXML
    private JFXComboBox<Integer> cbSoThe;
    @FXML
    private JFXRadioButton rdNam;
    @FXML
    private JFXRadioButton rdNu;
    
    public void btThemHandler(ActionEvent event) throws ParseException, SQLException{

        

        Date d = Date.valueOf(this.txtNamSinh.getValue());
      JOptionPane.showMessageDialog(null, "fdgjkfdhgkhfdg", "Thông báo", 1);
        boolean gt = false;
        if (this.rdNam.isSelected()) gt = true;
        DocGia dg = new DocGia(this.txtMaDG.getText(), this.txtTenDG.getText(), gt,d,this.txtDiaChi.getText(),this.cbSoThe.getValue());
        
           JdbcDocGia.addDocGia(dg);
            
      
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            List<Integer> the = JdbcTheThuVien.getTheThuVien();
             this.cbSoThe.getItems().addAll(the);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (ParseException ex) {
            System.err.println(ex.getMessage());
        }
           
    }    
    
}
