package com.kosa.myapp3.board;

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

import com.kosa.myapp3.comment.CommentDTO;
import com.kosa.myapp3.comment.CommentService;
import com.kosa.myapp3.common.CommonConst;
import com.kosa.myapp3.common.FileUploadUtil;

@Controller
public class BoardController {
	@Resource(name="boardService")
	BoardService boardService;
	
	@Resource(name="commentService")
	CommentService commentService;
		
	@RequestMapping(value="/board/list")
	public String getList(BoardDTO dto, Model model) {
		model.addAttribute("totalCnt", boardService.getTotalCnt(dto));
		model.addAttribute("boardList", boardService.getList(dto));
		return "board/board_list";
	}
	
	@RequestMapping(value="/board/write")
	public String write(BoardDTO dto, Model model) {
		BoardDTO tempDTO = new BoardDTO();
		model.addAttribute("boardDTO", tempDTO);
		return "board/board_write";
	}
	
	// view(seq) -> reply(seq)
	@RequestMapping(value="/board/reply")
	public String reply(BoardDTO dto, Model model) {
		// 부모글 정보 가져오기
		BoardDTO tempDTO = boardService.getView(dto);
		model.addAttribute("boardDTO", tempDTO);
		return "board/board_write";
	}
	
	// 글쓰기를 ajax로 썼으므로 답글쓰기도 ajax로 처리하는 것이 바람직
	// RequestMapping의 url 주소는 절대 중복될 수 없다(충돌예방)
	@ResponseBody
	@RequestMapping(value="/board/reply_save")
	public Map<String, String> reply_save(BoardDTO dto, Model model, MultipartHttpServletRequest multi) {
		
		// 트랜잭션 처리를 해놓으면 Controller에서 예외처리를 한다
		// 서비스에서 예외처리를 할 경우 rollback이 적용되지 않는다
		Map<String, String> resultMap = new HashMap<String, String>();
		try {
			List<MultipartFile> fileList = new ArrayList<MultipartFile>();
			fileList.add(multi.getFile("file1"));
			fileList.add(multi.getFile("file2"));
			fileList.add(multi.getFile("file3"));
			
			List<String> filenameList = new ArrayList<String>();
			
			String path = CommonConst.UPLOADPATH+"\\board";
			FileUploadUtil.setFilePath(path);
			
			FileUploadUtil.upload(fileList, filenameList);
			dto.setFilename1(filenameList.get(0));
			dto.setFilename2(filenameList.get(1));
			dto.setFilename3(filenameList.get(2));
			
			System.out.println(dto.getFilename1());
			System.out.println(dto.getFilename2());
			System.out.println(dto.getFilename3());
			
			resultMap.put("result", "success");
			resultMap.put("message", "글이 등록되었습니다.");
			boardService.reply(dto);
		}catch(Exception e) {
			e.printStackTrace();
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
		
	}
	// board/view?seq=12 보통은 이렇게 넘긴다
	// board/view?seq=12&board_seq=12 이런 식으로 넘길 수 없으니까 commentDTO를 파라미터로 넣지 말고 그냥 comment객체를 생성해라
	@RequestMapping(value="/board/view")
	public String getView(BoardDTO dto, Model model) {
		CommentDTO cmtDTO = new CommentDTO();
		cmtDTO.setBoard_seq(dto.getSeq());
		
		BoardDTO resultDTO = boardService.getView(dto);
		List<CommentDTO> list = commentService.getComment(cmtDTO);
		model.addAttribute("dto", resultDTO);
		model.addAttribute("cmtDTO", list);
		return "board/board_view";
	}
	
	// 원글이 있고 별도로 코멘트를 달거나 추천을 할 때 그 부분만 별도로 움직이게 만들어야 함 => ajax 사용
	@ResponseBody
	@RequestMapping(value="/comment/insert")
	public Map<String, Object> cmtSave(BoardDTO dto, CommentDTO cmtDTO) {
		// HashMap의 Key는 거의 항상 String 타입이지만 데이터값은 String 이외에 다른 타입일 수 있음
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map.put("result", "success");
			map.put("message", "글이 등록되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", "fail");
			
		}
		commentService.insert(cmtDTO);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="/comment/list")
	public Map<String, Object> CommentList(CommentDTO commentDTO){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", commentService.getComment(commentDTO));
		return map;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/board/save")
	public Map<String, String> board_save(BoardDTO dto, MultipartHttpServletRequest multi){
		// dto에 들어가 있는 파라미터값들을 리스트에 담는다
		// 파일처리를 한다
		Map<String, String> resultMap=new HashMap<String, String>();
		
		List<MultipartFile> fileList = new ArrayList<MultipartFile>();
		fileList.add(multi.getFile("file1"));
		fileList.add(multi.getFile("file2"));
		fileList.add(multi.getFile("file3"));
		
		List<String> filenameList = new ArrayList<String>();
		
		String path = CommonConst.UPLOADPATH+"\\board";
		FileUploadUtil.setFilePath(path);
		
		FileUploadUtil.upload(fileList, filenameList);
		dto.setFilename1(filenameList.get(0));
		dto.setFilename2(filenameList.get(1));
		dto.setFilename3(filenameList.get(2));
		
		System.out.println(dto.getFilename1());
		System.out.println(dto.getFilename2());
		System.out.println(dto.getFilename3());
		boardService.insert(dto);
		
		resultMap.put("result", "0");
		resultMap.put("message", "글이 등록되었습니다.");
		return resultMap;
		
	}
	
	@RequestMapping(value="/board/modify")
	public String modify(BoardDTO dto, Model model){
		BoardDTO presentDTO = boardService.getView(dto);
		model.addAttribute("boardDTO", presentDTO);
		return "board/board_write";
	}
	
	@ResponseBody
	@RequestMapping(value="/board/modify_save")
	public Map<String, String> modify_save(BoardDTO dto, MultipartHttpServletRequest multi, 
			Model model, String []del, String []old_name){
		// 트랜잭션 처리를 해놓으면 Controller에서 예외처리를 한다
		// 서비스에서 예외처리를 할 경우 rollback이 적용되지 않는다
		Map<String, String> map = new HashMap<String, String>();
			// 파일이 첨부되지 않더라도 본래 파일명은 갖고 있어야 한다
			// DB에서 가져온 기본값들을 넣어야 함
//		Map<String, String> resultMap = new HashMap<String, String>();
//		try {
			dto.setFilename1(old_name[0]);
			dto.setFilename2(old_name[1]);
			dto.setFilename3(old_name[2]);
			
			String path = CommonConst.UPLOADPATH+"\\board";
			FileUploadUtil.setFilePath(path);

			List<MultipartFile> fileList = new ArrayList<MultipartFile>();
			fileList.add(multi.getFile("file1"));
			fileList.add(multi.getFile("file2"));
			fileList.add(multi.getFile("file3"));
			
			List<String> filenameList = new ArrayList<String>();
			
			FileUploadUtil.upload(fileList, filenameList);

			// 첨부된 파일 처리
			if(del[0].equals("1"))
				dto.setFilename1(filenameList.get(0));
			if(del[1].equals("2"))
				dto.setFilename2(filenameList.get(1));
			if(del[2].equals("3"))
				dto.setFilename3(filenameList.get(2));

			
		//	if(del[1]!=null && del[1].equals("2"))
		//		dto.setFilename1(filenameList.get(1));
		//	if(del[2]!=null && del[2].equals("3"))
		//		dto.setFilename1(filenameList.get(2));
						
//			resultMap.put("result", "success");
//			resultMap.put("message", "글이 수정되었습니다.");
			boardService.modify(dto);
			map.put("result", "success");
			/*
			 * }catch(Exception e) { e.printStackTrace(); resultMap.put("result", "fail"); }
			 */
			return map;
	}
	
	@ResponseBody
	@RequestMapping(value="/board/delete")
	public Map<String, String> delete(BoardDTO dto, Model model){
		Map<String, String> resultMap = new HashMap<String, String>();
		boardService.delete(dto);
		resultMap.put("result", "success");
		return resultMap;
	}
	
}

