package com.javabase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeObject {

	public static void main(String[] args) {
		// 读序列化对象
		try {
			FileInputStream fis = new FileInputStream("MyObject.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			MyObject mo = (MyObject) ois.readObject();
			System.out.println(mo.getAge());
			ois.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
//对象类
class MyObject implements Serializable{
	private String name;
	private int age;
	private String sex;
	public MyObject(String name,String sex,int age) {
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}

//写序列化对象
class WriteObject{
	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("MyObject.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			MyObject mo = new MyObject("美林","女",22);
			oos.writeObject(mo);
			oos.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}