package com.mail;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

/**
 * Servlet implementation class SendAttachmentMail
 */
@WebServlet("/mail/SendAttachmentMail")
public class SendAttachmentMail extends HttpServlet {
	
	private ServletContext sc ;
	private String savePath;
	private Map<String,String> parameters = new HashMap<String,String>();
	
	public void init(ServletConfig config) {
		sc = config.getServletContext();
		savePath="upload";
	}
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			File file = this.doAttachment(request);
			MultiPartEmail email = new MultiPartEmail();
			email.setHostName("smtp.qq.com");
			email.setAuthentication("1379822587@qq.com", "lpjybzlzanzqfebc");
			email.setCharset("UTF-8");
			try {

				email.addTo(parameters.get("to"));
				email.setFrom(parameters.get("from"));
				email.setSubject(parameters.get("subject"));
				email.setMsg(parameters.get("content"));
				
				if(file!=null) {
					EmailAttachment attachment = new EmailAttachment();
					attachment.setPath(file.getPath());
					attachment.setDisposition(EmailAttachment.ATTACHMENT);
					attachment.setName(file.getName());
					email.attach(attachment);
				}
				
				email.send();
				System.out.println("邮件发送成功");
			} catch (EmailException e) {
				System.out.println("邮件发送失败");
				e.printStackTrace();
			}
		}
		
		public File doAttachment(HttpServletRequest request) throws ServletException, IOException {
			File file = null;
			String savePath = "fileupload";
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				List items = upload.parseRequest(request);
				Iterator it = items.iterator();
				while(it.hasNext()) {
					FileItem item = (FileItem) it.next();
					if(item.isFormField()) {
						parameters.put(item.getFieldName(),item.getString("UTF-8"));
					}else {
						if(item.getName() != null && !item.getName().equals("")) {
							File tempFile = new File(item.getName());
							file = new File(sc.getRealPath("/")+savePath,tempFile.getName());
							item.write(file);
							System.out.println("上传文件成功");
						}else {
							System.out.println("没有选择上传文件");
						}
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("上传文件失败");
			}
			return file;
		}
		

}
