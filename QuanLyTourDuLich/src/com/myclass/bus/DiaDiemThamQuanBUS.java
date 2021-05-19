package com.myclass.bus;

import java.util.ArrayList;
import java.util.Vector;

import com.myclass.dao.DiaDiemThamQuanDAO;
import com.myclass.dto.DiaDiemThamQuanDTO;

public class DiaDiemThamQuanBUS {
	private static DiaDiemThamQuanDAO diaDiemThamQuanDAO = new DiaDiemThamQuanDAO(); 
	public static ArrayList<DiaDiemThamQuanDTO> listDiaDiemThamQuanDTO = diaDiemThamQuanDAO.getAll();
	
	public DiaDiemThamQuanBUS() {}
	
	public DiaDiemThamQuanDTO getByMaDiaDiem(String maDiaDiem) {
		
		return diaDiemThamQuanDAO.getByMaDiaDiem(maDiaDiem);
	}
	
	public Vector<String> getAllMaDiaDiem() {
		
		return diaDiemThamQuanDAO.getAllMaDiaDiem();
	}

	public void deleteById(String maDiaDiem) {
		diaDiemThamQuanDAO.deleteById(maDiaDiem);
	}

	public void add(DiaDiemThamQuanDTO dto) {
		diaDiemThamQuanDAO.add(dto);
	}

	public void update(DiaDiemThamQuanDTO dto) {
		diaDiemThamQuanDAO.update(dto);
	}
}
