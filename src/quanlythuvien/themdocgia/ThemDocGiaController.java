/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlythuvien.themdocgia;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import quanlythuvien.GUI.dataBase.DBConnector;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class ThemDocGiaController implements Initializable {
    DBConnector databasehandler;
    @FXML
    private JFXTextField txtTenDocGia;
    @FXML
    private JFXTextField txtGioiTinh;
    @FXML
    private JFXTextField txtDiaChi;
    @FXML
    private JFXTextField txtSoThe;
    @FXML
    private JFXButton btnLuu;
    @FXML
    private JFXButton btnHuy;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void themDocGiaHandler(ActionEvent event) {
        String ten = txtTenDocGia.getText();
        String gioitinh = txtGioiTinh.getText();
        String diachi = txtDiaChi.getText();
        String sothe = txtSoThe.getText();
        
        if(ten.isEmpty() || gioitinh.isEmpty() || diachi.isEmpty() || sothe.isEmpty()) 
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng nhập đầy đủ thông tin");
            alert.showAndWait();    
            return;
        }
        
        String query = "INSERT INTO docgia VALUES ("+
                "'" + ten +"'"+
                "'" + gioitinh + "'" +
                "'" + diachi + "'" +
                "'" + sothe + "'" +
                " " + true + " " +")";
        System.out.print(query);
    }
    
    @FXML
    private void cancelHandler(ActionEvent event) {
    }

    
}
