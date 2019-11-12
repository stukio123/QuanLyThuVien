package quanlythuvien2;

import Data.JdbcTaiKhoan;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import quanlythuvien2.models.TaiKhoan;

public class FXMLDangNhapController implements Initializable {
    @FXML
    private JFXTextField txtTaiKhoan;
    @FXML
    private JFXPasswordField txtMatKhau;
    @FXML
    private JFXRadioButton rdQuanLy;
    @FXML
    private JFXRadioButton rdNhanVien;
    @FXML
    private JFXButton btDangNhap;
    @FXML
    private JFXButton btThoat;

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void btDangNhapHandler(ActionEvent event)  {
        boolean ktQuyen = true;
        boolean kq = false;
        try{
            if(this.txtTaiKhoan.getText().trim().length() == 0 || this.txtMatKhau.getText().trim().length() == 0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Tên tài khoản và mật khẩu không được để trống");
            }
            else{
            if(!this.rdQuanLy.isSelected()) ktQuyen = false;
                TaiKhoan tk = new TaiKhoan(this.txtTaiKhoan.getText().trim(),this.txtMatKhau.getText().trim(),ktQuyen);
            for (TaiKhoan a : JdbcTaiKhoan.getTaiKhoan()){
                if(tk.getTk().equals(a.getTk()) && (tk.getMk().equals(a.getMk())) && (tk.isQuyenDangNhap() == a.isQuyenDangNhap()) ){
                    kq = true;
                }
            }
            if (kq == true){
                if(tk.isQuyenDangNhap()){
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("FXMLSach.fxml"));
                Parent ChucNang = loader.load();
                Scene scene = new Scene(ChucNang);
                stage.setScene(scene);
                stage.show();
                }else{
                    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("FXMLSachNhanVien.fxml"));
                Parent ChucNang = loader.load();
                Scene scene = new Scene(ChucNang);
                stage.setScene(scene);
                stage.show();
                }}
            else JOptionPane.showMessageDialog(null, "Không tồn  tại tài khoản", "Thông báo", 1);
        }
        }catch(SQLException | IOException ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Không thể kết nối đến server ");
        }
        
    }
    

    public void btThoatHandler(ActionEvent event) throws IOException{
        
        Stage stage = (Stage)btThoat.getScene().getWindow();
        stage.close();

    }
}