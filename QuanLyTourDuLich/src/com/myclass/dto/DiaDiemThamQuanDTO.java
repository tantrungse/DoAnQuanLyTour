package com.myclass.dto;

public class DiaDiemThamQuanDTO {
	private String maDiaDiem;
	private String tenDiaDiem;
	private String diaChi;
	
	public DiaDiemThamQuanDTO() {}

	public DiaDiemThamQuanDTO(String maDiaDiem, String tenDiaDiem, String diaChi) {
		super();
		this.maDiaDiem = maDiaDiem;
		this.tenDiaDiem = tenDiaDiem;
		this.diaChi = diaChi;
	}

	public String getMaDiaDiem() {
		return maDiaDiem;
	}

	public void setMaDiaDiem(String maDiaDiem) {
		this.maDiaDiem = maDiaDiem;
	}

	public String getTenDiaDiem() {
		return tenDiaDiem;
	}

	public void setTenDiaDiem(String tenDiaDiem) {
		this.tenDiaDiem = tenDiaDiem;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
}
