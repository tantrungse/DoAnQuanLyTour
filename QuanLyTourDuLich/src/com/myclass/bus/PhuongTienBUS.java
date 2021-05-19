/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myclass.bus;

import com.myclass.dao.PhuongTienDAO;
import com.myclass.dto.PhuongTienDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thin
 */
public class PhuongTienBUS {
    
    static List<PhuongTienDTO> phuongtienList = new ArrayList<>();
    
    public static List<PhuongTienDTO> XemDSPT(){
        phuongtienList = PhuongTienDAO.XemDSPT();
        return phuongtienList;
    }
    
    public static void luuDSPT(PhuongTienDTO ptDTO){
        PhuongTienDAO.luuDSPT(ptDTO);
    }
    
    public static void xoaDSPT(String maPT){
        PhuongTienDAO.XoaDSPT(maPT);
    }
    
    public static List<PhuongTienDTO> findByMaPT(String maPT){
        phuongtienList = PhuongTienDAO.findByMaPT(maPT);
        return phuongtienList;
    }
    
    public static List<PhuongTienDTO> findByTenPT(String tenPT){
        phuongtienList = PhuongTienDAO.findByTenPT(tenPT);
        return phuongtienList;
    }
    
    public static void CapNhatTTPT(PhuongTienDTO ptDTO) {
        PhuongTienDAO.CapNhatTTPT(ptDTO);
    }
}
