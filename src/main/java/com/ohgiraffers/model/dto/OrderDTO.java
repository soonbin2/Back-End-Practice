package com.ohgiraffers.model.dto;

import java.time.LocalDateTime;

public class OrderDTO {
    private int code;
    private LocalDateTime date;
    private int price;
    private int amount;
    private int clothesCode;
    private int orderCode;

    public OrderDTO() {}

    public OrderDTO(int code, LocalDateTime date, int price, int amount, int clothesCode, int orderCode) {
        this.code = code;
        this.date = date;
        this.price = price;
        this.amount = amount;
        this.clothesCode = clothesCode;
        this.orderCode = orderCode;
    }

    public OrderDTO(int code, LocalDateTime date, int price){
        this.code = code;
        this.date = date;
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getClothesCode() {
        return clothesCode;
    }

    public void setClothesCode(int clothesCode) {
        this.clothesCode = clothesCode;
    }

    public int getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(int orderCode) {
        this.orderCode = orderCode;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "code=" + code +
                ", date=" + date +
                ", price=" + price +
                ", amount=" + amount +
                ", clothesCode=" + clothesCode +
                ", orderCode=" + orderCode +
                '}';
    }
}
