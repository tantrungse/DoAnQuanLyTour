package com.myclass.bus;

import java.sql.SQLException;
import java.util.ArrayList;

import com.myclass.dao.KHTourDAO;
import com.myclass.dao.TourDAO;
import com.myclass.dto.KeHoachTourDTO;
import com.myclass.dto.TourDTO;

public class KHTourBUS {
	private static KHTourDAO khTourDAO = new KHTourDAO();
	public static ArrayList<KeHoachTourDTO> listKHTourDTO = khTourDAO.getAll();
	
	public KHTourBUS() {}
	
	public KeHoachTourDTO getById(String maKHTour) {
		
		return khTourDAO.getById(maKHTour);
	}
	
	
	public void add(KeHoachTourDTO dto) throws SQLException {
		khTourDAO.add(dto);
	}
	
	public void update(KeHoachTourDTO dto) throws SQLException {
		khTourDAO.update(dto);
	}
	
	public void deteleById(String maKHTour) throws SQLException {
		khTourDAO.deteleById(maKHTour);
	}
}
