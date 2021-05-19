package com.myclass.dto;

public class CTKeHoachTourDTO {
	private String maCTKeHoach;
	private String maPhuongTien;
	private String maNhaHang;
	private String maKhachSan;
	private String maDiaDiemThamQuan;
	private String maCTThuChi;
	
	public CTKeHoachTourDTO() {}

	public CTKeHoachTourDTO(String maCTKeHoach, String maPhuongTien, String maNhaHang, String maKhachSan,
			String maDiaDiemThamQuan, String maCTThuChi) {
		super();
		this.maCTKeHoach = maCTKeHoach;
		this.maPhuongTien = maPhuongTien;
		this.maNhaHang = maNhaHang;
		this.maKhachSan = maKhachSan;
		this.maDiaDiemThamQuan = maDiaDiemThamQuan;
		this.maCTThuChi = maCTThuChi;
	}

	public String getMaCTKeHoach() {
		return maCTKeHoach;
	}

	public void setMaCTKeHoach(String maCTKeHoach) {
		this.maCTKeHoach = maCTKeHoach;
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

	public String getMaDiaDiemThamQuan() {
		return maDiaDiemThamQuan;
	}

	public void setMaDiaDiemThamQuan(String maDiaDiemThamQuan) {
		this.maDiaDiemThamQuan = maDiaDiemThamQuan;
	}

	public String getMaCTThuChi() {
		return maCTThuChi;
	}

	public void setMaCTThuChi(String maCTThuChi) {
		this.maCTThuChi = maCTThuChi;
	}
	
}
