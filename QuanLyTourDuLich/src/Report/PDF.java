/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;

import com.myclass.bus.*;
import com.myclass.dao.*;
import com.myclass.dto.ChiTietHoaDonDTO;
import com.myclass.dto.HoaDonDTO;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import java.awt.FileDialog;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class PDF {
        Document document;
    FileOutputStream file;
    Font fontData;
    DecimalFormat formatter = new DecimalFormat("###,###,###");
    Font fontTitle;
    Font fontHeader;

    FileDialog fd = new FileDialog(new JFrame(), "Xuất excel", FileDialog.SAVE);

    public PDF() {
        try {
            //Set font theo Arial trong Windows và các kích cỡ, định dạng thường
            fontData = new Font(BaseFont.createFont("C:\\Windows\\Fonts\\Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 11, Font.NORMAL);
            fontTitle = new Font(BaseFont.createFont("C:\\Windows\\Fonts\\Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 25, Font.NORMAL);
            fontHeader = new Font(BaseFont.createFont("C:\\Windows\\Fonts\\Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 13, Font.NORMAL);
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void chooseURL(String url) {
        try {
            document.close();
            document = new Document();
            file = new FileOutputStream(url);
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Khong tim thay duong dan file " + url);
        } catch (DocumentException ex) {
            JOptionPane.showMessageDialog(null, "Khong goi duoc document !");
        }
    }

    public void setTitle(String title) {
        try {
            Paragraph pdfTitle = new Paragraph(new Phrase(title, fontTitle));
            pdfTitle.setAlignment(Element.ALIGN_CENTER);
            document.add(pdfTitle);
            document.add(Chunk.NEWLINE);
        } catch (DocumentException ex) {
//            JOptionPane.showMessageDialog(null, "Khong goi duoc document !");
            ex.printStackTrace();
        }
    }

    public void writeObject(String[] data) {
        Paragraph pdfData = new Paragraph();
        for (int i = 0; i < data.length; i++) {
            pdfData.add(data[i] + "  ");
        }
        try {
            document.add(pdfData);
        } catch (DocumentException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void writeTable(JTable _table) {
        PdfPTable pdfTable = new PdfPTable(_table.getColumnCount());
        for (int i = 0; i < _table.getRowCount(); i++) {
            for (int j = 0; j < _table.getColumnCount(); j++) {
                String data = String.valueOf(_table.getValueAt(i, j));
                PdfPCell cell = new PdfPCell(new Phrase(data, fontData));
                pdfTable.addCell(cell);
            }
        }
        try {
            document.add(pdfTable);
        } catch (DocumentException ex) {
            JOptionPane.showMessageDialog(null, "Khong goi duoc document !");
        }
    }

    private String getFile() {
        fd.setFile("untitled.pdf");
        fd.setVisible(true);
        String url = fd.getDirectory() + fd.getFile();
        if (url.equals("nullnull")) {
            return null;
        }
        return url;
    }
    
    
    public void writeHoaDon(String mahd,int index) throws Exception {
        //Hien thong tin cua hoa don hien tai
        HoaDonBUS hdBUS = new HoaDonBUS();
        KhachHangBUS khBUS = new KhachHangBUS();
        ChuongTrinhKMBUS kmBUS = new ChuongTrinhKMBUS();
        kmBUS.list();
        hdBUS.docCTHD(mahd);
        if(hdBUS.CTHD.size()==0)
        {
        	JOptionPane.showMessageDialog(null, "Vé này không có chi tiết, không thể in!!!");
        	return;
        }
        String url = "";
        try {
            fd.setTitle("In hóa đơn");
            url = getFile();
            if (url == null) {
                return;
            }
            file = new FileOutputStream(url);
            document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();
            
            setTitle("Thông tin hóa đơn");
        
          TourBUS tourBUS = new TourBUS();
           // ChiTietHoaDonBUS cthdBUS = new ChiTietHoaDonBUS();

            HoaDonDTO hd = hdBUS.getHoaDonDTO(mahd);

            Chunk glue = new Chunk(new VerticalPositionMark());// Khoang trong giua hang
            Paragraph paraMaHoaDon = new Paragraph(new Phrase("Hóa đơn: " + String.valueOf(hd.getMaHoaDon()), fontData));

            Paragraph para1 = new Paragraph();
            para1.setFont(fontData);                                        
            para1.add(String.valueOf("Khách hàng: " +  hdBUS.CTHD.get(0).getTenKH() + "  -  " + hd.getMaKH()));
            para1.add(glue);
            para1.add("Ngày lập: " + String.valueOf(hd.getNgayLap()));

         

            Paragraph paraKhuyenMai = new Paragraph();
            paraKhuyenMai.setPaddingTop(30);
            paraKhuyenMai.setFont(fontData);
            paraKhuyenMai.add("Khuyến mãi: " + "giảm" + hd.getnoidungKM());

            document.add(paraMaHoaDon);
            document.add(para1);   document.add(paraKhuyenMai);
            document.add(Chunk.NEWLINE);//add hang trong de tao khoang cach

            //Tao table cho cac chi tiet cua hoa don
            PdfPTable pdfTable = new PdfPTable(6);
            double tongKhuyenMai = 0;
            float tongThanhTien = 0;

            //Set headers cho table chi tiet
            pdfTable.addCell(new PdfPCell(new Phrase("Mã Hóa Đơn", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Tên Tour", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Tên Khách Hàng", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Giá Tour", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Số lượng Tour", fontHeader)));
           pdfTable.addCell(new PdfPCell(new Phrase("Tổng tiền", fontHeader)));

            for (int i = 0; i < 6; i++) {
                pdfTable.addCell(new PdfPCell(new Phrase("")));
            }

            //Truyen thong tin tung chi tiet vao table
           for (ChiTietHoaDonDTO cthd : hdBUS.CTHD) {

                String maHoaDon = cthd.getMaHoaDon();
                String tentour =cthd.gettenTour();
                String tenKH=cthd.getTenKH();
                String gia = PriceFormatter.format(cthd.getGiaVe());
                String soluong =String.valueOf(cthd.getSoLuongTour());
                String thanhtien = PriceFormatter.format(cthd.getGiaVe() * cthd.getSoLuongTour());

                pdfTable.addCell(new PdfPCell(new Phrase(maHoaDon, fontData)));
                pdfTable.addCell(new PdfPCell(new Phrase(tentour, fontData)));
                pdfTable.addCell(new PdfPCell(new Phrase(tenKH, fontData)));
                pdfTable.addCell(new PdfPCell(new Phrase(gia, fontData)));
                pdfTable.addCell(new PdfPCell(new Phrase(soluong, fontData)));
                pdfTable.addCell(new PdfPCell(new Phrase(thanhtien, fontData)));

                tongThanhTien +=cthd.getGiaVe() * cthd.getSoLuongTour();
          }

            document.add(pdfTable);
            document.add(Chunk.NEWLINE);

            tongKhuyenMai =tongThanhTien*Float.valueOf(Float.valueOf(hd.getnoidungKM())/100);
            float tongtientt=0;
            tongtientt=(float) (tongThanhTien-tongKhuyenMai);
            Paragraph paraTongThanhTien = new Paragraph(new Phrase("Tổng thành tiền: " + PriceFormatter.format(tongThanhTien), fontData));
            paraTongThanhTien.setIndentationLeft(300);
            document.add(paraTongThanhTien);
            Paragraph paraTongKhuyenMai = new Paragraph(new Phrase("Tổng khuyến mãi: " + PriceFormatter.format1(tongKhuyenMai), fontData));
            paraTongKhuyenMai.setIndentationLeft(300);
            document.add(paraTongKhuyenMai);
            Paragraph paraTongThanhToan = new Paragraph(new Phrase("Tổng thanh toán: " + PriceFormatter.format1(tongtientt), fontData));
            paraTongThanhToan.setIndentationLeft(300);
            document.add(paraTongThanhToan);
            document.close();
            
            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + url);

        } catch (DocumentException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi ghi file " + url);
        }
    }
//    public void writeHoaDonNhap(String mahdn) throws Exception {
//        String url = "";
//        try {
//            fd.setTitle("In hóa đơn nhập");
//            url = getFile();
//            if (url == null) {
//                return;
//            }
//            file = new FileOutputStream(url);
//            document = new Document();
//            PdfWriter writer = PdfWriter.getInstance(document, file);
//            document.open();
//            
//            setTitle("Thông tin hóa đơn nhập");
//            //Hien thong tin cua hoa don hien tai
//            HoaDonNhapBUS hdnBUS = new HoaDonNhapBUS();
//            NhaCungCapBUS nccBUS = new NhaCungCapBUS();
//            NhanVienBUS nvBUS = new NhanVienBUS();
//            NguyenLieuBUS nlBUS = new NguyenLieuBUS();
//            ChiTietHoaDonNhapBUS cthdnBUS = new ChiTietHoaDonNhapBUS();
//
//            HoaDonNhapDTO hdn = hdnBUS.getHoaDonNhapDTO(mahdn);
//
//            Chunk glue = new Chunk(new VerticalPositionMark());// Khoang trong giua hang
//            Paragraph paraMaHoaDonNhap = new Paragraph(new Phrase("Hóa đơn nhập: " + String.valueOf(hdn.getIDHoaDonNhap()), fontData));
//
//            Paragraph para1 = new Paragraph();
//            para1.setFont(fontData);
//            para1.add(String.valueOf("Nhà cung cấp: " + nccBUS.getNhaCungCapDTO(hdn.getIDNhaCungCap()).getTenNhaCungCap() + "  -  " + hdn.getIDNhaCungCap()));
//            para1.add(glue);
//            para1.add("Ngày lập: " + String.valueOf(hdn.getNgayNhap()));
//
//            Paragraph para2 = new Paragraph();
//            para2.setPaddingTop(30);
//            para2.setFont(fontData);
//            para2.add(String.valueOf("Nhân viên: " + nvBUS.getNhanVienDTO(hdn.getIDNhanVien()).getTenNhanVien()+ "  -  " + hdn.getIDNhanVien()));
//            para2.add(glue);
////            para2.add("Giờ lập: " + String.valueOf(hd.getGioLap()));
//
//
//            document.add(paraMaHoaDonNhap);
//            document.add(para1);
//            document.add(para2);
//            document.add(Chunk.NEWLINE);//add hang trong de tao khoang cach
//
//            //Tao table cho cac chi tiet cua hoa don
//            PdfPTable pdfTable = new PdfPTable(5);
//            float tongThanhTien = 0;
//
//            //Set headers cho table chi tiet
//            pdfTable.addCell(new PdfPCell(new Phrase("Mã nguyên liệu", fontHeader)));
//            pdfTable.addCell(new PdfPCell(new Phrase("Tên nguyên liệu", fontHeader)));
//            pdfTable.addCell(new PdfPCell(new Phrase("Giá nhập", fontHeader)));
//            pdfTable.addCell(new PdfPCell(new Phrase("Số lượng", fontHeader)));
//            pdfTable.addCell(new PdfPCell(new Phrase("Tổng tiền", fontHeader)));
//
//            for (int i = 0; i < 5; i++) {
//                pdfTable.addCell(new PdfPCell(new Phrase("")));
//            }
//
//            //Truyen thong tin tung chi tiet vao table
//            for (ChiTietHoaDonNhapDTO cthdn : cthdnBUS.getAllChiTiet(mahdn)) {
//
//                String ma = cthdn.getIDNguyenLieu();
//                String ten = nlBUS.getNguyenLieuDTO(cthdn.getIDNguyenLieu()).getTenNguyenLieu();
//                String gia = PriceFormatter.format(cthdn.getGiaNhap());
//                String soluong = String.valueOf(cthdn.getSoLuong());
//                String thanhtien = PriceFormatter.format(cthdn.getGiaNhap() * cthdn.getSoLuong());
//
//                pdfTable.addCell(new PdfPCell(new Phrase(ma, fontData)));
//                pdfTable.addCell(new PdfPCell(new Phrase(ten, fontData)));
//                pdfTable.addCell(new PdfPCell(new Phrase(gia, fontData)));
//                pdfTable.addCell(new PdfPCell(new Phrase(soluong, fontData)));
//                pdfTable.addCell(new PdfPCell(new Phrase(thanhtien, fontData)));
//
//                tongThanhTien += cthdn.getGiaNhap() * cthdn.getSoLuong();
//            }
//
//            document.add(pdfTable);
//            document.add(Chunk.NEWLINE);
//
//           
//            Paragraph paraTongThanhTien = new Paragraph(new Phrase("Tổng thành tiền: " + PriceFormatter.format(tongThanhTien), fontData));
//            paraTongThanhTien.setIndentationLeft(300);
//            document.add(paraTongThanhTien);
//
//            Paragraph paraTongThanhToan = new Paragraph(new Phrase("Tổng thanh toán: " + PriceFormatter.format1(hdn.getTongTien()), fontData));
//            paraTongThanhToan.setIndentationLeft(300);
//            document.add(paraTongThanhToan);
//            document.close();
//            
//            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + url);
//
//        } catch (DocumentException | FileNotFoundException ex) {
//            JOptionPane.showMessageDialog(null, "Lỗi khi ghi file " + url);
//        }
//    }
//    
    
    
    public void closeFile() {
        document.close();
    } 
}
 