package project;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 Map 接口的迭代方法
 */
public class project2 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("汪峰","章子怡");
        map.put("文章","马伊琍");
        map.put("吴奇隆","刘诗诗");
        map.put("刘恺威","杨幂");
        Set<String> set = map.keySet();
        Iterator it = set.iterator();
        while(it.hasNext()){
            String key = (String) it.next();
            System.out.println("键:"+key+"  值:"+map.get(key));
        }

        /*Set<Map.Entry<String,String>> entrys =  map.entrySet();
        Iterator<Map.Entry<String,String>> it =entrys.iterator();
        while(it.hasNext()){
            Map.Entry<String,String> entry = it.next();
            System.out.println("键:"+entry.getKey()+" 值:"+entry.getValue());
        }*/
    }
}
