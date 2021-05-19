/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.DiaDiemThamQuanDAO;
import DTO.DiaDiemThamQuanDTO;
import DTO.KhachSanDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thin
 */
public class DiaDiemThamQuanBUS {
    
    static List<DiaDiemThamQuanDTO> diadiemList = new ArrayList<>();
    
    public static List<DiaDiemThamQuanDTO> xemDSDD(){
         diadiemList = DiaDiemThamQuanDAO.xemDSDD();
         return  diadiemList;
    }
    
    public static void XoaTTDD(String MaDiaDiem){
        DiaDiemThamQuanDAO.XoaTTDD(MaDiaDiem);
    }
    
    public static void LuuTTDD(DiaDiemThamQuanDTO ddDTO){
        DiaDiemThamQuanDAO.LuuTTDD(ddDTO);
    }
    
    public static List<DiaDiemThamQuanDTO> findByMaDD(String MaDiaDiem) {
        diadiemList = DiaDiemThamQuanDAO.findByMaDD(MaDiaDiem);
        return diadiemList;
    }
    
    public static List<DiaDiemThamQuanDTO> findByTenDD(String TenDiaDiem) {
        diadiemList = DiaDiemThamQuanDAO.findByTenDD(TenDiaDiem);
        return diadiemList;
    }
    
    public static void CapNhatTTDD(DiaDiemThamQuanDTO ddDTO){
        DiaDiemThamQuanDAO.CapNhatTTDD(ddDTO);
    }
}
