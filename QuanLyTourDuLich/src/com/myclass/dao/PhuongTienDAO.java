/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myclass.dao;

import com.myclass.dto.PhuongTienDTO;
import com.mysql.cj.xdevapi.Result;
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
public class PhuongTienDAO {

    public static List<PhuongTienDTO> XemDSPT() {
        List<PhuongTienDTO> phuongtienList = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;

        try {
            //Lấy danh sách phương tiện
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydulich", "root", "");
            //Query
            String sql = "select* from phuongtien";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                PhuongTienDTO ptDTO = new PhuongTienDTO(resultSet.getString("maPT"), resultSet.getString("tenPT"), resultSet.getString("diachi"), resultSet.getInt("sochongoi"), resultSet.getString("soDT"), resultSet.getInt("chiphi"));
                phuongtienList.add(ptDTO);

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
        return phuongtienList;
    }

    public static void luuDSPT(PhuongTienDTO ptDTO) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lấy Danh sách phương tiện
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydulich", "root", "");
            //Query
            String sql = "insert into phuongtien(maPT, tenPT, diachi, sochongoi, soDT, chiphi) values(?, ?, ?, ?, ?, ?)";

            statement = connection.prepareCall(sql);

            statement.setString(1, ptDTO.getMaPT());
            statement.setString(2, ptDTO.getTenPT());
            statement.setString(3, ptDTO.getDiachi());
            statement.setInt(4, ptDTO.getSochongoi());
            statement.setString(5, ptDTO.getSoDT());
            statement.setInt(6, ptDTO.getChiphi());

            statement.execute();
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
    }

    public static void XoaDSPT(String maPT) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //Lấy danh sách phương tiện
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydulich", "root", "");

            //Query
            String sql = "delete from phuongtien where maPT = ?";

            statement = connection.prepareCall(sql);
            statement.setString(1, maPT);
            statement.execute();
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

    }

    public static List<PhuongTienDTO> findByMaPT(String maPT) {
        List<PhuongTienDTO> phuongtienList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //Lấy danh sách phương tiện
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydulich", "root", "");
            String sql = "select* from phuongtien where maPT = ?";
            statement = connection.prepareCall(sql);

            statement.setString(1, maPT);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                PhuongTienDTO ptDTO = new PhuongTienDTO(resultSet.getString("maPT"), resultSet.getString("tenPT"), resultSet.getString("diachi"), resultSet.getInt("sochongoi"), resultSet.getString("soDT"), resultSet.getInt("chiphi"));
                phuongtienList.add(ptDTO);
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

        return phuongtienList;
    }

    public static List<PhuongTienDTO> findByTenPT(String tenPT) {
        List<PhuongTienDTO> phuongtienList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //Lấy danh sách phương tiện
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydulich", "root", "");
            String sql = "select* from phuongtien where tenPT like ?";
            
            statement = connection.prepareCall(sql);
            statement.setString(1, "%" + tenPT + "%");
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                PhuongTienDTO ptDTO = new PhuongTienDTO(resultSet.getString("maPT"), resultSet.getString("tenPT"), resultSet.getString("diachi"), resultSet.getInt("sochongoi"), resultSet.getString("soDT"), resultSet.getInt("chiphi"));
                phuongtienList.add(ptDTO);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhuongTienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PhuongTienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PhuongTienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return phuongtienList;
    }
    
    public static void CapNhatTTPT(PhuongTienDTO ptDTO) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lấy danh sách nhà hàng
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306:quanlydulich", "root", "");

            //Query
            String sql = "update phuongtien set tenPT = ?, diachi = ?, sochongoi = ?, soDT = ?, chiphi = ? where maPT = ?";
            statement = connection.prepareCall(sql);

            statement.setString(1, ptDTO.getTenPT());
            statement.setString(2, ptDTO.getDiachi());
            statement.setInt(3, ptDTO.getSochongoi());
            statement.setString(4, ptDTO.getSoDT());
            statement.setInt(5, ptDTO.getChiphi());
            statement.setString(6, ptDTO.getMaPT());

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
