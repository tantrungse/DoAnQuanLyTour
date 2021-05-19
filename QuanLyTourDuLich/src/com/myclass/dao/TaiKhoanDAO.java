package com.myclass.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.myclass.connector.JDBCConnection;
import com.myclass.dto.PhuongTienDTO;
import com.myclass.dto.TaiKhoanDTO;

public class TaiKhoanDAO {
	private final static String tableName = "TaiKhoan";
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public static ArrayList<TaiKhoanDTO> logindaonhanvien()
	{
		ArrayList<TaiKhoanDTO> list=new ArrayList<TaiKhoanDTO>();
		TaiKhoanDTO acc=new TaiKhoanDTO();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet resultSet = null;
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String query = "SELECT * FROM taikhoan\n" + "WHERE`Quyen`=1 ";
			pstm = conn.prepareStatement(query);
	
			
			resultSet = pstm.executeQuery();
			
			if(resultSet.next()) {
				acc.setTenTK(resultSet.getString("TenTK"));
				acc.setMatKhau(resultSet.getString("MatKhau"));
				acc.setQuyen(resultSet.getInt("Quyen"));
				list.add(acc);
			   
			}
		}catch (Exception e) {
		e.printStackTrace();
		}
	return list;
		}
	public static ArrayList<TaiKhoanDTO>  logindao()
	{
		ArrayList<TaiKhoanDTO> list=new ArrayList<TaiKhoanDTO>();
		TaiKhoanDTO acc=new TaiKhoanDTO();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet resultSet = null;
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			String query = "SELECT * FROM taikhoan" ;
			pstm = conn.prepareStatement(query);
			
			
			
			resultSet = pstm.executeQuery();
			
		if(resultSet.next()) {
			acc.setTenTK(resultSet.getString("TenTK"));
			acc.setMatKhau(resultSet.getString("MatKhau"));
			acc.setQuyen(resultSet.getInt("Quyen"));
			list.add(acc);
		   //JOptionPane.showMessageDialog(null,"Báº¡n Ä‘Ã£ Ä‘Äƒng nháº­p vá»›i quyá»�n admin");
		}
		}catch (Exception e) {
		e.printStackTrace();
		}
      return list;
		}
	
    public static ArrayList<TaiKhoanDTO> getAll() {
    	ArrayList<TaiKhoanDTO> dtos = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;

        try {
            //Láº¥y danh sÃ¡ch phÆ°Æ¡ng tiá»‡n
            connection = JDBCConnection.getJDBCConnection(tableName);
            //Query
            String sql = "Select * from " + tableName;
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                TaiKhoanDTO dto = new TaiKhoanDTO(resultSet.getString(1), resultSet.getString(2), Integer.valueOf(resultSet.getString(3)));
                dtos.add(dto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhuongTienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PhuongTienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PhuongTienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
        return dtos;
    }
    
    public ArrayList<TaiKhoanDTO> getByTenTK(String tenTK) {
    	ArrayList<TaiKhoanDTO> dtos = new ArrayList<TaiKhoanDTO>();
    	String query = "SELECT * FROM taikhoan WHERE TenTK LIKE ?"; 
    	try {
    		conn = JDBCConnection.getJDBCConnection(tableName);
    		pstmt = conn.prepareStatement(query);
    		pstmt.setString(1, tenTK + "%");
    		rs = pstmt.executeQuery();
    		
    		while(rs.next()) {
    			TaiKhoanDTO dto = new TaiKhoanDTO();
    			
    			dto.setTenTK(rs.getString(1));
    			dto.setMatKhau(rs.getString(2));
    			dto.setQuyen(rs.getInt(3));
    			
    			dtos.add(dto);
    		}
    		
    		return dtos;
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return null;
    }
    
	public void update(TaiKhoanDTO dto) {
		try {	
			conn = JDBCConnection.getJDBCConnection(tableName);
			String sql = "UPDATE TaiKhoan SET "
					+ "MatKhau = ?, Quyen = ? "
					+ "WHERE TenTK = ?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMatKhau());
			pstmt.setDouble(2, dto.getQuyen());
			pstmt.setString(3, dto.getTenTK());
		
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
	
	public void deleteByTenTK(String tenTK) {
		Connection conn = null;
		Statement stmt = null;
		String query = "DELETE FROM taikhoan WHERE TenTK = '" + tenTK + "';";
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			stmt = conn.createStatement();
			stmt.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void add(TaiKhoanDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO taikhoan(`TenTK`, `MatKhau`, `Quyen`) VALUES (?, ?, ?)";
		try {
			conn = JDBCConnection.getJDBCConnection(tableName);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getTenTK());
			pstmt.setString(2, dto.getMatKhau());
			pstmt.setInt(3, dto.getQuyen());
			
			int i = pstmt.executeUpdate();
			System.out.println("Row effected: " + i);
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
