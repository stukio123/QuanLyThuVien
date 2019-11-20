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

    public int themNhanVien(String ma, String ten, String gt, Date ns, String dc, int matk) {
        int kq = 0;
        try {
            NhanVien nv = new NhanVien(Integer.parseInt(ma), ten, gt, ns, dc, matk);
            if (ma.equals("") || ten.equals("") || gt.equals("") || dc.equals("")) {
                kq = 1;
            } else {

                JdbcNhanVien.addNhanVien(nv);
                kq = 2;
            }
        }
        catch (SQLException ex) {
            kq = 4;
        }
        catch(NumberFormatException ex){
            kq = 6;
        }
        if (ma.length() > 11 || ten.length() > 45 || gt.length() > 4 || dc.length() > 45) {
            kq = 5;
        }
        return kq;
    }

    public void btThemHandler(ActionEvent event) throws ParseException, SQLException {
        int ma = 0;
        Date ns = Date.valueOf(this.txtNamSinh.getValue());
        String gt = "Nữ";
        if (rdNam.isSelected()) {
            gt = "Nam";
        }
        for (TaiKhoan tk : JdbcTaiKhoan.getTaiKhoan1()) {
            if (tk.getTk().equals(this.cbMaTK.getValue())) {
                ma = tk.getMatk();
            }
        }
        int kq = themNhanVien(txtMaNV.getText(), txtTenNV.getText(), gt, ns, txtDiaChi.getText(), ma);
        System.err.println("kq");
        if (kq == 2) {
            this.txtMaNV.clear();
            this.txtTenNV.clear();
            this.txtDiaChi.clear();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Thông báo ");
            alert.setHeaderText("");
            alert.setContentText("Thêm thành công!");
            alert.showAndWait();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi ");
            alert.setHeaderText("");
            alert.setContentText("Vui lòng nhập đúng thông tin!");
            alert.showAndWait();
        }  
    }

    public void btHuyHandler(ActionEvent event) {
        Stage stage = (Stage) btHuy.getScene().getWindow();
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
