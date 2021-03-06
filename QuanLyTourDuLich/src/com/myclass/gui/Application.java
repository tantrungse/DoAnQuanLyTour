package com.myclass.gui;

import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.myclass.bus.CTKeHoachTheoNgayBUS;
import com.myclass.bus.DiaDiemThamQuanBUS;
import com.myclass.bus.DoanBUS;
import com.myclass.bus.HopDongBUS;
import com.myclass.bus.HuongDanVienBUS;
import com.myclass.bus.KeHoachTourBUS;
import com.myclass.bus.KhachHangBUS;
import com.myclass.bus.KhachSanBUS;
import com.myclass.bus.NhaHangBUS;
import com.myclass.bus.PhuongTienBUS;
import com.myclass.bus.TaiKhoanBUS;
import com.myclass.bus.TourBUS;
import com.myclass.dao.CTKeHoachTheoNgayDAO;
import com.myclass.dao.TaiKhoanDAO;
import com.myclass.dto.CTKeHoachTheoNgayDTO;
import com.myclass.dto.DiaDiemThamQuanDTO;
import com.myclass.dto.DoanDTO;
import com.myclass.dto.HopDongDTO;
import com.myclass.dto.HuongDanVienDTO;
import com.myclass.dto.KeHoachTourDTO;
import com.myclass.dto.KhachHangDTO;
import com.myclass.dto.KhachSanDTO;
import com.myclass.dto.NhaHangDTO;
import com.myclass.dto.PhuongTienDTO;
import com.myclass.dto.TaiKhoanDTO;
import com.myclass.dto.TourDTO;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;

public class Application extends JFrame {

	private JPanel contentPane;
	private JPanel sidePane;
	private JLabel lblDashboard;
	private JPanel cardsPane;
	private CardLayout cardLayout;
	
	private TaiKhoanBUS taiKhoanBUS;
	private TourBUS	tourBUS;
	private HuongDanVienBUS huongDanVienBUS;
	private KhachHangBUS khachHangBUS;
	private HopDongBUS hopDongBUS;
	private DoanBUS doanBUS;
	private KeHoachTourBUS keHoachTourBUS;
	private CTKeHoachTheoNgayBUS ctKeHoachTheoNgayBUS;
	private DiaDiemThamQuanBUS diaDiemThamQuanBUS;
	private PhuongTienBUS phuongTienBUS;
	private NhaHangBUS nhaHangBUS;
	private KhachSanBUS khachSanBUS;
	
	private DefaultTableModel taiKhoanTblModel;
	private DefaultTableModel tourTblModel;
	private DefaultTableModel hdvTblModel;
	private DefaultTableModel khachHangTblModel;
	private DefaultTableModel tour_hopDongTblModel;
	private DefaultTableModel tour_doanTblModel;
	private DefaultTableModel tour_keHoachTourTblModel;
	private DefaultTableModel hopDongTblModel;
	private DefaultTableModel doanTblModel;
	private DefaultTableModel keHoachTourTblModel;
	private DefaultTableModel keHoachTour_ctKeHoachTheoNgayTblModel;
	private DefaultTableModel ctKeHoachTheoNgayTblModel;
	private DefaultTableModel ctKeHoachTheoNgay_diaDiemThamQuanTblModel;
	private DefaultTableModel ctKeHoachTheoNgay_phuongTienTblModel;
	private DefaultTableModel ctKeHoachTheoNgay_nhaHangTblModel;
	private DefaultTableModel ctKeHoachTheoNgay_khachSanTblModel;
	private DefaultTableModel diaDiemThamQuanTblModel;
	private DefaultTableModel phuongTienTblModel;
	private DefaultTableModel nhaHangTblModel;
	private DefaultTableModel khachSanTblModel;
	
	private JTable tblTaiKhoan;
	private JTable tblTour;
	private JTable tblHdv;
	private JTable tblKhachHang;
	private JTable tblTour_HopDong;
	private JTable tblTour_Doan;
	private JTable tblTour_KeHoachTour;
	private JTable tblHopDong;
	private JTable tblDoan;
	private JTable tblKeHoachTour;
	private JTable tblKeHoachTour_CTKeHoachTheoNgay;
	private JTable tblCTKeHoachTheoNgay;
	private JTable tblCTKeHoachTheoNgay_DiaDiemThamQuan;
	private JTable tblCTKeHoachTheoNgay_PhuongTien;
	private JTable tblCTKeHoachTheoNgay_NhaHang;
	private JTable tblCTKeHoachTheoNgay_KhachSan;
	private JTable tblDiaDiemThamQuan;
	private JTable tblPhuongTien;
	private JTable tblNhaHang;
	private JTable tblKhachSan;
	
	private int selectedRow;
	
	private JButton btnTaiKhoan_Update;
	private JButton btnKhachHang_CapNhat;
	private JButton btnDoan_CapNhat;
	private JButton btnKeHoachTour_CapNhat;
	private JButton btnKeHoachTour_CTKeHoachTheoNgay_CapNhat;
	private JButton btnDiaDiemThamQuan_CapNhat;
	private JButton btnPhuongTien_CapNhat;
	private JButton btnNhaHang_CapNhat;
	private JButton btnKhachSan_CapNhat;
	
	private JTextField txtUpdateTenTaiKhoan;
	private JTextField txtUpdateMatKhau;
	
	private JTextField txtUpdateMaTour;
	private JTextField txtUpdateTenTour;
	private JTextField txtUpdateGiaVe;
	private JTextField txtUpdateDiemKhoiHanh;
	private JTextField txtUpdateDiemDen;
	
	private JTextField txtUpdateMaDoan;
	private JTextField txtUpdateSoNguoi;
	private JTextField txtUpdateDoan_MaTour;
	private JTextField txtUpdateDoan_MaHDV;
	
	private JTextField txtUpdateMaKhachHang;
	private JTextField txtUpdateHoTenKhachHang;
	private JTextField txtUpdateDiaChiKhachHang;
	private JTextField txtUpdateSdtKhachHang;
	private JTextField txtUpdateMaDoanKhachHang;
	
	private JTextField txtUpdateMaHdv;
	private JTextField txtUpdateHoTenHdv;
	private JTextField txtUpdateNgaySinhHdv;
	private JTextField txtUpdateGioiTinhHdv;
	private JTextField txtUpdateDiaChiHdv;
	private JTextField txtUpdateSdtHdv;
	
	private JTextField txtUpdateMaHD;
	private JTextField txtUpdateNgayLapHD;
	private JTextField txtUpdateNoiDungHD;
	private JTextField txtUpdateHD_MaTour;
	
	private JTextField txtUpdateMaKeHoach;
	private JTextField txtUpdateNgayBatDau;
	private JTextField txtUpdateNgayKetThuc;
	private JTextField txtUpdateKeHoachTour_MaTour;
	
	private JTextField txtUpdateMaCTKeHoachTheoNgay;
	private JTextField txtUpdateNgay;
	private JTextField txtUpdateDiaDiemThamQuan;
	private JTextField txtUpdatePhuongTien;
	private JTextField txtUpdateNhaHang;
	private JTextField txtUpdateKhachSan;
	private JTextField txtUpdateCTKeHoachTheoNgay_MaKHTour;
	
	private JTextField txtUpdateMaDiaDiem, txtUpdateTenDiaDiem, txtUpdateDiaDiemThamQuan_DiaChi;
	private JTextField txtUpdateMaPhuongTien, txtUpdateTenPhuongTien, txtUpdateChiPhi, txtUpdateSoChoNgoi;
	private JTextField txtUpdateMaNhaHang, txtUpdateTenNhaHang, txtUpdateNhaHang_DiaChi, txtUpdateNhaHang_ChiPhiTrenNguoi;
	private JTextField txtUpdateMaKhachSan, txtUpdateTenKhachSan, txtUpdateKhachSan_DiaChi, txtUpdateKhachSan_ChiPhiTrenNguoi;
	
	private JButton btnTour_Update;
	private JButton btnHopDong_CapNhat;
	
	private JRadioButton rBtnAddQuanTriVien;
	private JRadioButton rBtnAddNhanVien;
	private JRadioButton rBtnUpdateQuanTriVien;
	private JRadioButton rBtnUpdateNhanVien;
	private ButtonGroup bgAddQuyen;
	private ButtonGroup bgUpdateQuyen;
	
	public static Application appInstance;

	public Application(TaiKhoanDTO taiKhoanDangNhap) {
		taiKhoanBUS = new TaiKhoanBUS();
		tourBUS = new TourBUS();
		huongDanVienBUS = new HuongDanVienBUS();
		khachHangBUS = new KhachHangBUS();
		hopDongBUS = new HopDongBUS();
		doanBUS = new DoanBUS();
		keHoachTourBUS = new KeHoachTourBUS();
		ctKeHoachTheoNgayBUS = new CTKeHoachTheoNgayBUS();
		diaDiemThamQuanBUS = new DiaDiemThamQuanBUS();
		phuongTienBUS = new PhuongTienBUS();
		nhaHangBUS = new NhaHangBUS();
		khachSanBUS = new KhachSanBUS();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 800);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// ===== SIDE START HERE =====
		sidePane = new JPanel();
		sidePane.setBackground(Color.GRAY);
		sidePane.setBounds(0, 0, 250, 800);
		contentPane.add(sidePane);
		sidePane.setLayout(null);
		
		lblDashboard = new JLabel();
		lblDashboard.setText(taiKhoanDangNhap.getTenTK());
		lblDashboard.setForeground(Color.WHITE);
		lblDashboard.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblDashboard.setBounds(0, 50, 250, 100);
		sidePane.add(lblDashboard);
		
		JPanel menuSidePane = new JPanel();
		menuSidePane.setBackground(Color.GRAY);
		menuSidePane.setBounds(0, 300, 250, 450);
		sidePane.add(menuSidePane);
		menuSidePane.setLayout(new GridLayout(6, 0, 0, 0));
		
		JLabel lblQuanLyTaiKhoan = new JLabel("Qu???n l?? t??i kho???n h??? th???ng");
		lblQuanLyTaiKhoan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyTaiKhoan");
			}
		});
		lblQuanLyTaiKhoan.setForeground(Color.WHITE);
		lblQuanLyTaiKhoan.setFont(new Font("Consolas", Font.BOLD, 16));
		menuSidePane.add(lblQuanLyTaiKhoan);
		
		JLabel lblQuanLyTour = new JLabel("Qu???n l?? tour");
		lblQuanLyTour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyTour");
			}
		});
		lblQuanLyTour.setForeground(Color.WHITE);
		lblQuanLyTour.setFont(new Font("Consolas", Font.BOLD, 16));
		menuSidePane.add(lblQuanLyTour);
		
		JLabel lblQuanLyHdv = new JLabel("Qu???n l?? h?????ng d???n vi??n");
		lblQuanLyHdv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyHdv");
			}
		});
		lblQuanLyHdv.setForeground(Color.WHITE);
		lblQuanLyHdv.setFont(new Font("Consolas", Font.BOLD, 16));
		menuSidePane.add(lblQuanLyHdv);
		
		JLabel lblQuanLyHoaDon = new JLabel("Qu???n l?? h??a ????n");
		lblQuanLyHoaDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HoaDonGUI1 hoaDonGUI1 = new HoaDonGUI1();
				hoaDonGUI1.setVisible(true);
				hoaDonGUI1.setLocationRelativeTo(null);
			}
		});
		lblQuanLyHoaDon.setForeground(Color.WHITE);
		lblQuanLyHoaDon.setFont(new Font("Consolas", Font.BOLD, 16));
		menuSidePane.add(lblQuanLyHoaDon);
		
		JLabel lblQuanLyKhachHang = new JLabel("Qu???n l?? kh??ch h??ng");
		lblQuanLyKhachHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyKhachHang");
			}
		});
		lblQuanLyKhachHang.setForeground(Color.WHITE);
		lblQuanLyKhachHang.setFont(new Font("Consolas", Font.BOLD, 16));
		menuSidePane.add(lblQuanLyKhachHang);
		
		JLabel lblQuanLyCTKeHoachTheoNgay = new JLabel("Qu???n l?? CT k??? ho???ch");
		lblQuanLyCTKeHoachTheoNgay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyCTKeHoachTheoNgay");
			}
		});
		lblQuanLyCTKeHoachTheoNgay.setForeground(Color.WHITE);
		lblQuanLyCTKeHoachTheoNgay.setFont(new Font("Consolas", Font.BOLD, 16));
		menuSidePane.add(lblQuanLyCTKeHoachTheoNgay);
		// ===== SIDE END HERE ===== 
		
		cardsPane = new JPanel(new CardLayout());
		cardsPane.setBackground(Color.WHITE);
		cardsPane.setBounds(250, 0, 1250, 800);
		contentPane.add(cardsPane);
		cardLayout = (CardLayout) cardsPane.getLayout();
		
		// ===== ADMIN LAYOUT START HERE =====
		JPanel cardQuanLyTaiKhoan = new JPanel();
		cardsPane.add(cardQuanLyTaiKhoan, "name_4535705721900");
		cardQuanLyTaiKhoan.setLayout(null);
		cardLayout.addLayoutComponent(cardQuanLyTaiKhoan, "cardQuanLyTaiKhoan");
		
		JLabel lblTaiKhoan_Header = new JLabel("Trang qu???n l?? t??i kho???n");
		lblTaiKhoan_Header.setBounds(0, 0, 400, 100);
		lblTaiKhoan_Header.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardQuanLyTaiKhoan.add(lblTaiKhoan_Header);
		
		JScrollPane taiKhoanScrollPane = new JScrollPane();
		taiKhoanScrollPane.setBounds(60, 450, 390, 300);
		cardQuanLyTaiKhoan.add(taiKhoanScrollPane);
		
		JLabel lblTaiKhoanSearch = new JLabel("T??m ki???m:");
		lblTaiKhoanSearch.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblTaiKhoanSearch.setBounds(20, 400, 80, 30);
		cardQuanLyTaiKhoan.add(lblTaiKhoanSearch);
		
		JTextField txtTaiKhoanSearch = new JTextField();
		txtTaiKhoanSearch.setBounds(100, 400, 200, 30);
		cardQuanLyTaiKhoan.add(txtTaiKhoanSearch);
		txtTaiKhoanSearch.setColumns(10);
		
		JButton btnTaiKhoanSearch = new JButton("T??m\r\n");
		btnTaiKhoanSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int quyen = -1;
				String tenQuyen = null;
				ArrayList<TaiKhoanDTO> listKQ = taiKhoanBUS.searchByTenTK(txtTaiKhoanSearch.getText());
				taiKhoanTblModel.setRowCount(0); // xoa tat ca row
				for(TaiKhoanDTO dto : listKQ) {
					quyen = dto.getQuyen();
					if(quyen == 0) {
						tenQuyen = "Qu???n tr??? vi??n";
					}
					else if(quyen == 1) {
						tenQuyen = "Nh??n vi??n";
					}
					taiKhoanTblModel.addRow(new Object[] {
							dto.getTenTK(), dto.getMatKhau(), tenQuyen
					});
				}
			}
		});
		btnTaiKhoanSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTaiKhoanSearch.setBounds(310, 400, 80, 30);
		cardQuanLyTaiKhoan.add(btnTaiKhoanSearch);
		
		String[] colNamesTblTaiKhoan = {"T??i kho???n", "M???t kh???u", "Quy???n"};
		tblTaiKhoan = new JTable();
		tblTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tblTaiKhoan.setRowHeight(50);
		taiKhoanTblModel = new DefaultTableModel();
		for(String colName : colNamesTblTaiKhoan) {
			taiKhoanTblModel.addColumn(colName);
		}
		tblTaiKhoan.setModel(taiKhoanTblModel);
		loadTblTaiKhoan();
		
		taiKhoanScrollPane.setViewportView(tblTaiKhoan);
		tblTaiKhoan.setFillsViewportHeight(true);
		
		JButton btnTaiKhoanReload = new JButton("T???i l???i b???ng");
		btnTaiKhoanReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taiKhoanTblModel.setRowCount(0);
				loadTblTaiKhoan();
			}
		});
		btnTaiKhoanReload.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTaiKhoanReload.setBounds(475, 450, 200, 30);
		cardQuanLyTaiKhoan.add(btnTaiKhoanReload);
		
		JButton btnTaiKhoanDel = new JButton("X??a t??i kho???n");
		btnTaiKhoanDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tblTaiKhoan.getSelectedRow();

				if(selectedRow>=0) {
					int result=JOptionPane.showConfirmDialog(null, "B???n c?? ch???c mu???n x??a th??ng tin n??y ?","Th??ng b??o !",JOptionPane.YES_NO_OPTION);
					if(result==JOptionPane.YES_OPTION) {
						String tenTK = String.valueOf(tblTaiKhoan.getValueAt(selectedRow, 0));
						
						taiKhoanBUS.deleteByTenTK(tenTK);
						TaiKhoanBUS.listTaiKhoanDTO.remove(selectedRow);
						taiKhoanTblModel.removeRow(selectedRow);
					}
					else if(result==JOptionPane.NO_OPTION) {
						JOptionPane.showMessageDialog(null, "Th??ng tin n??y ch??a ???????c x??a !");
					}
				}
				if(selectedRow<0 ) {
					JOptionPane.showMessageDialog(cardQuanLyTaiKhoan, "B???n ch??a ch???n tr?????ng d??? li???u n??o c???");
				}
			}
		});
		btnTaiKhoanDel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTaiKhoanDel.setBounds(475, 500, 200, 30);
		cardQuanLyTaiKhoan.add(btnTaiKhoanDel);
		
		JButton btnTaiKhoan_Add = new JButton("Th??m t??i kho???n");
		btnTaiKhoan_Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardAddTaiKhoan");
			}
		});
		btnTaiKhoan_Add.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTaiKhoan_Add.setBounds(475, 550, 200, 30);
		cardQuanLyTaiKhoan.add(btnTaiKhoan_Add);
		
		btnTaiKhoan_Update = new JButton("C???p nh???t t??i kho???n");
		addActionListenerBtnTaiKhoan_Update();
		
		btnTaiKhoan_Update.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTaiKhoan_Update.setBounds(475, 600, 200, 30);
		cardQuanLyTaiKhoan.add(btnTaiKhoan_Update);
		// ===== ADMIN LAYOUT END HERE =====
		
		// ===== ADMIN ADD LAYOUT START HERE =====
		JPanel cardAddTaiKhoan = new JPanel();
		cardsPane.add(cardAddTaiKhoan);
		cardAddTaiKhoan.setLayout(null);
		cardLayout.addLayoutComponent(cardAddTaiKhoan, "cardAddTaiKhoan");
		
		JLabel lblAddAdminContent = new JLabel("Trang th??m t??i kho???n");
		lblAddAdminContent.setBounds(0, 0, 400, 100);
		lblAddAdminContent.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardAddTaiKhoan.add(lblAddAdminContent);
		
		JLabel lblAddTenTaiKhoan = new JLabel("Nh???p t??n t??i kho???n:");
		lblAddTenTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddTenTaiKhoan.setBounds(50, 150, 150, 30);
		cardAddTaiKhoan.add(lblAddTenTaiKhoan);
		
		JTextField txtAddTenTaiKhoan = new JTextField();
		txtAddTenTaiKhoan.setColumns(10);
		txtAddTenTaiKhoan.setBounds(200, 150, 300, 30);
		cardAddTaiKhoan.add(txtAddTenTaiKhoan);
		
		JLabel lblAddMatKhau = new JLabel("Nh???p m???t kh???u:");
		lblAddMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddMatKhau.setBounds(50, 200, 150, 30);
		cardAddTaiKhoan.add(lblAddMatKhau);
		
		JTextField txtAddMatKhau = new JTextField();
		txtAddMatKhau.setColumns(10);
		txtAddMatKhau.setBounds(200, 200, 300, 30);
		cardAddTaiKhoan.add(txtAddMatKhau);
		
		JLabel lblAddQuyen = new JLabel("Ch???n quy???n:");
		lblAddQuyen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddQuyen.setBounds(50, 250, 150, 30);
		cardAddTaiKhoan.add(lblAddQuyen);
		
		rBtnAddQuanTriVien = new JRadioButton("Qu???n tr??? vi??n");
		rBtnAddQuanTriVien.setActionCommand("Qu???n tr??? vi??n");
		rBtnAddQuanTriVien.setSelected(true);
		rBtnAddQuanTriVien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rBtnAddQuanTriVien.setBounds(200, 250, 120, 30);
		cardAddTaiKhoan.add(rBtnAddQuanTriVien);
		
		rBtnAddNhanVien = new JRadioButton("Nh??n vi??n");
		rBtnAddNhanVien.setActionCommand("Nh??n vi??n");
		rBtnAddNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rBtnAddNhanVien.setBounds(350, 250, 100, 30);
		cardAddTaiKhoan.add(rBtnAddNhanVien);
		
		bgAddQuyen = new ButtonGroup();
		bgAddQuyen.add(rBtnAddQuanTriVien);
		bgAddQuyen.add(rBtnAddNhanVien);
		
		JButton btnAddTaiKhoan_Add = new JButton("Th??m m???i");
		btnAddTaiKhoan_Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb=new StringBuilder();
				if(txtAddTenTaiKhoan.getText().equals("")) {
		            sb.append("*T??n t??i kho???n kh??ng ???????c ????? tr???ng\n");
		    	}
				if(txtAddMatKhau.getText().equals("")) {
		            sb.append("*M???t kh???u kh??ng ???????c ????? tr???ng\n");
		    	}
				if(sb.length()>0) {
		    		JOptionPane.showMessageDialog(cardAddTaiKhoan, sb.toString(),"Th??ng b??o",JOptionPane.ERROR_MESSAGE);
		    		return;
		    	}
		    	
				String tenQuyen = bgAddQuyen.getSelection().getActionCommand();
				TaiKhoanDTO dto = new TaiKhoanDTO();
				
				dto.setTenTK(txtAddTenTaiKhoan.getText());
				dto.setMatKhau(txtAddMatKhau.getText());
				if(tenQuyen.equals("Admin")) {
					dto.setQuyen(0);
				}
				else {
					dto.setQuyen(1);
				}
				
				taiKhoanBUS.add(dto);
				TaiKhoanBUS.listTaiKhoanDTO.add(dto);
				addRow(dto);
				cardLayout.show(cardsPane, "cardQuanLyTaiKhoan");
				// clear all text after add
				txtAddTenTaiKhoan.setText("");
				txtAddMatKhau.setText("");
				bgAddQuyen.getSelection().setSelected(false);
			}
		});
		btnAddTaiKhoan_Add.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddTaiKhoan_Add.setBounds(150, 300, 120, 30);
		cardAddTaiKhoan.add(btnAddTaiKhoan_Add);
		
		JButton btnAddTaiKhoan_QuayLai = new JButton("Quay l???i");
		btnAddTaiKhoan_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyTaiKhoan");
			}
		});
		btnAddTaiKhoan_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddTaiKhoan_QuayLai.setBounds(300, 300, 100, 30);
		cardAddTaiKhoan.add(btnAddTaiKhoan_QuayLai);
		// ===== ADMIN ADD LAYOUT END HERE =====
		
		// ===== ADMIN UPDATE LAYOUT START HERE =====
		JPanel cardUpdateTaiKhoan = new JPanel();
		cardsPane.add(cardUpdateTaiKhoan);
		cardUpdateTaiKhoan.setLayout(null);
		cardLayout.addLayoutComponent(cardUpdateTaiKhoan, "cardUpdateTaiKhoan");
		
		JLabel lblUpdateAdminContent = new JLabel("Trang c???p nh???t t??i kho???n");
		lblUpdateAdminContent.setBounds(0, 0, 400, 100);
		lblUpdateAdminContent.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardUpdateTaiKhoan.add(lblUpdateAdminContent);
		
		JLabel lblUpdateTenTaiKhoan = new JLabel("Nh???p t??n t??i kho???n:");
		lblUpdateTenTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateTenTaiKhoan.setBounds(50, 150, 150, 30);
		cardUpdateTaiKhoan.add(lblUpdateTenTaiKhoan);
		
		txtUpdateTenTaiKhoan = new JTextField();
		txtUpdateTenTaiKhoan.setColumns(10);
		txtUpdateTenTaiKhoan.setBounds(200, 150, 300, 30);
		cardUpdateTaiKhoan.add(txtUpdateTenTaiKhoan);
		
		JLabel lblUpdateMatKhau = new JLabel("Nh???p m???t kh???u:");
		lblUpdateMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateMatKhau.setBounds(50, 200, 150, 30);
		cardUpdateTaiKhoan.add(lblUpdateMatKhau);
		
		txtUpdateMatKhau = new JTextField();
		txtUpdateMatKhau.setColumns(10);
		txtUpdateMatKhau.setBounds(200, 200, 300, 30);
		cardUpdateTaiKhoan.add(txtUpdateMatKhau);
		
		JLabel lblUpdateQuyen = new JLabel("Ch???n quy???n:");
		lblUpdateQuyen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateQuyen.setBounds(50, 250, 150, 30);
		cardUpdateTaiKhoan.add(lblUpdateQuyen);
		
		rBtnUpdateQuanTriVien = new JRadioButton("Qu???n tr??? vi??n");
		rBtnUpdateQuanTriVien.setActionCommand("Qu???n tr??? vi??n");
		rBtnUpdateQuanTriVien.setSelected(true);
		rBtnUpdateQuanTriVien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rBtnUpdateQuanTriVien.setBounds(200, 250, 120, 30);
		cardUpdateTaiKhoan.add(rBtnUpdateQuanTriVien);
		
		rBtnUpdateNhanVien = new JRadioButton("Nh??n vi??n");
		rBtnUpdateNhanVien.setActionCommand("Nh??n vi??n");
		rBtnUpdateNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rBtnUpdateNhanVien.setBounds(350, 250, 100, 30);
		cardUpdateTaiKhoan.add(rBtnUpdateNhanVien);
		
		bgUpdateQuyen = new ButtonGroup();
		bgUpdateQuyen.add(rBtnUpdateQuanTriVien);
		bgUpdateQuyen.add(rBtnUpdateNhanVien);
		
		JButton btnUpdateTaiKhoan = new JButton("C???p nh???t");
		btnUpdateTaiKhoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tblTaiKhoan.getSelectedRow();
				String tenQuyen = bgUpdateQuyen.getSelection().getActionCommand();
				TaiKhoanDTO dto = new TaiKhoanDTO();
				
				if(!taiKhoanTblModel.getValueAt(selectedRow, 0).equals(txtUpdateTenTaiKhoan.getText())) {
					JOptionPane.showMessageDialog(new JFrame(), "Kh??ng ???????c thay ?????i t??n t??i kho???n!");
					return;
				}
				
				dto.setTenTK(txtUpdateTenTaiKhoan.getText());
				dto.setMatKhau(txtUpdateMatKhau.getText());
				if(tenQuyen.equals("Qu???n tr??? vi??n")) {
					dto.setQuyen(0);
				}
				else {
					dto.setQuyen(1);
				}
				
				taiKhoanBUS.update(dto);
				TaiKhoanBUS.listTaiKhoanDTO.set(selectedRow, dto);
				setRow(dto, selectedRow);
				cardLayout.show(cardsPane, "cardQuanLyTaiKhoan");
			}
		});
		btnUpdateTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateTaiKhoan.setBounds(150, 300, 100, 30);
		cardUpdateTaiKhoan.add(btnUpdateTaiKhoan);
		
		JButton btnUpdateTaiKhoan_QuayLai = new JButton("Quay l???i");
		btnUpdateTaiKhoan_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyTaiKhoan");
				txtUpdateTenTaiKhoan.setText("");
				txtUpdateMatKhau.setText("");
				bgUpdateQuyen.clearSelection();
			}
		});
		btnUpdateTaiKhoan_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateTaiKhoan_QuayLai.setBounds(300, 300, 100, 30);
		cardUpdateTaiKhoan.add(btnUpdateTaiKhoan_QuayLai);
		// ===== ADMIN UPDATE LAYOUT END HERE =====
		
		// ===== TOUR LAYOUT START HERE =====
		JPanel cardQuanLyTour = new JPanel();
		cardsPane.add(cardQuanLyTour, "name_4568411886400");
		cardQuanLyTour.setLayout(null);
		cardLayout.addLayoutComponent(cardQuanLyTour, "cardQuanLyTour");
		
		JLabel lblTourSearch = new JLabel("T??m ki???m:");
		lblTourSearch.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblTourSearch.setBounds(20, 0, 80, 30);
		cardQuanLyTour.add(lblTourSearch);
		
		JTextField txtTourSearch = new JTextField();
		txtTourSearch.setBounds(100, 0, 200, 30);
		cardQuanLyTour.add(txtTourSearch);
		txtTourSearch.setColumns(10);
		
		JButton btnTourSearch = new JButton("T??m");
		btnTourSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<TourDTO> listKQ;
				Object[] options = {
			            "T??m ki???m theo m?? Tour", "T??m ki???m theo t??n Tour", "????ng"
			        };
			        int select = JOptionPane.showOptionDialog(btnTourSearch, "B???n mu???n t??m ki???m theo ph????ng th???c n??o?", "T??y ch???n", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
			        
			        //System.out.println("select: " + select);
			        //m???? -> select: 0
			        //t????n -> select: 1
			        // chi phi -> select: 2
			        // ?????????ng -> select: 3
			        
			        if(select == 0){
			            String input = JOptionPane.showInputDialog(btnTourSearch, "M???i b???n nh???p m?? Tour !");
			            
			            if(input != null && input.length() > 0){
			                listKQ = tourBUS.getByMaTour(input);
			                tourTblModel.setRowCount(0);
			                
			                for(TourDTO dto : listKQ) {
								tourTblModel.addRow(new Object[] {
										dto.getMaTour(), dto.getTenTour(), dto.getGiaVe(), dto.getDiemKhoiHanh(), dto.getDiemDen()
								});
			                };
			            }
			            else {
			                JOptionPane.showMessageDialog(null, "L???i t??m ki???m !");
			            }
			        }
			        
			        if(select == 1){
			            String input = JOptionPane.showInputDialog(btnTourSearch, "M???i b???n nh???p t??n Tour !");
			            
			            if(input != null && input.length() > 0){
			                listKQ = tourBUS.getByTenTour(input);
			                tourTblModel.setRowCount(0);
			                
			                for(TourDTO dto : listKQ) {
								tourTblModel.addRow(new Object[] {
										dto.getMaTour(), dto.getTenTour(), dto.getGiaVe(), dto.getDiemKhoiHanh(), dto.getDiemDen()
								});
			                };
			            }
			            else {
			                JOptionPane.showMessageDialog(null, "L???i t??m ki???m !");
			            }
			        }
			}
		});
		btnTourSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTourSearch.setBounds(310, 0, 80, 30);
		cardQuanLyTour.add(btnTourSearch);
		
		JScrollPane tourScrollPane = new JScrollPane();
		tourScrollPane.setBounds(50, 50, 600, 273);
		cardQuanLyTour.add(tourScrollPane);
		
		tblTour = new JTable();
		tblTour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = tblTour.getSelectedRow();
				String maTour = (String) tblTour.getValueAt(selectedRow, 0);
				HopDongDTO hopDong = hopDongBUS.getByMaTour(maTour);
				DoanDTO doan = doanBUS.getByMaTour(maTour);
				KeHoachTourDTO keHoachTour = keHoachTourBUS.getByMaTour(maTour);
				
				if(tour_hopDongTblModel.getRowCount() > 0) {
					tour_hopDongTblModel.setRowCount(0);
				}
				addRowTblTour_HopDong(hopDong);
				if(tour_doanTblModel.getRowCount() > 0) {
					tour_doanTblModel.setRowCount(0);
				}
				addRowTblTour_Doan(doan);
				if(tour_keHoachTourTblModel.getRowCount() > 0) {
					tour_keHoachTourTblModel.setRowCount(0);
				}
				addRowTblTour_KeHoachTour(keHoachTour);
			}
		});
		tblTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tblTour.setRowHeight(50);
		String[] colNamesTblTour = {"M?? tour", "T??n tour", "Gi?? v??", "??i???m kh???i h??nh", "??i???m ?????n"};
		tourTblModel = new DefaultTableModel();
		tblTour.setModel(tourTblModel);
		for(String colName : colNamesTblTour) {
			tourTblModel.addColumn(colName);
		}
		loadTblTour();
		
		tourScrollPane.setViewportView(tblTour);
		tblTour.setFillsViewportHeight(true);
		
		JButton btnTourReload = new JButton("T???i l???i b???ng");
		btnTourReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//tourTblModel.setRowCount(0);
				//loadTblTour();
				ArrayList<TourDTO> listKQ;
				listKQ = tourBUS.getAll();
		        
		        tourTblModel.setRowCount(0);
		        
		        listKQ.forEach(dto -> {
		            tourTblModel.addRow(new Object[]{
		                dto.getMaTour(), dto.getTenTour(), dto.getGiaVe(), dto.getDiemKhoiHanh(), dto.getDiemDen()
		            });
		        });
			}
		});
		btnTourReload.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTourReload.setBounds(675, 50, 150, 30);
		cardQuanLyTour.add(btnTourReload);
		
		JButton btnTourDel = new JButton("X??a tour");
		btnTourDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tblTour.getSelectedRow();
				if(selectedRow>=0) {
					int result = JOptionPane.showConfirmDialog(null,"B???n c?? ch???c mu???n x??a th??ng tin n??y ?", "Th??ng b??o",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	                if(result == JOptionPane.YES_OPTION){
						String maTour = (String) tblTour.getValueAt(selectedRow, 0);
						
						tourBUS.deleteById(maTour);
						tourTblModel.removeRow(selectedRow);
						}
	                else if(result == JOptionPane.NO_OPTION)
                    {
                        JOptionPane.showMessageDialog(null, "Kh??ng x??a th??ng tin");
                    }
				}
				if(selectedRow<0) {
					JOptionPane.showMessageDialog(cardQuanLyTour, "B???n ch??a ch???n tr?????ng d??? li???u!");
				}
			}
		});
		btnTourDel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTourDel.setBounds(675, 100, 150, 30);;
		cardQuanLyTour.add(btnTourDel);
		
		JButton btnTourAdd = new JButton("Th??m tour");
		btnTourAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardAddTour");
			}
		});
		btnTourAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTourAdd.setBounds(675, 150, 150, 30);
		cardQuanLyTour.add(btnTourAdd);
		
		btnTour_Update = new JButton("C???p nh???t tour");
		addActionListenerBtnTour_Update();
		btnTour_Update.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTour_Update.setBounds(675, 200, 150, 30);
		cardQuanLyTour.add(btnTour_Update);
		
		JButton btnTour_TaoHD = new JButton("T???o h???p ?????ng");
		btnTour_TaoHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardAddHopDong");
			}
		});
		addActionListenerBtnTour_Update();
		btnTour_TaoHD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTour_TaoHD.setBounds(50, 350, 150, 30);
		cardQuanLyTour.add(btnTour_TaoHD);
		
		JButton btnTour_TaoDoan = new JButton("T???o ??o??n");
		btnTour_TaoDoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardAddDoan");
			}
		});
		addActionListenerBtnTour_Update();
		btnTour_TaoDoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTour_TaoDoan.setBounds(225, 350, 150, 30);
		cardQuanLyTour.add(btnTour_TaoDoan);
		
		JButton btnTour_TaoKeHoach = new JButton("T???o k??? ho???ch");
		btnTour_TaoKeHoach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardAddKeHoachTour");
			}
		});
		addActionListenerBtnTour_Update();
		btnTour_TaoKeHoach.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTour_TaoKeHoach.setBounds(400, 350, 150, 30);
		cardQuanLyTour.add(btnTour_TaoKeHoach);
		
		JLabel lblThongTinHopDong = new JLabel("Th??ng tin h???p ?????ng:");
		lblThongTinHopDong.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThongTinHopDong.setBounds(50, 410, 200, 30);
		cardQuanLyTour.add(lblThongTinHopDong);
		
		JScrollPane tour_hopDongScrollPane = new JScrollPane();
		tour_hopDongScrollPane.setBounds(50, 450, 600, 73);
		cardQuanLyTour.add(tour_hopDongScrollPane);
		
		tblTour_HopDong = new JTable();
		tblTour_HopDong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tblTour_HopDong.setRowHeight(50);
		String[] colNamesTblTour_HopDong = {"M?? h???p ?????ng", "Ng??y l???p h???p ?????ng", "N???i dung", "M?? tour"};
		tour_hopDongTblModel = new DefaultTableModel();
		tblTour_HopDong.setModel(tour_hopDongTblModel);
		for(String colName : colNamesTblTour_HopDong) {
			tour_hopDongTblModel.addColumn(colName);
		}
		
		tour_hopDongScrollPane.setViewportView(tblTour_HopDong);
		tblTour_HopDong.setFillsViewportHeight(true);
		
		JButton btnTour_HopDongLayout = new JButton("Xem danh s??ch");
		btnTour_HopDongLayout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyHopDong");
			}
		});
		addActionListenerBtnTour_Update();
		btnTour_HopDongLayout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTour_HopDongLayout.setBounds(675, 470, 150, 30);
		cardQuanLyTour.add(btnTour_HopDongLayout);
		
		JLabel lblThongTinDoan = new JLabel("Th??ng tin ??o??n du l???ch:");
		lblThongTinDoan.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThongTinDoan.setBounds(50, 530, 200, 30);
		cardQuanLyTour.add(lblThongTinDoan);
		
		JScrollPane tour_doanScrollPane = new JScrollPane();
		tour_doanScrollPane.setBounds(50, 570, 600, 73);
		cardQuanLyTour.add(tour_doanScrollPane);
		
		tblTour_Doan = new JTable();
		tblTour_Doan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tblTour_Doan.setRowHeight(50);
		String[] colNamesTblTour_Doan = {"M?? ??o??n", "S??? ng?????i", "M?? tour", "M?? HDV"};
		tour_doanTblModel = new DefaultTableModel();
		tblTour_Doan.setModel(tour_doanTblModel);
		for(String colName : colNamesTblTour_Doan) {
			tour_doanTblModel.addColumn(colName);
		}
		
		tour_doanScrollPane.setViewportView(tblTour_Doan);
		tblTour_Doan.setFillsViewportHeight(true);
		
		JButton btnTour_DoanLayout = new JButton("Xem danh s??ch");
		btnTour_DoanLayout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyDoan");
			}
		});
		addActionListenerBtnTour_Update();
		btnTour_DoanLayout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTour_DoanLayout.setBounds(675, 590, 150, 30);
		cardQuanLyTour.add(btnTour_DoanLayout);
		
		JLabel lblKeHoachTour = new JLabel("K??? ho???ch tour:");
		lblKeHoachTour.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblKeHoachTour.setBounds(50, 650, 200, 30);
		cardQuanLyTour.add(lblKeHoachTour);
		
		JScrollPane tour_keHoachTourScrollPane = new JScrollPane();
		tour_keHoachTourScrollPane.setBounds(50, 690, 600, 73);
		cardQuanLyTour.add(tour_keHoachTourScrollPane);
		
		tblTour_KeHoachTour = new JTable();
		tblTour_KeHoachTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tblTour_KeHoachTour.setRowHeight(50);
		String[] colNamesTblTour_KeHoachTour = {"M?? k??? ho???ch", "Ng??y b???t ?????u", "Ng??y k???t th??c", "M?? tour"};
		tour_keHoachTourTblModel = new DefaultTableModel();
		tblTour_KeHoachTour.setModel(tour_keHoachTourTblModel);
		for(String colName : colNamesTblTour_KeHoachTour) {
			tour_keHoachTourTblModel.addColumn(colName);
		}
		
		tour_keHoachTourScrollPane.setViewportView(tblTour_KeHoachTour);
		tblTour_KeHoachTour.setFillsViewportHeight(true);
		addActionListenerBtnTour_Update();
		
		JButton btnTour_KeHoachTourLayout = new JButton("Xem danh s??ch");
		btnTour_KeHoachTourLayout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyKeHoachTour");
			}
		});
		addActionListenerBtnTour_Update();
		btnTour_KeHoachTourLayout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTour_KeHoachTourLayout.setBounds(675, 710, 150, 30);
		cardQuanLyTour.add(btnTour_KeHoachTourLayout);
		// ===== TOUR LAYOUT END HERE =====
		
		// ===== TOUR ADD LAYOUT START HERE =====
		JPanel cardAddTour = new JPanel();
		cardsPane.add(cardAddTour);
		cardAddTour.setLayout(null);
		cardLayout.addLayoutComponent(cardAddTour, "cardAddTour");
		
		JLabel lblAddTourContent = new JLabel("Trang th??m tour");
		lblAddTourContent.setBounds(0, 0, 400, 100);
		lblAddTourContent.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardAddTour.add(lblAddTourContent);
		
		JLabel lblAddMaTour = new JLabel("Nh???p m?? tour:");
		lblAddMaTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddMaTour.setBounds(50, 100, 150, 30);
		cardAddTour.add(lblAddMaTour);
		
		JTextField txtAddMaTour = new JTextField();
		txtAddMaTour.setColumns(10);
		txtAddMaTour.setBounds(200, 100, 300, 30);
		cardAddTour.add(txtAddMaTour);
		
		JLabel lblAddTenTour = new JLabel("Nh???p t??n tour:");
		lblAddTenTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddTenTour.setBounds(50, 150, 150, 30);
		cardAddTour.add(lblAddTenTour);
		
		JTextField txtAddTenTour = new JTextField();
		txtAddTenTour.setColumns(10);
		txtAddTenTour.setBounds(200, 150, 300, 30);
		cardAddTour.add(txtAddTenTour);
		
		JLabel lblAddGiaVe = new JLabel("Nh???p gi?? v??:");
		lblAddGiaVe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddGiaVe.setBounds(50, 200, 150, 30);
		cardAddTour.add(lblAddGiaVe);
		
		JTextField txtAddGiaVe = new JTextField();
		txtAddGiaVe.setColumns(10);
		txtAddGiaVe.setBounds(200, 200, 300, 30);
		cardAddTour.add(txtAddGiaVe);
		
		JLabel lblAddDiemKhoiHanh = new JLabel("Nh???p ??i???m kh???i h??nh:");
		lblAddDiemKhoiHanh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddDiemKhoiHanh.setBounds(50, 250, 150, 30);
		cardAddTour.add(lblAddDiemKhoiHanh);
		
		JTextField txtAddDiemKhoiHanh = new JTextField();
		txtAddDiemKhoiHanh.setColumns(10);
		txtAddDiemKhoiHanh.setBounds(200, 250, 300, 30);
		cardAddTour.add(txtAddDiemKhoiHanh);
		
		JLabel lblAddDiemDen = new JLabel("Nh???p ??i???m ?????n:");
		lblAddDiemDen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddDiemDen.setBounds(50, 300, 150, 30);
		cardAddTour.add(lblAddDiemDen);
		
		JTextField txtAddDiemDen = new JTextField();
		txtAddDiemDen.setColumns(10);
		txtAddDiemDen.setBounds(200, 300, 300, 30);
		cardAddTour.add(txtAddDiemDen);
		
		JButton btnAddTour_ThemMoi = new JButton("Th??m m???i");
		btnAddTour_ThemMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TourDTO dto = new TourDTO();
				
				dto.setMaTour(txtAddMaTour.getText());
				dto.setTenTour(txtAddTenTour.getText());
				dto.setGiaVe(Double.parseDouble(txtAddGiaVe.getText()));
				dto.setDiemKhoiHanh(txtAddDiemKhoiHanh.getText());
				dto.setDiemDen(txtAddDiemDen.getText());
				
				tourBUS.add(dto);
				TourBUS.listTourDTO.add(dto);
				addRow(dto);
				cardLayout.show(cardsPane, "cardQuanLyTour");
				// clear all text after add
				txtAddMaTour.setText("");
				txtAddTenTour.setText("");
				txtAddGiaVe.setText("");
				txtAddDiemKhoiHanh.setText("");
				txtAddDiemDen.setText("");
			}
		});
		btnAddTour_ThemMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddTour_ThemMoi.setBounds(150, 400, 120, 30);
		cardAddTour.add(btnAddTour_ThemMoi);
		
		JButton btnAddTour_QuayLai = new JButton("Quay l???i");
		btnAddTour_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyTour");
			}
		});
		btnAddTour_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddTour_QuayLai.setBounds(300, 400, 100, 30);
		cardAddTour.add(btnAddTour_QuayLai);
		// ===== TOUR ADD LAYOUT END HERE =====
		
		// ===== TOUR UPDATE LAYOUT START HERE =====
		JPanel cardUpdateTour = new JPanel();
		cardsPane.add(cardUpdateTour);
		cardUpdateTour.setLayout(null);
		cardLayout.addLayoutComponent(cardUpdateTour, "cardUpdateTour");
		
		JLabel lblUpdateTourContent = new JLabel("Trang th??m tour");
		lblUpdateTourContent.setBounds(0, 0, 400, 100);
		lblUpdateTourContent.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardUpdateTour.add(lblUpdateTourContent);
		
		JLabel lblUpdateMaTour = new JLabel("Nh???p m?? tour:");
		lblUpdateMaTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateMaTour.setBounds(50, 100, 150, 30);
		cardUpdateTour.add(lblUpdateMaTour);
		
		txtUpdateMaTour = new JTextField();
		txtUpdateMaTour.setColumns(10);
		txtUpdateMaTour.setBounds(200, 100, 300, 30);
		cardUpdateTour.add(txtUpdateMaTour);
		
		JLabel lblUpdateTenTour = new JLabel("Nh???p t??n tour:");
		lblUpdateTenTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateTenTour.setBounds(50, 150, 150, 30);
		cardUpdateTour.add(lblUpdateTenTour);
		
		txtUpdateTenTour = new JTextField();
		txtUpdateTenTour.setColumns(10);
		txtUpdateTenTour.setBounds(200, 150, 300, 30);
		cardUpdateTour.add(txtUpdateTenTour);
		
		JLabel lblUpdateGiaVe = new JLabel("Nh???p gi?? v??:");
		lblUpdateGiaVe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateGiaVe.setBounds(50, 200, 150, 30);
		cardUpdateTour.add(lblUpdateGiaVe);
		
		txtUpdateGiaVe = new JTextField();
		txtUpdateGiaVe.setColumns(10);
		txtUpdateGiaVe.setBounds(200, 200, 300, 30);
		cardUpdateTour.add(txtUpdateGiaVe);
		
		JLabel lblUpdateDiemKhoiHanh = new JLabel("Nh???p ??i???m kh???i h??nh:");
		lblUpdateDiemKhoiHanh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateDiemKhoiHanh.setBounds(50, 250, 150, 30);
		cardUpdateTour.add(lblUpdateDiemKhoiHanh);
		
		txtUpdateDiemKhoiHanh = new JTextField();
		txtUpdateDiemKhoiHanh.setColumns(10);
		txtUpdateDiemKhoiHanh.setBounds(200, 250, 300, 30);
		cardUpdateTour.add(txtUpdateDiemKhoiHanh);
		
		JLabel lblUpdateDiemDen = new JLabel("Nh???p ??i???m ?????n:");
		lblUpdateDiemDen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateDiemDen.setBounds(50, 300, 150, 30);
		cardUpdateTour.add(lblUpdateDiemDen);
		
		txtUpdateDiemDen = new JTextField();
		txtUpdateDiemDen.setColumns(10);
		txtUpdateDiemDen.setBounds(200, 300, 300, 30);
		cardUpdateTour.add(txtUpdateDiemDen);
		
		JButton btnUpdateTour_CapNhat = new JButton("C???p nh???t");
		btnUpdateTour_CapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TourDTO dto = new TourDTO();
				
				dto.setMaTour(txtUpdateMaTour.getText());
				dto.setTenTour(txtUpdateTenTour.getText());
				dto.setGiaVe(Double.parseDouble(txtUpdateGiaVe.getText()));
				dto.setDiemKhoiHanh(txtUpdateDiemKhoiHanh.getText());
				dto.setDiemDen(txtUpdateDiemDen.getText());
				
				tourBUS.update(dto);
				TourBUS.listTourDTO.set(selectedRow, dto);
				setRow(dto, selectedRow);
				cardLayout.show(cardsPane, "cardQuanLyTour");
				// clear all text after update
				txtUpdateMaTour.setText("");
				txtUpdateTenTour.setText("");
				txtUpdateGiaVe.setText("");
				txtUpdateDiemKhoiHanh.setText("");
				txtUpdateDiemDen.setText("");
			}
		});
		btnUpdateTour_CapNhat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateTour_CapNhat.setBounds(150, 400, 120, 30);
		cardUpdateTour.add(btnUpdateTour_CapNhat);
		
		JButton btnUpdateTour_QuayLai = new JButton("Quay l???i");
		btnUpdateTour_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyTour");
			}
		});
		btnUpdateTour_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateTour_QuayLai.setBounds(300, 400, 100, 30);
		cardUpdateTour.add(btnUpdateTour_QuayLai);
		// ===== TOUR UPDATE LAYOUT END HERE =====
		
		// ===== HDV LAYOUT START HERE =====
		JPanel cardQuanLyHdv = new JPanel();
		cardsPane.add(cardQuanLyHdv, "name_4568411886400");
		cardQuanLyHdv.setLayout(null);
		cardLayout.addLayoutComponent(cardQuanLyHdv, "cardQuanLyHdv");
		
		JLabel lblHdvCard = new JLabel("Trang qu???n l?? h?????ng d???n vi??n");
		lblHdvCard.setBounds(0, 0, 500, 100);
		lblHdvCard.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardQuanLyHdv.add(lblHdvCard);
		
		JLabel lblHdvSearch = new JLabel("T??m ki???m:");
		lblHdvSearch.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblHdvSearch.setBounds(20, 400, 80, 30);
		cardQuanLyHdv.add(lblHdvSearch);
		
		JTextField txtHdvSearch = new JTextField();
		txtHdvSearch.setBounds(100, 400, 200, 30);
		cardQuanLyHdv.add(txtHdvSearch);
		txtHdvSearch.setColumns(10);
		
		JButton btnHdvSearch = new JButton("T??m\r\n");
		btnHdvSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<TourDTO> listKQ;
				Object[] options = {
			            "T??m ki???m theo m?? Tour", "T??m ki???m theo t??n Tour", "????ng"
			        };
			        int select = JOptionPane.showOptionDialog(btnTourSearch, "B???n mu???n t??m ki???m theo ph????ng th???c n??o?", "T??y ch???n", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
			        
			        //System.out.println("select: " + select);
			        //m???? -> select: 0
			        //t????n -> select: 1
			        // chi phi -> select: 2
			        // ?????????ng -> select: 3
			        
			        if(select == 0){
			            String input = JOptionPane.showInputDialog(btnTourSearch, "M???i b???n nh???p m?? Tour !");
			            
			            if(input != null && input.length() > 0){
			                listKQ = tourBUS.getByMaTour(input);
			                tourTblModel.setRowCount(0);
			                
			                for(TourDTO dto : listKQ) {
								tourTblModel.addRow(new Object[] {
										dto.getMaTour(), dto.getTenTour(), dto.getGiaVe(), dto.getDiemKhoiHanh(), dto.getDiemDen()
								});
			                };
			            }
			            else {
			                JOptionPane.showMessageDialog(null, "L???i t??m ki???m !");
			            }
			        }
			        
			        if(select == 1){
			            String input = JOptionPane.showInputDialog(btnTourSearch, "M???i b???n nh???p t??n Tour !");
			            
			            if(input != null && input.length() > 0){
			                listKQ = tourBUS.getByTenTour(input);
			                tourTblModel.setRowCount(0);
			                
			                for(TourDTO dto : listKQ) {
								tourTblModel.addRow(new Object[] {
										dto.getMaTour(), dto.getTenTour(), dto.getGiaVe(), dto.getDiemKhoiHanh(), dto.getDiemDen()
								});
			                };
			            }
			            else {
			                JOptionPane.showMessageDialog(null, "L???i t??m ki???m !");
			            }
			        }
			}
		});
		btnHdvSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHdvSearch.setBounds(310, 400, 80, 30);
		cardQuanLyHdv.add(btnHdvSearch);
		
		JScrollPane hdvScrollPane = new JScrollPane();
		hdvScrollPane.setBounds(50, 450, 720, 300);
		cardQuanLyHdv.add(hdvScrollPane);
		
		tblHdv = new JTable();
		tblHdv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tblHdv.setRowHeight(50);
		hdvTblModel = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"M?? HDV", "H??? t??n", "Ng??y sinh", "Gi???i t??nh", "?????a ch???", "S??? ??i???n tho???i"
				}
			);
		tblHdv.setModel(hdvTblModel);
		loadTblHdv();
		
		hdvScrollPane.setViewportView(tblHdv);
		tblHdv.setFillsViewportHeight(true);
		
		JButton btnHdvReload = new JButton("T???i l???i b???ng");
		btnHdvReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//hdvTblModel.setRowCount(0);
				//loadTblHdv();
				ArrayList<HuongDanVienDTO> listKQ;
				listKQ = huongDanVienBUS.getAll();
				
				hdvTblModel.setRowCount(0);
				
				for(HuongDanVienDTO dto : listKQ) {
                	hdvTblModel.addRow(new Object[] {
							dto.getMaHDV(), dto.getHoTen(), dto.getNgaySinh(), dto.getGioiTinh(), dto.getDiaChi(),dto.getSdt()
					});
                };
			}
		});
		btnHdvReload.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHdvReload.setBounds(795, 450, 220, 30);
		cardQuanLyHdv.add(btnHdvReload);
		
		JButton btnHdvDel = new JButton("X??a h?????ng d???n vi??n");
		btnHdvDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tblHdv.getSelectedRow();
				
				if(selectedRow>=0) {
					int result=JOptionPane.showConfirmDialog(null,"B???n c?? ch???c mu???n x??a th??ng tin n??y?","th??ng b??o",JOptionPane.YES_NO_OPTION); 
					if(result==JOptionPane.YES_OPTION) {
					String maHdv = (String) tblHdv.getValueAt(selectedRow, 0);
					
					huongDanVienBUS.deleteById(maHdv);
					hdvTblModel.removeRow(selectedRow);
					}
					else if(result==JOptionPane.NO_OPTION) {
						JOptionPane.showMessageDialog(null,"Th??ng tin n??y ch??a ???????c x??a!");
					}
				}
				if(selectedRow<0 ) {
					JOptionPane.showMessageDialog(cardQuanLyTaiKhoan, "B???n ch??a ch???n tr?????ng d??? li???u n??o c???");
				}
			}
		});
		btnHdvDel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHdvDel.setBounds(795, 500, 220, 30);;
		cardQuanLyHdv.add(btnHdvDel);
		
		JButton btnHdvAdd = new JButton("Th??m h?????ng d???n vi??n");
		btnHdvAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardAddHdv");
			}
		});
		btnHdvAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHdvAdd.setBounds(795, 550, 220, 30);
		cardQuanLyHdv.add(btnHdvAdd);
		
		JButton btnHdvUpdate = new JButton("C???p nh???t h?????ng d???n vi??n");
		btnHdvUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tblHdv.getSelectedRow();
				if(selectedRow>=0) {
				cardLayout.show(cardsPane, "cardUpdateHdv");
				
				txtUpdateMaHdv.setText((String) tblHdv.getValueAt(selectedRow, 0));
				txtUpdateHoTenHdv.setText((String) tblHdv.getValueAt(selectedRow, 1));
				txtUpdateNgaySinhHdv.setText((String) tblHdv.getValueAt(selectedRow, 2));
				txtUpdateGioiTinhHdv.setText((String) tblHdv.getValueAt(selectedRow, 3));
				txtUpdateDiaChiHdv.setText((String) tblHdv.getValueAt(selectedRow, 4));
				txtUpdateSdtHdv.setText((String) tblHdv.getValueAt(selectedRow, 5));
				}
				if(selectedRow<0 ) {
					JOptionPane.showMessageDialog(cardQuanLyHdv, "B???n ch??a ch???n tr?????ng d??? li???u n??o c???");
				}
			}
		});
		btnHdvUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHdvUpdate.setBounds(795, 600, 220, 30);
		cardQuanLyHdv.add(btnHdvUpdate);
		// ===== HDV LAYOUT END HERE =====
		
		// ===== ADD HDV LAYOUT START HERE =====
		JPanel cardAddHdv = new JPanel();
		cardsPane.add(cardAddHdv);
		cardAddHdv.setLayout(null);
		cardLayout.addLayoutComponent(cardAddHdv, "cardAddHdv");
		
		JLabel lblAddHdvContent = new JLabel("Trang th??m h?????ng d???n vi??n");
		lblAddHdvContent.setBounds(0, 0, 500, 100);
		lblAddHdvContent.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardAddHdv.add(lblAddHdvContent);
		
		JLabel lblAddMaHdv = new JLabel("Nh???p m?? h?????ng d???n vi??n:");
		lblAddMaHdv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddMaHdv.setBounds(50, 100, 200, 30);
		cardAddHdv.add(lblAddMaHdv);
		
		JTextField txtAddMaHdv = new JTextField();
		txtAddMaHdv.setColumns(10);
		txtAddMaHdv.setBounds(250, 100, 300, 30);
		cardAddHdv.add(txtAddMaHdv);
		
		JLabel lblAddHoTenHdv = new JLabel("Nh???p h??? t??n:");
		lblAddHoTenHdv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddHoTenHdv.setBounds(50, 150, 200, 30);
		cardAddHdv.add(lblAddHoTenHdv);
		
		JTextField txtAddHoTenHdv = new JTextField();
		txtAddHoTenHdv.setColumns(10);
		txtAddHoTenHdv.setBounds(250, 150, 300, 30);
		cardAddHdv.add(txtAddHoTenHdv);
		
		JLabel lblAddNgaySinhHdv = new JLabel("Nh???p ng??y sinh:");
		lblAddNgaySinhHdv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddNgaySinhHdv.setBounds(50, 200, 200, 30);
		cardAddHdv.add(lblAddNgaySinhHdv);
		
		JTextField txtAddNgaySinhHdv = new JTextField();
		txtAddNgaySinhHdv.setColumns(10);
		txtAddNgaySinhHdv.setBounds(250, 200, 300, 30);
		cardAddHdv.add(txtAddNgaySinhHdv);
		
		JLabel lblAddGioiTinhHdv = new JLabel("Nh???p gi???i t??nh:");
		lblAddGioiTinhHdv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddGioiTinhHdv.setBounds(50, 250, 200, 30);
		cardAddHdv.add(lblAddGioiTinhHdv);
		
		JTextField txtAddGioiTinhHdv = new JTextField();
		txtAddGioiTinhHdv.setColumns(10);
		txtAddGioiTinhHdv.setBounds(250, 250, 300, 30);
		cardAddHdv.add(txtAddGioiTinhHdv);
		
		JLabel lblAddDiaChiHdv = new JLabel("Nh???p ?????a ch???:");
		lblAddDiaChiHdv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddDiaChiHdv.setBounds(50, 300, 200, 30);
		cardAddHdv.add(lblAddDiaChiHdv);
		
		JTextField txtAddDiaChiHdv = new JTextField();
		txtAddDiaChiHdv.setColumns(10);
		txtAddDiaChiHdv.setBounds(250, 300, 300, 30);
		cardAddHdv.add(txtAddDiaChiHdv);
		
		JLabel lblAddSdtHdv = new JLabel("Nh???p s??? ??i???n tho???i:");
		lblAddSdtHdv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddSdtHdv.setBounds(50, 350, 200, 30);
		cardAddHdv.add(lblAddSdtHdv);
		
		JTextField txtAddSdtHdv = new JTextField();
		txtAddSdtHdv.setColumns(10);
		txtAddSdtHdv.setBounds(250, 350, 300, 30);
		cardAddHdv.add(txtAddSdtHdv);
		
		JButton btnAddHdv_ThemMoi = new JButton("Th??m m???i");
		btnAddHdv_ThemMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb=new StringBuilder();
		        
		    	if(txtAddMaHdv.getText().equals("")){
		            sb.append("*M?? h?????ng d???n vi??n kh??ng ???????c ????? tr???ng\n");
		        }
		    	else 
		        {
		        	for(HuongDanVienDTO dto: HuongDanVienBUS.listHuongDanVienDTO){
			            if(txtAddMaHdv.getText().equals(String.valueOf(dto.getMaHDV()))){
			                JOptionPane.showMessageDialog(cardAddHdv, "M?? h?????ng d???n vi??n ???? t???n t???i!", "Th??ng b??o", JOptionPane.ERROR_MESSAGE);
			                return;
			            } 
		        	}
		        }
		    	// t??n nh??n vi??n k ch???a k?? t??? s???
		    	if(txtAddHoTenHdv.getText().equals("")) {
		            sb.append("*H??? t??n HDV kh??ng ???????c ????? tr???ng\n");
		    	}
		    	else if(!Pattern.matches("\\D+", txtAddHoTenHdv.getText())) {
		    		sb.append("H??? t??n HDV kh??ng h???p l???\n");
		    	}
		    	if(txtAddNgaySinhHdv.getText().equals("")) {
		            sb.append("*Ng??y sinh HDV kh??ng ???????c ????? tr???ng\n");
		    	}
		    	else if(!Pattern.matches("^([0-9]{4}[-/]?((0[13-9]|1[012])[-/]?(0[1-9]|[12][0-9]|30)|(0[13578]|1[02])[-/]?31|02[-/]?(0[1-9]|1[0-9]|2[0-8]))|([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00)[-/]?02[-/]?29)$", txtAddNgaySinhHdv.getText())) {
		    		sb.append("Vui l??ng nh???p ng??y sinh ????ng ?????nh d???ng yyyy-MM-dd\n");
		    	}
		    	if(txtAddGioiTinhHdv.getText().equals("")) {
		            sb.append("*Gi???i t??nh HDV kh??ng ???????c ????? tr???ng\n");
		    	}
		    	else if(!Pattern.matches("\\D+", txtAddGioiTinhHdv.getText())) {
		    		sb.append("Gi???i t??nh HDV kh??ng h???p l???\n");
		    	}
		    	if(txtAddDiaChiHdv.getText().equals("")) {
		            sb.append("*?????a ch??? HDV kh??ng ???????c ????? tr???ng\n");
		    	}
		    	else if(!Pattern.matches("\\D+", txtAddDiaChiHdv.getText())) {
		    		sb.append("?????a ch??? HDV kh??ng h???p l???\n");
		    	}
		    	//ki???m tra SDT
		    	// s??? ??i???n tho???i c?? 10 ch??? s???, b???t ?????u b???ng s??? 0. S??? ti???p theo kh??ng ???????c l?? s??? 0.
		    	if(txtAddSdtHdv.getText().equals("")) {
		    		sb.append("*S??? ??i???n tho???i kh??ng ???????c ????? tr???ng\n");
		    	}
		    	else if(!Pattern.matches("^0{1}[1-9]{1}[0-9]{8}$", txtAddSdtHdv.getText())) {
		    			sb.append("S??? ??i???n tho???i kh??ng h???p l???\n");
		    	}
		    	
		    	if(sb.length()>0) {
		    		JOptionPane.showMessageDialog(cardAddHdv, sb.toString(),"Th??ng b??o",JOptionPane.ERROR_MESSAGE);
		    		return;
		    	}
				HuongDanVienDTO dto = new HuongDanVienDTO();
				
				dto.setMaHDV(txtAddMaHdv.getText());
				dto.setHoTen(txtAddHoTenHdv.getText());
				dto.setNgaySinh(txtAddNgaySinhHdv.getText());
				dto.setGioiTinh(txtAddGioiTinhHdv.getText());
				dto.setDiaChi(txtAddDiaChiHdv.getText());
				dto.setSdt(txtAddSdtHdv.getText());
			
				huongDanVienBUS.add(dto);
				HuongDanVienBUS.listHuongDanVienDTO.add(dto);
				addRow(dto);
				cardLayout.show(cardsPane, "cardQuanLyHdv");
				// clear all text after add
				txtAddMaHdv.setText("");
				txtAddHoTenHdv.setText("");
				txtAddNgaySinhHdv.setText("");
				txtAddGioiTinhHdv.setText("");
				txtAddDiaChiHdv.setText("");
				txtAddSdtHdv.setText("");
			}
		});
		btnAddHdv_ThemMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddHdv_ThemMoi.setBounds(150, 400, 120, 30);
		cardAddHdv.add(btnAddHdv_ThemMoi);
		
		JButton btnAddHdv_QuayLai = new JButton("Quay l???i");
		btnAddHdv_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyHdv");
			}
		});
		btnAddHdv_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddHdv_QuayLai.setBounds(300, 400, 100, 30);
		cardAddHdv.add(btnAddHdv_QuayLai);
		// ===== ADD HDV LAYOUT END HERE =====
		
		// ===== UPDATE HDV LAYOUT START HERE ===== 
		JPanel cardUpdateHdv = new JPanel();
		cardsPane.add(cardUpdateHdv);
		cardUpdateHdv.setLayout(null);
		cardLayout.addLayoutComponent(cardUpdateHdv, "cardUpdateHdv");
		
		JLabel lblUpdateHdvContent = new JLabel("Trang c???p nh???t h?????ng d???n vi??n");
		lblUpdateHdvContent.setBounds(0, 0, 500, 100);
		lblUpdateHdvContent.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardUpdateHdv.add(lblUpdateHdvContent);
		
		JLabel lblUpdateMaHdv = new JLabel("Nh???p m?? h?????ng d???n vi??n:");
		lblUpdateMaHdv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateMaHdv.setBounds(50, 100, 200, 30);
		cardUpdateHdv.add(lblUpdateMaHdv);
		
		txtUpdateMaHdv = new JTextField();
		txtUpdateMaHdv.setColumns(10);
		txtUpdateMaHdv.setBounds(250, 100, 300, 30);
		cardUpdateHdv.add(txtUpdateMaHdv);
		
		JLabel lblUpdateHoTenHdv = new JLabel("Nh???p h??? t??n:");
		lblUpdateHoTenHdv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateHoTenHdv.setBounds(50, 150, 200, 30);
		cardUpdateHdv.add(lblUpdateHoTenHdv);
		
		txtUpdateHoTenHdv = new JTextField();
		txtUpdateHoTenHdv.setColumns(10);
		txtUpdateHoTenHdv.setBounds(250, 150, 300, 30);
		cardUpdateHdv.add(txtUpdateHoTenHdv);
		
		JLabel lblUpdateNgaySinhHdv = new JLabel("Nh???p ng??y sinh:");
		lblUpdateNgaySinhHdv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateNgaySinhHdv.setBounds(50, 200, 200, 30);
		cardUpdateHdv.add(lblUpdateNgaySinhHdv);
		
		txtUpdateNgaySinhHdv = new JTextField();
		txtUpdateNgaySinhHdv.setColumns(10);
		txtUpdateNgaySinhHdv.setBounds(250, 200, 300, 30);
		cardUpdateHdv.add(txtUpdateNgaySinhHdv);
		
		JLabel lblUpdateGioiTinh = new JLabel("Nh???p gi???i t??nh:");
		lblUpdateGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateGioiTinh.setBounds(50, 250, 200, 30);
		cardUpdateHdv.add(lblUpdateGioiTinh);
		
		txtUpdateGioiTinhHdv = new JTextField();
		txtUpdateGioiTinhHdv.setColumns(10);
		txtUpdateGioiTinhHdv.setBounds(250, 250, 300, 30);
		cardUpdateHdv.add(txtUpdateGioiTinhHdv);
		
		JLabel lblUpdateDiaChiHdv = new JLabel("Nh???p ?????a ch???:");
		lblUpdateDiaChiHdv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateDiaChiHdv.setBounds(50, 300, 200, 30);
		cardUpdateHdv.add(lblUpdateDiaChiHdv);
		
		txtUpdateDiaChiHdv = new JTextField();
		txtUpdateDiaChiHdv.setColumns(10);
		txtUpdateDiaChiHdv.setBounds(250, 300, 300, 30);
		cardUpdateHdv.add(txtUpdateDiaChiHdv);
		
		JLabel lblUpdateSdtHdv = new JLabel("Nh???p s??? ??i???n tho???i:");
		lblUpdateSdtHdv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateSdtHdv.setBounds(50, 350, 200, 30);
		cardUpdateHdv.add(lblUpdateSdtHdv);
		
		txtUpdateSdtHdv = new JTextField();
		txtUpdateSdtHdv.setColumns(10);
		txtUpdateSdtHdv.setBounds(250, 350, 300, 30);
		cardUpdateHdv.add(txtUpdateSdtHdv);
		
		JButton btnUpdateHdv_CapNhat = new JButton("C???p nh???t");
		btnUpdateHdv_CapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HuongDanVienDTO dto = new HuongDanVienDTO();
				
				dto.setMaHDV(txtUpdateMaHdv.getText());
				dto.setHoTen(txtUpdateHoTenHdv.getText());
				dto.setNgaySinh(txtUpdateNgaySinhHdv.getText());
				dto.setGioiTinh(txtUpdateGioiTinhHdv.getText());
				dto.setDiaChi(txtUpdateDiaChiHdv.getText());
				dto.setSdt(txtUpdateSdtHdv.getText());
				
				huongDanVienBUS.update(dto);
				HuongDanVienBUS.listHuongDanVienDTO.set(selectedRow, dto);
				setRow(dto, selectedRow);
				cardLayout.show(cardsPane, "cardQuanLyHdv");
				// clear all text after update
				txtUpdateMaHdv.setText("");
				txtUpdateHoTenHdv.setText("");
				txtUpdateHoTenHdv.setText("");
				txtUpdateHoTenHdv.setText("");
				txtUpdateDiaChiHdv.setText("");
				txtUpdateSdtHdv.setText("");
			}
		});
		btnUpdateHdv_CapNhat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateHdv_CapNhat.setBounds(150, 400, 120, 30);
		cardUpdateHdv.add(btnUpdateHdv_CapNhat);
		
		JButton btnUpdateHdv_QuayLai = new JButton("Quay l???i");
		btnUpdateHdv_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyHdv");
			}
		});
		btnUpdateHdv_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateHdv_QuayLai.setBounds(300, 400, 100, 30);
		cardUpdateHdv.add(btnUpdateHdv_QuayLai);
		// ===== UPDATE HDV LAYOUT END HERE
		
		// ===== KHACH HANG LAYOUT START HERE =====
		JPanel cardQuanLyKhachHang = new JPanel();
		cardsPane.add(cardQuanLyKhachHang, "name_4568411886400");
		cardQuanLyKhachHang.setLayout(null);
		cardLayout.addLayoutComponent(cardQuanLyKhachHang, "cardQuanLyKhachHang");
		
		JLabel lblKhachHang_TieuDe = new JLabel("Trang qu???n l?? kh??ch h??ng");
		lblKhachHang_TieuDe.setBounds(0, 0, 500, 100);
		lblKhachHang_TieuDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardQuanLyKhachHang.add(lblKhachHang_TieuDe);
		
		JLabel lblKhachHang_TimKiem = new JLabel("T??m ki???m:");
		lblKhachHang_TimKiem.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblKhachHang_TimKiem.setBounds(20, 100, 80, 30);
		cardQuanLyKhachHang.add(lblKhachHang_TimKiem);
		
		JTextField txtKhachHang_TimKiem = new JTextField();
		txtKhachHang_TimKiem.setBounds(100, 100, 200, 30);
		txtKhachHang_TimKiem.setColumns(10);
		cardQuanLyKhachHang.add(txtKhachHang_TimKiem);
		
		JButton btnKhachHang_TimKiem = new JButton("T??m\r\n");
		btnKhachHang_TimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<KhachHangDTO> listKQ;
				Object[] options = {
			            "T??m ki???m theo m?? kh??ch h??ng","T??m ki???m theo h??? kh??ch h??ng", "T??m ki???m theo t??n kh??ch h??ng", "????ng"
			        };
			        int select = JOptionPane.showOptionDialog(btnTourSearch, "B???n mu???n t??m ki???m theo ph????ng th???c n??o?", "T??y ch???n", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[3]);
			        
			        //System.out.println("select: " + select);
			        //m???? -> select: 0
			        //t????n -> select: 1
			        // chi phi -> select: 2
			        // ?????????ng -> select: 3
			        
			        if(select == 0){
			            String input = JOptionPane.showInputDialog(btnTourSearch, "M???i b???n nh???p m?? kh??ch h??ng !");
			            
			            if(input != null && input.length() > 0){
			                listKQ = khachHangBUS.getByMaKH(input);
			                khachHangTblModel.setRowCount(0);
			                
			                for(KhachHangDTO dto : listKQ) {
			                	khachHangTblModel.addRow(new Object[] {
										dto.getMaKH(), dto.getHoTenKH(), dto.getDiaChi(), dto.getSdt(), dto.getMaDoan()
								});
			                };
			            }
			            else {
			                JOptionPane.showMessageDialog(null, "L???i t??m ki???m !");
			            }
			        }
			        
			        if(select == 1){
			            String input = JOptionPane.showInputDialog(btnTourSearch, "M???i b???n nh???p h??? kh??ch h??ng !");
			            
			            if(input != null && input.length() > 0){
			                listKQ = khachHangBUS.getByHoKH(input);
			                khachHangTblModel.setRowCount(0);
			                
			                for(KhachHangDTO dto : listKQ) {
			                	khachHangTblModel.addRow(new Object[] {
										dto.getMaKH(), dto.getHoTenKH(), dto.getDiaChi(), dto.getSdt(), dto.getMaDoan()
								});
			                };
			            }
			            else {
			                JOptionPane.showMessageDialog(null, "L???i t??m ki???m !");
			            }
			        }
			        
			        if(select == 2){
			            String input = JOptionPane.showInputDialog(btnTourSearch, "M???i b???n nh???p t??n kh??ch h??ng !");
			            
			            if(input != null && input.length() > 0){
			                listKQ = khachHangBUS.getByTenKH(input);
			                khachHangTblModel.setRowCount(0);
			                
			                for(KhachHangDTO dto : listKQ) {
			                	khachHangTblModel.addRow(new Object[] {
										dto.getMaKH(), dto.getHoTenKH(), dto.getDiaChi(), dto.getSdt(), dto.getMaDoan()
								});
			                };
			            }
			            else {
			                JOptionPane.showMessageDialog(null, "L???i t??m ki???m !");
			            }
			        }
			}
		});
		btnKhachHang_TimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKhachHang_TimKiem.setBounds(310, 100, 80, 30);
		cardQuanLyKhachHang.add(btnKhachHang_TimKiem);
		
		JScrollPane khachHangScrollPane = new JScrollPane();
		khachHangScrollPane.setBounds(50, 150, 750, 300);
		cardQuanLyKhachHang.add(khachHangScrollPane);
		
		tblKhachHang = new JTable();
		tblKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tblKhachHang.setRowHeight(50);
		String[] colNamesTblKhachHang = {"M?? kh??ch h??ng", "H??? t??n kh??ch h??ng", "?????a ch???", "S??? ??i???n tho???i", "M?? ??o??n"};
		khachHangTblModel = new DefaultTableModel();
		tblKhachHang.setModel(khachHangTblModel);
		for(String colName : colNamesTblKhachHang) {
			khachHangTblModel.addColumn(colName);
		}
		loadTblKhachHang();
		
		khachHangScrollPane.setViewportView(tblKhachHang);
		tblKhachHang.setFillsViewportHeight(true);
		
		JButton btnKhachHang_TaiLai = new JButton("T???i l???i b???ng");
		btnKhachHang_TaiLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//khachHangTblModel.setRowCount(0);
				//loadTblKhachHang();
				ArrayList<KhachHangDTO> listKQ;
				listKQ = khachHangBUS.getAll();
				
				khachHangTblModel.setRowCount(0);
				for(KhachHangDTO dto : listKQ) {
                	khachHangTblModel.addRow(new Object[] {
							dto.getMaKH(), dto.getHoTenKH(), dto.getDiaChi(), dto.getSdt(), dto.getMaDoan()
					});
                };
			}
		});
		btnKhachHang_TaiLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKhachHang_TaiLai.setBounds(820, 150, 200, 30);
		cardQuanLyKhachHang.add(btnKhachHang_TaiLai);
		
		JButton btnKhachHang_Xoa = new JButton("X??a kh??ch h??ng");
		btnKhachHang_Xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tblKhachHang.getSelectedRow();
				if(selectedRow>=0) {
					int result=JOptionPane.showConfirmDialog(null, "B???n c?? ch???c mu???n x??a th??ng tin n??y?", "Th??ng b??o",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(result==JOptionPane.YES_OPTION) {
					String maKH = (String) tblKhachHang.getValueAt(selectedRow, 0);
					
					khachHangBUS.deleteById(maKH);
					khachHangTblModel.removeRow(selectedRow);
					}
					else if(result==JOptionPane.NO_OPTION){
						JOptionPane.showMessageDialog(null, "Th??ng tin n??y ch??a ???????c x??a !");
					}
				}
				
				if(selectedRow<0 ) {
					JOptionPane.showMessageDialog(cardQuanLyKhachHang, "B???n ch??a ch???n tr?????ng d??? li???u n??o c???");
				}
			}
		});
		btnKhachHang_Xoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKhachHang_Xoa.setBounds(820, 200, 200, 30);;
		cardQuanLyKhachHang.add(btnKhachHang_Xoa);
		
		JButton btnKhachHang_ThemMoi = new JButton("Th??m kh??ch h??ng");
		btnKhachHang_ThemMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardAddKhachHang");
			}
		});
		btnKhachHang_ThemMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKhachHang_ThemMoi.setBounds(820, 250, 200, 30);
		cardQuanLyKhachHang.add(btnKhachHang_ThemMoi);
		
		btnKhachHang_CapNhat = new JButton("C???p nh???t kh??ch h??ng");
		addActionListenerBtnKhachHang_Update();
		btnKhachHang_CapNhat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKhachHang_CapNhat.setBounds(820, 300, 200, 30);
		cardQuanLyKhachHang.add(btnKhachHang_CapNhat);
		// ===== KHACH HANG LAYOUT END HERE =====
		
		// ===== ADD KHACH HANG LAYOUT START HERE =====
		JPanel cardAddKhachHang = new JPanel();
		cardsPane.add(cardAddKhachHang);
		cardAddKhachHang.setLayout(null);
		cardLayout.addLayoutComponent(cardAddKhachHang, "cardAddKhachHang");
		
		JLabel lblAddKhachHang_TieuDe = new JLabel("Trang th??m kh??ch h??ng");
		lblAddKhachHang_TieuDe.setBounds(0, 0, 500, 100);
		lblAddKhachHang_TieuDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardAddKhachHang.add(lblAddKhachHang_TieuDe);
		
		JLabel lblAddMaKhachHang = new JLabel("Nh???p m?? KH:");
		lblAddMaKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddMaKhachHang.setBounds(50, 100, 200, 30);
		cardAddKhachHang.add(lblAddMaKhachHang);
		
		JTextField txtAddMaKhachHang = new JTextField();
		txtAddMaKhachHang.setColumns(10);
		txtAddMaKhachHang.setBounds(250, 100, 300, 30);
		cardAddKhachHang.add(txtAddMaKhachHang);
		
		JLabel lblAddHoTenKhachHang = new JLabel("Nh???p h??? t??n KH:");
		lblAddHoTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddHoTenKhachHang.setBounds(50, 150, 200, 30);
		cardAddKhachHang.add(lblAddHoTenKhachHang);
		
		JTextField txtAddHoTenKhachHang = new JTextField();
		txtAddHoTenKhachHang.setColumns(10);
		txtAddHoTenKhachHang.setBounds(250, 150, 300, 30);
		cardAddKhachHang.add(txtAddHoTenKhachHang);
		
		JLabel lblAddDiaChiKhachHang = new JLabel("Nh???p ?????a ch??? KH:");
		lblAddDiaChiKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddDiaChiKhachHang.setBounds(50, 200, 200, 30);
		cardAddKhachHang.add(lblAddDiaChiKhachHang);
		
		JTextField txtAddDiaChiKhachHang = new JTextField();
		txtAddDiaChiKhachHang.setColumns(10);
		txtAddDiaChiKhachHang.setBounds(250, 200, 300, 30);
		cardAddKhachHang.add(txtAddDiaChiKhachHang);
		
		JLabel lblAddSdtKhachHang = new JLabel("Nh???p s??? ??i???n tho???i:");
		lblAddSdtKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddSdtKhachHang.setBounds(50, 250, 200, 30);
		cardAddKhachHang.add(lblAddSdtKhachHang);
		
		JTextField txtAddSdtKhachHang = new JTextField();
		txtAddSdtKhachHang.setColumns(10);
		txtAddSdtKhachHang.setBounds(250, 250, 300, 30);
		cardAddKhachHang.add(txtAddSdtKhachHang);
		
		JLabel lblAddMaDoanKhachHang = new JLabel("Ch???n ??o??n:");
		lblAddMaDoanKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddMaDoanKhachHang.setBounds(50, 300, 200, 30);
		cardAddKhachHang.add(lblAddMaDoanKhachHang);
		
//		JTextField txtAddMaDoanKhachHang = new JTextField();
//		txtAddMaDoanKhachHang.setColumns(10);
//		txtAddMaDoanKhachHang.setBounds(250, 300, 300, 30);
//		cardAddKhachHang.add(txtAddMaDoanKhachHang);
		
		Vector<String> listMaDoan = doanBUS.getAllMaDoan();
		JComboBox<String> cbAddMaDoanKhachHang = new JComboBox<String>(listMaDoan);
		cbAddMaDoanKhachHang.setBounds(250, 300, 150, 30);
		cardAddKhachHang.add(cbAddMaDoanKhachHang);
		
		JButton btnAddKhachHang_ThemMoi = new JButton("Th??m m???i");
		btnAddKhachHang_ThemMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb=new StringBuilder();
		        
		    	if(txtAddMaKhachHang.getText().equals("")){
		            sb.append("*M?? kh??ch h??ng kh??ng ???????c ????? tr???ng\n");
		        }
		    	else 
		        {
		        	for(KhachHangDTO dto: KhachHangBUS.listKhachHangDTO){
			            if(txtAddMaKhachHang.getText().equals(String.valueOf(dto.getMaKH()))){
			                JOptionPane.showMessageDialog(cardAddKhachHang, "M?? kh??ch h??ng ???? t???n t???i!", "Th??ng b??o", JOptionPane.ERROR_MESSAGE);
			                return;
			            } 
		        	}
		        }
		    	// t??n nh??n vi??n k ch???a k?? t??? s???
		    	if(txtAddHoTenKhachHang.getText().equals("")) {
		            sb.append("*H??? t??n kh??ch h??ng kh??ng ???????c ????? tr???ng\n");
		    	}
		    	else if(!Pattern.matches("\\D+", txtAddHoTenKhachHang.getText())) {
		    		sb.append("H??? t??n kh??ch h??ng kh??ng h???p l???\n");
		    	}
		    	if(txtAddDiaChiKhachHang.getText().equals("")) {
		            sb.append("*?????a ch??? kh??ch h??ng kh??ng ???????c ????? tr???ng\n");
		    	}
		    	else if(!Pattern.matches("\\D+", txtAddHoTenKhachHang.getText())) {
		    		sb.append("?????a ch??? kh??ch h??ng kh??ng h???p l???\n");
		    	}
		    	//ki???m tra SDT
		    	// s??? ??i???n tho???i c?? 10 ch??? s???, b???t ?????u b???ng s??? 0. S??? ti???p theo kh??ng ???????c l?? s??? 0.
		    	if(txtAddSdtKhachHang.getText().equals("")) {
		    		sb.append("*S??? ??i???n tho???i kh??ng ???????c ????? tr???ng\n");
		    	}
		    	else if(!Pattern.matches("^0{1}[1-9]{1}[0-9]{8}$", txtAddSdtKhachHang.getText())) {
		    			sb.append("S??? ??i???n tho???i kh??ng h???p l???\n");
		    	}
		    	
		    	if(sb.length()>0) {
		    		JOptionPane.showMessageDialog(cardAddKhachHang, sb.toString(),"Th??ng b??o",JOptionPane.ERROR_MESSAGE);
		    		return;
		    	}
		    	
				KhachHangDTO dto = new KhachHangDTO();
				
				dto.setMaKH(txtAddMaKhachHang.getText());
				dto.setHoTenKH(txtAddHoTenKhachHang.getText());
				dto.setDiaChi(txtAddDiaChiKhachHang.getText());
				dto.setSdt(txtAddSdtKhachHang.getText());
				dto.setMaDoan((String) cbAddMaDoanKhachHang.getSelectedItem());
				
				khachHangBUS.add(dto);
				KhachHangBUS.listKhachHangDTO.add(dto);
				addRow(dto);
				cardLayout.show(cardsPane, "cardQuanLyKhachHang");
				// clear all text after add
				txtAddMaKhachHang.setText("");
				txtAddHoTenKhachHang.setText("");
				txtAddDiaChiKhachHang.setText("");
				txtAddSdtKhachHang.setText("");
				cbAddMaDoanKhachHang.setSelectedIndex(0);
			}
		});
		btnAddKhachHang_ThemMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddKhachHang_ThemMoi.setBounds(150, 400, 120, 30);
		cardAddKhachHang.add(btnAddKhachHang_ThemMoi);
		
		JButton btnAddKhachHang_QuayLai = new JButton("Quay l???i");
		btnAddKhachHang_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyKhachHang");
			}
		});
		btnAddKhachHang_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddKhachHang_QuayLai.setBounds(300, 400, 100, 30);
		cardAddKhachHang.add(btnAddKhachHang_QuayLai);
		// ===== ADD KHACH HANG LAYOUT END HERE =====
		
		// ===== UPDATE KHACH HANG LAYOUT START HERE =====
		JPanel cardUpdateKhachHang = new JPanel();
		cardsPane.add(cardUpdateKhachHang);
		cardUpdateKhachHang.setLayout(null);
		cardLayout.addLayoutComponent(cardUpdateKhachHang, "cardUpdateKhachHang");
		
		JLabel lblUpdateKhachHangContent = new JLabel("Trang c???p nh???t kh??ch h??ng");
		lblUpdateKhachHangContent.setBounds(0, 0, 400, 100);
		lblUpdateKhachHangContent.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardUpdateKhachHang.add(lblUpdateKhachHangContent);
		
		JLabel lblUpdateMaKhachHang = new JLabel("Nh???p m?? KH:");
		lblUpdateMaKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateMaKhachHang.setBounds(50, 100, 150, 30);
		cardUpdateKhachHang.add(lblUpdateMaKhachHang);
		
		txtUpdateMaKhachHang = new JTextField();
		txtUpdateMaKhachHang.setColumns(10);
		txtUpdateMaKhachHang.setBounds(200, 100, 300, 30);
		cardUpdateKhachHang.add(txtUpdateMaKhachHang);
		
		JLabel lblUpdateHoTenKhachHang = new JLabel("Nh???p h??? t??n KH:");
		lblUpdateHoTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateHoTenKhachHang.setBounds(50, 150, 150, 30);
		cardUpdateKhachHang.add(lblUpdateHoTenKhachHang);
		
		txtUpdateHoTenKhachHang = new JTextField();
		txtUpdateHoTenKhachHang.setColumns(10);
		txtUpdateHoTenKhachHang.setBounds(200, 150, 300, 30);
		cardUpdateKhachHang.add(txtUpdateHoTenKhachHang);
		
		JLabel lblUpdateDiaChiKhachHang = new JLabel("Nh???p ?????a ch??? KH:");
		lblUpdateDiaChiKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateDiaChiKhachHang.setBounds(50, 200, 150, 30);
		cardUpdateKhachHang.add(lblUpdateDiaChiKhachHang);
		
		txtUpdateDiaChiKhachHang = new JTextField();
		txtUpdateDiaChiKhachHang.setColumns(10);
		txtUpdateDiaChiKhachHang.setBounds(200, 200, 300, 30);
		cardUpdateKhachHang.add(txtUpdateDiaChiKhachHang);
		
		JLabel lblUpdateSdtKhachHang = new JLabel("Nh???p s??? ??i???n tho???i KH:");
		lblUpdateSdtKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateSdtKhachHang.setBounds(50, 250, 150, 30);
		cardUpdateKhachHang.add(lblUpdateSdtKhachHang);
		
		txtUpdateSdtKhachHang = new JTextField();
		txtUpdateSdtKhachHang.setColumns(10);
		txtUpdateSdtKhachHang.setBounds(200, 250, 300, 30);
		cardUpdateKhachHang.add(txtUpdateSdtKhachHang);
		
		JLabel lblUpdateMaDoanKhachHang = new JLabel("Nh???p m?? ??o??n KH:");
		lblUpdateMaDoanKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateMaDoanKhachHang.setBounds(50, 300, 150, 30);
		cardUpdateKhachHang.add(lblUpdateMaDoanKhachHang);
		
		txtUpdateMaDoanKhachHang = new JTextField();
		txtUpdateMaDoanKhachHang.setColumns(10);
		txtUpdateMaDoanKhachHang.setBounds(200, 300, 300, 30);
		cardUpdateKhachHang.add(txtUpdateMaDoanKhachHang);
		
		JButton btnUpdateKhachHang_CapNhat = new JButton("C???p nh???t");
		btnUpdateKhachHang_CapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tblKhachHang.getSelectedRow();
				KhachHangDTO dto = new KhachHangDTO();
				
				dto.setMaKH(txtUpdateMaKhachHang.getText());
				dto.setHoTenKH(txtUpdateHoTenKhachHang.getText());
				dto.setDiaChi(txtUpdateDiaChiKhachHang.getText());
				dto.setSdt(txtUpdateSdtKhachHang.getText());
				dto.setMaDoan(txtUpdateMaDoanKhachHang.getText());
				
				khachHangBUS.update(dto);
				KhachHangBUS.listKhachHangDTO.set(selectedRow, dto);
				setRow(dto, selectedRow);
				cardLayout.show(cardsPane, "cardQuanLyKhachHang");
				// clear all text after update
				txtUpdateMaKhachHang.setText("");
				txtUpdateHoTenKhachHang.setText("");
				txtUpdateDiaChiKhachHang.setText("");
				txtUpdateSdtKhachHang.setText("");
				txtUpdateMaDoanKhachHang.setText("");
			}
		});
		btnUpdateKhachHang_CapNhat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateKhachHang_CapNhat.setBounds(150, 400, 120, 30);
		cardUpdateKhachHang.add(btnUpdateKhachHang_CapNhat);
		
		JButton btnUpdateKhachHang_QuayLai = new JButton("Quay l???i");
		btnUpdateKhachHang_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyKhachHang");
			}
		});
		btnUpdateKhachHang_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateKhachHang_QuayLai.setBounds(300, 400, 100, 30);
		cardUpdateKhachHang.add(btnUpdateKhachHang_QuayLai);
		// ===== UPDATE KHACH HANG LAYOUT END HERE =====
		
		// ===== HOP DONG LAYOUT START HERE =====
		JPanel cardQuanLyHopDong = new JPanel();
		cardsPane.add(cardQuanLyHopDong);
		cardQuanLyHopDong.setLayout(null);
		cardLayout.addLayoutComponent(cardQuanLyHopDong, "cardQuanLyHopDong");
		
		JLabel lblHopDong_TieuDe = new JLabel("Trang qu???n l?? h???p ?????ng");
		lblHopDong_TieuDe.setBounds(0, 0, 500, 100);
		lblHopDong_TieuDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardQuanLyHopDong.add(lblHopDong_TieuDe);
		
		JLabel lblHopDong_TimKiem = new JLabel("T??m ki???m:");
		lblHopDong_TimKiem.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblHopDong_TimKiem.setBounds(20, 400, 80, 30);
		cardQuanLyHopDong.add(lblHopDong_TimKiem);
		
		JTextField txtHopDong_TimKiem = new JTextField();
		txtHopDong_TimKiem.setBounds(100, 400, 200, 30);
		txtHopDong_TimKiem.setColumns(10);
		cardQuanLyHopDong.add(txtHopDong_TimKiem);
		
JButton btnHopDong_TimKiem = new JButton("T??m");
		
		btnHopDong_TimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<HopDongDTO> listKQ;
				
			            String input = JOptionPane.showInputDialog(btnTourSearch, "M???i b???n nh???p m?? h???p ?????ng !");
			            
			            if(input != null && input.length() > 0){
			                listKQ = hopDongBUS.getByMaHD(input);
			                hopDongTblModel.setRowCount(0);
			                
			                for(HopDongDTO dto : listKQ) {
								hopDongTblModel.addRow(new Object[] {
										dto.getMaHD(), dto.getNgayLapHD(), dto.getNoiDung(), dto.getMaTour()
								});
			                };
			            }
			           
			        }
			        
			        
		});
		
		btnHopDong_TimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHopDong_TimKiem.setBounds(310, 400, 80, 30);
		cardQuanLyHopDong.add(btnHopDong_TimKiem);
		
		JScrollPane HopDongScrollPane = new JScrollPane();
		HopDongScrollPane.setBounds(50, 450, 750, 273);
		cardQuanLyHopDong.add(HopDongScrollPane);
		
		tblHopDong = new JTable();
		tblHopDong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tblHopDong.setRowHeight(50);
		String[] colNamesTblHopDong = {"M?? h???p ?????ng", "Ng??y l???p h???p ?????ng", "N???i dung", "M?? tour"};
		hopDongTblModel = new DefaultTableModel();
		tblHopDong.setModel(hopDongTblModel);
		for(String colName : colNamesTblHopDong) {
			hopDongTblModel.addColumn(colName);
		}
		loadTblHopDong();
		
		HopDongScrollPane.setViewportView(tblHopDong);
		tblHopDong.setFillsViewportHeight(true);
		
		JButton btnHopDong_QuayLai = new JButton("Quay l???i");
		btnHopDong_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyTour");
			}
		});
		btnHopDong_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHopDong_QuayLai.setBounds(50, 750, 100, 30);
		cardQuanLyHopDong.add(btnHopDong_QuayLai);
		
		JButton btnHopDong_TaiLai = new JButton("T???i l???i b???ng");
		btnHopDong_TaiLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hopDongTblModel.setRowCount(0);
				loadTblHopDong();
			}
		});
		btnHopDong_TaiLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHopDong_TaiLai.setBounds(820, 450, 200, 30);
		cardQuanLyHopDong.add(btnHopDong_TaiLai);
		
		JButton btnHopDong_Xoa = new JButton("X??a h???p ?????ng");
		btnHopDong_Xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tblHopDong.getSelectedRow();
				if(selectedRow>=0) {
					int result=JOptionPane.showConfirmDialog(null,"B???n c?? ch???c mu???n x??a th??ng tin n??y?","th??ng b??o",JOptionPane.YES_NO_OPTION); 
					if(result==JOptionPane.YES_OPTION) {
					String maKH = (String) tblHopDong.getValueAt(selectedRow, 0);
					
					hopDongBUS.deleteById(maKH);
					hopDongTblModel.removeRow(selectedRow);
					HopDongBUS.listHopDongDTO.remove(selectedRow);
					}
					else if(result==JOptionPane.NO_OPTION) {
						JOptionPane.showMessageDialog(null,"Th??ng tin n??y ch??a ???????c x??a!");
					}
				}
				if(selectedRow<0 ) {
					JOptionPane.showMessageDialog(cardQuanLyTaiKhoan, "B???n ch??a ch???n tr?????ng d??? li???u n??o c???");
				}
			}
		});
		btnHopDong_Xoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHopDong_Xoa.setBounds(820, 500, 200, 30);;
		cardQuanLyHopDong.add(btnHopDong_Xoa);
		
		btnHopDong_CapNhat = new JButton("C???p nh???t h???p ?????ng");
		addActionListenerBtnHopDong_CapNhat();
		btnHopDong_CapNhat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHopDong_CapNhat.setBounds(820, 550, 200, 30);
		cardQuanLyHopDong.add(btnHopDong_CapNhat);
		// ===== HOP DONG LAYOUT END HERE ======
		
		// ===== ADD HOP DONG LAYOUT START HERE =====
		JPanel cardAddHopDong = new JPanel();
		cardsPane.add(cardAddHopDong);
		cardAddHopDong.setLayout(null);
		cardLayout.addLayoutComponent(cardAddHopDong, "cardAddHopDong");
		
		JLabel lblAddHopDong_TieuDe = new JLabel("Trang th??m h???p ?????ng");
		lblAddHopDong_TieuDe.setBounds(0, 0, 500, 100);
		lblAddHopDong_TieuDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardAddHopDong.add(lblAddHopDong_TieuDe);
		
		JLabel lblAddMaHopDong = new JLabel("Nh???p m?? HD:");
		lblAddMaHopDong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddMaHopDong.setBounds(50, 100, 200, 30);
		cardAddHopDong.add(lblAddMaHopDong);
		
		JTextField txtAddMaHopDong = new JTextField();
		txtAddMaHopDong.setColumns(10);
		txtAddMaHopDong.setBounds(250, 100, 300, 30);
		cardAddHopDong.add(txtAddMaHopDong);
		
		JLabel lblAddNgayLapHopDong = new JLabel("Nh???p ng??y l???p HD:");
		lblAddNgayLapHopDong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddNgayLapHopDong.setBounds(50, 150, 200, 30);
		cardAddHopDong.add(lblAddNgayLapHopDong);
		
		JTextField txtAddNgayLapHopDong = new JTextField();
		txtAddNgayLapHopDong.setColumns(10);
		txtAddNgayLapHopDong.setBounds(250, 150, 300, 30);
		cardAddHopDong.add(txtAddNgayLapHopDong);
		
		JLabel lblAddNoiDung = new JLabel("Nh???p n???i dung h???p ?????ng:");
		lblAddNoiDung.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddNoiDung.setBounds(50, 200, 200, 30);
		cardAddHopDong.add(lblAddNoiDung);
		
		JTextField txtAddNoiDung = new JTextField();
		txtAddNoiDung.setColumns(10);
		txtAddNoiDung.setBounds(250, 200, 300, 30);
		cardAddHopDong.add(txtAddNoiDung);
		
		JLabel lblAddHD_MaTour = new JLabel("Nh???p m?? tour:");
		lblAddHD_MaTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddHD_MaTour.setBounds(50, 250, 200, 30);
		cardAddHopDong.add(lblAddHD_MaTour);
		
		JTextField txtAddHD_MaTour = new JTextField();
		txtAddHD_MaTour.setColumns(10);
		txtAddHD_MaTour.setBounds(250, 250, 300, 30);
		cardAddHopDong.add(txtAddHD_MaTour);
		
		JButton btnAddHopDong_ThemMoi = new JButton("Th??m m???i");
		btnAddHopDong_ThemMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HopDongDTO dto = new HopDongDTO();
				
				dto.setMaHD(txtAddMaHopDong.getText());
				dto.setNgayLapHD(txtAddNgayLapHopDong.getText());
				dto.setNoiDung(txtAddNoiDung.getText());
				dto.setMaTour(txtAddHD_MaTour.getText());
				
				hopDongBUS.add(dto);
				HopDongBUS.listHopDongDTO.add(dto);
				addRowTblHopDong(dto);
				cardLayout.show(cardsPane, "cardQuanLyHopDong");
				// clear all text after add
				txtAddMaHopDong.setText("");
				txtAddNgayLapHopDong.setText("");
				txtAddNoiDung.setText("");
			}
		});
		btnAddHopDong_ThemMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddHopDong_ThemMoi.setBounds(150, 300, 120, 30);
		cardAddHopDong.add(btnAddHopDong_ThemMoi);
		
		JButton btnAddHopDong_QuayLai = new JButton("Quay l???i");
		btnAddHopDong_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyTour");
			}
		});
		btnAddHopDong_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddHopDong_QuayLai.setBounds(300, 300, 120, 30);
		cardAddHopDong.add(btnAddHopDong_QuayLai);
		// ===== ADD HOP DONG LAYOUT END HERE =====
		
		// ===== UPDATE HOP DONG LAYOUT START HERE =====
		JPanel cardUpdateHopDong = new JPanel();
		cardsPane.add(cardUpdateHopDong);
		cardUpdateHopDong.setLayout(null);
		cardLayout.addLayoutComponent(cardUpdateHopDong, "cardUpdateHopDong");
		
		JLabel lblUpdateHopDong_TieuDe = new JLabel("Trang c???p nh???t h???p ?????ng");
		lblUpdateHopDong_TieuDe.setBounds(0, 0, 400, 100);
		lblUpdateHopDong_TieuDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardUpdateHopDong.add(lblUpdateHopDong_TieuDe);
		
		JLabel lblUpdateMaHD = new JLabel("Nh???p m?? HD:");
		lblUpdateMaHD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateMaHD.setBounds(50, 100, 150, 30);
		cardUpdateHopDong.add(lblUpdateMaHD);
		
		txtUpdateMaHD = new JTextField();
		txtUpdateMaHD.setColumns(10);
		txtUpdateMaHD.setBounds(200, 100, 300, 30);
		cardUpdateHopDong.add(txtUpdateMaHD);
		
		JLabel lblUpdateNgayLapHD = new JLabel("Nh???p ng??y l???p HD:");
		lblUpdateNgayLapHD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateNgayLapHD.setBounds(50, 150, 150, 30);
		cardUpdateHopDong.add(lblUpdateNgayLapHD);
		
		txtUpdateNgayLapHD = new JTextField();
		txtUpdateNgayLapHD.setColumns(10);
		txtUpdateNgayLapHD.setBounds(200, 150, 300, 30);
		cardUpdateHopDong.add(txtUpdateNgayLapHD);
		
		JLabel lblUpdateNoiDung = new JLabel("Nh???p n???i dung:");
		lblUpdateNoiDung.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateNoiDung.setBounds(50, 200, 150, 30);
		cardUpdateHopDong.add(lblUpdateNoiDung);

		txtUpdateNoiDungHD = new JTextField();
		txtUpdateNoiDungHD.setColumns(10);
		txtUpdateNoiDungHD.setBounds(200, 200, 300, 30);
		cardUpdateHopDong.add(txtUpdateNoiDungHD);
		
		JLabel lblUpdateHD_MaTour = new JLabel("Nh???p m?? tour:");
		lblUpdateHD_MaTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateHD_MaTour.setBounds(50, 250, 150, 30);
		cardUpdateHopDong.add(lblUpdateHD_MaTour);

		txtUpdateHD_MaTour = new JTextField();
		txtUpdateHD_MaTour.setColumns(10);
		txtUpdateHD_MaTour.setBounds(200, 250, 300, 30);
		cardUpdateHopDong.add(txtUpdateHD_MaTour);
		
		JButton btnUpdateHopDong_CapNhat = new JButton("C???p nh???t");
		btnUpdateHopDong_CapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tblHopDong.getSelectedRow();
				HopDongDTO dto = new HopDongDTO();
				
				dto.setMaHD(txtUpdateMaHD.getText());
				dto.setNgayLapHD(txtUpdateNgayLapHD.getText());
				dto.setNoiDung(txtUpdateNoiDungHD.getText());
				dto.setMaTour(txtUpdateHD_MaTour.getText());
				
				hopDongBUS.update(dto);
				HopDongBUS.listHopDongDTO.set(selectedRow, dto);
				setRow(dto, selectedRow);
				cardLayout.show(cardsPane, "cardQuanLyHopDong");
				reloadTblTour_HopDong(dto);
				// clear all text after update
				txtUpdateMaHD.setText("");
				txtUpdateNgayLapHD.setText("");
				txtUpdateNoiDungHD.setText("");
				txtUpdateHD_MaTour.setText("");
			}
		});
		btnUpdateHopDong_CapNhat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateHopDong_CapNhat.setBounds(150, 300, 120, 30);
		cardUpdateHopDong.add(btnUpdateHopDong_CapNhat);
		
		JButton btnUpdateHopDong_QuayLai = new JButton("Quay l???i");
		btnUpdateHopDong_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyHopDong");
			}
		});
		btnUpdateHopDong_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateHopDong_QuayLai.setBounds(300, 300, 100, 30);
		cardUpdateHopDong.add(btnUpdateHopDong_QuayLai);
		// ===== UPDATE HOP DONG LAYOUT END HERE =====
		
		// ===== DOAN LAYOUT START HERE =====
		JPanel cardQuanLyDoan = new JPanel();
		cardsPane.add(cardQuanLyDoan);
		cardQuanLyDoan.setLayout(null);
		cardLayout.addLayoutComponent(cardQuanLyDoan, "cardQuanLyDoan");
		
		JLabel lblDoan_TieuDe = new JLabel("Trang qu???n l?? ??o??n");
		lblDoan_TieuDe.setBounds(0, 0, 500, 100);
		lblDoan_TieuDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardQuanLyDoan.add(lblDoan_TieuDe);
		
		JLabel lblDoan_TimKiem = new JLabel("T??m ki???m:");
		lblDoan_TimKiem.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblDoan_TimKiem.setBounds(20, 400, 80, 30);
		cardQuanLyDoan.add(lblDoan_TimKiem);
		
		JTextField txtDoan_TimKiem = new JTextField();
		txtDoan_TimKiem.setBounds(100, 400, 200, 30);
		txtDoan_TimKiem.setColumns(10);
		cardQuanLyDoan.add(txtDoan_TimKiem);
		
		JButton btnDoan_TimKiem = new JButton("T??m");
		
		btnDoan_TimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoanDTO dto = new DoanDTO();
				
			            String input = JOptionPane.showInputDialog(btnTourSearch, "M???i b???n nh???p m?? ??o??n !");
			            
			            if(input != null && input.length() > 0){
			                dto = doanBUS.getByMaDoan(input);
			                doanTblModel.setRowCount(0);
			                
			                doanTblModel.addRow(new Object[] {
										dto.getMaDoan(), dto.getSoNguoi(), dto.getMaTour(), dto.getMaHDV()
								});
			                };
			            }			              
		});
		
		btnDoan_TimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDoan_TimKiem.setBounds(310, 400, 80, 30);
		cardQuanLyDoan.add(btnDoan_TimKiem);
		
		JScrollPane doanScrollPane = new JScrollPane();
		doanScrollPane.setBounds(50, 450, 600, 273);
		cardQuanLyDoan.add(doanScrollPane);
		
		tblDoan = new JTable();
		tblDoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tblDoan.setRowHeight(50);
		String[] colNamesTblDoan = {"M?? ??o??n", "S??? ng?????i", "M?? tour", "M?? h?????ng d???n vi??n"};
		doanTblModel = new DefaultTableModel();
		tblDoan.setModel(doanTblModel);
		for(String colName : colNamesTblDoan) {
			doanTblModel.addColumn(colName);
		}
		loadTblDoan();
		
		doanScrollPane.setViewportView(tblDoan);
		tblDoan.setFillsViewportHeight(true);
		
		JButton btnDoan_QuayLai = new JButton("Quay l???i");
		btnDoan_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyTour");
			}
		});
		btnDoan_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDoan_QuayLai.setBounds(50, 750, 100, 30);
		cardQuanLyDoan.add(btnDoan_QuayLai);
		
		JButton btnDoan_TaiLai = new JButton("T???i l???i b???ng");
		btnDoan_TaiLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doanTblModel.setRowCount(0);
				loadTblDoan();
			}
		});
		btnDoan_TaiLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDoan_TaiLai.setBounds(820, 450, 200, 30);
		cardQuanLyDoan.add(btnDoan_TaiLai);
		
		JButton btnDoan_Xoa = new JButton("X??a ??o??n");
		btnDoan_Xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tblDoan.getSelectedRow();
				if(selectedRow>=0) {
					int result=JOptionPane.showConfirmDialog(null,"B???n c?? ch???c mu???n x??a th??ng tin n??y?","th??ng b??o",JOptionPane.YES_NO_OPTION); 
					if(result==JOptionPane.YES_OPTION) {
					String maDoan = (String) tblDoan.getValueAt(selectedRow, 0);
					doanBUS.deleteById(maDoan);
					doanTblModel.removeRow(selectedRow);
					DoanBUS.listDoanDTO.remove(selectedRow);
					}
					else if(result==JOptionPane.NO_OPTION) {
						JOptionPane.showMessageDialog(null,"Th??ng tin n??y ch??a ???????c x??a!");
					}
				}
				if(selectedRow<0 ) {
					JOptionPane.showMessageDialog(cardQuanLyTaiKhoan, "B???n ch??a ch???n tr?????ng d??? li???u n??o c???");
				}
			}
		});
		btnDoan_Xoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDoan_Xoa.setBounds(820, 500, 200, 30);;
		cardQuanLyDoan.add(btnDoan_Xoa);
		
		btnDoan_CapNhat = new JButton("C???p nh???t ??o??n");
		addActionListenerBtnDoan_CapNhat();
		btnDoan_CapNhat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDoan_CapNhat.setBounds(820, 550, 200, 30);
		cardQuanLyDoan.add(btnDoan_CapNhat);
		// ===== DOAN LAYOUT END HERE =====
		
		// ===== ADD DOAN LAYOUT START HERE =====
		JPanel cardAddDoan = new JPanel();
		cardsPane.add(cardAddDoan);
		cardAddDoan.setLayout(null);
		cardLayout.addLayoutComponent(cardAddDoan, "cardAddDoan");
		
		JLabel lblAddDoan_TieuDe = new JLabel("Trang th??m h???p ?????ng");
		lblAddDoan_TieuDe.setBounds(0, 0, 500, 100);
		lblAddDoan_TieuDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardAddDoan.add(lblAddDoan_TieuDe);
		
		JLabel lblAddMaDoan = new JLabel("Nh???p m?? ??o??n:");
		lblAddMaDoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddMaDoan.setBounds(50, 100, 200, 30);
		cardAddDoan.add(lblAddMaDoan);
		
		JTextField txtAddMaDoan = new JTextField();
		txtAddMaDoan.setColumns(10);
		txtAddMaDoan.setBounds(250, 100, 300, 30);
		cardAddDoan.add(txtAddMaDoan);
		
		JLabel lblAddSoNguoi = new JLabel("Nh???p s??? ng?????i:");
		lblAddSoNguoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddSoNguoi.setBounds(50, 150, 200, 30);
		cardAddDoan.add(lblAddSoNguoi);
		
		JTextField txtAddSoNguoi = new JTextField();
		txtAddSoNguoi.setColumns(10);
		txtAddSoNguoi.setBounds(250, 150, 300, 30);
		cardAddDoan.add(txtAddSoNguoi);
		
		JLabel lblAddDoan_MaTour = new JLabel("Nh???p m?? tour:");
		lblAddDoan_MaTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddDoan_MaTour.setBounds(50, 200, 200, 30);
		cardAddDoan.add(lblAddDoan_MaTour);
		
		JTextField txtAddDoan_MaTour = new JTextField();
		txtAddDoan_MaTour.setColumns(10);
		txtAddDoan_MaTour.setBounds(250, 200, 300, 30);
		cardAddDoan.add(txtAddDoan_MaTour);
		
		JLabel lblAddDoan_MaHDV = new JLabel("Nh???p m?? HDV:");
		lblAddDoan_MaHDV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddDoan_MaHDV.setBounds(50, 250, 200, 30);
		cardAddDoan.add(lblAddDoan_MaHDV);
		
		JTextField txtAddDoan_MaHDV = new JTextField();
		txtAddDoan_MaHDV.setColumns(10);
		txtAddDoan_MaHDV.setBounds(250, 250, 300, 30);
		cardAddDoan.add(txtAddDoan_MaHDV);

		JButton btnAddDoan_ThemMoi = new JButton("Th??m m???i");
		btnAddDoan_ThemMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoanDTO dto = new DoanDTO();
				
				dto.setMaDoan(txtAddMaDoan.getText());
				dto.setSoNguoi(Integer.valueOf(txtAddSoNguoi.getText()));
				dto.setMaTour(txtAddDoan_MaTour.getText());
				dto.setMaHDV(txtAddDoan_MaHDV.getText());
				
				doanBUS.add(dto);
				DoanBUS.listDoanDTO.add(dto);
				addRowTblDoan(dto);
				cardLayout.show(cardsPane, "cardQuanLyDoan");
				// clear all text after add
				txtAddMaDoan.setText("");
				txtAddSoNguoi.setText("");
				txtAddDoan_MaTour.setText("");
				txtAddDoan_MaHDV.setText("");
			}
		});
		btnAddDoan_ThemMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddDoan_ThemMoi.setBounds(150, 300, 120, 30);
		cardAddDoan.add(btnAddDoan_ThemMoi);
		
		JButton btnAddDoan_QuayLai = new JButton("Quay l???i");
		btnAddDoan_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyTour");
			}
		});
		btnAddDoan_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddDoan_QuayLai.setBounds(300, 300, 120, 30);
		cardAddDoan.add(btnAddDoan_QuayLai);
		// ===== ADD DOAN LAYOUT END HERE ======
		
		// ===== UPDATE DOAN LAYOUT START HERE =====
		JPanel cardUpdateDoan = new JPanel();
		cardsPane.add(cardUpdateDoan);
		cardUpdateDoan.setLayout(null);
		cardLayout.addLayoutComponent(cardUpdateDoan, "cardUpdateDoan");
		
		JLabel lblUpdateDoan_TieuDe = new JLabel("Trang c???p nh???t ??o??n");
		lblUpdateDoan_TieuDe.setBounds(0, 0, 400, 100);
		lblUpdateDoan_TieuDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardUpdateDoan.add(lblUpdateDoan_TieuDe);
		
		JLabel lblUpdateMaDoan = new JLabel("Nh???p m?? ??o??n:");
		lblUpdateMaDoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateMaDoan.setBounds(50, 100, 150, 30);
		cardUpdateDoan.add(lblUpdateMaDoan);
		
		txtUpdateMaDoan = new JTextField();
		txtUpdateMaDoan.setColumns(10);
		txtUpdateMaDoan.setBounds(200, 100, 300, 30);
		cardUpdateDoan.add(txtUpdateMaDoan);
		
		JLabel lblUpdateSoNguoi = new JLabel("Nh???p s??? ng?????i :");
		lblUpdateSoNguoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateSoNguoi.setBounds(50, 150, 150, 30);
		cardUpdateDoan.add(lblUpdateSoNguoi);
		
		txtUpdateSoNguoi = new JTextField();
		txtUpdateSoNguoi.setColumns(10);
		txtUpdateSoNguoi.setBounds(200, 150, 300, 30);
		cardUpdateDoan.add(txtUpdateSoNguoi);
		
		JLabel lblUpdateDoan_MaTour = new JLabel("Nh???p m?? tour:");
		lblUpdateDoan_MaTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateDoan_MaTour.setBounds(50, 200, 150, 30);
		cardUpdateDoan.add(lblUpdateDoan_MaTour);

		txtUpdateDoan_MaTour = new JTextField();
		txtUpdateDoan_MaTour.setColumns(10);
		txtUpdateDoan_MaTour.setBounds(200, 200, 300, 30);
		cardUpdateDoan.add(txtUpdateDoan_MaTour);
		
		JLabel lblUpdateDoan_MaHDV = new JLabel("Nh???p m?? HDV:");
		lblUpdateDoan_MaHDV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateDoan_MaHDV.setBounds(50, 250, 150, 30);
		cardUpdateDoan.add(lblUpdateDoan_MaHDV);

		txtUpdateDoan_MaHDV = new JTextField();
		txtUpdateDoan_MaHDV.setColumns(10);
		txtUpdateDoan_MaHDV.setBounds(200, 250, 300, 30);
		cardUpdateDoan.add(txtUpdateDoan_MaHDV);
		
		JButton btnUpdateDoan_CapNhat = new JButton("C???p nh???t");
		btnUpdateDoan_CapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tblDoan.getSelectedRow();
				DoanDTO dto = new DoanDTO();
				
				dto.setMaDoan(txtUpdateMaDoan.getText());
				dto.setSoNguoi(Integer.valueOf(txtUpdateSoNguoi.getText()));
				dto.setMaTour(txtUpdateDoan_MaTour.getText());
				dto.setMaHDV(txtUpdateDoan_MaHDV.getText());
				
				doanBUS.update(dto);
				DoanBUS.listDoanDTO.set(selectedRow, dto);
				setRow(dto, selectedRow);
				cardLayout.show(cardsPane, "cardQuanLyDoan");
				reloadTblTour_Doan(dto);
				// clear all text after update
				txtUpdateMaDoan.setText("");
				txtUpdateSoNguoi.setText("");
				txtUpdateDoan_MaTour.setText("");
				txtUpdateDoan_MaHDV.setText("");
			}
		});
		btnUpdateDoan_CapNhat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateDoan_CapNhat.setBounds(150, 350, 120, 30);
		cardUpdateDoan.add(btnUpdateDoan_CapNhat);
		
		JButton btnUpdateDoan_QuayLai = new JButton("Quay l???i");
		btnUpdateDoan_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyDoan");
			}
		});
		btnUpdateDoan_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateDoan_QuayLai.setBounds(300, 350, 100, 30);
		cardUpdateDoan.add(btnUpdateDoan_QuayLai);
		// ===== UPDATE DOAN LAYOUT END HERE =====
		
		// ===== KE HOACH TOUR LAYOUT START HERE =====
		JPanel cardQuanLyKeHoachTour = new JPanel();
		cardsPane.add(cardQuanLyKeHoachTour);
		cardQuanLyKeHoachTour.setLayout(null);
		cardLayout.addLayoutComponent(cardQuanLyKeHoachTour, "cardQuanLyKeHoachTour");
		
		JLabel lblKeHoachTour_TieuDe = new JLabel("Trang qu???n l?? k??? ho???ch tour");
		lblKeHoachTour_TieuDe.setBounds(0, 0, 500, 100);
		lblKeHoachTour_TieuDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardQuanLyKeHoachTour.add(lblKeHoachTour_TieuDe);
		
		JLabel lblKeHoachTour_TimKiem = new JLabel("T??m ki???m:");
		lblKeHoachTour_TimKiem.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblKeHoachTour_TimKiem.setBounds(20, 100, 80, 30);
		cardQuanLyKeHoachTour.add(lblKeHoachTour_TimKiem);
		
		JTextField txtKeHoachTour_TimKiem = new JTextField();
		txtKeHoachTour_TimKiem.setBounds(100, 100, 200, 30);
		txtKeHoachTour_TimKiem.setColumns(10);
		cardQuanLyKeHoachTour.add(txtKeHoachTour_TimKiem);
		
		JButton btnKeHoachTour_TimKiem = new JButton("T??m");
		btnKeHoachTour_TimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KeHoachTourDTO dto =keHoachTourBUS.getByMaKeHoach(txtKeHoachTour_TimKiem.getText());
				
				keHoachTourTblModel.setRowCount(0); // xoa tat ca row
	
				keHoachTourTblModel.addRow(new Object[] {
							dto.getMaKeHoach(), dto.getNgayBatDau(), dto.getNgayKetThuc(), dto.getMaTour()});
				
			}
		});
		btnKeHoachTour_TimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKeHoachTour_TimKiem.setBounds(310, 100, 80, 30);
		cardQuanLyKeHoachTour.add(btnKeHoachTour_TimKiem);
		
		JScrollPane keHoachTourScrollPane = new JScrollPane();
		keHoachTourScrollPane.setBounds(50, 150, 750, 223);
		cardQuanLyKeHoachTour.add(keHoachTourScrollPane);
		
		tblKeHoachTour = new JTable();
		tblKeHoachTour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = tblKeHoachTour.getSelectedRow();
				String maKHTour = (String) tblKeHoachTour.getValueAt(selectedRow, 0);
				ArrayList<CTKeHoachTheoNgayDTO> listCTKH = ctKeHoachTheoNgayBUS.getByMaKHTour(maKHTour);
				
				if(tblKeHoachTour_CTKeHoachTheoNgay.getRowCount() > 0) {
					keHoachTour_ctKeHoachTheoNgayTblModel.setRowCount(0);
				}
				for(CTKeHoachTheoNgayDTO ctkh : listCTKH) {
					addRowTblKeHoachTour_CTKeHoachTheoNgay(ctkh);
				}
			}
		});
		tblKeHoachTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tblKeHoachTour.setRowHeight(50);
		String[] colNamesTblKeHoachTour = {"M?? k??? ho???ch", "Ng??y b???t ?????u", "Ng??y k???t th??c", "M?? tour"};
		keHoachTourTblModel = new DefaultTableModel();
		tblKeHoachTour.setModel(keHoachTourTblModel);
		for(String colName : colNamesTblKeHoachTour) {
			keHoachTourTblModel.addColumn(colName);
		}
		loadTblKeHoachTour();
		
		keHoachTourScrollPane.setViewportView(tblKeHoachTour);
		tblKeHoachTour.setFillsViewportHeight(true);

		JButton btnKeHoachTour_TaoCTKeHoach = new JButton("T???o CT k??? ho???ch");
		btnKeHoachTour_TaoCTKeHoach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardAddCTKeHoachTheoNgay");
			}
		});
//		addActionListenerBtnCTKeHoach_Update();
		btnKeHoachTour_TaoCTKeHoach.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKeHoachTour_TaoCTKeHoach.setBounds(50, 400, 200, 30);
		cardQuanLyKeHoachTour.add(btnKeHoachTour_TaoCTKeHoach);
		
		JLabel lblThongTinCTKeHoachTheoNgay = new JLabel("Chi ti???t k??? ho???ch theo ng??y:");
		lblThongTinCTKeHoachTheoNgay.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThongTinCTKeHoachTheoNgay.setBounds(50, 460, 250, 30);
		cardQuanLyKeHoachTour.add(lblThongTinCTKeHoachTheoNgay);
		
		JScrollPane keHoachTour_ctKeHoachTheoNgayScrollPane = new JScrollPane();
		keHoachTour_ctKeHoachTheoNgayScrollPane.setBounds(50, 500, 875, 223);
		cardQuanLyKeHoachTour.add(keHoachTour_ctKeHoachTheoNgayScrollPane);
		
		tblKeHoachTour_CTKeHoachTheoNgay = new JTable();
		tblKeHoachTour_CTKeHoachTheoNgay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tblKeHoachTour_CTKeHoachTheoNgay.setRowHeight(50);
		String[] colNamesTblKeHoachTour_CTKeHoachTheoNgay = {"M?? CTKHTheoNgay", "Ng??y", "M?? KHTour", "M?? DD tham quan", "M?? ph????ng ti???n", "M?? nh?? h??ng", "M?? kh??ch s???n"};
		keHoachTour_ctKeHoachTheoNgayTblModel = new DefaultTableModel();
		tblKeHoachTour_CTKeHoachTheoNgay.setModel(keHoachTour_ctKeHoachTheoNgayTblModel);
		for(String colName : colNamesTblKeHoachTour_CTKeHoachTheoNgay) {
			keHoachTour_ctKeHoachTheoNgayTblModel.addColumn(colName);
		}
		
		keHoachTour_ctKeHoachTheoNgayScrollPane.setViewportView(tblKeHoachTour_CTKeHoachTheoNgay);
		tblKeHoachTour_CTKeHoachTheoNgay.setFillsViewportHeight(true);
		addActionListenerBtnTour_Update();
		
		JButton btnKeHoachTour_CTKeHoachTheoNgayLayout = new JButton("Xem danh s??ch");
		btnKeHoachTour_CTKeHoachTheoNgayLayout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyCTKeHoachTheoNgay");
			}
		});
		addActionListenerBtnTour_Update();
		btnKeHoachTour_CTKeHoachTheoNgayLayout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKeHoachTour_CTKeHoachTheoNgayLayout.setBounds(950, 500, 150, 30);
		cardQuanLyKeHoachTour.add(btnKeHoachTour_CTKeHoachTheoNgayLayout);
		
		JButton btnKeHoachTour_CTKeHoachTheoNgay_Xoa = new JButton("X??a");
		btnKeHoachTour_CTKeHoachTheoNgay_Xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tblKeHoachTour_CTKeHoachTheoNgay.getSelectedRow();
				if(selectedRow>=0) {
					int result = JOptionPane.showConfirmDialog(null,"B???n c?? ch???c mu???n x??a th??ng tin n??y ?", "Th??ng b??o",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	                if(result == JOptionPane.YES_OPTION){
				String maCTKeHoachTheoNgay = (String) tblKeHoachTour_CTKeHoachTheoNgay.getValueAt(selectedRow, 0);
				
				ctKeHoachTheoNgayBUS.deleteById(maCTKeHoachTheoNgay);
				keHoachTour_ctKeHoachTheoNgayTblModel.removeRow(selectedRow);
	                }
	                else if(result == JOptionPane.NO_OPTION)
                    {
                        JOptionPane.showMessageDialog(null, "Kh??ng x??a th??ng tin");
                    }
				}
				if(selectedRow<0) {
					JOptionPane.showMessageDialog(cardQuanLyTour, "B???n ch??a ch???n tr?????ng d??? li???u!");
				}
			}
		});
		btnKeHoachTour_CTKeHoachTheoNgay_Xoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKeHoachTour_CTKeHoachTheoNgay_Xoa.setBounds(950, 550, 120, 30);
		cardQuanLyKeHoachTour.add(btnKeHoachTour_CTKeHoachTheoNgay_Xoa);
		
		JButton btnKeHoachTour_CTKeHoachTheoNgay_Them = new JButton("Th??m ");
		btnKeHoachTour_CTKeHoachTheoNgay_Them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardAddCTKeHoachTheoNgay");
			}
		});
		btnKeHoachTour_CTKeHoachTheoNgay_Them.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKeHoachTour_CTKeHoachTheoNgay_Them.setBounds(950, 550, 120, 30);
		cardQuanLyKeHoachTour.add(btnKeHoachTour_CTKeHoachTheoNgay_Them);
		
		btnKeHoachTour_CTKeHoachTheoNgay_CapNhat = new JButton("C???p nh???t");
		addActionListenerBtnKeHoachTour_CTKeHoachTheoNgay_Update();
		btnKeHoachTour_CTKeHoachTheoNgay_CapNhat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKeHoachTour_CTKeHoachTheoNgay_CapNhat.setBounds(950, 600, 120, 30);
		cardQuanLyKeHoachTour.add(btnKeHoachTour_CTKeHoachTheoNgay_CapNhat);
		
		JButton btnKeHoachTour_TaiLai = new JButton("T???i l???i b???ng");
		btnKeHoachTour_TaiLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				keHoachTourTblModel.setRowCount(0);
				loadTblKeHoachTour();
			}
		});
		btnKeHoachTour_TaiLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKeHoachTour_TaiLai.setBounds(820, 150, 200, 30);
		cardQuanLyKeHoachTour.add(btnKeHoachTour_TaiLai);
		
		JButton btnKeHoachTour_Xoa = new JButton("X??a k??? ho???ch tour");
		btnKeHoachTour_Xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tblKeHoachTour.getSelectedRow();
				if(selectedRow>=0) {
					int result=JOptionPane.showConfirmDialog(null,"B???n c?? ch???c mu???n x??a th??ng tin n??y?","th??ng b??o",JOptionPane.YES_NO_OPTION); 
					if(result==JOptionPane.YES_OPTION) {
					String maKeHoach = (String) tblDoan.getValueAt(selectedRow, 0);
					
					keHoachTourBUS.deleteById(maKeHoach);
					keHoachTourTblModel.removeRow(selectedRow);
					KeHoachTourBUS.listKeHoachTourDTO.remove(selectedRow);
					}
					else if(result==JOptionPane.NO_OPTION) {
						JOptionPane.showMessageDialog(null,"Th??ng tin n??y ch??a ???????c x??a!");
					}
				}
				if(selectedRow<0 ) {
					JOptionPane.showMessageDialog(cardQuanLyTaiKhoan, "B???n ch??a ch???n tr?????ng d??? li???u n??o c???");
				}
			}
		});
		btnKeHoachTour_Xoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKeHoachTour_Xoa.setBounds(820, 200, 200, 30);;
		cardQuanLyKeHoachTour.add(btnKeHoachTour_Xoa);
		
		btnKeHoachTour_CapNhat = new JButton("C???p nh???t k??? ho???ch tour");
		addActionListenerBtnKeHoachTour_CapNhat();
		btnKeHoachTour_CapNhat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKeHoachTour_CapNhat.setBounds(820, 250, 200, 30);
		cardQuanLyKeHoachTour.add(btnKeHoachTour_CapNhat);
		
		JButton btnKeHoachTour_QuayLai = new JButton("Quay l???i");
		btnKeHoachTour_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyTour");
			}
		});
		btnKeHoachTour_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKeHoachTour_QuayLai.setBounds(50, 750, 100, 30);
		cardQuanLyKeHoachTour.add(btnKeHoachTour_QuayLai);
		// ===== KE HOACH TOUR LAYOUT END HERE =====
		
		// ===== ADD KE HOACH TOUR LAYOUT START HERE =====
		JPanel cardAddKeHoachTour = new JPanel();
		cardsPane.add(cardAddKeHoachTour);
		cardAddKeHoachTour.setLayout(null);
		cardLayout.addLayoutComponent(cardAddKeHoachTour, "cardAddKeHoachTour");
		
		JLabel lblAddKeHoachTour_TieuDe = new JLabel("Trang th??m k??? ho???ch tour");
		lblAddKeHoachTour_TieuDe.setBounds(0, 0, 500, 100);
		lblAddKeHoachTour_TieuDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardAddKeHoachTour.add(lblAddKeHoachTour_TieuDe);
		
		JLabel lblAddMaKeHoach = new JLabel("Nh???p m?? k??? ho???ch:");
		lblAddMaKeHoach.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddMaKeHoach.setBounds(50, 100, 200, 30);
		cardAddKeHoachTour.add(lblAddMaKeHoach);
		
		JTextField txtAddMaKeHoach = new JTextField();
		txtAddMaKeHoach.setColumns(10);
		txtAddMaKeHoach.setBounds(250, 100, 300, 30);
		cardAddKeHoachTour.add(txtAddMaKeHoach);
		
		JLabel lblAddNgayBatDau = new JLabel("Nh???p ng??y b???t ?????u:");
		lblAddNgayBatDau.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddNgayBatDau.setBounds(50, 150, 200, 30);
		cardAddKeHoachTour.add(lblAddNgayBatDau);
		
		JTextField txtAddNgayBatDau = new JTextField();
		txtAddNgayBatDau.setColumns(10);
		txtAddNgayBatDau.setBounds(250, 150, 300, 30);
		cardAddKeHoachTour.add(txtAddNgayBatDau);
		
		JLabel lblAddNgayKetThuc = new JLabel("Nh???p ng??y k???t th??c:");
		lblAddNgayKetThuc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddNgayKetThuc.setBounds(50, 200, 200, 30);
		cardAddKeHoachTour.add(lblAddNgayKetThuc);
		
		JTextField txtAddNgayKetThuc = new JTextField();
		txtAddNgayKetThuc.setColumns(10);
		txtAddNgayKetThuc.setBounds(250, 200, 300, 30);
		cardAddKeHoachTour.add(txtAddNgayKetThuc);
		
		JLabel lblAddKeHoachTour_MaTour = new JLabel("Nh???p m?? tour:");
		lblAddKeHoachTour_MaTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddKeHoachTour_MaTour.setBounds(50, 250, 200, 30);
		cardAddKeHoachTour.add(lblAddKeHoachTour_MaTour);
		
		JTextField txtAddKeHoachTour_MaTour = new JTextField();
		txtAddKeHoachTour_MaTour.setColumns(10);
		txtAddKeHoachTour_MaTour.setBounds(250, 250, 300, 30);
		cardAddKeHoachTour.add(txtAddKeHoachTour_MaTour);
		
		JButton btnAddKeHoachTour_ThemMoi = new JButton("Th??m m???i");
		btnAddKeHoachTour_ThemMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KeHoachTourDTO dto = new KeHoachTourDTO();
				
				dto.setMaKeHoach(txtAddMaKeHoach.getText());
				dto.setNgayBatDau(txtAddNgayBatDau.getText());
				dto.setNgayKetThuc(txtAddNgayKetThuc.getText());
				dto.setMaTour(txtAddKeHoachTour_MaTour.getText());
				
				keHoachTourBUS.add(dto);
				KeHoachTourBUS.listKeHoachTourDTO.add(dto);
				addRowTblKeHoachTour(dto);
				cardLayout.show(cardsPane, "cardQuanLyKeHoachTour");
				// clear all text after add
				txtAddMaKeHoach.setText("");
				txtAddNgayBatDau.setText("");
				txtAddNgayKetThuc.setText("");
				txtAddMaTour.setText("");
			}
		});
		btnAddKeHoachTour_ThemMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddKeHoachTour_ThemMoi.setBounds(150, 300, 120, 30);
		cardAddKeHoachTour.add(btnAddKeHoachTour_ThemMoi);
		
		JButton btnAddKeHoachTour_QuayLai = new JButton("Quay l???i");
		btnAddKeHoachTour_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyTour");
			}
		});
		btnAddKeHoachTour_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddKeHoachTour_QuayLai.setBounds(300, 300, 120, 30);
		cardAddKeHoachTour.add(btnAddKeHoachTour_QuayLai);
		// ===== ADD KE HOACH TOUR LAYOUT END HERE =====
		
		// ===== UPDATE KE HOACH TOUR LAYOUT START HERE =====
		JPanel cardUpdateKeHoachTour = new JPanel();
		cardsPane.add(cardUpdateKeHoachTour);
		cardUpdateKeHoachTour.setLayout(null);
		cardLayout.addLayoutComponent(cardUpdateKeHoachTour, "cardUpdateKeHoachTour");
		
		JLabel lblUpdateKeHoachTour_TieuDe = new JLabel("Trang c???p nh???t k??? ho???ch tour");
		lblUpdateKeHoachTour_TieuDe.setBounds(0, 0, 400, 100);
		lblUpdateKeHoachTour_TieuDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardUpdateKeHoachTour.add(lblUpdateKeHoachTour_TieuDe);
		
		JLabel lblUpdateMaKeHoachTour = new JLabel("Nh???p m?? k??? ho???ch:");
		lblUpdateMaKeHoachTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateMaKeHoachTour.setBounds(50, 100, 150, 30);
		cardUpdateKeHoachTour.add(lblUpdateMaKeHoachTour);
		
		txtUpdateMaKeHoach = new JTextField();
		txtUpdateMaKeHoach.setColumns(10);
		txtUpdateMaKeHoach.setBounds(200, 100, 300, 30);
		cardUpdateKeHoachTour.add(txtUpdateMaKeHoach);
		
		JLabel lblUpdateNgayBatDau = new JLabel("Nh???p ng??y b???t ?????u:");
		lblUpdateNgayBatDau.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateNgayBatDau.setBounds(50, 150, 150, 30);
		cardUpdateKeHoachTour.add(lblUpdateNgayBatDau);
		
		txtUpdateNgayBatDau = new JTextField();
		txtUpdateNgayBatDau.setColumns(10);
		txtUpdateNgayBatDau.setBounds(200, 150, 300, 30);
		cardUpdateKeHoachTour.add(txtUpdateNgayBatDau);
		
		JLabel lblUpdateNgayKetThuc = new JLabel("Nh???p ng??y k???t th??c:");
		lblUpdateNgayKetThuc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateNgayKetThuc.setBounds(50, 200, 150, 30);
		cardUpdateKeHoachTour.add(lblUpdateNgayKetThuc);
		
		txtUpdateNgayKetThuc = new JTextField();
		txtUpdateNgayKetThuc.setColumns(10);
		txtUpdateNgayKetThuc.setBounds(200, 200, 300, 30);
		cardUpdateKeHoachTour.add(txtUpdateNgayKetThuc);
		
		JLabel lblUpdateKeHoachTour_MaTour = new JLabel("Nh???p m?? tour:");
		lblUpdateKeHoachTour_MaTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateKeHoachTour_MaTour.setBounds(50, 250, 150, 30);
		cardUpdateKeHoachTour.add(lblUpdateKeHoachTour_MaTour);

		txtUpdateKeHoachTour_MaTour = new JTextField();
		txtUpdateKeHoachTour_MaTour.setColumns(10);
		txtUpdateKeHoachTour_MaTour.setBounds(200, 250, 300, 30);
		cardUpdateKeHoachTour.add(txtUpdateKeHoachTour_MaTour);
		
		JButton btnUpdateKeHoachTour_CapNhat = new JButton("C???p nh???t");
		btnUpdateKeHoachTour_CapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tblKeHoachTour.getSelectedRow();
				KeHoachTourDTO dto = new KeHoachTourDTO();
				
				dto.setMaKeHoach(txtUpdateMaKeHoach.getText());
				dto.setNgayBatDau(txtUpdateNgayBatDau.getText());
				dto.setNgayKetThuc(txtUpdateNgayKetThuc.getText());
				dto.setMaTour(txtUpdateKeHoachTour_MaTour.getText());
				
				keHoachTourBUS.update(dto);
				KeHoachTourBUS.listKeHoachTourDTO.set(selectedRow, dto);
				setRow(dto, selectedRow);
				cardLayout.show(cardsPane, "cardQuanLyKeHoachTour");
				reloadTblTour_KeHoachTour(dto);
				// clear all text after update
				txtUpdateMaKeHoach.setText("");
				txtUpdateNgayBatDau.setText("");
				txtUpdateNgayKetThuc.setText("");
				txtUpdateKeHoachTour_MaTour.setText("");
			}
		});
		btnUpdateKeHoachTour_CapNhat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateKeHoachTour_CapNhat.setBounds(150, 300, 120, 30);
		cardUpdateKeHoachTour.add(btnUpdateKeHoachTour_CapNhat);
		
		JButton btnUpdateKeHoachTour_QuayLai = new JButton("Quay l???i");
		btnUpdateKeHoachTour_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyDoan");
			}
		});
		btnUpdateKeHoachTour_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateKeHoachTour_QuayLai.setBounds(300, 300, 100, 30);
		cardUpdateKeHoachTour.add(btnUpdateKeHoachTour_QuayLai);
		// ===== UPDATE KE HOACH TOUR LAYOUT END HERE =====
		
		// ===== CT KE HOACH THEO NGAY LAYOUT START HERE =====
		JPanel cardQuanLyCTKeHoachTheoNgay = new JPanel();
		cardsPane.add(cardQuanLyCTKeHoachTheoNgay);
		cardQuanLyCTKeHoachTheoNgay.setLayout(null);
		cardLayout.addLayoutComponent(cardQuanLyCTKeHoachTheoNgay, "cardQuanLyCTKeHoachTheoNgay");
		
		JLabel lblCTKeHoachTheoNgay_TieuDe = new JLabel("Trang qu???n l?? ct k??? ho???ch theo ng??y");
		lblCTKeHoachTheoNgay_TieuDe.setBounds(0, 0, 600, 100);
		lblCTKeHoachTheoNgay_TieuDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardQuanLyCTKeHoachTheoNgay.add(lblCTKeHoachTheoNgay_TieuDe);
		
		JLabel lblCTKeHoachTheoNgay_TimKiem = new JLabel("T??m ki???m:");
		lblCTKeHoachTheoNgay_TimKiem.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblCTKeHoachTheoNgay_TimKiem.setBounds(20, 100, 80, 30);
		cardQuanLyCTKeHoachTheoNgay.add(lblCTKeHoachTheoNgay_TimKiem);
		
		JTextField txtCTKeHoachTheoNgay_TimKiem = new JTextField();
		txtCTKeHoachTheoNgay_TimKiem.setBounds(100, 100, 200, 30);
		txtCTKeHoachTheoNgay_TimKiem.setColumns(10);
		cardQuanLyCTKeHoachTheoNgay.add(txtCTKeHoachTheoNgay_TimKiem);
		
		JButton btnCTKeHoachTheoNgay_TimKiem = new JButton("T??m");
		btnCTKeHoachTheoNgay_TimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CTKeHoachTheoNgayDTO dto =ctKeHoachTheoNgayBUS.getByMaCTKHTheoNgay(txtCTKeHoachTheoNgay_TimKiem.getText());
				ctKeHoachTheoNgayTblModel.setRowCount(0); // xoa tat ca row
				ctKeHoachTheoNgayTblModel.addRow(new Object[] {
							dto.getMaCTKHTheoNgay(), dto.getNgay(), dto.getMaKHTour(), dto.getMaDiaDiemThamQuan(),dto.getMaPhuongTien(),dto.getMaNhaHang(),dto.getClass()});
			}
		});
		btnCTKeHoachTheoNgay_TimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCTKeHoachTheoNgay_TimKiem.setBounds(320, 100, 80, 30);
		cardQuanLyCTKeHoachTheoNgay.add(btnCTKeHoachTheoNgay_TimKiem);
		
		JScrollPane ctKeHoachTheoNgayScrollPane = new JScrollPane();
		ctKeHoachTheoNgayScrollPane.setBounds(50, 150, 750, 223);
		cardQuanLyCTKeHoachTheoNgay.add(ctKeHoachTheoNgayScrollPane);
		
		tblCTKeHoachTheoNgay = new JTable();
		tblCTKeHoachTheoNgay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = tblCTKeHoachTheoNgay.getSelectedRow();
				String maDiaDiem = (String) tblCTKeHoachTheoNgay.getValueAt(selectedRow, 3);
				String maPhuongTien = (String) tblCTKeHoachTheoNgay.getValueAt(selectedRow, 4);
				String maNhaHang = (String) tblCTKeHoachTheoNgay.getValueAt(selectedRow, 5);
				String maKhachSan = (String) tblCTKeHoachTheoNgay.getValueAt(selectedRow, 6);
				
				DiaDiemThamQuanDTO diaDiemThamQuan = diaDiemThamQuanBUS.getByMaDiaDiem(maDiaDiem);
				PhuongTienDTO phuongTien = phuongTienBUS.getByMaPhuongTien(maPhuongTien);
				NhaHangDTO nhaHang = nhaHangBUS.getByMaNhaHang(maNhaHang);
				KhachSanDTO khachSan = khachSanBUS.getByMaKhachSan(maKhachSan);
				
				if(tblCTKeHoachTheoNgay_DiaDiemThamQuan.getRowCount() > 0) {
					ctKeHoachTheoNgay_diaDiemThamQuanTblModel.setRowCount(0);
				}
				addRowTblCTKeHoachTheoNgay_DiaDiemThamQuan(diaDiemThamQuan);
				if(tblCTKeHoachTheoNgay_PhuongTien.getRowCount() > 0) {
					ctKeHoachTheoNgay_phuongTienTblModel.setRowCount(0);
				}
				addRowTblCTKeHoachTheoNgay_PhuongTien(phuongTien);
				if(tblCTKeHoachTheoNgay_NhaHang.getRowCount() > 0) {
					ctKeHoachTheoNgay_nhaHangTblModel.setRowCount(0);
				}
				addRowTblCTKeHoachTheoNgay_NhaHang(nhaHang);
				if(tblCTKeHoachTheoNgay_KhachSan.getRowCount() > 0) {
					ctKeHoachTheoNgay_khachSanTblModel.setRowCount(0);
				}
				addRowTblCTKeHoachTheoNgay_KhachSan(khachSan);
			}
		});
		tblCTKeHoachTheoNgay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tblCTKeHoachTheoNgay.setRowHeight(50);
		String[] colNamesTblCTKeHoachTheoNgay = {"M?? CTKH theo ng??y", "Ng??y", "M?? KH tour", "M?? ?????a ??i???m TQ", "M?? ph????ng ti???n", "M?? nh?? h??ng", "M?? kh??ch s???n"};
		ctKeHoachTheoNgayTblModel = new DefaultTableModel();
		tblCTKeHoachTheoNgay.setModel(ctKeHoachTheoNgayTblModel);
		for(String colName : colNamesTblCTKeHoachTheoNgay) {
			ctKeHoachTheoNgayTblModel.addColumn(colName);
		}
		loadTblCTKeHoachTheoNgay();
		
		ctKeHoachTheoNgayScrollPane.setViewportView(tblCTKeHoachTheoNgay);
		tblCTKeHoachTheoNgay.setFillsViewportHeight(true);
		
		JLabel lblThongTinDiaDiemThamQuan = new JLabel("Th??ng tin ?????a ??i???m tham quan:");
		lblThongTinDiaDiemThamQuan.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThongTinDiaDiemThamQuan.setBounds(50, 410, 250, 30);
		cardQuanLyCTKeHoachTheoNgay.add(lblThongTinDiaDiemThamQuan);
		
		JScrollPane ctKeHoachTheoNgay_diaDiemThamQuanScrollPane = new JScrollPane();
		ctKeHoachTheoNgay_diaDiemThamQuanScrollPane.setBounds(50, 450, 375, 73);
		cardQuanLyCTKeHoachTheoNgay.add(ctKeHoachTheoNgay_diaDiemThamQuanScrollPane);
		
		tblCTKeHoachTheoNgay_DiaDiemThamQuan = new JTable();
		tblCTKeHoachTheoNgay_DiaDiemThamQuan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tblCTKeHoachTheoNgay_DiaDiemThamQuan.setRowHeight(50);
		String[] colNamesTblCTKeHoachTheoNgay_DiaDiemThamQuan = {"M?? ?????a ??i???m", "T??n ?????a ??i???m", "?????a ch???"};
		ctKeHoachTheoNgay_diaDiemThamQuanTblModel = new DefaultTableModel();
		tblCTKeHoachTheoNgay_DiaDiemThamQuan.setModel(ctKeHoachTheoNgay_diaDiemThamQuanTblModel);
		for(String colName : colNamesTblCTKeHoachTheoNgay_DiaDiemThamQuan) {
			ctKeHoachTheoNgay_diaDiemThamQuanTblModel.addColumn(colName);
		}
		
		ctKeHoachTheoNgay_diaDiemThamQuanScrollPane.setViewportView(tblCTKeHoachTheoNgay_DiaDiemThamQuan);
		tblCTKeHoachTheoNgay_DiaDiemThamQuan.setFillsViewportHeight(true);
		
		JButton btnCTKeHoachTheoNgay_DiaDiemThamQuanLayout = new JButton("Xem danh s??ch");
		btnCTKeHoachTheoNgay_DiaDiemThamQuanLayout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyDiaDiemThamQuan");
			}
		});
		addActionListenerBtnTour_Update();
		btnCTKeHoachTheoNgay_DiaDiemThamQuanLayout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCTKeHoachTheoNgay_DiaDiemThamQuanLayout.setBounds(50, 530, 150, 30);
		cardQuanLyCTKeHoachTheoNgay.add(btnCTKeHoachTheoNgay_DiaDiemThamQuanLayout);
		
		JLabel lblThongTinNhaHang = new JLabel("Th??ng tin nh?? h??ng:");
		lblThongTinNhaHang.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThongTinNhaHang.setBounds(650, 410, 250, 30);
		cardQuanLyCTKeHoachTheoNgay.add(lblThongTinNhaHang);
		
		JScrollPane ctKeHoachTheoNgay_nhaHangScrollPane = new JScrollPane();
		ctKeHoachTheoNgay_nhaHangScrollPane.setBounds(650, 450, 500, 73);
		cardQuanLyCTKeHoachTheoNgay.add(ctKeHoachTheoNgay_nhaHangScrollPane);
		
		tblCTKeHoachTheoNgay_NhaHang = new JTable();
		tblCTKeHoachTheoNgay_NhaHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tblCTKeHoachTheoNgay_NhaHang.setRowHeight(50);
		String[] colNamesTblCTKeHoachTheoNgay_NhaHang = {"M?? nh?? h??ng", "T??n nh?? h??ng", "?????a ch???", "Chi ph?? tr??n ng?????i"};
		ctKeHoachTheoNgay_nhaHangTblModel = new DefaultTableModel();
		tblCTKeHoachTheoNgay_NhaHang.setModel(ctKeHoachTheoNgay_nhaHangTblModel);
		for(String colName : colNamesTblCTKeHoachTheoNgay_NhaHang) {
			ctKeHoachTheoNgay_nhaHangTblModel.addColumn(colName);
		}
		
		ctKeHoachTheoNgay_nhaHangScrollPane.setViewportView(tblCTKeHoachTheoNgay_NhaHang);
		tblCTKeHoachTheoNgay_NhaHang.setFillsViewportHeight(true);
		
		JButton btnCTKeHoachTheoNgay_NhaHangLayout = new JButton("Xem danh s??ch");
		btnCTKeHoachTheoNgay_NhaHangLayout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyNhaHang");
			}
		});
		addActionListenerBtnTour_Update();
		btnCTKeHoachTheoNgay_NhaHangLayout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCTKeHoachTheoNgay_NhaHangLayout.setBounds(650, 530, 150, 30);
		cardQuanLyCTKeHoachTheoNgay.add(btnCTKeHoachTheoNgay_NhaHangLayout);
		
		JLabel lblThongTinPhuongTien = new JLabel("Th??ng tin ph????ng ti???n:");
		lblThongTinPhuongTien.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThongTinPhuongTien.setBounds(50, 600, 250, 30);
		cardQuanLyCTKeHoachTheoNgay.add(lblThongTinPhuongTien);
		
		JScrollPane ctKeHoachTheoNgay_phuongTienScrollPane = new JScrollPane();
		ctKeHoachTheoNgay_phuongTienScrollPane.setBounds(50, 640, 500, 73);
		cardQuanLyCTKeHoachTheoNgay.add(ctKeHoachTheoNgay_phuongTienScrollPane);
		
		tblCTKeHoachTheoNgay_PhuongTien = new JTable();
		tblCTKeHoachTheoNgay_PhuongTien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tblCTKeHoachTheoNgay_PhuongTien.setRowHeight(50);
		String[] colNamesTblCTKeHoachTheoNgay_PhuongTien = {"M?? ph????ng ti???n", "T??n ph????ng ti???n", "Chi ph??", "S??? ch??? ng???i"};
		ctKeHoachTheoNgay_phuongTienTblModel = new DefaultTableModel();
		tblCTKeHoachTheoNgay_PhuongTien.setModel(ctKeHoachTheoNgay_phuongTienTblModel);
		for(String colName : colNamesTblCTKeHoachTheoNgay_PhuongTien) {
			ctKeHoachTheoNgay_phuongTienTblModel.addColumn(colName);
		}
		
		ctKeHoachTheoNgay_phuongTienScrollPane.setViewportView(tblCTKeHoachTheoNgay_PhuongTien);
		tblCTKeHoachTheoNgay_PhuongTien.setFillsViewportHeight(true);
		
		JButton btnCTKeHoachTheoNgay_PhuongTienLayout = new JButton("Xem danh s??ch");
		btnCTKeHoachTheoNgay_PhuongTienLayout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyPhuongTien");
			}
		});
		addActionListenerBtnTour_Update();
		btnCTKeHoachTheoNgay_PhuongTienLayout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCTKeHoachTheoNgay_PhuongTienLayout.setBounds(50, 720, 150, 30);
		cardQuanLyCTKeHoachTheoNgay.add(btnCTKeHoachTheoNgay_PhuongTienLayout);
		
		JLabel lblThongTinKhachSan = new JLabel("Th??ng tin kh??ch s???n:");
		lblThongTinKhachSan.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThongTinKhachSan.setBounds(650, 600, 250, 30);
		cardQuanLyCTKeHoachTheoNgay.add(lblThongTinKhachSan);
		
		JScrollPane ctKeHoachTheoNgay_khachSanScrollPane = new JScrollPane();
		ctKeHoachTheoNgay_khachSanScrollPane.setBounds(650, 640, 500, 73);
		cardQuanLyCTKeHoachTheoNgay.add(ctKeHoachTheoNgay_khachSanScrollPane);
		
		tblCTKeHoachTheoNgay_KhachSan = new JTable();
		tblCTKeHoachTheoNgay_KhachSan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tblCTKeHoachTheoNgay_KhachSan.setRowHeight(50);
		String[] colNamesTblCTKeHoachTheoNgay_KhachSan = {"M?? kh??ch s???n", "T??n kh??ch s???n", "?????a ch???", "Chi ph?? tr??n ng?????i"};
		ctKeHoachTheoNgay_khachSanTblModel = new DefaultTableModel();
		tblCTKeHoachTheoNgay_KhachSan.setModel(ctKeHoachTheoNgay_khachSanTblModel);
		for(String colName : colNamesTblCTKeHoachTheoNgay_KhachSan) {
			ctKeHoachTheoNgay_khachSanTblModel.addColumn(colName);
		}
		
		ctKeHoachTheoNgay_khachSanScrollPane.setViewportView(tblCTKeHoachTheoNgay_KhachSan);
		tblCTKeHoachTheoNgay_KhachSan.setFillsViewportHeight(true);
		
		JButton btnCTKeHoachTheoNgay_KhachSanLayout = new JButton("Xem danh s??ch");
		btnCTKeHoachTheoNgay_KhachSanLayout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyKhachSan");
			}
		});
		addActionListenerBtnTour_Update();
		btnCTKeHoachTheoNgay_KhachSanLayout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCTKeHoachTheoNgay_KhachSanLayout.setBounds(650, 720, 150, 30);
		cardQuanLyCTKeHoachTheoNgay.add(btnCTKeHoachTheoNgay_KhachSanLayout);
		// ===== CT KE HOACH THEO NGAY LAYOUT END HERE =====
		
		// ===== ADD CT KE HOACH THEO NGAY LAYOUT START HERE =====
		JPanel cardAddCTKeHoachTheoNgay = new JPanel();
		cardsPane.add(cardAddCTKeHoachTheoNgay);
		cardAddCTKeHoachTheoNgay.setLayout(null);
		cardLayout.addLayoutComponent(cardAddCTKeHoachTheoNgay, "cardAddCTKeHoachTheoNgay");
		
		JLabel lblAddCTKeHoachTheoNgay_TieuDe = new JLabel("Trang th??m chi ti???t k??? ho???ch");
		lblAddCTKeHoachTheoNgay_TieuDe.setBounds(0, 0, 500, 100);
		lblAddCTKeHoachTheoNgay_TieuDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardAddCTKeHoachTheoNgay.add(lblAddCTKeHoachTheoNgay_TieuDe);
		
		JLabel lblAddMaCTKeHoachTheoNgay = new JLabel("Nh???p m?? CT k??? ho???ch theo ng??y:");
		lblAddMaCTKeHoachTheoNgay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddMaCTKeHoachTheoNgay.setBounds(50, 100, 200, 30);
		cardAddCTKeHoachTheoNgay.add(lblAddMaCTKeHoachTheoNgay);
		
		JTextField txtAddMaCTKeHoachTheoNgay = new JTextField();
		txtAddMaCTKeHoachTheoNgay.setColumns(10);
		txtAddMaCTKeHoachTheoNgay.setBounds(250, 100, 300, 30);
		cardAddCTKeHoachTheoNgay.add(txtAddMaCTKeHoachTheoNgay);
		
		JLabel lblAddNgay = new JLabel("Nh???p ng??y:");
		lblAddNgay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddNgay.setBounds(50, 150, 200, 30);
		cardAddCTKeHoachTheoNgay.add(lblAddNgay);
		
		JTextField txtAddNgay = new JTextField();
		txtAddNgay.setColumns(10);
		txtAddNgay.setBounds(250, 150, 300, 30);
		cardAddCTKeHoachTheoNgay.add(txtAddNgay);
		
		JLabel lblAddDiaDiemThamQuan = new JLabel("?????a ??i???m tham quan:");
		lblAddDiaDiemThamQuan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddDiaDiemThamQuan.setBounds(50, 200, 200, 30);
		cardAddCTKeHoachTheoNgay.add(lblAddDiaDiemThamQuan);
		
		JTextField txtAddDiaDiemThamQuan = new JTextField();
		txtAddDiaDiemThamQuan.setColumns(10);
		txtAddDiaDiemThamQuan.setBounds(250, 200, 300, 30);
		cardAddCTKeHoachTheoNgay.add(txtAddDiaDiemThamQuan);
		
		JLabel lblAddPhuongTien = new JLabel("Ph????ng ti???n:");
		lblAddPhuongTien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddPhuongTien.setBounds(50, 250, 200, 30);
		cardAddCTKeHoachTheoNgay.add(lblAddPhuongTien);
		
		JTextField txtAddPhuongTien = new JTextField();
		txtAddPhuongTien.setColumns(10);
		txtAddPhuongTien.setBounds(250, 250, 300, 30);
		cardAddCTKeHoachTheoNgay.add(txtAddPhuongTien);
		
		JLabel lblAddNhaHang = new JLabel("Nh?? h??ng:");
		lblAddNhaHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddNhaHang.setBounds(50, 300, 200, 30);
		cardAddCTKeHoachTheoNgay.add(lblAddNhaHang);
		
		JTextField txtAddNhaHang = new JTextField();
		txtAddNhaHang.setColumns(10);
		txtAddNhaHang.setBounds(250, 300, 300, 30);
		cardAddCTKeHoachTheoNgay.add(txtAddNhaHang);
		
		JLabel lblAddKhachSan = new JLabel("Kh??ch s???n:");
		lblAddKhachSan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddKhachSan.setBounds(50, 350, 200, 30);
		cardAddCTKeHoachTheoNgay.add(lblAddKhachSan);
		
		JTextField txtAddKhachSan = new JTextField();
		txtAddKhachSan.setColumns(10);
		txtAddKhachSan.setBounds(250, 350, 300, 30);
		cardAddCTKeHoachTheoNgay.add(txtAddKhachSan);
		
		JLabel lblAddCTKeHoachTheoNgay_MaKHTour = new JLabel("Nh???p m?? k??? ho???ch:");
		lblAddCTKeHoachTheoNgay_MaKHTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddCTKeHoachTheoNgay_MaKHTour.setBounds(50, 400, 200, 30);
		cardAddCTKeHoachTheoNgay.add(lblAddCTKeHoachTheoNgay_MaKHTour);
		
		JTextField txtAddCTKeHoachTheoNgay_MaKHTour = new JTextField();
		txtAddCTKeHoachTheoNgay_MaKHTour.setColumns(10);
		txtAddCTKeHoachTheoNgay_MaKHTour.setBounds(250, 400, 300, 30);
		cardAddCTKeHoachTheoNgay.add(txtAddCTKeHoachTheoNgay_MaKHTour);
		
		JButton btnAddCTKeHoachTheoNgay_ThemMoi = new JButton("Th??m m???i");
		btnAddCTKeHoachTheoNgay_ThemMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CTKeHoachTheoNgayDTO dto = new CTKeHoachTheoNgayDTO();
				
				dto.setMaCTKHTheoNgay(txtAddMaCTKeHoachTheoNgay.getText());
				dto.setNgay(txtAddNgay.getText());
				dto.setMaKHTour(txtAddCTKeHoachTheoNgay_MaKHTour.getText());
				dto.setMaDiaDiemThamQuan(txtAddDiaDiemThamQuan.getText());
				dto.setMaPhuongTien(txtAddPhuongTien.getText());
				dto.setMaNhaHang(txtAddNhaHang.getText());
				dto.setMaKhachSan(txtAddKhachSan.getText());
				
				ctKeHoachTheoNgayBUS.add(dto);
				CTKeHoachTheoNgayBUS.listCTKeHoachTheoNgayDTO.add(dto);
				addRowTblKeHoachTour_CTKeHoachTheoNgay(dto);
				cardLayout.show(cardsPane, "cardQuanLyCTKeHoachTheoNgay");
				// clear all text after add
				txtAddMaCTKeHoachTheoNgay.setText("");
				txtAddNgay.setText("");
				txtAddDiaDiemThamQuan.setText("");
				txtAddPhuongTien.setText("");
				txtAddNhaHang.setText("");
				txtAddKhachSan.setText("");
				txtAddCTKeHoachTheoNgay_MaKHTour.setText("");
			}
		});
		btnAddCTKeHoachTheoNgay_ThemMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddCTKeHoachTheoNgay_ThemMoi.setBounds(150, 450, 120, 30);
		cardAddCTKeHoachTheoNgay.add(btnAddCTKeHoachTheoNgay_ThemMoi);
		
		JButton btnAddCTKeHoachTheoNgay_QuayLai = new JButton("Quay l???i");
		btnAddCTKeHoachTheoNgay_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyKeHoachTour");
			}
		});
		btnAddCTKeHoachTheoNgay_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddCTKeHoachTheoNgay_QuayLai.setBounds(300, 450, 120, 30);
		cardAddCTKeHoachTheoNgay.add(btnAddCTKeHoachTheoNgay_QuayLai);
		// ===== ADD CT KE HOACH THEO NGAY LAYOUT END HERE =====
		
		// ===== UPDATE CT KE HOACH THEO NGAY LAYOUT START HERE =====
		JPanel cardUpdateCTKeHoachTheoNgay = new JPanel();
		cardsPane.add(cardUpdateCTKeHoachTheoNgay);
		cardUpdateCTKeHoachTheoNgay.setLayout(null);
		cardLayout.addLayoutComponent(cardUpdateCTKeHoachTheoNgay, "cardUpdateCTKeHoachTheoNgay");
		
		JLabel lblUpdateCTKeHoachTheoNgay_TieuDe = new JLabel("Trang c???p nh???t chi ti???t k??? ho???ch");
		lblUpdateCTKeHoachTheoNgay_TieuDe.setBounds(0, 0, 400, 100);
		lblUpdateCTKeHoachTheoNgay_TieuDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardUpdateCTKeHoachTheoNgay.add(lblUpdateCTKeHoachTheoNgay_TieuDe);
		
		JLabel lblUpdateMaCTKeHoachTheoNgay = new JLabel("Nh???p m?? CTKH:");
		lblUpdateMaCTKeHoachTheoNgay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateMaCTKeHoachTheoNgay.setBounds(50, 100, 150, 30);
		cardUpdateCTKeHoachTheoNgay.add(lblUpdateMaCTKeHoachTheoNgay);
		
		txtUpdateMaCTKeHoachTheoNgay = new JTextField();
		txtUpdateMaCTKeHoachTheoNgay.setColumns(10);
		txtUpdateMaCTKeHoachTheoNgay.setBounds(200, 100, 300, 30);
		cardUpdateCTKeHoachTheoNgay.add(txtUpdateMaCTKeHoachTheoNgay);
		
		JLabel lblUpdateNgay = new JLabel("Nh???p ng??y:");
		lblUpdateNgay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateNgay.setBounds(50, 150, 150, 30);
		cardUpdateCTKeHoachTheoNgay.add(lblUpdateNgay);
		
		txtUpdateNgay = new JTextField();
		txtUpdateNgay.setColumns(10);
		txtUpdateNgay.setBounds(200, 150, 300, 30);
		cardUpdateCTKeHoachTheoNgay.add(txtUpdateNgay);
		
		JLabel lblUpdateDiaDiemThamQuan = new JLabel("?????a ??i???m tham quan:");
		lblUpdateDiaDiemThamQuan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateDiaDiemThamQuan.setBounds(50, 250, 150, 30);
		cardUpdateCTKeHoachTheoNgay.add(lblUpdateDiaDiemThamQuan);
		
		txtUpdateDiaDiemThamQuan = new JTextField();
		txtUpdateDiaDiemThamQuan.setColumns(10);
		txtUpdateDiaDiemThamQuan.setBounds(200, 250, 300, 30);
		cardUpdateCTKeHoachTheoNgay.add(txtUpdateDiaDiemThamQuan);
		
		JLabel lblUpdatePhuongTien = new JLabel("Ph????ng ti???n:");
		lblUpdatePhuongTien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdatePhuongTien.setBounds(50, 300, 150, 30);
		cardUpdateCTKeHoachTheoNgay.add(lblUpdatePhuongTien);

		txtUpdatePhuongTien = new JTextField();
		txtUpdatePhuongTien.setColumns(10);
		txtUpdatePhuongTien.setBounds(200, 300, 300, 30);
		cardUpdateCTKeHoachTheoNgay.add(txtUpdatePhuongTien);
		
		JLabel lblUpdateNhaHang = new JLabel("Nh?? h??ng:");
		lblUpdateNhaHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateNhaHang.setBounds(50, 350, 150, 30);
		cardUpdateCTKeHoachTheoNgay.add(lblUpdateNhaHang);

		txtUpdateNhaHang = new JTextField();
		txtUpdateNhaHang.setColumns(10);
		txtUpdateNhaHang.setBounds(200, 350, 300, 30);
		cardUpdateCTKeHoachTheoNgay.add(txtUpdateNhaHang);
		
		JLabel lblUpdateKhachSan = new JLabel("Kh??ch s???n:");
		lblUpdateKhachSan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateKhachSan.setBounds(50, 400, 150, 30);
		cardUpdateCTKeHoachTheoNgay.add(lblUpdateKhachSan);

		txtUpdateKhachSan = new JTextField();
		txtUpdateKhachSan.setColumns(10);
		txtUpdateKhachSan.setBounds(200, 400, 300, 30);
		cardUpdateCTKeHoachTheoNgay.add(txtUpdateKhachSan);
		
		JLabel lblUpdateCTKeHoachTheoNgay_MaKHTour = new JLabel("Nh???p m?? KH Tour:");
		lblUpdateCTKeHoachTheoNgay_MaKHTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateCTKeHoachTheoNgay_MaKHTour.setBounds(50, 200, 150, 30);
		cardUpdateCTKeHoachTheoNgay.add(lblUpdateCTKeHoachTheoNgay_MaKHTour);

		txtUpdateCTKeHoachTheoNgay_MaKHTour = new JTextField();
		txtUpdateCTKeHoachTheoNgay_MaKHTour.setColumns(10);
		txtUpdateCTKeHoachTheoNgay_MaKHTour.setBounds(200, 200, 300, 30);
		cardUpdateCTKeHoachTheoNgay.add(txtUpdateCTKeHoachTheoNgay_MaKHTour);
		
		JButton btnUpdateCTKeHoachTheoNgay_CapNhat = new JButton("C???p nh???t");
		btnUpdateCTKeHoachTheoNgay_CapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CTKeHoachTheoNgayDTO dto = new CTKeHoachTheoNgayDTO();
				
				dto.setMaCTKHTheoNgay(txtUpdateMaCTKeHoachTheoNgay.getText());
				dto.setNgay(txtUpdateNgay.getText());
				dto.setMaKHTour(txtUpdateCTKeHoachTheoNgay_MaKHTour.getText());
				dto.setMaDiaDiemThamQuan(txtUpdateDiaDiemThamQuan.getText());
				dto.setMaPhuongTien(txtUpdatePhuongTien.getText());
				dto.setMaNhaHang(txtUpdateNhaHang.getText());
				dto.setMaKhachSan(txtUpdateKhachSan.getText());
				
				ctKeHoachTheoNgayBUS.update(dto);
				CTKeHoachTheoNgayBUS.listCTKeHoachTheoNgayDTO.set(selectedRow, dto);
				setRow(dto, selectedRow);
//				cardLayout.show(cardsPane, "cardQuanLyKeHoachTour");
				reloadTblKeHoachTour_CTKeHoachTheoNgay(dto);
				// clear all text after update
				txtUpdateMaCTKeHoachTheoNgay.setText("");
				txtUpdateNgay.setText("");
				txtUpdateCTKeHoachTheoNgay_MaKHTour.setText("");
				txtUpdateDiaDiemThamQuan.setText("");
				txtUpdatePhuongTien.setText("");
				txtUpdateNhaHang.setText("");
				txtUpdateKhachSan.setText("");
			}
		});
		btnUpdateCTKeHoachTheoNgay_CapNhat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateCTKeHoachTheoNgay_CapNhat.setBounds(150, 450, 120, 30);
		cardUpdateCTKeHoachTheoNgay.add(btnUpdateCTKeHoachTheoNgay_CapNhat);
		
		JButton btnUpdateCTKeHoachTheoNgay_QuayLai = new JButton("Quay l???i");
		btnUpdateCTKeHoachTheoNgay_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyKeHoachTour");
			}
		});
		btnUpdateCTKeHoachTheoNgay_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateCTKeHoachTheoNgay_QuayLai.setBounds(300, 450, 100, 30);
		cardUpdateCTKeHoachTheoNgay.add(btnUpdateCTKeHoachTheoNgay_QuayLai);
		// ===== UPDATE CT KE HOACH LAYOUT END HERE =====
		
		// ===== PHUONG TIEN LAYOUT START HERE =====
		JPanel cardQuanLyPhuongTien= new JPanel();
		cardsPane.add(cardQuanLyPhuongTien, "name_4568411886400");
		cardQuanLyPhuongTien.setLayout(null);
		cardLayout.addLayoutComponent(cardQuanLyPhuongTien, "cardQuanLyPhuongTien");
		
		JLabel lblPhuongTien_TieuDe = new JLabel("Trang qu???n l?? ph????ng ti???n");
		lblPhuongTien_TieuDe.setBounds(0, 0, 500, 100);
		lblPhuongTien_TieuDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardQuanLyPhuongTien.add(lblPhuongTien_TieuDe);
		
		JLabel lblPhuongTien_TimKiem = new JLabel("T??m ki???m:");
		lblPhuongTien_TimKiem.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblPhuongTien_TimKiem.setBounds(20, 100, 80, 30);
		cardQuanLyPhuongTien.add(lblPhuongTien_TimKiem);
		
		JTextField txtPhuongTien_TimKiem = new JTextField();
		txtPhuongTien_TimKiem.setBounds(100, 100, 200, 30);
		txtPhuongTien_TimKiem.setColumns(10);
		cardQuanLyPhuongTien.add(txtPhuongTien_TimKiem);
		
		JButton btnPhuongTien_TimKiem = new JButton("T??m");
		btnPhuongTien_TimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PhuongTienDTO dto =phuongTienBUS.getByMaPhuongTien(txtPhuongTien_TimKiem.getText());
					
				phuongTienTblModel.setRowCount(0); // xoa tat ca row
				
					phuongTienTblModel.addRow(new Object[] {
							dto.getMaPhuongTien(), dto.getTenPhuongTien(), dto.getChiPhi(), dto.getSoChoNgoi()});
				
			}
		});
		btnPhuongTien_TimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPhuongTien_TimKiem.setBounds(310, 100, 80, 30);
		cardQuanLyPhuongTien.add(btnPhuongTien_TimKiem);
		
		JScrollPane phuongtienScrollPane = new JScrollPane();
		phuongtienScrollPane.setBounds(50, 150, 600, 273);
		cardQuanLyPhuongTien.add(phuongtienScrollPane);
		
		tblPhuongTien = new JTable();
		tblPhuongTien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tblPhuongTien.getSelectedRow();
				
			}
		});
		tblPhuongTien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tblPhuongTien.setRowHeight(50);
		String[] colNamesTblPhuongTien = {"M?? ph????ng ti???n", "T??n ph????ng ti???n", "Chi phi", "S??? ch??? ng???i"};
		phuongTienTblModel = new DefaultTableModel();
		tblPhuongTien.setModel(phuongTienTblModel);
		for(String colName : colNamesTblPhuongTien) {
			phuongTienTblModel.addColumn(colName);
		}
		loadTblPhuongTien();
		
		phuongtienScrollPane.setViewportView(tblPhuongTien);
		tblPhuongTien.setFillsViewportHeight(true);
		
		JButton btnPhuongTien_TaiLai = new JButton("T???i l???i b???ng");
		btnPhuongTien_TaiLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				phuongTienTblModel.setRowCount(0);
				loadTblPhuongTien();
			}
		});
		btnPhuongTien_TaiLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPhuongTien_TaiLai.setBounds(670, 150, 200, 30);
		cardQuanLyPhuongTien.add(btnPhuongTien_TaiLai);
		
		JButton btnPhuongTien_Xoa = new JButton("X??a ph????ng ti???n");
		btnPhuongTien_Xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tblPhuongTien.getSelectedRow();

				if(selectedRow>=0) {
					int result = JOptionPane.showConfirmDialog(null,"B???n c?? ch???c mu???n x??a th??ng tin n??y ?", "Th??ng b??o",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	                if(result == JOptionPane.YES_OPTION){
	                	String maPhuongTien = (String) tblPhuongTien.getValueAt(selectedRow, 0);
	    				
	    				phuongTienBUS.deleteById(maPhuongTien);
	    				phuongTienTblModel.removeRow(selectedRow);
						}
	                else if(result == JOptionPane.NO_OPTION)
                    {
                        JOptionPane.showMessageDialog(null, "Kh??ng x??a th??ng tin");
                    }
				}
				if(selectedRow<0) {
					JOptionPane.showMessageDialog(cardQuanLyTour, "B???n ch??a ch???n tr?????ng d??? li???u!");
				}
			}
		});
		btnPhuongTien_Xoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPhuongTien_Xoa.setBounds(670, 200, 200, 30);;
		cardQuanLyPhuongTien.add(btnPhuongTien_Xoa);
		
		JButton btnPhuongTien_ThemMoi = new JButton("Th??m ph????ng ti???n");
		btnPhuongTien_ThemMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardAddPhuongTien");
			}
		});
		btnPhuongTien_ThemMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPhuongTien_ThemMoi.setBounds(670, 250, 200, 30);
		cardQuanLyPhuongTien.add(btnPhuongTien_ThemMoi);
		
		btnPhuongTien_CapNhat = new JButton("C???p nh???t ph????ng ti???n");
		addActionListenerBtnPhuongTien_Update();
		btnPhuongTien_CapNhat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPhuongTien_CapNhat.setBounds(670, 300, 200, 30);
		cardQuanLyPhuongTien.add(btnPhuongTien_CapNhat);
		
		JButton btnPhuongTien_QuayLai = new JButton("Quay l???i");
		btnPhuongTien_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyCTKeHoachTheoNgay");
			}
		});
		btnPhuongTien_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPhuongTien_QuayLai.setBounds(50, 450, 100, 30);
		cardQuanLyPhuongTien.add(btnPhuongTien_QuayLai);
		// ===== PHUONG TIEN LAYOUT END HERE =====
		
		// ===== ADD PHUONG TIEN LAYOUT START HERE =====
		JPanel cardAddPhuongTien = new JPanel();
		cardsPane.add(cardAddPhuongTien);
		cardAddPhuongTien.setLayout(null);
		cardLayout.addLayoutComponent(cardAddPhuongTien, "cardAddPhuongTien");
		
		JLabel lblAddPhuongTien_TieuDe = new JLabel("Trang th??m ph????ng ti???n");
		lblAddPhuongTien_TieuDe.setBounds(0, 0, 500, 100);
		lblAddPhuongTien_TieuDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardAddPhuongTien.add(lblAddPhuongTien_TieuDe);
		
		JLabel lblAddMaPhuongTien = new JLabel("Nh???p m?? ph????ng ti???n:");
		lblAddMaPhuongTien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddMaPhuongTien.setBounds(50, 100, 200, 30);
		cardAddPhuongTien.add(lblAddMaPhuongTien);
		
		JTextField txtAddMaPhuongTien = new JTextField();
		txtAddMaPhuongTien.setColumns(10);
		txtAddMaPhuongTien.setBounds(250, 100, 300, 30);
		cardAddPhuongTien.add(txtAddMaPhuongTien);
		
		JLabel lblAddTenPhuongTien = new JLabel("Nh???p t??n ph????ng ti???n:");
		lblAddTenPhuongTien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddTenPhuongTien.setBounds(50, 150, 200, 30);
		cardAddPhuongTien.add(lblAddTenPhuongTien);
		
		JTextField txtAddTenPhuongTien = new JTextField();
		txtAddTenPhuongTien.setColumns(10);
		txtAddTenPhuongTien.setBounds(250, 150, 300, 30);
		cardAddPhuongTien.add(txtAddTenPhuongTien);
		
		JLabel lblAddChiPhi = new JLabel("Nh???p chi ph??:");
		lblAddChiPhi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddChiPhi.setBounds(50, 200, 200, 30);
		cardAddPhuongTien.add(lblAddChiPhi);
		
		JTextField txtAddChiPhi = new JTextField();
		txtAddChiPhi.setColumns(10);
		txtAddChiPhi.setBounds(250, 200, 300, 30);
		cardAddPhuongTien.add(txtAddChiPhi);
		
		JLabel lblAddSoChoNgoi = new JLabel("Nh???p s??? ch??? ng???i:");
		lblAddSoChoNgoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddSoChoNgoi.setBounds(50, 250, 200, 30);
		cardAddPhuongTien.add(lblAddSoChoNgoi);
		
		JTextField txtAddSoChoNgoi = new JTextField();
		txtAddSoChoNgoi.setColumns(10);
		txtAddSoChoNgoi.setBounds(250, 250, 300, 30);
		cardAddPhuongTien.add(txtAddSoChoNgoi);
		
		JButton btnAddPhuongTien_ThemMoi = new JButton("Th??m m???i");
		btnAddPhuongTien_ThemMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PhuongTienDTO dto = new PhuongTienDTO();
				
				dto.setMaPhuongTien(txtAddMaPhuongTien.getText());
				dto.setTenPhuongTien(txtAddTenPhuongTien.getText());
				dto.setChiPhi(Double.valueOf(txtAddChiPhi.getText()));
				dto.setSoChoNgoi(Integer.valueOf(txtAddSoChoNgoi.getText()));
				
				phuongTienBUS.add(dto);
				PhuongTienBUS.listPhuongTienDTO.add(dto);
				addRowTblPhuongTien(dto);
				cardLayout.show(cardsPane, "cardQuanLyPhuongTien");
				// clear all text after add
				txtAddMaPhuongTien.setText("");
				txtAddTenPhuongTien.setText("");
				txtAddChiPhi.setText("");
				txtAddSoChoNgoi.setText("");
			}
		});
		btnAddPhuongTien_ThemMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddPhuongTien_ThemMoi.setBounds(150, 300, 120, 30);
		cardAddPhuongTien.add(btnAddPhuongTien_ThemMoi);
		
		JButton btnAddPhuongTien_QuayLai = new JButton("Quay l???i");
		btnAddPhuongTien_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyPhuongTien");
			}
		});
		btnAddPhuongTien_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddPhuongTien_QuayLai.setBounds(300, 300, 120, 30);
		cardAddPhuongTien.add(btnAddPhuongTien_QuayLai);
		// ===== ADD PHUONG TIEN LAYOUT END HERE =====
		
		// ===== UPDATE PHUONG TIEN LAYOUT START HERE =====
		JPanel cardUpdatePhuongTien = new JPanel();
		cardsPane.add(cardUpdatePhuongTien);
		cardUpdatePhuongTien.setLayout(null);
		cardLayout.addLayoutComponent(cardUpdatePhuongTien, "cardUpdatePhuongTien");
		
		JLabel lblUpdatePhuongTien_TieuDe = new JLabel("Trang c???p nh???t ph????ng ti???n");
		lblUpdatePhuongTien_TieuDe.setBounds(0, 0, 400, 100);
		lblUpdatePhuongTien_TieuDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardUpdatePhuongTien.add(lblUpdatePhuongTien_TieuDe);
		
		JLabel lblUpdateMaPhuongTien = new JLabel("Nh???p m?? ph????ng ti???n:");
		lblUpdateMaPhuongTien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateMaPhuongTien.setBounds(50, 100, 150, 30);
		cardUpdatePhuongTien.add(lblUpdateMaPhuongTien);
		
		txtUpdateMaPhuongTien = new JTextField();
		txtUpdateMaPhuongTien.setColumns(10);
		txtUpdateMaPhuongTien.setBounds(200, 100, 300, 30);
		cardUpdatePhuongTien.add(txtUpdateMaPhuongTien);
		
		JLabel lblUpdateTenPhuongTien = new JLabel("Nh???p t??n ph????ng ti???n:");
		lblUpdateTenPhuongTien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateTenPhuongTien.setBounds(50, 150, 150, 30);
		cardUpdatePhuongTien.add(lblUpdateTenPhuongTien);
		
		txtUpdateTenPhuongTien = new JTextField();
		txtUpdateTenPhuongTien.setColumns(10);
		txtUpdateTenPhuongTien.setBounds(200, 150, 300, 30);
		cardUpdatePhuongTien.add(txtUpdateTenPhuongTien);
		
		JLabel lblUpdateChiPhi = new JLabel("Nh???p chi ph??:");
		lblUpdateChiPhi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateChiPhi.setBounds(50, 200, 150, 30);
		cardUpdatePhuongTien.add(lblUpdateChiPhi);
		
		txtUpdateChiPhi = new JTextField();
		txtUpdateChiPhi.setColumns(10);
		txtUpdateChiPhi.setBounds(200, 200, 300, 30);
		cardUpdatePhuongTien.add(txtUpdateChiPhi);
		
		JLabel lblUpdateSoChoNgoi = new JLabel("Nh???p s??? ch??? ng???i:");
		lblUpdateSoChoNgoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateSoChoNgoi.setBounds(50, 250, 150, 30);
		cardUpdatePhuongTien.add(lblUpdateSoChoNgoi);

		txtUpdateSoChoNgoi = new JTextField();
		txtUpdateSoChoNgoi.setColumns(10);
		txtUpdateSoChoNgoi.setBounds(200, 250, 300, 30);
		cardUpdatePhuongTien.add(txtUpdateSoChoNgoi);
		
		JButton btnUpdatePhuongTien_CapNhat = new JButton("C???p nh???t");
		btnUpdatePhuongTien_CapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PhuongTienDTO dto = new PhuongTienDTO();
				
				dto.setMaPhuongTien(txtUpdateMaPhuongTien.getText());
				dto.setTenPhuongTien(txtUpdateTenPhuongTien.getText());
				dto.setChiPhi(Double.valueOf(txtUpdateChiPhi.getText()));
				dto.setSoChoNgoi(Integer.valueOf(txtUpdateSoChoNgoi.getText()));
				
				phuongTienBUS.update(dto);
				PhuongTienBUS.listPhuongTienDTO.set(selectedRow, dto);
				setRow(dto, selectedRow);
				cardLayout.show(cardsPane, "cardQuanLyPhuongTien");
				phuongTienTblModel.setRowCount(0);
				loadTblPhuongTien();
				// clear all text after update
				txtUpdateMaPhuongTien.setText("");
				txtUpdateTenPhuongTien.setText("");
				txtUpdateChiPhi.setText("");
				txtUpdateSoChoNgoi.setText("");
			}
		});
		btnUpdatePhuongTien_CapNhat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdatePhuongTien_CapNhat.setBounds(150, 300, 120, 30);
		cardUpdatePhuongTien.add(btnUpdatePhuongTien_CapNhat);
		
		JButton btnUpdatePhuongTien_QuayLai = new JButton("Quay l???i");
		btnUpdatePhuongTien_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyPhuongTien");
			}
		});
		btnUpdatePhuongTien_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdatePhuongTien_QuayLai.setBounds(300, 300, 100, 30);
		cardUpdatePhuongTien.add(btnUpdatePhuongTien_QuayLai);
		// ===== UPDATE PHUONG TIEN LAYOUT END HERE =====
		
		// ===== DIA DIEM THAM QUAN LAYOUT START HERE =====
		JPanel cardQuanLyDiaDiemThamQuan = new JPanel();
		cardsPane.add(cardQuanLyDiaDiemThamQuan, "name_4568411886400");
		cardQuanLyDiaDiemThamQuan.setLayout(null);
		cardLayout.addLayoutComponent(cardQuanLyDiaDiemThamQuan, "cardQuanLyDiaDiemThamQuan");
		
		JLabel lblDiaDiemThamQuan_TieuDe = new JLabel("Trang qu???n l?? ?????a ??i???m tham quan");
		lblDiaDiemThamQuan_TieuDe.setBounds(0, 0, 600, 100);
		lblDiaDiemThamQuan_TieuDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardQuanLyDiaDiemThamQuan.add(lblDiaDiemThamQuan_TieuDe);
		
		JLabel lblDiaDiemThamQuan_TimKiem = new JLabel("T??m ki???m:");
		lblDiaDiemThamQuan_TimKiem.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblDiaDiemThamQuan_TimKiem.setBounds(20, 100, 80, 30);
		cardQuanLyDiaDiemThamQuan.add(lblDiaDiemThamQuan_TimKiem);
		
		JTextField txtDiaDiemThamQuan_TimKiem = new JTextField();
		txtDiaDiemThamQuan_TimKiem.setBounds(100, 100, 200, 30);
		txtDiaDiemThamQuan_TimKiem.setColumns(10);
		cardQuanLyDiaDiemThamQuan.add(txtDiaDiemThamQuan_TimKiem);
		
		JButton btnDiaDiemThamQuan_TimKiem = new JButton("T??m");
		btnDiaDiemThamQuan_TimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DiaDiemThamQuanDTO dto =diaDiemThamQuanBUS.getByMaDiaDiem(txtDiaDiemThamQuan_TimKiem.getText());
				diaDiemThamQuanTblModel.setRowCount(0); // xoa tat ca row
				diaDiemThamQuanTblModel.addRow(new Object[] {
							dto.getMaDiaDiem(), dto.getTenDiaDiem(), dto.getDiaChi()});
			}
		});
		btnDiaDiemThamQuan_TimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDiaDiemThamQuan_TimKiem.setBounds(310, 100, 80, 30);
		cardQuanLyDiaDiemThamQuan.add(btnDiaDiemThamQuan_TimKiem);
		
		JScrollPane diaDiemThamQuanScrollPane = new JScrollPane();
		diaDiemThamQuanScrollPane.setBounds(50, 150, 450, 273);
		cardQuanLyDiaDiemThamQuan.add(diaDiemThamQuanScrollPane);
		
		tblDiaDiemThamQuan = new JTable();
		tblDiaDiemThamQuan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tblDiaDiemThamQuan.getSelectedRow();
				
			}
		});
		tblDiaDiemThamQuan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tblDiaDiemThamQuan.setRowHeight(50);
		String[] colNamesTblDiaDiemThamQuan = {"M?? ?????a ??i???m", "T??n ?????a ??i???m", "?????a ch???"};
		diaDiemThamQuanTblModel = new DefaultTableModel();
		tblDiaDiemThamQuan.setModel(diaDiemThamQuanTblModel);
		for(String colName : colNamesTblDiaDiemThamQuan) {
			diaDiemThamQuanTblModel.addColumn(colName);
		}
		loadTblDiaDiemThamQuan();
		
		diaDiemThamQuanScrollPane.setViewportView(tblDiaDiemThamQuan);
		tblDiaDiemThamQuan.setFillsViewportHeight(true);
		
		JButton btnDiaDiemThamQuan_TaiLai = new JButton("T???i l???i b???ng");
		btnDiaDiemThamQuan_TaiLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				diaDiemThamQuanTblModel.setRowCount(0);
				loadTblDiaDiemThamQuan();
			}
		});
		btnDiaDiemThamQuan_TaiLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDiaDiemThamQuan_TaiLai.setBounds(520, 150, 200, 30);
		cardQuanLyDiaDiemThamQuan.add(btnDiaDiemThamQuan_TaiLai);
		
		JButton btnDiaDiemThamQuan_Xoa = new JButton("X??a ?????a ??i???m tham quan");
		btnDiaDiemThamQuan_Xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tblDiaDiemThamQuan.getSelectedRow();
				if(selectedRow>=0) {
					int result = JOptionPane.showConfirmDialog(null,"B???n c?? ch???c mu???n x??a th??ng tin n??y ?", "Th??ng b??o",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	                if(result == JOptionPane.YES_OPTION){
						String maDiaDiem = (String) tblDiaDiemThamQuan.getValueAt(selectedRow, 0);
						
						diaDiemThamQuanBUS.deleteById(maDiaDiem);
						diaDiemThamQuanTblModel.removeRow(selectedRow);
						}
	                else if(result == JOptionPane.NO_OPTION)
                    {
                        JOptionPane.showMessageDialog(null, "Kh??ng x??a th??ng tin");
                    }
				}
				if(selectedRow<0) {
					JOptionPane.showMessageDialog(cardQuanLyTour, "B???n ch??a ch???n tr?????ng d??? li???u!");
				}
			}			
		});
		btnDiaDiemThamQuan_Xoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDiaDiemThamQuan_Xoa.setBounds(520, 200, 200, 30);;
		cardQuanLyDiaDiemThamQuan.add(btnDiaDiemThamQuan_Xoa);
		
		JButton btnDiaDiemThamQuan_ThemMoi = new JButton("Th??m ?????a di???m");
		btnDiaDiemThamQuan_ThemMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardAddDiaDiemThamQuan");
			}
		});
		btnDiaDiemThamQuan_ThemMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDiaDiemThamQuan_ThemMoi.setBounds(520, 250, 200, 30);
		cardQuanLyDiaDiemThamQuan.add(btnDiaDiemThamQuan_ThemMoi);
		
		btnDiaDiemThamQuan_CapNhat = new JButton("C???p nh???t ?????a ??i???m");
		addActionListenerBtnDiaDiemThamQuan_Update();
		btnDiaDiemThamQuan_CapNhat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDiaDiemThamQuan_CapNhat.setBounds(520, 300, 200, 30);
		cardQuanLyDiaDiemThamQuan.add(btnDiaDiemThamQuan_CapNhat);
		
		JButton btnDiaDiemThamQuan_QuayLai = new JButton("Quay l???i");
		btnDiaDiemThamQuan_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyCTKeHoachTheoNgay");
			}
		});
		btnDiaDiemThamQuan_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDiaDiemThamQuan_QuayLai.setBounds(50, 450, 100, 30);
		cardQuanLyDiaDiemThamQuan.add(btnDiaDiemThamQuan_QuayLai);
		// ===== DIA DIEM THAM QUAN LAYOUT END HERE =====
		
		// ===== ADD DIA DIEM THAM QUAN LAYOUT START HERE =====
		JPanel cardAddDiaDiemThamQuan = new JPanel();
		cardsPane.add(cardAddDiaDiemThamQuan);
		cardAddDiaDiemThamQuan.setLayout(null);
		cardLayout.addLayoutComponent(cardAddDiaDiemThamQuan, "cardAddDiaDiemThamQuan");
		
		JLabel lblAddDiaDiemThamQuan_TieuDe = new JLabel("Trang th??m ?????a ??i???m tham quan");
		lblAddDiaDiemThamQuan_TieuDe.setBounds(0, 0, 500, 100);
		lblAddDiaDiemThamQuan_TieuDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardAddDiaDiemThamQuan.add(lblAddDiaDiemThamQuan_TieuDe);
		
		JLabel lblAddMaDiaDiem = new JLabel("Nh???p m?? ?????a ??i???m:");
		lblAddMaDiaDiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddMaDiaDiem.setBounds(50, 100, 200, 30);
		cardAddDiaDiemThamQuan.add(lblAddMaDiaDiem);
		
		JTextField txtAddMaDiaDiem = new JTextField();
		txtAddMaDiaDiem.setColumns(10);
		txtAddMaDiaDiem.setBounds(250, 100, 300, 30);
		cardAddDiaDiemThamQuan.add(txtAddMaDiaDiem);
		
		JLabel lblAddTenDiaDiem = new JLabel("Nh???p t??n ?????a ??i???m:");
		lblAddTenDiaDiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddTenDiaDiem.setBounds(50, 150, 200, 30);
		cardAddDiaDiemThamQuan.add(lblAddTenDiaDiem);
		
		JTextField txtAddTenDiaDiem = new JTextField();
		txtAddTenDiaDiem.setColumns(10);
		txtAddTenDiaDiem.setBounds(250, 150, 300, 30);
		cardAddDiaDiemThamQuan.add(txtAddTenDiaDiem);
		
		JLabel lblAddDiaDiemThamQuan_DiaChi = new JLabel("Nh???p ?????a ch???:");
		lblAddDiaDiemThamQuan_DiaChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddDiaDiemThamQuan_DiaChi.setBounds(50, 200, 200, 30);
		cardAddDiaDiemThamQuan.add(lblAddDiaDiemThamQuan_DiaChi);
		
		JTextField txtAddDiaDiemThamQuan_DiaChi = new JTextField();
		txtAddDiaDiemThamQuan_DiaChi.setColumns(10);
		txtAddDiaDiemThamQuan_DiaChi.setBounds(250, 200, 300, 30);
		cardAddDiaDiemThamQuan.add(txtAddDiaDiemThamQuan_DiaChi);
		
		JButton btnAddDiaDiemThamQuan_ThemMoi = new JButton("Th??m m???i");
		btnAddDiaDiemThamQuan_ThemMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb=new StringBuilder();
				if(txtAddMaDiaDiem.getText().equals("")){
		            sb.append("*M?? ?????a ??i???m kh??ng ???????c ????? tr???ng\n");
		        }
		    	else 
		        {
		        	for(DiaDiemThamQuanDTO dto: diaDiemThamQuanBUS.listDiaDiemThamQuanDTO){
			            if(txtAddMaDiaDiem.getText().equals(String.valueOf(dto.getMaDiaDiem()))){
			                JOptionPane.showMessageDialog(cardAddDiaDiemThamQuan, "M?? ?????a ??i???m ???? t???n t???i!", "Th??ng b??o", JOptionPane.ERROR_MESSAGE);
			                return;
			            } 
		        	}
		        }
				if(txtAddTenDiaDiem.getText().equals("")) {
		            sb.append("*T??n ?????a ??i???m tham quan kh??ng ???????c ????? tr???ng\n");
		    	}
				if(txtAddDiaDiemThamQuan_DiaChi.getText().equals("")) {
		            sb.append("*?????a ch??? kh??ng ???????c ????? tr???ng\n");
		    	}
				if(sb.length()>0) {
		    		JOptionPane.showMessageDialog(cardAddTaiKhoan, sb.toString(),"Th??ng b??o",JOptionPane.ERROR_MESSAGE);
		    		return;
		    	}
		    	
				DiaDiemThamQuanDTO dto = new DiaDiemThamQuanDTO();
				
				dto.setMaDiaDiem(txtAddMaDiaDiem.getText());
				dto.setTenDiaDiem(txtAddTenDiaDiem.getText());
				dto.setDiaChi(txtAddDiaDiemThamQuan_DiaChi.getText());
				
				diaDiemThamQuanBUS.add(dto);
				DiaDiemThamQuanBUS.listDiaDiemThamQuanDTO.add(dto);
				addRowTblDiaDiemThamQuan(dto);
				cardLayout.show(cardsPane, "cardQuanLyDiaDiemThamQuan");
				// clear all text after add
				txtAddMaDiaDiem.setText("");
				txtAddTenDiaDiem.setText("");
				txtAddDiaDiemThamQuan_DiaChi.setText("");
			}
		});
		btnAddDiaDiemThamQuan_ThemMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddDiaDiemThamQuan_ThemMoi.setBounds(150, 250, 120, 30);
		cardAddDiaDiemThamQuan.add(btnAddDiaDiemThamQuan_ThemMoi);
		
		JButton btnAddDiaDiemThamQuan_QuayLai = new JButton("Quay l???i");
		btnAddDiaDiemThamQuan_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyDiaDiemThamQuan");
			}
		});
		btnAddDiaDiemThamQuan_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddDiaDiemThamQuan_QuayLai.setBounds(300, 250, 120, 30);
		cardAddDiaDiemThamQuan.add(btnAddDiaDiemThamQuan_QuayLai);
		// ===== ADD DIA DIEM THAM QUAN LAYOUT END HERE =====
		
		// ===== UPDATE DIA DIEM THAM QUAN LAYOUT START HERE =====
		JPanel cardUpdateDiaDiemThamQuan = new JPanel();
		cardsPane.add(cardUpdateDiaDiemThamQuan);
		cardUpdateDiaDiemThamQuan.setLayout(null);
		cardLayout.addLayoutComponent(cardUpdateDiaDiemThamQuan, "cardUpdateDiaDiemThamQuan");
		
		JLabel lblUpdateDiaDiemThamQuan_TieuDe = new JLabel("Trang c???p nh???t ?????a ??i???m tham quan");
		lblUpdateDiaDiemThamQuan_TieuDe.setBounds(0, 0, 600, 100);
		lblUpdateDiaDiemThamQuan_TieuDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardUpdateDiaDiemThamQuan.add(lblUpdateDiaDiemThamQuan_TieuDe);
		
		JLabel lblUpdateMaDiaDiem = new JLabel("Nh???p m?? ?????a ??i???m:");
		lblUpdateMaDiaDiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateMaDiaDiem.setBounds(50, 100, 150, 30);
		cardUpdateDiaDiemThamQuan.add(lblUpdateMaDiaDiem);
		
		txtUpdateMaDiaDiem = new JTextField();
		txtUpdateMaDiaDiem.setColumns(10);
		txtUpdateMaDiaDiem.setBounds(200, 100, 300, 30);
		cardUpdateDiaDiemThamQuan.add(txtUpdateMaDiaDiem);
		
		JLabel lblUpdateTenDiaDiem = new JLabel("Nh???p t??n ?????a ??i???m:");
		lblUpdateTenDiaDiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateTenDiaDiem.setBounds(50, 150, 150, 30);
		cardUpdateDiaDiemThamQuan.add(lblUpdateTenDiaDiem);
		
		txtUpdateTenDiaDiem = new JTextField();
		txtUpdateTenDiaDiem.setColumns(10);
		txtUpdateTenDiaDiem.setBounds(200, 150, 300, 30);
		cardUpdateDiaDiemThamQuan.add(txtUpdateTenDiaDiem);
		
		JLabel lblUpdateDiaDiemThamQuan_DiaChi = new JLabel("Nh???p ?????a ch???:");
		lblUpdateDiaDiemThamQuan_DiaChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateDiaDiemThamQuan_DiaChi.setBounds(50, 200, 150, 30);
		cardUpdateDiaDiemThamQuan.add(lblUpdateDiaDiemThamQuan_DiaChi);
		
		txtUpdateDiaDiemThamQuan_DiaChi = new JTextField();
		txtUpdateDiaDiemThamQuan_DiaChi.setColumns(10);
		txtUpdateDiaDiemThamQuan_DiaChi.setBounds(200, 200, 300, 30);
		cardUpdateDiaDiemThamQuan.add(txtUpdateDiaDiemThamQuan_DiaChi);
		
		JButton btnUpdateDiaDiemThamQuan_CapNhat = new JButton("C???p nh???t");
		btnUpdateDiaDiemThamQuan_CapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DiaDiemThamQuanDTO dto = new DiaDiemThamQuanDTO();
				
				dto.setMaDiaDiem(txtUpdateMaDiaDiem.getText());
				dto.setTenDiaDiem(txtUpdateTenDiaDiem.getText());
				dto.setDiaChi(txtUpdateDiaDiemThamQuan_DiaChi.getText());
				
				diaDiemThamQuanBUS.update(dto);
				DiaDiemThamQuanBUS.listDiaDiemThamQuanDTO.set(selectedRow, dto);
				setRow(dto, selectedRow);
				cardLayout.show(cardsPane, "cardQuanLyDiaDiemThamQuan");
				diaDiemThamQuanTblModel.setRowCount(0);
				loadTblDiaDiemThamQuan();
				// clear all text after update
				txtUpdateMaDiaDiem.setText("");
				txtUpdateTenDiaDiem.setText("");
				txtUpdateDiaDiemThamQuan_DiaChi.setText("");
			}
		});
		btnUpdateDiaDiemThamQuan_CapNhat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateDiaDiemThamQuan_CapNhat.setBounds(150, 250, 120, 30);
		cardUpdateDiaDiemThamQuan.add(btnUpdateDiaDiemThamQuan_CapNhat);
		
		JButton btnUpdateDiaDiemThamQuan_QuayLai = new JButton("Quay l???i");
		btnUpdateDiaDiemThamQuan_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyDiaDiemThamQuan");
			}
		});
		btnUpdateDiaDiemThamQuan_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateDiaDiemThamQuan_QuayLai.setBounds(300, 250, 100, 30);
		cardUpdateDiaDiemThamQuan.add(btnUpdateDiaDiemThamQuan_QuayLai);
		// ===== UPDATE DIA DIEM THAM QUAN LAYOUT END HERE =====
		
		// ===== NHA HANG LAYOUT START HERE =====
		JPanel cardQuanLyNhaHang = new JPanel();
		cardsPane.add(cardQuanLyNhaHang, "name_4568411886400");
		cardQuanLyNhaHang.setLayout(null);
		cardLayout.addLayoutComponent(cardQuanLyNhaHang, "cardQuanLyNhaHang");
		
		JLabel lblNhaHang_TieuDe = new JLabel("Trang qu???n l?? nh?? h??ng");
		lblNhaHang_TieuDe.setBounds(0, 0, 600, 100);
		lblNhaHang_TieuDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardQuanLyNhaHang.add(lblNhaHang_TieuDe);
		
		JLabel lblNhaHang_TimKiem = new JLabel("T??m ki???m:");
		lblNhaHang_TimKiem.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNhaHang_TimKiem.setBounds(20, 100, 80, 30);
		cardQuanLyNhaHang.add(lblNhaHang_TimKiem);
		
		JTextField txtNhaHang_TimKiem = new JTextField();
		txtNhaHang_TimKiem.setBounds(100, 100, 200, 30);
		txtNhaHang_TimKiem.setColumns(10);
		cardQuanLyNhaHang.add(txtNhaHang_TimKiem);
		
		JButton btnNhaHang_TimKiem = new JButton("T??m");
		btnNhaHang_TimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhaHangDTO dto =nhaHangBUS.getByMaNhaHang(txtNhaHang_TimKiem.getText());
				nhaHangTblModel.setRowCount(0); // xoa tat ca row
				nhaHangTblModel.addRow(new Object[] {
							dto.getMaNhaHang(), dto.getTenNhaHang(), dto.getDiaChi(),dto.getChiPhiTrenNguoi()});
			}
		});
		btnNhaHang_TimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNhaHang_TimKiem.setBounds(310, 100, 80, 30);
		cardQuanLyNhaHang.add(btnNhaHang_TimKiem);
		
		JScrollPane nhaHangScrollPane = new JScrollPane();
		nhaHangScrollPane.setBounds(50, 150, 600, 273);
		cardQuanLyNhaHang.add(nhaHangScrollPane);
		
		tblNhaHang = new JTable();
		tblNhaHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tblNhaHang.getSelectedRow();
				
			}
		});
		tblNhaHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tblNhaHang.setRowHeight(50);
		String[] colNamesTblNhaHang = {"M?? nh?? h??ng", "T??n nh?? h??ng", "?????a ch???", "Chi ph?? tr??n ng?????i"};
		nhaHangTblModel = new DefaultTableModel();
		tblNhaHang.setModel(nhaHangTblModel);
		for(String colName : colNamesTblNhaHang) {
			nhaHangTblModel.addColumn(colName);
		}
		loadTblNhaHang();
		
		nhaHangScrollPane.setViewportView(tblNhaHang);
		tblNhaHang.setFillsViewportHeight(true);
		
		JButton btnNhaHang_TaiLai = new JButton("T???i l???i b???ng");
		btnNhaHang_TaiLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nhaHangTblModel.setRowCount(0);
				loadTblNhaHang();
			}
		});
		btnNhaHang_TaiLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNhaHang_TaiLai.setBounds(670, 150, 200, 30);
		cardQuanLyNhaHang.add(btnNhaHang_TaiLai);
		
		JButton btnNhaHang_Xoa = new JButton("X??a nh?? h??ng");
		btnNhaHang_Xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tblNhaHang.getSelectedRow();
				if(selectedRow>=0) {
					int result=JOptionPane.showConfirmDialog(null,"B???n c?? ch???c mu???n x??a th??ng tin n??y?","th??ng b??o",JOptionPane.YES_NO_OPTION); 
					if(result==JOptionPane.YES_OPTION) {
					String maDiaDiem = (String) tblNhaHang.getValueAt(selectedRow, 0);
					
					nhaHangBUS.deleteById(maDiaDiem);
					nhaHangTblModel.removeRow(selectedRow);
					}
					else if(result==JOptionPane.NO_OPTION) {
						JOptionPane.showMessageDialog(null,"Th??ng tin n??y ch??a ???????c x??a!");
					}
				}
				if(selectedRow<0 ) {
					JOptionPane.showMessageDialog(cardQuanLyTaiKhoan, "B???n ch??a ch???n tr?????ng d??? li???u n??o c???");
				}
			}
		});
		btnNhaHang_Xoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNhaHang_Xoa.setBounds(670, 200, 200, 30);;
		cardQuanLyNhaHang.add(btnNhaHang_Xoa);
		
		JButton btnNhaHang_ThemMoi = new JButton("Th??m nh?? h??ng");
		btnNhaHang_ThemMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardAddNhaHang");
			}
		});
		btnNhaHang_ThemMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNhaHang_ThemMoi.setBounds(670, 250, 200, 30);
		cardQuanLyNhaHang.add(btnNhaHang_ThemMoi);
		
		btnNhaHang_CapNhat = new JButton("C???p nh???t nh?? h??ng");
		addActionListenerBtnNhaHang_Update();
		btnNhaHang_CapNhat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNhaHang_CapNhat.setBounds(670, 300, 200, 30);
		cardQuanLyNhaHang.add(btnNhaHang_CapNhat);
		
		JButton btnNhaHang_QuayLai = new JButton("Quay l???i");
		btnNhaHang_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyCTKeHoachTheoNgay");
			}
		});
		btnNhaHang_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNhaHang_QuayLai.setBounds(50, 450, 100, 30);
		cardQuanLyNhaHang.add(btnNhaHang_QuayLai);
		// ===== NHA HANG LAYOUT END HERE =====
		
		// ===== ADD NHA HANG LAYOUT START HERE =====
		JPanel cardAddNhaHang = new JPanel();
		cardsPane.add(cardAddNhaHang);
		cardAddNhaHang.setLayout(null);
		cardLayout.addLayoutComponent(cardAddNhaHang, "cardAddNhaHang");
		
		JLabel lblAddNhaHang_TieuDe = new JLabel("Trang th??m nh?? h??ng");
		lblAddNhaHang_TieuDe.setBounds(0, 0, 500, 100);
		lblAddNhaHang_TieuDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardAddNhaHang.add(lblAddNhaHang_TieuDe);
		
		JLabel lblAddMaNhaHang = new JLabel("Nh???p m?? nh?? h??ng:");
		lblAddMaNhaHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddMaNhaHang.setBounds(50, 100, 200, 30);
		cardAddNhaHang.add(lblAddMaNhaHang);
		
		JTextField txtAddMaNhaHang = new JTextField();
		txtAddMaNhaHang.setColumns(10);
		txtAddMaNhaHang.setBounds(250, 100, 300, 30);
		cardAddNhaHang.add(txtAddMaNhaHang);
		
		JLabel lblAddTenNhaHang = new JLabel("Nh???p t??n nh?? h??ng:");
		lblAddTenNhaHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddTenNhaHang.setBounds(50, 150, 200, 30);
		cardAddNhaHang.add(lblAddTenNhaHang);
		
		JTextField txtAddTenNhaHang = new JTextField();
		txtAddTenNhaHang.setColumns(10);
		txtAddTenNhaHang.setBounds(250, 150, 300, 30);
		cardAddNhaHang.add(txtAddTenNhaHang);
		
		JLabel lblAddNhaHang_DiaChi = new JLabel("Nh???p ?????a ch???:");
		lblAddNhaHang_DiaChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddNhaHang_DiaChi.setBounds(50, 200, 200, 30);
		cardAddNhaHang.add(lblAddNhaHang_DiaChi);
		
		JTextField txtAddNhaHang_DiaChi = new JTextField();
		txtAddNhaHang_DiaChi.setColumns(10);
		txtAddNhaHang_DiaChi.setBounds(250, 200, 300, 30);
		cardAddNhaHang.add(txtAddNhaHang_DiaChi);
		
		JLabel lblAddNhaHang_ChiPhiTrenNguoi = new JLabel("Nh???p chi ph?? tr??n ng?????i:");
		lblAddNhaHang_ChiPhiTrenNguoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddNhaHang_ChiPhiTrenNguoi.setBounds(50, 250, 200, 30);
		cardAddNhaHang.add(lblAddNhaHang_ChiPhiTrenNguoi);
		
		JTextField txtAddNhaHang_ChiPhiTrenNguoi = new JTextField();
		txtAddNhaHang_ChiPhiTrenNguoi.setColumns(10);
		txtAddNhaHang_ChiPhiTrenNguoi.setBounds(250, 250, 300, 30);
		cardAddNhaHang.add(txtAddNhaHang_ChiPhiTrenNguoi);
		
		JButton btnAddNhaHang_ThemMoi = new JButton("Th??m m???i");
		btnAddNhaHang_ThemMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb=new StringBuilder();
				if(txtAddMaCTKeHoachTheoNgay.getText().equals("")){
		            sb.append("*M?? nh?? h??ng kh??ng ???????c ????? tr???ng\n");
		        }
		    	else 
		        {
		        	for(NhaHangDTO dto: nhaHangBUS.listNhaHangDTO){
			            if(txtAddMaNhaHang.getText().equals(String.valueOf(dto.getMaNhaHang()))){
			                JOptionPane.showMessageDialog(cardAddNhaHang, "M?? nh?? h??ng ???? t???n t???i!", "Th??ng b??o", JOptionPane.ERROR_MESSAGE);
			                return;
			            } 
		        	}
		        }
				if(txtAddTenNhaHang.getText().equals("")) {
		            sb.append("*T??n nh?? h??ng kh??ng ???????c ????? tr???ng\n");
		    	}
				if(txtAddNhaHang_DiaChi.getText().equals("")) {
		            sb.append("*?????a ch??? kh??ng ???????c ????? tr???ng\n");
		    	}
				if(txtAddNhaHang_ChiPhiTrenNguoi.getText().equals("")) {
		            sb.append("*Chi ph?? kh??ng ???????c ????? tr???ng\n");
		    	}
				if(sb.length()>0) {
		    		JOptionPane.showMessageDialog(cardAddTaiKhoan, sb.toString(),"Th??ng b??o",JOptionPane.ERROR_MESSAGE);
		    		return;
		    	}
		
				NhaHangDTO dto = new NhaHangDTO();
				
				dto.setMaNhaHang(txtAddMaNhaHang.getText());
				dto.setTenNhaHang(txtAddTenNhaHang.getText());
				dto.setDiaChi(txtAddNhaHang_DiaChi.getText());
				dto.setChiPhiTrenNguoi(Double.valueOf(txtAddNhaHang_ChiPhiTrenNguoi.getText()));
				
				nhaHangBUS.add(dto);
				NhaHangBUS.listNhaHangDTO.add(dto);
				addRowTblNhaHang(dto);
				cardLayout.show(cardsPane, "cardQuanLyNhaHang");
				// clear all text after add
				txtAddMaNhaHang.setText("");
				txtAddTenNhaHang.setText("");
				txtAddNhaHang_DiaChi.setText("");
				txtAddNhaHang_ChiPhiTrenNguoi.setText("");
			}
		});
		btnAddNhaHang_ThemMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddNhaHang_ThemMoi.setBounds(150, 300, 120, 30);
		cardAddNhaHang.add(btnAddNhaHang_ThemMoi);
		
		JButton btnAddNhaHang_QuayLai = new JButton("Quay l???i");
		btnAddNhaHang_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyNhaHang");
			}
		});
		btnAddNhaHang_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddNhaHang_QuayLai.setBounds(300, 300, 120, 30);
		cardAddNhaHang.add(btnAddNhaHang_QuayLai);
		// ===== ADD NHA HANG LAYOUT END HERE =====
		
		// ===== UPDATE NHA HANG LAYOUT START HERE =====
		JPanel cardUpdateNhaHang = new JPanel();
		cardsPane.add(cardUpdateNhaHang);
		cardUpdateNhaHang.setLayout(null);
		cardLayout.addLayoutComponent(cardUpdateNhaHang, "cardUpdateNhaHang");
		
		JLabel lblUpdateNhaHang_TieuDe = new JLabel("Trang c???p nh???t nh?? h??ng");
		lblUpdateNhaHang_TieuDe.setBounds(0, 0, 600, 100);
		lblUpdateNhaHang_TieuDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardUpdateNhaHang.add(lblUpdateNhaHang_TieuDe);
		
		JLabel lblUpdateMaNhaHang = new JLabel("Nh???p m?? nh?? h??ng:");
		lblUpdateMaNhaHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateMaNhaHang.setBounds(50, 100, 150, 30);
		cardUpdateNhaHang.add(lblUpdateMaNhaHang);
		
		txtUpdateMaNhaHang = new JTextField();
		txtUpdateMaNhaHang.setColumns(10);
		txtUpdateMaNhaHang.setBounds(200, 100, 300, 30);
		cardUpdateNhaHang.add(txtUpdateMaNhaHang);
		
		JLabel lblUpdateTenNhaHang = new JLabel("Nh???p t??n nh?? h??ng:");
		lblUpdateTenNhaHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateTenNhaHang.setBounds(50, 150, 150, 30);
		cardUpdateNhaHang.add(lblUpdateTenNhaHang);
		
		txtUpdateTenNhaHang = new JTextField();
		txtUpdateTenNhaHang.setColumns(10);
		txtUpdateTenNhaHang.setBounds(200, 150, 300, 30);
		cardUpdateNhaHang.add(txtUpdateTenNhaHang);
		
		JLabel lblUpdateNhaHang_DiaChi = new JLabel("Nh???p ?????a ch???:");
		lblUpdateNhaHang_DiaChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateNhaHang_DiaChi.setBounds(50, 200, 150, 30);
		cardUpdateNhaHang.add(lblUpdateNhaHang_DiaChi);
		
		txtUpdateNhaHang_DiaChi = new JTextField();
		txtUpdateNhaHang_DiaChi.setColumns(10);
		txtUpdateNhaHang_DiaChi.setBounds(200, 200, 300, 30);
		cardUpdateNhaHang.add(txtUpdateNhaHang_DiaChi);
		
		JLabel lblUpdateNhaHang_ChiPhiTrenNguoi = new JLabel("Nh???p chi ph?? tr??n ng?????i:");
		lblUpdateNhaHang_ChiPhiTrenNguoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateNhaHang_ChiPhiTrenNguoi.setBounds(50, 250, 150, 30);
		cardUpdateNhaHang.add(lblUpdateNhaHang_ChiPhiTrenNguoi);
		
		txtUpdateNhaHang_ChiPhiTrenNguoi = new JTextField();
		txtUpdateNhaHang_ChiPhiTrenNguoi.setColumns(10);
		txtUpdateNhaHang_ChiPhiTrenNguoi.setBounds(200, 250, 300, 30);
		cardUpdateNhaHang.add(txtUpdateNhaHang_ChiPhiTrenNguoi);
		
		JButton btnUpdateNhaHang_CapNhat = new JButton("C???p nh???t");
		btnUpdateNhaHang_CapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhaHangDTO dto = new NhaHangDTO();
				
				dto.setMaNhaHang(txtUpdateMaNhaHang.getText());
				dto.setTenNhaHang(txtUpdateTenNhaHang.getText());
				dto.setDiaChi(txtUpdateNhaHang_DiaChi.getText());
				dto.setChiPhiTrenNguoi(Double.valueOf(txtUpdateNhaHang_ChiPhiTrenNguoi.getText()));
				
				nhaHangBUS.update(dto);
				NhaHangBUS.listNhaHangDTO.set(selectedRow, dto);
				setRow(dto, selectedRow);
				cardLayout.show(cardsPane, "cardQuanLyNhaHang");
				nhaHangTblModel.setRowCount(0);
				loadTblNhaHang();
				// clear all text after update
				txtUpdateMaNhaHang.setText("");
				txtUpdateTenNhaHang.setText("");
				txtUpdateNhaHang_DiaChi.setText("");
				txtUpdateNhaHang_ChiPhiTrenNguoi.setText("");
			}
		});
		btnUpdateNhaHang_CapNhat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateNhaHang_CapNhat.setBounds(150, 300, 120, 30);
		cardUpdateNhaHang.add(btnUpdateNhaHang_CapNhat);
		
		JButton btnUpdateNhaHang_QuayLai = new JButton("Quay l???i");
		btnUpdateNhaHang_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyNhaHang");
			}
		});
		btnUpdateNhaHang_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateNhaHang_QuayLai.setBounds(300, 300, 100, 30);
		cardUpdateNhaHang.add(btnUpdateNhaHang_QuayLai);
		// ===== UPDATE NHA HANG LAYOUT END HERE =====
		
		// ===== KHACH SAN LAYOUT START HERE =====
		JPanel cardQuanLyKhachSan = new JPanel();
		cardsPane.add(cardQuanLyKhachSan, "name_4568411886400");
		cardQuanLyKhachSan.setLayout(null);
		cardLayout.addLayoutComponent(cardQuanLyKhachSan, "cardQuanLyKhachSan");
		
		JLabel lblKhachSan_TieuDe = new JLabel("Trang qu???n l?? kh??ch s???n");
		lblKhachSan_TieuDe.setBounds(0, 0, 600, 100);
		lblKhachSan_TieuDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardQuanLyKhachSan.add(lblKhachSan_TieuDe);
		
		JLabel lblKhachSan_TimKiem = new JLabel("T??m ki???m:");
		lblKhachSan_TimKiem.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblKhachSan_TimKiem.setBounds(20, 100, 80, 30);
		cardQuanLyKhachSan.add(lblKhachSan_TimKiem);
		
		JTextField txtKhachSan_TimKiem = new JTextField();
		txtKhachSan_TimKiem.setBounds(100, 100, 200, 30);
		txtKhachSan_TimKiem.setColumns(10);
		cardQuanLyKhachSan.add(txtKhachSan_TimKiem);
		
		JButton btnKhachSan_TimKiem = new JButton("T??m");
		btnKhachSan_TimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KhachSanDTO dto =khachSanBUS.getByMaKhachSan(txtKhachSan_TimKiem.getText());
				
				khachSanTblModel.setRowCount(0); // xoa tat ca row
				
					khachSanTblModel.addRow(new Object[] {
							dto.getMaKhachSan(), dto.getTenKhachSan(), dto.getDiaChi(), dto.getChiPhiTrenNguoi()});
				
			}
		});
		btnKhachSan_TimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKhachSan_TimKiem.setBounds(310, 100, 80, 30);
		cardQuanLyKhachSan.add(btnKhachSan_TimKiem);
		
		JScrollPane khachSanScrollPane = new JScrollPane();
		khachSanScrollPane.setBounds(50, 150, 600, 273);
		cardQuanLyKhachSan.add(khachSanScrollPane);
		
		tblKhachSan = new JTable();
		tblKhachSan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tblKhachSan.getSelectedRow();
				
			}
		});
		tblKhachSan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tblKhachSan.setRowHeight(50);
		String[] colNamesTblKhachSan = {"M?? kh??ch s???n", "T??n kh??ch s???n", "?????a ch???", "Chi ph?? tr??n ng?????i"};
		khachSanTblModel = new DefaultTableModel();
		tblKhachSan.setModel(khachSanTblModel);
		for(String colName : colNamesTblKhachSan) {
			khachSanTblModel.addColumn(colName);
		}
		loadTblKhachSan();
		
		khachSanScrollPane.setViewportView(tblKhachSan);
		tblKhachSan.setFillsViewportHeight(true);
		
		JButton btnKhachSan_TaiLai = new JButton("T???i l???i b???ng");
		btnKhachSan_TaiLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				khachSanTblModel.setRowCount(0);
				loadTblKhachSan();
			}
		});
		btnKhachSan_TaiLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKhachSan_TaiLai.setBounds(670, 150, 200, 30);
		cardQuanLyKhachSan.add(btnKhachSan_TaiLai);
		
		JButton btnKhachSan_Xoa = new JButton("X??a kh??ch s???n");
		btnKhachSan_Xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tblKhachSan.getSelectedRow();
				if(selectedRow>=0) {
					int result = JOptionPane.showConfirmDialog(null,"B???n c?? ch???c mu???n x??a th??ng tin n??y ?", "Th??ng b??o",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	                if(result == JOptionPane.YES_OPTION){
					String maDiaDiem = (String) tblKhachSan.getValueAt(selectedRow, 0);
					
					khachSanBUS.deleteById(maDiaDiem);
					khachSanTblModel.removeRow(selectedRow);
                } 
                else if(result == JOptionPane.NO_OPTION)
	                {
	                    JOptionPane.showMessageDialog(null, "Kh??ng x??a th??ng tin");
	                }
				}
				if(selectedRow<0) {
					JOptionPane.showMessageDialog(cardQuanLyTour, "B???n ch??a ch???n tr?????ng d??? li???u!");
				}
			}
		});
		btnKhachSan_Xoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKhachSan_Xoa.setBounds(670, 200, 200, 30);;
		cardQuanLyKhachSan.add(btnKhachSan_Xoa);
		
		JButton btnKhachSan_ThemMoi = new JButton("Th??m kh??ch s???n");
		btnKhachSan_ThemMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardAddKhachSan");
			}
		});
		btnKhachSan_ThemMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKhachSan_ThemMoi.setBounds(670, 250, 200, 30);
		cardQuanLyKhachSan.add(btnKhachSan_ThemMoi);
		
		btnKhachSan_CapNhat = new JButton("C???p nh???t kh??ch s???n");
		addActionListenerBtnKhachSan_Update();
		btnKhachSan_CapNhat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKhachSan_CapNhat.setBounds(670, 300, 200, 30);
		cardQuanLyKhachSan.add(btnKhachSan_CapNhat);
		
		JButton btnKhachSan_QuayLai = new JButton("Quay l???i");
		btnKhachSan_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyCTKeHoachTheoNgay");
			}
		});
		btnKhachSan_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKhachSan_QuayLai.setBounds(50, 450, 100, 30);
		cardQuanLyKhachSan.add(btnKhachSan_QuayLai);
		// ===== KHACH SAN LAYOUT END HERE ======
		
		// ===== ADD KHACH SAN LAYOUT START HERE =====
		JPanel cardAddKhachSan = new JPanel();
		cardsPane.add(cardAddKhachSan);
		cardAddKhachSan.setLayout(null);
		cardLayout.addLayoutComponent(cardAddKhachSan, "cardAddKhachSan");
		
		JLabel lblAddKhachSan_TieuDe = new JLabel("Trang th??m kh??ch s???n");
		lblAddKhachSan_TieuDe.setBounds(0, 0, 500, 100);
		lblAddKhachSan_TieuDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardAddKhachSan.add(lblAddKhachSan_TieuDe);
		
		JLabel lblAddMaKhachSan = new JLabel("Nh???p m?? kh??ch s???n:");
		lblAddMaKhachSan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddMaKhachSan.setBounds(50, 100, 200, 30);
		cardAddKhachSan.add(lblAddMaKhachSan);
		
		JTextField txtAddMaKhachSan = new JTextField();
		txtAddMaKhachSan.setColumns(10);
		txtAddMaKhachSan.setBounds(250, 100, 300, 30);
		cardAddKhachSan.add(txtAddMaKhachSan);
		
		JLabel lblAddTenKhachSan = new JLabel("Nh???p t??n kh??ch s???n:");
		lblAddTenKhachSan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddTenKhachSan.setBounds(50, 150, 200, 30);
		cardAddKhachSan.add(lblAddTenKhachSan);
		
		JTextField txtAddTenKhachSan = new JTextField();
		txtAddTenKhachSan.setColumns(10);
		txtAddTenKhachSan.setBounds(250, 150, 300, 30);
		cardAddKhachSan.add(txtAddTenKhachSan);
		
		JLabel lblAddKhachSan_DiaChi = new JLabel("Nh???p ?????a ch???:");
		lblAddKhachSan_DiaChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddKhachSan_DiaChi.setBounds(50, 200, 200, 30);
		cardAddKhachSan.add(lblAddKhachSan_DiaChi);
		
		JTextField txtAddKhachSan_DiaChi = new JTextField();
		txtAddKhachSan_DiaChi.setColumns(10);
		txtAddKhachSan_DiaChi.setBounds(250, 200, 300, 30);
		cardAddKhachSan.add(txtAddKhachSan_DiaChi);
		
		JLabel lblAddKhachSan_ChiPhiTrenNguoi = new JLabel("Nh???p chi ph?? tr??n ng?????i:");
		lblAddKhachSan_ChiPhiTrenNguoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddKhachSan_ChiPhiTrenNguoi.setBounds(50, 250, 200, 30);
		cardAddKhachSan.add(lblAddKhachSan_ChiPhiTrenNguoi);
		
		JTextField txtAddKhachSan_ChiPhiTrenNguoi = new JTextField();
		txtAddKhachSan_ChiPhiTrenNguoi.setColumns(10);
		txtAddKhachSan_ChiPhiTrenNguoi.setBounds(250, 250, 300, 30);
		cardAddKhachSan.add(txtAddKhachSan_ChiPhiTrenNguoi);
		
		JButton btnAddKhachSan_ThemMoi = new JButton("Th??m m???i");
		btnAddKhachSan_ThemMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KhachSanDTO dto = new KhachSanDTO();
				
				dto.setMaKhachSan(txtAddMaKhachSan.getText());
				dto.setTenKhachSan(txtAddTenKhachSan.getText());
				dto.setDiaChi(txtAddKhachSan_DiaChi.getText());
				dto.setChiPhiTrenNguoi(Double.valueOf(txtAddKhachSan_ChiPhiTrenNguoi.getText()));
				
				khachSanBUS.add(dto);
				KhachSanBUS.listKhachSanDTO.add(dto);
				addRowTblKhachSan(dto);
				cardLayout.show(cardsPane, "cardQuanLyKhachSan");
				// clear all text after add
				txtAddMaKhachSan.setText("");
				txtAddTenKhachSan.setText("");
				txtAddKhachSan_DiaChi.setText("");
				txtAddKhachSan_ChiPhiTrenNguoi.setText("");
			}
		});
		btnAddKhachSan_ThemMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddKhachSan_ThemMoi.setBounds(150, 300, 120, 30);
		cardAddKhachSan.add(btnAddKhachSan_ThemMoi);
		
		JButton btnAddKhachSan_QuayLai = new JButton("Quay l???i");
		btnAddKhachSan_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyKhachSan");
			}
		});
		btnAddKhachSan_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddKhachSan_QuayLai.setBounds(300, 300, 120, 30);
		cardAddKhachSan.add(btnAddKhachSan_QuayLai);
		// ===== ADD KHACH SAN LAYOUT END HERE =====
		
		// ===== UPDATE KHACH SAN LAYOUT START HERE =====
		JPanel cardUpdateKhachSan = new JPanel();
		cardsPane.add(cardUpdateKhachSan);
		cardUpdateKhachSan.setLayout(null);
		cardLayout.addLayoutComponent(cardUpdateKhachSan, "cardUpdateKhachSan");
		
		JLabel lblUpdateKhachSan_TieuDe = new JLabel("Trang c???p nh???t nh?? h??ng");
		lblUpdateKhachSan_TieuDe.setBounds(0, 0, 600, 100);
		lblUpdateKhachSan_TieuDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardUpdateKhachSan.add(lblUpdateKhachSan_TieuDe);
		
		JLabel lblUpdateMaKhachSan = new JLabel("Nh???p m?? kh??ch s???n:");
		lblUpdateMaKhachSan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateMaKhachSan.setBounds(50, 100, 150, 30);
		cardUpdateKhachSan.add(lblUpdateMaKhachSan);
		
		txtUpdateMaKhachSan = new JTextField();
		txtUpdateMaKhachSan.setColumns(10);
		txtUpdateMaKhachSan.setBounds(200, 100, 300, 30);
		cardUpdateKhachSan.add(txtUpdateMaKhachSan);
		
		JLabel lblUpdateTenKhachSan = new JLabel("Nh???p t??n kh??ch s???n:");
		lblUpdateTenKhachSan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateTenKhachSan.setBounds(50, 150, 150, 30);
		cardUpdateKhachSan.add(lblUpdateTenKhachSan);
		
		txtUpdateTenKhachSan = new JTextField();
		txtUpdateTenKhachSan.setColumns(10);
		txtUpdateTenKhachSan.setBounds(200, 150, 300, 30);
		cardUpdateKhachSan.add(txtUpdateTenKhachSan);
		
		JLabel lblUpdateKhachSan_DiaChi = new JLabel("Nh???p ?????a ch???:");
		lblUpdateKhachSan_DiaChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateKhachSan_DiaChi.setBounds(50, 200, 150, 30);
		cardUpdateKhachSan.add(lblUpdateKhachSan_DiaChi);
		
		txtUpdateKhachSan_DiaChi = new JTextField();
		txtUpdateKhachSan_DiaChi.setColumns(10);
		txtUpdateKhachSan_DiaChi.setBounds(200, 200, 300, 30);
		cardUpdateKhachSan.add(txtUpdateKhachSan_DiaChi);
		
		JLabel lblUpdateKhachSan_ChiPhiTrenNguoi = new JLabel("Nh???p chi ph?? tr??n ng?????i:");
		lblUpdateKhachSan_ChiPhiTrenNguoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateKhachSan_ChiPhiTrenNguoi.setBounds(50, 250, 150, 30);
		cardUpdateKhachSan.add(lblUpdateKhachSan_ChiPhiTrenNguoi);
		
		txtUpdateKhachSan_ChiPhiTrenNguoi = new JTextField();
		txtUpdateKhachSan_ChiPhiTrenNguoi.setColumns(10);
		txtUpdateKhachSan_ChiPhiTrenNguoi.setBounds(200, 250, 300, 30);
		cardUpdateKhachSan.add(txtUpdateKhachSan_ChiPhiTrenNguoi);
		
		JButton btnUpdateKhachSan_CapNhat = new JButton("C???p nh???t");
		btnUpdateKhachSan_CapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KhachSanDTO dto = new KhachSanDTO();
				
				dto.setMaKhachSan(txtUpdateMaKhachSan.getText());
				dto.setTenKhachSan(txtUpdateTenKhachSan.getText());
				dto.setDiaChi(txtUpdateKhachSan_DiaChi.getText());
				dto.setChiPhiTrenNguoi(Double.valueOf(txtUpdateKhachSan_ChiPhiTrenNguoi.getText()));
				
				khachSanBUS.update(dto);
				KhachSanBUS.listKhachSanDTO.set(selectedRow, dto);
				setRow(dto, selectedRow);
				cardLayout.show(cardsPane, "cardQuanLyKhachSan");
				khachSanTblModel.setRowCount(0);
				loadTblKhachSan();
				// clear all text after update
				txtUpdateMaKhachSan.setText("");
				txtUpdateTenKhachSan.setText("");
				txtUpdateKhachSan_DiaChi.setText("");
				txtUpdateKhachSan_ChiPhiTrenNguoi.setText("");
			}
		});
		btnUpdateKhachSan_CapNhat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateKhachSan_CapNhat.setBounds(150, 300, 120, 30);
		cardUpdateKhachSan.add(btnUpdateKhachSan_CapNhat);
		
		JButton btnUpdateKhachSan_QuayLai = new JButton("Quay l???i");
		btnUpdateKhachSan_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyKhachSan");
			}
		});
		btnUpdateKhachSan_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateKhachSan_QuayLai.setBounds(300, 300, 100, 30);
		cardUpdateKhachSan.add(btnUpdateKhachSan_QuayLai);
		// ===== UPDATE KHACH SAN LAYOUT END HERE =====
	}

	public void loadTblTaiKhoan() {
		for(TaiKhoanDTO taiKhoan : TaiKhoanBUS.listTaiKhoanDTO) {
			System.out.println(taiKhoan.getTenTK());
			String tenQuyen = null;
			if(taiKhoan.getQuyen() == 0) {
				tenQuyen = "Qu???n tr??? vi??n";
			}
			else if(taiKhoan.getQuyen() == 1) {
				tenQuyen = "Nh??n vi??n";
			}
			taiKhoanTblModel.addRow(new Object[] {
					taiKhoan.getTenTK(), taiKhoan.getMatKhau(), tenQuyen
			});
		}
	}
	
	public void loadTblTour() {
		for(TourDTO tour : TourBUS.listTourDTO) {
			tourTblModel.addRow(new Object[] {
					tour.getMaTour(), tour.getTenTour(), tour.getGiaVe(), tour.getDiemKhoiHanh(), tour.getDiemDen()
			});
		}
	}
	
	public void loadTblHdv() {
		for(HuongDanVienDTO hdv : HuongDanVienBUS.listHuongDanVienDTO) {
			hdvTblModel.addRow(new Object[] {
					hdv.getMaHDV(), hdv.getHoTen(), hdv.getNgaySinh(), hdv.getGioiTinh(), hdv.getDiaChi(), hdv.getSdt()
			});
		}
	}
	
	public void loadTblKhachHang() {
		for(KhachHangDTO kh : KhachHangBUS.listKhachHangDTO) {
			khachHangTblModel.addRow(new Object[] {
					kh.getMaKH(), kh.getHoTenKH(), kh.getDiaChi(), kh.getSdt(), kh.getMaDoan()
			});
		}
	}
	
	public void loadTblHopDong() {
		for(HopDongDTO hd : HopDongBUS.listHopDongDTO) {
			hopDongTblModel.addRow(new Object[] {
					hd.getMaHD(), hd.getNgayLapHD(), hd.getNoiDung(), hd.getMaTour()
			});
		}
	}
	
	public void loadTblDoan() {
		for(DoanDTO doan : DoanBUS.listDoanDTO) {
			doanTblModel.addRow(new Object[] {
					doan.getMaDoan(), doan.getSoNguoi(), doan.getMaTour(), doan.getMaHDV()
			});
		}
	}
	
	public void loadTblKeHoachTour() {
		for(KeHoachTourDTO khTour : KeHoachTourBUS.listKeHoachTourDTO) {
			keHoachTourTblModel.addRow(new Object[] {
					khTour.getMaKeHoach(), khTour.getNgayBatDau(), khTour.getNgayKetThuc(), khTour.getMaTour()
			});
		}
	}
	
	public void loadTblCTKeHoachTheoNgay() {
		for(CTKeHoachTheoNgayDTO ctkh : CTKeHoachTheoNgayBUS.listCTKeHoachTheoNgayDTO) {
			ctKeHoachTheoNgayTblModel.addRow(new Object[] {
					ctkh.getMaCTKHTheoNgay(), ctkh.getNgay(), ctkh.getMaKHTour(), ctkh.getMaDiaDiemThamQuan(), ctkh.getMaPhuongTien(), ctkh.getMaNhaHang(), ctkh.getMaKhachSan()
			});
		}
	}
	
	public void loadTblDiaDiemThamQuan() {
		for(DiaDiemThamQuanDTO dd : DiaDiemThamQuanBUS.listDiaDiemThamQuanDTO) {
			diaDiemThamQuanTblModel.addRow(new Object[] {
					dd.getMaDiaDiem(), dd.getTenDiaDiem(), dd.getDiaChi()
			});
		}
	}
	
	public void loadTblPhuongTien() {
		for(PhuongTienDTO pt : PhuongTienBUS.listPhuongTienDTO) {
			phuongTienTblModel.addRow(new Object[] {
					pt.getMaPhuongTien(), pt.getTenPhuongTien(), pt.getChiPhi(), pt.getSoChoNgoi()
			});
		}
	}
	
	public void loadTblNhaHang() {
		for(NhaHangDTO nh : NhaHangBUS.listNhaHangDTO) {
			nhaHangTblModel.addRow(new Object[] {
					nh.getMaNhaHang(), nh.getTenNhaHang(), nh.getDiaChi(), nh.getChiPhiTrenNguoi()
			});
		}
	}
	
	public void loadTblKhachSan() {
		for(KhachSanDTO ks : KhachSanBUS.listKhachSanDTO) {
			khachSanTblModel.addRow(new Object[] {
					ks.getMaKhachSan(), ks.getTenKhachSan(), ks.getDiaChi(), ks.getChiPhiTrenNguoi()
			});
		}
	}
	
	public void reloadTblTour_HopDong(HopDongDTO hd) {
		if(tour_hopDongTblModel.getRowCount() > 0) {
			tour_hopDongTblModel.setRowCount(0);
		}
		tour_hopDongTblModel.addRow(new Object[] {
				hd.getMaHD(), hd.getNgayLapHD(), hd.getNoiDung(), hd.getMaTour()
		});
	}
	
	public void reloadTblTour_Doan(DoanDTO doan) {
		if(tour_doanTblModel.getRowCount() > 0) {
			tour_doanTblModel.setRowCount(0);
		}
		tour_doanTblModel.addRow(new Object[] {
				doan.getMaDoan(), doan.getSoNguoi(), doan.getMaTour(),doan.getMaHDV()
		});
	}
	
	public void reloadTblTour_KeHoachTour(KeHoachTourDTO keHoach) {
		if(tour_keHoachTourTblModel.getRowCount() > 0) {
			tour_keHoachTourTblModel.setRowCount(0);
		}
		tour_keHoachTourTblModel.addRow(new Object[] {
				keHoach.getMaKeHoach(), keHoach.getNgayBatDau(), keHoach.getNgayKetThuc(), keHoach.getMaTour()
		});
	}
	
	public void reloadTblKeHoachTour_CTKeHoachTheoNgay(CTKeHoachTheoNgayDTO ctkh) {
		if(keHoachTour_ctKeHoachTheoNgayTblModel.getRowCount() > 0) {
			keHoachTour_ctKeHoachTheoNgayTblModel.setRowCount(0);
		}
		keHoachTour_ctKeHoachTheoNgayTblModel.addRow(new Object[] {
				ctkh.getMaCTKHTheoNgay(), ctkh.getNgay(), ctkh.getMaKHTour(), ctkh.getMaDiaDiemThamQuan(), ctkh.getMaPhuongTien(), ctkh.getMaNhaHang(), ctkh.getMaKhachSan()
		});
	}
	
	public void addRow(TaiKhoanDTO dto) {
		Vector<String> rowData = new Vector<String>();
		String tenQuyen = null;
		if(dto.getQuyen() == 0) {
			tenQuyen = "Qu???n tr??? vi??n";
		}
		else if(dto.getQuyen() == 1) {
			tenQuyen = "Nh??n vi??n";
		}
		
		rowData.add(dto.getTenTK());
		rowData.add(dto.getMatKhau());
		rowData.add(tenQuyen);
		
		taiKhoanTblModel.addRow(rowData);
	}
	
	public void addRow(TourDTO dto) {
		Vector<String> rowData = new Vector<String>();
		
		rowData.add(dto.getMaTour());
		rowData.add(dto.getTenTour());
		rowData.add(String.valueOf(dto.getGiaVe()));
		rowData.add(dto.getDiemKhoiHanh());
		rowData.add(dto.getDiemDen());
		
		tourTblModel.addRow(rowData);
	}
	
	private void addRow(KhachHangDTO dto) {
		Vector<String> rowData = new Vector<String>();

		rowData.add(dto.getMaKH());
		rowData.add(dto.getHoTenKH());
		rowData.add(dto.getDiaChi());
		rowData.add(dto.getSdt());
		rowData.add(dto.getMaDoan());
		
		khachHangTblModel.addRow(rowData);
	}
	
	private void addRow(HuongDanVienDTO dto) {
		Vector<String> rowData = new Vector<String>();
		
		rowData.add(dto.getMaHDV());
		rowData.add(dto.getHoTen());
		rowData.add(dto.getNgaySinh());
		rowData.add(dto.getGioiTinh());
		rowData.add(dto.getDiaChi());
		rowData.add(dto.getSdt());
		
		hdvTblModel.addRow(rowData);
	}
	
	private void addRowTblHopDong(HopDongDTO dto) {
		Vector<String> rowData = new Vector<String>();
		
		rowData.add(dto.getMaHD());
		rowData.add(dto.getNgayLapHD());
		rowData.add(dto.getNoiDung());
		rowData.add(dto.getMaTour());
		
		hopDongTblModel.addRow(rowData);
	}
	
	private void addRowTblDoan(DoanDTO dto) {
		Vector<String> rowData = new Vector<String>();
		
		rowData.add(dto.getMaDoan());
		rowData.add(String.valueOf(dto.getSoNguoi()));
		rowData.add(dto.getMaTour());
		rowData.add(dto.getMaHDV());
		
		doanTblModel.addRow(rowData);
	}
	
	private void addRowTblKeHoachTour(KeHoachTourDTO dto) {
		Vector<String> rowData = new Vector<String>();
		
		rowData.add(dto.getMaKeHoach());
		rowData.add(dto.getNgayBatDau());
		rowData.add(dto.getNgayKetThuc());
		rowData.add(dto.getMaTour());
		
		keHoachTourTblModel.addRow(rowData);
	}
	
	private void addRowTblDiaDiemThamQuan(DiaDiemThamQuanDTO dto) {
		Vector<String> rowData = new Vector<String>();
		
		rowData.add(dto.getMaDiaDiem());
		rowData.add(dto.getTenDiaDiem());
		rowData.add(dto.getDiaChi());
		
		diaDiemThamQuanTblModel.addRow(rowData);
	}
	
	private void addRowTblPhuongTien(PhuongTienDTO dto) {
		Vector<String> rowData = new Vector<String>();
		
		rowData.add(dto.getMaPhuongTien());
		rowData.add(dto.getTenPhuongTien());
		rowData.add(String.valueOf(dto.getChiPhi()));
		rowData.add(String.valueOf(dto.getSoChoNgoi()));
		
		phuongTienTblModel.addRow(rowData);
	}
	
	private void addRowTblNhaHang(NhaHangDTO dto) {
		Vector<String> rowData = new Vector<String>();
		
		rowData.add(dto.getMaNhaHang());
		rowData.add(dto.getTenNhaHang());
		rowData.add(dto.getDiaChi());
		rowData.add(String.valueOf(dto.getChiPhiTrenNguoi()));
		
		nhaHangTblModel.addRow(rowData);
	}
	
	private void addRowTblKhachSan(KhachSanDTO dto) {
		Vector<String> rowData = new Vector<String>();
		
		rowData.add(dto.getMaKhachSan());
		rowData.add(dto.getTenKhachSan());
		rowData.add(dto.getDiaChi());
		rowData.add(String.valueOf(dto.getChiPhiTrenNguoi()));
		
		khachSanTblModel.addRow(rowData);
	}
	
	private void addRowTblTour_HopDong(HopDongDTO dto) {
		Vector<String> rowData = new Vector<String>();
		
		rowData.add(dto.getMaHD());
		rowData.add(dto.getNgayLapHD());
		rowData.add(dto.getNoiDung());
		rowData.add(dto.getMaTour());
		
		
		tour_hopDongTblModel.addRow(rowData);
	}
	
	private void addRowTblTour_Doan(DoanDTO dto) {
		Vector<String> rowData = new Vector<String>();
		
		rowData.add(dto.getMaDoan());
		rowData.add(String.valueOf(dto.getSoNguoi()));
		rowData.add(dto.getMaTour());
		rowData.add(dto.getMaHDV());
		
		tour_doanTblModel.addRow(rowData);
	}
	
	private void addRowTblTour_KeHoachTour(KeHoachTourDTO dto) {
		Vector<String> rowData = new Vector<String>();
		
		rowData.add(dto.getMaKeHoach());
		rowData.add(dto.getNgayBatDau());
		rowData.add(dto.getNgayKetThuc());
		rowData.add(dto.getMaTour());
		
		tour_keHoachTourTblModel.addRow(rowData);
	}
	
	private void addRowTblKeHoachTour_CTKeHoachTheoNgay(CTKeHoachTheoNgayDTO dto) {
		Vector<String> rowData = new Vector<String>();
		
		rowData.add(dto.getMaCTKHTheoNgay());
		rowData.add(dto.getNgay());
		rowData.add(dto.getMaKHTour());
		rowData.add(dto.getMaDiaDiemThamQuan());
		rowData.add(dto.getMaPhuongTien());
		rowData.add(dto.getMaNhaHang());
		rowData.add(dto.getMaKhachSan());
		
		keHoachTour_ctKeHoachTheoNgayTblModel.addRow(rowData);
	}
	
	private void addRowTblCTKeHoachTheoNgay_DiaDiemThamQuan(DiaDiemThamQuanDTO dto) {
		Vector<String> rowData = new Vector<String>();
		
		rowData.add(dto.getMaDiaDiem());
		rowData.add(dto.getTenDiaDiem());
		rowData.add(dto.getDiaChi());
		
		ctKeHoachTheoNgay_diaDiemThamQuanTblModel.addRow(rowData);
	}
	
	private void addRowTblCTKeHoachTheoNgay_PhuongTien(PhuongTienDTO dto) {
		Vector<String> rowData = new Vector<String>();
		
		rowData.add(dto.getMaPhuongTien());
		rowData.add(dto.getTenPhuongTien());
		rowData.add(String.valueOf(dto.getChiPhi()));
		rowData.add(String.valueOf(dto.getSoChoNgoi()));
		
		ctKeHoachTheoNgay_phuongTienTblModel.addRow(rowData);
	}
	
	private void addRowTblCTKeHoachTheoNgay_NhaHang(NhaHangDTO dto) {
		Vector<String> rowData = new Vector<String>();
		
		rowData.add(dto.getMaNhaHang());
		rowData.add(dto.getTenNhaHang());
		rowData.add(dto.getDiaChi());
		rowData.add(String.valueOf(dto.getChiPhiTrenNguoi()));
		
		ctKeHoachTheoNgay_nhaHangTblModel.addRow(rowData);
	}
	
	private void addRowTblCTKeHoachTheoNgay_KhachSan(KhachSanDTO dto) {
		Vector<String> rowData = new Vector<String>();
		
		rowData.add(dto.getMaKhachSan());
		rowData.add(dto.getTenKhachSan());
		rowData.add(dto.getDiaChi());
		rowData.add(String.valueOf(dto.getChiPhiTrenNguoi()));
		
		ctKeHoachTheoNgay_khachSanTblModel.addRow(rowData);
	}
	
	public void setRow(TaiKhoanDTO dto, int selectedRow) {
		String tenQuyen = null;
		if(dto.getQuyen() == 0) {
			tenQuyen = "Qu???n tr??? vi??n";
		}
		else if(dto.getQuyen() == 1) {
			tenQuyen = "Nh??n vi??n";
		}
		taiKhoanTblModel.setValueAt(dto.getTenTK(), selectedRow, 0);
		taiKhoanTblModel.setValueAt(dto.getMatKhau(), selectedRow, 1);
		taiKhoanTblModel.setValueAt(tenQuyen, selectedRow, 2);
	}
	
	public void setRow(TourDTO dto, int selectedRow) {
		tourTblModel.setValueAt(dto.getMaTour(), selectedRow, 0);
		tourTblModel.setValueAt(dto.getTenTour(), selectedRow, 1);
		tourTblModel.setValueAt(dto.getGiaVe(), selectedRow, 2);
		tourTblModel.setValueAt(dto.getDiemKhoiHanh(), selectedRow, 3);
		tourTblModel.setValueAt(dto.getDiemDen(), selectedRow, 4);
	}
	
	private void setRow(KhachHangDTO dto, int selectedRow) {
		khachHangTblModel.setValueAt(dto.getMaKH(), selectedRow, 0);
		khachHangTblModel.setValueAt(dto.getHoTenKH(), selectedRow, 1);
		khachHangTblModel.setValueAt(dto.getDiaChi(), selectedRow, 2);
		khachHangTblModel.setValueAt(dto.getSdt(), selectedRow, 3);
		khachHangTblModel.setValueAt(dto.getMaDoan(), selectedRow, 4);
	}
	
	private void setRow(HuongDanVienDTO dto, int selectedRow) {
		hdvTblModel.setValueAt(dto.getMaHDV(), selectedRow, 0);
		hdvTblModel.setValueAt(dto.getHoTen(), selectedRow, 1);
		hdvTblModel.setValueAt(dto.getNgaySinh(), selectedRow, 2);
		hdvTblModel.setValueAt(dto.getGioiTinh(), selectedRow, 3);
		hdvTblModel.setValueAt(dto.getDiaChi(), selectedRow, 4);
		hdvTblModel.setValueAt(dto.getSdt(), selectedRow, 5);
	}
	
	private void setRow(HopDongDTO dto, int selectedRow) {
		hopDongTblModel.setValueAt(dto.getMaHD(), selectedRow, 0);
		hopDongTblModel.setValueAt(dto.getNgayLapHD(), selectedRow, 1);
		hopDongTblModel.setValueAt(dto.getNoiDung(), selectedRow, 2);
		hopDongTblModel.setValueAt(dto.getMaTour(), selectedRow, 3);
	}
	
	private void setRow(DoanDTO dto, int selectedRow) {
		doanTblModel.setValueAt(dto.getMaDoan(), selectedRow, 0);
		doanTblModel.setValueAt(dto.getSoNguoi(), selectedRow, 1);
		doanTblModel.setValueAt(dto.getMaTour(), selectedRow, 2);
		doanTblModel.setValueAt(dto.getMaHDV(), selectedRow, 3);
	}
	
	private void setRow(KeHoachTourDTO dto, int selectedRow) {
		keHoachTourTblModel.setValueAt(dto.getMaKeHoach(), selectedRow, 0);
		keHoachTourTblModel.setValueAt(dto.getNgayBatDau(), selectedRow, 1);
		keHoachTourTblModel.setValueAt(dto.getNgayKetThuc(), selectedRow, 2);
		keHoachTourTblModel.setValueAt(dto.getMaTour(), selectedRow, 3);
	}
	
	private void setRow(CTKeHoachTheoNgayDTO dto, int selectedRow) {
		keHoachTour_ctKeHoachTheoNgayTblModel.setValueAt(dto.getMaCTKHTheoNgay(), selectedRow, 0);
		keHoachTour_ctKeHoachTheoNgayTblModel.setValueAt(dto.getNgay(), selectedRow, 1);
		keHoachTour_ctKeHoachTheoNgayTblModel.setValueAt(dto.getMaKHTour(), selectedRow, 2);
		keHoachTour_ctKeHoachTheoNgayTblModel.setValueAt(dto.getMaDiaDiemThamQuan(), selectedRow, 3);
		keHoachTour_ctKeHoachTheoNgayTblModel.setValueAt(dto.getMaPhuongTien(), selectedRow, 4);
		keHoachTour_ctKeHoachTheoNgayTblModel.setValueAt(dto.getMaNhaHang(), selectedRow, 5);
		keHoachTour_ctKeHoachTheoNgayTblModel.setValueAt(dto.getMaKhachSan(), selectedRow, 6);
	}
	
	private void setRow(DiaDiemThamQuanDTO dto, int selectedRow) {
		diaDiemThamQuanTblModel.setValueAt(dto.getMaDiaDiem(), selectedRow, 0);
		diaDiemThamQuanTblModel.setValueAt(dto.getTenDiaDiem(), selectedRow, 1);
		diaDiemThamQuanTblModel.setValueAt(dto.getDiaChi(), selectedRow, 2);
	}
	
	private void setRow(PhuongTienDTO dto, int selectedRow) {
		phuongTienTblModel.setValueAt(dto.getMaPhuongTien(), selectedRow, 0);
		phuongTienTblModel.setValueAt(dto.getTenPhuongTien(), selectedRow, 1);
		phuongTienTblModel.setValueAt(dto.getChiPhi(), selectedRow, 2);
		phuongTienTblModel.setValueAt(dto.getSoChoNgoi(), selectedRow, 3);
	}
	
	private void setRow(NhaHangDTO dto, int selectedRow) {
		nhaHangTblModel.setValueAt(dto.getMaNhaHang(), selectedRow, 0);
		nhaHangTblModel.setValueAt(dto.getTenNhaHang(), selectedRow, 1);
		nhaHangTblModel.setValueAt(dto.getDiaChi(), selectedRow, 2);
		nhaHangTblModel.setValueAt(dto.getChiPhiTrenNguoi(), selectedRow, 3);
	}
	
	private void setRow(KhachSanDTO dto, int selectedRow) {
		khachSanTblModel.setValueAt(dto.getMaKhachSan(), selectedRow, 0);
		khachSanTblModel.setValueAt(dto.getTenKhachSan(), selectedRow, 1);
		khachSanTblModel.setValueAt(dto.getDiaChi(), selectedRow, 2);
		khachSanTblModel.setValueAt(dto.getChiPhiTrenNguoi(), selectedRow, 3);
	}
    
    private void addActionListenerBtnTaiKhoan_Update() {
		btnTaiKhoan_Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tblTaiKhoan.getSelectedRow();
				if(selectedRow>=0) {
					cardLayout.show(cardsPane, "cardUpdateTaiKhoan");
					
					
					String quyen = (String) tblTaiKhoan.getValueAt(selectedRow, 2);
					txtUpdateTenTaiKhoan.setText((String) tblTaiKhoan.getValueAt(selectedRow, 0));
					txtUpdateMatKhau.setText((String) tblTaiKhoan.getValueAt(selectedRow, 1));
					if(quyen.equals("Qu???n tr??? vi??n")) {
						rBtnUpdateQuanTriVien.setSelected(true);
					}	
					else if(quyen.equals("Nh??n vi??n")) {
						rBtnUpdateNhanVien.setSelected(true);
					}
				}
				else if(selectedRow<0) {
					JOptionPane.showMessageDialog(null, "B???n ch??a ch???n tr?????ng d??? li???u!");
				}
			}
		});
    }
    
    private void addActionListenerBtnTour_Update() {
		btnTour_Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardUpdateTour");
				selectedRow = tblTour.getSelectedRow();
				
				txtUpdateMaTour.setText((String) tblTour.getValueAt(selectedRow, 0));
				txtUpdateTenTour.setText((String) tblTour.getValueAt(selectedRow, 1));
				txtUpdateGiaVe.setText(String.valueOf(tblTour.getValueAt(selectedRow, 2)));
				txtUpdateDiemKhoiHanh.setText((String) tblTour.getValueAt(selectedRow, 3));
				txtUpdateDiemDen.setText((String) tblTour.getValueAt(selectedRow, 4));
			}
		});
    }
    
    private void addActionListenerBtnKhachHang_Update() {
		btnKhachHang_CapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tblKhachHang.getSelectedRow();
				if(selectedRow>=0) {
					cardLayout.show(cardsPane, "cardUpdateKhachHang");
					txtUpdateMaKhachHang.setText((String) tblKhachHang.getValueAt(selectedRow, 0));
					txtUpdateHoTenKhachHang.setText((String) tblKhachHang.getValueAt(selectedRow, 1));
					txtUpdateDiaChiKhachHang.setText((String) tblKhachHang.getValueAt(selectedRow, 2));
					txtUpdateSdtKhachHang.setText((String) tblKhachHang.getValueAt(selectedRow, 3));
					txtUpdateMaDoanKhachHang.setText((String) tblKhachHang.getValueAt(selectedRow, 4));
				}
				else if(selectedRow<0) {
					JOptionPane.showMessageDialog(null, "B???n ch??a ch???n d??? li???u n??o c???!");
				}
			}
		});
    }
    
    private void addActionListenerBtnHopDong_CapNhat() {
		btnHopDong_CapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tblHopDong.getSelectedRow();
				if(selectedRow>=0) {
				cardLayout.show(cardsPane, "cardUpdateHopDong");

				txtUpdateMaHD.setText((String) tblHopDong.getValueAt(selectedRow, 0));
				txtUpdateNgayLapHD.setText((String) tblHopDong.getValueAt(selectedRow, 1));
				txtUpdateNoiDungHD.setText((String) tblHopDong.getValueAt(selectedRow, 2));
				txtUpdateHD_MaTour.setText((String) tblHopDong.getValueAt(selectedRow, 3));
				}
				else if(selectedRow<0) {
					JOptionPane.showMessageDialog(null,"B???n ch??a ch???n tr?????ng d??? li???u!");
				}
			}
		});
    }
    
    private void addActionListenerBtnDoan_CapNhat() {
		btnDoan_CapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tblDoan.getSelectedRow();
				if(selectedRow>=0) {
					cardLayout.show(cardsPane, "cardUpdateDoan");
					txtUpdateMaDoan.setText((String) tblDoan.getValueAt(selectedRow, 0));
					txtUpdateSoNguoi.setText(String.valueOf(tblDoan.getValueAt(selectedRow, 1)));
					txtUpdateDoan_MaTour.setText((String) tblDoan.getValueAt(selectedRow, 2));
					txtUpdateDoan_MaHDV.setText((String) tblDoan.getValueAt(selectedRow, 3));
					
					}
				else if(selectedRow<0) {
					JOptionPane.showMessageDialog(null,"B???n ch??a ch???n tr?????ng d??? li???u!");
				}
			}
		});
    }
    
    private void addActionListenerBtnKeHoachTour_CapNhat() {
    	btnKeHoachTour_CapNhat.addActionListener(new ActionListener() {
    		public  void actionPerformed(ActionEvent e) {
    			cardLayout.show(cardsPane, "cardUpdateKeHoachTour");
    			selectedRow = tblKeHoachTour.getSelectedRow();
    			
    			txtUpdateMaKeHoach.setText((String) tblKeHoachTour.getValueAt(selectedRow, 0));
    			txtUpdateNgayBatDau.setText((String) tblKeHoachTour.getValueAt(selectedRow, 1));
    			txtUpdateNgayKetThuc.setText((String) tblKeHoachTour.getValueAt(selectedRow, 2));
    			txtUpdateKeHoachTour_MaTour.setText((String) tblKeHoachTour.getValueAt(selectedRow, 3));
    		}
    	});
    }
    
    private void addActionListenerBtnKeHoachTour_CTKeHoachTheoNgay_Update() {
    	btnKeHoachTour_CTKeHoachTheoNgay_CapNhat.addActionListener(new ActionListener() {
    		public  void actionPerformed(ActionEvent e) {
    			int selectedRow = tblKeHoachTour_CTKeHoachTheoNgay.getSelectedRow();
    			if(selectedRow>=0) {
    			cardLayout.show(cardsPane, "cardUpdateCTKeHoachTheoNgay");
    			txtUpdateMaCTKeHoachTheoNgay.setText((String) tblKeHoachTour_CTKeHoachTheoNgay.getValueAt(selectedRow, 0));
    			txtUpdateNgay.setText((String) tblKeHoachTour_CTKeHoachTheoNgay.getValueAt(selectedRow, 1));
    			txtUpdateDiaDiemThamQuan.setText((String) tblKeHoachTour_CTKeHoachTheoNgay.getValueAt(selectedRow, 2));
    			txtUpdatePhuongTien.setText((String) tblKeHoachTour_CTKeHoachTheoNgay.getValueAt(selectedRow, 3));
    			txtUpdateNhaHang.setText((String) tblKeHoachTour_CTKeHoachTheoNgay.getValueAt(selectedRow, 4));
    			txtUpdateKhachSan.setText((String) tblKeHoachTour_CTKeHoachTheoNgay.getValueAt(selectedRow, 5));
    			txtUpdateCTKeHoachTheoNgay_MaKHTour.setText((String) tblKeHoachTour_CTKeHoachTheoNgay.getValueAt(selectedRow, 6));
    			}
    			else if(selectedRow<0) {
					JOptionPane.showMessageDialog(null,"B???n ch??a ch???n tr?????ng d??? li???u!");
				}
    		}
    	});
    }
    
    private void addActionListenerBtnDiaDiemThamQuan_Update() {
    	btnDiaDiemThamQuan_CapNhat.addActionListener(new ActionListener() {
    		public  void actionPerformed(ActionEvent e) {
    			int selectedRow = tblDiaDiemThamQuan.getSelectedRow();
    			if(selectedRow>=0) {
    			cardLayout.show(cardsPane, "cardUpdateDiaDiemThamQuan");
    			txtUpdateMaDiaDiem.setText((String) tblDiaDiemThamQuan.getValueAt(selectedRow, 0));
    			txtUpdateTenDiaDiem.setText((String) tblDiaDiemThamQuan.getValueAt(selectedRow, 1));
    			txtUpdateDiaDiemThamQuan_DiaChi.setText((String) tblDiaDiemThamQuan.getValueAt(selectedRow, 2));
    			}
    			else if(selectedRow<0) {
					JOptionPane.showMessageDialog(null,"B???n ch??a ch???n tr?????ng d??? li???u!");
				}
    		}
    	});
    }
    
    private void addActionListenerBtnPhuongTien_Update() {
    	btnPhuongTien_CapNhat.addActionListener(new ActionListener() {
    		public  void actionPerformed(ActionEvent e) {
    			int selectedRow = tblPhuongTien.getSelectedRow();
    			if(selectedRow>=0) {
    				cardLayout.show(cardsPane, "cardUpdatePhuongTien");
        			
        			txtUpdateMaPhuongTien.setText((String) tblPhuongTien.getValueAt(selectedRow, 0));
        			txtUpdateTenPhuongTien.setText((String) tblPhuongTien.getValueAt(selectedRow, 1));
        			txtUpdateChiPhi.setText((String) tblPhuongTien.getValueAt(selectedRow, 2));
        			txtUpdateSoChoNgoi.setText((String) tblPhuongTien.getValueAt(selectedRow, 3));
    			}
    			else if(selectedRow<0) {
					JOptionPane.showMessageDialog(null,"B???n ch??a ch???n tr?????ng d??? li???u!");
				}
    		}
    	});
    }
    
    private void addActionListenerBtnNhaHang_Update() {
    	btnNhaHang_CapNhat.addActionListener(new ActionListener() {
    		public  void actionPerformed(ActionEvent e) {
    			int selectedRow = tblNhaHang.getSelectedRow();
    			if(selectedRow>=0) {
    				cardLayout.show(cardsPane, "cardUpdateNhaHang");
        			
        			txtUpdateMaNhaHang.setText((String) tblNhaHang.getValueAt(selectedRow, 0));
        			txtUpdateTenNhaHang.setText((String) tblNhaHang.getValueAt(selectedRow, 1));
        			txtUpdateNhaHang_DiaChi.setText((String) tblNhaHang.getValueAt(selectedRow, 2));
        			txtUpdateNhaHang_ChiPhiTrenNguoi.setText(String.valueOf(tblNhaHang.getValueAt(selectedRow, 3)));
    			}
    			else if(selectedRow<0) {
					JOptionPane.showMessageDialog(null,"B???n ch??a ch???n tr?????ng d??? li???u!");
				}
    		}
    	});
    }
    
    private void addActionListenerBtnKhachSan_Update() {
    	btnKhachSan_CapNhat.addActionListener(new ActionListener() {
    		public  void actionPerformed(ActionEvent e) {
    			int selectedRow = tblKhachSan.getSelectedRow();
    			if(selectedRow>=0) {
    				cardLayout.show(cardsPane, "cardUpdateKhachSan");
        			
        			txtUpdateMaKhachSan.setText((String) tblKhachSan.getValueAt(selectedRow, 0));
        			txtUpdateTenKhachSan.setText((String) tblKhachSan.getValueAt(selectedRow, 1));
        			txtUpdateKhachSan_DiaChi.setText((String) tblKhachSan.getValueAt(selectedRow, 2));
        			txtUpdateKhachSan_ChiPhiTrenNguoi.setText(String.valueOf(tblKhachSan.getValueAt(selectedRow, 3)));
    			}
    			else if(selectedRow<0) {
					JOptionPane.showMessageDialog(null,"B???n ch??a ch???n tr?????ng d??? li???u!");
				}
    		}
    	});
    }
  
}
