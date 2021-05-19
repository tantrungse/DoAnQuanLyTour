package com.myclass.bus;

import java.util.ArrayList;

import com.myclass.dao.KhachHangDAO;
import com.myclass.dto.KhachHangDTO;
import com.myclass.dto.TaiKhoanDTO;

public class KhachHangBUS {
	private static KhachHangDAO khachHangDAO = new KhachHangDAO(); 
	public static ArrayList<KhachHangDTO> listKhachHangDTO = khachHangDAO.getAll();
	
	public KhachHangBUS() {}
	
	public ArrayList<KhachHangDTO> getByHoKH(String HoKH) {
		return khachHangDAO.getByHoKH(HoKH);
	}
	
	
	public ArrayList<KhachHangDTO> getByTenKH(String tenKH) {
		return khachHangDAO.getByTenKH(tenKH);
	}
	
	public ArrayList<KhachHangDTO> getByMaKH(String MaKH) {
		return khachHangDAO.getByMaKH(MaKH);
	}
	
	public ArrayList<KhachHangDTO> getAll() {
		return khachHangDAO.getAll();
	}
	
	
	public void add(KhachHangDTO dto) {
		khachHangDAO.add(dto);
	}
	
	public void update(KhachHangDTO dto) {
		khachHangDAO.update(dto);
	}
	
	public void deleteById(String maKH) {
		khachHangDAO.deleteById(maKH);
	}
	
	public int getSoNguoiByMaDoan(String maDoan) {
		int soNguoi = 0;
		
		for(KhachHangDTO kh : listKhachHangDTO) {
			if(kh.getMaDoan().equals(maDoan)) {
				soNguoi += 1;
			}
		}
		
		return soNguoi;
	}
}
