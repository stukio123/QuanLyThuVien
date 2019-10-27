package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ChucNangController implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void CapNhat(ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AdminCapNhat.fxml"));
        Parent ChucNang = loader.load();
        Scene scene = new Scene(ChucNang);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void quayLai(ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("DangNhap.fxml"));
        Parent ChucNang = loader.load();
        Scene scene = new Scene(ChucNang);
        stage.setScene(scene);
        stage.show();
    }
}
