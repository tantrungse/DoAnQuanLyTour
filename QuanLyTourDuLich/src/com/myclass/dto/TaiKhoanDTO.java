package com.myclass.dto;

public class TaiKhoanDTO {
	private String tenTK;
	private String matKhau;
	private int quyen;
	
	public TaiKhoanDTO() {}

	public TaiKhoanDTO(String tenTK, String matKhau, int quyen) {
		super();
		this.tenTK = tenTK;
		this.matKhau = matKhau;
		this.quyen = quyen;
	}

	public String getTenTK() {
		return tenTK;
	}

	public void setTenTK(String tenTK) {
		this.tenTK = tenTK;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public int getQuyen() {
		return quyen;
	}

	public void setQuyen(int quyen) {
		this.quyen = quyen;
	}
	
}
