package quanlythuvien2;

import Data.JdbcDocGia;
import Data.JdbcMuonSach;
import Data.JdbcNhanVien;
import Data.JdbcSach;
import static Data.JdbcSach.delSach;
import static Data.JdbcSach.getSach;
import static Data.JdbcSach.getSach1;
import Data.JdbcTraSach;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import quanlythuvien2.models.DocGia;
import quanlythuvien2.models.MuonSach;
import quanlythuvien2.models.NhanVien;
import quanlythuvien2.models.Sach;
import quanlythuvien2.models.TraSach;

public class FXMLSachNhanVienController implements Initializable {

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
    private TableColumn<Sach, String> tbcNxb;
    @FXML
    private TableColumn<Sach, Integer> tbcSoLuong;
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
    private TableView<DocGia> tbvDG;
    @FXML
    private TableColumn<DocGia, String> tbcMaDG;
    @FXML
    private TableColumn<DocGia, String> tbcTenDG;
    @FXML
    private TableColumn<DocGia, String> tbcGioiTinh;
    @FXML
    private TableColumn<DocGia, Date> tbcNgaySinh;
    @FXML
    private TableColumn<DocGia, String> tbcDiaChi;
    @FXML
    private TableColumn<DocGia, Integer> tbcMaThe;
    @FXML
    private TableView<NhanVien> tbvNV;
    @FXML
    private TableColumn<NhanVien, Integer> tbcMaNV;
    @FXML
    private TableColumn<NhanVien, String> tbcTenNV;
    @FXML
    private TableColumn<NhanVien, Boolean> tbcGioiTinhNV;
    @FXML
    private TableColumn<NhanVien, Date> tbcNgaySinhNV;
    @FXML
    private TableColumn<NhanVien, String> tbcDiaChiNV;
    @FXML
    private TableColumn<NhanVien, Integer> tbcMaTK;
    @FXML
    private JFXTextField txtMaSachSua;
    @FXML
    private JFXTextField txtTenSachSua;
    @FXML
    private JFXTextField txtTacGiaSua;
    @FXML
    private JFXTextField txtTheLoaiSua;
    @FXML
    private JFXTextField txtNSXSua;
    @FXML
    private JFXTextField txtSoLuongSua;
    @FXML
    private VBox vboxSuaSach;
    @FXML
    private VBox vboxMuonSach;
    
    private int delNV = 0;
    private String delMaSach = "";
    private String chucNang = "";
    private String chucNangXoa = "";

    ObservableList<String> listLoai;

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        this.btnQLSach.setOnMouseClicked(et -> {
            listLoai = FXCollections.observableArrayList("Mã sách", "Tên sách", "Tên tác giả", "Nhà xuất bản");
            this.tbvSach.setVisible(true);
            this.tbvDG.setVisible(false);
            this.tbvNV.setVisible(false);
            this.tbvMuonSach.setVisible(false);
            this.vboxMuonSach.setVisible(false);
            this.chucNang = "Sach";
            this.tbvTraSach.setVisible(false);
            this.vboxTraSach.setVisible(false);
            try {
                this.loadSach(getSach());
            } catch (SQLException ex) {
                Logger.getLogger(FXMLSachController.class.getName()).log(Level.SEVERE, null, ex);
            }
            cbLoai.setItems(listLoai);

        });

        this.btnQLDocGia.setOnMouseClicked((MouseEvent et) -> {
            listLoai = FXCollections.observableArrayList("Mã DG", "Tên DG", "Thẻ TV");
            this.tbvSach.setVisible(false);
            this.tbvDG.setVisible(true);
            this.tbvNV.setVisible(false);
            this.tbvMuonSach.setVisible(false);
            this.vboxMuonSach.setVisible(false);
            this.chucNang = "DocGia";
            cbLoai.setItems(listLoai);
            this.tbvTraSach.setVisible(false);
            this.vboxTraSach.setVisible(false);

            try {
                this.loadDG(JdbcDocGia.getDG());
            } catch (SQLException ex) {
                Logger.getLogger(FXMLSachController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(FXMLSachController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        this.btnQLNhanVien.setOnMouseClicked((MouseEvent et) -> {
            listLoai = FXCollections.observableArrayList("Mã NV", "Tên NV", "Mã TK");
            cbLoai.setItems(listLoai);
            this.tbvSach.setVisible(false);
            this.tbvDG.setVisible(false);
            this.tbvNV.setVisible(true);
            this.tbvMuonSach.setVisible(false);
            this.vboxMuonSach.setVisible(false);
            this.chucNang = "NhanVien";
            this.tbvTraSach.setVisible(false);
            this.vboxTraSach.setVisible(false);

            try {
                this.loadNV(JdbcNhanVien.getNV());
            } catch (SQLException ex) {
                Logger.getLogger(FXMLSachController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(FXMLSachController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        this.btnQLMuonSach.setOnMouseClicked(et -> {
            this.tbvSach.setVisible(false);
            this.tbvDG.setVisible(false);
            this.tbvNV.setVisible(false);
            this.tbvMuonSach.setVisible(true);
            this.vboxMuonSach.setVisible(true);
            this.chucNang = "MuonSach";
            this.tbvTraSach.setVisible(false);
            this.vboxTraSach.setVisible(false);

            try {
                this.loadMuonSach(JdbcMuonSach.getMS());

            } catch (ParseException ex) {
                Logger.getLogger(FXMLSachController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(FXMLSachController.class.getName()).log(Level.SEVERE, null, ex);
            }
            cbLoai.setItems(listLoai);

        });

        this.btnQLTraSach.setOnMouseClicked((MouseEvent et) -> {
            this.tbvSach.setVisible(false);
            this.tbvDG.setVisible(false);
            this.tbvNV.setVisible(false);
            this.tbvMuonSach.setVisible(false);
            this.vboxMuonSach.setVisible(false);
            this.tbvTraSach.setVisible(true);
            this.vboxTraSach.setVisible(true);
            this.chucNang = "TraSach";

            try {
                this.loadTraSach(JdbcTraSach.getTS());

            } catch (ParseException | SQLException ex) {
                Logger.getLogger(FXMLSachController.class.getName()).log(Level.SEVERE, null, ex);
            }
            cbLoai.setItems(listLoai);

        });
    }

    /// ĐỘC GIẢ------------------------------------------------------------------------------------
    public void loadDG(List a) throws SQLException {

        tbcMaDG.setCellValueFactory(new PropertyValueFactory<>("maDG"));

        tbcTenDG.setCellValueFactory(new PropertyValueFactory<>("tenDG"));

        tbcGioiTinh.setCellValueFactory(new PropertyValueFactory<>("gioiTinh"));

        tbcNgaySinh.setCellValueFactory(new PropertyValueFactory<>("namSinh"));

        tbcDiaChi.setCellValueFactory(new PropertyValueFactory<>("diaChi"));

        tbcMaThe.setCellValueFactory(new PropertyValueFactory<>("soThe"));

        this.tbvDG.setItems(FXCollections.observableArrayList(a));

    }

    private int delDG = 0;

    public void XoaDG() throws SQLException, ParseException {
        System.out.println(delDG);
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Xóa Sách");
        alert.setContentText("Bạn có muốn xóa sách " + delDG + " không ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            JdbcDocGia.delDG(delDG);
        }
        btnSua.setDisable(true);
        btnXoa.setDisable(true);
        loadDG(JdbcDocGia.getDG());
    }

    @FXML
    public void ChonDG() throws SQLException {
        btnSua.setDisable(false);
        btnXoa.setDisable(false);
        delDG = tbvDG.getSelectionModel().getSelectedItem().getMaDG();
    }

    @FXML
    public void TimDG() throws SQLException, ParseException {
        if (this.txtTim.getText().length() == 0) {
            this.loadDG(JdbcDocGia.getDG());
        } else {
            loadDG(JdbcDocGia.getDG(this.txtTim.getText()));
        }
    }

    ///--------------SÁCH---------------------------------------------------------------------
    public void loadSach(List a) throws SQLException {

        tbcMaSach.setCellValueFactory(new PropertyValueFactory<>("maSach"));

        tbcTenSach.setCellValueFactory(new PropertyValueFactory<>("tenSach"));

        tbcTacGia.setCellValueFactory(new PropertyValueFactory<>("tacGia"));

        tbcTheLoai.setCellValueFactory(new PropertyValueFactory<>("theLoai"));

        tbcNxb.setCellValueFactory(new PropertyValueFactory<>("nxb"));

        tbcSoLuong.setCellValueFactory(new PropertyValueFactory<>("soLuong"));

        this.tbvSach.setItems(FXCollections.observableArrayList(a));

    }

    @FXML
    public void TimSach() throws SQLException {
        System.out.println(cbLoai.getValue());
        if (this.txtTim.getText().length() == 0) {
            String sql = "SELECT * FROM sach ";
            this.loadSach(getSach());
        } else {
            String sql = "";
            System.out.println(cbLoai.getValue());
            switch (cbLoai.getValue()) {
                case "Mã sách":
                    sql = "masach";
                    loadSach(getSach("masach", this.txtTim.getText()));
                    break;
                case "Tên sách":
                    sql = "tensach";
                    loadSach(getSach(sql, this.txtTim.getText()));
                    break;
                case "Tên tác giả":
                    sql = "tacgia";
                    loadSach(getSach(sql, this.txtTim.getText()));
                    break;
                case "Thể loại":
                    sql = "theloai";
                    loadSach(getSach(sql, this.txtTim.getText()));
                case "Nhà xuất bản":
                    sql = "nhaxuatban";
                    loadSach(getSach(sql, this.txtTim.getText()));
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
    public void ChonQLSach() throws SQLException {
        btnSua.setDisable(false);
        btnXoa.setDisable(false);
        delMaSach = tbvSach.getSelectionModel().getSelectedItem().getMaSach();
        System.out.println(delMaSach);
        this.txtMaSachSua.setText(delMaSach);

        this.txtTenSachSua.setText(tbvSach.getSelectionModel().getSelectedItem().getTenSach());
        this.txtTacGiaSua.setText(tbvSach.getSelectionModel().getSelectedItem().getTacGia());
        this.txtTheLoaiSua.setText(tbvSach.getSelectionModel().getSelectedItem().getTheLoai());
        this.txtNSXSua.setText(tbvSach.getSelectionModel().getSelectedItem().getNxb());
        this.txtSoLuongSua.setText(String.valueOf(tbvSach.getSelectionModel().getSelectedItem().getSoLuong()));
    }

    @FXML
    public void ChonSach(MouseEvent event) throws SQLException, ParseException {
        if (this.chucNang.equals("Sach")) {
            ChonQLSach();
        } else {
            ChonSachMuon();
        }

    }

    @FXML
    public void XoaSach() throws SQLException {

        System.out.println(delMaSach);
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Xóa Sách");
        alert.setContentText("Bạn có muốn xóa sách " + delMaSach + " không ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            delSach(delMaSach);
        }
        btnSua.setDisable(true);
        btnXoa.setDisable(true);
        loadSach(getSach());

    }

    @FXML
    public void LuuSuaSach(ActionEvent event) throws SQLException {
        Sach s = new Sach(this.txtMaSachSua.getText(), this.txtTenSachSua.getText(),
                this.txtTacGiaSua.getText(), this.txtTheLoaiSua.getText(), this.txtNSXSua.getText(),
                Integer.parseInt(this.txtSoLuongSua.getText()));
        if (JdbcSach.updateSach(s)) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Lưu Thành Công !!");
            alert.show();
        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Lưu thất bại");
            alert.show();
        }
        loadSach(getSach());
    }

    //---------------------------------------------NHÂN VIÊN--------------------------------------------
    @FXML
    public void loadNV(List a) throws SQLException {

        tbcMaNV.setCellValueFactory(new PropertyValueFactory<>("maNV"));
        tbcTenNV.setCellValueFactory(new PropertyValueFactory<>("tenNV"));
        tbcGioiTinhNV.setCellValueFactory(new PropertyValueFactory<>("gioiTinh"));
        tbcNgaySinhNV.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
        tbcDiaChiNV.setCellValueFactory(new PropertyValueFactory<>("diaChi"));
        tbcMaTK.setCellValueFactory(new PropertyValueFactory<>("maTK"));
        this.tbvNV.setItems(FXCollections.observableArrayList(a));

    }

    @FXML
    public void XoaNV() throws SQLException, ParseException {

        System.out.println(delNV);
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Xóa Sách");
        alert.setContentText("Bạn có muốn xóa sách " + delNV + " không ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            JdbcNhanVien.delNhanVien(delNV);
        }

        btnSua.setDisable(true);
        btnXoa.setDisable(true);
        loadNV(JdbcNhanVien.getNV());

    }

    @FXML
    public void ChonNV(MouseEvent event) throws SQLException {
        btnSua.setDisable(false);
        btnXoa.setDisable(false);
        delNV = tbvNV.getSelectionModel().getSelectedItem().getMaNV();
    }

    @FXML
    public void TimNV() throws SQLException, ParseException {

        if (this.txtTim.getText().length() == 0) {
            this.loadNV(JdbcNhanVien.getNV());
        } else {
            this.loadNV(JdbcNhanVien.getNV(this.txtTim.getText()));
        }
    }

//----------------------------------------CHƯC NĂNG CHÍNH CÓ TRÊN GIAO DIỆN THÊM XÓA SỬA------------------------------  
    public void btThemHandler(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLThem" + this.chucNang + ".fxml"));
        Stage stage = new Stage();
        Parent rootl = (Parent) loader.load();
        Stage stageDangNhap = new Stage();
        Scene sceneDN = new Scene(rootl);
        stageDangNhap.setScene(sceneDN);
        stageDangNhap.show();
//        FXMLThemSachController controller = loader.getController();
//        controller.btThemHandler(event);
    }

    @FXML
    public void Tim(ActionEvent event) throws SQLException, ParseException {

        if (this.chucNang.equals("Sach")) {
            TimSach();
        }
        if (this.chucNang.equals("DocGia")) {
            TimDG();
        }
        if (this.chucNang.equals(("NhanVien"))) {
            TimNV();
        }

    }

    public void btXoaHandler(ActionEvent event) throws IOException, SQLException, ParseException {

        if (chucNang.equals("Sach")) {
            XoaSach();
        }
        if (chucNang.equals("NhanVien")) {
            XoaNV();
        }
        if (chucNang.equals("DocGia")) {
            XoaDG();
        }
    }

    public void btChinhSuaHandler(ActionEvent event) throws IOException, SQLException {

        if (this.chucNang.equals("Sach")) {
            this.vboxSuaSach.setVisible(true);
        }
//            ChonQLSach();

        if (this.chucNang.equals("DocGia"));
        if (this.chucNang.equals("NhanVien"));

    }

    ///QUAY LẠI THOÁT---------------------------------------------------------------------
    public void btQuayLaiHandler(ActionEvent event) throws IOException {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLDangNhap.fxml"));
        Parent ChucNang = loader.load();
        Scene scene = new Scene(ChucNang);
        stage.setScene(scene);
        stage.show();

    }

    ///---------------------------------------Mươn sách-----------------------------------------------
    @FXML
    private TableView<MuonSach> tbvMuonSach;
    @FXML
    private TableColumn<MuonSach, Integer> tbcMaMuon;
    @FXML
    private TableColumn<MuonSach, Integer> tbcMaTheMuon;
    @FXML
    private TableColumn<MuonSach, String> tbcMaSachMuon;
    @FXML
    private TableColumn<MuonSach, Date> tbcNgayMuon;
    @FXML
    private TableColumn<MuonSach, String> tbcGhiChu;

    @FXML
    private JFXTextField txtMaSach;
    @FXML
    private JFXTextField txtMaThe;
    @FXML
    private JFXButton btKiemTraSach;
    @FXML
    private JFXButton btKiemTraDG;

    public void loadMuonSach(List a) throws SQLException {

        tbcMaMuon.setCellValueFactory(new PropertyValueFactory<>("maMuon"));
        tbcMaTheMuon.setCellValueFactory(new PropertyValueFactory<>("maThe"));
        tbcMaSachMuon.setCellValueFactory(new PropertyValueFactory<>("maSach"));
        tbcNgayMuon.setCellValueFactory(new PropertyValueFactory<>("ngayMuon"));
        tbcGhiChu.setCellValueFactory(new PropertyValueFactory<>("isTra"));
        this.tbvMuonSach.setItems(FXCollections.observableArrayList(a));

    }

    @FXML
    public void TimSachMuon(ActionEvent event) throws SQLException {

        if (this.txtMaSach.getText().length() == 0) {
            String sql = "SELECT * FROM sach ";
            this.loadSach(getSach());
        } else {
            loadSach(getSach1(this.txtMaSach.getText()));
        }
        this.tbvSach.setVisible(true);
        this.tbvDG.setVisible(false);
        this.tbvMuonSach.setVisible(false);

    }

    @FXML
    public void ChonSachMuon() throws SQLException, ParseException {

        txtMaSach.setText(tbvSach.getSelectionModel().getSelectedItem().getMaSach());
        tbvSach.setVisible(false);
        loadMuonSach(JdbcMuonSach.getMS());
        tbvMuonSach.setVisible(true);

    }

    @FXML
    public void TimDGMuon(ActionEvent event) throws SQLException, ParseException {

        if (this.txtMaSach.getText().length() == 0) {
            String sql = "SELECT * FROM docgia ";
            this.loadDG(JdbcDocGia.getDG());
        } else {
            loadDG(JdbcDocGia.getDG("sothe", this.txtMaThe.getText()));
        }
        this.tbvDG.setVisible(true);
        this.tbvSach.setVisible(false);
        this.tbvMuonSach.setVisible(false);
    }

    ////---------------------------------------TRẢ SAHCS---------------------------------------------------
    @FXML
    private JFXDatePicker txtNgayMuon;

    public void btLuuMuonSach(ActionEvent event) throws ParseException, SQLException {

        Date d = Date.valueOf(this.txtNgayMuon.getValue());
        MuonSach ms = new MuonSach(Integer.parseInt(txtMaThe.getText()), txtMaSach.getText(), d, "-");
        JdbcMuonSach.addMuonSach(ms);
        loadMuonSach(JdbcMuonSach.getMS());

    }

    @FXML
    private JFXButton btLuuMuonSach;

    @FXML
    public void ChonDocGiaMuon() throws SQLException, ParseException {

        txtMaThe.setText(String.valueOf(tbvDG.getSelectionModel().getSelectedItem().getSoThe()));
        txtSoLuongMuon.setText(String.valueOf(JdbcMuonSach.soluong(tbvDG.getSelectionModel().getSelectedItem().getSoThe())));
        if (JdbcMuonSach.soluong(tbvDG.getSelectionModel().getSelectedItem().getSoThe()) >= 5) {
            btLuuMuonSach.setDisable(true);
            JOptionPane.showMessageDialog(null, "Chỉ được mượn tối đa 5 quyển", "Thông báo", 1);

        } else {
            btLuuMuonSach.setDisable(false);
        }
        tbvDG.setVisible(false);
        tbvMuonSach.setVisible(true);
    }

    @FXML
    JFXTextField txtSoLuongMuon;

    ////-----------------------------------------CHỌN CHỨC NĂNG TABLEVIEW CHO CẬP NHẬT HOẶC CHỌN LẤY MÃ ĐỂ MƯỢN SÁCH
    @FXML
    public void ChonDocGia() throws SQLException, ParseException {

        if (this.chucNang.equals("DocGia")) {
            ChonDG();
        } else {
            ChonDocGiaMuon();
        }
    }

    /////////////////////////////////////////////////////////////////////////TRẢ 
    @FXML
    private TableView<TraSach> tbvTraSach;
    @FXML
    private TableColumn<TraSach, Integer> tbcMaTra;
    @FXML
    private TableColumn<TraSach, Integer> tbcMaMuonTra;
    @FXML
    private TableColumn<TraSach, Integer> tbcNgayTre;
    @FXML
    private TableColumn<TraSach, Date> tbcNgayTra;
    @FXML
    private TableColumn<TraSach, Double> tbcTienPhat;

    @FXML
    private JFXTextField txtMaMuon;
    @FXML
    private JFXButton btKTMaMuon;
    @FXML
    private JFXDatePicker txtNgayTra;
    @FXML
    private VBox vboxTraSach;
    @FXML
    private JFXTextField txtNgayMuonTra;

    public void loadTraSach(List a) throws SQLException {

        tbcMaTra.setCellValueFactory(new PropertyValueFactory<>("maTra"));
        tbcMaMuonTra.setCellValueFactory(new PropertyValueFactory<>("maMuon"));
        tbcNgayTra.setCellValueFactory(new PropertyValueFactory<>("ngayTra"));
        tbcNgayTre.setCellValueFactory(new PropertyValueFactory<>("ngayTre"));
        tbcTienPhat.setCellValueFactory(new PropertyValueFactory<>("tienPhat"));
        this.tbvTraSach.setItems(FXCollections.observableArrayList(a));

    }

    public void btLuuTraSach(ActionEvent event) throws ParseException, SQLException {

        SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");
        Date d = Date.valueOf(this.txtNgayTra.getValue());
//        Date n = Date.valueOf(this.m.getValue());

        long ngay = (d.getTime() - m.getTime()) / (24 * 3600 * 1000);
        int tre = 0;
        if ((int) ngay > 30) {
            tre = (int) ngay - 30;
        }

        TraSach ts = new TraSach(Integer.parseInt(txtMaMuon.getText()), d, tre, tre * 5000);

        JdbcTraSach.addTraSach(ts);
        JdbcMuonSach.updateMuon(Integer.parseInt(txtMaMuon.getText()));
        loadTraSach(JdbcTraSach.getTS());

    }

    @FXML
    public void TimMaMuon(ActionEvent event) throws SQLException, ParseException {

        loadMuonSach(JdbcMuonSach.getMS(1));
        this.tbvTraSach.setVisible(false);
        this.tbvMuonSach.setVisible(true);
    }

    Date m;

    @FXML
    public void ChonMaMuon() throws SQLException {

        txtMaMuon.setText(String.valueOf(tbvMuonSach.getSelectionModel().getSelectedItem().getMaMuon()));
        m = tbvMuonSach.getSelectionModel().getSelectedItem().getNgayMuon();
        SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");
        String d = f.format(m);
        this.txtNgayMuonTra.setText(d);
        tbvMuonSach.setVisible(false);
        tbvTraSach.setVisible(true);

    }

    int delMuon = 0;

    @FXML
    public void ChonMuonSach() throws SQLException {
        btnSua.setDisable(false);
        btnXoa.setDisable(false);
        delMuon = tbvMuonSach.getSelectionModel().getSelectedItem().getMaMuon();

    }

    @FXML
    public void ChonMuonS() throws SQLException, ParseException {
        if (this.chucNang.equals("MuonSach")) {
            ChonMuonSach();
        } else {
            ChonMaMuon();
        }
    }
}

