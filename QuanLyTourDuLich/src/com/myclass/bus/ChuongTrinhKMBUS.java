package com.myclass.bus;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.myclass.dao.ChuongTrinhKMDAO;
import com.myclass.dto.ChuongTrinhKMDTO;


public class ChuongTrinhKMBUS {
public static ArrayList<ChuongTrinhKMDTO> ctKMlist;

public static void list()
{
    ctKMlist=new ArrayList<ChuongTrinhKMDTO>();	
	ctKMlist=ChuongTrinhKMDAO.getAll();
	
}

public static void add(ChuongTrinhKMDTO kh)
{
	ChuongTrinhKMDAO.add(kh);
    ctKMlist.add(kh);
    
   
  
}    
public static void delete(String makm)
{
    for(ChuongTrinhKMDTO kh : ctKMlist )
    {
        if(kh.getMaKM().equals(makm))
        {
            ctKMlist.remove(kh);
  ChuongTrinhKMDAO.delete(makm);
            return;
        }
    }
}
public static void sua(ChuongTrinhKMDTO s)
{
	int ck=0;
    for(int i = 0 ; i < ctKMlist.size() ; i++)
    {
       if(ctKMlist.get(i).getMaKM().equals(s.getMaKM()))
        {
            ctKMlist.set(i, s);
          ck=1;
            ChuongTrinhKMDAO.sua(s);
           return;
           
        }
    
        }
  
    }


public static void showData()
{
	JTable table=new JTable();
	
	DefaultTableModel model = (DefaultTableModel)table.getModel();
	ctKMlist = ChuongTrinhKMDAO.getAll();
	
	model.setRowCount(1);
//	for (Student student : ctKMlist) {
//		model.addRow(new Object[] {
//				student.getId(), student.getFullname(),student.getGender(),student.getAge(),student.getEmail(),
//				student.getPhone_number()});
//		
//	}
	
	for(int i=0;i<ctKMlist.size();i++)
	{
		model.addRow(new Object[] {
				ctKMlist.get(i).getMaKM(), ctKMlist.get(i).getMaTourKM(), ctKMlist.get(i).getTenTourKM(), ctKMlist.get(i).getNoidungKM(),
				ctKMlist.get(i).getTimeStartKM(), ctKMlist.get(i).getTimeEndKM()
		});
	}
	
	table.setModel(model);
	
	
}
public ChuongTrinhKMDTO get(String MaKH)
{
    for(ChuongTrinhKMDTO kh : ctKMlist )
    {
        if(kh.getMaKM().equals(MaKH))
        {
            return kh;
        }
    }
    return null;
}
public static boolean check(String ma)
{
    for(ChuongTrinhKMDTO kh : ctKMlist)
    {
        if(kh.getMaKM().equals(ma))
        {
            return true;
        }
    }
    return false;
}

public static ArrayList<ChuongTrinhKMDTO> getList() {
    return ctKMlist;
}
//public static ArrayList<ChuongTrinhKMDTO> getListtk() {
//    return listSearchbyname;
//}
public static ArrayList<ChuongTrinhKMDTO> timkiemtheoten(String ten, DefaultTableModel model)
{
	ArrayList<ChuongTrinhKMDTO> listSearchbyname1 =new ArrayList<ChuongTrinhKMDTO>();	
	for(ChuongTrinhKMDTO ct : ctKMlist)
	{
		if(ct.getTenTourKM().indexOf(ten)>=0)
		{
			listSearchbyname1.add(ct);
			model.setNumRows(0);
		
		}
		else {
			System.out.println("0");
			
		}
	}
	return listSearchbyname1;

}
public static ChuongTrinhKMDTO timMa(String ma)
{
	for(ChuongTrinhKMDTO ct : ctKMlist)
	{
		if(ct.getMaKM().compareTo(ma)==0)
		{
			return ct;
		}
	}
	
	return null;
}
}
