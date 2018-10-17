package com.pxl.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class ReadFromFileUtil {
	public static String txt2String(File file) throws UnsupportedEncodingException{
		byte[] b = null;
		try {  
            //包装流  
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));  
            //读取文件内容  
            b = new byte[bis.available()];  
            bis.read(b);  
            bis.close();//关闭流(关闭bis就可以了)  
        } catch (FileNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }
		//String(byte[])把字节数组转成字符串  
		return (new String(b,"GBK"));
 }
 
 public static void main(String[] args) throws UnsupportedEncodingException{
     File file = new File("C:\\Users\\Administrator\\Desktop\\新建文本文档.txt");
     System.out.println(txt2String(file));
 }
}
