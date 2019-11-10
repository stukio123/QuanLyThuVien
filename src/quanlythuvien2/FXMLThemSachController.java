package quanlythuvien2;

import Data.JdbcSach;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import quanlythuvien2.models.Sach;

public class FXMLThemSachController implements Initializable {
    
    @FXML
    private JFXTextField txtMaSach;
    @FXML
    private JFXTextField txtTenSach;
    @FXML
    private JFXTextField txtTacGia;
    @FXML
    private JFXTextField txtTheLoai;
    @FXML
    private JFXTextField txtNxb;
    @FXML
    private JFXTextField txtSoLuong;
    @FXML
    private JFXButton btThem;
    @FXML
    private JFXButton btHuy;
    
    public void btThemHandler(ActionEvent event) throws SQLException, IOException{

        try {
            Sach s = new Sach(this.txtMaSach.getText(),this.txtTenSach.getText(),
                    this.txtTacGia.getText(),this.txtTheLoai.getText(),
                    this.txtNxb.getText(),Integer.parseInt(this.txtSoLuong.getText()));
            JdbcSach.addSach(s);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Thêm sách thành công !!");
            alert.show();
            txtMaSach.clear();
            txtTenSach.clear();
            txtTacGia.clear();
            txtTheLoai.clear();
            txtNxb.clear();
            txtSoLuong.clear();
            //Stage stage = (Stage)btThem.getScene().getWindow();
            //stage.close();
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Thêm  thất bại, lý do: " + ex.getMessage());
            alert.show();
        }
    }
    
     public void btHuyHandler(ActionEvent event){
        Stage stage = (Stage)btHuy.getScene().getWindow();
        stage.close();
     }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
