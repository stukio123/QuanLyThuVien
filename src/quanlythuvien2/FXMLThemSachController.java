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

    public int themSach(String maSach, String tenSach, String tacGia, String theLoai, String nxb, String soLuong) throws SQLException{

        int kq = 0;
        
        if (maSach.equals("") || tenSach.equals("") || theLoai.equals("")) {
            kq = 1;
        }

        if (maSach.length() > 10 || tenSach.length() > 45 || tacGia.length() > 45
                || theLoai.length() > 45 || nxb.length() > 45 || soLuong.length() > 45) {
            kq = 2;
        }else if (!maSach.equals("") && !tenSach.equals("")
                && !theLoai.equals("") && soLuong.length() >1) {
            Sach s = new Sach(maSach, tenSach, tacGia, theLoai, nxb, Integer.parseInt(soLuong));
            if (s.getSoLuong() < 0 ) kq = 4;
            else{
            JdbcSach.addSach(s);
            
            kq = 3;
            }
        }
       
        return kq;
    }

    public void btThemHandler(ActionEvent event) throws SQLException, IOException, NumberFormatException {
        int kq = themSach(this.txtMaSach.getText(), this.txtTenSach.getText(),
                this.txtTacGia.getText(), this.txtTheLoai.getText(),
                this.txtNxb.getText(), this.txtSoLuong.getText());
        if (kq == 3) {  
            this.txtMaSach.clear();
            this.txtTenSach.clear();
            this.txtTacGia.clear();
            this.txtTheLoai.clear();
            this.txtNxb.clear();
            this.txtSoLuong.clear();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Thêm Sách");
            alert.setHeaderText("");
            alert.setContentText("Thêm thành công!");
            alert.showAndWait();
        } else if (kq==1) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Dữ liệu trống");
            alert.setHeaderText("");
            alert.setContentText("Vui lòng nhập đầy đủ thông tin!");
            alert.showAndWait();
        } else if (kq==2) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Dữ liệu quá dài");
            alert.setHeaderText("");
            alert.setContentText("Vui lòng nhập đúng!");
            alert.showAndWait();
        }else if (kq == 4){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Số lượng  nhỏ hơn 0");
            alert.setHeaderText("");
            alert.setContentText("Vui lòng nhập đúng!");
            alert.showAndWait();
        }

//        try {
//            Sach s = new Sach(this.txtMaSach.getText(), this.txtTenSach.getText(),
//                    this.txtTacGia.getText(), this.txtTheLoai.getText(),
//                    this.txtNxb.getText(), Integer.parseInt(this.txtSoLuong.getText()));
//            JdbcSach.addSach(s);
//            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//            alert.setContentText("Thêm sách thành công !!");
//            alert.show();
//            txtMaSach.clear();
//            txtTenSach.clear();
//            txtTacGia.clear();
//            txtTheLoai.clear();
//            txtNxb.clear();
//            txtSoLuong.clear();
//            //Stage stage = (Stage)btThem.getScene().getWindow();
//            //stage.close();
//        } catch (SQLException ex) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setContentText("Thêm  thất bại, lý do: " + ex.getMessage());
//            alert.show();
//        } catch (NumberFormatException ex) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setContentText("Thêm  thất bại, lý do: " + ex.getMessage());
//            alert.show();
//        }

    }

    public void btHuyHandler(ActionEvent event) {
        Stage stage = (Stage) btHuy.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
