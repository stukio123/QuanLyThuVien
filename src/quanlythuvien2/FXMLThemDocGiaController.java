/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlythuvien2;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import quanlythuvien2.models.DocGia;

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
    private JFXRadioButton rdNam;
    @FXML
    private JFXRadioButton rdNu;
    
    public void btThemHandler(ActionEvent event){
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        Date d = Date.valueOf(this.txtNamSinh.getValue());
        String nam = f.format(d);
        boolean gt = false;
        if (this.rdNam.isSelected()) gt = true;
//        DocGia dg = new DocGia(this.txtMaDG.getText(),this.txtTenDG.getText(),nam,gt,this.txtDiaChi.getText(),this.txtSoThe.getText());
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
