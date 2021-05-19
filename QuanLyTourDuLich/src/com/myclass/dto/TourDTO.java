package com.myclass.dto;

public class TourDTO {
	private String maTour;
	private String tenTour;
	private double giaVe;
	private String diemKhoiHanh;
	private String diemDen;
	
	public TourDTO() {}
	
	public TourDTO(String maTour, String tenTour, double giaVe, String diemKhoiHanh, String diemDen) {
		this.maTour = maTour;
		this.tenTour = tenTour;
		this.giaVe = giaVe;
		this.diemKhoiHanh = diemKhoiHanh;
		this.diemDen = diemDen;
	}

	public String getMaTour() {
		return maTour;
	}

	public void setMaTour(String maTour) {
		this.maTour = maTour;
	}

	public String getTenTour() {
		return tenTour;
	}

	public void setTenTour(String tenTour) {
		this.tenTour = tenTour;
	}

	public double getGiaVe() {
		return giaVe;
	}

	public void setGiaVe(double giaVe) {
		this.giaVe = giaVe;
	}

	public String getDiemKhoiHanh() {
		return diemKhoiHanh;
	}

	public void setDiemKhoiHanh(String diemKhoiHanh) {
		this.diemKhoiHanh = diemKhoiHanh;
	}

	public String getDiemDen() {
		return diemDen;
	}

	public void setDiemDen(String diemDen) {
		this.diemDen = diemDen;
	}

}
