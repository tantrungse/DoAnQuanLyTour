package com.myclass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.myclass.connector.JDBCConnection;
import com.myclass.dto.HopDongDTO;
import com.myclass.dto.KhachHangDTO;
import com.myclass.dto.TaiKhoanDTO;
import com.myclass.dto.TourDTO;

public class HopDongDAO {
	private final static String tableName = "hopdong";
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public ArrayList<HopDongDTO> getByMaHD(String MaHD) {
    	ArrayList<HopDongDTO> dtos = new ArrayList<HopDongDTO>();
    	String query = "SELECT * FROM " + tableName + " WHERE MaHD = ?"; 
    	try {
    		conn = JDBCConnection.getJDBCConnection(tableName);
    		pstmt = conn.prepareStatement(query);
    		pstmt.setString(1, MaHD);
    		rs = pstmt.executeQuery();
    		
    		while(rs.next()) {
    			HopDongDTO dto = new HopDongDTO();
    			
    			dto.setMaHD(rs.getString(1));
    			dto.setNgayLapHD(rs.getString(2));
    			dto.setNoiDung(rs.getString(3));
    			dto.setMaTour(rs.getString(4));
    			dtos.add(dto);
    		}
    		
    		return dtos;
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return null;
    }
    
	public HopDongDTO getByMaTour(String maTour) {
    	String query = "SELECT * FROM " + tableName + " WHERE MaTour = ?"; 
    	try {
    		HopDongDTO dto = null;
    		conn = JDBCConnection.getJDBCConnection(tableName);
    		pstmt = conn.prepareStatement(query);
    		pstmt.setString(1, maTour);
    		rs = pstmt.executeQuery();
    		
    		if(rs.next()) {
    			dto = new HopDongDTO();

    			dto.setMaHD(rs.getString("MaHD"));
    			dto.setNgayLapHD(rs.getString("NgayLapHD"));
    			dto.setNoiDung(rs.getString("NoiDung"));
    			dto.setMaTour(rs.getString("MaTour"));
    		}
    		
    		return dto;
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
		
		return null;
	}
    
	public ArrayList<HopDongDTO> getAll() {
		ArrayList<HopDongDTO> dtos;
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "SELECT * FROM " + tableName;
			dtos = new ArrayList<HopDongDTO>();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				HopDongDTO dto = new HopDongDTO();
				
				dto.setMaHD(rs.getString("MaHD"));
				dto.setNgayLapHD(rs.getString("NgayLapHD"));
				dto.setNoiDung(rs.getString("NoiDung"));
				dto.setMaTour(rs.getString("MaTour"));
				
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
	
	public void add(HopDongDTO dto) {
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "INSERT INTO " + tableName
					+ " (`MaHD`, `NgayLapHD`, `NoiDung`, `MaTour`)"
					+ "VALUES (?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMaHD());
			pstmt.setString(2, dto.getNgayLapHD());
			pstmt.setString(3, dto.getNoiDung());
			pstmt.setString(4, dto.getMaTour());
			
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

	public void deleteById(String maHD) {
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "DELETE FROM HopDong WHERE MaHD = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, maHD);
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

	public void update(HopDongDTO dto) {
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "UPDATE + tableName + SET "
					+ "NgayLapHD = ?, NoiDung = ?, MaTour = ?"
					+ "WHERE MaHD = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getNgayLapHD());
			pstmt.setString(2, dto.getNoiDung());
			pstmt.setString(3, dto.getMaTour());
			pstmt.setString(4, dto.getMaHD());
			
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
