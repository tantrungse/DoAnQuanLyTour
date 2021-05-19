package com.myclass.dto;

public class PhuongTienDTO {
	private String maPhuongTien;
	private String tenPhuongTien;
	private double chiPhi;
	private int soChoNgoi;
	
	public PhuongTienDTO() {}

	public PhuongTienDTO(String maPhuongTien, String tenPhuongTien, double chiPhi, int soChoNgoi) {
		super();
		this.maPhuongTien = maPhuongTien;
		this.tenPhuongTien = tenPhuongTien;
		this.chiPhi = chiPhi;
		this.soChoNgoi = soChoNgoi;
	}

	public String getMaPhuongTien() {
		return maPhuongTien;
	}

	public void setMaPhuongTien(String maPhuongTien) {
		this.maPhuongTien = maPhuongTien;
	}

	public String getTenPhuongTien() {
		return tenPhuongTien;
	}

	public void setTenPhuongTien(String tenPhuongTien) {
		this.tenPhuongTien = tenPhuongTien;
	}

	public double getChiPhi() {
		return chiPhi;
	}

	public void setChiPhi(double chiPhi) {
		this.chiPhi = chiPhi;
	}

	public int getSoChoNgoi() {
		return soChoNgoi;
	}

	public void setSoChoNgoi(int soChoNgoi) {
		this.soChoNgoi = soChoNgoi;
	}

}
