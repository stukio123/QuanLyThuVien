 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlythuvien2;

import com.jfoenix.controls.JFXButton;
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
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class FXMLTrangChinhController implements Initializable {
    @FXML
    private JFXButton btQLSach;
    
    @FXML
    private JFXButton btQLDocGia;
    @FXML
    private JFXButton btQLMuonSach;
    
    @FXML
    private JFXButton btQLTraSach;
    
    @FXML
    private JFXButton btQLThongKe;
   
    @FXML
    private JFXButton btQLNhanVien;
    
    
    public String tenChucNang = "QLSach"; 
    

    
    
    
    public void btQLSachHandler(ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLSach.fxml"));
        Parent ChucNang = loader.load();
        Scene scene = new Scene(ChucNang);
        stage.setScene(scene);
        stage.show();
        
       btQLSach.setOnMouseClicked(et -> {
       
           JOptionPane.showMessageDialog(null, this.tenChucNang, "Thông báo", 1);
       });
       
    }
    
    @FXML
    private JFXButton btDangXuat;
    public void btDangXuatHandler(ActionEvent event) throws IOException{
        
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLDangNhap.fxml"));
        Parent ChucNang = loader.load();
        Scene scene = new Scene(ChucNang);
        stage.setScene(scene);
        stage.show();
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
//        this.btQLSach.setOnMouseClicked(et->{
//            this.tenChucNang = "Quản Lý Sách";
//        });
//        
//        this.btQLDocGia.setOnMouseClicked(et->{
//            this.tenChucNang = "Quản Lý Độc Giả";
//        });
//        
//        this.btQLMuonSach.setOnMouseClicked(et->{
//            this.tenChucNang = "Quản Lý Mượn Sách";
//        });
//        
//        this.btQLTraSach.setOnMouseClicked(et->{
//            this.tenChucNang = "Quản Lý Trả Sách";
//        });
//        
//        this.btQLThongKe.setOnMouseClicked(et->{
//            this.tenChucNang = "Thống Kê";
//        });
//        this.btQLNhanVien.setOnMouseClicked(et->{
//            this.tenChucNang = "Quản Lý Nhân Viên";
//        });
//        
       
    }    
    
}
