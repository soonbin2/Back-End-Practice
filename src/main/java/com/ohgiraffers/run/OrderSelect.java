package com.ohgiraffers.run;

import com.ohgiraffers.model.dao.OrderDAO;

import java.sql.Connection;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class OrderSelect {

    public static void main(String[] args) {

        Connection con = getConnection();
        OrderDAO registDAO = new OrderDAO();

        List<Map<String,Object>> OrderList = registDAO.selectOrderList(con);

        for(Map<String,Object> order : OrderList) {
            System.out.println("OrderCode : " + order.get("ORDER_CODE"));
            System.out.println("OrderDate : " + order.get("ORDER_DATE"));
            System.out.println("ClothesCode : " + order.get("CLOTHES_CODE"));
            System.out.println("OrderClothesPrice : " + order.get("ORDER_CLOTHES_PRICE"));
            System.out.println("OrderClothesAmount : " + order.get("ORDER_CLOTHES_AMOUNT"));
            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        }
    }
}
