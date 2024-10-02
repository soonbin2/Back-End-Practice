package com.ohgiraffers.model.dao;

import com.ohgiraffers.model.dto.ClothesDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;

import static com.ohgiraffers.common.JDBCTemplate.close;

public class ClothesDAO {

    private Properties prop = new Properties();

    public ClothesDAO() {
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/clothes-query.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Map<String, Object>> selectAllList(Connection con) {
        Statement stmt = null;
        ResultSet rset = null;
        List<Map<String, Object>> categoryList = new ArrayList<>();

        String query = prop.getProperty("selectAllList");

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);

            while (rset.next()) {
                Map<String, Object> clothesList = new HashMap<>();
                clothesList.put("CLOTHES_CODE", rset.getInt("clothes_code"));
                clothesList.put("CLOTHES_NAME", rset.getString("clothes_name"));
                clothesList.put("CLOTHES_PRICE", rset.getInt("clothes_price"));
                clothesList.put("ORDERABLE_STATUS", rset.getString("orderable_status"));
                clothesList.put("CATEGORY_CODE", rset.getInt("category_code"));
                clothesList.put("CATEGORY_NAME", rset.getString("category_name"));
                categoryList.add(clothesList);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(stmt);
            close(rset);
        }
        return categoryList;
    }

    public int insertClothes(Connection con, ClothesDTO newClothes) {

        PreparedStatement pstmt = null;

        int result = 0;
        String query = prop.getProperty("insertClothes");

        try {
            pstmt=con.prepareStatement(query);
            pstmt.setInt(1,newClothes.getCode());
            pstmt.setString(2,newClothes.getName());
            pstmt.setInt(3,newClothes.getPrice());
            pstmt.setInt(4,newClothes.getCategoryCode());
            pstmt.setString(5,newClothes.getOrderableStatus());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public int deleteClothes(Connection con, ClothesDTO newClothes) {
        PreparedStatement pstmt = null;
        int result = 0;
        String query = prop.getProperty("deleteClothes");

        try {
            int clothesCode = newClothes.getCode();
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, clothesCode);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;

    }

    public int updateClothes(Connection con, ClothesDTO newClothes) {
        PreparedStatement pstmt = null;
        int result = 0;
        String query = prop.getProperty("updateClothes");

        try {
            pstmt = con.prepareStatement(query);

            pstmt.setString(1,newClothes.getName());
            pstmt.setInt(2,newClothes.getPrice());
            pstmt.setInt(3,newClothes.getCategoryCode());
            pstmt.setString(4,newClothes.getOrderableStatus());
            pstmt.setInt(5, newClothes.getCode());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;

    }

}
