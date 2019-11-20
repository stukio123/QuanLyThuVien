package quanlythuvien2;

import Data.JdbcDocGia;
import Data.JdbcTheThuVien;
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
import quanlythuvien2.models.DocGia;

public class FXMLThemDocGiaController implements Initializable {

    @FXML
    private JFXTextField txtMaDG;
    @FXML
    private JFXTextField txtTenDG;
    @FXML
    private JFXDatePicker txtNamSinh;
    @FXML
    private JFXTextField txtDiaChi;
    @FXML
    private JFXTextField txtSoThe;
    @FXML
    private JFXComboBox<Integer> cbSoThe;
    @FXML
    private JFXRadioButton rdNam;
    @FXML
    private JFXRadioButton rdNu;
    @FXML
    private JFXButton btThem;
    @FXML
    private JFXButton btHuy;

    public int themDocGia(String ma, String ten, String gt, Date ns, String dc, int soThe) {
        int kq = 0;
        
        
            try {
                DocGia dg = new DocGia(Integer.parseInt(ma), ten, gt, ns, dc, soThe);
                if (ma.equals("") || ten.equals("") || gt.equals("") || dc.equals("")) 
            kq = 1;
                else{
                JdbcDocGia.addDocGia(dg);
                kq = 2;
                }
            } catch (ParseException ex) {
                kq = 3;
            }catch (NumberFormatException ex){
                kq = 6;
            } 
            catch (SQLException ex) {
                kq = 4;
            }
        
        if (ma.length()>11 || ten.length()>45 || gt.length()>4 || dc.length() > 45 ) kq = 5; 
        
        return kq;
    }

    public void btThemHandler(ActionEvent event) {
        Date d = Date.valueOf(this.txtNamSinh.getValue());
        String gt = "Nữ";
        if (this.rdNam.isSelected()) {
            gt = "Nam";
        }
        int kq = themDocGia(this.txtMaDG.getText(), this.txtTenDG.getText(),
                gt, d, this.txtDiaChi.getText(), this.cbSoThe.getValue());
         if (kq == 2) {
            this.txtMaDG.clear();
            this.txtTenDG.clear();
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
//        try{
//            Date d = Date.valueOf(this.txtNamSinh.getValue());
//            String gt = "Nữ";
//            if (this.rdNam.isSelected()) gt = "Nam";
//            DocGia dg = new DocGia(Integer.parseInt(this.txtMaDG.getText()), 
//                    this.txtTenDG.getText(), gt,d,this.txtDiaChi.getText(),
//                    this.cbSoThe.getValue());
//            JdbcDocGia.addDocGia(dg);
//            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//            alert.setContentText("Thêm thành công !!");
//            alert.showAndWait();
//            Stage stage = (Stage)btThem.getScene().getWindow();
//            stage.close();
//        } catch (SQLException ex) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setContentText("Thêm  thất bại, lý do: " + ex.getMessage());
//            alert.show();
//        } catch(NumberFormatException ex)
//        {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setContentText("Thêm  thất bại, lý do: " + ex.getMessage());
//            alert.show();
//        }catch(ParseException ex)
//        {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setContentText("Nhập sai định dạng ngày tháng năm (Năm\\Tháng\\Ngày\\)");
//            alert.show();
//        }

    }

    public void btHuyHandler(ActionEvent event) {
        Stage stage = (Stage) btHuy.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            List<Integer> the = JdbcTheThuVien.getTheThuVien();
            this.cbSoThe.getItems().addAll(the);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (ParseException ex) {
            System.err.println(ex.getMessage());
        }

    }

}
