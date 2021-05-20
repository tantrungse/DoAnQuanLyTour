package com.myclass.gui;



import java.awt.BorderLayout;
import java.awt.EventQueue;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.myclass.bus.ChuongTrinhKMBUS;
import com.myclass.dao.ChuongTrinhKMDAO;
import com.myclass.dto.ChuongTrinhKMDTO;

import Excel.DocExcel;
import Excel.XuatExcel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.JScrollPane;

import javax.swing.JTable;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ChuongTrinhKMFrame extends JFrame {

	ArrayList<ChuongTrinhKMDTO> listKMGUI =new ArrayList<ChuongTrinhKMDTO>();
	DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private JPanel contentPane;
	private JTextField txtMakm ;
	private JTextField txtNoidung ;
	private JTextField txtDateend ;
	private JTextField txtDatestart ;
	   private static DatePicker dp1,dp2;
	private JScrollPane scrollPane ;
private DefaultTableModel model =new DefaultTableModel();
JTable tblDSSV =new JTable();
private JTextField txtTentour;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChuongTrinhKMFrame frame = new ChuongTrinhKMFrame();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public ChuongTrinhKMFrame() {
		
		
	  
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(255,204,204));
		contentPane.setLayout(null);
		
		//nút nhập,xuất file excel 
		   JButton NhapExcel=new JButton("Nhập Excel");
		   NhapExcel.setIcon(new ImageIcon(this.getClass().getResource("/Images/Icon/xls-30.png")));
		   NhapExcel.setFont(new Font("Segoe UI", 0, 14));
		   NhapExcel.setBorder(BorderFactory.createLineBorder(Color.decode("#90CAF9"), 1));
		   NhapExcel.setBackground(Color.decode("#90CAF9"));
		   NhapExcel.setBounds(631, 90, 140, 38);
		   NhapExcel.addMouseListener(new MouseAdapter(){
		       @Override
		       public void mousePressed(MouseEvent evt){
			           NhapExcel_click(evt);
			           model.setRowCount(0);
			           outModel();
		       }
		   });
		   
		   JButton XuatExcel=new JButton("Xuất Excel");
		   XuatExcel.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
		   	}
		   });
		   XuatExcel.setIcon(new ImageIcon(this.getClass().getResource("/Images/Icon/xls-30.png")));
		   XuatExcel.setFont(new Font("Segoe UI", 0, 14));
		   XuatExcel.setBorder(BorderFactory.createLineBorder(Color.decode("#90CAF9"), 1));
		   XuatExcel.setBackground(Color.decode("#90CAF9"));
		   XuatExcel.setBounds(780, 90, 147, 38);
		   XuatExcel.addMouseListener(new MouseAdapter(){
		       @Override
		       public void mousePressed(MouseEvent evt){
		      XuatExcel_click(evt);
		       }
		   });
		   contentPane.add(XuatExcel);
		   contentPane.add(NhapExcel);
		
		
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(new Color(255,204,204));
		panel3.setBounds(607, 556, 272, 54);
		contentPane.add(panel3);
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 5));
		
		txtMakm = new JTextField();
		txtMakm.setBounds(462, 95, 159, 33);
		contentPane.add(txtMakm);
		txtMakm.setColumns(10);
		
		txtNoidung = new JTextField();
		txtNoidung.setBounds(462, 188, 159, 87);
		txtNoidung.setColumns(10);
		contentPane.add(txtNoidung);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(52, 286, 875, 182);
		contentPane.add(panel1);
		panel1.setLayout(null);
		 scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 0, 874, 182);
			panel1.add(scrollPane);
		
		JButton btnNhaplai = new JButton("Nh\u1EADp l\u1EA1i");
		btnNhaplai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMakm.setEditable(true);
				txtMakm.setText("");
				
				txtTentour.setText("");
				txtNoidung.setText("");
				txtDatestart.setText("");
				txtDateend.setText("");
				list();
				
			}
		});
		
		btnNhaplai.setIcon(new ImageIcon("C:\\Users\\Minh\\OneDrive\\Hình ảnh\\refresh_32px.png"));
		btnNhaplai.setBackground(new Color(255, 255, 0));
		btnNhaplai.setForeground(new Color(255, 0, 0));
		btnNhaplai.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel3.add(btnNhaplai);
		
		JButton btnThoat = new JButton("Tr\u1EDF v\u1EC1");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int reponse=JOptionPane.showConfirmDialog(rootPane, "Do you want to exit ?","Exit",JOptionPane.YES_NO_OPTION);
	        	if(reponse==0)
	        	{
	        		System.exit(0);
	        	}else
	        	{
	        		return;
	        	}	
			}
		});
		btnThoat.setIcon(new ImageIcon("C:\\Users\\Minh\\OneDrive\\Hình ảnh\\shutdown_32px.png"));
		btnThoat.setBackground(new Color(255, 255, 0));
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThoat.setForeground(new Color(255, 0, 0));
		panel3.add(btnThoat);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(121, 479, 747, 68);
		contentPane.add(panel2);
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));
		panel2.setBackground(new Color(255,204,204));
		
		
		txtTentour = new JTextField();
		txtTentour.setColumns(10);
		txtTentour.setBounds(462, 144, 159, 33);
		contentPane.add(txtTentour);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("<html>\r\n<body>\r\n<p>Ng\u00E0y h\u1EBFt hi\u1EC7u<br/> l\u1EF1c khuy\u1EBFn m\u00E3i</p>\r\n</body>\r\n</html>");
		lblNewLabel_1_2_1.setBounds(641, 221, 107, 50);
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1_2_1);
		
		txtDateend = new JTextField();
		txtDateend.setBounds(758, 238, 122, 26);
		txtDateend.setColumns(10);
		contentPane.add(txtDateend);
		
		
	     DatePickerSettings pickerSetting = new DatePickerSettings();
	        pickerSetting.setVisibleDateTextField(false);

	 dp1 = new DatePicker(pickerSetting);        
	 dp1.setBounds(890, 185, 35, 30);
	        dp1.setDateToToday();    

	  JButton calendar3=dp1.getComponentToggleCalendarButton();
	        calendar3.setText("");
	        calendar3.setIcon(new ImageIcon(this.getClass().getResource("/Images/Icon/calendar-30.png")));
	        calendar3.setBorder(BorderFactory.createLineBorder(Color.decode("#90CAF9"), 1));
	        contentPane.add(dp1);
	        dp1.addDateChangeListener((dce) -> {
	        	String k =  dp1.getDateStringOrEmptyString();
	            txtDatestart.setText(k);
	        });
	        
	    //calendar 2    
		     DatePickerSettings pickerSetting1 = new DatePickerSettings();
		        pickerSetting1.setVisibleDateTextField(false);

		 dp2 = new DatePicker(pickerSetting1);        
		 dp2.setBounds(890, 235, 35, 30);
		        dp2.setDateToToday();    



		  JButton calendar=dp2.getComponentToggleCalendarButton();
		        calendar.setText("");
		        calendar.setIcon(new ImageIcon(this.getClass().getResource("/Images/Icon/calendar-30.png")));
		        calendar.setBorder(BorderFactory.createLineBorder(Color.decode("#90CAF9"), 1));
		        contentPane.add(dp2);
		        dp2.addDateChangeListener((dce) -> {
		        	String k =  dp2.getDateStringOrEmptyString();
		          txtDateend.setText(k);
		        });
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("<html>\r\n<body>\r\n<p>Ng\u00E0y b\u1EAFt \u0111\u1EA7u<br/> khuy\u1EBFn m\u00E3i</p>\r\n</body>\r\n</html>");
		lblNewLabel_1_2_1_1.setBounds(631, 163, 107, 50);
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1_2_1_1);
		
		txtDatestart = new JTextField();
		txtDatestart.setBounds(757, 187, 122, 26);
		txtDatestart.setColumns(10);
		contentPane.add(txtDatestart);
		
		JButton btnThem = new JButton("Th\u00EAm");
		btnThem.setIcon(new ImageIcon("C:\\Users\\Minh\\OneDrive\\Hình ảnh\\add_32px.png"));
	//	btnThem.setSelectedIcon(new ImageIcon(ChuongTrinhKMFrame.class.getResource("/IMG/icons8_add_48px.png")));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				SimpleDateFormat ft=new SimpleDateFormat("dd/MM/yyyy");
				ChuongTrinhKMBUS ct =new ChuongTrinhKMBUS();
				  String makm = txtMakm.getText();
                
                  String tentour = txtTentour.getText();
                  String noidung= txtNoidung.getText();
              
				
	if(txtMakm.getText().isEmpty()  || txtTentour.getText().isEmpty() || txtNoidung.getText().isEmpty() || (txtDatestart.getText()).isEmpty() || (txtDateend.getText()).isEmpty())
	{
		JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
		return;
	}else {
	    LocalDate dayend=  LocalDate.parse(txtDateend.getText(),formatter2);
        LocalDate daystart= LocalDate.parse(txtDatestart.getText(),formatter2);
		
		if(kiemTraNgayThangNam(String.valueOf(daystart))==2)
		{
			JOptionPane.showMessageDialog(null,"Ngày tháng năm không hợp lệ , vui lòng nhập theo định dạng yyyy/MM/dd !!!");
			
			txtDatestart.setText("");
			txtDatestart.requestFocus();
			return;
		}
		if( kiemTraNgayThangNam(String.valueOf(dayend))==2)
		{
JOptionPane.showMessageDialog(null,"Ngày tháng năm không hợp lệ , vui lòng nhập theo định dạng yyyy/MM/dd !!!");
			
			txtDateend.setText("");
			txtDateend.requestFocus();
			return;
		}
	     if(!ct.checkngay(daystart, dayend)) {
         	JOptionPane.showMessageDialog(null, "Ngày tháng năm không hợp lệ!!!");
         	return;
         }
		 if(ChuongTrinhKMBUS.check(makm))
         {
             JOptionPane.showMessageDialog(null, "Mã khuyến mãi đă tồn tại !!!");
             return;
         } else
         {
        	
        	 //thêm
        	 ChuongTrinhKMDTO ctkm =new ChuongTrinhKMDTO(makm,tentour,noidung, daystart,dayend);
        	 ChuongTrinhKMBUS.add(ctkm);
        	
			
		     Vector header = new Vector();
		        header.add("Mã KM");
		 
		        header.add("Tên chương trình KM");
		        header.add("Nội dung");
		        header.add("Ngày bắt đầu");
		        header.add("Ngày kết thúc");
		    
		        if (model.getRowCount()==0)
		        {
		            
		            model = new DefaultTableModel(header, 0);
		        }
		        Vector row=new Vector();
		        row.add(ctkm.getMaKM());
		       
		        row.add(ctkm.getTenTourKM());
		        row.add("Giảm " + ctkm.getNoidungKM() + "%");
		        row.add(formatter1.format(ctkm.getTimeStartKM()));
		        row.add(formatter1.format( ctkm.getTimeEndKM()));
		        
		        model.addRow(row);
		       
		        tblDSSV.setModel(model);
         }
		                     
	}
			}
		});
	
		clickOnKey(btnThoat,"EXIT",KeyEvent.VK_ESCAPE);
		btnThem.setForeground(new Color(0, 139, 139));
		btnThem.setBackground(new Color(64, 224, 208));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel2.add(btnThem);
		
		JButton btnSua = new JButton("S\u1EEDa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int j= tblDSSV.getSelectedRow();
			      String makm = txtMakm.getText();
		     
		            String tentour=txtTentour.getText();
		            String noidung=txtNoidung.getText();
		           
		            if(kiemTraNgayThangNam(String.valueOf(txtDatestart))==2 || kiemTraNgayThangNam(String.valueOf(txtDateend))==2)
		            {
		            	JOptionPane.showMessageDialog(null, "Ngày tháng năm không hợp lệ (yyyy/MM/dd)!!!");
		            	return;
		            }
		            LocalDate day1=LocalDate.parse(txtDatestart.getText());
		            LocalDate day2=LocalDate.parse(txtDateend.getText());
		            ChuongTrinhKMBUS ct =new ChuongTrinhKMBUS();
		            if(!ct.checkngay(day1, day2)) {
		            	JOptionPane.showMessageDialog(null, "Ngày tháng năm không hợp lệ!!!");
		            	return;
		            }
		            ChuongTrinhKMDTO s= new ChuongTrinhKMDTO();
		            s.setMaKM(makm);
		           
		            s.setTenTourKM(tentour);
		            s.setNoidungKM(noidung);
		            s.setTimeStartKM(day1);
		            s.setTimeEndKM(day2);
				int reponse=JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn sửa?","Exit",JOptionPane.YES_NO_OPTION);
	        	if(reponse==0)
	        	{
	        	if(checksua(txtMakm.getText())<=1)
	        	{
	        		ChuongTrinhKMBUS.sua(s);
	        		 model.setValueAt(s.getMaKM(), j, 0);
	        	       
	        	        model.setValueAt(s.getTenTourKM(), j, 1);
	        	        model.setValueAt(s.getNoidungKM(), j, 2);
	        	        model.setValueAt(formatter1.format(s.getTimeStartKM()), j, 3);
	        	        model.setValueAt(formatter1.format(s.getTimeEndKM()), j, 4);
	        	        tblDSSV.setModel(model);
	        	        JOptionPane.showMessageDialog(null, "Sửa thành công!!!");
	        	}	else {
	        		JOptionPane.showMessageDialog(null, "Mã KM muốn sửa đã bị trùng !!!");
	        		return;
	        	}
	        		
	        		
	        	}else
	        	{
	        		return;
	        	}	
				
			}
		});
		btnSua.setIcon(new ImageIcon("C:\\Users\\Minh\\OneDrive\\Hình ảnh\\wrench_32px.png"));
	//	btnSua.setIcon(new ImageIcon(ChuongTrinhKMFrame.class.getResource("/IMG/icons8_wrench_32px_1.png")));
		btnSua.setBackground(new Color(64, 224, 208));
		btnSua.setForeground(new Color(0, 128, 128));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel2.add(btnSua);
		
		JButton btnXoa = new JButton("X\u00F3a");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int  i=tblDSSV.getSelectedRow();
				String makmxoa=txtMakm.getText();
				int reponse=JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn xóa?","Exit",JOptionPane.YES_NO_OPTION);
	        	if(reponse==0)
	        	{
	        		if(ChuongTrinhKMBUS.check(makmxoa)==true) {
	        		ChuongTrinhKMBUS.delete(makmxoa);
	        		model.removeRow(i);
	        		}
	        		else {
	        			JOptionPane.showMessageDialog(null,"Mã khuyến mãi muốn xóa không tồn tại!!!");
	        			return;
	        		}
	        	}else
	        	{
	        		return;
	        	}	
				
			}
		});
		btnXoa.setIcon(new ImageIcon("C:\\Users\\Minh\\OneDrive\\Hình ảnh\\close_window_32px.png"));
	//	btnXoa.setIcon(new ImageIcon(ChuongTrinhKMFrame.class.getResource("/IMG/icons8_close_window_32px.png")));
		btnXoa.setBackground(new Color(64, 224, 208));
		btnXoa.setForeground(new Color(0, 128, 128));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel2.add(btnXoa);
		
		JButton btnNewButton_3 = new JButton("T\u00ECm ki\u1EBFm");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = {
						"Search theo mã", "Seach theo tên","Cancel"
				};
				int c=JOptionPane.showOptionDialog(contentPane, "Tìm kiếm theo mã khuyến mãi hay tên chương trình KM","Tìm kiếm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,options,options[2]);
				if(c==1) {
				 String seach=JOptionPane.showInputDialog("Mời nhập tên chương trình khuyến mãi cần tìm");
				  if( seach== null) {
				
					  return;
				  }
				  else
				  {
					//  ChuongTrinhKMBUS.listtimkiemtheoten(seach);
			//ChuongTrinhKMBUS.timkiemtheoten(seach,model);
				//listSearchName(seach);
			
			outModelten(seach);
			
				  }
				}else if(c==0)
				{
					 String seach=JOptionPane.showInputDialog("Mời nhập mã khuyến mãi cần tìm");
					  if( seach== null) {
					
						  return;
					  }else
					  {
						 // timkiemtheoma(seach);
						 ChuongTrinhKMDTO ct =ChuongTrinhKMBUS.timMa(seach);      //tạo đối tượng để hứng bên BUS tìm kiếm theo mã
						 if(ct!=null) {
						   model.setRowCount(0);
				    	   Vector header = new Vector();
					        header.add("Mã KM");
					      
					        header.add("Tên chương trình KM");
					        header.add("Nội dung");
					        header.add("Ngày bắt đầu");
					        header.add("Ngày kết thúc");
					    
					        if (model.getRowCount()==0)
					        {
					            
					            model = new DefaultTableModel(header, 0);
					        }
					       
					    
					       
					          Vector	data = new Vector();
					        data.add(ct.getMaKM());
					       
					        data.add(ct.getTenTourKM());
					        data.add(ct.getNoidungKM());
					        data.add(formatter1.format(ct.getTimeStartKM()));
					        data.add(formatter1.format( ct.getTimeEndKM()));
					        model.addRow(data);
					        tblDSSV.setModel(model);
					  }else
					  {
						  JOptionPane.showMessageDialog(null, "Không tìm thấy hóa đơn cần tìm!!");
						  return;
					  }
					  }
				}else
				{
					return;
				}
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\Minh\\OneDrive\\Hình ảnh\\search_32px.png"));
		//btnNewButton_3.setIcon(new ImageIcon(ChuongTrinhKMFrame.class.getResource("/IMG/icons8_search_32px_2.png")));
		btnNewButton_3.setBackground(new Color(64, 224, 208));
		btnNewButton_3.setForeground(new Color(0, 128, 128));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3.setSelectedIcon(null);
		panel2.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(52, 22, 189, 212);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Minh\\OneDrive\\Hi\u0300nh a\u0309nh\\image.png"));
		contentPane.add(lblNewLabel);
		
		JLabel lbTieude = new JLabel("CH\u01AF\u01A0NG TR\u00CCNH KHUY\u1EBEN M\u00C3I");
		lbTieude.setBounds(394, 22, 420, 60);
		lbTieude.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lbTieude.setForeground(new Color(139, 0, 0));
		lbTieude.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lbTieude);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E3 khuy\u1EBFn m\u00E3i");
		lblNewLabel_1.setBounds(315, 92, 131, 33);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Gi\u00E1 tr\u1ECB % khuy\u1EBFn m\u00E3i");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(287, 207, 159, 47);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblNewLabel_1_1);
		
	
		   tblDSSV.addMouseListener(new MouseAdapter() {
		   	@Override
		   	public void mousePressed(MouseEvent e) {
		   		
		   	  int i = tblDSSV.getSelectedRow();
		   	 txtMakm.setEditable(false);
              txtMakm.setText(tblDSSV.getModel().getValueAt(i, 0).toString());
             
            txtTentour.setText(tblDSSV.getModel().getValueAt(i, 1).toString()); 
           txtNoidung.setText(tblDSSV.getModel().getValueAt(i, 2).toString());
             txtDatestart.setText( tblDSSV.getModel().getValueAt(i, 3).toString());    
             txtDateend.setText( tblDSSV.getModel().getValueAt(i, 4).toString());  
		   	}
		   });
		
		//táº¡o báº£ng
		   tblDSSV.setModel(new DefaultTableModel(
		        	new Object[][] {
		        		{null, null, null,null,null},
		        		{null, null, null,null,null},
		        		{null, null, null,null,null}
		        	},
		        	new String[] {
		        		"Mã khuyến mãi", "Tên chương trình KM","Nội dung khuyến mãi","Ngày bắt đầu","Ngày kết thúc"
		        	}
		        ));
		scrollPane.setViewportView(tblDSSV);
		
	ChuongTrinhKMBUS.list();
	outModel();
		
		JLabel lblNewLabel_1_3 = new JLabel("Tên chương trình KM");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setForeground(Color.BLACK);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(287, 150, 159, 33);
		contentPane.add(lblNewLabel_1_3);
	
		
	
	
	}
	
	   
	
	private Color Color(int i, int j, int k) {
		// TODO Auto-generated method stub
		return null;
	}
	 public void outModel() // Xuất ra Table từ ArrayList
	    {
		  Vector header = new Vector();
	        header.add("Mã KM");
	     
	        header.add("Tên chương trình KM");
	        header.add("Nội dung");
	        header.add("Ngày bắt đầu");
	        header.add("Ngày kết thúc");
	    
	        if (model.getRowCount()==0)
	        {
	            
	            model = new DefaultTableModel(header, 0);
	        }
	       
	    
	        for(ChuongTrinhKMDTO n:ChuongTrinhKMBUS.ctKMlist)
	        { 
	          Vector	data = new Vector();
	        data.add(n.getMaKM());
	       
	        data.add(n.getTenTourKM());
	        data.add("Giảm "+n.getNoidungKM()+"%");
	        data.add(formatter1.format(n.getTimeStartKM()));
	        data.add(formatter1.format( n.getTimeEndKM()));
	        model.addRow(data);
	        }
	    
			
			tblDSSV.setModel(model);
	    }
	    public void list() // Chép ArrayList lên table
	    {
	    	ChuongTrinhKMBUS ct =new ChuongTrinhKMBUS();
	        if(ct.getList()== null) ChuongTrinhKMBUS.list();
	        ArrayList<ChuongTrinhKMDTO> nv = ct.getList();
   model.setRowCount(0);
	        outModel();
	    }
	    public void outModelten(String search) // Xuất ra Table từ ArrayList tên đã tìm thấy
	    {
		  Vector header = new Vector();
	        header.add("Mã KM");
	  
	        header.add("Tên chương trình KM");
	        header.add("Nội dung");
	        header.add("Ngày bắt đầu");
	        header.add("Ngày kết thúc");
	    
	        if (model.getRowCount()==0)
	        {
	            
	            model = new DefaultTableModel(header, 0);
	        }
	       
	    ArrayList<ChuongTrinhKMDTO> listSearch =ChuongTrinhKMBUS.timkiemtheoten(search, model);
		if(listSearch.size()==0)
		{
			 JOptionPane.showMessageDialog(null,"Không tìm thấy tên tour!!");
			 return;
			 
		}
	        for(ChuongTrinhKMDTO n: listSearch)  //tk theo tên 
	        { 
	          Vector	data = new Vector();
	        data.add(n.getMaKM());
	       
	        data.add(n.getTenTourKM());
	        data.add("Giảm "+n.getNoidungKM()+"%");
	        data.add(formatter1.format(n.getTimeStartKM()));
	        data.add(formatter1.format(n.getTimeEndKM()));
	        model.addRow(data);
	        }
	    
			
			tblDSSV.setModel(model);
	    }
	    public void listSearchName(String tentk) // danh sách tên tìm kiếm
	    {
	       // if(ChuongTrinhKMBUS.getListtk()== null) ChuongTrinhKMBUS.li;
	      
   model.setRowCount(0);
	        outModelten(tentk);
	    }
		public int kiemTraNgayThangNam(String day) {  // Check ngày tháng năm theo form yyyy/MM/dd
		 int c=1;
		 String regex = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$";
				try {
					
					if (day.matches(regex) == true) {
						
						
					}
					else {
						
					c=2;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			return c;
		}
		public static void clickOnKey(  final AbstractButton button, String actionName, int key ) //tạo t exit bằng phím ESC
		{
		       button.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW )
		           .put( KeyStroke.getKeyStroke( key, 0 ), actionName );

		       button.getActionMap().put( actionName, new AbstractAction()
		       {
		           @Override
		           public void actionPerformed( ActionEvent e )
		           {
		        		int reponse=JOptionPane.showConfirmDialog(null, "Do you want to exit ?","Exit",JOptionPane.YES_NO_OPTION);
		            	if(reponse==0)
		            	{
		            		System.exit(0);
		            	}else
		            	{
		            		return;
		            	}
		           }
		       } );
		}
		public  int checksua(String ma) //tìm mã trong Jtable
		{
			int c=0;
			for(int i=0;i<tblDSSV.getRowCount();i++)
			{
				if(tblDSSV.getValueAt(i, 0).toString().equalsIgnoreCase(ma))
				{
					c++;
				}
			}
		    return c;
		}

	    protected void XuatExcel_click(MouseEvent evt){
	        new XuatExcel().xuatFileExcelKhuyenMai();
	    }
	    protected void NhapExcel_click(MouseEvent evt){
	        new DocExcel().docFileExcelKhuyenMai();
	    }
		
}
