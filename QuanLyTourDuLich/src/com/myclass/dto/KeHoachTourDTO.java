package com.myclass.dto;

public class KeHoachTourDTO {
	private String maKeHoach;
	private String ngayBatDau;
	private String ngayKetThuc;
	private String maTour;
	
	public KeHoachTourDTO() {}

	public KeHoachTourDTO(String maKeHoach, String ngayBatDau, String ngayKetThuc, String maTour) {
		super();
		this.maKeHoach = maKeHoach;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.maTour = maTour;
	}

	public String getMaKeHoach() {
		return maKeHoach;
	}

	public void setMaKeHoach(String maKeHoach) {
		this.maKeHoach = maKeHoach;
	}

	public String getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(String ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public String getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(String ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public String getMaTour() {
		return maTour;
	}

	public void setMaTour(String maTour) {
		this.maTour = maTour;
	}
	
}
