package com.myclass.bus;

import com.myclass.dao.NhaHangDAO;
import com.myclass.dto.NhaHangDTO;

import java.util.ArrayList;
import java.util.Vector;

public class NhaHangBUS {
	private static NhaHangDAO nhaHangDAO = new NhaHangDAO(); 
	public static ArrayList<NhaHangDTO> listNhaHangDTO = nhaHangDAO.getAll();
	
	public NhaHangBUS() {}
	
	public NhaHangDTO getByMaNhaHang(String maNhaHang) {
		
		return nhaHangDAO.getByMaNhaHang(maNhaHang);
	}
	
	public Vector<String> getAllMaNhaHang() {
		
		return nhaHangDAO.getAllMaNhaHang();
	}

	public void deleteById(String maNhaHang) {
		nhaHangDAO.deleteById(maNhaHang);
	}

	public void add(NhaHangDTO dto) {
		nhaHangDAO.add(dto);
	}

	public void update(NhaHangDTO dto) {
		nhaHangDAO.update(dto);
	}
}
