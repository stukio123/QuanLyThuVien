package quanlythuvien2;

import Data.JdbcDocGia;
import static Data.JdbcSach.delSach;
import static Data.JdbcSach.getSach;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import quanlythuvien2.models.DocGia;
import quanlythuvien2.models.Sach;

public class FXMLSachController implements Initializable {
    
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
    @FXML
    private JFXTextField txtTim;
    @FXML
    private JFXComboBox<String> cbLoai;
    @FXML
    private JFXButton btnSua;
    @FXML
    private JFXButton btnXoa;
    
    @FXML
    private JFXButton btnQLNhanVien;
    @FXML
    private JFXButton btnQLSach;
    @FXML
    private JFXButton btnQLDocGia;
    @FXML
    private JFXButton btnQLMuonSach;
    @FXML
    private JFXButton btnQLTraSach;
    @FXML
    private JFXButton btnQLThongKe;
    
   
    
    
    @FXML
    private TableView tbvDG;
    @FXML
    private TableColumn<Sach, String> tbcMaDG;
    @FXML
    private TableColumn<Sach, String> tbcTenDG;
     @FXML
    private TableColumn<Sach, String> tbcGioiTinh;
     @FXML
    private TableColumn<Sach, Date> tbcNgaySinh;
     @FXML
    private TableColumn<Sach, String> tbcDiaChi;
     @FXML
    private TableColumn<Sach, Integer> tbcMaThe;
    
    
    private String delMaSach = "";
    private String chucNang ="";
    
    ObservableList<String> listLoai = FXCollections.observableArrayList("Mã sách","Tên sách","Tên tác giả","Nhà xuất bản");
    
    
    FXMLTrangChinhController  s = new FXMLTrangChinhController();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

        
        
//        JOptionPane.showMessageDialog(null, s.tenChucNang , "Thông báo", 1);

        this.btnQLSach.setOnMouseClicked(et->{
            this.tbvSach.setVisible(true);
            this.tbvDG.setVisible(false);
            this.chucNang = "Sach";
            try {
                 this.loadSach(getSach());
             } catch (SQLException ex) {
                 Logger.getLogger(FXMLSachController.class.getName()).log(Level.SEVERE, null, ex);
             }
             cbLoai.setItems(listLoai);
        });
        
        this.btnQLDocGia.setOnMouseClicked((MouseEvent et)->{
            this.tbvSach.setVisible(false);
            this.tbvDG.setVisible(true);
            this.chucNang = "DocGia";

            
            
            try {
                this.loadDG(JdbcDocGia.getDG());
            } catch (SQLException ex) {
                Logger.getLogger(FXMLSachController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(FXMLSachController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
       
        });
            
           
      
        

        
    }
    
    
    public void loadDG(List a) throws SQLException{


        tbcMaDG.setCellValueFactory(new PropertyValueFactory<>("maDG"));

        tbcTenDG.setCellValueFactory(new PropertyValueFactory<>("tenDG"));

        tbcGioiTinh.setCellValueFactory(new PropertyValueFactory<>("gioiTinh"));

        tbcNgaySinh.setCellValueFactory(new PropertyValueFactory<>("namSinh"));
        
        tbcDiaChi.setCellValueFactory(new PropertyValueFactory<>("diaChi"));
        
        tbcMaThe.setCellValueFactory(new PropertyValueFactory<>("soThe"));

        this.tbvDG.setItems(FXCollections.observableArrayList(a));
     
    }
    
    public void loadSach(List a) throws SQLException{


        tbcMaSach.setCellValueFactory(new PropertyValueFactory<>("maSach"));

        tbcTenSach.setCellValueFactory(new PropertyValueFactory<>("tenSach"));

        tbcTacGia.setCellValueFactory(new PropertyValueFactory<>("tacGia"));

        tbcTheLoai.setCellValueFactory(new PropertyValueFactory<>("theLoai"));
        
        tbcNxb.setCellValueFactory(new PropertyValueFactory<>("nxb"));
        
        tbcSoLuong.setCellValueFactory(new PropertyValueFactory<>("soLuong"));

        this.tbvSach.setItems(FXCollections.observableArrayList(a));
     
    }
    
    public void btThemHandler(ActionEvent event) throws IOException, SQLException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLThem" + this.chucNang +".fxml"));
        Stage stage = new Stage();
        Parent rootl = (Parent) loader.load();
        Stage stageDangNhap = new Stage();
        Scene sceneDN =  new Scene(rootl);
        stageDangNhap.setScene(sceneDN);        
        stageDangNhap.show();
//        FXMLThemSachController controller = loader.getController();
//        controller.btThemHandler(event);
    }
    
    @FXML
    public void TimSach(ActionEvent event) throws SQLException{
        System.out.println(cbLoai.getValue());
        if(this.txtTim.getText().length() == 0) {
            String sql = "SELECT * FROM sach ";
            this.loadSach(getSach());
        }
        else {
            String sql = "";
            System.out.println(cbLoai.getValue());
            switch (cbLoai.getValue()) {
                case "Mã sách":
                    sql = "masach";
                    loadSach(getSach(sql,this.txtTim.getText()));
                    break;
                case "Tên sách":
                    sql = "tensach";
                    loadSach(getSach(sql,this.txtTim.getText()));
                    break;
                case "Tên tác giả":
                    sql = "tacgia";
                    loadSach(getSach(sql,this.txtTim.getText()));
                    break;
                case "Thể loại":
                    sql = "theloai";
                    loadSach(getSach(sql,this.txtTim.getText()));
                case "Nhà xuất bản":
                    sql = "nhaxuatban";
                    loadSach(getSach(sql,this.txtTim.getText()));
                default:
                    loadSach(getSach());
                    break;
            }
//            String sql = "SELECT * from SACH WHERE Ma_Sach like N'%"+this.txtTim.getText()+"%' "
//                    + "or Ten_Sach like N'%"+this.txtTim.getText()+"%'"
//                    + "or Ten_Tac_gia like N'%"+this.txtTim.getText()+"%'"
//                    + "or Nha_xb like N'%"+this.txtTim.getText()+"%'";
//            LoadData(sql);
        }
    }
    
    @FXML
    public void ChonSach(MouseEvent event) throws SQLException{
        btnSua.setDisable(false);
        btnXoa.setDisable(false);
        delMaSach = tbvSach.getSelectionModel().getSelectedItem().getMaSach();
        System.out.println(delMaSach);
    }
    @FXML
    public void XoaSach(ActionEvent Event) throws SQLException{
        System.out.println(delMaSach);
        delSach(delMaSach);
        btnSua.setDisable(true);
        btnXoa.setDisable(true);
        loadSach(getSach());
    }
    
    public void btQuayLaiHandler(ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLTrangChinh.fxml"));
        Parent ChucNang = loader.load();
        Scene scene = new Scene(ChucNang);
        stage.setScene(scene);
        stage.show();
        
    }
    
    public void btRefesh(ActionEvent event) throws SQLException{
        loadSach(getSach());
    }
    
    public void btChinhSuaHandler(ActionEvent event) throws IOException{
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLChinhSuaSach.fxml"));
        Stage stage = new Stage();
        Parent rootl = (Parent) loader.load();
        Stage stageDangNhap = new Stage();
        Scene sceneDN =  new Scene(rootl);
//        FXMLChinhSuaSachController controller = loader.getController();
//        Sach selected = tbvSach.getSelectionModel().getSelectedItem();
//        controller.setSach(selected);
        stageDangNhap.setScene(sceneDN);        
        stageDangNhap.show();
        
    }
    
}