package com.myclass.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.myclass.connector.JDBCConnection;
import com.myclass.dto.ChuongTrinhKMDTO;

public class ChuongTrinhKMDAO {

public static ArrayList<ChuongTrinhKMDTO> getAll()
{
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet resultSet = null;
	ArrayList<ChuongTrinhKMDTO> ctKMlist =new ArrayList<ChuongTrinhKMDTO>();
	
	try {
		
		conn = JDBCConnection.getJDBCConnection();
		String query = "SELECT * FROM khuyenmai";
		pstm = conn.prepareStatement(query);
		resultSet = pstm.executeQuery();
	
		while (resultSet.next()) {
			
		String makm=(resultSet.getString("Mã KM"));
		String matour=(resultSet.getString("Mã Tour"));
		String tentour=(resultSet.getString("Tên Tour"));
	    String noidung=(resultSet.getString("Nội dung khuyến mãi"));
		String daystart=(resultSet.getString("Ngày bắt đầu"));
		String dayend=(resultSet.getString("Ngày kết thúc"));
		ChuongTrinhKMDTO ctkm =new ChuongTrinhKMDTO(makm,matour,tentour,noidung,daystart,dayend);
		ctKMlist.add(ctkm);
		}
		
	resultSet.close();
		conn.close();
	}
	
	catch (Exception e) {
		// TODO: handle exception
	}
	
	return ctKMlist ;
	
}
public static void add(ChuongTrinhKMDTO ctkm)
{
	  ResultSet rs = null;
		   String sql = "INSERT INTO khuyenmai(`Mã KM`,`Mã Tour`,`Tên Tour`,`Nội dung khuyến mãi`,`Ngày bắt đầu` ,`Ngày kết thúc`) "
                   + "VALUES(?,?,?,?,?,?)";
         
        try (Connection conn = JDBCConnection.getJDBCConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {
        	
            // set parameters for statement
       	 pstmt.setString(1, ctkm.getMaKM());
           pstmt.setString(2,ctkm.getMaTourKM());
           pstmt.setString(3,ctkm.getTenTourKM());
           pstmt.setString(4,ctkm.getNoidungKM());
           pstmt.setString(5,ctkm.getTimeStartKM());
        
          
           pstmt.setString(6,ctkm.getTimeEndKM());

           int rowAffected = pstmt.executeUpdate();
          
       } catch (SQLException ex) {
           System.out.println(ex.getMessage());
       } finally {
           try {
               if(rs != null)  rs.close();
           } catch (SQLException e) {
               System.out.println(e.getMessage());
           }
       }
   }
public static void delete(String makm)
{

    
    Connection connection = null;
    PreparedStatement statement = null;
    
    try {
        //lay tat ca danh sach sinh vien
      connection=JDBCConnection.getJDBCConnection();
        String sql = "delete from khuyenmai where `Mã KM` = ?";
        statement = connection.prepareStatement(sql);
        
        statement.setString(1, makm);
        
        statement.executeUpdate();
    } catch (Exception ex) {
     ex.printStackTrace();
    } finally {
        if(statement != null) {
            try {
                statement.close();
            } catch (Exception ex) {
               ex.printStackTrace();
            }
        }
        
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception ex) {
               ex.printStackTrace();
            }
        }
    }
}
public static void sua(ChuongTrinhKMDTO ctkm)
{
	 
	    
	 String sqlUpdate = "UPDATE khuyenmai "
             + "SET `Mã KM` = ? , `Mã Tour`= ? , `Tên Tour` = ? ,`Nội dung khuyến mãi` = ? ,`Ngày bắt đầu` = ?, `Ngày kết thúc` =? "
             + "WHERE `Mã KM` = ?";
	 try (Connection conn = JDBCConnection.getJDBCConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlUpdate);) {

           pstmt.setString(1, ctkm.getMaKM());
           pstmt.setString(2, ctkm.getMaTourKM());
           pstmt.setString(3, ctkm.getTenTourKM());
           pstmt.setString(4, ctkm.getNoidungKM());
           pstmt.setString(5, ctkm.getTimeStartKM());
           pstmt.setString(6, ctkm.getTimeEndKM());
           pstmt.setString(7, ctkm.getMaKM());

        int i= pstmt.executeUpdate();
       System.out.println(i);
     
     } catch (SQLException ex) {
         System.out.println(ex.getMessage());
     }
	
}


public static ArrayList<ChuongTrinhKMDTO> timkiemtheoten( String tentk)
{
	
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet resultSet = null;
		ArrayList<ChuongTrinhKMDTO> listma =new ArrayList<ChuongTrinhKMDTO>();
		
		try {
			
			conn = JDBCConnection.getJDBCConnection();
			String query = "SELECT * FROM khuyenmai WHERE `Tên Tour` = ?";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, tentk);
			resultSet = pstm.executeQuery();
		
			while (resultSet.next()) {
				
			String makm=(resultSet.getString("Mã KM"));
			String matour=(resultSet.getString("Mã Tour"));
			String tentour=(resultSet.getString("Tên Tour"));
		    String noidung=(resultSet.getString("Nội dung khuyến mãi"));
			String daystart=(resultSet.getString("Ngày bắt đầu"));
			String dayend=(resultSet.getString("Ngày kết thúc"));
			ChuongTrinhKMDTO ctkm =new ChuongTrinhKMDTO(makm,matour,tentour,noidung,daystart,dayend);
			listma.add(ctkm);
			}
			
		resultSet.close();
			conn.close();
		}
		
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return listma;
		
	
}

}
