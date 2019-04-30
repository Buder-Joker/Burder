package 小项目;

import com.sun.prism.shader.FillPgram_RadialGradient_REPEAT_AlphaTest_Loader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Random;

public class SnakeGame {
    private static final int WIDTH = 30;
    private static final int HIGHT = 10;
    private static char[][] map = new char[HIGHT][WIDTH];
    //初始化地图
    public void initMap(){
        for(int rows=0; rows<map.length; rows++){
            for(int cols=0; cols<map[rows].length; cols++){
                if(cols==0||cols==(WIDTH-1)||rows==0||rows==(HIGHT-1)){
                    map[rows][cols]='*';
                }else{
                    map[rows][cols]=' ';
                }
            }
        }
    }
    //地图显示
    public void ShowMap() {
        for(int rows=0; rows<map.length; rows++){
            for(int cols=0; cols<map[rows].length; cols++){
                System.out.print(map[rows][cols]);
            }
            System.out.println();
        }
    }

    //使用节点保存蛇节点的所有信息
    static LinkedList<Point> snake = new LinkedList<Point>();

    //初始化蛇
    public static void initSnake(){
        int x = WIDTH/2;
        int y = HIGHT/2;
        snake.addFirst(new Point(x-1,y));
        snake.addFirst(new Point(x,y));
        snake.addFirst(new Point(x+1,y));
    }

    //显示蛇
    public static void showSnake(){
        Point head = snake.getFirst();
        map[head.y][head.x]='$';
        for(int i=1 ; i<snake.size(); i++){
            Point body = snake.get(i);
            map[body.y][body.x] = '#';
        }
    }

    //食物
    Point food;
    //生成食物
    public void createFood(){
        Random random = new Random();
        while (true) {
            int x = random.nextInt(WIDTH);
            int y = random.nextInt(HIGHT);
            if (map[y][x] != '*') {
                food = new Point(x, y);
                break;
            }
        }
    }
    //显示食物
    public void showFood(){
        map[food.y][food.x] = '@';
    }
    //使用四个常量表示四个方向
    private static final int Up_Direction= 1;//上
    private static final int Down_Direction= -1;//下
    private static final int Left_Direction= 2;//左
    private static final int Right_Direction= -2;//右

    //默认当前方向是向右的
    int currentDirection = -2;
    //蛇移动的方法
    public void move(){
        Point head = snake.getFirst();
        //蛇是根据当前方法移动的
        switch (currentDirection){
            //添加新的蛇头
            case Up_Direction:
                snake.addFirst(new Point(head.x,head.y-1));
                break;
            //添加新的蛇头
            case Down_Direction:
                snake.addFirst(new Point(head.x,head.y+1));
                break;
            //添加新的蛇头
            case Left_Direction:
                snake.addFirst(new Point(head.x-1,head.y));
                break;
            //添加新的蛇头
            case Right_Direction:
                snake.addFirst(new Point(head.x+1,head.y));
                break;
             default:
                 break;
        }
        if(eatFood()){
            createFood();
        }else {
            //删除蛇尾
            snake.removeLast();
        }
    }
    //改变当前方向的方法
    public void changeDirection(int newCurrDirection){
        if(currentDirection+newCurrDirection!=0){
            //判断新方向是否与当前方向是否是相反方向，才允许其改变
            this.currentDirection=newCurrDirection;
        }
    }
    //

    //吃食物
    public boolean eatFood(){
        Point head = snake.getFirst();
        if(food.equals(head)){
            return true;
        }
        return false;
    }

    /*//向上走
    public void moveUp(){
        //取得蛇头
        Point head = snake.getFirst();
        //
        snake.addFirst(new Point(head.x,head.y-1));
        //删除蛇尾
        snake.removeLast();
    }*/


    //游戏结束方式
    public void gameOver(){
        Point head = snake.getFirst();
        /*if(head.x==0||head.x==WIDTH-1||head.y==0||head.y==HIGHT-1){
            System.out.println("游戏结束！");
            System.exit(0);
        }*/

        //当碰到墙或者自己的身体游戏结束
        if(map[head.y][head.x]=='*'||map[head.y][head.x]=='#'){
            System.out.println("游戏结束");
            System.exit(0);
        }
    }

    //刷新
    public void refrash(){
        //清空游戏以前的状态信息
        initMap();
        //把蛇的最新信息反馈到地图上
        showSnake();
        //把食物的信息反馈到地图
        showFood();
        //显示当前地图的信息
        ShowMap();
    }

    //工具类
    public static void initFrame(JFrame frame,int width , int height){
        Toolkit toolkit = Toolkit.getDefaultToolkit(); //获取一个与系统相关工具类对象
        //获取屏幕的分辨率
        Dimension d = toolkit.getScreenSize();

        int x = (int) d.getWidth();
        int y = (int) d.getHeight();

        frame.setBounds((x-width)/2, (y-height)/2, width, height);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) throws InterruptedException {
        SnakeGame snakeGame = new SnakeGame();
        //初始化地图
        snakeGame.initMap();
        //初始化蛇
        snakeGame.initSnake();
        //把蛇的信息反馈在地图上
        snakeGame.showSnake();
        //生成食物
        snakeGame.createFood();
        //显示食物
        snakeGame.showFood();
        //显示地图
        snakeGame.ShowMap();

        /*//向右三步
        for(int i=0; i<3; i++) {
            snakeGame.changeDirection(Right_Direction);
            snakeGame.move();
            snakeGame.refrash();
            Thread.sleep(500);
        }*/
        JFrame jFrame = new JFrame("方向盘");
        jFrame.add(new JButton("↑"),BorderLayout.NORTH);
        jFrame.add(new JButton("↓"),BorderLayout.SOUTH);
        jFrame.add(new JButton("←"),BorderLayout.WEST);
        jFrame.add(new JButton("→"),BorderLayout.EAST);
        JButton jButton = new JButton("点击控制方向");
        jFrame.add(jButton);
        initFrame(jFrame,300,300);
        //给按钮添加事件监听器
        jButton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();
                switch (code){
                    case KeyEvent.VK_UP:
                        snakeGame.changeDirection(Up_Direction);
                        break;
                    case KeyEvent.VK_DOWN:
                        snakeGame.changeDirection(Down_Direction);
                        break;
                    case KeyEvent.VK_LEFT:
                        snakeGame.changeDirection(Left_Direction);
                        break;
                    case KeyEvent.VK_RIGHT:
                        snakeGame.changeDirection(Right_Direction);
                        break;
                     default:
                         break;
                }
                snakeGame.move();
                snakeGame.gameOver();
                snakeGame.refrash();
            }
        });
    }
}
