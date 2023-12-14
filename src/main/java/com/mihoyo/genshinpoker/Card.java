package com.mihoyo.genshinpoker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/**
 * &#064;ClassName  Card
 * &#064;brief  牌类，表示一组牌，使用牌的代号储存
 * &#064;date  2023-12-15
 */
public class Card {

    public Card(java.util.ArrayList<Integer> _cards) {
        this.cards = _cards;
    }

    public String code2cardName(Integer _code) {
        int mark = _code % 10;
        if (mark == 0) {
            return "z0";
        } else if (mark == 1){
            return  "z1";
        } else if (mark == 2) {
            return "f" + (_code / 10);
        } else if (mark == 3) {
            return "m" + (_code / 10);
        } else if (mark == 4) {
            return "t" + (_code / 10);
        } else if (mark == 5) {
            return "h" + (_code / 10);
        } else {
            return "error";
        }
    }

    /**
     * &#064;brief  判断牌型
     * @param _cards 即将打出的牌
     * @return 返回描述牌型的字符串数组
     * @note  0：不允许出牌，1：单张，2：对子，3：三张，4：三带一，5：三带二，6：四带二，7：顺子，8：连对，9：飞机，10：炸弹，11：王炸
     */
    public int getType(java.util.ArrayList<Integer> _cards) {
        java.util.Collections.sort(_cards);
        // 理牌：相同牌值的牌放在前面
        ArrayList<ArrayList<Integer>> cards = new ArrayList<ArrayList<Integer>>();
        int index = 0;
        cards.add(new ArrayList<>(Collections.singletonList(_cards.get(0))));
        for (Integer card : _cards) {
            if (card / 10 != cards.get(index).get(0) / 10) {
                index++;
                cards.add(new ArrayList<>(Collections.singletonList(card)));
            } else {
                cards.get(index).add(card);
            }
        }

        // TODO:判断牌型
        // 判断牌型
        if (cards.size() == 1) {
            if (cards.get(0).size() == 1) {
                return 1;
            } else if (cards.get(0).size() == 2) {
                if (cards.get(0).get(0) == 0 && cards.get(0).get(1) == 1) {
                    return 11;
                } else {
                    return 2;
                }
            } else if (cards.get(0).size() == 3) {
                return 3;
            } else if (cards.get(0).size() == 4) {
                return 10;
            } else {
                return 0;
            }
        } else if (cards.size() == 2) {

        }


    }

    /**
     * 判断是否能出牌
     * @param _cards1 当前牌
     * @param _cards2 上一手牌
     * @return 能否出牌
     */
    public boolean compareType(java.util.ArrayList<Integer> _cards1, java.util.ArrayList<Integer> _cards2) {
        if (_cards1.size() == 0) {
            return false;
        } else if (this.getType(_cards1) == this.getType(_cards2)) {
            if (this.getType(_cards1) == 1) {
                return compareCode(_cards1.get(0), _cards2.get(0));
            } else if (this.getType(_cards1) == 2) {
                return compareCode(_cards1.get(0), _cards2.get(0));
            } else if (this.getType(_cards1) == 3) {
                return compareCode(_cards1.get(0), _cards2.get(0));
            } else if (this.getType(_cards1) == 4) {
                return compareCode(_cards1.get(0), _cards2.get(0));
            } else if (this.getType(_cards1) == 5) {
                return compareCode(_cards1.get(0), _cards2.get(0));
            } else if (this.getType(_cards1) == 6) {
                return compareCode(_cards1.get(0), _cards2.get(0));
            } else if (this.getType(_cards1) == 7) {
                return compareCode(_cards1.get(0), _cards2.get(0));
            } else if (this.getType(_cards1) == 8) {
                return compareCode(_cards1.get(0), _cards2.get(0));
            } else if (this.getType(_cards1) == 9) {
                return compareCode(_cards1.get(0), _cards2.get(0));
            } else if (this.getType(_cards1) == 10) {
                return compareCode(_cards1.get(0), _cards2.get(0));
            } else if (this.getType(_cards1) == 11) {
                return compareCode(_cards1.get(0), _cards2.get(0));
            } else {
                return false;
            }
        }
    }


    //////////////////////// 静态方法 ////////////////////////
    /**
     * &#064;brief  生成随机的牌，通过循环取值初始化牌组
     * @return 返回一组牌
     */
    public static java.util.ArrayList<Integer> licensing() {
        java.util.ArrayList<Integer> cards = new java.util.ArrayList<Integer>();
        for (int i = 0; i < 54; i++) {
            Integer code = ((i % 13) + 1) * 10 + i / 13;
            cards.add(code);
        }
        java.util.Collections.shuffle(cards);
        return cards;
    }

    /**
     * &#064;brief  比较两组牌的大小
     * @param _code1 牌1的代号
     * @param _code2 牌2的代号
     * @return 牌1是否大于牌2
     */
    public static boolean compareCode(Integer _code1, Integer _code2) {
        int count1 = _code1 / 10;
        int count2 = _code2 / 10;
        if (count1 > count2) {
            return true;
        } else {
            return false;
        }
    }

    private String[] cardName;    //牌名
    private java.util.ArrayList<Integer> cards;    // 牌代号：0-53，方块个位为2，梅花个位为3，红桃个位为4，黑桃个位为5，十位为牌值，0-12，0为2，1为3，11为K，12为A，0为小王，1为大王

}
