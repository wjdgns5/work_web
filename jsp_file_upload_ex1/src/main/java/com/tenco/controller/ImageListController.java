package com.tenco.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/imageList")
public class ImageListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ImageListController() {
        super();
    }
    
    // 주소 설계
    // http://localhost:8080/imageList
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 이미지 파일이 저장된 경로를 가져 온다.
		String ulpoadDir = "C:\\work_web\\jsp_file_upload_ex1\\src\\main\\webapp\\images";
		File dir = new File(ulpoadDir);
		
		// 디렉토리 내 파일 리스트를 가져 오는 방법
		File[] files = dir.listFiles();
		List<String> fileNames = new ArrayList<String>();
		
		if(fileNames != null) {
			for(File f : files) {
				fileNames.add(f.getName());
			}
		}
		System.out.println(" file length : " + fileNames.size());
		System.out.println(" file names : " + fileNames.toString());
		
		request.setAttribute("fileNames", fileNames);
		request.getRequestDispatcher("/WEB-INF/list.jsp").forward(request, response);
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
