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
public class DiaDiemThamQuanDTO {
    private String maDD; // mã địa điểm
    private String tenDD;   //tên địa điểm
    private String ND;  //nội dung tham quan
    private String diachi;

    public DiaDiemThamQuanDTO() {
    }

    public DiaDiemThamQuanDTO(String tenDD, String ND, String diachi) {
        this.tenDD = tenDD;
        this.ND = ND;
        this.diachi = diachi;
    }

    public DiaDiemThamQuanDTO(String maDD, String tenDD, String ND, String diachi) {
        this.maDD = maDD;
        this.tenDD = tenDD;
        this.ND = ND;
        this.diachi = diachi;
    }

    public String getMaDD() {
        return maDD;
    }

    public void setMaDD(String maDD) {
        this.maDD = maDD;
    }

    public String getTenDD() {
        return tenDD;
    }

    public void setTenDD(String tenDD) {
        this.tenDD = tenDD;
    }

    public String getND() {
        return ND;
    }

    public void setND(String ND) {
        this.ND = ND;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

}