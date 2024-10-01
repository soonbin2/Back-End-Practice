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
                Map<String, Object> category = new HashMap<>();
                category.put("CATEGORY_CODE", rset.getInt("CATEGORY_CODE"));
                category.put("CATEGORY_NAME", rset.getString("CATEGORY_NAME"));

                // 옷 정보를 리스트에 추가
                List<Map<String, String>> clothesList = new ArrayList<>();

                // 현재 카테고리 코드
                int currentCategoryCode = rset.getInt("CATEGORY_CODE");
                do {
                    Map<String, String> clothes = new HashMap<>();
                    clothes.put("CLOTHES_NAME", rset.getString("CLOTHES_NAME"));
                    clothes.put("CLOTHES_PRICE", String.valueOf(rset.getInt("CLOTHES_PRICE"))); // 가격을 문자열로 변환
                    clothesList.add(clothes);
                } while (rset.next() && rset.getInt("CATEGORY_CODE") == currentCategoryCode);

                category.put("CLOTHES", clothesList); // CLOTHES를 List<Map<String, String>>로 추가
                categoryList.add(category);
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

}
