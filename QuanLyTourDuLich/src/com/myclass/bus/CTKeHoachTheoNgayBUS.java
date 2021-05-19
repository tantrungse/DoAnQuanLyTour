package com.myclass.bus;

import java.util.ArrayList;
import java.util.Vector;

import com.myclass.dao.CTKeHoachTheoNgayDAO;
import com.myclass.dto.CTKeHoachTheoNgayDTO;

public class CTKeHoachTheoNgayBUS {
	private static CTKeHoachTheoNgayDAO ctKeHoachTheoNgayDAO = new CTKeHoachTheoNgayDAO(); 
	public static ArrayList<CTKeHoachTheoNgayDTO> listCTKeHoachTheoNgayDTO = ctKeHoachTheoNgayDAO.getAll();
	
	public CTKeHoachTheoNgayBUS() {}
	
	public CTKeHoachTheoNgayDTO getByMaCTKHTheoNgay(String maCTKHTheoNgay) {
		
		return ctKeHoachTheoNgayDAO.getByMaCTKHTheoNgay(maCTKHTheoNgay);
	}
	
	public Vector<String> getAllMaCTKHTheoNgay() {
		
		return ctKeHoachTheoNgayDAO.getAllMaCTKHTheoNgay();
	}

	public ArrayList<CTKeHoachTheoNgayDTO> getByMaKHTour(String maKHTour) {
		return ctKeHoachTheoNgayDAO.getByMaKHTour(maKHTour);
	}

	public void deleteById(String maCTKHTheoNgay) {
		ctKeHoachTheoNgayDAO.deleteById(maCTKHTheoNgay);
	}

	public void add(CTKeHoachTheoNgayDTO dto) {
		ctKeHoachTheoNgayDAO.add(dto);
	}

	public void update(CTKeHoachTheoNgayDTO dto) {
		ctKeHoachTheoNgayDAO.update(dto);
	}
}
