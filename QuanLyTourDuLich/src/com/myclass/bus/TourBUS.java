package com.myclass.bus;

import java.util.ArrayList;

import com.myclass.dao.TourDAO;
import com.myclass.dto.TourDTO;

public class TourBUS {
	private static TourDAO tourDAO = new TourDAO(); 
	public static ArrayList<TourDTO> listTourDTO = tourDAO.getAll();
	
	public TourBUS() {}
	
	public ArrayList<TourDTO> getByMaTour(String MaTour) {
		listTourDTO = tourDAO.getByMaTour(MaTour);
		return listTourDTO;
	}
	
	public ArrayList<TourDTO> getByTenTour(String TenTour) {
		listTourDTO = tourDAO.getByTenTour(TenTour);
		return listTourDTO;
	}
	
	
	public void add(TourDTO dto) {
		tourDAO.add(dto);
	}
	
	public void update(TourDTO dto) {
		tourDAO.update(dto);
	}
	
	public void deleteById(String maTour) {
		tourDAO.deleteById(maTour);
	}
	
	public ArrayList<TourDTO> getAll() {
		listTourDTO = tourDAO.getAll();
		return listTourDTO;
	}
}
