package com.ohgiraffers.run;

import com.ohgiraffers.model.dao.ClothesDAO;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application {

    public static void main(String[] args) {

        Connection con = getConnection();
        ClothesDAO registDAO = new ClothesDAO();

        List<Map<String, Object>> categoryList = registDAO.selectAllList(con);

        for (Map<String, Object> category : categoryList) {
            System.out.println("Category Code: " + category.get("CATEGORY_CODE"));
            System.out.println("Category Name: " + category.get("CATEGORY_NAME"));

            List<Map<String, String>> clothesList = (List<Map<String, String>>) category.get("CLOTHES");
            for (Map<String, String> clothes : clothesList) {
                System.out.println("    Clothes Name: " + clothes.get("CLOTHES_NAME"));
                System.out.println("    Clothes Price: " + clothes.get("CLOTHES_PRICE"));

            }
        }
    }
}
