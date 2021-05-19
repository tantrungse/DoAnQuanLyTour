package com.myclass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.myclass.connector.JDBCConnection;
import com.myclass.dto.TourDTO;

public class TourDAO {
	private final static String tableName = "tour";
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public TourDAO() {
		
	}
	
	public ArrayList<TourDTO> getByTenTour(String TenTour) {
    	ArrayList<TourDTO> dtos = new ArrayList<TourDTO>();
    	String query = "SELECT * FROM tour WHERE TenTour LIKE ?"; 
    	try {
    		conn = JDBCConnection.getJDBCConnection(tableName);
    		pstmt = conn.prepareStatement(query);
    		pstmt.setString(1, "%" + TenTour + "%");
    		rs = pstmt.executeQuery();
    		
    		while(rs.next()) {
    			TourDTO dto = new TourDTO();
    			
    			dto.setMaTour(rs.getString(1));
    			dto.setTenTour(rs.getString(2));
    			dto.setGiaVe(rs.getDouble(3));
    			dto.setDiemKhoiHanh(rs.getString(4));
    			dto.setDiemDen(rs.getString(5));
    			dtos.add(dto);
    		}
    		
    		return dtos;
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return null;
    }
	
	public ArrayList<TourDTO> getByMaTour(String MaTour) {
    	ArrayList<TourDTO> dtos = new ArrayList<TourDTO>();
    	String query = "SELECT * FROM tour WHERE MaTour = ?"; 
    	try {
    		conn = JDBCConnection.getJDBCConnection(tableName);
    		pstmt = conn.prepareStatement(query);
    		pstmt.setString(1, MaTour);
    		rs = pstmt.executeQuery();
    		
    		while(rs.next()) {
    			TourDTO dto = new TourDTO();
    			
    			dto.setMaTour(rs.getString(1));
    			dto.setTenTour(rs.getString(2));
    			dto.setGiaVe(rs.getDouble(3));
    			dto.setDiemKhoiHanh(rs.getString(4));
    			dto.setDiemDen(rs.getString(5));
    			dtos.add(dto);
    		}
    		
    		return dtos;
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return null;
    }
	
	public ArrayList<TourDTO> getAll() {
		ArrayList<TourDTO> dtos;
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "SELECT * FROM tour";
			dtos = new ArrayList<TourDTO>();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				TourDTO dto = new TourDTO();
				
				dto.setMaTour(rs.getString("MaTour"));
				dto.setTenTour(rs.getString("TenTour"));
				dto.setGiaVe(rs.getDouble("GiaVe"));
				dto.setDiemKhoiHanh(rs.getString("DiemKhoiHanh"));
				dto.setDiemDen(rs.getString("DiemDen"));
				
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
	
	public void add(TourDTO dto) {
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "INSERT INTO "
					+ "Tour(`MaTour`, `TenTour`, `GiaVe`, `DiemKhoiHanh`, `DiemDen`)"
					+ "VALUES (?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMaTour());
			pstmt.setString(2, dto.getTenTour());
			pstmt.setDouble(3, dto.getGiaVe());
			pstmt.setString(4, dto.getDiemKhoiHanh());
			pstmt.setString(5, dto.getDiemDen());
			
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
	
	public void update(TourDTO dto) {
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "UPDATE Tour SET "
					+ "TenTour = ?, GiaVe = ?, DiemKhoiHanh = ?, DiemDen = ?"
					+ "WHERE MaTour = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTenTour());
			pstmt.setDouble(2, dto.getGiaVe());
			pstmt.setString(3, dto.getDiemKhoiHanh());
			pstmt.setString(4, dto.getDiemDen());
			pstmt.setString(5, dto.getMaTour());
			
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
	
	public void deleteById(String maTour) {
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "DELETE FROM Tour WHERE MaTour = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, maTour);
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
