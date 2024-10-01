package com.ohgiraffers.run;

import com.ohgiraffers.model.dao.ClothesDAO;
import com.ohgiraffers.model.dto.ClothesDTO;

import java.sql.Connection;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application2 {

    public static void main(String[] args) {

        Connection con = getConnection();
        ClothesDAO registDAO = new ClothesDAO();

        Scanner sc = new Scanner(System.in);

        System.out.print("옷의 이름을 입력해주세요 : ");
        String clothesName = sc.nextLine();
        System.out.print("옷의 가격을 입력해주세요 : ");
        int clothesPrice = sc.nextInt();
        System.out.print("옷의 카테고리를 입력해주세요(맨투맨,바지,후드티,티셔츠,외투) : ");
        sc.nextLine();
        String categoryName = sc.nextLine();
        System.out.print("바로 판매 메뉴에 등록하시겠습니까? (예/아니오) : ");
        String answer = sc.nextLine();

        int clothesCode = 0;

        int categoryCode=0;
        switch (categoryName) {
            case "맨투맨" : categoryCode=9; break;
            case "바지" : categoryCode=10; break;
            case "후드티" : categoryCode=5; break;
            case "티셔츠" : categoryCode=8; break;
            case "외투" : categoryCode=7; break;
        }

        String orderableStatus = "";
        switch (answer) {
            case "예" : orderableStatus = "Y"; break;
            case "아니오" : orderableStatus = "N"; break;
        }

        ClothesDTO newClothes = new ClothesDTO(clothesCode,clothesName,clothesPrice,categoryCode,orderableStatus);

        int result = registDAO.insertClothes(con, newClothes);

        if(result >0){
            System.out.println("신규 옷 등록 성공!");
        } else {
            System.out.println("신규 옷 등록 실패!");
        }
    }
}
