package com.mihoyo.genshinpoker;

import java.net.URL;
import java.util.*;


/**
 * &#064;ClassName  Card
 * &#064;brief  牌类，表示一组牌，使用牌的代号储存
 * &#064;date  2023-12-15
 */
public class Card {

    public Card() {
        this.cards = new ArrayList<>();
    }
    public Card(java.util.ArrayList<Integer> _cards) {
        this.cards = _cards;
    }



    //////////////////////// 静态方法 ////////////////////////
    /**
     * 判断是否能出牌
     * @param _cards1 当前牌
     * @param _cards2 上一手牌
     * @return 能否出牌
     */
    public static boolean compare(java.util.ArrayList<Integer> _cards1, java.util.ArrayList<Integer> _cards2) {
        int type1 = getType(_cards1);
        int type2 = getType(_cards2);
        if (type2 == 11) {
            return false;
        } else if (type1 == 11) {
            return true;
        } else if (type1 != type2 && type1 == 10) {
            return true;
        } else if (type1 != type2 && type2 == 10) {
            return false;
        } else if (type1 == type2 && type1 == 10) {
            return compareCode(_cards1.get(0), _cards2.get(0));
        } else if (type1 == 1) {
            // 单张
            return compareCode(_cards1.get(0), _cards2.get(0));
        } else if (type1 == 2) {
            // 对子
            return compareCode(_cards1.get(0), _cards2.get(0));
        } else if (type1 == 3) {
            // 三张
            return compareCode(_cards1.get(0), _cards2.get(0));
        } else if (type1 == 4) {
            // 三带一
            ArrayList<ArrayList<Integer>> cards1 = manageCards(_cards1);
            ArrayList<ArrayList<Integer>> cards2 = manageCards(_cards1);
            return compareCode(cards1.get(0).get(0), cards2.get(0).get(0));
        } else if (type1 == 5) {
            // 三带二
            ArrayList<ArrayList<Integer>> cards1 = manageCards(_cards1);
            ArrayList<ArrayList<Integer>> cards2 = manageCards(_cards1);
            return compareCode(cards1.get(0).get(0), cards2.get(0).get(0));
        } else if (type1 == 6) {
            // 四带二
            ArrayList<ArrayList<Integer>> cards1 = manageCards(_cards1);
            ArrayList<ArrayList<Integer>> cards2 = manageCards(_cards1);
            return compareCode(cards1.get(0).get(0), cards2.get(0).get(0));
        } else if (type1 == 7) {
            // 顺子
            return compareCode(_cards1.get(0), _cards2.get(0));
        } else if (type1 == 8) {
            // 连对
            return compareCode(_cards1.get(0), _cards2.get(0));
        } else if (type1 == 9) {
            // 飞机
            return compareCode(_cards1.get(0), _cards2.get(0));
        } else {
            return false;
        }
    }

    /**
     * &#064;brief   理牌——用于比较与判断牌型
     * @return 二维数组，子数组中的牌值相同，按照牌的数量进行排序
     */
    private static ArrayList<ArrayList<Integer>> manageCards (ArrayList<Integer> _cards) {
        java.util.Collections.sort(_cards);
        // 理牌：相同牌值的牌放在前面
        ArrayList<ArrayList<Integer>> cards = new ArrayList<>();
        int index = 0;
        cards.add(new ArrayList<>(Collections.singletonList(_cards.get(0))));
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
        return cards;
    }

    /**
     * &#064;brief   理牌——可以用与渲染牌的时候（发牌、出牌）
     * @param _cards 待理的牌
     */
    public static ArrayList<Integer> sortCards (ArrayList<Integer> _cards) {
        _cards.sort((o1, o2) -> (compareCode(o1, o2) ? -1 : ((o1 / 10) == (o2 / 10) ? 0 : 1)));// 我简直就是个天才
        return _cards;
    }

    /**
     * &#064;brief  判断牌型
     * @param _cards 即将打出的牌
     * @return 返回描述牌型的字符串数组
     * &#064;note   0：不允许出牌，1：单张，2：对子，3：三张，4：三带一，5：三带二，6：四带二，7：顺子，8：连对，9：飞机，10：炸弹，11：王炸
     */
    public static int getType(java.util.ArrayList<Integer> _cards) {
        // 理牌
        ArrayList<ArrayList<Integer>> cards = manageCards(_cards);

        // TODO: 测试牌型
        // 判断牌型
        if (cards.size() == 1) {
            if (cards.get(0).size() == 1) {
                // 单张
                return 1;
            } else if (cards.get(0).size() == 2) {
                if (cards.get(0).get(0) == 140 && cards.get(0).get(1) == 141) {
                    // 王炸
                    return 11;
                } else {
                    // 对子
                    return 2;
                }
            } else if (cards.get(0).size() == 3) {
                // 三张
                return 3;
            } else if (cards.get(0).size() == 4) {
                // 炸弹
                return 10;
            } else {
                return 0;
            }
        } else if (cards.size() == 2) {
            if (cards.get(0).size() == 3 && cards.get(1).size() == 1) {
                // 三带一
                return 4;
            } else if (cards.get(0).size() == 3 && cards.get(1).size() == 2) {
                // 三带二
                return 5;
            } else if (cards.get(0).size() == 4 && cards.get(1).size() == 2) {
                // 四带二
                return 6;
            } else {
                return 0;
            }
        } else if (cards.size() >= 3) {
            // Lambda表达式：判断子数组中的牌数是否相同，如果所有组的牌数都相同，则返回true
            boolean numEqual = cards.stream().allMatch(o -> o.size() == cards.get(0).size());
            if (numEqual) {
                // 判断子数组中的牌值是否连续，如果所有组的牌值都连续，则返回true
                boolean codeEqual = true;
                for (int i = 0; i < cards.size() - 1; i++) {
                    if (cards.get(i).get(0) / 10 + 1 != cards.get(i + 1).get(0) / 10) {
                        codeEqual = false;
                        break;
                    }
                }
                if (codeEqual && cards.get(0).size() == 2) {
                    // 连对
                    return 8;
                } else if (codeEqual && cards.get(0).size() == 1) {
                    // 顺子
                    return 7;
                } else {
                    return 0;
                }
            } else {
                // 判断是否为飞机
                // TODO: 飞机判断解释不一，按照连续两个或者两个个以上数字相同的三张牌组成的牌型（如333444）为准
                for (int i = 0; i < cards.size() - 1; i++) {
                    if (cards.get(i).size() != 3 || cards.get(i + 1).size() != 3) {
                        return 9;
                    }
                }
                return 0;
            }
        } else {
            return 0;
        }
    }

    /**
     * &#064;brief  洗牌
     * @return 返回一组牌
     */
    public static java.util.ArrayList<ArrayList<Integer>> licensing(int playerNum) {
        java.util.ArrayList<Integer> cards;
        cards = new ArrayList<>(allCardsHash.keySet());
        java.util.Collections.shuffle(cards);

        ArrayList<ArrayList<Integer>> players = new ArrayList<>();
        for (int i = 1; i <= playerNum; i++) {
            players.add(new ArrayList<>(cards.subList((i - 1) * 17, i * 17)));
        }
        return players;
    }

    /**
     * &#064;brief  比较两组牌的大小
     * @param _code1 牌1的代号
     * @param _code2 牌2的代号
     * @return 牌1是否大于牌2
     */
    public static boolean compareCode(Integer _code1, Integer _code2) {
        int cardNum1 = allCardsHash.get(_code1) % 13;
        int cardNum2 = allCardsHash.get(_code2) % 13;
        cardNum1 = _code1 / 10 == 14 ? 20 : cardNum1;
        cardNum2 = _code2 / 10 == 14 ? 20 : cardNum2;
        return cardNum1 > cardNum2;
    }


    //////////////// 成员变量 ////////////////
    private static final HashMap<Integer, Integer> allCardsHash = new HashMap<>() {{
        put(32, 0);
        put(42, 1);
        put(52, 2);
        put(62, 3);
        put(72, 4);
        put(82, 5);
        put(92, 6);
        put(102, 7);
        put(112, 8);
        put(122, 9);
        put(132, 10);
        put(12, 11);
        put(22, 12);
        put(33, 13);
        put(43, 14);
        put(53, 15);
        put(63, 16);
        put(73, 17);
        put(83, 18);
        put(93, 19);
        put(103, 20);
        put(113, 21);
        put(123, 22);
        put(133, 23);
        put(13, 24);
        put(23, 25);
        put(34, 26);
        put(44, 27);
        put(54, 28);
        put(64, 29);
        put(74, 30);
        put(84, 31);
        put(94, 32);
        put(104, 33);
        put(114, 34);
        put(124, 35);
        put(134, 36);
        put(14, 37);
        put(24, 38);
        put(35, 39);
        put(45, 40);
        put(55, 41);
        put(65, 42);
        put(75, 43);
        put(85, 44);
        put(95, 45);
        put(105, 46);
        put(115, 47);
        put(125, 48);
        put(135, 49);
        put(15, 50);
        put(25, 51);
        put(140, 52);
        put(141, 53);
    }}; // 所有牌，通过哈希表可以比较大小

    private static final char[] name = {'z', 'z', 'f', 'm', 't', 'h'}; // 花色
    private final java.util.ArrayList<Integer> cards;
    // Integer Code = 10 * (牌值) + (花色) 花色：方块个位为2，梅花个位为3，红桃个位为4，黑桃个位为5；牌值：1-13 代表 A-K, 14表示王；个位为0为小王，个位为1为大王,


    //////////////////////// set-get method ////////////////////////
    /**
     * &#064;brief  获取牌名 （用于链接资源文件）
     * @param _code 牌的代号
     * @return 牌名
     * &#064;note  梅花：m，方块：f，红桃：t，黑桃：h，小王：z0，大王：z1
     */
    public static String getCardName(Integer _code) {
        return name[_code % 10] + String.valueOf((_code / 10) == 14 ? _code % 10 : _code / 10);
    }
    public static URL getCardPicUrl(Integer _code) {
        return GamePage.class.getResource("/com/mihoyo/genshinpoker/images/pokerCard/" + getCardName(_code) + ".jpg");
    }
    public void setCard(ArrayList<Integer> _cards) {
        this.cards.clear();
        this.cards.addAll(_cards);
    }
    public void deleteCard(Integer _card) {
        this.cards.remove(_card);
    }
    public int getCardNum() {
        return this.cards.size();
    }
    public java.util.ArrayList<Integer> getCards() {
        return cards;
    }
}
