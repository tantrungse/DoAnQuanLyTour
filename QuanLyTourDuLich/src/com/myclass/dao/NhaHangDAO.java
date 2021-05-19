package com.myclass.dao;

import com.myclass.connector.JDBCConnection;
import com.myclass.dto.NhaHangDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class NhaHangDAO {
	private final static String tableName = "NhaHang";
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public ArrayList<NhaHangDTO> getAll() {
		ArrayList<NhaHangDTO> dtos;
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "SELECT * FROM " + tableName;
			dtos = new ArrayList<NhaHangDTO>();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NhaHangDTO dto = new NhaHangDTO();
				
				dto.setMaNhaHang(rs.getString("MaNhaHang"));
				dto.setTenNhaHang(rs.getString("TenNhaHang"));
				dto.setDiaChi(rs.getString("DiaChi"));
				dto.setChiPhiTrenNguoi(rs.getDouble("ChiPhiTrenNguoi"));
				
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
	
    public NhaHangDTO getByMaNhaHang(String maNhaHang) {
    	String query = "SELECT * FROM " + tableName + " WHERE MaNhaHang = ?"; 
    	try {
    		NhaHangDTO dto = null;
    		conn = JDBCConnection.getJDBCConnection(tableName);
    		pstmt = conn.prepareStatement(query);
    		pstmt.setString(1, maNhaHang);
    		rs = pstmt.executeQuery();
    		
    		if(rs.next()) {
    			dto = new NhaHangDTO();

				dto.setMaNhaHang(rs.getString("MaNhaHang"));
				dto.setTenNhaHang(rs.getString("TenNhaHang"));
				dto.setDiaChi(rs.getString("DiaChi"));
				dto.setChiPhiTrenNguoi(rs.getDouble("ChiPhiTrenNguoi"));
    		}
    		
    		return dto;
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return null;
    }
    
	public Vector<String> getAllMaNhaHang() {
		Vector<String> listMaNhaHang;
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "SELECT MaNhaHang FROM " + tableName;
			listMaNhaHang = new Vector<String>();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				listMaNhaHang.add(rs.getString("MaNhaHang"));
			}
			
			return listMaNhaHang;
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

	public void deleteById(String maNhaHang) {
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "DELETE FROM " + tableName + " WHERE MaNhaHang = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, maNhaHang);
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

	public void add(NhaHangDTO dto) {
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "INSERT INTO " + tableName + "(`MaNhaHang`, `TenNhaHang`, `DiaChi`, `ChiPhiTrenNguoi`)"
					+ "VALUES (?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMaNhaHang());
			pstmt.setString(2, dto.getTenNhaHang());
			pstmt.setString(3, dto.getDiaChi());
			pstmt.setDouble(4, dto.getChiPhiTrenNguoi());
			
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

	public void update(NhaHangDTO dto) {
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "UPDATE " + tableName + " SET "
					+ "TenNhaHang = ?, DiaChi = ?, ChiPhiTrenNguoi = ?"
					+ "WHERE MaNhaHang = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getTenNhaHang());
			pstmt.setString(2, dto.getDiaChi());
			pstmt.setDouble(3, dto.getChiPhiTrenNguoi());
			pstmt.setString(4, dto.getMaNhaHang());
			
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
