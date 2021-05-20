package com.myclass.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.myclass.bus.ChuongTrinhKMBUS;
import com.myclass.bus.HoaDonBUS;
import com.myclass.bus.KhachHangBUS;
import com.myclass.dto.ChuongTrinhKMDTO;
import com.myclass.dto.HoaDonDTO;
import com.myclass.dto.KhachHangDTO;

import Excel.DocExcel;
import Excel.XuatExcel;
import Report.PDF;
import javax.swing.border.EtchedBorder;

public class HoaDonGUI1 extends JFrame {

	private JPanel contentPane;
	
    private static String array_HoaDon[]={"Mã hóa đơn","Mã khách hàng","Mã khuyến mãi","Ngày lập","Nội dung khuyến mãi","Tổng tiền(VNĐ)"};   
    private final JLabel label_HoaDon[]=new JLabel[array_HoaDon.length];
    private JTextField txt_HoaDon_Them[]=new JTextField[array_HoaDon.length];
    private JTextField txt_HoaDon_Sua[]=new JTextField[array_HoaDon.length];
    private static DatePicker dp1,dp_Tu_NgayLap,dp_Den_NgayLap;
    private JTextField Ten,Tu_TongTien,Den_TongTien,Tu_NgayLap,Den_NgayLap;
    private JComboBox cbSearch;
    String[] a,b,c,d,f;


	private JTextField txtMaHoaDon ;
	private JTextField txtNoidung ;
	private JTextField txtMaKM ;
	private JTextField txtTongtien ;
	DecimalFormat formatter = new DecimalFormat("###,###,###");
	SimpleDateFormat fm =new SimpleDateFormat("dd/MM/yyyy");
	DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private JTextField txtNgayLapHD ;
	private JScrollPane scrollPane ;
private DefaultTableModel model =new DefaultTableModel();
JTable tblDSSV =new JTable();
private JTextField txtMaKH;
private JTextField txtGia1;
private JTextField txtGia2;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HoaDonGUI1 frame = new HoaDonGUI1();
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
	public HoaDonGUI1() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 998, 797);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(255,204,204));
		
			//panel tim kiem nang cao
//			
//        JPanel TimKiem=new JPanel();
//        TimKiem.setLocation(50, 200);
//        
//        
//        JLabel lbTen=new JLabel("");
//        lbTen.setBorder(new TitledBorder("Tìm kiếm"));
//        lbTen.add(cbSearch);
//        
//        Ten=new JTextField();
//        Ten.setBorder(new TitledBorder("Mã hóa đơn"));
//        Ten.setBounds(105, 20, 150, 40);
//        lbTen.add(Ten);
//        addDocumentListener(Ten);
//        lbTen.setBounds(52, 320, 265, 70);
//       contentPane.add(lbTen);
//        
//        
		   
        JLabel NgayLap=new JLabel("");
        NgayLap.setBounds(235, 384, 377, 70);
        NgayLap.setFont(new Font("Tahoma", Font.BOLD, 12));
        NgayLap.setBorder(new TitledBorder(null, "T\u00ECm h\u00F3a \u0111\u01A1n theo ng\u00E0y l\u1EADp", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
                        
        Tu_NgayLap=new JTextField();
        Tu_NgayLap.setFont(new Font("Tahoma", Font.BOLD, 12));
        Tu_NgayLap.setForeground(Color.BLACK);
        Tu_NgayLap.setBackground(Color.WHITE);
        Tu_NgayLap.setBorder(new TitledBorder(null, "T\u1EEB ng\u00E0y", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        Tu_NgayLap.setBounds(5, 20, 100, 40);
        Tu_NgayLap.setEditable(false);
        NgayLap.add(Tu_NgayLap);
       // addDocumentListener(Tu_NgayLap);
        
        // khoang ngay
        DatePickerSettings pickerSettings = new DatePickerSettings();
        pickerSettings.setVisibleDateTextField(false);
        dp_Tu_NgayLap = new DatePicker(pickerSettings);        
        dp_Tu_NgayLap.setDateToToday();       
        // calendar icon
        JButton calendar=dp_Tu_NgayLap.getComponentToggleCalendarButton();
        calendar.setText("");
        calendar.setIcon(new ImageIcon(this.getClass().getResource("/Images/Icon/calendar-30.png")));
        calendar.setBorder(BorderFactory.createLineBorder(Color.decode("#90CAF9"), 1));
        dp_Tu_NgayLap.setBounds(105, 25, 35,30);
        NgayLap.add(dp_Tu_NgayLap);
        dp_Tu_NgayLap.addDateChangeListener((dce) -> {
            Tu_NgayLap.setText( dp_Tu_NgayLap.getDateStringOrEmptyString());
        });
        
        Den_NgayLap=new JTextField();
        Den_NgayLap.setFont(new Font("Tahoma", Font.BOLD, 12));
        Den_NgayLap.setForeground(Color.BLACK);
        Den_NgayLap.setBackground(Color.WHITE);
        Den_NgayLap.setBorder(new TitledBorder(null, "\u0110\u1EBFn ng\u00E0y", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        Den_NgayLap.setBounds(140, 20, 100, 40);
        Den_NgayLap.setEditable(false);
        NgayLap.add(Den_NgayLap);
      //  addDocumentListener(Den_NgayLap);
        
        // khoang ngay
        DatePickerSettings pickerSettings2 = new DatePickerSettings();
        pickerSettings2.setVisibleDateTextField(false);
        dp_Den_NgayLap = new DatePicker(pickerSettings2);        
        dp_Den_NgayLap.setDateToToday();       
        // calendar icon
        JButton calendar2=dp_Den_NgayLap.getComponentToggleCalendarButton();
        calendar2.setText("");
        calendar2.setIcon(new ImageIcon(this.getClass().getResource("/Images/Icon/calendar-30.png")));
        calendar2.setBorder(BorderFactory.createLineBorder(Color.decode("#90CAF9"), 1));
        dp_Den_NgayLap.setBounds(240, 25, 35,30);
        NgayLap.add(dp_Den_NgayLap);
        dp_Den_NgayLap.addDateChangeListener((dce) -> {
            Den_NgayLap.setText(dp_Den_NgayLap.getDateStringOrEmptyString());
        });
        contentPane.setLayout(null);
        
	     JButton btnNgay = new JButton("Tìm");
	     btnNgay.setFont(new Font("Tahoma", Font.BOLD, 11));
	     btnNgay.setBounds(411, 410, 66, 33);
	     btnNgay.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		ArrayList<HoaDonDTO> arr = new ArrayList<>();
	     		HoaDonBUS hdb=new HoaDonBUS();
	     	
	     
	     	if(Tu_NgayLap.getText().isEmpty() || Den_NgayLap.getText().isEmpty())
	     	{
	     		JOptionPane.showMessageDialog(null,"Vui lòng chọn đầy đủ khoảng thời gian cần để lọc");
	     		return;
	     	}else
	     	{
	     		LocalDate tungay=LocalDate.parse(Tu_NgayLap.getText(), formatter2); 
		        	LocalDate denngay=LocalDate.parse(Den_NgayLap.getText(), formatter2);
		        	float s1,s2;
	     	arr=hdb.loctheongay(tungay, denngay,"locngay",0,0);
	     	
	     	if(arr.size()==0)
	     	{
	     		JOptionPane.showMessageDialog(null,"Không tìm thấy hóa đơn trong khoảng thời gian trên");
	     		return;
	     	}else
	     	{
	     		JOptionPane.showMessageDialog(null,"Đã lọc được " + arr.size() +" hóa đơn thỏa điều kiện!!!" );
	     		clear();
	     		Vector header = new Vector();
	    	        header.add("Mã hóa đơn");
	    	        header.add("Mã khuyến mãi");
	    	        header.add("Mã khách hàng");
	    	        header.add("Ngày lập hóa đơn");
	    	       header.add("Nội dung khuyến mãi");
	    	    	header.add("Tổng tiền(VNĐ)");    
	    	    
	    	        if (model.getRowCount()==0)
	    	        {
	    	            
	    	            model = new DefaultTableModel(header, 0);
	    	        }
	    	   
	    	        chitietHDGUI ct = null;
	         for(HoaDonDTO n: arr)
	         { 
	         	  
	         	 try {
	      			ct =new chitietHDGUI(n.getMaHoaDon());
	      		} catch (Exception e1) {
	      			// TODO Auto-generated catch block
	      			e1.printStackTrace();
	      		}
	    			
	         Vector	d = new Vector();
	       
	         d.add(n.getMaHoaDon());
	         d.add(n.getMaKM());
	         d.add(n.getMaKH());
	         d.add(formatter1.format( n.getNgayLap()));
	         d.add("Giảm " +n.getnoidungKM() + "%");
	         d.add(formatter.format(Float.valueOf(ct.tongThanhTien)-(Float.valueOf(ct.tongThanhTien*Float.valueOf(n.getnoidungKM()))/100)));
	    	        model.addRow(d);
	    	        }
	    	 System.out.println(d[5]);   
	    			
	    			tblDSSV.setModel(model);
	     	}
	     	}
	       }
	     
	     });
	     
	     JLabel timGia = new JLabel("");
	     timGia.setFont(new Font("Tahoma", Font.BOLD, 12));
	     timGia.setBorder(new TitledBorder(null, "T\u00ECm h\u00F3a \u0111\u01A1n theo t\u1ED5ng ti\u1EC1n", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
	     timGia.setBounds(512, 384, 377, 70);
	     contentPane.add(timGia);
	     
	     txtGia2 = new JTextField();
	     txtGia2.setForeground(Color.BLACK);
	     txtGia2.setFont(new Font("Tahoma", Font.BOLD, 12));
	     txtGia2.setEditable(true);
	     txtGia2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u0110\u1EBFn (VN\u0110)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
	     txtGia2.setBackground(Color.WHITE);
	     txtGia2.setBounds(670, 403, 120, 40);
	     contentPane.add(txtGia2);
	     
	     txtGia1 = new JTextField();
	     txtGia1.setForeground(Color.BLACK);
	     txtGia1.setFont(new Font("Tahoma", Font.BOLD, 12));
	     txtGia1.setEditable(true);
	     txtGia1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u1EEB (VN\u0110)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
	     txtGia1.setBackground(Color.WHITE);
	     txtGia1.setBounds(524, 403, 120, 40);
	     contentPane.add(txtGia1);
	 //    contentPane.add(btnNgay);
 
        contentPane.add(NgayLap);                
        
//        JLabel TongTien=new JLabel("");
//        TongTien.setBorder(new TitledBorder("Tổng tiền(VNĐ)"));
//        
//        Tu_TongTien=new JTextField();
//        Tu_TongTien.setBorder(new TitledBorder("Từ"));
//        Tu_TongTien.setBounds(5, 20, 100, 40);
//        TongTien.add(Tu_TongTien);
//        addDocumentListener(Tu_TongTien);
//        
//        
//        Den_TongTien=new JTextField();
//        Den_TongTien.setBorder(new TitledBorder("Đến"));
//        Den_TongTien.setBounds(105, 20, 100, 40);
//        TongTien.add(Den_TongTien);
//        addDocumentListener(Den_TongTien);
//        
//
//         TongTien.setBounds(429, 320, 215, 70);
//         contentPane.add(TongTien);
      //   contentPane.add(TimKiem);
		
		
	
		
		JPanel panel3 = new JPanel();
		panel3.setBounds(514, 696, 352, 54);
		panel3.setBackground(new Color(255,204,204));
		contentPane.add(panel3);
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 5));
		
		txtMaHoaDon = new JTextField();
		txtMaHoaDon.setBounds(462, 118, 159, 33);
		contentPane.add(txtMaHoaDon);
		txtMaHoaDon.setColumns(10);
		
		txtNoidung = new JTextField();
		txtNoidung.setBounds(462, 223, 159, 87);
		txtNoidung.setEditable(false);
		txtNoidung.setColumns(10);
		contentPane.add(txtNoidung);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(52, 464, 875, 182);
		contentPane.add(panel1);
		panel1.setLayout(null);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 874, 182);
		panel1.add(scrollPane);
		
	

		   
		   //tạo bảng
		      tblDSSV.setModel(new DefaultTableModel(
		      	new Object[][] {
		      		{null, null, null, null, null, null},
		      		{null, null, null, null, null, null},
		      		{null, null, null, null, null, null},
		      		{null, null, null, null, null, null},
		      	},
		      	new String[] {"Mã hóa đơn","Mã khách hàng","Mã khuyến mãi","Ngày lập","Nội dung khuyến mãi","Tổng tiền(VNĐ)"}
		      ));
		      scrollPane.setViewportView(tblDSSV);
		
	
		
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
		panel2.setBounds(101, 642, 747, 54);
		contentPane.add(panel2);
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));
		panel2.setBackground(new Color(255,204,204));
		
		
		txtMaKH = new JTextField();
		txtMaKH.setBounds(462, 180, 159, 33);
		txtMaKH.setColumns(10);
		contentPane.add(txtMaKH);
		
		JLabel lblNewLabel_1_2 = new JLabel("M\u00E3 khuy\u1EBFn m\u00E3i");
		lblNewLabel_1_2.setBounds(628, 93, 120, 33);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1_2);
		
		txtMaKM = new JTextField();
		txtMaKM.setBounds(771, 104, 156, 33);
		txtMaKM.setColumns(10);
		contentPane.add(txtMaKM);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("T\u1ED5ng ti\u1EC1n");
		lblNewLabel_1_2_1.setBounds(641, 187, 107, 50);
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1_2_1);
		
		txtTongtien = new JTextField();
		txtTongtien.setBounds(771, 200, 159, 26);
		txtTongtien.setColumns(10);
		contentPane.add(txtTongtien);
		
		
	     DatePickerSettings pickerSetting3 = new DatePickerSettings();
	        pickerSetting3.setVisibleDateTextField(false);

	 dp1 = new DatePicker(pickerSetting3);        
	 dp1.setBounds(890, 150, 35, 30);
	        dp1.setDateToToday();    



	  JButton calendar3=dp1.getComponentToggleCalendarButton();
	        calendar3.setText("");
	        calendar3.setIcon(new ImageIcon(this.getClass().getResource("/Images/Icon/calendar-30.png")));
	        calendar3.setBorder(BorderFactory.createLineBorder(Color.decode("#90CAF9"), 1));
	        contentPane.add(dp1);
	        dp1.addDateChangeListener((dce) -> {
	        	String k =  dp1.getDateStringOrEmptyString();
	            txtNgayLapHD.setText(k);
	        });
	        
		
		 
		JLabel lblNewLabel_1_2_1_1 = new JLabel("<html>\r\n<body>\r\n<p>Ng\u00E0y l\u1EADp<br/> h\u00F3a \u0111\u01A1n</p>\r\n</body>\r\n</html>");
		lblNewLabel_1_2_1_1.setBounds(631, 136, 107, 50);
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1_2_1_1);
		
		txtNgayLapHD = new JTextField();
		txtNgayLapHD.setBounds(771, 147, 107, 33);
		txtNgayLapHD.setColumns(10);
		contentPane.add(txtNgayLapHD);
		
		JButton btnThem = new JButton("T\u1EA1o");
		btnThem.setIcon(new ImageIcon("C:\\Users\\Minh\\OneDrive\\Hình ảnh\\add_32px.png"));
	//	btnThem.setSelectedIcon(new ImageIcon(ChuongTrinhKMFrame.class.getResource("/IMG/icons8_add_48px.png")));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				SimpleDateFormat ft=new SimpleDateFormat("yyyy/MM/dd");
				Float tongtien = null;
				  String mahd = txtMaHoaDon.getText();
				  if(mahd.length()!=5)
				  {
					  JOptionPane.showMessageDialog(null, "Vui lòng nhập mã hóa đơn đủ  5 ký tự!!");
					  txtMaHoaDon.requestFocus();
					  return;
				  }else {
					  mahd = txtMaHoaDon.getText();;
				  }
				  
                  String makm = txtMaKM.getText();
                
                  String makh = txtMaKH.getText();
                  String[] giamgia = txtNoidung.getText().split(" ");
                  
                  String noidung= giamgia[1];
                  System.out.println(noidung);
                 if(txtTongtien.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"Vui lòng nhập Tổng tiền");
                  return;
                  }else 
                  {
                	  chitietHDGUI ct=null;
					try {
						ct = new chitietHDGUI(mahd);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                	  if(isTongTien(txtTongtien.getText())) {
                  tongtien=  Float.valueOf(txtTongtien.getText());
                  tongtien+=Float.valueOf(ct.tongThanhTien)-(Float.valueOf(ct.tongThanhTien)*Float.valueOf(noidung)/100);
                	  }else
                	  {
                		  JOptionPane.showMessageDialog(null,"Tổng tiền không hợp lệ");
                	  }
                  }
                 LocalDate ngaylap;
                 if(txtNgayLapHD.getText().isEmpty())
                 {
                	 JOptionPane.showMessageDialog(null,"VUi lòng nhập ngày tạo hóa đơn!!!");
                	 txtNgayLapHD.requestFocus();
                	 return;
                 }else {
             		if(kiemTraNgayThangNam(txtNgayLapHD.getText())==2)
            		{
            			JOptionPane.showMessageDialog(null,"Ngày tháng năm không hợp lệ , vui lòng nhập theo định dạng dd/MM/yyyy !!!");
            			
            			txtNgayLapHD.setText("");
            			txtNgayLapHD.requestFocus();
            			return;
            		}
                ngaylap=LocalDate.parse(txtNgayLapHD.getText(), formatter2);
              //  System.out.println(ngaylap);
                 }
			
	if( txtMaKH.getText().isEmpty() )
	{
		JOptionPane.showMessageDialog(null, "Vui lòng nhập mã khách hàng");
		return;
	}else {

	HoaDonBUS hd =new HoaDonBUS();
	 if(hd.check(mahd))
         {
             JOptionPane.showMessageDialog(null, "Mã hóa đơn đă tồn tại !!!");
             return;
         } else
         {
        	
        	 //thêm
        	 HoaDonDTO ctkm =new HoaDonDTO(mahd,makh,makm,noidung,tongtien,ngaylap);
        	 hd.them(ctkm);
        	
			
        		Vector header = new Vector();
		        header.add("Mã hóa đơn");
		        header.add("Mã khuyến mãi");
		        header.add("Mã khách hàng");
		        header.add("Ngày lập hóa đơn");
		       header.add("Nội dung khuyến mãi");
		    	header.add("Tổng tiền(VNĐ)");    
		        if (model.getRowCount()==0)
		        {
		            
         		      model = new DefaultTableModel(header, 0);
		        }
		        Vector	d = new Vector();
		        d.add(ctkm.getMaHoaDon());
		        d.add(ctkm.getMaKM());
		        d.add(ctkm.getMaKH());
		        d.add(formatter1.format( ctkm.getNgayLap()));
	            d.add("Giảm "+ ctkm.getnoidungKM() +" %");
		        d.add(formatter.format(ctkm.getTongTien()));
		        model.addRow(d);
		        tblDSSV.setModel(model);
         }
	                   
	}
			}
		});
//      
		
		clickOnKey(btnThoat,"EXIT",KeyEvent.VK_ESCAPE);
		btnThem.setForeground(new Color(0, 139, 139));
		btnThem.setBackground(new Color(64, 224, 208));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel2.add(btnThem);
		
		JButton btnXoa = new JButton("X\u00F3a");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int  i=tblDSSV.getSelectedRow();
				String makmxoa=txtMaHoaDon.getText();
				int k=tblDSSV.getSelectedColumn();
				
				if(k<0)
				{
					JOptionPane.showMessageDialog(null, "Vui lòng chọn hóa đơn cần xóa");
				}else {
					int reponse=JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn xóa?","Exit",JOptionPane.YES_NO_OPTION);
	        	if(reponse==0)
	        	{
	        		HoaDonBUS hd =new HoaDonBUS();
	        		try {
						hd.docHD();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	        		if(hd.check(makmxoa)==true) {
	        		hd.xoa(makmxoa, i);
	        		model.setRowCount(0);
	        		try {
						hd.docHD();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	        		outModel();
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
				HoaDonBUS hd =new HoaDonBUS();
				Object[] options = {
						"Search theo mã hóa đơn", "Seach theo mã khách hàng","Cancel"
				};
				int c=JOptionPane.showOptionDialog(contentPane, "Tìm kiếm theo mã hóa đơn hay mã khách hàng","Tìm kiếm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,options,options[2]);
				if(c==1) {
				 String seach=JOptionPane.showInputDialog("Mời nhập mã khách hàng cần tìm");
				  if( seach== null) {
				
					  return;
				  }
				  else
				  {
					  if(hd.getKHDTO(seach) !=null) {
						
						 clear();
						 outModelSearch(seach,"theomaKH");
			
					  }else
					  {
						  JOptionPane.showMessageDialog(null, "Không tìm thấy hóa đơn cần tìm!!");
						  return;
					  }
				  }
				}else if(c==0)
				{
					 String seach=JOptionPane.showInputDialog("Mời nhập mã hóa đơn cần tìm");
					  if( seach== null) {
					
						  return;
					  }else
					  {
	
						 if(hd.timViTri(seach) !=-1) {
							
							 clear();
		                outModelSearch(seach,"theomahd");
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
		
		//nút nhập,xuất file excel và in pdf
		   JButton NhapExcel=new JButton("Nhập Excel");
		   NhapExcel.setBounds(628, 318, 140, 38);
		   NhapExcel.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
		   	}
		   });
	        NhapExcel.setIcon(new ImageIcon(this.getClass().getResource("/Images/Icon/xls-30.png")));
	        NhapExcel.setFont(new Font("Segoe UI", 0, 14));
	        NhapExcel.setBorder(BorderFactory.createLineBorder(Color.decode("#90CAF9"), 1));
	        NhapExcel.setBackground(Color.decode("#90CAF9"));
	        NhapExcel.addMouseListener(new MouseAdapter(){
	            @Override
	            public void mousePressed(MouseEvent evt){
	           NhapExcel_click(evt);
	           clear();
	           outModel();
	            }
	        });
	        contentPane.add(NhapExcel);
	        
	        JButton XuatExcel=new JButton("Xuất Excel");
	        XuatExcel.setBounds(780, 318, 147, 38);
	        XuatExcel.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        	}
	        });
	        XuatExcel.setIcon(new ImageIcon(this.getClass().getResource("/Images/Icon/xls-30.png")));
	        XuatExcel.setFont(new Font("Segoe UI", 0, 14));
	        XuatExcel.setBorder(BorderFactory.createLineBorder(Color.decode("#90CAF9"), 1));
	        XuatExcel.setBackground(Color.decode("#90CAF9"));
	        XuatExcel.addMouseListener(new MouseAdapter(){
	            @Override
	            public void mousePressed(MouseEvent evt){
	             XuatExcel_click(evt);
	            }
	        });
	        contentPane.add(XuatExcel);
	        
	        JButton inPDF=new JButton("In PDF");
	        inPDF.setBounds(474, 320, 131, 34);
	        inPDF.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        	}
	        });
	        inPDF.setIcon(new ImageIcon(this.getClass().getResource("/Images/Icon/pdf-30.png")));
	        inPDF.setFont(new Font("Segoe UI", 0, 14));
	        inPDF.setBorder(BorderFactory.createLineBorder(Color.decode("#90CAF9"), 1));
	        inPDF.setBackground(Color.decode("#90CAF9"));
	        inPDF.addMouseListener(new MouseAdapter(){
	            @Override
	            public void mousePressed(MouseEvent evt){
	            int i =tblDSSV.getSelectedRow();
	            if (i == -1){
	                JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 hàng để in file");
	            }
	            else{
	            	System.out.println(String.valueOf(model.getValueAt(tblDSSV.getSelectedRow(), 0)));
	               try {
					new PDF().writeHoaDon(String.valueOf(model.getValueAt(tblDSSV.getSelectedRow(), 0)),i);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            }
	            }
	        });
	        contentPane.add(inPDF);
		
		 
	        
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(52, 22, 189, 212);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Minh\\OneDrive\\Hi\u0300nh a\u0309nh\\image.png"));
		contentPane.add(lblNewLabel);
		
		JLabel lbTieude = new JLabel("H\u00F3a \u0110\u01A1n Tour Du Lich");
		lbTieude.setBounds(394, 22, 420, 60);
		lbTieude.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lbTieude.setForeground(new Color(139, 0, 0));
		lbTieude.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lbTieude);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E3 h\u00F3a \u0111\u01A1n");
		lblNewLabel_1.setBounds(315, 116, 131, 33);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("N\u1ED9i dung khuy\u1EBFn m\u00E3i");
		lblNewLabel_1_1.setBounds(287, 207, 159, 47);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblNewLabel_1_1);
		HoaDonBUS hdbus=new HoaDonBUS();
		try {
			hdbus.docHD();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	outModel();
		
		JLabel lblNewLabel_1_3 = new JLabel("M\u00E3 kh\u00E1ch h\u00E0ng");
		lblNewLabel_1_3.setBounds(315, 178, 131, 33);
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setForeground(Color.BLACK);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1_3);
		
		JButton btnXem_1 = new JButton("Xem chi ti\u1EBFt");
		btnXem_1.setBounds(771, 237, 156, 38);
		btnXem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int j=tblDSSV.getSelectedRow();
				HoaDonBUS hd = new HoaDonBUS();
				
				
	
				if(j<0)
				{
					JOptionPane.showMessageDialog(null, "Vui lòng chọn hóa đơn để xem chi tiết");
					return;
				}else {
				
					chitietHDGUI f;
					try {
						String ma=tblDSSV.getModel().getValueAt(j, 0).toString();
						f = new chitietHDGUI(ma);
						f.setVisible(true);
						f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						f.setLocationRelativeTo(null);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					//taotableCTHD
					
					
				
				}
			
			}
		});
		btnXem_1.setIcon(new ImageIcon("C:\\Users\\Minh\\OneDrive\\Hi\u0300nh a\u0309nh\\preview_pane_32px.png"));
		btnXem_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnXem_1.setForeground(Color.RED);
		btnXem_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXem_1.setBackground(Color.YELLOW);
		contentPane.add(btnXem_1);
		
		txtMaKM.setEditable(false);
		txtMaKH.setEditable(false);
	
	   
		
		 int i=1,j=0,m=0,n=0;
		 ChuongTrinhKMBUS.list();
		 a=new String[ChuongTrinhKMBUS.ctKMlist.size()+1];
		 b=new String[ChuongTrinhKMBUS.ctKMlist.size()+1];
		 d=new String[ChuongTrinhKMBUS.ctKMlist.size()];
		 f=new String[ChuongTrinhKMBUS.ctKMlist.size()];
		 a[0]="Chọn mã khuyến mãi";
		 b[0]="";
		 d[0]="";
		 f[0]="";
		    for(ChuongTrinhKMDTO kt : ChuongTrinhKMBUS.ctKMlist)
	         {
	      	   
	      		   a[i++]=kt.getMaKM();
	      		   b[j++]=kt.getNoidungKM();
	      		   d[m++]=String.valueOf( kt.getTimeStartKM());
	      		   f[n++]=String.valueOf(kt.getTimeEndKM());
	      		   
	      	   
	      		  
	      	   
	         }
			JComboBox comboBox = new JComboBox(a);
			comboBox.setBounds(771, 73, 156, 21);
			contentPane.add(comboBox);
	
			 comboBox.addActionListener(new ActionListener() {
		         	public void actionPerformed(ActionEvent e) {
		         		if(comboBox.getSelectedIndex()==0)
		         		{
		         			txtMaKM.setText("");
		         			txtNoidung.setText("");
		         			
		         		}
		         		else {
		         			if(txtNgayLapHD.getText().isEmpty())
		         			{
		         				JOptionPane.showMessageDialog(null, "Hãy nhập ngày tạo hóa đơn");
		         				comboBox.setSelectedIndex(0);
		         				return;
		         			}else 
		         			{
		         				if(kiemTraNgayThangNam(txtNgayLapHD.getText())==1) {
		         					LocalDate day=LocalDate.parse(txtNgayLapHD.getText(), formatter2); 
		         					LocalDate d1= LocalDate.parse(d[comboBox.getSelectedIndex()-1],formatter2);
		         					LocalDate d2= LocalDate.parse(f[comboBox.getSelectedIndex()-1],formatter2);
		         					System.out.println(String.valueOf(d1));
		         					HoaDonBUS hd =new HoaDonBUS();
		         					if(hd.checkngay(d1, d2, day))
		         					{
		         		txtMaKM.setText(a[comboBox.getSelectedIndex()]);
		         		txtNoidung.setText("Giảm " + b[comboBox.getSelectedIndex()-1] + " %");
		         					}
		         					else
		         					{
		         						JOptionPane.showMessageDialog(null, "Thời gian áp dụng mã khuyến mãi không hợp lệ!!!");
		         						comboBox.setSelectedIndex(0);
		         						return;
		         					}
	
		         				}
		         				else {
		         					JOptionPane.showMessageDialog(null, "Ngày tháng năm không hợp lệ (yyyy/MM/dd)");
		         					return;
		         				}
		         			}
		         		}
		         	}
		         });
			 KhachHangBUS.list();
			 int k=1;
		
			String[] c=new String[KhachHangBUS.listKhachHangDTO.size()+1];
			c[0]="Chọn mã khách hàng";
			for(KhachHangDTO kh : KhachHangBUS.listKhachHangDTO)
	         {
	      	   
	      		   c[k++]=kh.getMaKH();
	      		   
	      	   
	      		  
	      	   
	         }
			 JComboBox comboxKH = new JComboBox(c);
			 comboxKH.setBounds(472, 158, 148, 21);
			contentPane.add(comboxKH);
			 comboxKH.addActionListener(new ActionListener() {
		         	public void actionPerformed(ActionEvent e) {
		         		if(comboxKH.getSelectedIndex()==0)
		         		{
		         			txtMaKH.setText("");
		         			
		         			
		         		}
		         		else {
		         		txtMaKH.setText(c[comboxKH.getSelectedIndex()]);
		         	
		         		}
		         	}
		         });
				JButton btnNhaplai = new JButton("Nh\u1EADp l\u1EA1i");
				btnNhaplai.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						 comboBox.setVisible(true);
						 Tu_NgayLap.setText("");
						 Den_NgayLap.setText("");
						 txtGia1.setText("");
						 txtGia2.setText("");
					   	  comboxKH.setVisible(true);
						txtMaHoaDon.setEditable(true);
						comboBox.setSelectedIndex(0);
						comboxKH.setSelectedIndex(0);
						txtTongtien.setEditable(true);
						txtNoidung.setEditable(false);
						txtNgayLapHD.setEditable(true);
						txtMaHoaDon.setText("");
						txtNoidung.setText("");
						txtMaKM.setText("");
						txtMaKH.setText("");
						txtNoidung.setText("");
						txtNgayLapHD.setText("");
						txtTongtien.setText("");
					model.setRowCount(0);
					outModel();
						
					}
				});
				btnNhaplai.setIcon(new ImageIcon("C:\\Users\\Minh\\OneDrive\\Hình ảnh\\refresh_32px.png"));
				btnNhaplai.setBackground(new Color(255, 255, 0));
				btnNhaplai.setForeground(new Color(255, 0, 0));
				btnNhaplai.setFont(new Font("Tahoma", Font.BOLD, 14));
				panel3.add(btnNhaplai);
				
				JLabel lblNewLabel_2 = new JLabel("~");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_2.setBounds(635, 415, 45, 13);
				contentPane.add(lblNewLabel_2);
				
				JButton btnGia = new JButton("T\u00ECm");
				btnGia.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ArrayList<HoaDonDTO> arr=new ArrayList<>();
						HoaDonBUS hd =new HoaDonBUS();
				      if(Tu_NgayLap.getText().isEmpty() && Den_NgayLap.getText().isEmpty() && txtGia1.getText().isEmpty() && txtGia2.getText().isEmpty())
				      {
				    	  JOptionPane.showMessageDialog(null,"Vui lòng nhập đầy đủ thời gian và số tiền để lọc");
				    	  return;
				      }else if(Tu_NgayLap.getText().isEmpty() && txtGia1.getText().isEmpty() && !Den_NgayLap.getText().isEmpty() && !txtGia2.getText().isEmpty())
				      {
				    	  JOptionPane.showMessageDialog(null,"Điều kiện lọc không hợp lệ!!!");
				    	  return;
				      }else if(Tu_NgayLap.getText().isEmpty() && txtGia2.getText().isEmpty() && !txtGia1.getText().isEmpty() && !Den_NgayLap.getText().isEmpty())
				      {
				    	  JOptionPane.showMessageDialog(null,"Điều kiện lọc không hợp lệ!!!");
				    	  return;
				      }else if(Den_NgayLap.getText().isEmpty() && txtGia1.getText().isEmpty() && !Tu_NgayLap.getText().isEmpty() && !txtGia2.getText().isEmpty() )
				      {
				    	  JOptionPane.showMessageDialog(null,"Điều kiện lọc không hợp lệ!!!");
				    	  return;
				      }else if(Den_NgayLap.getText().isEmpty() && txtGia2.getText().isEmpty() && !Tu_NgayLap.getText().isEmpty() && ! txtGia1.getText().isEmpty())
				      {
				    	  JOptionPane.showMessageDialog(null,"Điều kiện lọc không hợp lệ!!!");
				    	  return;
				      }else if(!Tu_NgayLap.getText().isEmpty() && !Den_NgayLap.getText().isEmpty() && txtGia1.getText().isEmpty() && !txtGia2.getText().isEmpty())
				      {
				    	  JOptionPane.showMessageDialog(null,"Điều kiện lọc không hợp lệ!!!");
				    	  return;
				      }
				      else if(!Tu_NgayLap.getText().isEmpty() && !Den_NgayLap.getText().isEmpty() && !txtGia1.getText().isEmpty() && txtGia2.getText().isEmpty())
				      {
				    	  JOptionPane.showMessageDialog(null,"Điều kiện lọc không hợp lệ!!!");
				    	  return;
				      }
				      else if(Tu_NgayLap.getText().isEmpty() && !Den_NgayLap.getText().isEmpty() && !txtGia1.getText().isEmpty() && !txtGia2.getText().isEmpty())
				      {
				    	  JOptionPane.showMessageDialog(null,"Điều kiện lọc không hợp lệ!!!");
				    	  return;
				      }
				      else if(!Tu_NgayLap.getText().isEmpty() && Den_NgayLap.getText().isEmpty() && !txtGia1.getText().isEmpty() && !txtGia2.getText().isEmpty())
				      {
				    	  JOptionPane.showMessageDialog(null,"Điều kiện lọc không hợp lệ!!!");
				    	  return;
				      }
				      else if(txtGia1.getText().isEmpty() && txtGia2.getText().isEmpty())
				      {

					     	if(Tu_NgayLap.getText().isEmpty() || Den_NgayLap.getText().isEmpty())
					     	{
					     		JOptionPane.showMessageDialog(null,"Vui lòng chọn đầy đủ khoảng thời gian cần để lọc");
					     		return;
					     	}else
					     		
					     	{
					     		LocalDate tungay=LocalDate.parse(Tu_NgayLap.getText(), formatter2); 
						        	LocalDate denngay=LocalDate.parse(Den_NgayLap.getText(), formatter2);
						        	float s1,s2;
					     	arr=hd.loctheongay(tungay, denngay,"locngay",0,0);
					     	
					     	if(arr.size()==0)
					     	{
					     		JOptionPane.showMessageDialog(null,"Không tìm thấy hóa đơn trong khoảng thời gian trên");
					     		return;
					     	}else
					     	{
					     		JOptionPane.showMessageDialog(null,"Đã lọc được " + arr.size() +" hóa đơn thỏa điều kiện!!!" );
					     		clear();
					     		Vector header = new Vector();
					    	        header.add("Mã hóa đơn");
					    	        header.add("Mã khuyến mãi");
					    	        header.add("Mã khách hàng");
					    	        header.add("Ngày lập hóa đơn");
					    	       header.add("Nội dung khuyến mãi");
					    	    	header.add("Tổng tiền(VNĐ)");    
					    	    
					    	        if (model.getRowCount()==0)
					    	        {
					    	            
					    	            model = new DefaultTableModel(header, 0);
					    	        }
					    	   
					    	        chitietHDGUI ct = null;
					         for(HoaDonDTO n: arr)
					         { 
					         	  
					         	 try {
					      			ct =new chitietHDGUI(n.getMaHoaDon());
					      		} catch (Exception e1) {
					      			// TODO Auto-generated catch block
					      			e1.printStackTrace();
					      		}
					    			
					         Vector	d = new Vector();
					       
					         d.add(n.getMaHoaDon());
					         d.add(n.getMaKM());
					         d.add(n.getMaKH());
					         d.add(formatter1.format( n.getNgayLap()));
					         d.add("Giảm " +n.getnoidungKM() + "%");
					         d.add(formatter.format(Float.valueOf(ct.tongThanhTien)-(Float.valueOf(ct.tongThanhTien*Float.valueOf(n.getnoidungKM()))/100)));
					    	        model.addRow(d);
					    	        }
					    	    
					    			
					    			tblDSSV.setModel(model);
					     	}
					     	}
					     		
				      }else if(Tu_NgayLap.getText().isEmpty() && Den_NgayLap.getText().isEmpty()) //lọc theo giá
				      {

				  		if(txtGia1.getText().isEmpty() || txtGia2.getText().isEmpty())
				  						{
				  							JOptionPane.showMessageDialog(null,"Vui lòng nhập vào khoảng tổng tiền để lọc hóa đơn");
				  							return;
				  						}else {
				  							if(isTongTien(txtGia1.getText()) || isTongTien(txtGia2.getText())) {
				  								Float j,k;
				  								j=Float.valueOf(txtGia1.getText());
				  								k=Float.valueOf(txtGia2.getText());
				  								arr=hd.loctheongay(null, null, "locgia", j, k);
				  								if(arr.size()==0)
				  								{
				  									JOptionPane.showMessageDialog(null, "Không có hóa đơn nằm trong khoảng giá trị thành tiền cần lọc");
				  									return;
				  								}else
				  								{
				  									JOptionPane.showMessageDialog(null,"Đã lọc được " + arr.size() +" hóa đơn thỏa điều kiện!!!" );
				  						     		clear();
				  						     		Vector header = new Vector();
				  						    	        header.add("Mã hóa đơn");
				  						    	        header.add("Mã khuyến mãi");
				  						    	        header.add("Mã khách hàng");
				  						    	        header.add("Ngày lập hóa đơn");
				  						    	       header.add("Nội dung khuyến mãi");
				  						    	    	header.add("Tổng tiền(VNĐ)");    
				  						    	    
				  						    	        if (model.getRowCount()==0)
				  						    	        {
				  						    	            
				  						    	            model = new DefaultTableModel(header, 0);
				  						    	        }
				  						    	   
				  						    	        chitietHDGUI ct = null;
				  						         for(HoaDonDTO n: arr)
				  						         { 
				  						         	  
				  						         	 try {
				  						      			ct =new chitietHDGUI(n.getMaHoaDon());
				  						      		} catch (Exception e1) {
				  						      			// TODO Auto-generated catch block
				  						      			e1.printStackTrace();
				  						      		}
				  						    			
				  						         Vector	d = new Vector();
				  						       
				  						         d.add(n.getMaHoaDon());
				  						         d.add(n.getMaKM());
				  						         d.add(n.getMaKH());
				  						         d.add(formatter1.format( n.getNgayLap()));
				  						         d.add("Giảm " +n.getnoidungKM() + "%");
				  						         d.add(formatter.format(Float.valueOf(ct.tongThanhTien)-(Float.valueOf(ct.tongThanhTien*Float.valueOf(n.getnoidungKM()))/100)));
				  						    	        model.addRow(d);
				  						    	        }
				  						    	    
				  						    			
				  						    			tblDSSV.setModel(model);
				  								}
				  							}else {
				  								JOptionPane.showMessageDialog(null,"Tổng tiền cần lọc không hợp lệ!!!");
				  								return;
				  							}
				  						}
				      }else if(!Tu_NgayLap.getText().isEmpty() && !Den_NgayLap.getText().isEmpty() && !txtGia1.getText().isEmpty() && !txtGia2.getText().isEmpty())
				      {
				    	  

				  							if(isTongTien(txtGia1.getText()) && isTongTien(txtGia2.getText())) {
				  								LocalDate tungay=LocalDate.parse(Tu_NgayLap.getText(), formatter2); 
				  					        	LocalDate denngay=LocalDate.parse(Den_NgayLap.getText(), formatter2);
				  								Float j,k;
				  								j=Float.valueOf(txtGia1.getText());
				  								k=Float.valueOf(txtGia2.getText());
				  								arr=hd.loctheongay(tungay, denngay, "all", j, k);
				  								if(arr.size()==0)
				  								{
				  									
				  									JOptionPane.showMessageDialog(null, "Không có hóa đơn nằm trong khoảng giá trị cần lọc");
				  									return;
				  								}else
				  								{
				  									JOptionPane.showMessageDialog(null,"Đã lọc được " + arr.size() +" hóa đơn thỏa điều kiện!!!" );
				  						     		clear();
				  						     		Vector header = new Vector();
				  						    	        header.add("Mã hóa đơn");
				  						    	        header.add("Mã khuyến mãi");
				  						    	        header.add("Mã khách hàng");
				  						    	        header.add("Ngày lập hóa đơn");
				  						    	       header.add("Nội dung khuyến mãi");
				  						    	    	header.add("Tổng tiền(VNĐ)");    
				  						    	    
				  						    	        if (model.getRowCount()==0)
				  						    	        {
				  						    	            
				  						    	            model = new DefaultTableModel(header, 0);
				  						    	        }
				  						    	   
				  						    	        chitietHDGUI ct = null;
				  						         for(HoaDonDTO n: arr)
				  						         { 
				  						         	  
				  						         	 try {
				  						      			ct =new chitietHDGUI(n.getMaHoaDon());
				  						      		} catch (Exception e1) {
				  						      			// TODO Auto-generated catch block
				  						      			e1.printStackTrace();
				  						      		}
				  						    			
				  						         Vector	d = new Vector();
				  						       
				  						         d.add(n.getMaHoaDon());
				  						         d.add(n.getMaKM());
				  						         d.add(n.getMaKH());
				  						         d.add(formatter1.format( n.getNgayLap()));
				  						         d.add("Giảm " +n.getnoidungKM() + "%");
				  						         d.add(formatter.format(Float.valueOf(ct.tongThanhTien)-(Float.valueOf(ct.tongThanhTien*Float.valueOf(n.getnoidungKM()))/100)));
				  						    	        model.addRow(d);
				  						    	        }
				  						    	    
				  						    			
				  						    			tblDSSV.setModel(model);
				  								}
				  							}else {
				  								JOptionPane.showMessageDialog(null,"Tổng tiền cần lọc không hợp lệ!!!");
				  								return;
				  							}
				  						
				    	  
				      }
					}
				});
				btnGia.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnGia.setBounds(811, 403, 66, 33);
				contentPane.add(btnGia);
				   tblDSSV.addMouseListener(new MouseAdapter() {
					   	@Override
					   	public void mousePressed(MouseEvent e) {
					   		
					   	  int i = tblDSSV.getSelectedRow();
					   	  comboBox.setVisible(false);
					   	  comboxKH.setVisible(false);
					   	 txtMaHoaDon.setEditable(false);
					   	 txtMaKM.setEditable(false);
					   	 txtMaKH.setEditable(false);
					   	 txtNoidung.setEditable(false);
					   	 txtNgayLapHD.setEditable(false);
					   	 txtTongtien.setEditable(false);
			              txtMaHoaDon.setText(tblDSSV.getModel().getValueAt(i, 0).toString());
			              txtMaKM.setText(tblDSSV.getModel().getValueAt(i, 1).toString());
			            txtMaKH.setText(tblDSSV.getModel().getValueAt(i, 2).toString()); 
			           txtNoidung.setText(tblDSSV.getModel().getValueAt(i, 4).toString());
			             txtNgayLapHD.setText( tblDSSV.getModel().getValueAt(i, 3).toString());    
			             txtTongtien.setText( tblDSSV.getModel().getValueAt(i, 5).toString());  
					   	}
					   });
			 			 
	}
	 public void outModel() // Xuất ra Table từ ArrayList
	    {
		 HoaDonBUS hd =new HoaDonBUS();
		 try {
			hd.docHD();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			Vector header = new Vector();
	        header.add("Mã hóa đơn");
	        header.add("Mã khuyến mãi");
	        header.add("Mã khách hàng");
	        header.add("Ngày lập hóa đơn");
	       header.add("Nội dung khuyến mãi");
	    	header.add("Tổng tiền(VNĐ)");    
	    
	        if (model.getRowCount()==0)
	        {
	            
	            model = new DefaultTableModel(header, 0);
	        }
	   
	        chitietHDGUI ct = null;
        for(HoaDonDTO n:hd.HD)
        { 
        	  
	
			
        Vector	d = new Vector();
        try {
			ct =new chitietHDGUI(n.getMaHoaDon());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        d.add(n.getMaHoaDon());
        d.add(n.getMaKM());
        d.add(n.getMaKH());
        d.add(formatter1.format( n.getNgayLap()));
        d.add("Giảm " +n.getnoidungKM() + "%");
        d.add(formatter.format(Float.valueOf(ct.tongThanhTien)-(Float.valueOf(ct.tongThanhTien*Float.valueOf(n.getnoidungKM()))/100)));
	        model.addRow(d);
	        }
	    
			
			tblDSSV.setModel(model);
	    }
	    public void list() // Chép ArrayList lên table
	    {
//	        if(ChuongTrinhKMBUS.getList()== null) ChuongTrinhKMBUS.list();
//	        ArrayList<ChuongTrinhKMDTO> nv = ChuongTrinhKMBUS.getList();
//model.setRowCount(0);
//	        outModel();
	    }
	    public void outModelSearch(String search,String s) // Xuất ra Table từ ArrayList tên đã tìm thấy
	    {
	    	ArrayList<HoaDonDTO> arrHD =new ArrayList<>();
	    	ArrayList<HoaDonDTO> arrKH =new ArrayList<>();
	    	HoaDonBUS hd =new HoaDonBUS();
	    	try {
				hd.docHD();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    if(search.length()!=5) {JOptionPane.showMessageDialog(null,"Vui lòng nhập đúng mã 5 ký tự!!!");}
	    else {
	    	if(s=="theomahd")
	    	{
	    		HoaDonDTO HD = hd.getHoaDonDTO(search);
	    		arrHD.add(HD);
	    	
	    Vector header = new Vector();
	  
        header.add("Mã hóa đơn");
        header.add("Mã khuyến mãi");
        header.add("Mã khách hàng");
        header.add("Ngày lập hóa đơn");
       header.add("Nội dung khuyến mãi");
    	header.add("Tổng tiền(VNĐ)");    
    
	    
	        if (model.getRowCount()==0)
	        {
	            
	            model = new DefaultTableModel(header, 0);
	        }
	        for(HoaDonDTO n:arrHD)
	        { 
	        Vector	d = new Vector();
	        d.add(n.getMaHoaDon());
	        d.add(n.getMaKM());
	        d.add(n.getMaKH());
	        d.add(n.getNgayLap());
	        d.add("Giảm " +n.getnoidungKM() + "%");
	        d.add((formatter.format(n.getTongTien())));
		        model.addRow(d);
		        }
	    	}else if(s=="theomakh")
	    	{
	    		HoaDonDTO HD = hd.getKHDTO(search);
	    		arrKH.add(HD);
	    	
	    Vector header = new Vector();
	   
        header.add("Mã hóa đơn");
        header.add("Mã khuyến mãi");
        header.add("Mã khách hàng");
        header.add("Ngày lập hóa đơn");
       header.add("Nội dung khuyến mãi");
    	header.add("Tổng tiền(VNĐ)");    
    
	        if (model.getRowCount()==0)
	        {
	            
	            model = new DefaultTableModel(header, 0);
	        }
	        for(HoaDonDTO n:arrHD)
	        { 
	        Vector	d = new Vector();
	        d.add(n.getMaHoaDon());
	        d.add(n.getMaKM());
	        d.add(n.getMaKH());
	        d.add(n.getNgayLap());
	        d.add("Giảm " +n.getnoidungKM() + "%");
	        d.add((formatter.format(n.getTongTien())));
		        model.addRow(d);
	    	}
	    	}
	    }
			tblDSSV.setModel(model);
	    
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
		   private void addDocumentListener(JTextField tx) { 
		        // https://stackoverflow.com/questions/3953208/value-change-listener-to-jtextfield
		        tx.getDocument().addDocumentListener(new DocumentListener() {
		            @Override
		            public void changedUpdate(DocumentEvent e) {
		                txtSearchOnChange();
		            }

		            @Override
		            public void removeUpdate(DocumentEvent e) {
		                txtSearchOnChange();
		            }

		            @Override
		            public void insertUpdate(DocumentEvent e) {
		                txtSearchOnChange();
		            }
		        });
		    }
		    //Hàm tìm kiếm mỗi khi thao tác trên field
		    public void txtSearchOnChange() {
		        double donGia1= -1, donGia2 = -1;
		        //Ràng buộc
		        try {
		            donGia1 = Double.parseDouble(Tu_TongTien.getText());
		            Tu_TongTien.setForeground(Color.black);
		        } catch (NumberFormatException e) {
		            Tu_TongTien.setForeground(Color.red);
		        }
		        

		        try {
		            donGia2 = Double.parseDouble(Den_TongTien.getText());
		            Den_TongTien.setForeground(Color.black);
		        } catch (NumberFormatException e) {
		            Den_TongTien.setForeground(Color.red);
		        }
		        //chưa sửa xong hỏi Nguyên cái Textfield
		    }
		    //Set dữ liệu lên lại table
		    private void setDataToTable(ArrayList<HoaDonDTO> hoaDonDTO) {
		       clear();
		        for (HoaDonDTO hoaDon : hoaDonDTO) {
		            addRow(hoaDon);
		        }
		    }
		    
		 
		    protected void XuatExcel_click(MouseEvent evt){
		        new XuatExcel().xuatFileExcelHoaDon();
		    }
		    
		    protected void NhapExcel_click(MouseEvent evt){
		       new DocExcel().docFileExcelHoaDon();
		    }
		    public void clear() {
		    	model.setRowCount(0);
		    	    }
		    public void addRow(HoaDonDTO data) {
		    	Vector header = new Vector();
		        header.add("Mã hóa đơn");
		        header.add("Mã khuyến mãi");
		        header.add("Mã khách hàng");
		        header.add("Ngày lập hóa đơn");
		       header.add("Nội dung khuyến mãi");
		    	header.add("Tổng tiền(VNĐ)");    
		        if (model.getRowCount()==0)
		        {
		            
		      model = new DefaultTableModel(header, 0);
		        }
		        Vector	d = new Vector();
		        d.add(data.getMaHoaDon());
		        d.add(data.getMaKM());
		        d.add(data.getMaKH());
		        d.add(data.getNgayLap());
	            d.add(data.getnoidungKM());
		        d.add((data.getTongTien()));
		        model.addRow(d);
		        tblDSSV.setModel(model);
		    }
		    public boolean isTongTien(String name)
		    {
		        Pattern pattern = Pattern.compile("[^a-zA-Z0-9. ]");
		        Matcher matcher = pattern.matcher(name);
		        if (matcher.find()) {
		            return false;
		        }
		        return true;
		        
		    }
		    public int checkmaKM(String ma)
		    {
                   ChuongTrinhKMBUS.list();
                   int check=0;
                   for(ChuongTrinhKMDTO kt : ChuongTrinhKMBUS.ctKMlist)
                   {
                	   if(kt.getMaKM().equalsIgnoreCase(ma))
                	   {
                		   txtNoidung.setText(kt.getNoidungKM());
                		   check=1;
                		  
                	   }
                   }
                  
                	   return check;
                   
		   
		    	
		    }
}
