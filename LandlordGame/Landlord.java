package LandlordGame;


import java.util.*;


public class Landlord {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap();
        List<Integer> list = new ArrayList();
        String[] id = {"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
        String[] color = {"♦","♥","♣","♠"};
        int val = 2;
        map.put(0,"大王");
        map.put(1,"小王");
        list.add(0);
        list.add(1);
        for(String i: id){
            for(String c: color){
                map.put(val,i+c);
                list.add(val);
                val++;
            }
        }
        //洗牌
        Collections.shuffle(list);
        //发牌
        List<Integer> list1 = new ArrayList();
        List<Integer> list2 = new ArrayList();
        List<Integer> list3 = new ArrayList();
        List<Integer> bottom = new ArrayList();

       for(int i=0; i<list.size(); i++){
           if(i>=51){
                bottom.add(list.get(i));
           }else if(i%3==0){
                list1.add(list.get(i));
            }else if(i%3==1){
                list2.add(list.get(i));
            }else if(i%3==2){
                list3.add(list.get(i));
            }

        }
        //对玩家手中牌进行排序
        Collections.sort(list1);
        Collections.sort(list2);
        Collections.sort(list3);

        //看牌
        System.out.print("农民1：");
        for(Integer i:list1){
            String values = map.get(i);
            System.out.print(values+"、");
        }
        System.out.println();
        System.out.print("农民2：");
        for(Integer i:list2){
            String values = map.get(i);
            System.out.print(values+"、");
        }
        System.out.println();
        System.out.print("地主：");
        for(Integer i:list3){
            String values = map.get(i);
            System.out.print(values+"、");
        }
        System.out.println();
        System.out.print("底牌：");
        for(Integer i:bottom){
            String values = map.get(i);
            System.out.print(values+"、");
        }


    }

}
