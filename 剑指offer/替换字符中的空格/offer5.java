package 剑指Offer;

import java.util.Arrays;

/*
替换字符串中的空格
 */
public class offer5 {
    public static void main(String[] args) {
        replaceSpace("we are family",50);
    }
    private static void replaceSpace(String str,int length){
        int trueLength = 0;
        int count = 0;
        char[] brr = str.toCharArray();
        char[] arr = new char[length];
        for(int i=0; i<brr.length; i++){
            arr[i]=brr[i];
        }
        int i = 0;
        while(arr[i]!='\0'){
            ++trueLength;
            if(arr[i]==' '){
                ++count;
            }
            ++i;
        }
        int newLength = trueLength+2*count;
        //char[] brr = new char[newLength];
        int indexLength = trueLength;
        int indexNewlength = newLength;
        while(indexLength>=0&&indexNewlength>indexLength){
            if(arr[indexLength]==' '){
                arr[indexNewlength--]='0';
                arr[indexNewlength--]='2';
                arr[indexNewlength--]='%';
            }else {
                arr[indexNewlength--] = arr[indexLength];
            }
            indexLength--;
        }
        String str1 = String.valueOf(arr,0,newLength);
        System.out.println(str1);
        for(int j=0; j<newLength; j++){
            System.out.print(arr[j]);
        }

    }
}
