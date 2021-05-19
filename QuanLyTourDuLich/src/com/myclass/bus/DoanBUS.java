package com.myclass.bus;

import java.util.ArrayList;
import java.util.Vector;

import com.myclass.dao.DoanDAO;
import com.myclass.dao.TourDAO;
import com.myclass.dto.DoanDTO;
import com.myclass.dto.TourDTO;

public class DoanBUS {
	private static DoanDAO doanDAO = new DoanDAO(); 
	public static ArrayList<DoanDTO> listDoanDTO = doanDAO.getAll();
	
	public DoanBUS() {}
	
	public DoanDTO getByMaDoan(String maDoan) {
		
		return doanDAO.getByMaDoan(maDoan);
	}
	
	public Vector<String> getAllMaDoan() {
		
		return doanDAO.getAllMaDoan();
	}

	public DoanDTO getByMaTour(String maTour) {
		return doanDAO.getByMaTour(maTour);
	}

	public DoanDTO getByMaHDV(String maHDV) {
		return doanDAO.getByMaHDV(maHDV);
	}

	public void deleteById(String maDoan) {
		doanDAO.deleteById(maDoan);
	}

	public void add(DoanDTO dto) {
		doanDAO.add(dto);
	}

	public void update(DoanDTO dto) {
		doanDAO.update(dto);
	}
	
}
