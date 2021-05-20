package com.myclass.dao;

import com.myclass.connector.JDBCConnection;
import com.myclass.dto.KhachSanDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class KhachSanDAO {
	private final static String tableName = "KhachSan";
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public ArrayList<KhachSanDTO> getAll() {
		ArrayList<KhachSanDTO> dtos;
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "SELECT * FROM " + tableName;
			dtos = new ArrayList<KhachSanDTO>();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				KhachSanDTO dto = new KhachSanDTO();
				
				dto.setMaKhachSan(rs.getString("MaKhachSan"));
				dto.setTenKhachSan(rs.getString("TenKhachSan"));
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
	
    public KhachSanDTO getByMaKhachSan(String maNhaHang) {
    	String query = "SELECT * FROM " + tableName + " WHERE MaKhachSan = ?"; 
    	try {
    		KhachSanDTO dto = null;
    		conn = JDBCConnection.getJDBCConnection(tableName);
    		pstmt = conn.prepareStatement(query);
    		pstmt.setString(1, maNhaHang);
    		rs = pstmt.executeQuery();
    		
    		if(rs.next()) {
    			dto = new KhachSanDTO();

				dto.setMaKhachSan(rs.getString("MaKhachSan"));
				dto.setTenKhachSan(rs.getString("TenKhachSan"));
				dto.setDiaChi(rs.getString("DiaChi"));
				dto.setChiPhiTrenNguoi(rs.getDouble("ChiPhiTrenNguoi"));
    		}
    		
    		return dto;
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return null;
    }
    
	public Vector<String> getAllMaKhachSan() {
		Vector<String> listMaKhachSan;
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "SELECT MaKhachSan FROM " + tableName;
			listMaKhachSan = new Vector<String>();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				listMaKhachSan.add(rs.getString("MaKhachSan"));
			}
			
			return listMaKhachSan;
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

	public void deleteById(String maKhachSan) {
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "DELETE FROM " + tableName + " WHERE MaKhachSan = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, maKhachSan);
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

	public void add(KhachSanDTO dto) {
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "INSERT INTO " + tableName + "(`MaKhachSan`, `TenKhachSan`, `DiaChi`, `ChiPhiTrenNguoi`)"
					+ "VALUES (?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMaKhachSan());
			pstmt.setString(2, dto.getTenKhachSan());
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

	public void update(KhachSanDTO dto) {
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "UPDATE " + tableName + " SET "
					+ "TenKhachSan = ?, DiaChi = ?, ChiPhiTrenNguoi = ?"
					+ "WHERE MaKhachSan = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getTenKhachSan());
			pstmt.setString(2, dto.getDiaChi());
			pstmt.setDouble(3, dto.getChiPhiTrenNguoi());
			pstmt.setString(4, dto.getMaKhachSan());
			
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
