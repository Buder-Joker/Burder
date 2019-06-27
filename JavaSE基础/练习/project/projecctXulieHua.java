package project;

import java.io.*;

/*
序列化和反序列化
 */
class person implements Serializable {
    String name;
    Integer age;
    public person(String name,Integer age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "[name:"+name+" age:"+age+"]";
    }
}

public class projecctXulieHua {
    public static void main(String[] args) throws Exception{
        //序列化
        /*
        person per = new person("唐伯虎",24);
        File file = new File("F:\\a.txt");
        OutputStream out = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(per);
        oos.close();
        */
        //反序列化
        File file = new File("F:\\a.txt");
        InputStream in = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(in);
        person per = (person) ois.readObject();
        System.out.println(per);
        ois.close();
    }
}
