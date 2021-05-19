package com.myclass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.myclass.connector.JDBCConnection;
import com.myclass.dto.KeHoachTourDTO;
import com.myclass.dto.TourDTO;

public class KHTourDAO {
	private final static String tableName = "KeHoachTour";
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public KeHoachTourDTO getById(String maKHTour) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<KeHoachTourDTO> getAll() {
		ArrayList<KeHoachTourDTO> dtos;
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "SELECT * FROM KeHoachTour";
			dtos = new ArrayList<KeHoachTourDTO>();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				KeHoachTourDTO dto = new KeHoachTourDTO();
				
				dto.setMaKeHoach(rs.getString("MaKeHoach"));
				dto.setNgayBatDau(rs.getString("NgayBatDau"));
				dto.setNgayKetThuc(rs.getString("NgayKetThuc"));
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
	
	public void add(KeHoachTourDTO dto) throws SQLException {
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "INSERT INTO "
					+ "KeHoachTour(`MaKeHoach`, `NgayBatDau`, `NgayKetThuc`, `MaCTKH`)"
					+ "VALUES (?, ?, ?, ?,)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMaKeHoach());
			pstmt.setString(2, dto.getNgayBatDau());
			pstmt.setString(3, dto.getNgayKetThuc());
			
			int rowEffects = pstmt.executeUpdate();
			System.out.println("Row effects: " + rowEffects);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}

	public void update(KeHoachTourDTO dto) throws SQLException {
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "UPDATE KeHoachTour SET "
					+ "NgayBatDau = ?, NgayKetThuc = ?, MaCTKH = ?"
					+ "WHERE MaKeHoach = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getNgayBatDau());
			pstmt.setString(2, dto.getNgayKetThuc());
			pstmt.setString(3, dto.getMaKeHoach());
			
			int rowEffects = pstmt.executeUpdate();
			System.out.println("Row effects: " + rowEffects);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}

	public void deteleById(String maKeHoach) throws SQLException {
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "DELETE FROM " + tableName + " WHERE MaKeHoach = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, maKeHoach);
			int rowEffects = pstmt.executeUpdate();
			System.out.println("Row effects: " + rowEffects);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}

}
