package com.myclass.gui;

import java.awt.EventQueue;

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
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.myclass.bus.DoanBUS;
import com.myclass.bus.HopDongBUS;
import com.myclass.bus.HuongDanVienBUS;
import com.myclass.bus.KHTourBUS;
import com.myclass.bus.KeHoachTourBUS;
import com.myclass.bus.KhachHangBUS;
import com.myclass.bus.TaiKhoanBUS;
import com.myclass.bus.TourBUS;
import com.myclass.dao.TaiKhoanDAO;
import com.myclass.dto.DoanDTO;
import com.myclass.dto.HopDongDTO;
import com.myclass.dto.HuongDanVienDTO;
import com.myclass.dto.KeHoachTourDTO;
import com.myclass.dto.KhachHangDTO;
import com.myclass.dto.TaiKhoanDTO;
import com.myclass.dto.TourDTO;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;

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
	
	private DefaultTableModel taiKhoanTblModel;
	private DefaultTableModel tourTblModel;
	private DefaultTableModel hdvTblModel;
	private DefaultTableModel khachHangTblModel;
	private DefaultTableModel tour_hopDongTblModel;
	private DefaultTableModel tour_doanTblModel;
	private DefaultTableModel tour_keHoachTourTblModel;
	private DefaultTableModel hopDongTblModel;
	private DefaultTableModel doanTblModel;
	
	private JTable tblTaiKhoan;
	private JTable tblTour;
	private JTable tblHdv;
	private JTable tblKhachHang;
	private JTable tblTour_HopDong;
	private JTable tblTour_Doan;
	private JTable tblTour_KeHoachTour;
	private JTable tblHopDong;
	private JTable tblDoan;
	
	private int selectedRow;
	
	private JButton btnTaiKhoan_Update;
	private JButton btnKhachHang_CapNhat;
	private JButton btnDoan_CapNhat;
	
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
	
	private JButton btnTour_Update;
	private JButton btnHopDong_CapNhat;
	
	private JRadioButton rBtnAddQuanTriVien;
	private JRadioButton rBtnAddNhanVien;
	private JRadioButton rBtnUpdateQuanTriVien;
	private JRadioButton rBtnUpdateNhanVien;
	private ButtonGroup bgAddQuyen;
	private ButtonGroup bgUpdateQuyen;
	
	public static Application appInstance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application frame = new Application();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Application() {
		taiKhoanBUS = new TaiKhoanBUS();
		tourBUS = new TourBUS();
		huongDanVienBUS = new HuongDanVienBUS();
		khachHangBUS = new KhachHangBUS();
		hopDongBUS = new HopDongBUS();
		doanBUS = new DoanBUS();
		keHoachTourBUS = new KeHoachTourBUS();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 800);
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
		
		lblDashboard = new JLabel("Dashboard", SwingConstants.CENTER);
		lblDashboard.setForeground(Color.WHITE);
		lblDashboard.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblDashboard.setBounds(0, 50, 250, 100);
		sidePane.add(lblDashboard);
		
		JPanel menuSidePane = new JPanel();
		menuSidePane.setBackground(Color.GRAY);
		menuSidePane.setBounds(0, 300, 250, 400);
		sidePane.add(menuSidePane);
		menuSidePane.setLayout(new GridLayout(5, 0, 0, 0));
		
		JLabel lblAdminMgmt = new JLabel("Quáº£n lÃ½ tÃ i khoáº£n há»‡ thá»‘ng");
		lblAdminMgmt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyTaiKhoan");
			}
		});
		lblAdminMgmt.setForeground(Color.WHITE);
		lblAdminMgmt.setFont(new Font("Consolas", Font.BOLD, 16));
		menuSidePane.add(lblAdminMgmt);
		
		JLabel lblTourMgmt = new JLabel("Quáº£n lÃ½ tour");
		lblTourMgmt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyTour");
			}
		});
		lblTourMgmt.setForeground(Color.WHITE);
		lblTourMgmt.setFont(new Font("Consolas", Font.BOLD, 16));
		menuSidePane.add(lblTourMgmt);
		
		JLabel lblPersonnelMgmt = new JLabel("Qu\u1EA3n l\u00FD h\u01B0\u1EDBng d\u1EABn vi\u00EAn");
		lblPersonnelMgmt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyHdv");
			}
		});
		lblPersonnelMgmt.setForeground(Color.WHITE);
		lblPersonnelMgmt.setFont(new Font("Consolas", Font.BOLD, 16));
		menuSidePane.add(lblPersonnelMgmt);
		
		JLabel lblFinanceMgmt = new JLabel("Qu\u1EA3n l\u00FD t\u00E0i ch\u00EDnh");
		lblFinanceMgmt.setForeground(Color.WHITE);
		lblFinanceMgmt.setFont(new Font("Consolas", Font.BOLD, 16));
		menuSidePane.add(lblFinanceMgmt);
		
		JLabel lblVehicleMgmt = new JLabel("Qu\u1EA3n l\u00FD kh\u00E1ch h\u00E0ng");
		lblVehicleMgmt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyKhachHang");
			}
		});
		lblVehicleMgmt.setForeground(Color.WHITE);
		lblVehicleMgmt.setFont(new Font("Consolas", Font.BOLD, 16));
		menuSidePane.add(lblVehicleMgmt);
		// ===== SIDE END HERE ===== 
		
		cardsPane = new JPanel(new CardLayout());
		cardsPane.setBackground(Color.WHITE);
		cardsPane.setBounds(250, 0, 1050, 800);
		contentPane.add(cardsPane);
		cardLayout = (CardLayout) cardsPane.getLayout();
		
		// ===== ADMIN LAYOUT START HERE =====
		JPanel cardQuanLyTaiKhoan = new JPanel();
		cardsPane.add(cardQuanLyTaiKhoan, "name_4535705721900");
		cardQuanLyTaiKhoan.setLayout(null);
		cardLayout.addLayoutComponent(cardQuanLyTaiKhoan, "cardQuanLyTaiKhoan");
		
		JLabel lblTaiKhoan_Header = new JLabel("Trang quáº£n lÃ½ tÃ i khoáº£n");
		lblTaiKhoan_Header.setBounds(0, 0, 400, 100);
		lblTaiKhoan_Header.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardQuanLyTaiKhoan.add(lblTaiKhoan_Header);
		
		JScrollPane taiKhoanScrollPane = new JScrollPane();
		taiKhoanScrollPane.setBounds(60, 450, 390, 300);
		cardQuanLyTaiKhoan.add(taiKhoanScrollPane);
		
		JLabel lblTaiKhoanSearch = new JLabel("TÃ¬m kiáº¿m:");
		lblTaiKhoanSearch.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblTaiKhoanSearch.setBounds(20, 400, 80, 30);
		cardQuanLyTaiKhoan.add(lblTaiKhoanSearch);
		
		JTextField txtTaiKhoanSearch = new JTextField();
		txtTaiKhoanSearch.setBounds(100, 400, 200, 30);
		cardQuanLyTaiKhoan.add(txtTaiKhoanSearch);
		txtTaiKhoanSearch.setColumns(10);
		
		JButton btnTaiKhoanSearch = new JButton("TÃ¬m\r\n");
		btnTaiKhoanSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int quyen = -1;
				String tenQuyen = null;
				ArrayList<TaiKhoanDTO> listKQ = taiKhoanBUS.getByTenTK(txtTaiKhoanSearch.getText());
				taiKhoanTblModel.setRowCount(0); // xoa tat ca row
				for(TaiKhoanDTO dto : listKQ) {
					quyen = dto.getQuyen();
					if(quyen == 0) {
						tenQuyen = "Quáº£n trá»‹ viÃªn";
					}
					else if(quyen == 1) {
						tenQuyen = "NhÃ¢n viÃªn";
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
		
		String[] colNamesTblTaiKhoan = {"TÃ i khoáº£n", "Máº­t kháº©u", "Quyá»�n"};
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
		
		JButton btnTaiKhoanReload = new JButton("Táº£i láº¡i báº£ng");
		btnTaiKhoanReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taiKhoanTblModel.setRowCount(0);
				loadTblTaiKhoan();
			}
		});
		btnTaiKhoanReload.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTaiKhoanReload.setBounds(475, 450, 200, 30);
		cardQuanLyTaiKhoan.add(btnTaiKhoanReload);
		
		JButton btnTaiKhoanDel = new JButton("XÃ³a tÃ i khoáº£n");
		btnTaiKhoanDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tblTaiKhoan.getSelectedRow();
				String tenTK = String.valueOf(tblTaiKhoan.getValueAt(selectedRow, 0));
				
				taiKhoanBUS.deleteByTenTK(tenTK);
				TaiKhoanBUS.listTaiKhoanDTO.remove(selectedRow);
				taiKhoanTblModel.removeRow(selectedRow);
			}
		});
		btnTaiKhoanDel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTaiKhoanDel.setBounds(475, 500, 200, 30);
		cardQuanLyTaiKhoan.add(btnTaiKhoanDel);
		
		JButton btnTaiKhoan_Add = new JButton("ThÃªm tÃ i khoáº£n");
		btnTaiKhoan_Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardAddTaiKhoan");
			}
		});
		btnTaiKhoan_Add.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTaiKhoan_Add.setBounds(475, 550, 200, 30);
		cardQuanLyTaiKhoan.add(btnTaiKhoan_Add);
		
		btnTaiKhoan_Update = new JButton("Cáº­p nháº­t tÃ i khoáº£n");
		addActionListenerBtnTaiKhoan_Update();
		btnTaiKhoan_Update.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTaiKhoan_Update.setBounds(475, 600, 200, 30);
		cardQuanLyTaiKhoan.add(btnTaiKhoan_Update);
		
//		JButton btnTaiKhoanExit = new JButton("");
//		btnTaiKhoanExit.setIcon(new ImageIcon(Application.class.getResource("/com/myclass/gui/IMG/exit-1852366-1573369 (1).png")));
//		btnTaiKhoanExit.setBounds(703, 5, 25, 29);
//		btnTaiKhoanExit.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				int reponse=JOptionPane.showConfirmDialog(rootPane, "Do you want to exit ?","Exit",JOptionPane.YES_NO_OPTION);
//	        	if(reponse==0)
//	        	{
//	        		System.exit(0);
//	        	}else
//	        	{
//	        		return;
//	        	}	
//	        	
//			}
//			
//		});
//		cardQuanLyTaiKhoan.add(btnTaiKhoanExit);
		// ===== ADMIN LAYOUT END HERE =====
		
		// ===== ADMIN ADD LAYOUT START HERE =====
		JPanel cardAddTaiKhoan = new JPanel();
		cardsPane.add(cardAddTaiKhoan);
		cardAddTaiKhoan.setLayout(null);
		cardLayout.addLayoutComponent(cardAddTaiKhoan, "cardAddTaiKhoan");
		
		JLabel lblAddAdminContent = new JLabel("Trang thÃªm tÃ i khoáº£n");
		lblAddAdminContent.setBounds(0, 0, 400, 100);
		lblAddAdminContent.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardAddTaiKhoan.add(lblAddAdminContent);
		
		JLabel lblAddTenTaiKhoan = new JLabel("Nháº­p tÃªn tÃ i khoáº£n:");
		lblAddTenTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddTenTaiKhoan.setBounds(50, 150, 150, 30);
		cardAddTaiKhoan.add(lblAddTenTaiKhoan);
		
		JTextField txtAddTenTaiKhoan = new JTextField();
		txtAddTenTaiKhoan.setColumns(10);
		txtAddTenTaiKhoan.setBounds(200, 150, 300, 30);
		cardAddTaiKhoan.add(txtAddTenTaiKhoan);
		
		JLabel lblAddMatKhau = new JLabel("Nháº­p máº­t kháº©u:");
		lblAddMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddMatKhau.setBounds(50, 200, 150, 30);
		cardAddTaiKhoan.add(lblAddMatKhau);
		
		JTextField txtAddMatKhau = new JTextField();
		txtAddMatKhau.setColumns(10);
		txtAddMatKhau.setBounds(200, 200, 300, 30);
		cardAddTaiKhoan.add(txtAddMatKhau);
		
		JLabel lblAddQuyen = new JLabel("Chá»�n quyá»�n:");
		lblAddQuyen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddQuyen.setBounds(50, 250, 150, 30);
		cardAddTaiKhoan.add(lblAddQuyen);
		
		rBtnAddQuanTriVien = new JRadioButton("Quáº£n trá»‹ viÃªn");
		rBtnAddQuanTriVien.setActionCommand("Quáº£n trá»‹ viÃªn");
		rBtnAddQuanTriVien.setSelected(true);
		rBtnAddQuanTriVien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rBtnAddQuanTriVien.setBounds(200, 250, 120, 30);
		cardAddTaiKhoan.add(rBtnAddQuanTriVien);
		
		rBtnAddNhanVien = new JRadioButton("NhÃ¢n viÃªn");
		rBtnAddNhanVien.setActionCommand("NhÃ¢n viÃªn");
		rBtnAddNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rBtnAddNhanVien.setBounds(350, 250, 100, 30);
		cardAddTaiKhoan.add(rBtnAddNhanVien);
		
		bgAddQuyen = new ButtonGroup();
		bgAddQuyen.add(rBtnAddQuanTriVien);
		bgAddQuyen.add(rBtnAddNhanVien);
		
		JButton btnAddTaiKhoan_Add = new JButton("ThÃªm má»›i");
		btnAddTaiKhoan_Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		
		JButton btnAddTaiKhoan_QuayLai = new JButton("Quay láº¡i");
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
		
		JLabel lblUpdateAdminContent = new JLabel("Trang cáº­p nháº­t tÃ i khoáº£n");
		lblUpdateAdminContent.setBounds(0, 0, 400, 100);
		lblUpdateAdminContent.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardUpdateTaiKhoan.add(lblUpdateAdminContent);
		
		JLabel lblUpdateTenTaiKhoan = new JLabel("Nháº­p tÃªn tÃ i khoáº£n:");
		lblUpdateTenTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateTenTaiKhoan.setBounds(50, 150, 150, 30);
		cardUpdateTaiKhoan.add(lblUpdateTenTaiKhoan);
		
		txtUpdateTenTaiKhoan = new JTextField();
		txtUpdateTenTaiKhoan.setColumns(10);
		txtUpdateTenTaiKhoan.setBounds(200, 150, 300, 30);
		cardUpdateTaiKhoan.add(txtUpdateTenTaiKhoan);
		
		JLabel lblUpdateMatKhau = new JLabel("Nháº­p máº­t kháº©u:");
		lblUpdateMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateMatKhau.setBounds(50, 200, 150, 30);
		cardUpdateTaiKhoan.add(lblUpdateMatKhau);
		
		txtUpdateMatKhau = new JTextField();
		txtUpdateMatKhau.setColumns(10);
		txtUpdateMatKhau.setBounds(200, 200, 300, 30);
		cardUpdateTaiKhoan.add(txtUpdateMatKhau);
		
		JLabel lblUpdateQuyen = new JLabel("Chá»�n quyá»�n:");
		lblUpdateQuyen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateQuyen.setBounds(50, 250, 150, 30);
		cardUpdateTaiKhoan.add(lblUpdateQuyen);
		
		rBtnUpdateQuanTriVien = new JRadioButton("Quáº£n trá»‹ viÃªn");
		rBtnUpdateQuanTriVien.setActionCommand("Quáº£n trá»‹ viÃªn");
		rBtnUpdateQuanTriVien.setSelected(true);
		rBtnUpdateQuanTriVien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rBtnUpdateQuanTriVien.setBounds(200, 250, 120, 30);
		cardUpdateTaiKhoan.add(rBtnUpdateQuanTriVien);
		
		rBtnUpdateNhanVien = new JRadioButton("NhÃ¢n viÃªn");
		rBtnUpdateNhanVien.setActionCommand("NhÃ¢n viÃªn");
		rBtnUpdateNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rBtnUpdateNhanVien.setBounds(350, 250, 100, 30);
		cardUpdateTaiKhoan.add(rBtnUpdateNhanVien);
		
		bgUpdateQuyen = new ButtonGroup();
		bgUpdateQuyen.add(rBtnUpdateQuanTriVien);
		bgUpdateQuyen.add(rBtnUpdateNhanVien);
		
		JButton btnUpdateTaiKhoan = new JButton("Cáº­p nháº­t");
		btnUpdateTaiKhoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tblTaiKhoan.getSelectedRow();
				String tenQuyen = bgUpdateQuyen.getSelection().getActionCommand();
				TaiKhoanDTO dto = new TaiKhoanDTO();
				
				if(!taiKhoanTblModel.getValueAt(selectedRow, 0).equals(txtUpdateTenTaiKhoan.getText())) {
					JOptionPane.showMessageDialog(new JFrame(), "KhÃ´ng Ä‘Æ°á»£c thay Ä‘á»•i tÃªn tÃ i khoáº£n!");
					return;
				}
				
				dto.setTenTK(txtUpdateTenTaiKhoan.getText());
				dto.setMatKhau(txtUpdateMatKhau.getText());
				if(tenQuyen.equals("Quáº£n trá»‹ viÃªn")) {
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
		
		JButton btnUpdateTaiKhoan_QuayLai = new JButton("Quay láº¡i");
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
		
		JLabel lblTourSearch = new JLabel("TÃ¬m kiáº¿m:");
		lblTourSearch.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblTourSearch.setBounds(20, 0, 80, 30);
		cardQuanLyTour.add(lblTourSearch);
		
		JTextField txtTourSearch = new JTextField();
		txtTourSearch.setBounds(100, 0, 200, 30);
		cardQuanLyTour.add(txtTourSearch);
		txtTourSearch.setColumns(10);
		
		JButton btnTourSearch = new JButton("TÃ¬m");
		
		btnTourSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<TourDTO> listKQ;
				Object[] options = {
			            "Tìm kiếm theo mã Tour", "Tìm kiếm theo tên Tour", "Đóng"
			        };
			        int select = JOptionPane.showOptionDialog(btnTourSearch, "Bạn muốn tìm kiếm theo phương thức nào?", "Tùy chọn", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
			        
			        //System.out.println("select: " + select);
			        //mÃ£ -> select: 0
			        //tÃªn -> select: 1
			        // chi phi -> select: 2
			        // Ä‘Ã³ng -> select: 3
			        
			        if(select == 0){
			            String input = JOptionPane.showInputDialog(btnTourSearch, "Mời bạn nhập mã Tour !");
			            
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
			                JOptionPane.showMessageDialog(null, "Lỗi tìm kiếm !");
			            }
			        }
			        
			        if(select == 1){
			            String input = JOptionPane.showInputDialog(btnTourSearch, "Mời bạn nhập tên Tour !");
			            
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
			                JOptionPane.showMessageDialog(null, "Lỗi tìm kiếm !");
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
		String[] colNamesTblTour = {"MÃ£ tour", "TÃªn tour", "GiÃ¡ vÃ©", "Ä�iá»ƒm khá»Ÿi hÃ nh", "Ä�iá»ƒm Ä‘áº¿n"};
		tourTblModel = new DefaultTableModel();
		tblTour.setModel(tourTblModel);
		for(String colName : colNamesTblTour) {
			tourTblModel.addColumn(colName);
		}
		loadTblTour();
		
		tourScrollPane.setViewportView(tblTour);
		tblTour.setFillsViewportHeight(true);
		
		JButton btnTourReload = new JButton("Táº£i láº¡i báº£ng");
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
		
		JButton btnTourDel = new JButton("XÃ³a tour");
		btnTourDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tblTour.getSelectedRow();
				String maTour = (String) tblTour.getValueAt(selectedRow, 0);
				
				tourBUS.deleteById(maTour);
				tourTblModel.removeRow(selectedRow);
			}
		});
		btnTourDel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTourDel.setBounds(675, 100, 150, 30);;
		cardQuanLyTour.add(btnTourDel);
		
		JButton btnTourAdd = new JButton("ThÃªm tour");
		btnTourAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardAddTour");
			}
		});
		btnTourAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTourAdd.setBounds(675, 150, 150, 30);
		cardQuanLyTour.add(btnTourAdd);
		
		btnTour_Update = new JButton("Cáº­p nháº­t tour");
		addActionListenerBtnTour_Update();
		btnTour_Update.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTour_Update.setBounds(675, 200, 150, 30);
		cardQuanLyTour.add(btnTour_Update);
		
		JButton btnTour_TaoHD = new JButton("Táº¡o há»£p Ä‘á»“ng");
		btnTour_TaoHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardAddHopDong");
			}
		});
		addActionListenerBtnTour_Update();
		btnTour_TaoHD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTour_TaoHD.setBounds(50, 350, 150, 30);
		cardQuanLyTour.add(btnTour_TaoHD);
		
		JButton btnTour_TaoDoan = new JButton("Táº¡o Ä‘oÃ n");
		btnTour_TaoDoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardAddDoan");
			}
		});
		addActionListenerBtnTour_Update();
		btnTour_TaoDoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTour_TaoDoan.setBounds(225, 350, 150, 30);
		cardQuanLyTour.add(btnTour_TaoDoan);
		
		JButton btnTour_TaoKeHoach = new JButton("Táº¡o káº¿ hoáº¡ch");
		addActionListenerBtnTour_Update();
		btnTour_TaoKeHoach.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTour_TaoKeHoach.setBounds(400, 350, 150, 30);
		cardQuanLyTour.add(btnTour_TaoKeHoach);
		
		JLabel lblThongTinHopDong = new JLabel("ThÃ´ng tin há»£p Ä‘á»“ng:");
		lblThongTinHopDong.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThongTinHopDong.setBounds(50, 410, 200, 30);
		cardQuanLyTour.add(lblThongTinHopDong);
		
		JScrollPane tour_hopDongScrollPane = new JScrollPane();
		tour_hopDongScrollPane.setBounds(50, 450, 600, 73);
		cardQuanLyTour.add(tour_hopDongScrollPane);
		
		tblTour_HopDong = new JTable();
		tblTour_HopDong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tblTour_HopDong.setRowHeight(50);
		String[] colNamesTblTour_HopDong = {"MÃ£ há»£p Ä‘á»“ng", "NgÃ y láº­p há»£p Ä‘á»“ng", "Ná»™i dung", "MÃ£ tour"};
		tour_hopDongTblModel = new DefaultTableModel();
		tblTour_HopDong.setModel(tour_hopDongTblModel);
		for(String colName : colNamesTblTour_HopDong) {
			tour_hopDongTblModel.addColumn(colName);
		}
		
		tour_hopDongScrollPane.setViewportView(tblTour_HopDong);
		tblTour_HopDong.setFillsViewportHeight(true);
		
		JButton btnTour_HopDongLayout = new JButton("Xem danh sÃ¡ch");
		btnTour_HopDongLayout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyHopDong");
			}
		});
		addActionListenerBtnTour_Update();
		btnTour_HopDongLayout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTour_HopDongLayout.setBounds(675, 470, 150, 30);
		cardQuanLyTour.add(btnTour_HopDongLayout);
		
		JLabel lblThongTinDoan = new JLabel("ThÃ´ng tin Ä‘oÃ n du lá»‹ch:");
		lblThongTinDoan.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThongTinDoan.setBounds(50, 530, 200, 30);
		cardQuanLyTour.add(lblThongTinDoan);
		
		JScrollPane tour_doanScrollPane = new JScrollPane();
		tour_doanScrollPane.setBounds(50, 570, 600, 73);
		cardQuanLyTour.add(tour_doanScrollPane);
		
		tblTour_Doan = new JTable();
		tblTour_Doan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tblTour_Doan.setRowHeight(50);
		String[] colNamesTblTour_Doan = {"MÃ£ Ä‘oÃ n", "Sá»‘ ngÆ°á»�i", "MÃ£ tour", "MÃ£ HDV"};
		tour_doanTblModel = new DefaultTableModel();
		tblTour_Doan.setModel(tour_doanTblModel);
		for(String colName : colNamesTblTour_Doan) {
			tour_doanTblModel.addColumn(colName);
		}
		
		tour_doanScrollPane.setViewportView(tblTour_Doan);
		tblTour_Doan.setFillsViewportHeight(true);
		
		JButton btnTour_DoanLayout = new JButton("Xem danh sÃ¡ch");
		btnTour_DoanLayout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyDoan");
			}
		});
		addActionListenerBtnTour_Update();
		btnTour_DoanLayout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTour_DoanLayout.setBounds(675, 590, 150, 30);
		cardQuanLyTour.add(btnTour_DoanLayout);
		
		JLabel lblKeHoachTour = new JLabel("Káº¿ hoáº¡ch tour:");
		lblKeHoachTour.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblKeHoachTour.setBounds(50, 650, 200, 30);
		cardQuanLyTour.add(lblKeHoachTour);
		
		JScrollPane tour_keHoachTourScrollPane = new JScrollPane();
		tour_keHoachTourScrollPane.setBounds(50, 690, 600, 73);
		cardQuanLyTour.add(tour_keHoachTourScrollPane);
		
		tblTour_KeHoachTour = new JTable();
		tblTour_KeHoachTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tblTour_KeHoachTour.setRowHeight(50);
		String[] colNamesTblKeHoachTour = {"MÃ£ káº¿ hoáº¡ch", "NgÃ y báº¯t Ä‘áº§u", "NgÃ y káº¿t thÃºc", "MÃ£ tour"};
		tour_keHoachTourTblModel = new DefaultTableModel();
		tblTour_KeHoachTour.setModel(tour_keHoachTourTblModel);
		for(String colName : colNamesTblKeHoachTour) {
			tour_keHoachTourTblModel.addColumn(colName);
		}
		
		tour_keHoachTourScrollPane.setViewportView(tblTour_KeHoachTour);
		tblTour_KeHoachTour.setFillsViewportHeight(true);
		
		JButton btnTour_KeHoachLayout = new JButton("Xem danh sÃ¡ch");
		addActionListenerBtnTour_Update();
		btnTour_KeHoachLayout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTour_KeHoachLayout.setBounds(675, 710, 150, 30);
		cardQuanLyTour.add(btnTour_KeHoachLayout);
		// ===== TOUR LAYOUT END HERE =====
		
		// ===== TOUR ADD LAYOUT START HERE =====
		JPanel cardAddTour = new JPanel();
		cardsPane.add(cardAddTour);
		cardAddTour.setLayout(null);
		cardLayout.addLayoutComponent(cardAddTour, "cardAddTour");
		
		JLabel lblAddTourContent = new JLabel("Trang thÃªm tour");
		lblAddTourContent.setBounds(0, 0, 400, 100);
		lblAddTourContent.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardAddTour.add(lblAddTourContent);
		
		JLabel lblAddMaTour = new JLabel("Nháº­p mÃ£ tour:");
		lblAddMaTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddMaTour.setBounds(50, 100, 150, 30);
		cardAddTour.add(lblAddMaTour);
		
		JTextField txtAddMaTour = new JTextField();
		txtAddMaTour.setColumns(10);
		txtAddMaTour.setBounds(200, 100, 300, 30);
		cardAddTour.add(txtAddMaTour);
		
		JLabel lblAddTenTour = new JLabel("Nháº­p tÃªn tour:");
		lblAddTenTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddTenTour.setBounds(50, 150, 150, 30);
		cardAddTour.add(lblAddTenTour);
		
		JTextField txtAddTenTour = new JTextField();
		txtAddTenTour.setColumns(10);
		txtAddTenTour.setBounds(200, 150, 300, 30);
		cardAddTour.add(txtAddTenTour);
		
		JLabel lblAddGiaVe = new JLabel("Nháº­p giÃ¡ vÃ©:");
		lblAddGiaVe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddGiaVe.setBounds(50, 200, 150, 30);
		cardAddTour.add(lblAddGiaVe);
		
		JTextField txtAddGiaVe = new JTextField();
		txtAddGiaVe.setColumns(10);
		txtAddGiaVe.setBounds(200, 200, 300, 30);
		cardAddTour.add(txtAddGiaVe);
		
		JLabel lblAddDiemKhoiHanh = new JLabel("Nháº­p Ä‘iá»ƒm khá»Ÿi hÃ nh:");
		lblAddDiemKhoiHanh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddDiemKhoiHanh.setBounds(50, 250, 150, 30);
		cardAddTour.add(lblAddDiemKhoiHanh);
		
		JTextField txtAddDiemKhoiHanh = new JTextField();
		txtAddDiemKhoiHanh.setColumns(10);
		txtAddDiemKhoiHanh.setBounds(200, 250, 300, 30);
		cardAddTour.add(txtAddDiemKhoiHanh);
		
		JLabel lblAddDiemDen = new JLabel("Nháº­p Ä‘iá»ƒm Ä‘áº¿n:");
		lblAddDiemDen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddDiemDen.setBounds(50, 300, 150, 30);
		cardAddTour.add(lblAddDiemDen);
		
		JTextField txtAddDiemDen = new JTextField();
		txtAddDiemDen.setColumns(10);
		txtAddDiemDen.setBounds(200, 300, 300, 30);
		cardAddTour.add(txtAddDiemDen);
		
		JButton btnAddTour_ThemMoi = new JButton("ThÃªm má»›i");
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
		
		JButton btnAddTour_QuayLai = new JButton("Quay láº¡i");
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
		
		JLabel lblUpdateTourContent = new JLabel("Trang thÃªm tour");
		lblUpdateTourContent.setBounds(0, 0, 400, 100);
		lblUpdateTourContent.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardUpdateTour.add(lblUpdateTourContent);
		
		JLabel lblUpdateMaTour = new JLabel("Nháº­p mÃ£ tour:");
		lblUpdateMaTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateMaTour.setBounds(50, 100, 150, 30);
		cardUpdateTour.add(lblUpdateMaTour);
		
		txtUpdateMaTour = new JTextField();
		txtUpdateMaTour.setColumns(10);
		txtUpdateMaTour.setBounds(200, 100, 300, 30);
		cardUpdateTour.add(txtUpdateMaTour);
		
		JLabel lblUpdateTenTour = new JLabel("Nháº­p tÃªn tour:");
		lblUpdateTenTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateTenTour.setBounds(50, 150, 150, 30);
		cardUpdateTour.add(lblUpdateTenTour);
		
		txtUpdateTenTour = new JTextField();
		txtUpdateTenTour.setColumns(10);
		txtUpdateTenTour.setBounds(200, 150, 300, 30);
		cardUpdateTour.add(txtUpdateTenTour);
		
		JLabel lblUpdateGiaVe = new JLabel("Nháº­p giÃ¡ vÃ©:");
		lblUpdateGiaVe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateGiaVe.setBounds(50, 200, 150, 30);
		cardUpdateTour.add(lblUpdateGiaVe);
		
		txtUpdateGiaVe = new JTextField();
		txtUpdateGiaVe.setColumns(10);
		txtUpdateGiaVe.setBounds(200, 200, 300, 30);
		cardUpdateTour.add(txtUpdateGiaVe);
		
		JLabel lblUpdateDiemKhoiHanh = new JLabel("Nháº­p Ä‘iá»ƒm khá»Ÿi hÃ nh:");
		lblUpdateDiemKhoiHanh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateDiemKhoiHanh.setBounds(50, 250, 150, 30);
		cardUpdateTour.add(lblUpdateDiemKhoiHanh);
		
		txtUpdateDiemKhoiHanh = new JTextField();
		txtUpdateDiemKhoiHanh.setColumns(10);
		txtUpdateDiemKhoiHanh.setBounds(200, 250, 300, 30);
		cardUpdateTour.add(txtUpdateDiemKhoiHanh);
		
		JLabel lblUpdateDiemDen = new JLabel("Nháº­p Ä‘iá»ƒm Ä‘áº¿n:");
		lblUpdateDiemDen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateDiemDen.setBounds(50, 300, 150, 30);
		cardUpdateTour.add(lblUpdateDiemDen);
		
		txtUpdateDiemDen = new JTextField();
		txtUpdateDiemDen.setColumns(10);
		txtUpdateDiemDen.setBounds(200, 300, 300, 30);
		cardUpdateTour.add(txtUpdateDiemDen);
		
		JButton btnUpdateTour_ThemMoi = new JButton("Cáº­p nháº­t");
		btnUpdateTour_ThemMoi.addActionListener(new ActionListener() {
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
		btnUpdateTour_ThemMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateTour_ThemMoi.setBounds(150, 400, 120, 30);
		cardUpdateTour.add(btnUpdateTour_ThemMoi);
		
		JButton btnUpdateTour_QuayLai = new JButton("Quay láº¡i");
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
		
		JLabel lblHdvCard = new JLabel("Trang quáº£n lÃ½ hÆ°á»›ng dáº«n viÃªn");
		lblHdvCard.setBounds(0, 0, 500, 100);
		lblHdvCard.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardQuanLyHdv.add(lblHdvCard);
		
		JLabel lblHdvSearch = new JLabel("TÃ¬m kiáº¿m:");
		lblHdvSearch.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblHdvSearch.setBounds(20, 400, 80, 30);
		cardQuanLyHdv.add(lblHdvSearch);
		
		JTextField txtHdvSearch = new JTextField();
		txtHdvSearch.setBounds(100, 400, 200, 30);
		cardQuanLyHdv.add(txtHdvSearch);
		txtHdvSearch.setColumns(10);
		
		JButton btnHdvSearch = new JButton("TÃ¬m\r\n");
		btnHdvSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<HuongDanVienDTO> listKQ;
				Object[] options = {
			            "Tìm kiếm theo mã HDV","Tìm kiếm theo họ HDV", "Tìm kiếm theo tên HDV", "Đóng"
			        };
			        int select = JOptionPane.showOptionDialog(btnTourSearch, "Bạn muốn tìm kiếm theo phương thức nào?", "Tùy chọn", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[3]);
			        
			        //System.out.println("select: " + select);
			        //mÃ£ -> select: 0
			        //tÃªn -> select: 1
			        // chi phi -> select: 2
			        // Ä‘Ã³ng -> select: 3
			        
			        if(select == 0){
			            String input = JOptionPane.showInputDialog(btnTourSearch, "Mời bạn nhập mã HDV !");
			            
			            if(input != null && input.length() > 0){
			                listKQ = huongDanVienBUS.getByMaHDV(input);
			                hdvTblModel.setRowCount(0);
			                
			                for(HuongDanVienDTO dto : listKQ) {
			                	hdvTblModel.addRow(new Object[] {
										dto.getMaHDV(), dto.getHoTen(), dto.getNgaySinh(), dto.getGioiTinh(), dto.getDiaChi(),dto.getSdt()
								});
			                };
			            }
			            else {
			                JOptionPane.showMessageDialog(null, "Lỗi tìm kiếm !");
			            }
			        }
			        
			        if(select == 1){
			            String input = JOptionPane.showInputDialog(btnTourSearch, "Mời bạn nhập họ HDV !");
			            
			            if(input != null && input.length() > 0){
			                listKQ = huongDanVienBUS.getByHoHDV(input);
			                hdvTblModel.setRowCount(0);
			                
			                for(HuongDanVienDTO dto : listKQ) {
			                	hdvTblModel.addRow(new Object[] {
										dto.getMaHDV(), dto.getHoTen(), dto.getNgaySinh(), dto.getGioiTinh(), dto.getDiaChi(),dto.getSdt()
								});
			                };
			            }
			            else {
			                JOptionPane.showMessageDialog(null, "Lỗi tìm kiếm !");
			            }
			        }
			        
			        if(select == 2){
			            String input = JOptionPane.showInputDialog(btnTourSearch, "Mời bạn nhập tên HDV !");
			            
			            if(input != null && input.length() > 0){
			                listKQ = huongDanVienBUS.getByTenHDV(input);
			                hdvTblModel.setRowCount(0);
			                
			                for(HuongDanVienDTO dto : listKQ) {
			                	hdvTblModel.addRow(new Object[] {
										dto.getMaHDV(), dto.getHoTen(), dto.getNgaySinh(), dto.getGioiTinh(), dto.getDiaChi(),dto.getSdt()
								});
			                };
			            }
			            else {
			                JOptionPane.showMessageDialog(null, "Lỗi tìm kiếm !");
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
		tblHdv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int indexRowSelected = tblHdv.getSelectedRow();
				
//				txtMaTour.setText((String) tourTblModel.getValueAt(indexRowSelected, 0));
//				txtTenTour.setText((String) tourTblModel.getValueAt(indexRowSelected, 1));
//				txtGiaVe.setText(String.valueOf( tourTblModel.getValueAt(indexRowSelected, 2) ));
//				txtMaKHTour.setText((String) tourTblModel.getValueAt(indexRowSelected, 3));
//				txtMaHD.setText((String) tourTblModel.getValueAt(indexRowSelected, 4));
			}
		});
		tblHdv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tblHdv.setRowHeight(50);
		hdvTblModel = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"MÃ£ HDV", "Há»� tÃªn", "NgÃ y sinh", "Giá»›i tÃ­nh", "Ä�á»‹a chá»‰", "Sá»‘ Ä‘iá»‡n thoáº¡i"
				}
			);
		tblHdv.setModel(hdvTblModel);
		loadTblHdv();
		
		hdvScrollPane.setViewportView(tblHdv);
		tblHdv.setFillsViewportHeight(true);
		
		JButton btnHdvReload = new JButton("Táº£i láº¡i báº£ng");
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
		
		JButton btnHdvDel = new JButton("XÃ³a hÆ°á»›ng dáº«n viÃªn");
		btnHdvDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tblHdv.getSelectedRow();
				String maHdv = (String) tblHdv.getValueAt(selectedRow, 0);
				
				huongDanVienBUS.deleteById(maHdv);
				hdvTblModel.removeRow(selectedRow);
			}
		});
		btnHdvDel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHdvDel.setBounds(795, 500, 220, 30);;
		cardQuanLyHdv.add(btnHdvDel);
		
		JButton btnHdvAdd = new JButton("ThÃªm hÆ°á»›ng dáº«n viÃªn");
		btnHdvAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardAddHdv");
			}
		});
		btnHdvAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHdvAdd.setBounds(795, 550, 220, 30);
		cardQuanLyHdv.add(btnHdvAdd);
		
		JButton btnHdvUpdate = new JButton("Cáº­p nháº­t hÆ°á»›ng dáº«n viÃªn");
		btnHdvUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardUpdateHdv");
				selectedRow = tblHdv.getSelectedRow();
				
				txtUpdateMaHdv.setText((String) tblHdv.getValueAt(selectedRow, 0));
				txtUpdateHoTenHdv.setText((String) tblHdv.getValueAt(selectedRow, 1));
				txtUpdateNgaySinhHdv.setText((String) tblHdv.getValueAt(selectedRow, 2));
				txtUpdateGioiTinhHdv.setText((String) tblHdv.getValueAt(selectedRow, 3));
				txtUpdateDiaChiHdv.setText((String) tblHdv.getValueAt(selectedRow, 4));
				txtUpdateSdtHdv.setText((String) tblHdv.getValueAt(selectedRow, 5));
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
		
		JLabel lblAddHdvContent = new JLabel("Trang thÃªm hÆ°á»›ng dáº«n viÃªn");
		lblAddHdvContent.setBounds(0, 0, 500, 100);
		lblAddHdvContent.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardAddHdv.add(lblAddHdvContent);
		
		JLabel lblAddMaHdv = new JLabel("Nháº­p mÃ£ hÆ°á»›ng dáº«n viÃªn:");
		lblAddMaHdv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddMaHdv.setBounds(50, 100, 200, 30);
		cardAddHdv.add(lblAddMaHdv);
		
		JTextField txtAddMaHdv = new JTextField();
		txtAddMaHdv.setColumns(10);
		txtAddMaHdv.setBounds(250, 100, 300, 30);
		cardAddHdv.add(txtAddMaHdv);
		
		JLabel lblAddHoTenHdv = new JLabel("Nháº­p há»� tÃªn:");
		lblAddHoTenHdv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddHoTenHdv.setBounds(50, 150, 200, 30);
		cardAddHdv.add(lblAddHoTenHdv);
		
		JTextField txtAddHoTenHdv = new JTextField();
		txtAddHoTenHdv.setColumns(10);
		txtAddHoTenHdv.setBounds(250, 150, 300, 30);
		cardAddHdv.add(txtAddHoTenHdv);
		
		JLabel lblAddNgaySinhHdv = new JLabel("Nháº­p ngÃ y sinh:");
		lblAddNgaySinhHdv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddNgaySinhHdv.setBounds(50, 200, 200, 30);
		cardAddHdv.add(lblAddNgaySinhHdv);
		
		JTextField txtAddNgaySinhHdv = new JTextField();
		txtAddNgaySinhHdv.setColumns(10);
		txtAddNgaySinhHdv.setBounds(250, 200, 300, 30);
		cardAddHdv.add(txtAddNgaySinhHdv);
		
		JLabel lblAddGioiTinhHdv = new JLabel("Nháº­p giá»›i tÃ­nh:");
		lblAddGioiTinhHdv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddGioiTinhHdv.setBounds(50, 250, 200, 30);
		cardAddHdv.add(lblAddGioiTinhHdv);
		
		JTextField txtAddGioiTinhHdv = new JTextField();
		txtAddGioiTinhHdv.setColumns(10);
		txtAddGioiTinhHdv.setBounds(250, 250, 300, 30);
		cardAddHdv.add(txtAddGioiTinhHdv);
		
		JLabel lblAddDiaChiHdv = new JLabel("Nháº­p Ä‘á»‹a chá»‰:");
		lblAddDiaChiHdv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddDiaChiHdv.setBounds(50, 300, 200, 30);
		cardAddHdv.add(lblAddDiaChiHdv);
		
		JTextField txtAddDiaChiHdv = new JTextField();
		txtAddDiaChiHdv.setColumns(10);
		txtAddDiaChiHdv.setBounds(250, 300, 300, 30);
		cardAddHdv.add(txtAddDiaChiHdv);
		
		JLabel lblAddSdtHdv = new JLabel("Nháº­p sá»‘ Ä‘iá»‡n thoáº¡i:");
		lblAddSdtHdv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddSdtHdv.setBounds(50, 350, 200, 30);
		cardAddHdv.add(lblAddSdtHdv);
		
		JTextField txtAddSdtHdv = new JTextField();
		txtAddSdtHdv.setColumns(10);
		txtAddSdtHdv.setBounds(250, 350, 300, 30);
		cardAddHdv.add(txtAddSdtHdv);
		
		JButton btnAddHdv_ThemMoi = new JButton("ThÃªm má»›i");
		btnAddHdv_ThemMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		
		JButton btnAddHdv_QuayLai = new JButton("Quay láº¡i");
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
		
		JLabel lblUpdateHdvContent = new JLabel("Trang cáº­p nháº­t hÆ°á»›ng dáº«n viÃªn");
		lblUpdateHdvContent.setBounds(0, 0, 500, 100);
		lblUpdateHdvContent.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardUpdateHdv.add(lblUpdateHdvContent);
		
		JLabel lblUpdateMaHdv = new JLabel("Nháº­p mÃ£ hÆ°á»›ng dáº«n viÃªn:");
		lblUpdateMaHdv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateMaHdv.setBounds(50, 100, 200, 30);
		cardUpdateHdv.add(lblUpdateMaHdv);
		
		txtUpdateMaHdv = new JTextField();
		txtUpdateMaHdv.setColumns(10);
		txtUpdateMaHdv.setBounds(250, 100, 300, 30);
		cardUpdateHdv.add(txtUpdateMaHdv);
		
		JLabel lblUpdateHoTenHdv = new JLabel("Nháº­p há»� tÃªn:");
		lblUpdateHoTenHdv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateHoTenHdv.setBounds(50, 150, 200, 30);
		cardUpdateHdv.add(lblUpdateHoTenHdv);
		
		txtUpdateHoTenHdv = new JTextField();
		txtUpdateHoTenHdv.setColumns(10);
		txtUpdateHoTenHdv.setBounds(250, 150, 300, 30);
		cardUpdateHdv.add(txtUpdateHoTenHdv);
		
		JLabel lblUpdateNgaySinhHdv = new JLabel("Nháº­p ngÃ y sinh:");
		lblUpdateNgaySinhHdv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateNgaySinhHdv.setBounds(50, 200, 200, 30);
		cardUpdateHdv.add(lblUpdateNgaySinhHdv);
		
		txtUpdateNgaySinhHdv = new JTextField();
		txtUpdateNgaySinhHdv.setColumns(10);
		txtUpdateNgaySinhHdv.setBounds(250, 200, 300, 30);
		cardUpdateHdv.add(txtUpdateNgaySinhHdv);
		
		JLabel lblUpdateGioiTinh = new JLabel("Nháº­p giá»›i tÃ­nh:");
		lblUpdateGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateGioiTinh.setBounds(50, 250, 200, 30);
		cardUpdateHdv.add(lblUpdateGioiTinh);
		
		txtUpdateGioiTinhHdv = new JTextField();
		txtUpdateGioiTinhHdv.setColumns(10);
		txtUpdateGioiTinhHdv.setBounds(250, 250, 300, 30);
		cardUpdateHdv.add(txtUpdateGioiTinhHdv);
		
		JLabel lblUpdateDiaChiHdv = new JLabel("Nháº­p Ä‘á»‹a chá»‰:");
		lblUpdateDiaChiHdv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateDiaChiHdv.setBounds(50, 300, 200, 30);
		cardUpdateHdv.add(lblUpdateDiaChiHdv);
		
		txtUpdateDiaChiHdv = new JTextField();
		txtUpdateDiaChiHdv.setColumns(10);
		txtUpdateDiaChiHdv.setBounds(250, 300, 300, 30);
		cardUpdateHdv.add(txtUpdateDiaChiHdv);
		
		JLabel lblUpdateSdtHdv = new JLabel("Nháº­p sá»‘ Ä‘iá»‡n thoáº¡i:");
		lblUpdateSdtHdv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateSdtHdv.setBounds(50, 350, 200, 30);
		cardUpdateHdv.add(lblUpdateSdtHdv);
		
		txtUpdateSdtHdv = new JTextField();
		txtUpdateSdtHdv.setColumns(10);
		txtUpdateSdtHdv.setBounds(250, 350, 300, 30);
		cardUpdateHdv.add(txtUpdateSdtHdv);
		
		JButton btnUpdateHdv_CapNhat = new JButton("Cáº­p nháº­t");
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
				cardLayout.show(cardsPane, "cardQuanLyHuongDanVien");
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
		
		JButton btnUpdateHdv_QuayLai = new JButton("Quay láº¡i");
		btnUpdateHdv_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyHuongDanVien");
			}
		});
		btnUpdateHdv_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateHdv_QuayLai.setBounds(300, 400, 100, 30);
		cardUpdateHdv.add(btnUpdateHdv_QuayLai);
		// ===== UPDATE HDV LAYOUT END HERE
		
		// ===== KHACH HANG LAYOUT START HERE =====
		JPanel cardQuanLyKhachHang= new JPanel();
		cardsPane.add(cardQuanLyKhachHang, "name_4568411886400");
		cardQuanLyKhachHang.setLayout(null);
		cardLayout.addLayoutComponent(cardQuanLyKhachHang, "cardQuanLyKhachHang");
		
		JLabel lblKhachHang_TieuDe = new JLabel("Trang quáº£n lÃ½ khÃ¡ch hÃ ng");
		lblKhachHang_TieuDe.setBounds(0, 0, 500, 100);
		lblKhachHang_TieuDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardQuanLyKhachHang.add(lblKhachHang_TieuDe);
		
		JLabel lblKhachHang_TimKiem = new JLabel("TÃ¬m kiáº¿m:");
		lblKhachHang_TimKiem.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblKhachHang_TimKiem.setBounds(20, 400, 80, 30);
		cardQuanLyKhachHang.add(lblKhachHang_TimKiem);
		
		JTextField txtKhachHang_TimKiem = new JTextField();
		txtKhachHang_TimKiem.setBounds(100, 400, 200, 30);
		txtKhachHang_TimKiem.setColumns(10);
		cardQuanLyKhachHang.add(txtKhachHang_TimKiem);
		
		JButton btnKhachHang_TimKiem = new JButton("TÃ¬m\r\n");
		btnKhachHang_TimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<KhachHangDTO> listKQ;
				Object[] options = {
			            "Tìm kiếm theo mã khách hàng","Tìm kiếm theo họ khách hàng", "Tìm kiếm theo tên khách hàng", "Đóng"
			        };
			        int select = JOptionPane.showOptionDialog(btnTourSearch, "Bạn muốn tìm kiếm theo phương thức nào?", "Tùy chọn", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[3]);
			        
			        //System.out.println("select: " + select);
			        //mÃ£ -> select: 0
			        //tÃªn -> select: 1
			        // chi phi -> select: 2
			        // Ä‘Ã³ng -> select: 3
			        
			        if(select == 0){
			            String input = JOptionPane.showInputDialog(btnTourSearch, "Mời bạn nhập mã khách hàng !");
			            
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
			                JOptionPane.showMessageDialog(null, "Lỗi tìm kiếm !");
			            }
			        }
			        
			        if(select == 1){
			            String input = JOptionPane.showInputDialog(btnTourSearch, "Mời bạn nhập họ khách hàng !");
			            
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
			                JOptionPane.showMessageDialog(null, "Lỗi tìm kiếm !");
			            }
			        }
			        
			        if(select == 2){
			            String input = JOptionPane.showInputDialog(btnTourSearch, "Mời bạn nhập tên khách hàng !");
			            
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
			                JOptionPane.showMessageDialog(null, "Lỗi tìm kiếm !");
			            }
			        }
			}
		});
		btnKhachHang_TimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKhachHang_TimKiem.setBounds(310, 400, 80, 30);
		cardQuanLyKhachHang.add(btnKhachHang_TimKiem);
		
		JScrollPane khachHangScrollPane = new JScrollPane();
		khachHangScrollPane.setBounds(50, 450, 750, 300);
		cardQuanLyKhachHang.add(khachHangScrollPane);
		
		tblKhachHang = new JTable();
		tblKhachHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int indexRowSelected = tblHdv.getSelectedRow();
				
//				txtMaTour.setText((String) tourTblModel.getValueAt(indexRowSelected, 0));
//				txtTenTour.setText((String) tourTblModel.getValueAt(indexRowSelected, 1));
//				txtGiaVe.setText(String.valueOf( tourTblModel.getValueAt(indexRowSelected, 2) ));
//				txtMaKHTour.setText((String) tourTblModel.getValueAt(indexRowSelected, 3));
//				txtMaHD.setText((String) tourTblModel.getValueAt(indexRowSelected, 4));
			}
		});
		tblKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tblKhachHang.setRowHeight(50);
		String[] colNamesTblKhachHang = {"MÃ£ khÃ¡ch hÃ ng", "Há»� tÃªn khÃ¡ch hÃ ng", "Ä�á»‹a chá»‰", "Sá»‘ Ä‘iá»‡n thoáº¡i", "MÃ£ Ä‘oÃ n"};
		khachHangTblModel = new DefaultTableModel();
		tblKhachHang.setModel(khachHangTblModel);
		for(String colName : colNamesTblKhachHang) {
			khachHangTblModel.addColumn(colName);
		}
		loadTblKhachHang();
		
		khachHangScrollPane.setViewportView(tblKhachHang);
		tblKhachHang.setFillsViewportHeight(true);
		
		JButton btnKhachHang_TaiLai = new JButton("Táº£i láº¡i báº£ng");
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
		btnKhachHang_TaiLai.setBounds(820, 450, 200, 30);
		cardQuanLyKhachHang.add(btnKhachHang_TaiLai);
		
		JButton btnKhachHang_Xoa = new JButton("XÃ³a khÃ¡ch hÃ ng");
		btnKhachHang_Xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tblKhachHang.getSelectedRow();
				String maKH = (String) tblKhachHang.getValueAt(selectedRow, 0);
				
				khachHangBUS.deleteById(maKH);
				khachHangTblModel.removeRow(selectedRow);
			}
		});
		btnKhachHang_Xoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKhachHang_Xoa.setBounds(820, 500, 200, 30);;
		cardQuanLyKhachHang.add(btnKhachHang_Xoa);
		
		JButton btnKhachHang_ThemMoi = new JButton("ThÃªm khÃ¡ch hÃ ng");
		btnKhachHang_ThemMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardAddKhachHang");
			}
		});
		btnKhachHang_ThemMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKhachHang_ThemMoi.setBounds(820, 550, 200, 30);
		cardQuanLyKhachHang.add(btnKhachHang_ThemMoi);
		
		btnKhachHang_CapNhat = new JButton("Cáº­p nháº­t khÃ¡ch hÃ ng");
		addActionListenerBtnKhachHang_Update();
		btnKhachHang_CapNhat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKhachHang_CapNhat.setBounds(820, 600, 200, 30);
		cardQuanLyKhachHang.add(btnKhachHang_CapNhat);
		// ===== KHACH HANG LAYOUT END HERE =====
		
		// ===== ADD KHACH HANG LAYOUT START HERE =====
		JPanel cardAddKhachHang = new JPanel();
		cardsPane.add(cardAddKhachHang);
		cardAddKhachHang.setLayout(null);
		cardLayout.addLayoutComponent(cardAddKhachHang, "cardAddKhachHang");
		
		JLabel lblAddKhachHang_TieuDe = new JLabel("Trang thÃªm khÃ¡ch hÃ ng");
		lblAddKhachHang_TieuDe.setBounds(0, 0, 500, 100);
		lblAddKhachHang_TieuDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardAddKhachHang.add(lblAddKhachHang_TieuDe);
		
		JLabel lblAddMaKhachHang = new JLabel("Nháº­p mÃ£ KH:");
		lblAddMaKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddMaKhachHang.setBounds(50, 100, 200, 30);
		cardAddKhachHang.add(lblAddMaKhachHang);
		
		JTextField txtAddMaKhachHang = new JTextField();
		txtAddMaKhachHang.setColumns(10);
		txtAddMaKhachHang.setBounds(250, 100, 300, 30);
		cardAddKhachHang.add(txtAddMaKhachHang);
		
		JLabel lblAddHoTenKhachHang = new JLabel("Nháº­p há»� tÃªn KH:");
		lblAddHoTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddHoTenKhachHang.setBounds(50, 150, 200, 30);
		cardAddKhachHang.add(lblAddHoTenKhachHang);
		
		JTextField txtAddHoTenKhachHang = new JTextField();
		txtAddHoTenKhachHang.setColumns(10);
		txtAddHoTenKhachHang.setBounds(250, 150, 300, 30);
		cardAddKhachHang.add(txtAddHoTenKhachHang);
		
		JLabel lblAddDiaChiKhachHang = new JLabel("Nháº­p Ä‘á»‹a chá»‰ KH:");
		lblAddDiaChiKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddDiaChiKhachHang.setBounds(50, 200, 200, 30);
		cardAddKhachHang.add(lblAddDiaChiKhachHang);
		
		JTextField txtAddDiaChiKhachHang = new JTextField();
		txtAddDiaChiKhachHang.setColumns(10);
		txtAddDiaChiKhachHang.setBounds(250, 200, 300, 30);
		cardAddKhachHang.add(txtAddDiaChiKhachHang);
		
		JLabel lblAddSdtKhachHang = new JLabel("Nháº­p sá»‘ Ä‘iá»‡n thoáº¡i:");
		lblAddSdtKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddSdtKhachHang.setBounds(50, 250, 200, 30);
		cardAddKhachHang.add(lblAddSdtKhachHang);
		
		JTextField txtAddSdtKhachHang = new JTextField();
		txtAddSdtKhachHang.setColumns(10);
		txtAddSdtKhachHang.setBounds(250, 250, 300, 30);
		cardAddKhachHang.add(txtAddSdtKhachHang);
		
		JLabel lblAddMaDoanKhachHang = new JLabel("Chá»�n Ä‘oÃ n:");
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
		
		JButton btnAddKhachHang_ThemMoi = new JButton("ThÃªm má»›i");
		btnAddKhachHang_ThemMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		
		JButton btnAddKhachHang_QuayLai = new JButton("Quay láº¡i");
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
		
		JLabel lblUpdateKhachHangContent = new JLabel("Trang cáº­p nháº­t khÃ¡ch hÃ ng");
		lblUpdateKhachHangContent.setBounds(0, 0, 400, 100);
		lblUpdateKhachHangContent.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardUpdateKhachHang.add(lblUpdateKhachHangContent);
		
		JLabel lblUpdateMaKhachHang = new JLabel("Nháº­p mÃ£ KH:");
		lblUpdateMaKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateMaKhachHang.setBounds(50, 100, 150, 30);
		cardUpdateKhachHang.add(lblUpdateMaKhachHang);
		
		txtUpdateMaKhachHang = new JTextField();
		txtUpdateMaKhachHang.setColumns(10);
		txtUpdateMaKhachHang.setBounds(200, 100, 300, 30);
		cardUpdateKhachHang.add(txtUpdateMaKhachHang);
		
		JLabel lblUpdateHoTenKhachHang = new JLabel("Nháº­p há»� tÃªn KH:");
		lblUpdateHoTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateHoTenKhachHang.setBounds(50, 150, 150, 30);
		cardUpdateKhachHang.add(lblUpdateHoTenKhachHang);
		
		txtUpdateHoTenKhachHang = new JTextField();
		txtUpdateHoTenKhachHang.setColumns(10);
		txtUpdateHoTenKhachHang.setBounds(200, 150, 300, 30);
		cardUpdateKhachHang.add(txtUpdateHoTenKhachHang);
		
		JLabel lblUpdateDiaChiKhachHang = new JLabel("Nháº­p Ä‘á»‹a chá»‰ KH:");
		lblUpdateDiaChiKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateDiaChiKhachHang.setBounds(50, 200, 150, 30);
		cardUpdateKhachHang.add(lblUpdateDiaChiKhachHang);
		
		txtUpdateDiaChiKhachHang = new JTextField();
		txtUpdateDiaChiKhachHang.setColumns(10);
		txtUpdateDiaChiKhachHang.setBounds(200, 200, 300, 30);
		cardUpdateKhachHang.add(txtUpdateDiaChiKhachHang);
		
		JLabel lblUpdateSdtKhachHang = new JLabel("Nháº­p sá»‘ Ä‘iá»‡n thoáº¡i KH:");
		lblUpdateSdtKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateSdtKhachHang.setBounds(50, 250, 150, 30);
		cardUpdateKhachHang.add(lblUpdateSdtKhachHang);
		
		txtUpdateSdtKhachHang = new JTextField();
		txtUpdateSdtKhachHang.setColumns(10);
		txtUpdateSdtKhachHang.setBounds(200, 250, 300, 30);
		cardUpdateKhachHang.add(txtUpdateSdtKhachHang);
		
		JLabel lblUpdateMaDoanKhachHang = new JLabel("Nháº­p mÃ£ Ä‘oÃ n KH:");
		lblUpdateMaDoanKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateMaDoanKhachHang.setBounds(50, 300, 150, 30);
		cardUpdateKhachHang.add(lblUpdateMaDoanKhachHang);
		
		txtUpdateMaDoanKhachHang = new JTextField();
		txtUpdateMaDoanKhachHang.setColumns(10);
		txtUpdateMaDoanKhachHang.setBounds(200, 300, 300, 30);
		cardUpdateKhachHang.add(txtUpdateMaDoanKhachHang);
		
		JButton btnUpdateKhachHang_CapNhat = new JButton("Cáº­p nháº­t");
		btnUpdateKhachHang_CapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		
		JButton btnUpdateKhachHang_QuayLai = new JButton("Quay láº¡i");
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
		
		JLabel lblHopDong_TieuDe = new JLabel("Trang quáº£n lÃ½ há»£p Ä‘á»“ng");
		lblHopDong_TieuDe.setBounds(0, 0, 500, 100);
		lblHopDong_TieuDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardQuanLyHopDong.add(lblHopDong_TieuDe);
		
		JLabel lblHopDong_TimKiem = new JLabel("TÃ¬m kiáº¿m:");
		lblHopDong_TimKiem.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblHopDong_TimKiem.setBounds(20, 400, 80, 30);
		cardQuanLyHopDong.add(lblHopDong_TimKiem);
		
		JTextField txtHopDong_TimKiem = new JTextField();
		txtHopDong_TimKiem.setBounds(100, 400, 200, 30);
		txtHopDong_TimKiem.setColumns(10);
		cardQuanLyHopDong.add(txtHopDong_TimKiem);
		
		JButton btnHopDong_TimKiem = new JButton("TÃ¬m\r\n");
		
		btnHopDong_TimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<HopDongDTO> listKQ;
				
			            String input = JOptionPane.showInputDialog(btnTourSearch, "Mời bạn nhập mã Tour !");
			            
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
		String[] colNamesTblHopDong = {"MÃ£ há»£p Ä‘á»“ng", "NgÃ y láº­p há»£p Ä‘á»“ng", "Ná»™i dung", "MÃ£ tour"};
		hopDongTblModel = new DefaultTableModel();
		tblHopDong.setModel(hopDongTblModel);
		for(String colName : colNamesTblHopDong) {
			hopDongTblModel.addColumn(colName);
		}
		loadTblHopDong();
		
		HopDongScrollPane.setViewportView(tblHopDong);
		tblHopDong.setFillsViewportHeight(true);
		
		JButton btnHopDong_QuayLai = new JButton("Quay láº¡i");
		btnHopDong_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyTour");
			}
		});
		btnHopDong_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHopDong_QuayLai.setBounds(50, 750, 100, 30);
		cardQuanLyHopDong.add(btnHopDong_QuayLai);
		
		JButton btnHopDong_TaiLai = new JButton("Táº£i láº¡i báº£ng");
		btnHopDong_TaiLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hopDongTblModel.setRowCount(0);
				loadTblHopDong();
			}
		});
		btnHopDong_TaiLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHopDong_TaiLai.setBounds(820, 450, 200, 30);
		cardQuanLyHopDong.add(btnHopDong_TaiLai);
		
		JButton btnHopDong_Xoa = new JButton("XÃ³a há»£p Ä‘á»“ng");
		btnHopDong_Xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tblHopDong.getSelectedRow();
				String maKH = (String) tblHopDong.getValueAt(selectedRow, 0);
				
				hopDongBUS.deleteById(maKH);
				hopDongTblModel.removeRow(selectedRow);
				HopDongBUS.listHopDongDTO.remove(selectedRow);
			}
		});
		btnHopDong_Xoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHopDong_Xoa.setBounds(820, 500, 200, 30);;
		cardQuanLyHopDong.add(btnHopDong_Xoa);
		
		btnHopDong_CapNhat = new JButton("Cáº­p nháº­t há»£p Ä‘á»“ng");
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
		
		JLabel lblAddHopDong_TieuDe = new JLabel("Trang thÃªm há»£p Ä‘á»“ng");
		lblAddHopDong_TieuDe.setBounds(0, 0, 500, 100);
		lblAddHopDong_TieuDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardAddHopDong.add(lblAddHopDong_TieuDe);
		
		JLabel lblAddMaHopDong = new JLabel("Nháº­p mÃ£ HD:");
		lblAddMaHopDong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddMaHopDong.setBounds(50, 100, 200, 30);
		cardAddHopDong.add(lblAddMaHopDong);
		
		JTextField txtAddMaHopDong = new JTextField();
		txtAddMaHopDong.setColumns(10);
		txtAddMaHopDong.setBounds(250, 100, 300, 30);
		cardAddHopDong.add(txtAddMaHopDong);
		
		JLabel lblAddNgayLapHopDong = new JLabel("Nháº­p ngÃ y láº­p HD:");
		lblAddNgayLapHopDong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddNgayLapHopDong.setBounds(50, 150, 200, 30);
		cardAddHopDong.add(lblAddNgayLapHopDong);
		
		JTextField txtAddNgayLapHopDong = new JTextField();
		txtAddNgayLapHopDong.setColumns(10);
		txtAddNgayLapHopDong.setBounds(250, 150, 300, 30);
		cardAddHopDong.add(txtAddNgayLapHopDong);
		
		JLabel lblAddNoiDung = new JLabel("Nháº­p ná»™i dung há»£p Ä‘á»“ng:");
		lblAddNoiDung.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddNoiDung.setBounds(50, 200, 200, 30);
		cardAddHopDong.add(lblAddNoiDung);
		
		JTextField txtAddNoiDung = new JTextField();
		txtAddNoiDung.setColumns(10);
		txtAddNoiDung.setBounds(250, 200, 300, 30);
		cardAddHopDong.add(txtAddNoiDung);
		
		JLabel lblAddHD_MaTour = new JLabel("Nháº­p mÃ£ tour:");
		lblAddHD_MaTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddHD_MaTour.setBounds(50, 250, 200, 30);
		cardAddHopDong.add(lblAddHD_MaTour);
		
		JTextField txtAddHD_MaTour = new JTextField();
		txtAddHD_MaTour.setColumns(10);
		txtAddHD_MaTour.setBounds(250, 250, 300, 30);
		cardAddHopDong.add(txtAddHD_MaTour);
		
		JButton btnAddHopDong_ThemMoi = new JButton("ThÃªm má»›i");
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
		
		JButton btnAddHopDong_QuayLai = new JButton("Quay láº¡i");
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
		
		JLabel lblUpdateHopDong_TieuDe = new JLabel("Trang cáº­p nháº­t há»£p Ä‘á»“ng");
		lblUpdateHopDong_TieuDe.setBounds(0, 0, 400, 100);
		lblUpdateHopDong_TieuDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardUpdateHopDong.add(lblUpdateHopDong_TieuDe);
		
		JLabel lblUpdateMaHD = new JLabel("Nháº­p mÃ£ HD:");
		lblUpdateMaHD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateMaHD.setBounds(50, 100, 150, 30);
		cardUpdateHopDong.add(lblUpdateMaHD);
		
		txtUpdateMaHD = new JTextField();
		txtUpdateMaHD.setColumns(10);
		txtUpdateMaHD.setBounds(200, 100, 300, 30);
		cardUpdateHopDong.add(txtUpdateMaHD);
		
		JLabel lblUpdateNgayLapHD = new JLabel("Nháº­p ngÃ y láº­p HD:");
		lblUpdateNgayLapHD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateNgayLapHD.setBounds(50, 150, 150, 30);
		cardUpdateHopDong.add(lblUpdateNgayLapHD);
		
		txtUpdateNgayLapHD = new JTextField();
		txtUpdateNgayLapHD.setColumns(10);
		txtUpdateNgayLapHD.setBounds(200, 150, 300, 30);
		cardUpdateHopDong.add(txtUpdateNgayLapHD);
		
		JLabel lblUpdateNoiDung = new JLabel("Nháº­p ná»™i dung:");
		lblUpdateNoiDung.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateNoiDung.setBounds(50, 200, 150, 30);
		cardUpdateHopDong.add(lblUpdateNoiDung);

		txtUpdateNoiDungHD = new JTextField();
		txtUpdateNoiDungHD.setColumns(10);
		txtUpdateNoiDungHD.setBounds(200, 200, 300, 30);
		cardUpdateHopDong.add(txtUpdateNoiDungHD);
		
		JLabel lblUpdateHD_MaTour = new JLabel("Nháº­p mÃ£ tour:");
		lblUpdateHD_MaTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateHD_MaTour.setBounds(50, 250, 150, 30);
		cardUpdateHopDong.add(lblUpdateHD_MaTour);

		txtUpdateHD_MaTour = new JTextField();
		txtUpdateHD_MaTour.setColumns(10);
		txtUpdateHD_MaTour.setBounds(200, 250, 300, 30);
		cardUpdateHopDong.add(txtUpdateHD_MaTour);
		
		JButton btnUpdateHopDong_CapNhat = new JButton("Cáº­p nháº­t");
		btnUpdateHopDong_CapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		
		JButton btnUpdateHopDong_QuayLai = new JButton("Quay láº¡i");
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
		
		JLabel lblDoan_TieuDe = new JLabel("Trang quáº£n lÃ½ Ä‘oÃ n");
		lblDoan_TieuDe.setBounds(0, 0, 500, 100);
		lblDoan_TieuDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardQuanLyDoan.add(lblDoan_TieuDe);
		
		JLabel lblDoan_TimKiem = new JLabel("TÃ¬m kiáº¿m:");
		lblDoan_TimKiem.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblDoan_TimKiem.setBounds(20, 400, 80, 30);
		cardQuanLyDoan.add(lblDoan_TimKiem);
		
		JTextField txtDoan_TimKiem = new JTextField();
		txtDoan_TimKiem.setBounds(100, 400, 200, 30);
		txtDoan_TimKiem.setColumns(10);
		cardQuanLyDoan.add(txtDoan_TimKiem);
		
//		JButton btnDoan_TimKiem = new JButton("TÃ¬m\r\n");
//		btnDoan_TimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		btnDoan_TimKiem.setBounds(310, 400, 80, 30);
//		cardQuanLyDoan.add(btnDoan_TimKiem);
		
		JScrollPane DoanScrollPane = new JScrollPane();
		DoanScrollPane.setBounds(50, 450, 750, 273);
		cardQuanLyDoan.add(DoanScrollPane);
		
		tblDoan = new JTable();
		tblDoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tblDoan.setRowHeight(50);
		String[] colNamesTblDoan = {"MÃ£ Ä‘oÃ n", "Sá»‘ ngÆ°á»�i", "MÃ£ tour", "MÃ£ HDV"};
		doanTblModel = new DefaultTableModel();
		tblDoan.setModel(doanTblModel);
		for(String colName : colNamesTblDoan) {
			doanTblModel.addColumn(colName);
		}
		loadTblDoan();
		
		DoanScrollPane.setViewportView(tblDoan);
		tblDoan.setFillsViewportHeight(true);
		
		JButton btnDoan_QuayLai = new JButton("Quay láº¡i");
		btnDoan_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyTour");
			}
		});
		btnDoan_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDoan_QuayLai.setBounds(50, 750, 100, 30);
		cardQuanLyDoan.add(btnDoan_QuayLai);
		
		JButton btnDoan_TaiLai = new JButton("Táº£i láº¡i báº£ng");
		btnDoan_TaiLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doanTblModel.setRowCount(0);
				loadTblDoan();
			}
		});
		btnDoan_TaiLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDoan_TaiLai.setBounds(820, 450, 200, 30);
		cardQuanLyDoan.add(btnDoan_TaiLai);
		
		JButton btnDoan_Xoa = new JButton("XÃ³a Ä‘oÃ n");
		btnDoan_Xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tblDoan.getSelectedRow();
				String maDoan = (String) tblDoan.getValueAt(selectedRow, 0);
				
				doanBUS.deleteById(maDoan);
				doanTblModel.removeRow(selectedRow);
				DoanBUS.listDoanDTO.remove(selectedRow);
			}
		});
		btnDoan_Xoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDoan_Xoa.setBounds(820, 500, 200, 30);;
		cardQuanLyDoan.add(btnDoan_Xoa);
		
		btnDoan_CapNhat = new JButton("Cáº­p nháº­t Ä‘oÃ n");
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
		
		JLabel lblAddDoan_TieuDe = new JLabel("Trang thÃªm há»£p Ä‘á»“ng");
		lblAddDoan_TieuDe.setBounds(0, 0, 500, 100);
		lblAddDoan_TieuDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardAddDoan.add(lblAddDoan_TieuDe);
		
		JLabel lblAddMaDoan = new JLabel("Nháº­p mÃ£ Ä‘oÃ n:");
		lblAddMaDoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddMaDoan.setBounds(50, 100, 200, 30);
		cardAddDoan.add(lblAddMaDoan);
		
		JTextField txtAddMaDoan = new JTextField();
		txtAddMaDoan.setColumns(10);
		txtAddMaDoan.setBounds(250, 100, 300, 30);
		cardAddDoan.add(txtAddMaDoan);
		
		JLabel lblAddSoNguoi = new JLabel("Nháº­p sá»‘ ngÆ°á»�i:");
		lblAddSoNguoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddSoNguoi.setBounds(50, 150, 200, 30);
		cardAddDoan.add(lblAddSoNguoi);
		
		JTextField txtAddSoNguoi = new JTextField();
		txtAddSoNguoi.setColumns(10);
		txtAddSoNguoi.setBounds(250, 150, 300, 30);
		cardAddDoan.add(txtAddSoNguoi);
		
		JLabel lblAddDoan_MaTour = new JLabel("Nháº­p mÃ£ tour:");
		lblAddDoan_MaTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddDoan_MaTour.setBounds(50, 200, 200, 30);
		cardAddDoan.add(lblAddDoan_MaTour);
		
		JTextField txtAddDoan_MaTour = new JTextField();
		txtAddDoan_MaTour.setColumns(10);
		txtAddDoan_MaTour.setBounds(250, 200, 300, 30);
		cardAddDoan.add(txtAddDoan_MaTour);
		
		JButton btnAddDoan_ThemMoi = new JButton("ThÃªm má»›i");
		btnAddDoan_ThemMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoanDTO dto = new DoanDTO();
				
				dto.setMaDoan(txtAddMaDoan.getText());
				dto.setSoNguoi(Integer.valueOf(txtAddSoNguoi.getText()));
				dto.setMaTour(txtAddHD_MaTour.getText());
				
				doanBUS.add(dto);
				DoanBUS.listDoanDTO.add(dto);
				addRowTblDoan(dto);
				cardLayout.show(cardsPane, "cardQuanLyDoan");
				// clear all text after add
				txtAddMaDoan.setText("");
				txtAddSoNguoi.setText("");
				txtAddMaTour.setText("");
			}
		});
		btnAddDoan_ThemMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddDoan_ThemMoi.setBounds(150, 250, 120, 30);
		cardAddDoan.add(btnAddDoan_ThemMoi);
		
		JButton btnAddDoan_QuayLai = new JButton("Quay láº¡i");
		btnAddDoan_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyTour");
			}
		});
		btnAddDoan_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddDoan_QuayLai.setBounds(300, 250, 120, 30);
		cardAddDoan.add(btnAddDoan_QuayLai);
		// ===== ADD DOAN LAYOUT END HERE ======
		
		// ===== UPDATE DOAN LAYOUT START HERE =====
		JPanel cardUpdateDoan = new JPanel();
		cardsPane.add(cardUpdateDoan);
		cardUpdateDoan.setLayout(null);
		cardLayout.addLayoutComponent(cardUpdateDoan, "cardUpdateDoan");
		
		JLabel lblUpdateDoan_TieuDe = new JLabel("Trang cáº­p nháº­t Ä‘oÃ n");
		lblUpdateDoan_TieuDe.setBounds(0, 0, 400, 100);
		lblUpdateDoan_TieuDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		cardUpdateDoan.add(lblUpdateDoan_TieuDe);
		
		JLabel lblUpdateMaDoan = new JLabel("Nháº­p mÃ£ Ä‘oÃ n:");
		lblUpdateMaDoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateMaDoan.setBounds(50, 100, 150, 30);
		cardUpdateDoan.add(lblUpdateMaDoan);
		
		txtUpdateMaDoan = new JTextField();
		txtUpdateMaDoan.setColumns(10);
		txtUpdateMaDoan.setBounds(200, 100, 300, 30);
		cardUpdateDoan.add(txtUpdateMaDoan);
		
		JLabel lblUpdateSoNguoi = new JLabel("Nháº­p sá»‘ ngÆ°á»�i :");
		lblUpdateSoNguoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateSoNguoi.setBounds(50, 150, 150, 30);
		cardUpdateDoan.add(lblUpdateSoNguoi);
		
		txtUpdateSoNguoi = new JTextField();
		txtUpdateSoNguoi.setColumns(10);
		txtUpdateSoNguoi.setBounds(200, 150, 300, 30);
		cardUpdateDoan.add(txtUpdateSoNguoi);
		
		JLabel lblUpdateDoan_MaTour = new JLabel("Nháº­p mÃ£ tour:");
		lblUpdateDoan_MaTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdateDoan_MaTour.setBounds(50, 200, 150, 30);
		cardUpdateDoan.add(lblUpdateDoan_MaTour);

		txtUpdateDoan_MaTour = new JTextField();
		txtUpdateDoan_MaTour.setColumns(10);
		txtUpdateDoan_MaTour.setBounds(200, 200, 300, 30);
		cardUpdateDoan.add(txtUpdateDoan_MaTour);
		
		JButton btnUpdateDoan_CapNhat = new JButton("Cáº­p nháº­t");
		btnUpdateDoan_CapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoanDTO dto = new DoanDTO();
				
				dto.setMaDoan(txtUpdateMaDoan.getText());
				dto.setSoNguoi(Integer.valueOf(txtUpdateNgayLapHD.getText()));
				dto.setMaTour(txtUpdateDoan_MaTour.getText());
				
				doanBUS.update(dto);
				DoanBUS.listDoanDTO.set(selectedRow, dto);
				setRow(dto, selectedRow);
				cardLayout.show(cardsPane, "cardQuanLyDoan");
				reloadTblTour_Doan(dto);
				// clear all text after update
				txtUpdateMaDoan.setText("");
				txtUpdateSoNguoi.setText("");
				txtUpdateDoan_MaTour.setText("");
			}
		});
		btnUpdateDoan_CapNhat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateDoan_CapNhat.setBounds(150, 250, 120, 30);
		cardUpdateDoan.add(btnUpdateDoan_CapNhat);
		
		JButton btnUpdateDoan_QuayLai = new JButton("Quay láº¡i");
		btnUpdateDoan_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardQuanLyDoan");
			}
		});
		btnUpdateDoan_QuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateDoan_QuayLai.setBounds(300, 250, 100, 30);
		cardUpdateDoan.add(btnUpdateDoan_QuayLai);
		// ===== UPDATE DOAN LAYOUT END HERE
	}

	public void loadTblTaiKhoan() {
		for(TaiKhoanDTO taiKhoan : TaiKhoanBUS.listTaiKhoanDTO) {
			String tenQuyen = null;
			if(taiKhoan.getQuyen() == 0) {
				tenQuyen = "Quáº£n trá»‹ viÃªn";
			}
			else if(taiKhoan.getQuyen() == 1) {
				tenQuyen = "NhÃ¢n viÃªn";
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
				doan.getMaDoan(), doan.getSoNguoi(), doan.getMaTour()
		});
	}
	
	public void addRow(TaiKhoanDTO dto) {
		Vector<String> rowData = new Vector<String>();
		String tenQuyen = null;
		if(dto.getQuyen() == 0) {
			tenQuyen = "Quáº£n trá»‹ viÃªn";
		}
		else if(dto.getQuyen() == 1) {
			tenQuyen = "NhÃ¢n viÃªn";
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
		
		doanTblModel.addRow(rowData);
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
	
	public void setRow(TaiKhoanDTO dto, int selectedRow) {
		String tenQuyen = null;
		if(dto.getQuyen() == 0) {
			tenQuyen = "Quáº£n trá»‹ viÃªn";
		}
		else if(dto.getQuyen() == 1) {
			tenQuyen = "NhÃ¢n viÃªn";
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
	}

    public static Application getAppInstance() {
        if(appInstance == null) 
            appInstance = new Application();
        return appInstance;
    }
    
    private void addActionListenerBtnTaiKhoan_Update() {
		btnTaiKhoan_Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardUpdateTaiKhoan");
				selectedRow = tblTaiKhoan.getSelectedRow();
				String quyen = (String) tblTaiKhoan.getValueAt(selectedRow, 2);
				txtUpdateTenTaiKhoan.setText((String) tblTaiKhoan.getValueAt(selectedRow, 0));
				txtUpdateMatKhau.setText((String) tblTaiKhoan.getValueAt(selectedRow, 1));
				if(quyen.equals("Quáº£n trá»‹ viÃªn")) {
					rBtnUpdateQuanTriVien.setSelected(true);
				}	
				else if(quyen.equals("NhÃ¢n viÃªn")) {
					rBtnUpdateNhanVien.setSelected(true);
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
				cardLayout.show(cardsPane, "cardUpdateKhachHang");
				selectedRow = tblKhachHang.getSelectedRow();
				
				txtUpdateMaKhachHang.setText((String) tblKhachHang.getValueAt(selectedRow, 0));
				txtUpdateHoTenKhachHang.setText((String) tblKhachHang.getValueAt(selectedRow, 1));
				txtUpdateDiaChiKhachHang.setText((String) tblKhachHang.getValueAt(selectedRow, 2));
				txtUpdateSdtKhachHang.setText((String) tblKhachHang.getValueAt(selectedRow, 3));
				txtUpdateMaDoanKhachHang.setText((String) tblKhachHang.getValueAt(selectedRow, 4));
			}
		});
    }
    
    private void addActionListenerBtnHopDong_CapNhat() {
		btnHopDong_CapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardUpdateHopDong");
				selectedRow = tblHopDong.getSelectedRow();
				
				txtUpdateMaHD.setText((String) tblHopDong.getValueAt(selectedRow, 0));
				txtUpdateNgayLapHD.setText((String) tblHopDong.getValueAt(selectedRow, 1));
				txtUpdateNoiDungHD.setText((String) tblHopDong.getValueAt(selectedRow, 2));
				txtUpdateHD_MaTour.setText((String) tblHopDong.getValueAt(selectedRow, 3));
			}
		});
    }
    
    private void addActionListenerBtnDoan_CapNhat() {
		btnDoan_CapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardsPane, "cardUpdateDoan");
				selectedRow = tblDoan.getSelectedRow();

				txtUpdateMaDoan.setText((String) tblDoan.getValueAt(selectedRow, 0));
				txtUpdateSoNguoi.setText((String) tblDoan.getValueAt(selectedRow, 1));
				txtUpdateDoan_MaTour.setText((String) tblDoan.getValueAt(selectedRow, 2));
			}
		});
    }
}
