package com.myclass.dto;

public class PhuongTienDTO{
    
    private String maPT;
    private String tenPT;
    private String diachi;
    private int sochongoi;
    private String soDT;
    private int chiphi;
    
    public PhuongTienDTO(){
        
    }

    public PhuongTienDTO(String tenPT, String diachi, int sochongoi, String soDT, int chiphi) {
        this.tenPT = tenPT;
        this.diachi = diachi;
        this.sochongoi = sochongoi;
        this.soDT = soDT;
        this.chiphi = chiphi;
    }

    public PhuongTienDTO(String maPT, String tenPT, String diachi, int sochongoi, String soDT, int chiphi) {
        this.maPT = maPT;
        this.tenPT = tenPT;
        this.diachi = diachi;
        this.sochongoi = sochongoi;
        this.soDT = soDT;
        this.chiphi = chiphi;
    }

    public String getMaPT() {
        return maPT;
    }

    public void setMaPT(String maPT) {
        this.maPT = maPT;
    }

    public String getTenPT() {
        return tenPT;
    }

    public void setTenPT(String tenPT) {
        this.tenPT = tenPT;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getSochongoi() {
        return sochongoi;
    }

    public void setSochongoi(int sochongoi) {
        this.sochongoi = sochongoi;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public int getChiphi() {
        return chiphi;
    }

    public void setChiphi(int chiphi) {
        this.chiphi = chiphi;
    }
    
    
}