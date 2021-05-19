package com.myclass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import com.myclass.connector.JDBCConnection;
import com.myclass.dto.DiaDiemThamQuanDTO;

public class DiaDiemThamQuanDAO {
	private final static String tableName = "DiaDiemThamQuan";
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public ArrayList<DiaDiemThamQuanDTO> getAll() {
		ArrayList<DiaDiemThamQuanDTO> dtos;
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "SELECT * FROM " + tableName;
			dtos = new ArrayList<DiaDiemThamQuanDTO>();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				DiaDiemThamQuanDTO dto = new DiaDiemThamQuanDTO();
				
				dto.setMaDiaDiem(rs.getString("MaDiaDiem"));
				dto.setTenDiaDiem(rs.getString("TenDiaDiem"));
				dto.setDiaChi(rs.getString("DiaChi"));
				
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
	
    public DiaDiemThamQuanDTO getByMaDiaDiem(String maDiaDiem) {
    	String query = "SELECT * FROM " + tableName + " WHERE MaDiaDiem = ?"; 
    	try {
    		DiaDiemThamQuanDTO dto = null;
    		conn = JDBCConnection.getJDBCConnection(tableName);
    		pstmt = conn.prepareStatement(query);
    		pstmt.setString(1, maDiaDiem);
    		rs = pstmt.executeQuery();
    		
    		if(rs.next()) {
    			dto = new DiaDiemThamQuanDTO();

				dto.setMaDiaDiem(rs.getString("MaDiaDiem"));
				dto.setTenDiaDiem(rs.getString("TenDiaDiem"));
				dto.setDiaChi(rs.getString("DiaChi"));
    		}
    		
    		return dto;
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return null;
    }
    
	public Vector<String> getAllMaDiaDiem() {
		Vector<String> listMaDiaDiem;
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "SELECT MaDiaDiem FROM " + tableName;
			listMaDiaDiem = new Vector<String>();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				listMaDiaDiem.add(rs.getString("MaDiaDiem"));
			}
			
			return listMaDiaDiem;
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

	public void deleteById(String maDiaDiem) {
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "DELETE FROM " + tableName + " WHERE MaDiaDiem = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, maDiaDiem);
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

	public void add(DiaDiemThamQuanDTO dto) {
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "INSERT INTO " + tableName + "(`MaDiaDiem`, `TenDiaDiem`, `DiaChi`)"
					+ "VALUES (?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMaDiaDiem());
			pstmt.setString(2, dto.getTenDiaDiem());
			pstmt.setString(3, dto.getDiaChi());
			
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

	public void update(DiaDiemThamQuanDTO dto) {
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "UPDATE " + tableName + " SET "
					+ "TenDiaDiem = ?, DiaChi = ?"
					+ "WHERE MaDiaDiem = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getTenDiaDiem());
			pstmt.setString(2, dto.getDiaChi());
			pstmt.setString(3, dto.getMaDiaDiem());
			
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
