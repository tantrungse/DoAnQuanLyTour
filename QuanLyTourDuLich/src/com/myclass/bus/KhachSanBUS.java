package com.myclass.bus;

import com.myclass.dao.KhachSanDAO;
import com.myclass.dao.KhachSanDAO;
import com.myclass.dto.KhachSanDTO;
import com.myclass.dto.KhachSanDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
public class KhachSanBUS {
	private static KhachSanDAO khachSanDAO = new KhachSanDAO(); 
	public static ArrayList<KhachSanDTO> listKhachSanDTO = khachSanDAO.getAll();
	
	public KhachSanBUS() {}
	
	public KhachSanDTO getByMaKhachSan(String maKhachSan) {
		
		return khachSanDAO.getByMaKhachSan(maKhachSan);
	}
	
	public Vector<String> getAllMaKhachSan() {
		
		return khachSanDAO.getAllMaKhachSan();
	}

	public void deleteById(String maKhachSan) {
		khachSanDAO.deleteById(maKhachSan);
	}

	public void add(KhachSanDTO dto) {
		khachSanDAO.add(dto);
	}

	public void update(KhachSanDTO dto) {
		khachSanDAO.update(dto);
	}
}
