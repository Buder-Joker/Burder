package 小项目;

import java.util.LinkedList;
import java.util.Random;

/*
实现扑克牌的洗牌功能
 */
class Poker{

    String color;
    String id;

    public Poker(String color,String id){
        this.id=id;
        this.color = color;
    }
    @Override
    public String toString() {
        return "["+color+id+"]";
    }
}

public class PokerGame {
    public static void main(String[] args) {
        LinkedList list = makePoker();
        shufflePoker(list);
        showPoker(list);
    }


    //洗牌de功能
    public static void shufflePoker(LinkedList list){
        //创建随机对象
        Random random = new Random();
        for(int i=0; i<50; i++){
            //随机产生俩个索引值
            int a = random.nextInt(list.size());
            int b = random.nextInt(list.size());
            //根据索引值取出俩张牌，然后交换俩张牌的顺序
            Poker poker1 = (Poker) list.get(a);
            Poker poker2 = (Poker) list.get(b);
            list.set(a,poker2);
            list.set(b,poker1);
        }
    }

    //显示扑克牌
    public static void showPoker(LinkedList list){
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i)+"、");
            if(i%10==9){
                System.out.println();
            }
        }
    }
    //生成扑克牌
    public static LinkedList makePoker(){
        LinkedList<Poker> list = new LinkedList<>();
        String[] id = {"A","1","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] color={"红桃","方块","黑桃","梅花"};
        for (int i=0; i<color.length; i++){
            for(int j=0; j<id.length; j++){
                list.add(new Poker(color[i],id[j]));
            }
        }
        return list;
    }
}
