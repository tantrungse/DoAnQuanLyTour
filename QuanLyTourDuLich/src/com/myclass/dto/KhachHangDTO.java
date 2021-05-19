package com.myclass.dto;

public class KhachHangDTO {
	private String maKH;
	private String hoTenKH;
	private String diaChi;
	private String sdt;
	private String maDoan;
	
	public KhachHangDTO() {}

	public KhachHangDTO(String maKH, String hoTenKH, String diaChi, String sdt, String maDoan) {
		super();
		this.maKH = maKH;
		this.hoTenKH = hoTenKH;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.maDoan = maDoan;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getHoTenKH() {
		return hoTenKH;
	}

	public void setHoTenKH(String hoTenKH) {
		this.hoTenKH = hoTenKH;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getMaDoan() {
		return maDoan;
	}

	public void setMaDoan(String maDoan) {
		this.maDoan = maDoan;
	}
	
}
