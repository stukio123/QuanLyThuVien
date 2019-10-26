package GUI;

import Data.AdminData;
import Data.DocGiaData;
import Object.Admin;
import Object.DocGia;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
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
import javax.swing.JOptionPane;

public class DangNhapController implements Initializable {

    @FXML
    private JFXTextField txtTaiKhoan;
    
    @FXML
    private JFXPasswordField txtMatKhau;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void DangNhap(ActionEvent event){
        DocGiaData docgiadata = new DocGiaData();
        AdminData admindata= new AdminData();
        String taiKhoan = this.txtTaiKhoan.getText();
        String matKhau = this.txtMatKhau.getText();
        if(taiKhoan.isEmpty() || matKhau.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập tài khoản hoặc mật khẩu !", "Thông báo", 1);
        }
        else {
            DocGia dg = docgiadata.dangNhap(taiKhoan, matKhau);
            Admin ad = admindata.dangNhap(taiKhoan, matKhau);
            try{
                if(dg != null) {
                    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("TimSach.fxml"));
                    Parent ChucNang = loader.load();
                    Scene scene = new Scene(ChucNang);
                    stage.setScene(scene);
                    stage.show();
                }else if(ad != null) {
                    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("ChucNang.fxml"));
                    Parent ChucNang = loader.load();
                    Scene scene = new Scene(ChucNang);
                    stage.setScene(scene);
                    stage.show();
                }
                else JOptionPane.showMessageDialog(null, "Không tồn  tại tài khoản", "Thông báo", 1);
            }
            catch(Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }   
        }
    }
    
    public void Thoat (ActionEvent event){
        System.exit(0);
    }
    
    public void checkAdmin(ActionEvent event){
        txtTaiKhoan.setDisable(false);
        txtMatKhau.setDisable(false);
    }
    public void checkDocGia(ActionEvent event){
        txtTaiKhoan.setDisable(false);
        txtMatKhau.setDisable(false);
    }
}
