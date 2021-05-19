package com.myclass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.myclass.connector.JDBCConnection;
import com.myclass.dto.KhachHangDTO;
import com.myclass.dto.TaiKhoanDTO;

public class KhachHangDAO {
	private final static String tableName = "khachhang";
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public KhachHangDAO() {
		
	}
	
	public KhachHangDTO getById(String maKH) {
		return null;
	}
	
	public ArrayList<KhachHangDTO> getAll() {
		ArrayList<KhachHangDTO> dtos;
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "SELECT * FROM KhachHang";
			dtos = new ArrayList<KhachHangDTO>();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				KhachHangDTO dto = new KhachHangDTO();
				
				dto.setMaKH(rs.getString("MaKH"));
				dto.setHoTenKH(rs.getString("HoKH") + " " + rs.getString("TenKH"));
				dto.setDiaChi(rs.getString("DiaChi"));
				dto.setSdt(rs.getString("SDT"));
				dto.setMaDoan(rs.getString("MaDoan"));
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
	
	public void add(KhachHangDTO dto) {
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "INSERT INTO "
					+ "KhachHang(`MaKH`, `HoKH`, `TenKH`, `DiaChi`, `SDT`, `MaDoan`)"
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMaKH());
			pstmt.setString(2, getHo(dto.getHoTenKH()));
			pstmt.setString(3, getTen(dto.getHoTenKH()));
			pstmt.setString(4, dto.getDiaChi());
			pstmt.setString(5, dto.getSdt());
			pstmt.setString(6, dto.getMaDoan());
			
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
	
	public void update(KhachHangDTO dto) {
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "UPDATE KhachHang SET "
					+ "HoKH = ?, TenKH = ?, DiaChi = ?, SDT = ?, MaDoan = ?"
					+ "WHERE MaKH = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, getHo(dto.getHoTenKH()));
			pstmt.setString(2, getTen(dto.getHoTenKH()));
			pstmt.setString(3, dto.getDiaChi());
			pstmt.setString(4, dto.getSdt());
			pstmt.setString(5, dto.getMaDoan());
			pstmt.setString(6, dto.getMaKH());
			
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
	
	public void deleteById(String maKH) {
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "DELETE FROM KhachHang WHERE MaKH = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, maKH);
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

	public ArrayList<KhachHangDTO> getByMaKH(String MaKH) {
    	ArrayList<KhachHangDTO> dtos = new ArrayList<KhachHangDTO>();
    	String query = "SELECT * FROM KhachHang WHERE MaKH = ?"; 
    	try {
    		conn = JDBCConnection.getJDBCConnection(tableName);
    		pstmt = conn.prepareStatement(query);
    		pstmt.setString(1,MaKH);
    		rs = pstmt.executeQuery();
    		
    		while(rs.next()) {
    			KhachHangDTO dto = new KhachHangDTO();
    			
    			dto.setMaKH(rs.getString("MaKH"));
    			dto.setHoTenKH(rs.getString("HoKH") + " " + rs.getString("TenKH"));
    			dto.setDiaChi(rs.getString("DiaChi"));
    			dto.setSdt(rs.getString("SDT"));
    			dto.setMaDoan(rs.getString("MaDoan"));
    			
    			dtos.add(dto);
    		}
    		
    		return dtos;
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
		return null;
	}
	
	public ArrayList<KhachHangDTO> getByHoKH(String HoKH) {
    	ArrayList<KhachHangDTO> dtos = new ArrayList<KhachHangDTO>();
    	String query = "SELECT * FROM KhachHang WHERE HoKH LIKE ?"; 
    	try {
    		conn = JDBCConnection.getJDBCConnection(tableName);
    		pstmt = conn.prepareStatement(query);
    		pstmt.setString(1,"%" + HoKH + "%");
    		rs = pstmt.executeQuery();
    		
    		while(rs.next()) {
    			KhachHangDTO dto = new KhachHangDTO();
    			
    			dto.setMaKH(rs.getString("MaKH"));
    			dto.setHoTenKH(rs.getString("HoKH") + " " + rs.getString("TenKH"));
    			dto.setDiaChi(rs.getString("DiaChi"));
    			dto.setSdt(rs.getString("SDT"));
    			dto.setMaDoan(rs.getString("MaDoan"));
    			
    			dtos.add(dto);
    		}
    		
    		return dtos;
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
		return null;
	}

	public ArrayList<KhachHangDTO> getByTenKH(String TenKH) {
    	ArrayList<KhachHangDTO> dtos = new ArrayList<KhachHangDTO>();
    	String query = "SELECT * FROM KhachHang WHERE TenKH LIKE ?"; 
    	try {
    		conn = JDBCConnection.getJDBCConnection(tableName);
    		pstmt = conn.prepareStatement(query);
    		pstmt.setString(1,"%" + TenKH + "%");
    		rs = pstmt.executeQuery();
    		
    		while(rs.next()) {
    			KhachHangDTO dto = new KhachHangDTO();
    			
    			dto.setMaKH(rs.getString("MaKH"));
    			dto.setHoTenKH(rs.getString("HoKH") + " " + rs.getString("TenKH"));
    			dto.setDiaChi(rs.getString("DiaChi"));
    			dto.setSdt(rs.getString("SDT"));
    			dto.setMaDoan(rs.getString("MaDoan"));
    			
    			dtos.add(dto);
    		}
    		
    		return dtos;
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
		return null;
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
