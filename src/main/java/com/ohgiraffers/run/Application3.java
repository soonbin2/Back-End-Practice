package com.ohgiraffers.run;

import com.ohgiraffers.model.dao.ClothesDAO;
import com.ohgiraffers.model.dto.ClothesDTO;

import java.sql.Connection;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application3 {
    public static void main(String[] args) {

        Connection con = getConnection();

        ClothesDAO registDAO = new ClothesDAO();

        Scanner sc = new Scanner(System.in);

        System.out.print("삭제할 옷 번호를 입력하세요 : ");
        int clothesCode = sc.nextInt();

        ClothesDTO newClothes = new ClothesDTO(clothesCode);

        int result = registDAO.deleteClothes(con,newClothes);

        if(result > 0) {
            System.out.println("옷 삭제 성공 !");
        }else{
            System.out.println("옷 삭제 실패 !");
        }
    }
}
