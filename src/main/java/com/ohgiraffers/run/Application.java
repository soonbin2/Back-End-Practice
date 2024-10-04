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



        List<Map<String, Object>> categoryList = registDAO.selectClothesList(con);



        for (Map<String, Object> category : categoryList) {
            System.out.println("Clothes Code: " + category.get("CLOTHES_CODE"));
            System.out.println("Clothes Name: " + category.get("CLOTHES_NAME"));
            System.out.println("Clothes PRICE: " + category.get("CLOTHES_PRICE"));
            System.out.println("Orderale Status: " + category.get("ORDERABLE_STATUS"));
            System.out.println("Category code: " + category.get("CATEGORY_CODE"));
            System.out.println("Category name: " + category.get("CATEGORY_NAME"));
            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

            }
        }
    }

