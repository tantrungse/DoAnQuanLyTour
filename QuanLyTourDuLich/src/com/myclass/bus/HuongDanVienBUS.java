package com.myclass.bus;

import java.util.ArrayList;

import com.myclass.dao.HuongDanVienDAO;
import com.myclass.dao.TourDAO;
import com.myclass.dto.HuongDanVienDTO;
import com.myclass.dto.TourDTO;

public class HuongDanVienBUS {
	private static HuongDanVienDAO huongDanVienDAO = new HuongDanVienDAO(); 
	public static ArrayList<HuongDanVienDTO> listHuongDanVienDTO = huongDanVienDAO.getAll();
	
	public HuongDanVienBUS() {}
	
	public ArrayList<HuongDanVienDTO> getByMaHDV(String MaHDV) {
		listHuongDanVienDTO = huongDanVienDAO.getByMaHDV(MaHDV);
		return listHuongDanVienDTO;
	}
	
	public ArrayList<HuongDanVienDTO> getByTenHDV(String TenHDV) {
		listHuongDanVienDTO = huongDanVienDAO.getByTenHDV(TenHDV);
		return listHuongDanVienDTO;
	}
	
	public ArrayList<HuongDanVienDTO> getByHoHDV(String HoHDV) {
		listHuongDanVienDTO = huongDanVienDAO.getByHoHDV(HoHDV);
		return listHuongDanVienDTO;
	}
	
	
	public void add(HuongDanVienDTO dto) {
		huongDanVienDAO.add(dto);
	}
	
	public void update(HuongDanVienDTO dto) {
		huongDanVienDAO.update(dto);
	}
	
	public void deleteById(String maHDV) {
		huongDanVienDAO.deleteById(maHDV);
	}
	
	public ArrayList<HuongDanVienDTO> getAll() {
		listHuongDanVienDTO = huongDanVienDAO.getAll();
		return listHuongDanVienDTO;
	}
}
