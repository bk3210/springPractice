package com.kosa.myapp3.common;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

// 파일업로드 전담용 클래스
public class FileUploadUtil {
	static String filePath="";	// 물리적 경로(null값이 들어오면 안됨)
	// static 변수는 생성자로 값 초기화를 할 수가 없다(static이니까 당연)
	
	// 생성자의 접근제어자를 private로 만들면 객체를 생성할 수 없다
	private FileUploadUtil() {
		
	}
	
	// getter/setter
	public static String getFilePath() {
		return filePath;
	}

	public static void setFilePath(String filePath) {
		FileUploadUtil.filePath = filePath;
	}
	
	public static String getFilename(String oriFilename) {
		String newFilename = "";
		// 1. 파일명과 확장자를 분리한다
		// 오른쪽에서 .이 있는 위치값을 찾는다
		// 점이 여러개일 때, 오른쪽 끝에서부터 마지막인 위치 찾기
		int pos = oriFilename.lastIndexOf(".");
		String ext = "";	// 확장자 담을 변수
		String filename = "";
		if(pos!=-1) {
			filename = oriFilename.substring(0, pos);	// 파일명만 추출해서 입력
			ext = oriFilename.substring(pos+1);	// 확장자만 추출하기(pos만 쓰면 .이 들어감)
		}else {	//(pos==0은 확장자가 없다는 뜻)
			filename = oriFilename;	// linuxOS는 확장자를 구분하지 않기 때문에 확장자 없는 파일도 존재함
			ext="";
		}
		
		System.out.println("파일이름 : " + filename);
		System.out.println("확장자명 : " + ext);
		newFilename = filename + "." + ext;
		File newFile = new File(filePath+"/"+newFilename);
		int i=1;
		while(newFile.exists()) {	// 이 파일이 존재한다면 새로운 파일명을 부여해야 함(충돌 방지)
			// a(1).jsp, a(2).jsp.........
			newFilename = filename + "(" + i + ")" + "." + ext;
			i++;
			newFile = new File(filePath+"/"+newFilename);
		}
		System.out.println(newFilename);
		return newFilename;
	}
	
	// controller에서 MultipartFile 객체리스트를 전달하면 파일을 저장한 다음 파일의 이름목록을 전달
	// 파일명이 겹칠 때 발생하는 충돌을 방지
	// a.jpg, a(1).jpg, a(2).jpg... 이런 식으로 자동저장되도록
	// 혹은 202302021145001(저장시간)+5981879(랜덤난수).jpg 이런식으로 저장되도록
	public static void upload(List<MultipartFile> fileList, List<String> filenameList) {
		File file = new File(filePath);
		
		// 첨부파일이 없을 때
		if(!file.exists()) {
			file.mkdirs();
		}
		
		// 첨부파일이 있을 때
		if(fileList!=null && fileList.size()>0) {
			for(MultipartFile mfile : fileList) {
				// 1. 본래 파일명을 가져온다
				String oriFilename = mfile.getOriginalFilename();
				if(oriFilename==null || oriFilename.equals("")) {
					filenameList.add("");
					continue;	// 이 다음 코드를 건너뛰고 다시 for문으로 이동
					// 이 if문은 파일이 세 개 전부 다 첨부되지 않고 한두개만 첨부된 글을 업로드할 때,
					// filename2나 3이 null값으로 DB에 넘어가도록 처리하는 코드이다
				}
				// 파일명이 충돌나지 않도록 바꾸기
				String newFilename = getFilename(oriFilename);
				try {
					mfile.transferTo(new File(filePath+"/"+newFilename));
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				filenameList.add(newFilename);
			}
		}
	}

}
