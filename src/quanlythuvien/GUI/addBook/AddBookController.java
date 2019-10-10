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
import quanlythuvien.GUI.dataBase.DBConnector;

/**
 * FXML Controller class
 *
 * @author Kyo
 */
public class AddBookController implements Initializable {

    @FXML
    private JFXTextField idBook;
    @FXML
    private JFXTextField actorBook;
    @FXML
    private JFXTextField typeBook;
    @FXML
    private JFXTextField publisherBook;
    @FXML
    private JFXButton btnAdd;
    @FXML
    private JFXButton btnCancel;
    
    DBConnector databasehandler;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addBook(ActionEvent event) {
        String id = idBook.getText();
        String actor = actorBook.getText();
        String type = typeBook.getText();
        String publisher = publisherBook.getText();
        
        if(id.isEmpty() || actor.isEmpty() || type.isEmpty() || publisher.isEmpty()) 
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng nhập đầy đủ thông tin");
            alert.showAndWait();    
            return;
        }
        String query = "INSERT INTO sach VALUES ("+
                "'" + id +"'"+
                "'" + actor + "'" +
                "'" + type + "'" +
                "'" + publisher + "'" +
                " " + true + " " +")";
        System.out.print(query);
        if(databasehandler.execAction(query))
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Thêm Thành công !");
            alert.showAndWait(); 
        }else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Lỗi");
            alert.showAndWait(); 
        }
    }

    @FXML
    private void Cancel(ActionEvent event) {
    }
    
}
