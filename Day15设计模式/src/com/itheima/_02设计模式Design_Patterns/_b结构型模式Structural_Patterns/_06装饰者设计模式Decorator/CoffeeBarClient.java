package com.itheima._02设计模式Design_Patterns._b结构型模式Structural_Patterns._06装饰者设计模式Decorator;


/**
     1、咖啡种类/单品咖啡：Espresso(意大利浓咖啡)16元、ShortBlack、LongBlack(美式咖啡)15元、Decaf(无因咖啡)18元
     2、调料：Milk4元、Soy(豆浆)2元、Chocolate3元
     3、要求在扩展新的咖啡种类时，具有良好的扩展性、改动方便、维护方便
     4、使用 OO 的来计算不同种类咖啡的费用: 客户可以点单品咖啡，也可以单品咖啡+调料组合
 */
public class CoffeeBarClient {
    public static void main(String[] args) {
        // 装饰者模式下的订单：2份巧克力 + 一份牛奶的LongBlack

        // 1.点一份 LongBlack
        Drink order = new LongBlack();
        System.out.println("点了 "+ order.getDes() + " " + order.cost()+"元");

        // 2. order 再加一份牛奶
        order = new Milk(order);
        System.out.println("点了 "+ order.getDes() + " " + order.cost()+"元");

        // 3. order 再加入一份巧克力
        order = new Chocolate(order);
        System.out.println("点了 "+ order.getDes() + " " + order.cost()+"元");

        // 3. order 再加入一份巧克力
        order = new Chocolate(order);
        System.out.println("点了 "+ order.getDes() + " " + order.cost()+"元");

        System.out.println("===========================");

        // 从新点了一份无因咖啡
        Drink order2 = new DeCaf();
        System.out.println("点了 "+ order2.getDes() + " " + order2.cost()+"元");

        // 又点了一份牛奶
        order2 = new Milk(order2);
        System.out.println("点了 "+ order2.getDes() + " " + order2.cost()+"元");
    }
}
