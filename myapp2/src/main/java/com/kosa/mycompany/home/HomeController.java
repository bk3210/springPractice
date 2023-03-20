package com.kosa.mycompany.home;

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


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	/*
	 * private static final Logger logger =
	 * LoggerFactory.getLogger(HomeController.class);
	 * 
	 *//**
		 * Simply selects the home view to render by returning its name.
		 */
	
	@Resource(name="homeService")
	HomeService homeService;
	
	@RequestMapping(value = "/home/list")
	public String home_list(HomeDTO dto, Model model) {
		return "home/home_list";
	}
	
	
	@RequestMapping(value = "/home/write")
	public String write() {
		return "home/home_write";
	}
	
	@ResponseBody
	@RequestMapping(value="/home/save")
	public Map<String, String> home_save(HomeDTO dto, MultipartHttpServletRequest multi){
		Map<String, String> resultMap = new HashMap<String, String>();
		System.out.println(dto.getTitle());
		
		MultipartFile file = multi.getFile("file1");
		List<MultipartFile> fileList = new ArrayList<MultipartFile>();
		fileList.add(file);
		
		List<String> filenameList = new ArrayList<String>();
		
		String path = "C:\\web_programming\\spring_workspace1\\myapp2\\src\\main\\webapp\\homeimage";
		FileUploadUtil.setFilePath(path);		//  경로 지정
		
		FileUploadUtil.upload(fileList, filenameList);
		dto.setImage(filenameList.get(0));
		
		System.out.println(dto.getImage());
		homeService.insert(dto);
		
		resultMap.put("result", "0");
		resultMap.put("message", "글이 등록되었습니다.");
		return resultMap;
	}
	
	@ResponseBody
	@RequestMapping(value="/home/list_data")
	public Map<String, Object> home_listData(HomeDTO dto){
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", homeService.homeList(dto));
		return map;
	}

}
