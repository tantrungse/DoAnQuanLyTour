package com.myclass.bus;

import java.util.ArrayList;
import java.util.Vector;

import com.myclass.dao.KeHoachTourDAO;
import com.myclass.dto.KeHoachTourDTO;

public class KeHoachTourBUS {
	public KeHoachTourDAO keHoachTourDAO;
	
	public KeHoachTourBUS() {
		keHoachTourDAO = new KeHoachTourDAO();
	}
	
	public KeHoachTourDTO getByMaKeHoach(String maKeHoach) {
		
		return keHoachTourDAO.getByMaKeHoach(maKeHoach);
	}
	
	public Vector<String> getAllMaKHTour() {
		
		return keHoachTourDAO.getAllMaKHTour();
	}

	public KeHoachTourDTO getByMaTour(String maTour) {
		
		return keHoachTourDAO.getByMaTour(maTour);
	}
}
