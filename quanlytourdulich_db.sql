CREATE SCHEMA IF NOT EXISTS quanlytourdulich2 CHARACTER SET utf8 COLLATE utf8_bin ;
USE quanlytourdulich2;

-- TaiKhoan(TenTK, MatKhau, Quyen)
CREATE TABLE IF NOT EXISTS TaiKhoan (
	TenTK VARCHAR(30) NOT NULL,
    MatKhau VARCHAR(30) NOT NULL,
    Quyen INT NOT NULL, -- 0:Admin , 1:NhanVien
    PRIMARY KEY (TenTK)
);

-- HuongDanVien (MaNV, HoNV, TenNV, NgaySinh, GioiTinh, DiaChi, SDT, MaDoan)
CREATE TABLE IF NOT EXISTS HuongDanVien (
	MaHDV VARCHAR(10) NOT NULL,
    Ho VARCHAR(10) NOT NULL,
    Ten VARCHAR(30) NOT NULL,
    NgaySinh DATE NOT NULL,
    GioiTinh VARCHAR(10),
    DiaChi TEXT,
    SDT VARCHAR(20),
    PRIMARY KEY (MaHDV)
);

-- Doan (MaDoan, SoNguoi, MaHuongDanVien, MaTour)
CREATE TABLE IF NOT EXISTS Doan (
	MaDoan VARCHAR(10) NOT NULL,
	SoNguoi INT,
    PRIMARY KEY (MaDoan)
);
ALTER TABLE Doan ADD MaTour VARCHAR(10) NOT NULL;
ALTER TABLE Doan ADD MaHDV VARCHAR(10) NOT NULL;
ALTER TABLE Doan ADD MaPhuongTien VARCHAR(10) NOT NULL;

-- KhachHang (MaKH, HoKH, TenKH, DiaChi, SDT, MaDoan)
CREATE TABLE IF NOT EXISTS KhachHang (
	MaKH VARCHAR(10) NOT NULL,
	HoKH VARCHAR(30),
	TenKH VARCHAR(30),
    DiaChi TEXT,
    SDT VARCHAR(11),
    PRIMARY KEY (MaKH)
);
ALTER TABLE KhachHang ADD MaDoan VARCHAR(10) NOT NULL;

-- HopDong (MaHD, NgayLapHD, NoiDung, MaTour)
CREATE TABLE IF NOT EXISTS HopDong (
	MaHD VARCHAR(10) NOT NULL,
    NgayLapHD DATE,
	NoiDung TEXT,
    -- ThanhTien --
    PRIMARY KEY (MaHD)
);
ALTER TABLE HopDong ADD MaTour VARCHAR(10) NOT NULL;

-- Tour (MaTour, TenTour, GiaVe, MaKHTour)
CREATE TABLE IF NOT EXISTS Tour (
	MaTour VARCHAR(10) NOT NULL,
    TenTour VARCHAR(50),
    GiaVe DOUBLE,
    PRIMARY KEY (MaTour)
);
ALTER TABLE Tour ADD DiemKhoiHanh VARCHAR(50);
ALTER TABLE Tour ADD DiemDen VARCHAR(50);

-- KeHoachTour (MaKeHoach, NgayBatDau, NgayKetThuc, SoNgay, MaTour, MaCTKH)
CREATE TABLE IF NOT EXISTS KeHoachTour (
	MaKeHoach VARCHAR(10) NOT NULL,
	NgayBatDau DATE,
    NgayKetThuc DATE,
    PRIMARY KEY (MaKeHoach)
);
ALTER TABLE KeHoachTour ADD MaTour VARCHAR(10) NOT NULL;

-- CTKeHoachTour (MaCTKeHoach, KeHoachTheoNgay(list), MaPhuongTien, MaNhaHang, MaKhachSan, MaDiaDiemThamQuan, MaCTThuChi)
CREATE TABLE IF NOT EXISTS CTKeHoach (
	MaCTKeHoach VARCHAR(10) NOT NULL,
    PRIMARY KEY (MaCTKeHoach)
);
ALTER TABLE CTKeHoach ADD MaPhuongTien VARCHAR(10) NOT NULL;
ALTER TABLE CTKeHoach ADD MaNhaHang VARCHAR(10) NOT NULL;
ALTER TABLE CTKeHoach ADD MaKhachSan VARCHAR(10) NOT NULL;
ALTER TABLE CTKeHoach ADD MaDiaDiemThamQuan VARCHAR(10) NOT NULL;
ALTER TABLE CTKeHoach ADD MaCTThuChi VARCHAR(10) NOT NULL;
ALTER TABLE CTKeHoach ADD MaKeHoachTour VARCHAR(10) NOT NULL;

CREATE TABLE IF NOT EXISTS CTKeHoachTheoNgay (
	MaCTKHTheoNgay VARCHAR(10) NOT NULL,
	Ngay DATE,
    PRIMARY KEY (MaCTKHTheoNgay)
);
ALTER TABLE CTKeHoachTheoNgay ADD MaKHTour VARCHAR(10) NOT NULL;
ALTER TABLE CTKeHoachTheoNgay ADD MaDiaDiemThamQuan VARCHAR(10) NOT NULL;
ALTER TABLE CTKeHoachTheoNgay ADD MaPhuongTien VARCHAR(10) NOT NULL;
ALTER TABLE CTKeHoachTheoNgay ADD MaNhaHang VARCHAR(10) NOT NULL;
ALTER TABLE CTKeHoachTheoNgay ADD MaKhachSan VARCHAR(10) NOT NULL;

-- PhuongTien (MaPhuongTien, TenPhuongTien, ChiPhi, SoChoNgoi)
CREATE TABLE IF NOT EXISTS PhuongTien (
	MaPhuongTien VARCHAR(10) NOT NULL,
    TenPhuongTien VARCHAR(50),
    ChiPhi DOUBLE,
    SoChoNgoi INT,
    PRIMARY KEY (MaPhuongTien)
);

-- DiaDiemThamQuan (MaDiaDiem, TenDiaDiem, NoiDung(list), DiaChi)
CREATE TABLE IF NOT EXISTS DiaDiemThamQuan (
	MaDiaDiem VARCHAR(10) NOT NULL,
    TenDiaDiem VARCHAR(50) NOT NULL,
    NoiDung VARCHAR(500),
    DiaChi VARCHAR(100),
    PRIMARY KEY (MaDiaDiem)
);

-- NhaHang (MaNhaHang, TenNhaHang, DiaChi, ChiPhiTrenNguoi)
CREATE TABLE IF NOT EXISTS NhaHang (
	MaNhaHang VARCHAR(10) NOT NULL,
    TenNhaHang VARCHAR(50),
    DiaChi VARCHAR(100),
    ChiPhiTrenNguoi DOUBLE,
    PRIMARY KEY (MaNhaHang)
);

-- KhachSan (MaKhachSan, TenKhachSan, DiaChi, ChiPhiTrenNguoi)
CREATE TABLE IF NOT EXISTS KhachSan (
	MaKhachSan VARCHAR(10) NOT NULL,
    TenKhachSan VARCHAR(50),
    DiaChi VARCHAR(100),
    ChiPhiTrenNguoi DOUBLE,
    PRIMARY KEY (MaKhachSan)
);

-- CTThuChi (MaCTThuChi, TongThu, TongChi, DoanThu, MaCTKH)
CREATE TABLE IF NOT EXISTS CTThuChi (
	MaCTThuChi VARCHAR(10) NOT NULL,
	TongThu DOUBLE,
    TongChi DOUBLE,
    DoanhThu DOUBLE,
    PRIMARY KEY (MaCTThuChi)
);

CREATE TABLE IF NOT EXISTS HoaDon (
	MaHoaDon varchar(10) NOT NULL,
    NgayLap date NOT NULL,
	TongTien DOUBLE,
	MaKhachHang varchar(10) NOT NULL,
	MaKhuyenMai varchar(10) NOT NULL,
    PRIMARY KEY (MaHoaDon)
);

CREATE TABLE IF NOT EXISTS ChiTietHoaDon (
	TenKhachHang varchar(255) NOT NULL,
	TenTour varchar(255) NOT NULL,
	SoLuong int NOT NULL,
	GiaVe DOUBLE,
	ThanhTien DOUBLE,
	MaHoaDon varchar(10) NOT NULL
);

CREATE TABLE IF NOT EXISTS KhuyenMai (
	MaKhuyenMai varchar(10) NOT NULL,
	TenKhuyenMai varchar(30) NOT NULL,
	NoiDung varchar(50) NOT NULL,
	NgayBatDau date NOT NULL,
	NgayKetThuc date NOT NULL,
    MaTour varchar(10) NOT NULL,
    PRIMARY KEY (MaKhuyenMai)
);

-- TAO KHOA NGOAI
ALTER TABLE Doan ADD CONSTRAINT fk_Doan_Tour
	FOREIGN KEY (MaTour) REFERENCES Tour(MaTour);
ALTER TABLE Doan ADD CONSTRAINT fk_Doan_HuongDanVien
	FOREIGN KEY (MaHDV) REFERENCES HuongDanVien(MaHDV);

ALTER TABLE KhachHang ADD CONSTRAINT fk_KhachHang_Doan
	FOREIGN KEY (MaDoan) REFERENCES Doan(MaDoan);
    
ALTER TABLE HopDong ADD CONSTRAINT fk_HopDong_Tour
	FOREIGN KEY (MaTour) REFERENCES Tour(MaTour);
    
ALTER TABLE KeHoachTour ADD CONSTRAINT fk_KeHoachTour_Tour
	FOREIGN KEY (MaTour) REFERENCES Tour(MaTour);
    
ALTER TABLE CTKeHoachTheoNgay ADD CONSTRAINT fk_CTKeHoachTheoNgay_KeHoachTour
	FOREIGN KEY (MaKHTour) REFERENCES KeHoachTour(MaKeHoach);
ALTER TABLE CTKeHoachTheoNgay ADD CONSTRAINT fk_CTKeHoachTheoNgay_DiaDiemThamQuan
	FOREIGN KEY (MaDiaDiemThamQuan) REFERENCES DiaDiemThamQuan(MaDiaDiem);
ALTER TABLE CTKeHoachTheoNgay ADD CONSTRAINT fk_CTKeHoachTheoNgay_PhuongTien
	FOREIGN KEY (MaPhuongTien) REFERENCES PhuongTien(MaPhuongTien);
ALTER TABLE CTKeHoachTheoNgay ADD CONSTRAINT fk_CTKeHoachTheoNgay_NhaHang
	FOREIGN KEY (MaNhaHang) REFERENCES NhaHang(MaNhaHang);
ALTER TABLE CTKeHoachTheoNgay ADD CONSTRAINT fk_CTKeHoachTheoNgay_KhachSan
	FOREIGN KEY (MaKhachSan) REFERENCES KhachSan(MaKhachSan);
    
ALTER TABLE KhuyenMai ADD CONSTRAINT fk_KhuyenMai_Tour
	FOREIGN KEY (MaTour) REFERENCES Tour(MaTour);
    
ALTER TABLE HoaDon ADD CONSTRAINT fk_HoaDon_KhachHang
	FOREIGN KEY (MaKhachHang) REFERENCES KhachHang(MaKH);
ALTER TABLE HoaDon ADD CONSTRAINT fk_HoaDon_KhuyenMai
	FOREIGN KEY (MaKhuyenMai) REFERENCES KhuyenMai(MaKhuyenMai);
    
ALTER TABLE ChiTietHoaDon ADD CONSTRAINT fk_ChiTietHoaDon_HoaDon
	FOREIGN KEY (MaHoaDon) REFERENCES HoaDon(MaHoaDon);