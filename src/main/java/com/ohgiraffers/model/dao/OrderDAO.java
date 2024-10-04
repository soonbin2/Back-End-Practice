package com.ohgiraffers.model.dao;

import com.ohgiraffers.model.dto.OrderDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;

import static com.ohgiraffers.common.JDBCTemplate.close;

public class OrderDAO {
    private Properties prop = new Properties();

    public OrderDAO() {
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/clothes-query.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Map<String,Object>> selectOrderList(Connection con){
        Statement stmt = null;
        ResultSet rset = null;
        List<Map<String,Object>> clothesList = new ArrayList<>();

        String query = prop.getProperty("selectOrderList");


        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);
            while (rset.next()) {
                Map<String,Object> orderList = new HashMap<>();
                orderList.put("ORDER_CODE", rset.getInt("ORDER_CODE"));
                orderList.put("ORDER_DATE",rset.getTimestamp("ORDER_DATE"));
                orderList.put("CLOTHES_CODE", rset.getInt("CLOTHES_CODE"));
                orderList.put("ORDER_CLOTHES_PRICE", rset.getInt("ORDER_CLOTHES_PRICE"));
                orderList.put("ORDER_CLOTHES_AMOUNT", rset.getInt("ORDER_CLOTHES_AMOUNT"));
                clothesList.add(orderList);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(stmt);
            close(rset);
        }
        return clothesList;
    }

    public int insertOrder(Connection con, OrderDTO newOrder) {
        PreparedStatement pstmt = null;

        int result = 0;

        String query = prop.getProperty("insertOrder");


        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1,newOrder.getCode());
            pstmt.setTimestamp(2, Timestamp.valueOf(newOrder.getDate()));
            pstmt.setInt(3, newOrder.getClothesCode());
            pstmt.setInt(4, newOrder.getPrice());
            pstmt.setInt(5, newOrder.getAmount());

            result=pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(pstmt);
        }
        return result;

    }

//    public int insertOrderClothes(Connection con, OrderDTO newOrder) {
//        PreparedStatement pstmt = null;
//        int result = 0;
//        String query = prop.getProperty("insertOrderClothes");
//        try {
//
//            pstmt = con.prepareStatement(query);
//            pstmt.setInt(1, newOrder.getOrderCode());
//            pstmt.setInt(2, newOrder.getClothesCode());
//            pstmt.setInt(3, newOrder.getAmount());
//            pstmt.setInt(4, newOrder.getPrice());
//            result = pstmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//
//        }
//        return result;
//    }


}
