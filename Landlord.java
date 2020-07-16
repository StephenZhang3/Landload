import java.util.*;

public class Landlord {
    public static void main(String[] args) {
        //牌种类数组
        String[] types = {"红桃♥️", "黑桃♠️", "方块♦️", "梅花♣️"};
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        
        //牌组合
        List<String> listPoke = new ArrayList<>();
        for (String number : numbers) {
            for (String type : types) {
                listPoke.add(type + number);
            }
        }

        //牌库
        Map<Integer, String> pokes = new HashMap<>();
        List<Integer> allNumber = new ArrayList<>();
        for (int i = 0; i < 52; i++) {
            pokes.put(i, listPoke.get(i));
            allNumber.add(i);
        }

        //添加大小王
        pokes.put(52, "小王🃏");
        pokes.put(53, "大王🃏");
        allNumber.add(52);
        allNumber.add(53);
        
        Collections.shuffle(allNumber); //洗牌，打乱原来顺序
        List<Integer> group1 = new ArrayList<>();   //第一组牌，17张
        List<Integer> group2 = new ArrayList<>();   //第二组牌，17张
        List<Integer> group3 = new ArrayList<>();   //第三组牌，17张
        List<Integer> group4 = new ArrayList<>();   //第四组牌，3张
        
        //发牌
        for (int i = 0; i < allNumber.size(); i++) {
            if (i < 17) {
                group1.add(allNumber.get(i));
            } else if (i < 34) {
                group2.add(allNumber.get(i));
            } else if (i < 51) {
                group3.add(allNumber.get(i));
            } else {
                group4.add(allNumber.get(i));
            }
        }

        //将每一组扑克牌按从小到大的顺序排列
        Collections.sort(group1);
        Collections.sort(group2);
        Collections.sort(group3);
        Collections.sort(group4);
        
        List<String> player1 = new ArrayList<>();   //玩家一手中的牌，17张
        List<String> player2 = new ArrayList<>();   //玩家二手中的牌，17张
        List<String> player3 = new ArrayList<>();   //玩家三手中的牌，17张
        List<String> others = new ArrayList<>();    //补牌，3张
        
        //将牌的数字代号替换为扑克牌表示
        for (Integer i : group1) {
            player1.add(pokes.get(i));
        }
        for (Integer i : group2) {
            player2.add(pokes.get(i));
        }
        for (Integer i : group3) {
            player3.add(pokes.get(i));
        }
        for (Integer i : group4) {
            others.add(pokes.get(i));
        }

        //显示发牌结果
        System.out.printf("发给玩家一的扑克牌：");
        System.out.println(player1);
        System.out.printf("发给玩家二的扑克牌：");
        System.out.println(player2);
        System.out.printf("发给玩家三的扑克牌：");
        System.out.println(player3);
        System.out.printf("留给地主的三张底牌：");
        System.out.println(others);
    }
}
