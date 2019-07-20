package NiuKeWang;
/*
删除公共字符
 */
import java.util.HashMap;
import java.util.Scanner;

public class Demo28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        //contain(str1,str2);
        //System.out.println(str1);
        char[] arr = new char[str1.length()];
        int index = 0;
        for(int i=0; i<str1.length(); i++){
            if(!str2.contains(str1.charAt(i)+"")){
                arr[index] = str1.charAt(i);
                index++;
            }
        }
        System.out.println(String.valueOf(arr).trim());
    }

    private static void contain(String str1, String str2) {
        char[] arr = str1.toCharArray();
        char[] brr = str2.toCharArray();
        char[] crr = new char[arr.length];
        HashMap hashMap = new HashMap();
        for(int i=0; i<brr.length; i++){
            hashMap.put(brr[i],null);
        }
        int index = 0;
        for(int i=0; i<arr.length; i++){
            hashMap.put(arr[i],null);

        }
        //String str = String.valueOf(crr);
        System.out.println(index);

    }
}
