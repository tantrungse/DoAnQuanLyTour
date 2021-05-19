package com.myclass.gui;
import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.myclass.bus.SendEmail;
import com.myclass.bus.TaiKhoanBUS;
import com.myclass.dto.TaiKhoanDTO;
import com.mysql.cj.Session;
import com.mysql.cj.protocol.Message;
import com.sun.jdi.connect.Transport;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.mail.Authenticator;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.nio.charset.Charset;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class TaiKhoanFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPass;
	private JTextField txtMail;
	private JTextField txtMaxn;
	ArrayList<TaiKhoanDTO> arr=new ArrayList<>();
	String arr1[]= {"abc123","123abc","xyz456","456xyz","798mno","mno789"};
	Random r =new Random();
	String ma=arr1[r.nextInt(6)];
	public static TaiKhoanFrame mInstance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Formlogin frame = new Formlogin();
					TaiKhoanFrame.getTaiKhoanFrameInstance().setUndecorated(true);
					TaiKhoanFrame.getTaiKhoanFrameInstance().setBackground(new Color(0,0,0,0));
					TaiKhoanFrame.getTaiKhoanFrameInstance().setVisible(true);
					TaiKhoanFrame.getTaiKhoanFrameInstance().setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TaiKhoanFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 678);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0,0,0,0));
		
	
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnExit = new JButton("");
		btnExit.addActionListener(new ActionListener() {
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
		
		JButton btnSendmail = new JButton("G\u1EEDi mail");
	btnSendmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Charset t;
				String ma1="   MÃƒ XÃ�C NHáº¬N Cá»¦A Báº N LÃ€ : ";
				
				String maxn=String.valueOf("Your Confirm Code " + ma );
				try {
					SendEmail.sendMail(txtMail.getText(), "DO U LOVE ME ? ",ma);
				/*	SendEmail.prepareMessage(null,"lytheminh2506@gmail.com", "lytheminh3q@gmail.com","Gá»­i mÃ£ xÃ¡c nháº­n","<html>\r\n"
							+ "<head>\r\n"
							+ "<meta charset=\"utf-8\">\r\n"
							+ "<title>Untitled Document</title>\r\n"
							+ "</head>\r\n"
							+ "<form style=\"border: solid #C4F900\">\r\n"
							+ "	<hr>\r\n"
							+ "	<h1 style=\"text-align: center; color: rgba(255,89,92,1.00)\">MÃƒ XÃ�C NHáº¬N LOGIN</h1>\r\n"
							+ "	<br>\r\n"
							+ "</form>\r\n"
							+ "<body>\r\n"
							+ "</body>\r\n"
							+ "</html>");
					*/
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSendmail.setForeground(new Color(139, 0, 0));
		btnSendmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSendmail.setBackground(Color.PINK);
		btnSendmail.setBounds(801, 392, 90, 35);
		contentPane.add(btnSendmail);
		
		JButton btnReset = new JButton("Nh\u1EADp l\u1EA1i");
		
		btnReset.setForeground(new Color(139, 0, 0));
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.setBackground(Color.PINK);
		btnReset.setBounds(767, 470, 124, 35);
		contentPane.add(btnReset);
		
		JLabel lbMaxn = new JLabel("Vui l\u00F2ng m\u00E3 x\u00E1c nh\u1EADn");
		lbMaxn.setHorizontalAlignment(SwingConstants.CENTER);
		lbMaxn.setForeground(Color.RED);
		lbMaxn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lbMaxn.setBounds(444, 392, 186, 41);
		contentPane.add(lbMaxn);
		
		txtMaxn = new JTextField();
		txtMaxn.setForeground(Color.BLACK);
		txtMaxn.setColumns(10);
		txtMaxn.setBorder(BorderFactory.createMatteBorder(0,0,3,0,new Color(128,64,0)));
		txtMaxn.setBounds(664, 392, 124, 35);
		contentPane.add(txtMaxn);
		
		JLabel lbNhapmail = new JLabel("Vui l\u00F2ng nh\u1EADp mail");
		lbNhapmail.setHorizontalAlignment(SwingConstants.CENTER);
		lbNhapmail.setForeground(new Color(255, 0, 0));
		lbNhapmail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lbNhapmail.setBounds(444, 340, 179, 41);
		contentPane.add(lbNhapmail);
		
		txtMail = new JTextField();
		txtMail.setForeground(Color.BLACK);
		txtMail.setColumns(10);
		txtMail.setBorder(BorderFactory.createMatteBorder(0,0,3,0,new Color(128,64,0)));
		txtMail.setBounds(664, 345, 227, 35);
		contentPane.add(txtMail);
		
	
		
	
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Git\\quanlytour\\QuanLyTourDuLichIMG\\Untitled (2).png"));
		lblNewLabel_5.setBounds(515, 553, 376, 61);
		contentPane.add(lblNewLabel_5);
		
		txtPass = new JPasswordField();
		txtPass.setColumns(10);
		txtPass.setBounds(664, 288, 227, 35);
		contentPane.add(txtPass);
		
		txtUser = new JTextField();
		txtUser.setBounds(664, 208, 227, 35);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBackground(new Color(0, 0, 0));
		btnExit.setIcon(new ImageIcon("C:\\Git\\quanlytour\\QuanLyTourDuLich\\IMG\\exit-1852366-1573369 (1).png"));
		btnExit.setBounds(923, 30, 26, 21);
		contentPane.add(btnExit);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Git\\quanlytour\\QuanLyTourDuLich\\IMG\\image.png"));
		lblNewLabel_4.setBounds(161, 11, 193, 198);
		contentPane.add(lblNewLabel_4);
		
		lbMaxn.setVisible(false);
		lbNhapmail.setVisible(false);
		txtMail.setVisible(false);
		txtMaxn.setVisible(false);
		
	btnSendmail.setVisible(false);
		
		JButton btnLogin = new JButton("\u0110\u0103ng nh\u1EADp");
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(0, 0, 255));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 16));
		comboBox.setBackground(new Color(0,0,0,0));
		comboBox.setBorder(BorderFactory.createMatteBorder(4,0,0,0,new Color(128,64,0)));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"   Account?", " Nh\u00E2n Vi\u00EAn ", " Qu\u1EA3n L\u00FD"}));
		comboBox.setBounds(631, 470, 118, 37);
		contentPane.add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(comboBox.getSelectedIndex());
		 if(comboBox.getSelectedIndex()==1)
		 {
			 lbNhapmail.setVisible(true);
			 lbMaxn.setVisible(true);
			 txtMail.setVisible(true);
			 txtMaxn.setVisible(true);
			 btnSendmail.setVisible(true);
			
		 }else {
			 btnSendmail.setVisible(false);
			 lbNhapmail.setVisible(false);
			 lbMaxn.setVisible(false);
			 txtMail.setVisible(false);
			 txtMaxn.setVisible(false);
		 }
		 
			}
		});
		btnLogin.setBackground(Color.PINK);
		btnLogin.addActionListener(new ActionListener() {
                // TODO Auto-generated method stub
				public void actionPerformed(ActionEvent e) {
					String taikhoan=txtUser.getText();
					String matkhau=txtPass.getText();
					
					if(taikhoan!=null && matkhau!=null) {
					if(comboBox.getSelectedIndex()==2)
					{
						
					int ck;
					ck=TaiKhoanBUS.loginbus(taikhoan, matkhau);
					if(ck==1)
					{
						JOptionPane.showMessageDialog(null, "ChÃ o má»«ng admin!");
						Application.getAppInstance().setVisible(true);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"TÃ i khoáº£n khÃ´ng há»£p lá»‡!!!");
					}
					
						
					}else if(comboBox.getSelectedIndex()==1)
					{
					if(txtMail.getText()=="")
					{
						JOptionPane.showMessageDialog(null, "Vui lÃ²ng nháº­p vÃ o mail Ä‘á»ƒ gá»­i mÃ£ xÃ¡c nháº­n!!!");
					}
					if(txtMaxn.getText()=="")
					{
						JOptionPane.showMessageDialog(null, "Vui lÃ²ng nháº­p vÃ o mÃ£ xÃ¡c nháº­n!!!");
					}
					int ck;
					ck=TaiKhoanBUS.loginbusnhanvien(taikhoan, matkhau);
					if(ck==1)
					{
						JOptionPane.showMessageDialog(null, "ChÃ o má»«ng account nhÃ¢n viÃªn!!!");
					}else{
						JOptionPane.showMessageDialog(null, "Account khÃ´ng há»£p lá»‡!!!");
					}
					
						//loginBUS.loginnhanvien(txtUser.getText(),txtPass.getText(),1);
					/*
					int ck=1,ck1;
						for(int i=0;i<arr1.length;i++)
						{
							if(arr1[i].equalsIgnoreCase(txtMaxn.getText()))
							{
								
								ck1=loginDAO.loginnhanvien(taikhoan,matkhau);
								if(ck1==1) {
								ck=0;
								JOptionPane.showMessageDialog(null,"Báº¡n lÃ  nhÃ¢n viÃªn");
								
								break;
								   }else
								   {
									   JOptionPane.showMessageDialog(null,"Báº¡n khÃ´ng lÃ  nhÃ¢n viÃªn");
								   }
								}
						
						}
						if(ck==1)
						{
							{
								JOptionPane.showMessageDialog(null, "MÃ£ Ä‘Äƒng nháº­p khÃ´ng Ä‘Ãºng");
							}
						}
						*/
					}else {
						JOptionPane.showMessageDialog(btnLogin, "Vui lÃ²ng chá»�n quyá»�n Ä‘á»ƒ Ä‘Äƒng nháº­p!!");
			       txtUser.requestFocus();
				}
					}else {
						JOptionPane.showMessageDialog(btnLogin,"Vui lÃ²ng nháº­p Ä‘áº§y Ä‘á»§ tÃ i khoáº£n vÃ  máº­t kháº©u!!");
					}
			}
		
		
			 });
		TaiKhoanBUS.clickOnKey(btnExit,"EXIT",KeyEvent.VK_ESCAPE);
		
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(comboBox.getSelectedIndex()==1)
				 {
					 txtUser.setText("");
					 txtPass.setText("");
					 txtMail.setText("");
					 txtMaxn.setText("");
					 lbNhapmail.setVisible(false);
					 lbMaxn.setVisible(false);
					 txtMail.setVisible(false);
					 txtMaxn.setVisible(false);
					 comboBox.setSelectedIndex(0);
				
				 }else {
					 txtUser.setText("");
					 txtPass.setText("");
					 txtMail.setText("");
					 txtMaxn.setText("");
				 }
			}
		});
		
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogin.setForeground(new Color(139, 0, 0));
		btnLogin.setBounds(497, 472, 124, 35);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel_3_1 = new JLabel("Password");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(new Color(30, 144, 255));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_3_1.setBounds(541, 288, 91, 41);
		contentPane.add(lblNewLabel_3_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(160, 82, 45));
		panel_1_1.setBounds(504, 288, 33, 41);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon("C:\\Git\\quanlytour\\QuanLyTourDuLich\\IMG\\icons8_Lock_32px.png"));
		lblNewLabel_2_1.setBounds(0, 0, 35, 41);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		panel_1_1.add(lblNewLabel_2_1);
		
		
		
	

		
		JLabel lblNewLabel_3 = new JLabel("User Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_3.setForeground(new Color(30, 144, 255));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(541, 208, 91, 41);
		contentPane.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(160, 82, 45));
		panel_1.setBounds(504, 208, 33, 41);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 35, 41);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Git\\quanlytour\\QuanLyTourDuLich\\IMG\\icons8_User_35px_1.png"));
	
	//	txtUser.setBackground(new Color(0,0,0,0));
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		txtUser.setBorder(BorderFactory.createMatteBorder(0,0,3,0,new Color(128,64,0)));
		


txtPass.setBorder(BorderFactory.createMatteBorder(0,0,3,0,new Color(128,64,0)));
		txtPass.setColumns(10);
		//txtPass.setBackground(new Color(0,0,0,0));
		txtPass.setForeground(Color.BLACK);
		contentPane.add(txtPass);
		
		JLabel lb0 = new JLabel("QU\u1EA2N L\u00DD TOUR DU L\u1ECACH");
		lb0.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lb0.setHorizontalAlignment(SwingConstants.LEFT);
		lb0.setForeground(new Color(0, 255, 255));
		lb0.setBounds(484, 0, 500, 55);
		contentPane.add(lb0);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 192, 203));
		panel.setBounds(504, 40, 200, 10);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Sign In");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 37));
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(631, 98, 193, 61);
		contentPane.add(lblNewLabel_1);
		
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("C:\\Git\\quanlytour\\QuanLyTourDuLich\\IMG\\image (5).png"));
			lblNewLabel.setBounds(0, 0, 992, 667);
			lblNewLabel.setBackground(new Color(0,0,0,0));
			contentPane.add(lblNewLabel);
		
	}
	
    public static TaiKhoanFrame getTaiKhoanFrameInstance() {
        if(mInstance == null) 
            mInstance = new TaiKhoanFrame();
        return mInstance;
    }
   
}
