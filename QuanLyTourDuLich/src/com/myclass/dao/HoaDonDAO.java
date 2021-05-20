package com.myclass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

//main



import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import org.apache.poi.util.SystemOutLogger;

import com.myclass.connector.JDBCConnection;
import com.myclass.dto.ChiTietHoaDonDTO;
import com.myclass.dto.ChuongTrinhKMDTO;
import com.myclass.dto.HoaDonDTO;

public class HoaDonDAO {


	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet resultSet = null;

  public HoaDonDAO() {

  }

  public ArrayList docHD() throws SQLException, Exception { //cáº§n ghi láº¡i khi qua class khÃ¡c
  
      ArrayList<HoaDonDTO> HD = new ArrayList<>();
 
    		conn = JDBCConnection.getJDBCConnection("quanlytourdulich");
          String qry = "SELECT * FROM hoadon";

      	try {
      		
      		conn = JDBCConnection.getJDBCConnection("quanlytourdulich");
      		String query = "SELECT * FROM hoadondb";
      		pstm = conn.prepareStatement(query);
      		resultSet = pstm.executeQuery();
      	
      		while (resultSet.next()) {
      			
      		String maHD=(resultSet.getString("maHoaDon"));
      		String maKH=(resultSet.getString("maKH"));
      		String maKM=(resultSet.getString("Mã KM"));
            String noidungKM=(resultSet.getString("noidungKM"));
      		Float TongTien=(resultSet.getFloat("TongTien"));
      		LocalDate ngaylap = (resultSet.getDate("NgayLap").toLocalDate());
      		HoaDonDTO ctkm =new HoaDonDTO(maHD,maKH,maKM,noidungKM,TongTien,ngaylap);
      		HD.add(ctkm);
      		}
      		
      	resultSet.close();
      		conn.close();
      	}
      	
      	catch (Exception e) {
      		// TODO: handle exception
      	}
      	
      	return HD ;
      	
      }
  public ArrayList docCTHD(String ma) throws SQLException, Exception {
	  
      ArrayList<ChiTietHoaDonDTO> CTHD = new ArrayList<>();
 
    		conn = JDBCConnection.getJDBCConnection("quanlytourdulich");
          String qry = "SELECT * FROM chitiethddb where `maHoaDon` = " + "'"+ma+"'";
          System.out.print(qry);

      	try {
      		
      		conn = JDBCConnection.getJDBCConnection("quanlytourdulich");
      		String query = "SELECT * FROM chitiethddb";
      		pstm = conn.prepareStatement(qry);
      		resultSet = pstm.executeQuery();
      	
      		while (resultSet.next()) {
      			
      		String maHD=(resultSet.getString("maHoaDon"));
      		String tenKH=(resultSet.getString("tenKH"));
      		String tentour=(resultSet.getString("tentour"));
            int soluong=(resultSet.getInt("soluong"));
      		Float giave=(resultSet.getFloat("giaVe"));
      		Float thanhtien = (resultSet.getFloat("ThanhTien"));
      		ChiTietHoaDonDTO ctkm =new ChiTietHoaDonDTO(maHD,tentour,soluong,giave,thanhtien,tenKH);
      		CTHD.add(ctkm);
      		}
      		
      	resultSet.close();
      		conn.close();
      	}
catch (Exception e) {
      		// TODO: handle exception
      	}
      	
      	return CTHD ;
      	
      }
  
  public void them(HoaDonDTO HD) { 
    
      
      ResultSet rs = null;
	   String sql = "INSERT INTO hoadondb(`maHoaDon`,`maKH`,`Mã KM`,`noidungKM`,`TongTien`,`NgayLap`) "
              + "VALUES(?,?,?,?,?,?)";
    
   try (Connection conn = JDBCConnection.getJDBCConnection("quanlytourdulich");
        PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {
   	
       // set parameters for statement
  	 pstmt.setString(1, HD.getMaHoaDon());
      pstmt.setString(2,HD.getMaKH());
      pstmt.setString(3,HD.getMaKM());
      pstmt.setString(4, HD.getnoidungKM());
      pstmt.setFloat(5,HD.getTongTien());
       pstmt.setString(6,String.valueOf(HD.getNgayLap()));
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
  public void xoa(String IDHoaDon) { 

		Connection connection=null;
		PreparedStatement statement = null;
		try {
		        //lay tat ca danh sach sinh vien
		      connection=JDBCConnection.getJDBCConnection("quanlytourdulich");
		        String sql = "delete from hoadondb where `maHoaDon` = ?";
		        statement = connection.prepareStatement(sql);
		        
		        statement.setString(1,IDHoaDon);
		        
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
  public void xoa(HoaDonDTO HD) { 
	
	Connection connection=null;
	PreparedStatement statement = null;
	try {
	       
	      connection=JDBCConnection.getJDBCConnection("quanlytourdulich");
	        String sql = "delete from hoadondb where `Mã KM` = ?";
	        statement = connection.prepareStatement(sql);
	        statement.setString(1,HD.getMaHoaDon());
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



  public void sua(HoaDonDTO HD) {
String sqlUpdate = "UPDATE hoadondb "
              + "SET  `maKH`= ? , `Mã KM` = ? ,`noidungKM` = ?, `TongTien` =? ,`NgayLap`=?"
              + "WHERE `maHoaDon` = ?";
 	 try (Connection conn = JDBCConnection.getJDBCConnection("quanlytourdulich");
              PreparedStatement pstmt = conn.prepareStatement(sqlUpdate);) {

 	  
 	      pstmt.setString(1,HD.getMaKH());
 	      pstmt.setString(2,HD.getMaKM());
 	      pstmt.setString(3, HD.getnoidungKM());
 	
 	       pstmt.setFloat(4,HD.getTongTien());
 	       pstmt.setString(5, String.valueOf(HD.getNgayLap()));
 	      pstmt.setString(6,HD.getMaHoaDon());

         int i= pstmt.executeUpdate();
        System.out.println(i);
      
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      }
 	
  }

}