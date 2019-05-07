package ListSetMap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
class Emp implements Comparable<Emp>{
    int id;
    String name;
    public Emp(int id,String name){
        this.id = id;
        this.name = name;
    }


    public String toString() {
        return "[编号:"+this.id+" 名字:"+this.name+"]";
    }


    public int hashCode() {
        return this.id;
    }


    public boolean equals(Object obj) {
        Emp e = (Emp)obj;
        return this.id==e.id;
    }


    public int compareTo(Emp e) {
        return this.id - e.id;
    }
}
class MyComparator implements Comparator<Emp>{

    public int compare(Emp e1,Emp e2) {
        return e1.id-e2.id;
    }
}
public class list1 {
    public static void main(String[] args) {
        //MyComparator m = new MyComparator();
        Map<Emp,String> map = new TreeMap<>();
        map.put(new Emp(24,"科比"),"001");
        map.put(new Emp(2,"欧文"),"004");
        map.put(new Emp(23,"詹姆斯"),"002");
        map.put(new Emp(30,"库里"),"003");
        System.out.println(map);
    }
}
