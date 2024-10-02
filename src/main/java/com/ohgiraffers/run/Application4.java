package com.ohgiraffers.run;

import com.ohgiraffers.model.dao.ClothesDAO;
import com.ohgiraffers.model.dto.ClothesDTO;

import java.sql.Connection;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application4 {

    public static void main(String[] args) {

        Connection con = getConnection();

        ClothesDAO registDAO = new ClothesDAO();

        Scanner sc = new Scanner(System.in);
        System.out.print("변경할 옷의 코드를 입력하세요 : ");
        int clothesCode = sc.nextInt();
        sc.nextLine();
        System.out.print("변경할 옷의 이름을 입력하세요 : ");
        String clothesName = sc.nextLine();
        System.out.print("변경할 옷의 가격을 입력하세요 : ");
        int clothesPrice = sc.nextInt();
        System.out.print("변경할 옷의 카테고리 코드를 입력하세요 : ");
        int categoryCode = sc.nextInt();
        sc.nextLine();
        System.out.print("변경할 옷의 판매여부를 입력하세요 (예/아니오) : ");
        String answer = sc.nextLine();

        String orderableStatus = "";
        switch (answer) {
            case "예" : orderableStatus = "Y"; break;
            case "아니오" : orderableStatus = "N"; break;
        }

        ClothesDTO newClothes = new ClothesDTO(clothesCode, clothesName, clothesPrice, categoryCode, orderableStatus);

        int result = registDAO.updateClothes(con, newClothes);

        if (result > 0){
            System.out.println("옷 변경 성공 !");
        }else{
            System.out.println("옷 변경 실패 !");
        }


    }
}
