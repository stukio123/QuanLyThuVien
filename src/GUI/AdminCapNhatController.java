package GUI;

import Data.DataBaseConnector;
import Data.SachData;
import Object.Sach;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class AdminCapNhatController implements Initializable {
    
    @FXML
    private TableView<Sach> tbSach;
    @FXML
    private TableColumn<Sach, String> maSach;
    @FXML
    private TableColumn<Sach, String> tenSach;
    @FXML
    private TableColumn<Sach, String> tenTacGia;
    @FXML
    private TableColumn<Sach, String> nhaXuatBan;
    @FXML
    private TableColumn<Sach, Integer> soLuong;
    @FXML
    private TableColumn<Sach, Integer> giaTien;
    @FXML
    private TextField txtMaSach;
    @FXML
    private TextField txtTenSach;
    @FXML
    private TextField txtTenTacGia;
    @FXML
    private TextField txtNXB;
    @FXML
    private TextField txtSoLuong;
    @FXML
    private TextField txtGiaTien;
    @FXML
    private TextField txtTim;
    @FXML
    private JFXButton btnChinhSua;
    @FXML
    private JFXButton btnThem;
    @FXML
    private JFXButton btnSua;
    @FXML
    private JFXButton btnXoa;
    
    private ObservableList<Sach> oblist;
    
    SachData sachdata = new SachData();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LoadData("SELECT * FROM quanlythuvien.sach;");
        DataBaseConnector.getConnection();
    }
    
    @FXML
    public void SuaSach(ActionEvent event){
        Sach s = new Sach(this.txtMaSach.getText(), this.txtTenSach.getText(), this.txtTenTacGia.getText(),this.txtNXB.getText(),
             Integer.parseInt(this.txtGiaTien.getText()),Integer.parseInt(this.txtSoLuong.getText()));
        if(sachdata.UpdateSach(s)) {
            JOptionPane.showMessageDialog(null, "Bạn đã sửa thành công", "Thông báo", 1);
        }else JOptionPane.showMessageDialog(null, "Có lỗi xảy ra", "Thông báo", 2);
        LoadData("SELECT * FROM quanlythuvien.sach;");
    }
    
    @FXML
    public void XoaSach(ActionEvent event){
        if(sachdata.DeleteSach(this.txtMaSach.getText())) {
                JOptionPane.showMessageDialog(null, "Bạn đã xóa thành công", "Thông báo", 1);
            }
            else JOptionPane.showMessageDialog(null, "Có lỗi xảy ra", "Thông báo", 2);
        LoadData("SELECT * FROM quanlythuvien.sach;");
    }
    @FXML
    public void ThemSach(ActionEvent event){
        if (this.txtMaSach.getText().length()==0) JOptionPane.showMessageDialog(null, "Mã sách không thể bỏ trống", "thông báo", 2);
        else if(this.txtMaSach.getText().length()>10) JOptionPane.showMessageDialog(null, "Mã sách không được lớn hơn 10 ký tự", "thông báo", 2);
        else {
            Sach s = new Sach(this.txtMaSach.getText(), this.txtTenSach.getText(), this.txtTenTacGia.getText(),this.txtNXB.getText(),
             Integer.parseInt(this.txtGiaTien.getText()),Integer.parseInt(this.txtSoLuong.getText()));
            SachData.InsertSach(s);
            LoadData("SELECT * FROM quanlythuvien.sach;");
        }
    }
    @FXML
    public void LoadData(String sql){
        try {
            Connection conn = DataBaseConnector.getConnection();
            oblist = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while(rs.next())
            {
                oblist.add(new Sach (rs.getString("Ma_Sach"),rs.getString("Ten_Sach"),
                        rs.getString("Ten_Tac_gia"),rs.getString("Nha_xb"),
                        rs.getInt("Gia_tien"),
                        rs.getInt("So_luong")));
            }
            } catch (SQLException ex) {
            Logger.getLogger(TimSachController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        maSach.setCellValueFactory(new PropertyValueFactory<>("maSach"));
        
        tenSach.setCellValueFactory(new PropertyValueFactory<>("tenSach"));
        
        tenTacGia.setCellValueFactory(new PropertyValueFactory<>("tenTacGia"));
        
        nhaXuatBan.setCellValueFactory(new PropertyValueFactory<>("nhaXB"));
        
        giaTien.setCellValueFactory(new PropertyValueFactory<>("giaTien"));
        
        soLuong.setCellValueFactory(new PropertyValueFactory<>("soLuong"));

        tbSach.setItems(oblist);
    }
    @FXML
    public void ChinhSua(ActionEvent event){
        btnThem.setDisable(false);
        btnSua.setDisable(true);
        btnXoa.setDisable(true);
        txtMaSach.clear();
        txtMaSach.setEditable(true);
        txtTenSach.clear();
        txtTenSach.setEditable(true);
        txtTenTacGia.clear();
        txtTenTacGia.setEditable(true);
        txtNXB.clear();
        txtNXB.setEditable(true);
        txtSoLuong.clear();
        txtSoLuong.setEditable(true);
        txtGiaTien.clear();
        txtGiaTien.setEditable(true);
    }
    
    @FXML
    public void TimSach(ActionEvent event){
        if(this.txtTim.getText().length() == 0) {
            String sql = "SELECT * from SACH ";
            LoadData(sql);
        }
        else {
            String sql = "SELECT * from SACH WHERE Ma_Sach like N'%"+this.txtTim.getText()+"%' "
                    + "or Ten_Sach like N'%"+this.txtTim.getText()+"%'"
                    + "or Ten_Tac_gia like N'%"+this.txtTim.getText()+"%'"
                    + "or Nha_xb like N'%"+this.txtTim.getText()+"%'";
            LoadData(sql);
        }
    }
    
    @FXML
    public void chonSach(MouseEvent event){
        btnThem.setDisable(true);
        btnSua.setDisable(false);
        btnXoa.setDisable(false);
//        txtMaSach.setEditable(false);
//        txtTenSach.setEditable(false);
//        txtTenTacGia.setEditable(false);
//        txtNXB.setEditable(false);
//        txtSoLuong.setEditable(false);
//        txtGiaTien.setEditable(false);
        Connection conn = DataBaseConnector.getConnection();
        String MaSach = tbSach.getSelectionModel().getSelectedItem().getMaSach();
        String sql = "SELECT * FROM SACH where Ma_Sach='"+MaSach+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                this.txtMaSach.setText(rs.getString("Ma_Sach"));
                this.txtTenSach.setText(rs.getString("Ten_Sach"));
                this.txtNXB.setText(rs.getString("Nha_Xb"));
                this.txtTenTacGia.setText(rs.getString("Ten_Tac_gia"));
                this.txtGiaTien.setText((rs.getString("Gia_tien")));
                this.txtSoLuong.setText(rs.getString("So_luong"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TimSachController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void quayLai(ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ChucNang.fxml"));
        Parent ChucNang = loader.load();
        Scene scene = new Scene(ChucNang);
        stage.setScene(scene);
        stage.show();
    }
}
