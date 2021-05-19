package com.myclass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import com.myclass.connector.JDBCConnection;
import com.myclass.dto.DoanDTO;
import com.myclass.dto.TourDTO;

public class DoanDAO {
	private final static String tableName = "doan";
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public ArrayList<DoanDTO> getAll() {
		ArrayList<DoanDTO> dtos;
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "SELECT * FROM " + tableName;
			dtos = new ArrayList<DoanDTO>();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				DoanDTO dto = new DoanDTO();
				
				dto.setMaDoan(rs.getString("MaDoan"));
				dto.setSoNguoi(rs.getInt("SoNguoi"));
				dto.setMaTour(rs.getString("MaTour"));
				dto.setMaHDV(rs.getString("MaHDV"));
				
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
	
    public DoanDTO getByMaDoan(String maDoan) {
    	String query = "SELECT * FROM " + tableName + " WHERE MaDoan = ?"; 
    	try {
    		DoanDTO dto = null;
    		conn = JDBCConnection.getJDBCConnection(tableName);
    		pstmt = conn.prepareStatement(query);
    		pstmt.setString(1, maDoan);
    		rs = pstmt.executeQuery();
    		
    		if(rs.next()) {
    			dto = new DoanDTO();

    			dto.setMaDoan(rs.getString("MaDoan"));
    			dto.setSoNguoi(rs.getInt("SoNguoi"));
    			dto.setMaTour(rs.getString("MaTour"));
			dto.setMaHDV(rs.getString("MaHDV"));
    		}
    		
    		return dto;
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return null;
    }
    
	public DoanDTO getByMaTour(String maTour) {
    	String query = "SELECT * FROM " + tableName + " WHERE MaTour = ?"; 
    	try {
    		DoanDTO dto = null;
    		conn = JDBCConnection.getJDBCConnection(tableName);
    		pstmt = conn.prepareStatement(query);
    		pstmt.setString(1, maTour);
    		rs = pstmt.executeQuery();
    		
    		if(rs.next()) {
    			dto = new DoanDTO();

    			dto.setMaDoan(rs.getString("MaDoan"));
    			dto.setSoNguoi(rs.getInt("SoNguoi"));
    			dto.setMaTour(rs.getString("MaTour"));
			dto.setMaHDV(rs.getString("MaHDV"));
    		}
    		
    		return dto;
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
		
		return null;
	}

	public DoanDTO getByMaHDV(String maHDV) {
    	String query = "SELECT * FROM " + tableName + " WHERE MaHDV = ?"; 
    	try {
    		DoanDTO dto = null;
    		conn = JDBCConnection.getJDBCConnection(tableName);
    		pstmt = conn.prepareStatement(query);
    		pstmt.setString(1, maHDV);
    		rs = pstmt.executeQuery();
    		
    		if(rs.next()) {
    			dto = new DoanDTO();

    			dto.setMaDoan(rs.getString("MaDoan"));
    			dto.setSoNguoi(rs.getInt("SoNguoi"));
    			dto.setMaTour(rs.getString("MaTour"));
    			dto.setMaHDV(rs.getString("MaHDV"));
    		}
    		
    		return dto;
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
		
		return null;
	}
    
	public Vector<String> getAllMaDoan() {
		Vector<String> listMaDoan;
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "SELECT MaDoan FROM " + tableName;
			listMaDoan = new Vector<String>();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				listMaDoan.add(rs.getString("MaDoan"));
			}
			
			return listMaDoan;
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

	public void deleteById(String maDoan) {
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "DELETE FROM " + tableName + " WHERE MaDoan = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, maDoan);
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

	public void add(DoanDTO dto) {
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "INSERT INTO " + tableName
					+ " (`MaDoan`, `SoNguoi`, `MaTour`, `MaHDV`) "
					+ "VALUES (?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMaDoan());
			pstmt.setInt(2, dto.getSoNguoi());
			pstmt.setString(3, dto.getMaTour());
			pstmt.setString(4, dto.getMaHDV());
			
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

	public void update(DoanDTO dto) {
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "UPDATE Doan SET "
					+ "SoNguoi = ?, MaTour = ?, MaHDV = ?"
					+ "WHERE MaDoan = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getSoNguoi());
			pstmt.setString(2, dto.getMaTour());
			pstmt.setString(3, dto.getMaDoan());
			pstmt.setString(4, dto.getMaHDV());
			
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
