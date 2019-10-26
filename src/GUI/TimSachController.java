package GUI;

import Data.DataBaseConnector;
import Data.UpdateTable;
import Object.Sach;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

public class TimSachController implements Initializable {

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
    
    private ObservableList<Sach> oblist;
    private DataBaseConnector dc;
    String c1;
    
    public static String sql = "SELECT * FROM quanlythuvien.sach order by Ma_Sach ;";
    
    private ObservableList<Sach> getSach(){
        ObservableList<Sach> getsach = FXCollections.observableArrayList();
        getsach.add(new Sach("Cersei","Lannister","Queen Regent","123",100000,169));
        getsach.add(new Sach("Cersei","Lannister","Queen Regent","123",100000,169));
        getsach.add(new Sach("Cersei","Lannister","Queen Regent","123",100000,169));

        return getsach;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        try {
//            Connection conn = DataBaseConnector.getConnection();
//            oblist = FXCollections.observableArrayList();
//            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM quanlythuvien.sach;");
//            while(rs.next())
//            {
//                oblist.add(new Sach (rs.getString("Ma_Sach"),rs.getString("Ten_Sach"),
//                        rs.getString("Ten_Tac_gia"),rs.getString("Nha_xb"),
//                        rs.getInt("Gia_tien"),
//                        rs.getInt("So_luong")));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(TimSachController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        maSach.setCellValueFactory(new PropertyValueFactory<>("Ma_Sach"));
        
        tenSach.setCellValueFactory(new PropertyValueFactory<>("Ten_Sach"));
        
        tenTacGia.setCellValueFactory(new PropertyValueFactory<>("Ten_Tac_gia"));
        
        nhaXuatBan.setCellValueFactory(new PropertyValueFactory<>("Nha_xb"));
        
        giaTien.setCellValueFactory(new PropertyValueFactory<>("Gia_tien"));
        
        soLuong.setCellValueFactory(new PropertyValueFactory<>("So_luong"));

        tbSach.setItems(getSach());
    }
    
    public void LoadData(){
         
    }
    

    @FXML
    public void DangXuat(ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("DangNhap.fxml"));
        Parent ChucNang = loader.load();
        Scene scene = new Scene(ChucNang);
        stage.setScene(scene);
        stage.show();
    }
}
