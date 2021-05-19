package com.myclass.dto;

public class HuongDanVienDTO {
	private String maHDV;
	private String hoTen;
	private String ngaySinh;
	private String gioiTinh;
	private String diaChi;
	private String sdt;
	
	public HuongDanVienDTO() {}

	public HuongDanVienDTO(String maHDV, String hoTen, String ngaySinh, String gioiTinh, String diaChi, String sdt) {
		super();
		this.maHDV = maHDV;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.sdt = sdt;
	}

	public String getMaHDV() {
		return maHDV;
	}

	public void setMaHDV(String maHDV) {
		this.maHDV = maHDV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
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
	
}
