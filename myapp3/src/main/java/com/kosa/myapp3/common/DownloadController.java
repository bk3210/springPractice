package com.kosa.myapp3.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DownloadController {
	@RequestMapping(value="/download")
	public void download(HttpServletRequest req, HttpServletResponse res, String path, String filename) {
		// path : 모든 파일을 한 폴더에 업로드하면 관리하기 어려우므로 
		// 		  /upload/board, /upload/gallery, /upload/qna 이런 식으로 경로가 나눠지게
		// filename : 다운로드할 파일명
		// servlet 3.0 이상부터 가상폴더의 실제 물리적 구조를 알려주는 메소드가 도입됨
		
		/*
		 * ServletContext ctx = req.getServletContext(); String wholepath =
		 * ctx.getRealPath("/upload/"+path);
		   http://127.0.0.1:9000/myapp3/download?path=board&filename=test.txt 로 쓰고 콘솔에 뭐라고 찍히는지 테스트해보자
		 */
		String wholepath=CommonConst.UPLOADPATH+"/"+path;
		System.out.println(wholepath+"*******");
		System.out.println(filename+"*******");
		
		// 서버에 있는 파일을 읽어서 클라이언트로 전송해야 한다
		InputStream in = null;	// 서버 빨대. 파일을 읽는 곳
		OutputStream out = null;	// 클라이언트 빨대. 여기로 전송됨
		File file = null;
		boolean skip = false;	// 보내려는 파일이 서버에 존재해야 전송할 수 있으므로 파일유무 확인(true여야 전송 가능)
		
		// 파일 종류 : 1. 이진파일(이미지, 동영상, exe, class 파일 등등) - 그림판, 동영상 플레이어 등 읽는데 특정 툴이 필요한 파일
		//			   2. 텍스트파일(txt, 소스파일들) - 특별한 프로그램 없이 읽을 수 있는 파일, 컴퓨터 내부 메모리를 가공해서 저장
		//					이진파일은 컴퓨터 내부 메모리 그대로 파일을 저장한다
		//					이진파일을 텍스트파일로 취급하면 복구할 수 없으므로 저장시 이진형태로 보내야 함
		try {
			file = new File(wholepath, filename);	// 파일을 찾아내서
			in = new FileInputStream(file);	// 읽을 준비 시작
		}catch(Exception e){	// 파일이 없거나 그밖의 오류로 전송할 수 없다면
			e.printStackTrace();
			skip = true;
		}
		if(skip== true) {
			return;
		}
		
		// 한글 처리
		// 브라우저마다 처리방식이 다르다
		try {
			String client = req.getHeader("User-Agent");
			if(client.indexOf("MSIE")!=-1) {
				// 익스플로러 방식
				filename = new String(filename.getBytes("KSC5601"), "ISO8859_1");
			}else {
			// 크롬 방식(공백처리도 같이된다)
			filename = new String(filename.getBytes("KSC5601"), "ISO-8859-1");
			}
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		// 보낼 준비
		res.reset();	// 서버에 클라이언트로 보낼 정보가 남아있을 경우 비우는 처리
		res.setContentType("application/octet-stream");
		// 이진형태로 파일을 보내겠다는 사실을 클라이언트에 전달
		// attachment; filename="test.txt"
		res.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
		res.setHeader("Content-type", "application/octet-stream");
		res.setHeader("Content-length", file.length()+"");	// header는 String 타입으로 보내야 하므로 ""추가
		
		
		try {
			out = res.getOutputStream();
			// 파일을 byte 단위로 읽어야 한다
			// 파일 크기가 너무 클 경우에 한번에 메모리 확보가 되지 않으면 분할해서 읽은 다음 보내야 함
			// 파일 하나를 저장할 byte 배열을 만들어 줌
			byte b[] = new byte[(int)file.length()];
			int leng=0;
			//in.read(b) - 주어진 배열 크기만큼 데이터를 읽어옴
			while((leng=in.read(b))>0) {	// 읽어온 데이터가 존재한다면(1 이상)
				out.write(b, 0, leng);		// 클라이언트로 전송해라
			}
			out.close();	// 파일 닫기
			in.close();		// 파일 닫기
		} catch (IOException e) {
			e.printStackTrace();
		}	// 파일을 보내기 위한 통로 개설
		// 파일을 보낼 때는 언제나 예외처리를 해줘야 한다
		
		// board_view.jsp로 가서 a태그에 #처리했던 거 path 주소로 고치고 값이 제대로 넘어가는지 확인하기
		
	}
	
}
