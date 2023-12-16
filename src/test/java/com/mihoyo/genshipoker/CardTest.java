package com.mihoyo.genshipoker;

import java.lang.reflect.Array;
import java.util.*;

import com.mihoyo.genshinpoker.Card;

public class CardTest {
    public static void main(String[] args) {
        ///////////////////// 测试洗牌 ////////////////////
        System.out.println("--------------- 测试洗牌 ---------------");

        ////////////////////// 测试理牌 //////////////////////
        System.out.println("--------------- 测试理牌 ---------------");
        String sortCardResult = new CardTest().testSortCard();
        System.out.println(sortCardResult);
        ///////////////////// 测试牌型判断 ////////////////////
        System.out.println("--------------- 测试牌型判断 ---------------");
        // 理牌
        ArrayList<Integer> _cards = new ArrayList<>(Arrays.asList(141, 140));
        java.util.Collections.sort(_cards);
        ArrayList<ArrayList<Integer>> cards = new ArrayList<ArrayList<Integer>>();
        int index = 0;
        cards.add(new ArrayList<Integer>(Collections.singletonList(_cards.get(0))));
        // 从第二张牌开始，如果牌值不同，则新建一个牌值相同的牌组
        for (Integer card : _cards) {
            if (Objects.equals(card, _cards.get(0))) {
                continue;
            }
            if (card / 10 != cards.get(index).get(0) / 10) {
                index++;
                cards.add(new ArrayList<>(Collections.singletonList(card)));
            } else {
                cards.get(index).add(card);
            }
        }
        // 理牌：将相同的牌多的放在前面
        cards.sort((o1, o2) -> o2.size() - o1.size());
        // 输出理牌结果
        System.out.println(cards);
        String cardTypeResult = new CardTest().testCardType();
        System.out.println(cardTypeResult);
        ///////////////////// 测试牌比较 ////////////////////
        System.out.println("--------------- 测试牌比较 ---------------");
        String cardCompareResult = new CardTest().testCardCompare();
        System.out.println(cardCompareResult);

    }

    /**
     * 牌型判断测试
     * @return 测试信息
     * &#064;note   Integer Code = 10 * (牌值) + (花色) 花色：方块个位为2，梅花个位为3，红桃个位为4，黑桃个位为5；牌值：1-13 代表 A-K；个位为0为小王，个位为1为大王
     * &#064;note   0：不允许出牌，1：单张，2：对子，3：三张，4：三带一，5：三带二，6：四带二，7：顺子，8：连对，9：飞机，10：炸弹，11：王炸
     */
    private String testCardType() {
        // 1. 单张
        ArrayList<Integer> cards1 = new ArrayList<>(List.of(133));
        if (Card.getType(cards1) != 1) {
            return "单张判断错误";
        }
        // 2. 对子
        ArrayList<Integer> cards2 = new ArrayList<>(Arrays.asList(133, 134));
        if (Card.getType(cards2) != 2) {
            return "对子判断错误";
        }
        // 3. 三张
        ArrayList<Integer> cards3 = new ArrayList<>(Arrays.asList(133, 134, 135));
        if (Card.getType(cards3) != 3) {
            return "三张判断错误";
        }
        // 4. 炸弹
        ArrayList<Integer> cards4 = new ArrayList<>(Arrays.asList(132, 133, 134, 135));
        if (Card.getType(cards4) != 10) {
            return "炸弹判断错误";
        }
        // 5. 三带一
        ArrayList<Integer> cards5 = new ArrayList<>(Arrays.asList(132, 133, 134, 15));
        if (Card.getType(cards5) != 4) {
            return "三带一判断错误";
        }
        // 6. 三带二
        ArrayList<Integer> cards6 = new ArrayList<>(Arrays.asList(132, 133, 134, 13, 14));
        if (Card.getType(cards6) != 5) {
            return "三带二判断错误";
        }
        // 7. 四带二
        ArrayList<Integer> cards7 = new ArrayList<>(Arrays.asList(132, 133, 134, 135, 13, 14));
        if (Card.getType(cards7) != 6) {
            return "四带二判断错误";
        }
        // 8. 顺子
        ArrayList<Integer> cards8 = new ArrayList<>(Arrays.asList(33, 44, 55, 63, 72));
        if (Card.getType(cards8) != 7) {
            return "顺子判断错误";
        }
        // 9. 连对
        ArrayList<Integer> cards9 = new ArrayList<>(Arrays.asList(132, 132, 123, 124, 115, 112, 102, 103, 94, 95));
        if (Card.getType(cards9) != 8) {
            return "连对判断错误";
        }
        // 10. 飞机
        ArrayList<Integer> cards10 = new ArrayList<>(Arrays.asList(33, 34, 35, 43, 44, 45, 53, 63));
        if (Card.getType(cards10) != 9) {
            return "飞机判断错误";
        }
        // 11. 王炸
        ArrayList<Integer> cards11 = new ArrayList<>(Arrays.asList(140, 141));
        if (Card.getType(cards11) != 11) {
            return "王炸判断错误";
        }
        return "牌型判断测试通过";
    }
    private String testSortCard(){
        // 331理牌
        ArrayList<Integer> cards1 = new ArrayList<>(Arrays.asList(13, 23, 24, 25, 33, 34, 35));
        return "理牌后：" + Card.sortCards(cards1);
    }
    private String testCardCompare() {
        ArrayList<Integer> cards1 = new ArrayList<>();
        ArrayList<Integer> cards2 = new ArrayList<>();
        // 1. 单张
        cards1 = new ArrayList<>(List.of(133));
        cards2 = new ArrayList<>(List.of(134));
        if (Card.compare(cards1, cards2)) {
            return "单张1比较错误";
        }
        cards1 = new ArrayList<>(List.of(133));
        cards2 = new ArrayList<>(List.of(14));
        if (Card.compare(cards1, cards2)) {
            return "单张2比较错误";
        }
        cards1 = new ArrayList<>(List.of(13));
        cards2 = new ArrayList<>(List.of(24));
        if (Card.compare(cards1, cards2)) {
            return "单张3比较错误";
        }
        // 2. 对子
        cards1 = new ArrayList<>(Arrays.asList(133, 134));
        cards2 = new ArrayList<>(Arrays.asList(133, 135));
        if (Card.compare(cards1, cards2)) {
            return "对子1比较错误";
        }
        cards1 = new ArrayList<>(Arrays.asList(123, 124));
        cards2 = new ArrayList<>(Arrays.asList(133, 135));
        if (Card.compare(cards1, cards2)) {
            return "对子2比较错误";
        }
        cards1 = new ArrayList<>(Arrays.asList(123, 124));
        cards2 = new ArrayList<>(Arrays.asList(13, 15));
        if (Card.compare(cards1, cards2)) {
            return "对子3比较错误";
        }
        // 3. 三张
        cards1 = new ArrayList<>(Arrays.asList(123, 124, 125));
        cards2 = new ArrayList<>(Arrays.asList(133, 134, 136));
        if (Card.compare(cards1, cards2)) {
            return "三张1比较错误";
        }
        cards1 = new ArrayList<>(Arrays.asList(133, 134, 135));
        cards2 = new ArrayList<>(Arrays.asList(23, 24, 26));
        if (Card.compare(cards1, cards2)) {
            return "三张2比较错误";
        }
        // 4. 炸弹
        cards1 = new ArrayList<>(Arrays.asList(132, 133, 134, 135));
        cards2 = new ArrayList<>(Arrays.asList(12, 13, 14, 15));
        if (Card.compare(cards1, cards2)) {
            return "炸弹1比较错误";
        }
        cards1 = new ArrayList<>(Arrays.asList(92, 103, 114, 125, 133));
        cards2 = new ArrayList<>(Arrays.asList(12, 13, 14, 15));
        if (Card.compare(cards1, cards2)) {
            return "炸弹2比较错误";
        }
        cards1 = new ArrayList<>(Arrays.asList(22, 23, 24));
        cards2 = new ArrayList<>(Arrays.asList(12, 13, 14, 15));
        if (Card.compare(cards1, cards2)) {
            return "炸弹3比较错误";
        }
        // 5. 三带一
        cards1 = new ArrayList<>(Arrays.asList(122, 123, 124, 15));
        cards2 = new ArrayList<>(Arrays.asList(133, 134, 135, 15));
        if (Card.compare(cards1, cards2)) {
            return "三带一1比较错误";
        }
        cards1 = new ArrayList<>(Arrays.asList(102, 103, 104, 25));
        cards2 = new ArrayList<>(Arrays.asList(133, 134, 135, 15));
        if (Card.compare(cards1, cards2)) {
            return "三带一2比较错误";
        }
        // 6. 三带二
        cards1 = new ArrayList<>(Arrays.asList(122, 123, 124, 13, 14));
        cards2 = new ArrayList<>(Arrays.asList(133, 134, 135, 13, 14));
        if (Card.compare(cards1, cards2)) {
            return "三带二1比较错误";
        }
        cards1 = new ArrayList<>(Arrays.asList(122, 123, 124, 13, 14));
        cards2 = new ArrayList<>(Arrays.asList(13, 14, 15, 103, 104));
        if (Card.compare(cards1, cards2)) {
            return "三带二2比较错误";
        }
        // 7. 四带二
        cards1 = new ArrayList<>(Arrays.asList(122, 123, 124, 125, 13, 14));
        cards2 = new ArrayList<>(Arrays.asList(133, 134, 135, 136, 12, 15));
        if (Card.compare(cards1, cards2)) {
            return "四带二1比较错误";
        }
        // 8. 顺子
        cards1 = new ArrayList<>(Arrays.asList(33, 44, 55, 63, 72));
        cards2 = new ArrayList<>(Arrays.asList(44, 55, 66, 74, 83));
        if (Card.compare(cards1, cards2)) {
            return "顺子1比较错误";
        }
        // 9. 连对
        cards1 = new ArrayList<>(Arrays.asList(92, 92, 123, 124, 115, 112, 102, 103, 84, 85));
        cards2 = new ArrayList<>(Arrays.asList(133, 133, 124, 125, 116, 113, 103, 104, 95, 96));
        if (Card.compare(cards1, cards2)) {
            return "连对比较错误";
        }
        // 10. 飞机
        cards1 = new ArrayList<>(Arrays.asList(33, 34, 35, 43, 44, 45, 53, 63));
        cards2 = new ArrayList<>(Arrays.asList(44, 45, 46, 54, 55, 56, 14, 24));
        if (Card.compare(cards1, cards2)) {
            return "飞机比较错误";
        }
        // 11. 王炸
        cards1 = new ArrayList<>(Arrays.asList(33, 34, 35, 43, 44, 45, 53, 63));
        cards2 = new ArrayList<>(Arrays.asList(140, 141));
        if (Card.compare(cards1, cards2)) {
            return "王炸1比较错误";
        }
        cards1 = new ArrayList<>(List.of(133));
        cards2 = new ArrayList<>(Arrays.asList(140, 141));
        if (Card.compare(cards1, cards2)) {
            return "王炸2比较错误";
        }
        cards1 = new ArrayList<>(Arrays.asList(133, 134));
        cards2 = new ArrayList<>(Arrays.asList(140, 141));
        if (Card.compare(cards1, cards2)) {
            return "王炸3比较错误";
        }
        cards1 = new ArrayList<>(Arrays.asList(123, 124, 125));
        cards2 = new ArrayList<>(Arrays.asList(140, 141));
        if (Card.compare(cards1, cards2)) {
            return "王炸4比较错误";
        }
        cards1 = new ArrayList<>(Arrays.asList(12, 13, 14, 15));
        cards2 = new ArrayList<>(Arrays.asList(140, 141));
        if (Card.compare(cards1, cards2)) {
            return "王炸5比较错误";
        }
        cards1 = new ArrayList<>(Arrays.asList(122, 123, 124, 15));
        cards2 = new ArrayList<>(Arrays.asList(140, 141));
        if (Card.compare(cards1, cards2)) {
            return "王炸6比较错误";
        }
        cards1 = new ArrayList<>(Arrays.asList(122, 123, 124, 13, 14));
        cards2 = new ArrayList<>(Arrays.asList(140, 141));
        if (Card.compare(cards1, cards2)) {
            return "王炸7比较错误";
        }
        cards1 = new ArrayList<>(Arrays.asList(33, 44, 55, 63, 72));
        cards2 = new ArrayList<>(Arrays.asList(140, 141));
        if (Card.compare(cards1, cards2)) {
            return "王炸8比较错误";
        }
        cards1 = new ArrayList<>(Arrays.asList(92, 92, 123, 124, 115, 112, 102, 103, 84, 85));
        cards2 = new ArrayList<>(Arrays.asList(140, 141));
        if (Card.compare(cards1, cards2)) {
            return "王炸9比较错误";
        }
        cards1 = new ArrayList<>(Arrays.asList(33, 34, 35, 43, 44, 45, 53, 63));
        cards2 = new ArrayList<>(Arrays.asList(140, 141));
        if (Card.compare(cards1, cards2)) {
            return "王炸10比较错误";
        }
        return "牌比较测试通过";
    }
}
