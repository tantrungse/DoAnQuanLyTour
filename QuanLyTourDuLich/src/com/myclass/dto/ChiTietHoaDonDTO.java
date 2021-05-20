

package com.myclass.dto;

public class ChiTietHoaDonDTO {
    private String maHoaDon;
    public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	private String tenTour;
    private String tenKH;
    private int SoLuongTour;
    private float giaVe,ThanhTien;
	
	public ChiTietHoaDonDTO(String maHoaDon, String tenTour, int SoLuongTour, float giaVe, float thanhTien,String tenKH) {
		super();
           this.maHoaDon=maHoaDon;
           this.tenKH=tenKH;
           this.tenTour=tenTour;
           this.SoLuongTour=SoLuongTour;
           this.giaVe=giaVe;
           this.ThanhTien=thanhTien;
	
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public ChiTietHoaDonDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String gettenTour() {
		return tenTour;
	}
	public void settenTour(String tenTour) {
		this.tenTour = tenTour;
	}
	public int getSoLuongTour() {
		return SoLuongTour;
	}
	public void setSoLuongTour(int soLuongTour) {
		SoLuongTour = soLuongTour;
	}
	public float getGiaVe() {
		return giaVe;
	}
	public void setGiaVe(float giaVe) {
		this.giaVe = giaVe;
	}
	public float getThanhTien() {
		return ThanhTien;
	}
	public void setThanhTien(float thanhTien) {
		ThanhTien = thanhTien;
	}
}




