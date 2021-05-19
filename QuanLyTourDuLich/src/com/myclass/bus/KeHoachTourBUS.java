package com.myclass.bus;

import java.util.ArrayList;
import java.util.Vector;

import com.myclass.dao.DoanDAO;
import com.myclass.dao.KeHoachTourDAO;
import com.myclass.dto.DoanDTO;
import com.myclass.dto.KeHoachTourDTO;

public class KeHoachTourBUS {
	private static KeHoachTourDAO keHoachTourDAO = new KeHoachTourDAO(); 
	public static ArrayList<KeHoachTourDTO> listKeHoachTourDTO = keHoachTourDAO.getAll();
	
	public KeHoachTourBUS() {}
	
	public KeHoachTourDTO getByMaKeHoach(String maKeHoach) {
			
		return keHoachTourDAO.getByMaKeHoach(maKeHoach);
	}
	
	public Vector<String> getAllMaKeHoach() {
		
		return keHoachTourDAO.getAllMaKeHoach();
	}

	public KeHoachTourDTO getByMaTour(String maTour) {
		return keHoachTourDAO.getByMaTour(maTour);
	}

	public void deleteById(String maKeHoach) {
		keHoachTourDAO.deleteById(maKeHoach);
	}

	public void add(KeHoachTourDTO dto) {
		keHoachTourDAO.add(dto);
	}

	public void update(KeHoachTourDTO dto) {
		keHoachTourDAO.update(dto);
	}
}
