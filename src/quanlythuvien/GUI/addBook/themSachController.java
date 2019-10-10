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
public class themSachController implements Initializable {

    @FXML
    private JFXButton btnLuu;
    @FXML
    private JFXButton btnHuy;
    
<<<<<<< HEAD:src/quanlythuvien/GUI/addBook/AddBookController.java
    DataBaseConnector databasehandler;
=======
    DBConnector databasehandler;
    @FXML
    private JFXTextField txtTenSach;
    @FXML
    private JFXTextField txtTacGia;
    @FXML
    private JFXTextField txtTheLoai;
    @FXML
    private JFXTextField txtNXB;
>>>>>>> d6e71583457c43741e45a9cc69fdc690a22d9f73:src/quanlythuvien/GUI/addBook/themSachController.java

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void themSach(ActionEvent event) {
        String id = txtTenSach.getText();
        String actor = txtTacGia.getText();
        String type = txtTheLoai.getText();
        String publisher = txtNXB.getText();
        
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
