package com.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailOfJavaMail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties props = new Properties();
		Session session = Session.getInstance(props,null);
		props.put("mail.host", "127.0.0.1");
		props.put("mail.transport.protocol", "smtp");
		
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress("liuwei8809@163.com"));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress("zhangliguo_china@sina.com"));
			message.setText("邮件发送测试");
			Transport.send(message);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
