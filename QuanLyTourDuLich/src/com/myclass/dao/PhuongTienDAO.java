package com.myclass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import com.myclass.connector.JDBCConnection;
import com.myclass.dto.PhuongTienDTO;

public class PhuongTienDAO {
	private final static String tableName = "PhuongTien";
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public ArrayList<PhuongTienDTO> getAll() {
		ArrayList<PhuongTienDTO> dtos;
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "SELECT * FROM " + tableName;
			dtos = new ArrayList<PhuongTienDTO>();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PhuongTienDTO dto = new PhuongTienDTO();
				
				dto.setMaPhuongTien(rs.getString("MaPhuongTien"));
				dto.setTenPhuongTien(rs.getString("TenPhuongTien"));
				dto.setChiPhi(rs.getDouble("ChiPhi"));
				dto.setSoChoNgoi(rs.getInt("SoChoNgoi"));
				
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
	
    public PhuongTienDTO getByMaPhuongTien(String maPhuongTien) {
    	String query = "SELECT * FROM " + tableName + " WHERE MaPhuongTien = ?"; 
    	try {
    		PhuongTienDTO dto = null;
    		conn = JDBCConnection.getJDBCConnection(tableName);
    		pstmt = conn.prepareStatement(query);
    		pstmt.setString(1, maPhuongTien);
    		rs = pstmt.executeQuery();
    		
    		if(rs.next()) {
    			dto = new PhuongTienDTO();

				dto.setMaPhuongTien(rs.getString("MaPhuongTien"));
				dto.setTenPhuongTien(rs.getString("TenPhuongTien"));
				dto.setChiPhi(rs.getDouble("ChiPhi"));
				dto.setSoChoNgoi(rs.getInt("SoChoNgoi"));
    		}
    		
    		return dto;
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return null;
    }
    
	public Vector<String> getAllMaPhuongTien() {
		Vector<String> listMaPhuongTien;
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "SELECT MaDoan FROM " + tableName;
			listMaPhuongTien = new Vector<String>();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				listMaPhuongTien.add(rs.getString("MaPhuongTien"));
			}
			
			return listMaPhuongTien;
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

	public void deleteById(String maPhuongTien) {
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "DELETE FROM " + tableName + " WHERE MaPhuongTien = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, maPhuongTien);
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

	public void add(PhuongTienDTO dto) {
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "INSERT INTO " + tableName + "(`MaPhuongTien`, `TenPhuongTien`, `ChiPhi`, `SoChoNgoi`)"
					+ "VALUES (?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMaPhuongTien());
			pstmt.setString(2, dto.getTenPhuongTien());
			pstmt.setDouble(3, dto.getChiPhi());
			pstmt.setInt(4, dto.getSoChoNgoi());
			
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

	public void update(PhuongTienDTO dto) {
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "UPDATE " + tableName + " SET "
					+ "TenPhuongTien = ?, ChiPhi = ?, SoChoNgoi = ?"
					+ "WHERE MaPhuongTien = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getTenPhuongTien());
			pstmt.setDouble(2, dto.getChiPhi());
			pstmt.setInt(3, dto.getSoChoNgoi());
			pstmt.setString(4, dto.getMaPhuongTien());
			
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
