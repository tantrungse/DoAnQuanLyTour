package com.myclass.bus;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import com.myclass.dao.TaiKhoanDAO;
import com.myclass.dto.TaiKhoanDTO;

public class TaiKhoanBUS {
	public static ArrayList<TaiKhoanDTO> listTaiKhoanDTO = TaiKhoanDAO.getAll();
	private TaiKhoanDAO taiKhoanDAO;
    
    public TaiKhoanBUS() {
    	taiKhoanDAO = new TaiKhoanDAO();
    }
   
    public ArrayList<TaiKhoanDTO> getAll() {
    	return listTaiKhoanDTO;
    }
    
    public void add(TaiKhoanDTO dto) {
    	taiKhoanDAO.add(dto);
    }
    
   public static int loginbus(String user,String pass)
   {
	   int ck=0;
	   listTaiKhoanDTO=TaiKhoanDAO.logindao();
	   for(TaiKhoanDTO arr :listTaiKhoanDTO)
	   {
		   if(arr.getTenTK().equalsIgnoreCase(user) && arr.getMatKhau().equalsIgnoreCase(pass) && arr.getQuyen()==0)
		   {
			   ck=1;
		   }else if(arr.getTenTK().equalsIgnoreCase(user) && arr.getMatKhau().equalsIgnoreCase(pass) && arr.getQuyen()==1)
		   {
			   ck=2;
		   }
	   }
	   
	return ck;
	   
   }
   public static int loginbusnhanvien(String user,String pass)
   {
	   int ck=0;
	   listTaiKhoanDTO=TaiKhoanDAO.logindaonhanvien();
	   for(TaiKhoanDTO arr :listTaiKhoanDTO)
	   {
		   if(arr.getTenTK().equalsIgnoreCase(user) && arr.getMatKhau().equalsIgnoreCase(pass))
		   {
			   ck=1;
		   }
	   }
	   
	return ck;
	   
   }

public static void clickOnKey(  final AbstractButton button, String actionName, int key )
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

	public ArrayList<TaiKhoanDTO> getByTenTK(String tenTK) {
		return taiKhoanDAO.getByTenTK(tenTK);
	}

	public void update(TaiKhoanDTO dto) {
		taiKhoanDAO.update(dto);
	}

	public void deleteByTenTK(String tenTK) {
		taiKhoanDAO.deleteByTenTK(tenTK);
	}
}

