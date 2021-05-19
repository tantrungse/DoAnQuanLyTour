//<<<<<<< HEAD
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//=======
//>>>>>>> parent of 0825b5e (6:32)
package com.myclass.dto;

public class CTThuChiDTO {
	private String maCTThuChi;
	private double tongThu;
	private double tongChi;
	private double doanhThu;
	private String maCTKHTour;
	
	public CTThuChiDTO() {}

	public CTThuChiDTO(String maCTThuChi, double tongThu, double tongChi, double doanhThu, String maCTKHTour) {
		super();
		this.maCTThuChi = maCTThuChi;
		this.tongThu = tongThu;
		this.tongChi = tongChi;
		this.doanhThu = doanhThu;
		this.maCTKHTour = maCTKHTour;
	}

	public String getMaCTThuChi() {
		return maCTThuChi;
	}

	public void setMaCTThuChi(String maCTThuChi) {
		this.maCTThuChi = maCTThuChi;
	}

	public double getTongThu() {
		return tongThu;
	}

	public void setTongThu(double tongThu) {
		this.tongThu = tongThu;
	}

	public double getTongChi() {
		return tongChi;
	}

	public void setTongChi(double tongChi) {
		this.tongChi = tongChi;
	}

	public double getDoanhThu() {
		return doanhThu;
	}

	public void setDoanhThu(double doanhThu) {
		this.doanhThu = doanhThu;
	}

	public String getMaCTKHTour() {
		return maCTKHTour;
	}

	public void setMaCTKHTour(String maCTKHTour) {
		this.maCTKHTour = maCTKHTour;
	}
	
}
