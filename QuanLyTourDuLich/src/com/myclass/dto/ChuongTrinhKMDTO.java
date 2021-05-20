package com.myclass.dto;

import java.sql.Date;
import java.time.LocalDate;

public class ChuongTrinhKMDTO {
  private String maKM;

  private String tenTourKM;
  private String noidungKM;
  private LocalDate timeStartKM;
  private LocalDate timeEndKM;
public String getMaKM() {
	return maKM;
}
public void setMaKM(String maKM) {
	this.maKM = maKM;
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
public LocalDate getTimeStartKM() {
	return timeStartKM;
}
public void setTimeStartKM(LocalDate timeStartKM) {
	this.timeStartKM = timeStartKM;
}
public LocalDate getTimeEndKM() {
	return timeEndKM;
}
public void setTimeEndKM(LocalDate timeEndKM) {
	this.timeEndKM = timeEndKM;
}
public ChuongTrinhKMDTO(String maKM, String tenTourKM, String noidungKM, LocalDate daystart,
		LocalDate dayend) {
	
	this.maKM = maKM;
	
	this.tenTourKM = tenTourKM;
	this.noidungKM = noidungKM;
	this.timeStartKM = daystart;
	this.timeEndKM = dayend;
}
public ChuongTrinhKMDTO() {
	super();
	// TODO Auto-generated constructor stub
}
  
 }
