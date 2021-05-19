/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myclass.dao;

import com.myclass.dto.KhachSanDTO;
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
public class KhachSanDAO {

    public static List<KhachSanDTO> xemDSKS() {
        List<KhachSanDTO> khachsanList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            //lấy tất cả danh sách khách sạn
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydulich", "root", "");
            //Query
            String sql = "select* from khachsan";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                KhachSanDTO ksDTO = new KhachSanDTO(resultSet.getString("maKS"), resultSet.getString("tenKS"), resultSet.getString("diachi"), resultSet.getString("website"), resultSet.getString("soDT"), resultSet.getInt("chiphi"));
                khachsanList.add(ksDTO);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ketthuc.
        return khachsanList;
    }

    public static void XoaTTKS(String maKS) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lấy tất cả danh sách khách sạn
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydulich", "root", "");
            //Query
            String sql = "delete from khachsan where maKS = ?";
            statement = connection.prepareCall(sql);

            statement.setString(1, maKS);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(KhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ketthuc.
    }

    public static void LuuTTKS(KhachSanDTO ksDTO) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lấy tất cả danh sách khách sạn
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydulich", "root", "");
            //Query
            String sql = "insert into khachsan( maKS, tenKS, diachi, website, soDT, chiphi) values(?,?,?,?,?,?)";
            statement = connection.prepareCall(sql);

            statement.setString(1, ksDTO.getMaKS());
            statement.setString(2, ksDTO.getTenKS());
            statement.setString(3, ksDTO.getDiachiKS());
            statement.setString(4, ksDTO.getWebsite());
            statement.setString(5, ksDTO.getSoDT());
            statement.setInt(6, ksDTO.getChiphi());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(KhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ketthuc.
    }

    public static List<KhachSanDTO> findByMaKS(String maKS) {
        List<KhachSanDTO> khachsanList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lấy tất cả danh sách khách sạn
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydulich", "root", "");
            //Query
            String sql = "select* from khachsan where maKS = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, maKS);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                KhachSanDTO ksDTO = new KhachSanDTO(resultSet.getString("maKS"), resultSet.getString("tenKS"), resultSet.getString("diachi"), resultSet.getString("website"), resultSet.getString("soDT"), resultSet.getInt("chiphi"));
                khachsanList.add(ksDTO);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ketthuc.
        return khachsanList;
    }
    
    public static List<KhachSanDTO> findByTenKS(String tenKS) {
        List<KhachSanDTO> khachsanList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lấy tất cả danh sách khách sạn
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydulich", "root", "");
            //Query
            String sql = "select* from khachsan where tenKS like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1,"%" + tenKS + "%");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                KhachSanDTO ksDTO = new KhachSanDTO(resultSet.getString("maKS"), resultSet.getString("tenKS"), resultSet.getString("diachi"), resultSet.getString("website"), resultSet.getString("soDT"), resultSet.getInt("chiphi"));
                khachsanList.add(ksDTO);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ketthuc.
        return khachsanList;
    }
    
    public static void CapNhatTTKS(KhachSanDTO ksDTO) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lấy tất cả danh sách khách sạn
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydulich", "root", "");
            //Query
            String sql = "update khachsan set tenKS=?, diachi=?, website=?, soDT=?, chiphi=? where maKS=? ";
            statement = connection.prepareCall(sql);

            statement.setString(1, ksDTO.getTenKS());
            statement.setString(2, ksDTO.getDiachiKS());
            statement.setString(3, ksDTO.getWebsite());
            statement.setString(4, ksDTO.getSoDT());
            statement.setInt(5, ksDTO.getChiphi());
            statement.setString(6, ksDTO.getMaKS());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(KhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachSanDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ketthuc.
    }
}
