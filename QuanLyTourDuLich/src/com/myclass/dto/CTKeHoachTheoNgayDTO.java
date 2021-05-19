package com.myclass.dto;

public class CTKeHoachTheoNgayDTO {
	private String maCTKHTheoNgay;
	private String ngay;
	private String maKHTour;
	private String maDiaDiemThamQuan;
	private String maPhuongTien;
	private String maNhaHang;
	private String maKhachSan;
	
	public CTKeHoachTheoNgayDTO() {}

	public CTKeHoachTheoNgayDTO(String maCTKHTheoNgay, String ngay, String maKHTour, String maDiaDiemThamQuan, String maPhuongTien, String maNhaHang, String maKhachSan) {
		this.maCTKHTheoNgay = maCTKHTheoNgay;
		this.ngay = ngay;
		this.maKHTour = maKHTour;
		this.maDiaDiemThamQuan = maDiaDiemThamQuan;
		this.maPhuongTien = maPhuongTien;
		this.maNhaHang = maNhaHang;
		this.maKhachSan = maKhachSan;
	}

	public String getMaCTKHTheoNgay() {
		return maCTKHTheoNgay;
	}

	public void setMaCTKHTheoNgay(String maCTKHTheoNgay) {
		this.maCTKHTheoNgay = maCTKHTheoNgay;
	}

	public String getNgay() {
		return ngay;
	}

	public void setNgay(String ngay) {
		this.ngay = ngay;
	}
	
	public String getMaKHTour() {
		return maKHTour;
	}

	public void setMaKHTour(String maKHTour) {
		this.maKHTour = maKHTour;
	}

	public String getMaDiaDiemThamQuan() {
		return maDiaDiemThamQuan;
	}

	public void setMaDiaDiemThamQuan(String maDiaDiemThamQuan) {
		this.maDiaDiemThamQuan = maDiaDiemThamQuan;
	}

	public String getMaPhuongTien() {
		return maPhuongTien;
	}

	public void setMaPhuongTien(String maPhuongTien) {
		this.maPhuongTien = maPhuongTien;
	}

	public String getMaNhaHang() {
		return maNhaHang;
	}

	public void setMaNhaHang(String maNhaHang) {
		this.maNhaHang = maNhaHang;
	}

	public String getMaKhachSan() {
		return maKhachSan;
	}

	public void setMaKhachSan(String maKhachSan) {
		this.maKhachSan = maKhachSan;
	}
	
}
