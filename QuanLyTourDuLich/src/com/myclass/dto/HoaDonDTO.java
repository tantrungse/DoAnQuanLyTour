
package com.myclass.dto;

import java.time.LocalDate;

public class HoaDonDTO {
    private String maHoaDon,maKH,maKM;
    private float TongTien;
    private LocalDate NgayLap;
    private  String noidungKM;


    public HoaDonDTO(String maHoaDon, String maKH, String maKM, String noidungkm,
			float tongTien, LocalDate ngayLap) {
		super();
		this.maHoaDon = maHoaDon;
		this.maKH = maKH;
		this.maKM = maKM;
		noidungKM=noidungkm;
		TongTien = tongTien;
		noidungKM=noidungkm;
		NgayLap = ngayLap;
	
	}

	public String getnoidungKM() {
		return noidungKM;
	}

	public void setnoidungKM(String noidungkm) {
		noidungKM = noidungkm;
	}

	public HoaDonDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getMaKM() {
		return maKM;
	}

	public void setMaKM(String maKM) {
		this.maKM = maKM;
	}

	public LocalDate getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(LocalDate NgayLap) {
        this.NgayLap = NgayLap;
    }

  

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float TongTien) {
        this.TongTien = TongTien;
    }

   
}
















