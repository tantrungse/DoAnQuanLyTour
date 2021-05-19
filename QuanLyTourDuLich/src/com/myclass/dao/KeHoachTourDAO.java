package com.myclass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import com.myclass.connector.JDBCConnection;
import com.myclass.dto.DoanDTO;
import com.myclass.dto.KeHoachTourDTO;
import com.myclass.dto.TourDTO;

public class KeHoachTourDAO {
	private final static String tableName = "KeHoachTour";
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
    public KeHoachTourDTO getByMaKeHoach(String maKeHoach) {
    	String query = "SELECT * FROM " + tableName + " WHERE MaKeHoach = ?"; 
    	try {
    		KeHoachTourDTO dto = null;
    		conn = JDBCConnection.getJDBCConnection(tableName);
    		pstmt = conn.prepareStatement(query);
    		pstmt.setString(1, maKeHoach);
    		rs = pstmt.executeQuery();
    		
    		if(rs.next()) {
    			dto = new KeHoachTourDTO();

    			dto.setMaKeHoach(rs.getString("MaKeHoach"));
    			dto.setNgayBatDau(rs.getString("NgayBatDau"));
    			dto.setNgayKetThuc(rs.getString("NgayKetThuc"));
    			dto.setMaTour(rs.getString("MaTour"));
    		}
    		
    		return dto;
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return null;
    }

	public Vector<String> getAllMaKHTour() {
		Vector<String> listMaKHTour;
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "SELECT MaKeHoach FROM " + tableName;
			listMaKHTour = new Vector<String>();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				listMaKHTour.add(rs.getString("MaKeHoach"));
			}
			
			return listMaKHTour;
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

	public KeHoachTourDTO getByMaTour(String maTour) {
    	String query = "SELECT * FROM " + tableName + " WHERE MaTour = ?"; 
    	try {
    		KeHoachTourDTO dto = null;
    		conn = JDBCConnection.getJDBCConnection(tableName);
    		pstmt = conn.prepareStatement(query);
    		pstmt.setString(1, maTour);
    		rs = pstmt.executeQuery();
    		
    		if(rs.next()) {
    			dto = new KeHoachTourDTO();

    			dto.setMaKeHoach(rs.getString("MaKeHoach"));
    			dto.setNgayBatDau(rs.getString("NgayBatDau"));
    			dto.setNgayKetThuc(rs.getString("NgayKetThuc"));
    			dto.setMaTour(rs.getString("MaTour"));
    		}
    		
    		return dto;
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
		return null;
	}
}
