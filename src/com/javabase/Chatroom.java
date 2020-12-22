package com.javabase;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

//非阻塞式I/O技术实现聊天室
public class Chatroom {
	public static void main(String[] args) throws IOException{
		//监听8888接口
		ServerSocket server = new ServerSocket(8888);
		//等待客户端连接，在此之前一直处于阻塞状态
		Socket socket = server.accept();
		//服务端读线程封装
		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		Thread readInfoThread = new InfoReader(dis);
		readInfoThread.setName("服务端读线程");
		//服务端写线程封装
		OutputStream os = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		Thread writeInfoThread = new InfoWriter(dos);
		writeInfoThread.setName("服务端写线程");
		//读和写线程启动
		readInfoThread.start();
		writeInfoThread.start();
		
	}
}

class client{
	public static void main(String[] args) throws UnknownHostException, IOException {
		//创建客户端，指定服务器和端口
		Socket socket = new Socket("127.0.0.1",8888);
		//客户端读线程
		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		Thread readInfoThread = new InfoReader(dis);
		readInfoThread.setName("客户端读线程");
		//客户端写线程
		OutputStream os = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		Thread writeInfoThread = new InfoWriter(dos);
		writeInfoThread.setName("客户端写线程");
		//线程启动
		readInfoThread.start();
		writeInfoThread.start();
	}
}

//用来读输入流的线程
class InfoReader extends Thread{
	private DataInputStream dis;

	public InfoReader(DataInputStream dis) {
		this.dis = dis;
	}
	
	public void run() {
		String info;
		while(true) {
			try {
				info = dis.readUTF();
				System.out.println(this.getName()+"收到消息："+info);
				if(info.equals("bye")) {
					System.out.println("对方下线，该程序退出");
					System.exit(0);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

//用来写输出流的线程
class InfoWriter extends Thread{
	private DataOutputStream dos;
	public InfoWriter(DataOutputStream dos) {
		this.dos = dos;
	}
	
	public void run() {
		String info;
		while(true) {
			try {
				InputStreamReader isr = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(isr);
				info = br.readLine();
				dos.writeUTF(info);
				if(info.equals("bye")) {
					System.out.println("自己下线，程序退出");
					System.exit(0);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
