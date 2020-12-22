package com.javabase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class FileOperate {
	public static void main(String[] args) {
		try {
			//读取控制台消息,乱码
//			InputStreamReader in = new InputStreamReader(System.in,"gbk");
			//读取文件
			InputStream in = new FileInputStream("D:\\cba.txt");
			File file = new File("D:\\abc.txt");
			if(!file.exists()) {
				file.createNewFile();
			}
			OutputStream out = new FileOutputStream(file,false);
			int len;
			while((len=in.read()) != -1) {
				//输出流写入文件
				out.write(len);
			}
			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			
		}
		
	}
}

class FileReaderOperater{
	public static void main(String[] args) {
		BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            //设置文件编码，解决文件乱码问题
            //将字节流转换为字符流，实际上使用了一种设计模式——适配器模式
            InputStreamReader isr = new InputStreamReader(new FileInputStream("E:\\test\\a.txt"), "UTF-8");
            bufferedReader = new BufferedReader(isr);
            bufferedWriter = new BufferedWriter(new FileWriter("E:\\test\\d.txt"));
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();//按行读取，写入一个分行符，否则所有内容都在一行显示
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
}
