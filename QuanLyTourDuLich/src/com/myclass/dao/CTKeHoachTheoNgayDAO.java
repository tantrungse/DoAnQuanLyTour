package com.myclass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import com.myclass.connector.JDBCConnection;
import com.myclass.dto.CTKeHoachTheoNgayDTO;

public class CTKeHoachTheoNgayDAO {
	private final static String tableName = "CTKeHoachTheoNgay";
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public ArrayList<CTKeHoachTheoNgayDTO> getAll() {
		ArrayList<CTKeHoachTheoNgayDTO> dtos;
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "SELECT * FROM " + tableName;
			dtos = new ArrayList<CTKeHoachTheoNgayDTO>();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CTKeHoachTheoNgayDTO dto = new CTKeHoachTheoNgayDTO();
				
				dto.setMaCTKHTheoNgay(rs.getString("MaCTKHTheoNgay"));
				dto.setNgay(rs.getString("Ngay"));
				dto.setMaKHTour(rs.getString("MaKHTour"));
				dto.setMaDiaDiemThamQuan(rs.getString("MaDiaDiemThamQuan"));
				dto.setMaPhuongTien(rs.getString("MaPhuongTien"));
				dto.setMaNhaHang(rs.getString("MaNhaHang"));
				dto.setMaKhachSan(rs.getString("MaKhachSan"));
				
				dtos.add(dto);
			}
			
			return dtos;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
    public CTKeHoachTheoNgayDTO getByMaCTKHTheoNgay(String maCTKHTheoNgay) {
    	String query = "SELECT * FROM " + tableName + " WHERE MaCTKHTheoNgay = ?"; 
    	try {
    		CTKeHoachTheoNgayDTO dto = null;
    		conn = JDBCConnection.getJDBCConnection(tableName);
    		pstmt = conn.prepareStatement(query);
    		pstmt.setString(1, maCTKHTheoNgay);
    		rs = pstmt.executeQuery();
    		
    		if(rs.next()) {
    			dto = new CTKeHoachTheoNgayDTO();

				dto.setMaCTKHTheoNgay(rs.getString("MaCTKHTheoNgay"));
				dto.setNgay(rs.getString("Ngay"));
				dto.setMaKHTour(rs.getString("MaKHTour"));
				dto.setMaDiaDiemThamQuan(rs.getString("MaDiaDiemThamQuan"));
				dto.setMaPhuongTien(rs.getString("MaPhuongTien"));
				dto.setMaNhaHang(rs.getString("MaNhaHang"));
				dto.setMaKhachSan(rs.getString("MaKhachSan"));
    		}
    		
    		return dto;
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return null;
    }
    
	public ArrayList<CTKeHoachTheoNgayDTO> getByMaKHTour(String maKHTour) {
    	String query = "SELECT * FROM " + tableName + " WHERE MaKHTour = ?"; 
    	ArrayList<CTKeHoachTheoNgayDTO> dtos = new ArrayList<CTKeHoachTheoNgayDTO>();
    	try {
    		conn = JDBCConnection.getJDBCConnection(tableName);
    		pstmt = conn.prepareStatement(query);
    		pstmt.setString(1, maKHTour);
    		rs = pstmt.executeQuery();
    		
    		while(rs.next()) {
    			CTKeHoachTheoNgayDTO dto = new CTKeHoachTheoNgayDTO();

				dto.setMaCTKHTheoNgay(rs.getString("MaCTKHTheoNgay"));
				dto.setNgay(rs.getString("Ngay"));
				dto.setMaKHTour(rs.getString("MaKHTour"));
				dto.setMaDiaDiemThamQuan(rs.getString("MaDiaDiemThamQuan"));
				dto.setMaPhuongTien(rs.getString("MaPhuongTien"));
				dto.setMaNhaHang(rs.getString("MaNhaHang"));
				dto.setMaKhachSan(rs.getString("MaKhachSan"));
				
				dtos.add(dto);
    		}
    		
    		return dtos;
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
		
		return null;
	}
    
	public Vector<String> getAllMaCTKHTheoNgay() {
		Vector<String> listMaCTKHTheoNgay;
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "SELECT MaCTKHTheoNgay FROM " + tableName;
			listMaCTKHTheoNgay = new Vector<String>();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				listMaCTKHTheoNgay.add(rs.getString("MaCTKHTheoNgay"));
			}
			
			return listMaCTKHTheoNgay;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public void deleteById(String maCTKHTheoNgay) {
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "DELETE FROM " + tableName + " WHERE MaCTKHTheoNgay = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, maCTKHTheoNgay);
			int rowEffects = pstmt.executeUpdate();
			System.out.println("Row effects: " + rowEffects);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void add(CTKeHoachTheoNgayDTO dto) {
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "INSERT INTO "
					+ "CTKeHoachTheoNgay(`MaCTKHTheoNgay`, `Ngay`, `MaKHTour`, `MaDiaDiemThamQuan`, `MaPhuongTien`, `MaNhaHang`, `MaKhachSan`)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getMaCTKHTheoNgay());
			pstmt.setString(2, dto.getNgay());
			pstmt.setString(3, dto.getMaKHTour());
			pstmt.setString(4, dto.getMaDiaDiemThamQuan());
			pstmt.setString(5, dto.getMaPhuongTien());
			pstmt.setString(6, dto.getMaNhaHang());
			pstmt.setString(7, dto.getMaKhachSan());
			
			int rowEffects = pstmt.executeUpdate();
			System.out.println("Row effects: " + rowEffects);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void update(CTKeHoachTheoNgayDTO dto) {
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "UPDATE CTKeHoachTheoNgay SET "
					+ "Ngay = ?, MaKHTour = ?, MaDiaDiemThamQuan = ?, MaPhuongTien = ?, MaNhaHang = ?, MaKhachSan = ?"
					+ "WHERE MaCTKHTheoNgay = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getNgay());
			pstmt.setString(2, dto.getMaKHTour());
			pstmt.setString(3, dto.getMaDiaDiemThamQuan());
			pstmt.setString(4, dto.getMaPhuongTien());
			pstmt.setString(5, dto.getMaNhaHang());
			pstmt.setString(6, dto.getMaKhachSan());
			pstmt.setString(7, dto.getMaCTKHTheoNgay());
			
			int rowEffects = pstmt.executeUpdate();
			System.out.println("Row effects: " + rowEffects);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
