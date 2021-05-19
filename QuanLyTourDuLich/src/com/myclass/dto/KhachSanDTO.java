package com.myclass.dto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thin
 */
public class KhachSanDTO {
    String maKS;
    String tenKS;
    String diachiKS;
    String website;
    String soDT;
    int chiphi;
    public KhachSanDTO(){
        
    }

    public KhachSanDTO(String tenKS, String diachiKS, String website, String soDT, int chiphi) {
        this.tenKS = tenKS;
        this.diachiKS = diachiKS;
        this.website = website;
        this.soDT = soDT;
        this.chiphi = chiphi;
    }

    public KhachSanDTO(String maKS, String tenKS, String diachiKS, String website, String soDT, int chiphi) {
        this.maKS = maKS;
        this.tenKS = tenKS;
        this.diachiKS = diachiKS;
        this.website = website;
        this.soDT = soDT;
        this.chiphi = chiphi;
    }

    public String getMaKS() {
        return maKS;
    }

    public void setMaKS(String maKS) {
        this.maKS = maKS;
    }

    public String getTenKS() {
        return tenKS;
    }

    public void setTenKS(String tenKS) {
        this.tenKS = tenKS;
    }

    public String getDiachiKS() {
        return diachiKS;
    }

    public void setDiachiKS(String diachiKS) {
        this.diachiKS = diachiKS;
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
