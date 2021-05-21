use quanlytourdulich2;

insert into tour(MaTour, TenTour, GiaVe)
	   values ('TOUR001', 'Tour 1', 100);
insert into tour(MaTour, TenTour, GiaVe)
	   values ('TOUR002', 'Tour 2', 100);
insert into tour(MaTour, TenTour, GiaVe)
	   values ('TOUR003', 'Tour 3', 100);
insert into tour(MaTour, TenTour, GiaVe)
	   values ('TOUR004', 'Tour 4', 100);
insert into tour(MaTour, TenTour, GiaVe)
	   values ('TOUR005', 'Tour 5', 100);
update tour set DiemKhoiHanh = "Diem Khoi Hanh 1", DiemDen = "Diem Den 1" where MaTour = "TOUR001";
update tour set DiemKhoiHanh = "Diem Khoi Hanh 2", DiemDen = "Diem Den 2" where MaTour = "TOUR002";
update tour set DiemKhoiHanh = "Diem Khoi Hanh 3", DiemDen = "Diem Den 1" where MaTour = "TOUR003";
update tour set DiemKhoiHanh = "Diem Khoi Hanh 4", DiemDen = "Diem Den 1" where MaTour = "TOUR004";
update tour set DiemKhoiHanh = "Diem Khoi Hanh 5", DiemDen = "Diem Den 1" where MaTour = "TOUR005";

insert into huongdanvien(MaHDV, Ho, Ten, NgaySinh, GioiTinh, DiaChi, SDT)
	values ('HDV001', 'Nguyen',	'Van A', '1990-01-01', 'Nam', 'Dia Chi A', '0342980001');
insert into huongdanvien(MaHDV, Ho, Ten, NgaySinh, GioiTinh, DiaChi, SDT)
	values ('HDV002', 'Nguyen',	'Thi A', '1990-02-02', 'Nu', 'Dia Chi A', '0342980002');
insert into huongdanvien(MaHDV, Ho, Ten, NgaySinh, GioiTinh, DiaChi, SDT)
	values ('HDV003', 'Tran', 'Van B', '1989-01-01', 'Nam', 'Dia Chi B', '0342980003');
insert into huongdanvien(MaHDV, Ho, Ten, NgaySinh, GioiTinh, DiaChi, SDT)
	values ('HDV004', 'Tran', 'Thi B', '1989-02-02', 'Nu', 'Dia Chi B', '0342980004');
insert into huongdanvien(MaHDV, Ho, Ten, NgaySinh, GioiTinh, DiaChi, SDT)
	values ('HDV005', 'Vo',	'Van C', '1988-01-01', 'Nam', 'Dia Chi C', '0342980005');
insert into huongdanvien(MaHDV, Ho, Ten, NgaySinh, GioiTinh, DiaChi, SDT)
	values ('HDV006', 'Vo',	'Thi C', '1988-02-02', 'Nu', 'Dia Chi C', '0342980006');
insert into huongdanvien(MaHDV, Ho, Ten, NgaySinh, GioiTinh, DiaChi, SDT)
	values ('HDV007', 'Le',	'Van D', '1987-01-01', 'Nam', 'Dia Chi D', '0342980007');
insert into huongdanvien(MaHDV, Ho, Ten, NgaySinh, GioiTinh, DiaChi, SDT)
	values ('HDV008', 'Le',	'Thi D', '1987-02-02', 'Nu', 'Dia Chi D', '0342980008');
insert into huongdanvien(MaHDV, Ho, Ten, NgaySinh, GioiTinh, DiaChi, SDT)
	values ('HDV009', 'Ly',	'Van E', '1986-01-01', 'Nam', 'Dia Chi E', '0342980009');
insert into huongdanvien(MaHDV, Ho, Ten, NgaySinh, GioiTinh, DiaChi, SDT)
	values ('HDV010', 'Ly',	'Thi E', '1986-02-02', 'Nu', 'Dia Chi E', '0342980010');
    
insert into taikhoan(TenTK, MatKhau, Quyen)
	values ('admin', 'admin', 0);
insert into taikhoan(TenTK, MatKhau, Quyen)
	values ('nhanvien', 'nhanvien', 1);

insert into kehoachtour(MaKeHoach, NgayBatDau, NgayKetThuc, MaTour)
	   values ('KH001','2021-04-13', '2021-04-21', 'TOUR001');
insert into kehoachtour(MaKeHoach, NgayBatDau, NgayKetThuc, MaTour)
	   values ('KH002','2021-04-10', '2021-04-18', 'TOUR002');
insert into kehoachtour(MaKeHoach, NgayBatDau, NgayKetThuc, MaTour)
	   values ('KH003','2021-04-13', '2021-04-17', 'TOUR003');
insert into kehoachtour(MaKeHoach, NgayBatDau, NgayKetThuc, MaTour)
	   values ('KH004','2021-04-16', '2021-04-20', 'TOUR004');
insert into kehoachtour(MaKeHoach, NgayBatDau, NgayKetThuc, MaTour)
	   values ('KH005','2021-04-14', '2021-04-21', 'TOUR005');	
update kehoachtour set MaTour = "TOUR001" where makehoach = "KH001";
update kehoachtour set MaTour = "TOUR002" where makehoach = "KH002";
update kehoachtour set MaTour = "TOUR003" where makehoach = "KH003";
update kehoachtour set MaTour = "TOUR004" where makehoach = "KH004";
update kehoachtour set MaTour = "TOUR005" where makehoach = "KH005";

insert into hopdong(MaHD, NgayLapHD, NoiDung, MaTour)
	   values ('HD001', '2021-03-13', 'Day la hop dong cua Tour 1', 'TOUR001');
insert into hopdong(MaHD, NgayLapHD, NoiDung, MaTour)
	   values ('HD002', '2021-03-10', 'Day la hop dong cua Tour 2', 'TOUR002');
insert into hopdong(MaHD, NgayLapHD, NoiDung, MaTour)
	   values ('HD003', '2021-03-13', 'Day la hop dong cua Tour 3', 'TOUR003');
insert into hopdong(MaHD, NgayLapHD, NoiDung, MaTour)
	   values ('HD004', '2021-03-16', 'Day la hop dong cua Tour 4', 'TOUR004');
insert into hopdong(MaHD, NgayLapHD, NoiDung, MaTour)
	   values ('HD005', '2021-03-14', 'Day la hop dong cua Tour 5', 'TOUR005');

insert into doan(MaDoan, MaTour, MaHDV)
	values ('DOAN001', 'TOUR001', 'HDV001');
insert into doan(MaDoan, MaTour, MaHDV)
	values ('DOAN002', 'TOUR002', 'HDV002');
insert into doan(MaDoan, MaTour, MaHDV)
	values ('DOAN003', 'TOUR003', 'HDV003');
insert into doan(MaDoan, MaTour, MaHDV)
	values ('DOAN004', 'TOUR004', 'HDV004');
insert into doan(MaDoan, MaTour, MaHDV)
	values ('DOAN005', 'TOUR005', 'HDV005');
update doan set MaPhuongTien = "PT001" where MaDoan = "DOAN001";
update doan set MaPhuongTien = "PT002" where MaDoan = "DOAN002";
update doan set MaPhuongTien = "PT003" where MaDoan = "DOAN003";
update doan set MaPhuongTien = "PT004" where MaDoan = "DOAN004";
update doan set MaPhuongTien = "PT005" where MaDoan = "DOAN005";

insert  into ctkehoachtheongay(MaCTKHTheoNgay, Ngay, MaKHTour, MaDiaDiemThamQuan, MaPhuongTien, MaNhaHang, MaKhachSan)
		values('CTKH001N1', '2021-04-13', 'KH001', 'DD001', 'PT001', 'NH001', 'KS001');
insert  into ctkehoachtheongay(MaCTKHTheoNgay, Ngay, MaKHTour, MaDiaDiemThamQuan, MaPhuongTien, MaNhaHang, MaKhachSan)
		values('CTKH002N1', '2021-04-10', 'KH002', 'DD002', 'PT002', 'NH002', 'KS002');
insert  into ctkehoachtheongay(MaCTKHTheoNgay, Ngay, MaKHTour, MaDiaDiemThamQuan, MaPhuongTien, MaNhaHang, MaKhachSan)
		values('CTKH002N2', '2021-04-11', 'KH002', 'DD002', 'PT002', 'NH002', 'KS002');
insert  into ctkehoachtheongay(MaCTKHTheoNgay, Ngay, MaKHTour, MaDiaDiemThamQuan, MaPhuongTien, MaNhaHang, MaKhachSan)
		values('CTKH003N1', '2021-04-13', 'KH003', 'DD003', 'PT003', 'NH003', 'KS003');
insert  into ctkehoachtheongay(MaCTKHTheoNgay, Ngay, MaKHTour, MaDiaDiemThamQuan, MaPhuongTien, MaNhaHang, MaKhachSan)
		values('CTKH003N2', '2021-04-14', 'KH003', 'DD003', 'PT003', 'NH003', 'KS003');
insert  into ctkehoachtheongay(MaCTKHTheoNgay, Ngay, MaKHTour, MaDiaDiemThamQuan, MaPhuongTien, MaNhaHang, MaKhachSan)
		values('CTKH003N3', '2021-04-15', 'KH003', 'DD003', 'PT003', 'NH003', 'KS003');
insert  into ctkehoachtheongay(MaCTKHTheoNgay, Ngay, MaKHTour, MaDiaDiemThamQuan, MaPhuongTien, MaNhaHang, MaKhachSan)
		values('CTKH004N1', '2021-04-16', 'KH004', 'DD004', 'PT004', 'NH004', 'KS004');
insert  into ctkehoachtheongay(MaCTKHTheoNgay, Ngay, MaKHTour, MaDiaDiemThamQuan, MaPhuongTien, MaNhaHang, MaKhachSan)
		values('CTKH004N2', '2021-04-17', 'KH004', 'DD004', 'PT004', 'NH004', 'KS004');
insert  into ctkehoachtheongay(MaCTKHTheoNgay, Ngay, MaKHTour, MaDiaDiemThamQuan, MaPhuongTien, MaNhaHang, MaKhachSan)
		values('CTKH004N3', '2021-04-18', 'KH004', 'DD004', 'PT004', 'NH004', 'KS004');
insert  into ctkehoachtheongay(MaCTKHTheoNgay, Ngay, MaKHTour, MaDiaDiemThamQuan, MaPhuongTien, MaNhaHang, MaKhachSan)
		values('CTKH004N4', '2021-04-19', 'KH004', 'DD004', 'PT004', 'NH004', 'KS004');
insert  into ctkehoachtheongay(MaCTKHTheoNgay, Ngay, MaKHTour, MaDiaDiemThamQuan, MaPhuongTien, MaNhaHang, MaKhachSan)
		values('CTKH005N1', '2021-04-14', 'KH005', 'DD005', 'PT005', 'NH005', 'KS005');
insert  into ctkehoachtheongay(MaCTKHTheoNgay, Ngay, MaKHTour, MaDiaDiemThamQuan, MaPhuongTien, MaNhaHang, MaKhachSan)
		values('CTKH005N2', '2021-04-15', 'KH005', 'DD005', 'PT005', 'NH005', 'KS005');
insert  into ctkehoachtheongay(MaCTKHTheoNgay, Ngay, MaKHTour, MaDiaDiemThamQuan, MaPhuongTien, MaNhaHang, MaKhachSan)
		values('CTKH005N3', '2021-04-16', 'KH005', 'DD005', 'PT005', 'NH005', 'KS005');
insert  into ctkehoachtheongay(MaCTKHTheoNgay, Ngay, MaKHTour, MaDiaDiemThamQuan, MaPhuongTien, MaNhaHang, MaKhachSan)
		values('CTKH005N4', '2021-04-17', 'KH005', 'DD005', 'PT005', 'NH005', 'KS005');
insert  into ctkehoachtheongay(MaCTKHTheoNgay, Ngay, MaKHTour, MaDiaDiemThamQuan, MaPhuongTien, MaNhaHang, MaKhachSan)
		values('CTKH005NS5', '2021-04-18', 'KH005', 'DD005', 'PT005', 'NH005', 'KS005');

insert  into khachsan(MaKhachSan, TenKhachSan, DiaChi, ChiPhiTrenNguoi)
		values('KS001', 'Khach San 1', 'Unknow', '500');
insert  into khachsan(MaKhachSan, TenKhachSan, DiaChi, ChiPhiTrenNguoi)
		values('KS002', 'Khach San 2', 'Unknow', '600');
insert  into khachsan(MaKhachSan, TenKhachSan, DiaChi, ChiPhiTrenNguoi)
		values('KS003', 'Khach San 3', 'Unknow', '700');
insert  into khachsan(MaKhachSan, TenKhachSan, DiaChi, ChiPhiTrenNguoi)
		values('KS004', 'Khach San 4', 'Unknow', '800');
insert  into khachsan(MaKhachSan, TenKhachSan, DiaChi, ChiPhiTrenNguoi)
		values('KS005', 'Khach San 5', 'Unknow', '900');       

insert  into nhahang(MaNhaHang, TenNhaHang, DiaChi, ChiPhiTrenNguoi)
		values('NH001', 'Nha Hang 1', 'Unknow', '500');
insert  into nhahang(MaNhaHang, TenNhaHang, DiaChi, ChiPhiTrenNguoi)
		values('NH002', 'Nha Hang 2', 'Unknow', '600');
insert  into nhahang(MaNhaHang, TenNhaHang, DiaChi, ChiPhiTrenNguoi)
		values('NH003', 'Nha Hang 3', 'Unknow', '700');
insert  into nhahang(MaNhaHang, TenNhaHang, DiaChi, ChiPhiTrenNguoi)
		values('NH004', 'Nha Hang 4', 'Unknow', '800');
insert  into nhahang(MaNhaHang, TenNhaHang, DiaChi, ChiPhiTrenNguoi)
		values('NH005', 'Nha Hang 5', 'Unknow', '900');
        
insert  into phuongtien(MaPhuongTien, TenPhuongTien, ChiPhi, SoChoNgoi)
		values('PT001', 'Phuong Tien 1', '500', 8);
insert  into phuongtien(MaPhuongTien, TenPhuongTien, ChiPhi, SoChoNgoi)
		values('PT002', 'Phuong Tien 2', '600', 12);
insert  into phuongtien(MaPhuongTien, TenPhuongTien, ChiPhi, SoChoNgoi)
		values('PT003', 'Phuong Tien 3', '700', 16);
insert  into phuongtien(MaPhuongTien, TenPhuongTien, ChiPhi, SoChoNgoi)
		values('PT004', 'Phuong Tien 4', '800', 24);
insert  into phuongtien(MaPhuongTien, TenPhuongTien, ChiPhi, SoChoNgoi)
		values('PT005', 'Phuong Tien 5', '900', 32);
      
insert  into ctthuchi(MaCTThuChi, TongThu, TongChi, DoanhThu)
	 	values('CTTC001', null, null, null);
insert  into ctthuchi(MaCTThuChi, TongThu, TongChi, DoanhThu)
		values('CTTC002', null, null, null);
insert  into ctthuchi(MaCTThuChi, TongThu, TongChi, DoanhThu)
		values('CTTC003', null, null, null);
insert  into ctthuchi(MaCTThuChi, TongThu, TongChi, DoanhThu)
		values('CTTC004', null, null, null);
insert  into ctthuchi(MaCTThuChi, TongThu, TongChi, DoanhThu)
		values('CTTC005', null, null, null);
        
insert  into diadiemthamquan(MaDiaDiem, TenDiaDiem, DiaChi)
		values('DD001', 'Dia Diem 1', 'Unknow');
insert  into diadiemthamquan(MaDiaDiem, TenDiaDiem, DiaChi)
		values('DD002', 'Dia Diem 2', 'Unknow');
insert  into diadiemthamquan(MaDiaDiem, TenDiaDiem, DiaChi)
		values('DD003', 'Dia Diem 3', 'Unknow');
insert  into diadiemthamquan(MaDiaDiem, TenDiaDiem, DiaChi)
		values('DD004', 'Dia Diem 4', 'Unknow');
insert  into diadiemthamquan(MaDiaDiem, TenDiaDiem, DiaChi)
		values('DD005', 'Dia Diem 5', 'Unknow');

INSERT INTO `hoadondb` (`maHoaDon`, `maKH`, `Mã KM`, `noidungKM`, `TongTien`, `NgayLap`) VALUES
('HD001', 'T001KH001', '9aefe', '10', 594000, '2001-06-25'),
('HD002', 'T002KH002', 'adh88', '5', 285000, '2020-12-01'),
('HD003', 'T003KH003', '1a425', '5', 4275000, '2021-04-20'),
('HD004', 'T004KH004', '486452', '7', 1116000, '2020-11-20'),
('HD005', 'T005KH005', '1a4w5', '7', 4650000, '2020-10-21'),
('HD006', 'T006KH006', '4648612', '20', 1960000, '2020-10-21');


INSERT INTO `khuyenmai` (`Mã KM`, `Mã Tour`, `Tên Tour`, `Nội dung khuyến mãi`, `Ngày bắt đầu`, `Ngày kết thúc`) VALUES
('1a425', '6461d', 'Du Lich Hồ Gươm', '5', '2021-04-20', '2021-06-10'),
('1a4w5', '6462d', 'Du Lich Hồ Hoàn Kiếm', '7', '2021-05-10', '2021-06-10'),
('1c425', '6461d', 'Du Lich Sông SG', '10', '2021-05-20', '2021-06-10'),
('3311f', 'da4d464', 'Du lịch Cần Thơ', '6', '2021-05-05', '2021-06-05'),
('4648612', '248998', 'Du lịch Sóc Trăng', '20', '2020-08-12', '2020-09-13'),
('486452', '23333', 'Du lịch Đà Lạt', '15', '2001-06-01', '2020-01-03'),
('48646', '23333', 'Du lịch Đà Lạt', '12', '2021-06-02', '2021-06-09');

INSERT INTO `chitiethddb` (`maHoaDon`, `tenKH`, `tentour`, `soluong`, `giaVe`, `ThanhTien`) VALUES
('32424', 'Lý Thế Minh', 'Du Lịch Sóc Trăng', 2, 180000, 180000),
('32424', 'Lý Thế Minh', 'Du Lịch Đà Lạt(3 ngày)', 1, 300000, 300000),
('46qdd', 'Võ Tấn Trung', 'Thăm quan Bến Nhà Rồng', 2, 150000, 300000),
('d56d5', 'Võ Huyền Trân', 'Du Lịch Vũng Tàu', 3, 400000, 0),
('f4r32', 'Mai Văn Thinh', 'Chuyến đi Tây Nguyên 2 ngày', 7, 350000, 0),
('f4r31', 'Ánh Trâm', 'Củ Chi 3 đêm', 5, 1000000, 0),
('adnb2', 'Lữ Bố', 'Du Lịch Tam Quốc', 3, 1500000, 0);