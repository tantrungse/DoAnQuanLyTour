/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myclass.dto;

/**
 *
 * @author Thin
 */
public class NhaHangDTO {
    private String maNH;
    private String tenNH;
    private String diachi;
    private String website;
    private String soDT;
    private int chiphi;
    
    public NhaHangDTO(){
        
    }

    public NhaHangDTO(String tenNH, String diachi, String website, String soDT, int chiphi) {
        this.tenNH = tenNH;
        this.diachi = diachi;
        this.website = website;
        this.soDT = soDT;
        this.chiphi = chiphi;
    }

    public NhaHangDTO(String maNH, String tenNH, String diachi, String website, String soDT, int chiphi) {
        this.maNH = maNH;
        this.tenNH = tenNH;
        this.diachi = diachi;
        this.website = website;
        this.soDT = soDT;
        this.chiphi = chiphi;
    }

    public String getMaNH() {
        return maNH;
    }

    public void setMaNH(String maNH) {
        this.maNH = maNH;
    }

    public String getTenNH() {
        return tenNH;
    }

    public void setTenNH(String tenNH) {
        this.tenNH = tenNH;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
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
