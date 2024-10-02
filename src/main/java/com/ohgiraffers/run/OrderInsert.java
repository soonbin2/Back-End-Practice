package com.ohgiraffers.run;

import com.ohgiraffers.model.dao.OrderDAO;
import com.ohgiraffers.model.dto.OrderDTO;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class OrderInsert {

    public static void main(String[] args) {
        Connection con = getConnection();
        OrderDAO registDAO = new OrderDAO();

        int orderCode = 0;
        LocalDateTime orderDate = LocalDateTime.now();
        Scanner sc = new Scanner(System.in);
        System.out.print("주문 가격을 입력하세요 : ");
        int orderPrice = sc.nextInt();

        OrderDTO newOrder = new OrderDTO(orderCode, orderDate, orderPrice);
        int result = registDAO.insertOrder(con, newOrder);

        if (result > 0){
            System.out.println("주문 성공 !");
        }else{
            System.out.println("주문 실패 !");
        }
    }
}
