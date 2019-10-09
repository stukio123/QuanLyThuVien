package quanlythuvien.GUI.addBook;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


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
    private JFXButton btnSave;
    @FXML
    private JFXButton btnCancel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addBook(ActionEvent event) {
    }

    @FXML
    private void Cancel(ActionEvent event) {
    }
    
}
