package GUI;

import Data.DataBaseConnector;
import Object.Sach;
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
    
    private ObservableList<Sach> oblist;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LoadData("SELECT * FROM quanlythuvien.sach;");
        DataBaseConnector.getConnection();
    }
    
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
