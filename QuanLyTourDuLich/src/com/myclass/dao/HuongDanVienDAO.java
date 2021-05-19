package com.myclass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.myclass.connector.JDBCConnection;
import com.myclass.dto.HuongDanVienDTO;

public class HuongDanVienDAO {
	private final static String tableName = "huongdanvien";
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public HuongDanVienDAO() {
		
	}
	
	public ArrayList<HuongDanVienDTO> getByTenHDV(String TenHDV) {
    	ArrayList<HuongDanVienDTO> dtos = new ArrayList<HuongDanVienDTO>();
    	String query = "SELECT * FROM " + tableName + " WHERE Ten LIKE ?"; 
    	try {
    		conn = JDBCConnection.getJDBCConnection(tableName);
    		pstmt = conn.prepareStatement(query);
    		pstmt.setString(1,"%" + TenHDV + "%");
    		rs = pstmt.executeQuery();
    		
    		while(rs.next()) {
    			HuongDanVienDTO dto = new HuongDanVienDTO();
    			
    			dto.setMaHDV(rs.getString("MaHDV"));
				dto.setHoTen(rs.getString("Ho") + " " + rs.getString("Ten"));
				dto.setNgaySinh(rs.getString("NgaySinh"));
				dto.setGioiTinh(rs.getString("GioiTinh"));
				dto.setDiaChi(rs.getString("DiaChi"));
				dto.setSdt(rs.getString("SDT"));
				dtos.add(dto);
    		}
    		
    		return dtos;
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return null;
    }
	
	public ArrayList<HuongDanVienDTO> getByHoHDV(String HoHDV) {
    	ArrayList<HuongDanVienDTO> dtos = new ArrayList<HuongDanVienDTO>();
    	String query = "SELECT * FROM " + tableName + " WHERE Ho LIKE ?"; 
    	try {
    		conn = JDBCConnection.getJDBCConnection(tableName);
    		pstmt = conn.prepareStatement(query);
    		pstmt.setString(1,"%" + HoHDV + "%");
    		rs = pstmt.executeQuery();
    		
    		while(rs.next()) {
    			HuongDanVienDTO dto = new HuongDanVienDTO();
    			
    			dto.setMaHDV(rs.getString("MaHDV"));
				dto.setHoTen(rs.getString("Ho") + " " + rs.getString("Ten"));
				dto.setNgaySinh(rs.getString("NgaySinh"));
				dto.setGioiTinh(rs.getString("GioiTinh"));
				dto.setDiaChi(rs.getString("DiaChi"));
				dto.setSdt(rs.getString("SDT"));
				dtos.add(dto);
    		}
    		
    		return dtos;
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return null;
    }
	
	public ArrayList<HuongDanVienDTO> getByMaHDV(String MaHDV) {
    	ArrayList<HuongDanVienDTO> dtos = new ArrayList<HuongDanVienDTO>();
    	String query = "SELECT * FROM " + tableName + " WHERE MaHDV = ?"; 
    	try {
    		conn = JDBCConnection.getJDBCConnection(tableName);
    		pstmt = conn.prepareStatement(query);
    		pstmt.setString(1, MaHDV);
    		rs = pstmt.executeQuery();
    		
    		while(rs.next()) {
    			HuongDanVienDTO dto = new HuongDanVienDTO();
    			
    			dto.setMaHDV(rs.getString("MaHDV"));
				dto.setHoTen(rs.getString("Ho") + " " + rs.getString("Ten"));
				dto.setNgaySinh(rs.getString("NgaySinh"));
				dto.setGioiTinh(rs.getString("GioiTinh"));
				dto.setDiaChi(rs.getString("DiaChi"));
				dto.setSdt(rs.getString("SDT"));
				dtos.add(dto);
    		}
    		
    		return dtos;
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return null;
    }
	
	public ArrayList<HuongDanVienDTO> getAll() {
		ArrayList<HuongDanVienDTO> dtos;
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "SELECT * FROM " + tableName;
			dtos = new ArrayList<HuongDanVienDTO>();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				HuongDanVienDTO dto = new HuongDanVienDTO();
			
				dto.setMaHDV(rs.getString("MaHDV"));
				dto.setHoTen(rs.getString("Ho") + " " + rs.getString("Ten"));
				dto.setNgaySinh(rs.getString("NgaySinh"));
				dto.setGioiTinh(rs.getString("GioiTinh"));
				dto.setDiaChi(rs.getString("DiaChi"));
				dto.setSdt(rs.getString("SDT"));
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
	
	public void add(HuongDanVienDTO dto) {
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "INSERT INTO " + tableName
					+ "(`MaHDV`, `Ho`, `Ten`, `NgaySinh`, `GioiTinh`, `DiaChi`, `SDT`)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMaHDV());
			pstmt.setString(2, getHo(dto.getHoTen()));
			pstmt.setString(3, getTen(dto.getHoTen()));
			pstmt.setString(4, dto.getNgaySinh());
			pstmt.setString(5, dto.getGioiTinh());
			pstmt.setString(6, dto.getDiaChi());
			pstmt.setString(7, dto.getSdt());
			
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
	
	public void update(HuongDanVienDTO dto) {
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "UPDATE " + tableName + " SET "
					+ "Ho = ?, Ten = ?, NgaySinh = ?, GioiTinh = ?, DiaChi = ?, SDT = ?"
					+ "WHERE MaHDV = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, getHo(dto.getHoTen()));
			pstmt.setString(2, getTen(dto.getHoTen()));
			pstmt.setString(3, dto.getNgaySinh());
			pstmt.setString(4, dto.getGioiTinh());
			pstmt.setString(5, dto.getDiaChi());
			pstmt.setString(6, dto.getSdt());
			
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
	
	public void deleteById(String maHdv) {
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "DELETE FROM " + tableName + " WHERE MaHDV = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, maHdv);
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
	
	public String getHo(String hoTen) {
		int lastSpaceIndex = hoTen.lastIndexOf(" ");

		return hoTen.substring(0, lastSpaceIndex);
	}
	
	public String getTen(String hoTen) {
		int lastSpaceIndex = hoTen.lastIndexOf(" ");

		return hoTen.substring(lastSpaceIndex).trim();
	}
	
	public String dateFormat(String ngaySinh) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		return LocalDate.parse(ngaySinh, formatter).format(formatter2);
	}
}
