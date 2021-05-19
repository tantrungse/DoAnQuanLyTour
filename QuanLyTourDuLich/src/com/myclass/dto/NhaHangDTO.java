package com.myclass.dto;

public class NhaHangDTO {
	private String maNhaHang;
	private String tenNhaHang;
	private String diaChi;
	private double chiPhiTrenNguoi;
    
    public NhaHangDTO(){
        
    }

	public NhaHangDTO(String maNhaHang, String tenNhaHang, String diaChi, double chiPhiTrenNguoi) {
		super();
		this.maNhaHang = maNhaHang;
		this.tenNhaHang = tenNhaHang;
		this.diaChi = diaChi;
		this.chiPhiTrenNguoi = chiPhiTrenNguoi;
	}

	public String getMaNhaHang() {
		return maNhaHang;
	}

	public void setMaNhaHang(String maNhaHang) {
		this.maNhaHang = maNhaHang;
	}

	public String getTenNhaHang() {
		return tenNhaHang;
	}

	public void setTenNhaHang(String tenNhaHang) {
		this.tenNhaHang = tenNhaHang;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public double getChiPhiTrenNguoi() {
		return chiPhiTrenNguoi;
	}

	public void setChiPhiTrenNguoi(double chiPhiTrenNguoi) {
		this.chiPhiTrenNguoi = chiPhiTrenNguoi;
	}

}
