/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlythuvien.GUI.addBook;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import quanlythuvien.GUI.dataBase.DataBaseConnector;
import quanlythuvien.model.Sach;

/**
 * FXML Controller class
 *
 * @author Kyo
 */
public class AddBookController implements Initializable {

    @FXML
    private JFXTextField tensach;
    @FXML
    private JFXTextField tacgia;
    @FXML
    private JFXTextField theloai;
    @FXML
    private JFXTextField nhaxuatban;
    @FXML
    private JFXButton btnLuu;
    @FXML
    private JFXButton btnHuy;
    
    DataBaseConnector databasehandler;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addBook(ActionEvent event) {
        String id = tensach.getText();
        String actor = tacgia.getText();
        String type = theloai.getText();
        String publisher = nhaxuatban.getText();
        
        if(id.isEmpty() || actor.isEmpty() || type.isEmpty() || publisher.isEmpty()) 
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng nhập đầy đủ thông tin");
            alert.showAndWait();    
            return;
        }
        Sach book = new Sach(id,actor,type,publisher,"1");
        boolean result = DataBaseConnector.insertNewBook(book);
        if (result) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Thành Công");
            alert.setContentText("Nhập sách: " + tensach + "thành công !");
            clearEntries();
            alert.showAndWait();
        } 
       
    }

    @FXML
    private void Cancel(ActionEvent event) {
    }
    private void clearEntries() {
        tensach.clear();
        tacgia.clear();
        theloai.clear();
        nhaxuatban.clear();
    }
}
