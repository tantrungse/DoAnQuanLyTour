/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myclass.bus;

import com.myclass.dao.NhaHangDAO;
import com.myclass.dto.NhaHangDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thin
 */
public class NhaHangBUS {
    
    static List<NhaHangDTO> nhahangList = new ArrayList<>();
    
    public static List<NhaHangDTO> xemDSNH(){
        nhahangList = NhaHangDAO.xemDSNH();
        return nhahangList;
    }
    
    public static void luuTTNH(NhaHangDTO nhDTO){
        NhaHangDAO.luuTTNH(nhDTO);
    }
    
    public static List<NhaHangDTO> findByMaNH(String maNH){
        nhahangList = NhaHangDAO.findByMaNH(maNH);
        return nhahangList;
    }
    
    public static List<NhaHangDTO> findByTenNH(String tenNH){
        nhahangList = NhaHangDAO.findByTenNH(tenNH);
        return nhahangList;
    }
    
    public static void XoaTTNH(String maNH){
        NhaHangDAO.XoaTTNH(maNH);
    }
    
    public static void CapNhatTTNH(NhaHangDTO nhDTO){
        NhaHangDAO.CapNhatTTNH(nhDTO);
    }
}
