package com.myclass.dto;

public class HopDongDTO {
	private String maHD;
	private String ngayLapHD;
	private String noiDung;
	private String maTour;
	
	public HopDongDTO() {}

	public HopDongDTO(String maHD, String ngayLapHD, String noiDung, String maTour) {
		super();
		this.maHD = maHD;
		this.ngayLapHD = ngayLapHD;
		this.noiDung = noiDung;
		this.maTour = maTour;
	}

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public String getNgayLapHD() {
		return ngayLapHD;
	}

	public void setNgayLapHD(String ngayLapHD) {
		this.ngayLapHD = ngayLapHD;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public String getMaTour() {
		return maTour;
	}

	public void setMaTour(String maTour) {
		this.maTour = maTour;
	}
	
}
