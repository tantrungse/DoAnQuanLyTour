/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myclass.dao;

import com.myclass.dto.NhaHangDTO;
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
public class NhaHangDAO {

    /**
     * @param args the command line arguments
     */
    public static List<NhaHangDTO> xemDSNH() {

        List<NhaHangDTO> nhahangList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {
            //lấy tất cả danh sách nhà hàng
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydulich", "root", "");
            //Query
            String sql = "select* from nhahang";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                NhaHangDTO nhDTO = new NhaHangDTO(resultSet.getString("maNH"), resultSet.getString("tenNH"), resultSet.getString("diachi"), resultSet.getString("website"), resultSet.getString("soDT"), resultSet.getInt("chiphi"));
                nhahangList.add(nhDTO);
            }

        } catch (SQLException ex) {
            Logger.getLogger(NhaHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhaHangDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhaHangDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        //ket thuc.
        return nhahangList;
    }

    public static void luuTTNH(NhaHangDTO nhDTO) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay danh sach nha hang
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydulich", "root", "");
            String sql = "insert into nhahang(maNH, tenNH, diachi, website, soDT, chiphi) values(?, ?, ?, ?, ?, ?)";

            statement = connection.prepareCall(sql);

            statement.setString(1, nhDTO.getMaNH());
            statement.setString(2, nhDTO.getTenNH());
            statement.setString(3, nhDTO.getDiachi());
            statement.setString(4, nhDTO.getWebsite());
            statement.setString(5, nhDTO.getSoDT());
            statement.setInt(6, nhDTO.getChiphi());

            statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(NhaHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhaHangDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhaHangDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }

    public static List<NhaHangDTO> findByMaNH(String maNH) {

        List<NhaHangDTO> nhahangList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lấy danh sách nhà hàng được tìm kiếm theo mã
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydulich", "root", "");
            //Query
            String sql = "select* from nhahang where maNH = ?";
            statement = connection.prepareCall(sql);

            statement.setString(1, maNH);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                NhaHangDTO nhDTO = new NhaHangDTO(resultSet.getString("maNH"), resultSet.getString("tenNH"), resultSet.getString("diachi"), resultSet.getString("website"), resultSet.getString("soDT"), resultSet.getInt("chiphi"));
                nhahangList.add(nhDTO);
            }

        } catch (SQLException ex) {
            Logger.getLogger(NhaHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhaHangDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhaHangDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        //ket thuc.
        return nhahangList;
    }

    public static List<NhaHangDTO> findByTenNH(String tenNH) {

        List<NhaHangDTO> nhahangList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lấy danh sách nhà hàng được tìm kiếm theo tenNH

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydulich", "root", "");

            //Query
            String sql = "select* from nhahang where tenNH like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%" + tenNH + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                NhaHangDTO nhDTO = new NhaHangDTO(resultSet.getString("maNH"), resultSet.getString("tenNH"), resultSet.getString("diachi"), resultSet.getString("website"), resultSet.getString("soDT"), resultSet.getInt("chiphi"));
                nhahangList.add(nhDTO);
            }

        } catch (SQLException ex) {
            Logger.getLogger(NhaHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhaHangDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhaHangDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return nhahangList;
    }

    public static void XoaTTNH(String maNH) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lấy danh sách nhà hàng
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydulich", "root", "");
            //Query
            String sql = "delete from nhahang where maNH = ?";

            statement = connection.prepareCall(sql);

            statement.setString(1, maNH);
            statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(NhaHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhaHangDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhaHangDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void CapNhatTTNH(NhaHangDTO nhDTO) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lấy danh sách nhà hàng
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306:quanlydulich", "root", "");

            //Query
            String sql = "update nhahang set tenNH = ?, diachi = ?, website = ?, soDT = ?, chiphi = ? where maNH = ?";
            statement = connection.prepareCall(sql);

            statement.setString(1, nhDTO.getTenNH());
            statement.setString(2, nhDTO.getDiachi());
            statement.setString(3, nhDTO.getWebsite());
            statement.setString(4, nhDTO.getSoDT());
            statement.setInt(5, nhDTO.getChiphi());
            statement.setString(6, nhDTO.getMaNH());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(NhaHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhaHangDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhaHangDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
}
