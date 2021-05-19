package com.myclass.dto;

import java.sql.Date;

public class ChuongTrinhKMDTO {
  private String maKM;
  private String maTourKM;
  private String tenTourKM;
  private String noidungKM;
  private String timeStartKM;
  private String timeEndKM;
public String getMaKM() {
	return maKM;
}
public void setMaKM(String maKM) {
	this.maKM = maKM;
}
public String getMaTourKM() {
	return maTourKM;
}
public void setMaTourKM(String maTourKM) {
	this.maTourKM = maTourKM;
}
public String getTenTourKM() {
	return tenTourKM;
}
public void setTenTourKM(String tenTourKM) {
	this.tenTourKM = tenTourKM;
}
public String getNoidungKM() {
	return noidungKM;
}
public void setNoidungKM(String noidungKM) {
	this.noidungKM = noidungKM;
}
public String getTimeStartKM() {
	return timeStartKM;
}
public void setTimeStartKM(String timeStartKM) {
	this.timeStartKM = timeStartKM;
}
public String getTimeEndKM() {
	return timeEndKM;
}
public void setTimeEndKM(String timeEndKM) {
	this.timeEndKM = timeEndKM;
}
public ChuongTrinhKMDTO(String maKM, String maTourKM, String tenTourKM, String noidungKM, String timeStartKM,
		String timeEndKM) {
	
	this.maKM = maKM;
	this.maTourKM = maTourKM;
	this.tenTourKM = tenTourKM;
	this.noidungKM = noidungKM;
	this.timeStartKM = timeStartKM;
	this.timeEndKM = timeEndKM;
}
public ChuongTrinhKMDTO() {
	super();
	// TODO Auto-generated constructor stub
}
  
 }
