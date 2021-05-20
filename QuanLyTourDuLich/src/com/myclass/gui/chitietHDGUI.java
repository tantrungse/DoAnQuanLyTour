package com.myclass.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.myclass.bus.ChuongTrinhKMBUS;
import com.myclass.bus.HoaDonBUS;
import com.myclass.dto.ChiTietHoaDonDTO;
import com.myclass.dto.ChuongTrinhKMDTO;

import Report.PriceFormatter;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class chitietHDGUI extends JFrame {
 String ma;
	private JPanel contentPane;
	private DefaultTableModel model =new DefaultTableModel();
	DecimalFormat formatter = new DecimalFormat("###,###,###");
Float tongThanhTien=(float) 0;
private JTextField textField;
private JTable table;
private JTextField textField_1;
private JTextField txtTongtien;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
					chitietHDGUI frame = new chitietHDGUI("32424");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public chitietHDGUI(String ma) throws Exception {
		JPanel panel = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 706, 299);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 85, 718, 158);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setSize(900,250);
		table.setModel(new DefaultTableModel(
	        	new Object[][] {
	        		{null, null, null, null,null,null},
	        		{null, null, null, null,null,null},
	        		{null, null, null, null,null,null}
	        	},
	        	new String[] {
	        		"Mã hóa đơn", "Tên khách hàng", "Tên tour","Số lượng vé","Giá vé","Thành tiền"
	        	}
	        ));
		
		
		scrollPane.setViewportView(table);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.RED);
		textField_1.setText("Chi tiết hóa đơn "+ma);;
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(208, 0, 250, 37);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("T\u1ED5ng ti\u1EC1n :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(369, 253, 110, 20);
		panel_1.add(lblNewLabel);
		
		txtTongtien = new JTextField();
		txtTongtien.setBounds(469, 256, 164, 19);
		panel_1.add(txtTongtien);
		txtTongtien.setColumns(10);
	HoaDonBUS hdbus =new HoaDonBUS();
	hdbus.docCTHD(ma);
	 
	 for (ChiTietHoaDonDTO cthd : hdbus.CTHD) {

        

         tongThanhTien +=cthd.getGiaVe() * cthd.getSoLuongTour();
   }
	 txtTongtien.setText(formatter.format(tongThanhTien));
	//System.out.println(ma);
System.out.println(hdbus.CTHD.size());
	//ChuongTrinhKMBUS.list();
		outModel();

      
//		table.addMouseListener(new MouseListener() {
//			
//			
//			@Override
//			public void mousePressed(MouseEvent e) {
//				// TODO Auto-generated method stub
//				int i=table.getSelectedRow();
//				JOptionPane.showMessageDialog(null,ChuongTrinhKMBUS.ctKMlist.get(i).getMaKM());
//			}
//			
//			
//		});
//		
//		
//      
	}
	 public void outModel() // Xuất ra Table từ ArrayList
	    {
		  Vector header = new Vector();
	        header.add("Mã hóa đơn");
	        header.add("Tên khách hàng");
	        header.add("Tên tour");
	        header.add("Số lượng vé");
	        header.add("Giá vé");
	        header.add("Thành tiền");
	    
	        if (model.getRowCount()==0)
	        {
	            
	            model = new DefaultTableModel(header, 0);
	        }
	       
	    HoaDonBUS hd =new HoaDonBUS();
	        for(ChiTietHoaDonDTO n:hd.CTHD)
	        { 
	          Vector	data = new Vector();
	        data.add(n.getMaHoaDon());
	        data.add(n.getTenKH());
	        data.add(n.gettenTour());
	        data.add(n.getSoLuongTour());
	        data.add(n.getGiaVe());
	       n.setThanhTien(Float.valueOf(n.getGiaVe())*Float.valueOf(n.getSoLuongTour()));
	        data.add(n.getThanhTien());
	        model.addRow(data);
	        }
	    
			
			table.setModel(model);
	    }
}
