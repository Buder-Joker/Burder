package NiuKeWang;
/*
输入:
a 78
b 98
c 54

输出:
b 98
a 78
c 54
 */
import java.util.*;

class Person{
    String name;
    int score;
    public Person(String name,int score){
        this.name = name;
        this.score = score;
    }
}
public class Demo23 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            int n = in.nextInt();
            int option = in.nextInt();
            List<Person> list = new ArrayList();
            for(int i=0; i<n; i++){
                list.add(new Person(in.next(),in.nextInt()));
            }
            //降序
            if (option == 0) {
                list.sort((o1, o2) -> o2.score - o1.score);
            //升序
            }else if(option==1){
                list.sort((o1, o2) -> o1.score - o2.score);
            }

            for(Person person:list){
                System.out.println(person.name+" "+person.score);
            }
        }
    }


}
