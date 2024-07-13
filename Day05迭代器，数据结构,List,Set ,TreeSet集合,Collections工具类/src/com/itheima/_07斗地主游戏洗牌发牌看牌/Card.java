package com.itheima._07斗地主游戏洗牌发牌看牌;
// 牌类
public class Card {
    private String number;
    private String color;
    private Integer index;

    public Card() {
    }

    public Card(String number, String color,Integer index) {
        this.number = number;
        this.color = color;
        this.index = index;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return number+color;
    }
}
