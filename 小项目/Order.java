package 小项目;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*

 */
class Commodity{
    private String name;
    private double price;
    private int count;

    public Commodity(String name, double price, int count){
        this.count = count;
        this.name = name;
        this.price = price;
    }

    /*private Commodity(){};

    Commodity commodity = null;
    public Commodity getCommodity(Commodity commodity){
        if(commodity==null){
            commodity = new Commodity();
        }
        return commodity;
    }*/

    @Override
    public boolean equals(Object obj) {
        Commodity commodity = (Commodity) obj;
        return this.name.equals(commodity);
    }

    public String toString() {
        return "[名称:"+name+" 价格:"+price+" 数量:"+count+"]";
    }
}

class order{
    String name;
    String price;
    int count;

    public order(String name,String price,int count){
        this.count = count;
        this.name = name;
        this.price = price;
    }


    public String toString() {
        return "[名称:"+name+" 价格:"+price+" 数量:"+count+"]";
    }
}

public class Order {

    static List list = new LinkedList();
    //添加商品
    public static void addCommodity(){
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.println("请输入商品名称:");
            String name = in.next();
            System.out.println("请输入商品价格:");
            double price = in.nextInt();
            System.out.println("请输入商品数量:");
            int count = in.nextInt();
            list.add(new Commodity(name, price, count));
            System.out.println("是否继续添加 1:继续  2:退出");
            int option = in.nextInt();
            if(option==2){
                break;
            }
        }
        System.out.println(list);
    }

    //修改商品
    public static void changeCommodity(){
        System.out.println("修改商品。。。。");
    }
    //删除商品
    public static void deleteCommodity(){
        System.out.println("删除商品。。。。");
    }
    //查询商品
    public static void findCommodity(){
        Scanner in = new Scanner(System.in);
        System.out.println("请输入商品名称:");
        String name = in.next();
        if(list.equals(name)){
            System.out.println(list);
        }
    }
    //添加订单
    public static void addOrder(){
        System.out.println("添加订单。。。。");
    }
    //修改订单
    public static void changeOrder(){
        System.out.println("修改订单。。。。");
    }
    //删除订单
    public static void deleteOrder(){
        System.out.println("删除订单。。。。");
    }
    //查询订单
    public static void findOrder(){
        System.out.println("查询订单。。。。");
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List list = new LinkedList();
        List list1 = new LinkedList();
        while(true){
            System.out.println("A) 商品管理  B) 订单管理 C) 退出");
            String optoin1 = in.next();
            if ("a".equalsIgnoreCase(optoin1)) {
                System.out.println("1) 添加商品 2) 修改商品 3) 删除商品 4) 查询商品 5) 退出");
                int option2 = in.nextInt();
                switch (option2) {
                    case 1:
                        addCommodity();
                        break;
                    case 2:
                        changeCommodity();
                        break;
                    case 3:
                        deleteCommodity();
                        break;
                    case 4:
                        findCommodity();
                        break;
                    default:
                        System.exit(0);
                }
            } else if ("b".equalsIgnoreCase(optoin1)) {
                System.out.println("1) 添加商品 2) 修改订单 3) 删除订单 4) 查询订单 5) 退出");
                int option3 = in.nextInt();
                switch (option3) {
                    case 1:
                        addOrder();
                        break;
                    case 2:
                        changeOrder();
                        break;
                    case 3:
                        deleteOrder();
                        break;
                    case 4:
                        findOrder();
                        break;
                    default:
                        System.exit(0);
                }
            }else if("c".equalsIgnoreCase(optoin1)){
                System.exit(0);
            }
        }
    }
}
