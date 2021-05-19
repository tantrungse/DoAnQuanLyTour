package com.myclass.bus;

import java.util.ArrayList;
import java.util.Vector;

import com.myclass.dao.DoanDAO;
import com.myclass.dao.PhuongTienDAO;
import com.myclass.dto.DoanDTO;
import com.myclass.dto.PhuongTienDTO;

public class PhuongTienBUS {
	private static PhuongTienDAO phuongTienDAO = new PhuongTienDAO(); 
	public static ArrayList<PhuongTienDTO> listPhuongTienDTO = phuongTienDAO.getAll();
	
	public PhuongTienBUS() {}
	
	public PhuongTienDTO getByMaPhuongTien(String maPhuongTien) {
		
		return phuongTienDAO.getByMaPhuongTien(maPhuongTien);
	}
	
	public Vector<String> getAllMaPhuongTien() {
		
		return phuongTienDAO.getAllMaPhuongTien();
	}

	public void deleteById(String maPhuongTien) {
		phuongTienDAO.deleteById(maPhuongTien);
	}

	public void add(PhuongTienDTO dto) {
		phuongTienDAO.add(dto);
	}

	public void update(PhuongTienDTO dto) {
		phuongTienDAO.update(dto);
	}
}
