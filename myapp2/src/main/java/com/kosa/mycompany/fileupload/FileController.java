package com.kosa.mycompany.fileupload;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kosa.mycompany.common.FileUploadUtil;

// MultipartHttpServlet 동작 테스트용 Controller
@Controller
public class FileController {
	@RequestMapping(value="/fileupload")
	public String fileupload() {
		return "/fileupload/fileupload";
	}
	
	@RequestMapping(value="/fileupload/save")
	public String fileuploadsave(MultipartHttpServletRequest multi) {
		// file 업로드 기능을 처리하는 MultipartHttpServletRequest 객체
		// MultipartHttpServletRequest 객체의 getFile 메소드를 호출한다
		// 이 메소드가 업로드된 파일의 정보를 가지고 input type="file" 태그의 name 속성값을 가져온다
		
		MultipartFile file = multi.getFile("file1");
		String path="C:\\web_programming\\spring_workspace1\\myapp2\\src\\main\\webapp\\upload";
		/*
		File dir=new File(path);	// 이 경로가 존재하는지 확인해주는 메소드
		if(!dir.exists()) {	// 디렉토리 존재여부 예외처리 : 
			dir.mkdirs();	// 	디렉토리가 없으면 디렉토리를 생성해줌
		}

		try {
			// 이미 올려져 있는 임시 서버의 파일을 내가 지정한 경로로 옮겨줌
			// 스프링부트부터는 이 방식을 사용하지 않는다
			// path+"새로운 파일명" : 기존에 같은 파일명이 존재할 때, 파일을 덮어쓸지 아니면 새로 만들지
			file.transferTo(new File(path+"//a.jpg"));	// a라는 이름으로 서버에 파일을 저장함(계속 덮어쓰기됨)
		}catch(Exception e){
			e.printStackTrace();
		}
		
		*/
		List<MultipartFile> multiList = new ArrayList<MultipartFile>();
		multiList.add(multi.getFile("file1"));
		
		List<String> filenameList = new ArrayList<String>();
		filenameList.add("filename1");

		
		FileUploadUtil.setFilePath(path);
		FileUploadUtil.upload(multiList, filenameList);
		return "redirect:/";
	}

}
