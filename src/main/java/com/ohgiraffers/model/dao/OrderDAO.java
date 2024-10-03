package com.ohgiraffers.model.dao;

import com.ohgiraffers.model.dto.OrderDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Properties;

public class OrderDAO {
    private Properties prop = new Properties();

    public OrderDAO() {
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/clothes-query.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int insertOrder(Connection con, OrderDTO newOrder) {
        PreparedStatement pstmt = null;
        int result = 0;

        String query = prop.getProperty("insertOrder");

        try {
            pstmt=con.prepareStatement(query);
            pstmt.setInt(1,newOrder.getCode());
            pstmt.setTimestamp(2, Timestamp.valueOf(newOrder.getDate()));
            pstmt.setInt(3, newOrder.getPrice());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;

    }

    public int insertOrderClothes(Connection con, OrderClothesDTO newOrderClothes) {
        String query = "INSERT INTO tbl_order_clothes (order_code, clothes_code, quantity) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, newOrderClothes.getOrderCode());
            pstmt.setInt(2, newOrderClothes.getClothesCode());
            pstmt.setInt(3, newOrderClothes.getQuantity());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

}
