package quanlythuvien2;

import Data.JdbcSach;
import static Data.JdbcSach.getSach;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import quanlythuvien2.models.Sach;

public class FXMLChinhSuaSachController implements Initializable {
    
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
    @FXML
    private TableView<Sach> tbvSach;
    @FXML
    private TableColumn<Sach, String> tbcMaSach;
    @FXML
    private TableColumn<Sach, String> tbcTenSach;
    @FXML
    private TableColumn<Sach, String> tbcTacGia;
    @FXML
    private TableColumn<Sach, String> tbcTheLoai;
    @FXML
    private TableColumn<Sach, String>  tbcNxb;
    @FXML
    private TableColumn<Sach, Integer>  tbcSoLuong;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            this.loadSach(getSach());
        } catch (SQLException ex) {
            Logger.getLogger(FXMLSachController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
//    public void setSach(Sach sach){
//        txtMaSach.setText(sach.getMaSach());
//        txtTenSach.setText(sach.getTenSach());
//        txtTacGia.setText(sach.getTacGia());
//        txtTheLoai.setText(sach.getTheLoai());
//        txtNxb.setText(sach.getNxb());
//        txtSoLuong.setText(String.valueOf(sach.getSoLuong()));
//    }
    
    public void loadSach(List a) throws SQLException{


        tbcMaSach.setCellValueFactory(new PropertyValueFactory<>("maSach"));

        tbcTenSach.setCellValueFactory(new PropertyValueFactory<>("tenSach"));

        tbcTacGia.setCellValueFactory(new PropertyValueFactory<>("tacGia"));

        tbcTheLoai.setCellValueFactory(new PropertyValueFactory<>("theLoai"));
        
        tbcNxb.setCellValueFactory(new PropertyValueFactory<>("nxb"));
        
        tbcSoLuong.setCellValueFactory(new PropertyValueFactory<>("soLuong"));

        this.tbvSach.setItems(FXCollections.observableArrayList(a));
     
    }
    
    @FXML
    public void ChonSach(MouseEvent event) throws SQLException{
        
        String MaSach = tbvSach.getSelectionModel().getSelectedItem().getMaSach();
        Sach selected = JdbcSach.getSach(MaSach);
        this.txtMaSach.setText(selected.getMaSach());
        this.txtTenSach.setText(selected.getTenSach());
        this.txtTacGia.setText(selected.getTacGia());
        this.txtTheLoai.setText(selected.getTheLoai());
        this.txtNxb.setText(selected.getNxb());
        this.txtSoLuong.setText(String.valueOf(selected.getSoLuong()));
        
    }
    
    public void LuuSach(ActionEvent event) throws SQLException{
        Sach s = new Sach(this.txtMaSach.getText(), this.txtTenSach.getText(),this.txtTacGia.getText(), this.txtTheLoai.getText(),this.txtNxb.getText(),
        Integer.parseInt(this.txtSoLuong.getText()));
        if(JdbcSach.updateSach(s)) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Lưu Thành Công !!");
            alert.show();
        }else{
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Lưu thất bại");
            alert.show();
        }
        loadSach(getSach());
    }
    
    public void btHuyHandler(ActionEvent event){
        Stage stage = (Stage)btHuy.getScene().getWindow();
        stage.close();
     }
}
