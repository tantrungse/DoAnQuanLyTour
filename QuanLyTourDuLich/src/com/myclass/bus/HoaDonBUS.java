package com.myclass.bus;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.myclass.dao.HoaDonDAO;
import com.myclass.dto.ChiTietHoaDonDTO;
import com.myclass.dto.ChuongTrinhKMDTO;
import com.myclass.dto.HoaDonDTO;
public class HoaDonBUS {

    public static ArrayList<HoaDonDTO> HD;
    public static ArrayList<ChiTietHoaDonDTO> CTHD;

    public HoaDonBUS() {

    }
    public void docCTHD(String ma) throws Exception 
    {
        HoaDonDAO hd = new HoaDonDAO();
        if (CTHD == null) {
            CTHD = new ArrayList<>();
        }
        CTHD = hd.docCTHD(ma); 

    }

    public void docHD() throws Exception 
    {
        HoaDonDAO hd = new HoaDonDAO();
        if (HD == null) {
            HD = new ArrayList<>();
        }
        HD = hd.docHD(); 

    }
    public static boolean check(String ma)
    {
        for(HoaDonDTO kh : HD)
        {
            if(kh.getMaHoaDon().equals(ma))
            {
                return true;
            }
        }
        return false;
    }

    public void them(HoaDonDTO HDDTO) 
    {
        HoaDonDAO hd = new HoaDonDAO();
        hd.them(HDDTO);//ghi vÃ o database
        if (HD != null)
        HD.add(HDDTO);
      
    }

    public void sua(HoaDonDTO HDDTO, int i) 
    {
        HoaDonDAO hd = new HoaDonDAO();
        hd.sua(HDDTO);
        if (HD != null)
        HD.set(i, HDDTO);
    }

    public void xoa(HoaDonDTO HDDTO, int index) 
    {
        HoaDonDAO hd = new HoaDonDAO();
        hd.xoa(HDDTO); 
        if (HD != null)
        HD.set(index, HDDTO); 
    }

    public void xoa(String ID, int index) 
    {
        HoaDonDAO data = new HoaDonDAO();
        data.xoa(ID);
        HoaDonDTO DTO=HD.get(index); 
       if (HD != null)
        HD.set(index, DTO);
    }
    

    public static int timViTri( String ID) 
    {
        for (int i = 0; i < HD.size(); i++) {
            if (HD.get(i).getMaHoaDon().equals(ID)) {
                return i;
            }
        }
        return -1;
    }
    
 
    public static String getMaHoaDonCuoi()
    {
        if(HD == null)
        {
            HD = new ArrayList<>();
        }
        if(HD.size() > 0)
        {
            String ma;
         ma = HD.get(HD.size()-1).getMaHoaDon();
         return ma;
        }
         return null;
    }
    //Get lÃ m Excel PDF
    public ArrayList<HoaDonDTO> getHoaDonDTO() {
        return HD;
    }
    public HoaDonDTO getHoaDonDTO(String idhoadon) {
        for (HoaDonDTO hdDTO : HD) {
            if (hdDTO.getMaHoaDon().equals(idhoadon)) {
                return hdDTO;
            }
        }
        return null;
    }
    public HoaDonDTO getKHDTO(String idhoadon) {
        for (HoaDonDTO hdDTO : HD) {
            if (hdDTO.getMaKH().equals(idhoadon)) {
return hdDTO;
            }
        }
        return null;
    }
    
    public ArrayList<HoaDonDTO> search(String type, String value, LocalDate _ngay1, LocalDate _ngay2, int _tong1, int _tong2) {
        ArrayList<HoaDonDTO> result = new ArrayList<>();
        HD.forEach((HoaDonDTO) -> {
            switch (type) {
                case "Tất cả":
                    if (HoaDonDTO.getMaHoaDon().toLowerCase().contains(value.toLowerCase())
                            
                            || HoaDonDTO.getNgayLap().toString().toLowerCase().contains(value.toLowerCase())
                            || String.valueOf(HoaDonDTO.getnoidungKM()).toLowerCase().contains(value.toLowerCase())
                            || String.valueOf(HoaDonDTO.getTongTien()).toLowerCase().contains(value.toLowerCase())) {
                        result.add(HoaDonDTO);
                    }

                    break;

                case "Mã Hóa Đơn":
                    if (HoaDonDTO.getMaHoaDon().toLowerCase().contains(value.toLowerCase())) {
                        result.add(HoaDonDTO);
                    }
                    break;

          

                case "Ngày Lập Hóa Đơn":
                    if (HoaDonDTO.getNgayLap().toString().toLowerCase().contains(value.toLowerCase())) {
                        result.add(HoaDonDTO);
                    }
                    break; 
                case "Giá KM":
                    if (String.valueOf(HoaDonDTO.getnoidungKM()).toLowerCase().contains(value.toLowerCase())) {
                        result.add(HoaDonDTO);
                    }
                    break;

                case "Tổng tiền":
                    if (String.valueOf(HoaDonDTO.getTongTien()).toLowerCase().contains(value.toLowerCase())) {
                        result.add(HoaDonDTO);
                    }
            }
        });

        //Ngay lap, tong tien
        for (int i = result.size() - 1; i >= 0; i--) {
            HoaDonDTO hd = result.get(i);
            LocalDate ngaylap = hd.getNgayLap();
            float tongtien = (float) hd.getTongTien();

            Boolean ngayKhongThoa = (_ngay1 != null && ngaylap.isBefore(_ngay1)) || (_ngay2 != null && ngaylap.isAfter(_ngay2));
            Boolean tienKhongThoa = (_tong1 != -1 && tongtien < _tong1) || (_tong2 != -1 && tongtien > _tong2);

            if (ngayKhongThoa || tienKhongThoa) {
                result.remove(hd);
            }
        }
        
        return result;
    }
    public ArrayList<HoaDonDTO> loctheongay(LocalDate d1 , LocalDate d2,String s,float s1, float s2)
    {
    	ArrayList<HoaDonDTO> arr = new ArrayList<>();
    	if(s=="locngay") {
    	for(HoaDonDTO n:HD)
    	{
    		if(d1.isAfter(d2))
    		{
    			JOptionPane.showMessageDialog(null,"THời gian lọc không hợp lệ!!!");
    		}
    		else {
    		if( n.getNgayLap().isAfter(d1) && n.getNgayLap().isBefore(d2) )
    		{
    			arr.add(n);
}else if(n.getNgayLap().isEqual(d1) || n.getNgayLap().isEqual(d2))
    		{
    			arr.add(n);
    		}
    		
    	}
    	}
    	}else if(s=="locgia")
    	{
    		for(HoaDonDTO n:HD)
        	{
        		if(s2<s1)
        		{
        			JOptionPane.showMessageDialog(null,"Số tiền của hóa đơn cần lọc không hợp lệ!!!");
        		}
        		else {
        		if( n.getTongTien()>s1 && n.getTongTien()<s2)
        		{
        			arr.add(n);
        		}else if(n.getTongTien()==s1 ||  n.getTongTien()==s2)
        		{
        			arr.add(n);
        		}
        	}
        	}
    	}else if(s=="all")
    	{
    		for(HoaDonDTO n:HD)
        	{
        		if(s2<s1 )
        		{
        			JOptionPane.showMessageDialog(null,"Số tiền của hóa đơn cần lọc không hợp lệ!!!");
        			return null;
        		}
        		else if(d1.isAfter(d2))
        		{
        			JOptionPane.showMessageDialog(null,"Ngày lọc  hóa đơn không hợp lệ!!!");
        			return null;
        	
        		}
        		else if(s1<s2 && d1.isBefore(d2)){
        		if( n.getTongTien()>=s1 && n.getTongTien()<=s2 && n.getNgayLap().isAfter(d1) && n.getNgayLap().isBefore(d2))
        		{
        			arr.add(n);
        		}else if( n.getNgayLap().isEqual(d1) || n.getNgayLap().isEqual(d2) )
        		{
        			arr.add(n);
        		}
        	}
        	}
    	}
    	
    	return arr;
    }
    public boolean checkngay(LocalDate d1 , LocalDate d2 ,LocalDate d)
    {
    	if(d.isAfter(d1) && d.isBefore(d2) )
		{
			return true;
		}else if(d.isEqual(d1) || d.isEqual(d2))
		{
			return true;
		}
    	else if(d.isAfter(d2) && d.isBefore(d1))
    	{
    		return false;
    	}
		return false;
    }
}