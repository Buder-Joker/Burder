package Bit;
//文件拷贝

import java.io.*;

class CopyFile{
    private CopyFile(){
    }
    public static boolean creatParent(String path){
        File file = new File(path);
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        return false;
    }
    public static boolean CopyFile(String yuanPath,String mubiaoPath){
        File inFile = new File(yuanPath);
        File outFile = new File(mubiaoPath);
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(inFile);
            fileOutputStream = new FileOutputStream(outFile);
            copyFileHand(fileInputStream,fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
    private static void copyFileHand(InputStream inputStream,OutputStream outputStream)throws IOException{
        long star = System.currentTimeMillis();
        int temp = 0;
        do {
            temp = inputStream.read();
            outputStream.write(temp);
        }while (temp!=-1);
        long end = System.currentTimeMillis();
        System.out.println("拷贝花费的时间为："+(end-star));
    }
}
public class Demo5 {
    public static void main(String[] args) {
        if(args.length!=2){
            System.out.println("非法操作");
            return;
        }
        String yuanPath = args[0];
        String mubiaoPath = args[1];
        if(CopyFile.creatParent(yuanPath)){
            CopyFile.creatParent(yuanPath);
            System.out.println(CopyFile.CopyFile(yuanPath,mubiaoPath)? "文件拷贝成功":"文件拷贝失败");
        }else{
            System.out.println("源文件不存在，无法进行拷贝");
        }
    }
}
