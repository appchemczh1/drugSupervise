package org.jeecg.modules.demo.dzzz.util;



import java.util.Base64;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Base64Util {

   /* public static void main(String[] args) {
        Base64Util base64Util = new Base64Util();
        base64Util.base64Encoding();
    }*/

    public    String base64Encoding(){
        String base64ImageString="";
        try {
            String imagePath = "/opt/upFiles/ewm/test.png";

            // 读取图片文件到字节数组
            Path path = new File(imagePath).toPath();
            byte[] imageBytes = Files.readAllBytes(path);

            // 对字节数组进行Base64编码
             base64ImageString = Base64.getEncoder().encodeToString(imageBytes);

            return  base64ImageString;
            // 输出Base64编码后的字符串
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  base64ImageString;
    }
    public    byte[] base64get(){
        String base64ImageString="";
        byte[] imageBytes=null;
        try {
            String imagePath = "/opt/upFiles/ewm/test.png";

            // 读取图片文件到字节数组
            Path path = new File(imagePath).toPath();
             imageBytes = Files.readAllBytes(path);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return  imageBytes;
    }
}