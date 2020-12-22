package com.fileupload;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.mysql.MysqlUtil;

@WebServlet(urlPatterns="/fileupload/FileUpload",initParams= {@WebInitParam(name="savePath",value="fileupload")})
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext sc;
	private String savePath;
	public void init(ServletConfig config) {
		sc = config.getServletContext();
		savePath = config.getInitParameter("savePath");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory); 
		try {
			List items = upload.parseRequest(request);
			Iterator it = items.iterator();
			while(it.hasNext()) {
				FileItem item = (FileItem) it.next();
				if(item.isFormField()) {
					System.out.println(item.getFieldName()+item.getString("UTF-8"));
				}else {
					if(item.getName() !=null && !item.getName().equals("")) {
						System.out.println("上传文件的大小："+item.getSize());
						System.out.println("上传文件的类型："+item.getContentType());
						System.out.println("上传文件的名称："+item.getName());
					
					File tempFile = new File(item.getName());
					File file = new File(sc.getRealPath("/")+savePath,tempFile.getName());
					item.write(file);
					request.setAttribute("upload.message", "上传文件成功");
					}else {
						request.setAttribute("upload.message", "没有选择上传文件");
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("upload.message", "上传文件失败");
		}
		request.getRequestDispatcher("/fileupload/uploadResult.jsp").forward(request,response);
	}
	
	
}
