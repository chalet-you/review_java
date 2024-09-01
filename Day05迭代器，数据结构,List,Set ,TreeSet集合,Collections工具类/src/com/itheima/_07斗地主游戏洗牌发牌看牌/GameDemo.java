package com.itheima._07斗地主游戏洗牌发牌看牌;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
    目标：斗地主游戏的案例开发。

    业务需求分析:
        斗地主的做牌，洗牌，发牌,排序（拓展知识）, 看牌
        业务:总共有54张牌。
        点数: "3","4","5","6","7","8","9","10","J","Q","K","A","2"
        花色: "♠", "♥", "♣", "♦"
        大小王: "👲" , ""
        点数分别要组合4种花色，大小王各一张。
        斗地主：发出51张牌，剩下3张作为底牌。

    功能：
        1.做牌。
        2.洗牌
        3.定义3个玩家。
        4.发牌。
        5.排序（拓展，了解）
        6.看牌。

    用面向对象设计案例：
        a.定义一个牌类，代表牌对象。 一个牌对象代表一张牌。
        b.定义一个集合存储54张牌，集合只需要一个(因为牌只需要一副)
 */
public class GameDemo {
    /**
     * a.定义一个静态集合，存储54张牌对象，集合只需要一个
     */
    public static final List<Card> ALL_CARDS = new ArrayList<>();

    /** b.做牌 */
    static {
        // 1.定义一个数组存储牌的点数，类型确定，个数确定请用数组存储！
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        // 2.定义一个数组存储牌的花色，类型确定，个数确定请用数组存储！
        String[] colors = {"♠", "♥", "♣", "♦"};
        Integer index = 0;
        // 3.先遍历点数与四种花色组装成牌对象存入到集合中去
        for (String number : numbers) {
            // 遍历花色
            for (String color : colors) {
                // 创建一张牌对象封装点数和花色
                Card card = new Card(number, color, index++);
                ALL_CARDS.add(card);
            }
        }
        // 4.单独加入大小王
        Collections.addAll(ALL_CARDS, new Card("", "🃏", index++), new Card("", "👲", index++));
        System.out.println("输出新牌：" + ALL_CARDS);
    }

    public static void main(String[] args) {
        /**
            c. 洗牌
         */
        Collections.shuffle(ALL_CARDS);
        System.out.println("洗牌后：" + ALL_CARDS);

        /**
         d. 定义三个玩家
         */
        List<Card> lingHuChong = new ArrayList<>();
        List<Card> jiuMoZhi = new ArrayList<>();
        List<Card> dongFangBuBai = new ArrayList<>();

        /**
         e. 发牌：依次发出51张牌出去。
         */
        for (int i = 0; i < ALL_CARDS.size()-3; i++) {
            Card card = ALL_CARDS.get(i);
            if (i % 3 ==0) {
                lingHuChong.add(card);
            }else if (i % 3==1){
                jiuMoZhi.add(card);
            }else if (i % 3 ==2){
                dongFangBuBai.add(card);
            }
        }

        /**
         f. 对牌进行排序。
         */

        sortCard(lingHuChong);
        sortCard(jiuMoZhi);
        sortCard(dongFangBuBai);


        /**
         g. 看牌。
         */
        System.out.println("令狐冲"+lingHuChong);
        System.out.println("鸠摩智"+jiuMoZhi);
        System.out.println("东方不败"+dongFangBuBai);

        System.out.println("底牌："+ ALL_CARDS.subList(ALL_CARDS.size()-3,ALL_CARDS.size()));
    }

    private static void sortCard(List<Card> cards) {
        Collections.sort(cards, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o2.getIndex()-o1.getIndex();
            }
        });
    }
}