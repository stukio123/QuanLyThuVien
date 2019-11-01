package quanlythuvien2;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import quanlythuvien2.models.Sach;

public class FXMLChinhSuaSachController  {
    
    @FXML
    private JFXButton btHuy;
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
    
    public  void setSach(Sach sach){
        txtMaSach.setText(sach.getMaSach());
        txtTenSach.setText(sach.getTenSach());
        txtTacGia.setText(sach.getTacGia());
        txtTheLoai.setText(sach.getTheLoai());
        txtNxb.setText(sach.getNxb());
        txtSoLuong.setText(String.valueOf(sach.getSoLuong()));
    }
    
    public void btHuyHandler(ActionEvent event){
        Stage stage = (Stage)btHuy.getScene().getWindow();
        stage.close();
     }
    
}
