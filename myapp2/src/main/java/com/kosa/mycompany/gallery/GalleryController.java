package com.kosa.mycompany.gallery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kosa.mycompany.common.FileUploadUtil;

@Controller
public class GalleryController {
	
	@Resource(name="galleryService")
	GalleryService galleryService;
	
	@RequestMapping(value="/gallery/list")
	public String gallery_list(GalleryDTO dto, Model model) {
		System.out.println(dto.getSearchKey());
		System.out.println(dto.getSearchKeyword());
		
		model.addAttribute("totalCnt", galleryService.getTotalCnt(dto));
		return "gallery/gallery_list";
	}
	

	@RequestMapping(value="/gallery/write")
	public String write() {
		
		return "gallery/gallery_write";
	}
	
	@ResponseBody
	@RequestMapping(value="/gallery/save")
	public Map<String, String> gallery_save(GalleryDTO dto, MultipartHttpServletRequest multi) {
		Map<String, String> resultMap = new HashMap<String, String>();
		System.out.println(dto.getTitle());
		System.out.println(dto.getWriter());
		System.out.println(dto.getContents());
		// Spring에서는 DTO의 image1 주소명 객체타입(파일 타입)를 String 그대로 가져오면 에러남
		// (바인딩하면 String타입이 아니게 되기 때문)
		// 이미지 삽입태그의 id값을 DTO 매개변수명과 다르게 받은 다음 별도로 처리해줘야 함
		// 그리고 파일명을 변수에 할당
		// System.out.println(dto.getImage1());
		MultipartFile file = multi.getFile("file1");
		List<MultipartFile> fileList = new ArrayList<MultipartFile>();
		fileList.add(file);
		
		List<String> filenameList = new ArrayList<String>();
		
		String path="C:\\web_programming\\spring_workspace1\\myapp2\\src\\main\\webapp\\upload";
		FileUploadUtil.setFilePath(path);	// 경로 설정
		
		FileUploadUtil.upload(fileList, filenameList);
		dto.setImage1(filenameList.get(0));
		
		System.out.println(dto.getImage1());
		galleryService.insert(dto);
		System.out.println("+++++++++++++");
		
		resultMap.put("result", "0");
		resultMap.put("message", "글이 등록되었습니다.");
		return resultMap;
	}
	
	@ResponseBody
	@RequestMapping(value="/gallery/list_data")
	public Map<String, Object> gallery_listdata(GalleryDTO dto) {
		// pg사이즈 임의로 지정(BaseDTO에 지정된 값을 상속받음)
		dto.setPgSize(12);	// 화면에 몇 개의 이미지를 띄울 건지
		
		// 데이터를 JSON으로 jsp에 보낼거라 Map
		// 값에는 String, Integer 등 다양한 값이 들어갈 수 있으므로 Object type 부여
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalCnt", galleryService.getTotalCnt(dto));
		map.put("data", galleryService.getList(dto));
		return map;
	}
	
}