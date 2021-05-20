/*
z * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excel;

/**
 *
 * @author Piger Streaming
 */
import com.myclass.dto.*;
import com.myclass.bus.*;

import java.awt.FileDialog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class DocExcel {
	ChuongTrinhKMBUS khuyenMaiBUS = new ChuongTrinhKMBUS();

    FileDialog fd = new FileDialog(new JFrame(), "Đọc excel", FileDialog.LOAD);

    public DocExcel() {

    }
    private String getFile() {
        fd.setFile("*.xls");
        fd.setVisible(true);
        String url = fd.getDirectory() + fd.getFile();
        if (url.equals("nullnull")) {
            return null;
        }
        return url;
    }
    
    
     //Đọc file excel Hóa đơn
    
    public void docFileExcelHoaDon() {
        fd.setTitle("Nhập dữ liệu hóa đơn từ excel");
        String url = getFile();
        if (url == null) {
            return;
        }

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File(url));

            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            HSSFSheet sheet = workbook.getSheetAt(0);
           Iterator<Row> rowIterator = sheet.iterator();
            Row row1 = rowIterator.next();

            String hanhDongKhiTrung = "";
            int countThem = 0;
            int countGhiDe = 0;
            int countBoQua = 0;

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    String idhd = cellIterator.next().getStringCellValue();
                    String idkm = cellIterator.next().getStringCellValue(); // cần tách chuỗi
                    String idkh = cellIterator.next().getStringCellValue(); // cần tách chuỗi
                  
                    LocalDate ngaylap = LocalDate.parse(cellIterator.next().getStringCellValue());
                    String noidung =  cellIterator.next().getStringCellValue();
                    int tongtien =  (int) cellIterator.next().getNumericCellValue();
System.out.println(idhd + " " + idkm +" " +idkh+" " +ngaylap +" " + noidung+" "+ tongtien);
                    HoaDonBUS hoadonBUS = new HoaDonBUS();
                    HoaDonDTO hdOld = hoadonBUS.getHoaDonDTO(idhd);
                   
                    if (hdOld != null) {
                        if (!hanhDongKhiTrung.contains("tất cả")) {
                            MyTable mtb = new MyTable();
                            mtb.setHeaders(new String[]{"", "Mã hóa đơn", "Mã khuyến mãi", "Mã khách hàng", "Ngày lập", "% giảm giá", " Tổng tiền thanh toán" });
                            mtb.addRow(new String[]{
                                "Cũ:", hdOld.getMaHoaDon(),
                               hdOld.getMaKM(),
                                hdOld.getMaKH(),
                                String.valueOf(hdOld.getNgayLap()),
                                String.valueOf(hdOld.getnoidungKM()),
                                String.valueOf(hdOld.getTongTien()),
                            });
                            mtb.addRow(new String[]{
                                "Mới:", idhd,idkm, idkh, String.valueOf(ngaylap), String.valueOf(noidung), String.valueOf(tongtien)            
                            });

                            MyJOptionPane mop = new MyJOptionPane(mtb, hanhDongKhiTrung);
                            hanhDongKhiTrung = mop.getAnswer();
                        }
                        if (hanhDongKhiTrung.contains("Ghi đè")) {
                           HoaDonDTO DTO = new HoaDonDTO(idhd, idkh, idkm, noidung, tongtien,ngaylap);
                            hoadonBUS.sua(DTO,HoaDonBUS.timViTri(idhd));
                           countGhiDe++;
                       } else {
                            countBoQua++;
                        }                      
                        
                    //Khi database trống    
                     
                    } else {          
                        HoaDonDTO hd = new HoaDonDTO(idhd, idkh, idkm,noidung, tongtien,ngaylap);
                        hoadonBUS.them(hd);
                        countThem++;
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Đọc thành công, "
                    + "Thêm " + countThem
                    + "; Ghi đè " + countGhiDe
                    + "; Bỏ qua " + countBoQua
                    + ". Vui lòng làm mới để thấy kết quả");
        } catch (Exception ex) {
            ex.printStackTrace();
           
            JOptionPane.showMessageDialog(null, "Lỗi khi nhập dữ liệu từ file: " + ex.getMessage());
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Lỗi khi đóng inputstream: " + ex.getMessage());
            }
        }
    }
    
    
     //Đọc file excel Khuyến mãi
    public void docFileExcelKhuyenMai() {
        fd.setTitle("Nhập dữ liệu khuyến mãi từ excel");
        String url = getFile();
        if (url == null) {
            return;
        }

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File(url));

            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            Row row1 = rowIterator.next();

            String hanhDongKhiTrung = "";
            int countThem = 0;
            int countGhiDe = 0;
            int countBoQua = 0;

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    String id = cellIterator.next().getStringCellValue();
                    String ten = cellIterator.next().getStringCellValue();
                    String noidung = cellIterator.next().getStringCellValue();
                    System.out.println(noidung);
                    LocalDate ngaybd = LocalDate.parse(cellIterator.next().getStringCellValue());
                    LocalDate ngaykt = LocalDate.parse(cellIterator.next().getStringCellValue());
                   

                    ChuongTrinhKMBUS khuyenmaiBUS = new ChuongTrinhKMBUS();
                    ChuongTrinhKMDTO kmOld = khuyenmaiBUS.get(id);
                   
                    if (kmOld != null) {
                        if (!hanhDongKhiTrung.contains("tất cả")) {
                            MyTable mtb = new MyTable();
                            mtb.setHeaders(new String[]{"Mã khuyến mãi", "Tên chương trình", "Nội dung", "Ngày bắt đầu", "Ngày kết thúc" });
                            mtb.addRow(new String[]{
                                "Cũ:", kmOld.getMaKM(),
                                kmOld.getTenTourKM(),
                                String.valueOf(kmOld.getNoidungKM()),
                                String.valueOf(kmOld.getTimeStartKM()),
                                String.valueOf(kmOld.getTimeEndKM()),
                             
                            });
                            mtb.addRow(new String[]{
                                "Mới:", id, ten,noidung, String.valueOf(ngaybd), String.valueOf(ngaykt)               
                            });

                            MyJOptionPane mop = new MyJOptionPane(mtb, hanhDongKhiTrung);
                            hanhDongKhiTrung = mop.getAnswer();
                        }
                        if (hanhDongKhiTrung.contains("Ghi đè")) {
                            ChuongTrinhKMDTO DTO = new ChuongTrinhKMDTO(id, ten,noidung, ngaybd, ngaykt);
                            khuyenmaiBUS.sua(DTO,ChuongTrinhKMBUS.timVitri(id));
                            countGhiDe++;
                        } else {
                            countBoQua++;
                        }                      
                        
                    //Khi database trống    
                     
                    } else {          
                        ChuongTrinhKMDTO km = new ChuongTrinhKMDTO(id, ten,noidung, ngaybd, ngaykt);
                        khuyenMaiBUS.add(km);
                        countThem++;
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Đọc thành công, "
                    + "Thêm " + countThem
                    + "; Ghi đè " + countGhiDe
                    + "; Bỏ qua " + countBoQua
                   );
        } catch (Exception ex) {
            ex.printStackTrace();
           
            JOptionPane.showMessageDialog(null, "Lỗi khi nhập dữ liệu từ file: " + ex.getMessage());
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Lỗi khi đóng inputstream: " + ex.getMessage());
            }
        }
    }
    
//     //Đọc file excel Khách hàng
//    public void docFileExcelKhachHang() {
//        fd.setTitle("Nhập dữ liệu món ăn từ excel");
//        String url = getFile();
//        if (url == null) {
//            return;
//        }
//
//        FileInputStream inputStream = null;
//        try {
//            inputStream = new FileInputStream(new File(url));
//
//            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
//            HSSFSheet sheet = workbook.getSheetAt(0);
//            Iterator<Row> rowIterator = sheet.iterator();
//            Row row1 = rowIterator.next();
//
//            String hanhDongKhiTrung = "";
//            int countThem = 0;
//            int countGhiDe = 0;
//            int countBoQua = 0;
//
//            while (rowIterator.hasNext()) {
//                Row row = rowIterator.next();
//                Iterator<Cell> cellIterator = row.cellIterator();
//
//                while (cellIterator.hasNext()) {
//                    String id = cellIterator.next().getStringCellValue();
//                    String ho = cellIterator.next().getStringCellValue();
//                    String ten = cellIterator.next().getStringCellValue();
//                    String gmail = cellIterator.next().getStringCellValue();
//                    String gioitinh = cellIterator.next().getStringCellValue();
//                    String sdt = cellIterator.next().getStringCellValue();
//                    float tongchitieu = (float) cellIterator.next().getNumericCellValue();
//
//                    KhachHangBUS khBUS = new KhachHangBUS();
//                    KhachHangDTO khOld = khBUS.getKhachHangDTO(id);
//
//                    
//                    
//                    if (khOld != null) {
//                        if (!hanhDongKhiTrung.contains("tất cả")) {
//                            MyTable mtb = new MyTable();
//                            mtb.setHeaders(new String[]{"", "Mã khách hàng", "Họ", "Tên", "Gmail", "Giới tính", "SĐT", "Tổng chi tiêu" });
//                            mtb.addRow(new String[]{
//                                "Cũ:", khOld.getIDKhachHang(),
//                                khOld.getHoKhachHang(),
//                                khOld.getTenKhachHang(),
//                                khOld.getGmail(),
//                                khOld.getGioiTinh(),
//                                khOld.getSoDienThoai(),
//                                String.valueOf(khOld.getTongChiTieu())
//                            });
//                            mtb.addRow(new String[]{
//                                "Mới:", id, ho, ten, gmail, gioitinh, sdt, String.valueOf(tongchitieu)                   
//                            });
//
//                            MyJOptionPane mop = new MyJOptionPane(mtb, hanhDongKhiTrung);
//                            hanhDongKhiTrung = mop.getAnswer();
//                        }
//                        if (hanhDongKhiTrung.contains("Ghi đè")) {
//                            KhachHangDTO DTO=new KhachHangDTO(id, ho, ten, gmail, gioitinh, sdt, tongchitieu, "Hiện");
//                            khBUS.sua(DTO,KhachHangBUS.timViTri(id));
//                            countGhiDe++;
//                        } else {
//                            countBoQua++;
//                        }                      
//                        
//                    //Khi database trống    
//                     
//                    } else {          
//                        KhachHangDTO khaha = new KhachHangDTO(id, ho, ten, gmail, gioitinh, sdt, tongchitieu, "Hiện");
//                        khBUS.them(khaha);
//                        countThem++;
//                    }
//                }
//            }
//            JOptionPane.showMessageDialog(null, "Đọc thành công, "
//                    + "Thêm " + countThem
//                    + "; Ghi đè " + countGhiDe
//                    + "; Bỏ qua " + countBoQua
//                    + ". Vui lòng làm mới để thấy kết quả");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//           
//            JOptionPane.showMessageDialog(null, "Lỗi khi nhập dữ liệu từ file: " + ex.getMessage());
//        } finally {
//            try {
//                if (inputStream != null) {
//                    inputStream.close();
//                }
//            } catch (IOException ex) {
//                JOptionPane.showMessageDialog(null, "Lỗi khi đóng inputstream: " + ex.getMessage());
//            }
//        }
//    }
//     //Đọc file excel Nhân viên
//    public void docFileExcelNhanVien() {
//        fd.setTitle("Nhập dữ liệu nhân viên từ excel");
//        String url = getFile();
//        if (url == null) {
//            return;
//        }
//
//        FileInputStream inputStream = null;
//        try {
//            inputStream = new FileInputStream(new File(url));
//
//            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
//            HSSFSheet sheet = workbook.getSheetAt(0);
//            Iterator<Row> rowIterator = sheet.iterator();
//            Row row1 = rowIterator.next();
//
//            String hanhDongKhiTrung = "";
//            int countThem = 0;
//            int countGhiDe = 0;
//            int countBoQua = 0;
//
//            while (rowIterator.hasNext()) {
//                Row row = rowIterator.next();
//                Iterator<Cell> cellIterator = row.cellIterator();
//
//                while (cellIterator.hasNext()) {
//                    String id = cellIterator.next().getStringCellValue();
//                    String ho = cellIterator.next().getStringCellValue();
//                    String ten = cellIterator.next().getStringCellValue();
//                    String gmail = cellIterator.next().getStringCellValue();
//                    String gioitinh = cellIterator.next().getStringCellValue();
//                    String sdt = cellIterator.next().getStringCellValue();
//                    String chucvu = cellIterator.next().getStringCellValue();
//
//                    NhanVienBUS nvBUS = new NhanVienBUS();
//                    NhanVienDTO nvOld = nvBUS.getNhanVienDTO(id);
//
//                    if (nvOld != null) {
//                        if (!hanhDongKhiTrung.contains("tất cả")) {
//                            MyTable mtb = new MyTable();
//                            mtb.setHeaders(new String[]{"", "Mã nhân viên", "Họ", "Tên", "Gmail", "Giới tính", "SĐT", "Chức vụ" });
//                            mtb.addRow(new String[]{
//                                "Cũ:", nvOld.getIDNhanVien(),
//                                nvOld.getHoNhanVien(),
//                                nvOld.getTenNhanVien(),
//                                nvOld.getGmail(),
//                                nvOld.getGioiTinh(),
//                                nvOld.getSoDienThoai(),
//                                nvOld.getChucVu(),
//                                
//                            });
//                            mtb.addRow(new String[]{
//                                "Mới:", id, ho, ten, gmail, gioitinh, sdt, chucvu                         
//                            });
//
//                            MyJOptionPane mop = new MyJOptionPane(mtb, hanhDongKhiTrung);
//                            hanhDongKhiTrung = mop.getAnswer();
//                        }
//                        if (hanhDongKhiTrung.contains("Ghi đè")) {
//                            NhanVienDTO DTO=new NhanVienDTO(id, ho, ten, gmail, gioitinh, sdt, chucvu, "Hiện");
//                            nvBUS.sua(DTO,NguyenLieuBUS.timViTri(id));
//                            countGhiDe++;
//                        } else {
//                            countBoQua++;
//                        }                      
//                        
//                    //Khi database trống    
//                     
//                    } else {          
//                        NhanVienDTO nhanvien = new NhanVienDTO(id, ho, ten, gmail, gioitinh, sdt, chucvu, "Hiện");
//                        nvBUS.them(nhanvien);
//                        countThem++;
//                    }
//                }
//            }
//            JOptionPane.showMessageDialog(null, "Đọc thành công, "
//                    + "Thêm " + countThem
//                    + "; Ghi đè " + countGhiDe
//                    + "; Bỏ qua " + countBoQua
//                    + ". Vui lòng làm mới để thấy kết quả");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//           
//            JOptionPane.showMessageDialog(null, "Lỗi khi nhập dữ liệu từ file: " + ex.getMessage());
//        } finally {
//            try {
//                if (inputStream != null) {
//                    inputStream.close();
//                }
//            } catch (IOException ex) {
//                JOptionPane.showMessageDialog(null, "Lỗi khi đóng inputstream: " + ex.getMessage());
//            }
//        }
//    }
    
//     //Đọc file excel Tài khoản
//    public void docFileExcelTaiKhoan() {
//        fd.setTitle("Nhập dữ liệu tài khoản từ excel");
//        String url = getFile();
//        if (url == null) {
//            return;
//        }
//
//        FileInputStream inputStream = null;
//        try {
//            inputStream = new FileInputStream(new File(url));
//
//            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
//            HSSFSheet sheet = workbook.getSheetAt(0);
//            Iterator<Row> rowIterator = sheet.iterator();
//            Row row1 = rowIterator.next();
//
//            String hanhDongKhiTrung = "";
//            int countThem = 0;
//            int countGhiDe = 0;
//            int countBoQua = 0;
//
//            while (rowIterator.hasNext()) {
//                Row row = rowIterator.next();
//                Iterator<Cell> cellIterator = row.cellIterator();
//
//                while (cellIterator.hasNext()) {
//                    String id = cellIterator.next().getStringCellValue();
//                    String idnv = cellIterator.next().getStringCellValue();
//                    String idquyen = cellIterator.next().getStringCellValue();
//                    String matkhau = cellIterator.next().getStringCellValue();
//
//
//                    TaiKhoanBUS tkBUS = new TaiKhoanBUS();
//                    TaiKhoanDTO tkOld = tkBUS.getTaiKhoanDTO(id);
//
//                    if (tkOld != null) {
//                        if (!hanhDongKhiTrung.contains("tất cả")) {
//                            MyTable mtb = new MyTable();
//                            mtb.setHeaders(new String[]{"", "Tài khoản", "Mã nhân viên", "Mã quyền", "Mật khẩu"});
//                            mtb.addRow(new String[]{
//                                "Cũ:", tkOld.getTaiKhoan(),
//                                tkOld.getIDNhanVien(),
//                                tkOld.getIDPhanQuyen(),
//                                tkOld.getMatKhau(),
//
//                            });
//                            mtb.addRow(new String[]{
//                                "Mới:", id, idnv, idquyen, matkhau                  
//                            });
//
//                            MyJOptionPane mop = new MyJOptionPane(mtb, hanhDongKhiTrung);
//                            hanhDongKhiTrung = mop.getAnswer();
//                        }
//                        if (hanhDongKhiTrung.contains("Ghi đè")) {
//                            TaiKhoanDTO DTO=new TaiKhoanDTO(id, idnv, idquyen, matkhau, "Hiện");
//                            tkBUS.sua(DTO,TaiKhoanBUS.timViTri(id));
//                            countGhiDe++;
//                        } else {
//                            countBoQua++;
//                        }                      
//                        
//                    //Khi database trống    
//                     
//                    } else {          
//                        TaiKhoanDTO taka = new TaiKhoanDTO(id, idnv, idquyen, matkhau, "Hiện");
//                        tkBUS.them(taka);
//                        countThem++;
//                    }
//                }
//            }
//            JOptionPane.showMessageDialog(null, "Đọc thành công, "
//                    + "Thêm " + countThem
//                    + "; Ghi đè " + countGhiDe
//                    + "; Bỏ qua " + countBoQua
//                    + ". Vui lòng làm mới để thấy kết quả");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//           
//            JOptionPane.showMessageDialog(null, "Lỗi khi nhập dữ liệu từ file: " + ex.getMessage());
//        } finally {
//            try {
//                if (inputStream != null) {
//                    inputStream.close();
//                }
//            } catch (IOException ex) {
//                JOptionPane.showMessageDialog(null, "Lỗi khi đóng inputstream: " + ex.getMessage());
//            }
//        }
//    }
     //Đọc file excel Phân quyền
   
}




