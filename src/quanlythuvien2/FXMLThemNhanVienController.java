/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlythuvien2;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

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
    private JFXComboBox<Integer> cbMaTK;
    @FXML
    private JFXRadioButton rdNam;
    @FXML
    private JFXRadioButton rdNu;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
