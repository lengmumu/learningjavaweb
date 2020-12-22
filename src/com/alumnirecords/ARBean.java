package com.alumnirecords;

import java.util.ArrayList;
import java.util.Vector;

public class ARBean {
	private int id;
	private int userId;
	private int deleteFlag;
	private int invitedCode;
	private String image;
	private String name;
	private String sex;
	private String birthday;
	private String mobile;
	private String email;
	private String address;
	private String interests;
	private String yearningCity;
	private String imageToInviter;
	private String leaveMessage;
	public int length = 15;
	public Object[] getObjectsArray() {
//		Vector<Object> m1 = new Vector<Object>();
//		m1 = m;
		Object[] m = {id,userId,deleteFlag,invitedCode,image,name,sex,birthday,mobile,email,address,interests,yearningCity,imageToInviter,leaveMessage};
		this.length = m.length;
		return m;
	}
	public String[] getNamesArray() {
		String[] m = {
				"id","userId","deleteFlag","invitedCode",
				"image","name","sex","birthday","mobile",
				"email","address","interests","yearningCity","imageToInviter","leaveMessage"};
		return m;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public int getInvitedCode() {
		return invitedCode;
	}
	public void setInvitedCode(int invitedCode) {
		this.invitedCode = invitedCode;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getInterests() {
		return interests;
	}
	public void setInterests(String interests) {
		this.interests = interests;
	}
	public String getYearningCity() {
		return yearningCity;
	}
	public void setYearningCity(String yearningCity) {
		this.yearningCity = yearningCity;
	}
	public String getImageToInviter() {
		return imageToInviter;
	}
	public void setImageToInviter(String imageToInviter) {
		this.imageToInviter = imageToInviter;
	}
	public String getLeaveMessage() {
		return leaveMessage;
	}
	public void setLeaveMessage(String leaveMessage) {
		this.leaveMessage = leaveMessage;
	}
}
