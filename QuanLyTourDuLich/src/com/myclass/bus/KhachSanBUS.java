/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myclass.bus;

import com.myclass.dao.KhachSanDAO;
import com.myclass.dto.KhachSanDTO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thin
 */
public class KhachSanBUS {
    
    static List<KhachSanDTO> khachsanList = new ArrayList<>();
    
    public static List<KhachSanDTO> xemDSKS(){ 
        khachsanList = KhachSanDAO.xemDSKS();  
        return khachsanList;
    }
    
    public static void XoaTTKS(String maKS){
        KhachSanDAO.XoaTTKS(maKS);
    }
    
    public static void LuuTTKS(KhachSanDTO ksDTO){
        KhachSanDAO.LuuTTKS(ksDTO);
    }
    
    public static List<KhachSanDTO> findByMaKS(String maKS){
        khachsanList = KhachSanDAO.findByMaKS(maKS);
        return khachsanList;
    }
    
    public static List<KhachSanDTO> findByTenKS(String tenKS){
        khachsanList = KhachSanDAO.findByTenKS(tenKS);
        return khachsanList;
    }
    
    public static void CapNhatTTKS(KhachSanDTO ksDTO){
        KhachSanDAO.CapNhatTTKS(ksDTO);
    }
}
