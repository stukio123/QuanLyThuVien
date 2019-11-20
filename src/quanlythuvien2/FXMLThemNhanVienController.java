package quanlythuvien2;

import Data.JdbcNhanVien;
import Data.JdbcTaiKhoan;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import quanlythuvien2.models.NhanVien;
import quanlythuvien2.models.TaiKhoan;

public class FXMLThemNhanVienController implements Initializable {
    @FXML
    private JFXTextField txtTenNV;
    @FXML
    private JFXDatePicker txtNamSinh;
    @FXML
    private JFXTextField txtDiaChi;
    @FXML
    private JFXComboBox<String> cbMaTK;
    @FXML
    private JFXRadioButton rdNam;
    @FXML
    private JFXRadioButton rdNu;
    @FXML 
    private JFXTextField txtMaNV;
    @FXML
    private JFXButton btThem;
    @FXML
    private JFXButton btHuy;
    
    public boolean themNV(){
        int ma = 0;
        Date d = Date.valueOf(this.txtNamSinh.getValue());
        String gt = "Nữ";
        try {
            for(TaiKhoan tk: JdbcTaiKhoan.getTaiKhoan1()){
                if(tk.getTk().equals(this.cbMaTK.getValue())){
                    ma = tk.getMatk();
                }
            }
            if (this.rdNam.isSelected()) gt = "Nam";
            NhanVien nv = new NhanVien(Integer.parseInt(this.txtMaNV.getText()),
                    this.txtTenNV.getText(),gt,d,this.txtDiaChi.getText(),
                    ma);
            JdbcNhanVien.addNhanVien(nv);
            return true;
        } catch (SQLException | NumberFormatException ex) {
            Logger.getLogger(FXMLThemNhanVienController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    public void btThemHandler(ActionEvent event) throws ParseException, SQLException{
        if(themNV()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Thành Công");
            alert.setContentText("Thêm nhân viên thành công");
            alert.showAndWait();
            Stage stage = (Stage)btThem.getScene().getWindow();
            stage.close();
        }else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Thất Bại");
            alert.setContentText("Lỗi khi thêm nhân viên\n");
            alert.show();
        }
    } 
    
    public void btHuyHandler(ActionEvent event){
        Stage stage = (Stage)btHuy.getScene().getWindow();
        stage.close();
     }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            List<String> maTK = JdbcTaiKhoan.getTaiKhoan2();
             this.cbMaTK.getItems().addAll(maTK);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
           
    }    
        
    
}
