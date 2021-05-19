/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myclass.dao;

import com.myclass.dto.DiaDiemThamQuanDTO;
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

/**
 *
 * @author Thin
 */
public class DiaDiemThamQuanDAO {
    
    public static List<DiaDiemThamQuanDTO> xemDSDD() {
        List<DiaDiemThamQuanDTO> diadiemList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            //lấy tất cả danh sách khách sạn
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydulich", "root", "");
            //Query
            String sql = "select* from diadiemthamquan";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                DiaDiemThamQuanDTO ddDTO = new DiaDiemThamQuanDTO(resultSet.getString("MaDiaDiem"), resultSet.getString("TenDiaDiem"), resultSet.getString("NoiDung"), resultSet.getString("DiaChi"));
                diadiemList.add(ddDTO);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiaDiemThamQuanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DiaDiemThamQuanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DiaDiemThamQuanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ketthuc.
        return diadiemList;
    }
    
    public static void XoaTTDD(String MaDiaDiem) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lấy tất cả danh sách khách sạn
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydulich", "root", "");
            //Query
            String sql = "delete from diadiemthamquan where MaDiaDiem = ?";
            statement = connection.prepareCall(sql);

            statement.setString(1, MaDiaDiem);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DiaDiemThamQuanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DiaDiemThamQuanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DiaDiemThamQuanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ketthuc.
    }
    
    public static void LuuTTDD(DiaDiemThamQuanDTO ddDTO) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lấy tất cả danh sách khách sạn
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydulich", "root", "");
            //Query
            String sql = "insert into diadiemthamquan( MaDiaDiem, TenDiaDiem, NoiDung, DiaChi) values(?,?,?,?)";
            statement = connection.prepareCall(sql);

            statement.setString(1, ddDTO.getMaDD());
            statement.setString(2, ddDTO.getTenDD());
            statement.setString(3, ddDTO.getND());
            statement.setString(4, ddDTO.getDiachi());           

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DiaDiemThamQuanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DiaDiemThamQuanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DiaDiemThamQuanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ketthuc.
    }
    
    public static List<DiaDiemThamQuanDTO> findByMaDD(String MaDiaDiem) {
        List<DiaDiemThamQuanDTO> diadiemList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lấy tất cả danh sách khách sạn
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydulich", "root", "");
            //Query
            String sql = "select* from diadiemthamquan where MaDiaDiem = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, MaDiaDiem);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                DiaDiemThamQuanDTO ddDTO = new DiaDiemThamQuanDTO(resultSet.getString("MaDiaDiem"), resultSet.getString("TenDiaDiem"), resultSet.getString("NoiDung"), resultSet.getString("DiaChi"));
                diadiemList.add(ddDTO);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiaDiemThamQuanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DiaDiemThamQuanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DiaDiemThamQuanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ketthuc.
        return diadiemList;
    }
    
    public static List<DiaDiemThamQuanDTO> findByTenDD(String TenDiaDiem) {
        List<DiaDiemThamQuanDTO> diadiemList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lấy tất cả danh sách khách sạn
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydulich", "root", "");
            //Query
            String sql = "select* from diadiemthamquan where TenDiaDiem like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1,"%" + TenDiaDiem + "%");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                DiaDiemThamQuanDTO ddDTO = new DiaDiemThamQuanDTO(resultSet.getString("MaDiaDiem"), resultSet.getString("TenDiaDiem"), resultSet.getString("NoiDung"), resultSet.getString("DiaChi"));
                diadiemList.add(ddDTO);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiaDiemThamQuanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DiaDiemThamQuanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DiaDiemThamQuanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ketthuc.
        return diadiemList;
    }
    
    public static void CapNhatTTDD(DiaDiemThamQuanDTO ddDTO) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lấy tất cả danh sách khách sạn
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydulich", "root", "");
            //Query
            String sql = "update diadiemthamquan set TenDiaDiem=?, NoiDung=?, DiaChi=? where MaDiaDiem =? ";
            statement = connection.prepareCall(sql);

            statement.setString(1, ddDTO.getTenDD());
            statement.setString(2, ddDTO.getND());
            statement.setString(3, ddDTO.getDiachi());
            statement.setString(4, ddDTO.getMaDD());
            

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DiaDiemThamQuanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DiaDiemThamQuanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DiaDiemThamQuanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ketthuc.
    }
}
