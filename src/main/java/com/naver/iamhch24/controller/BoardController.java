package com.naver.iamhch24.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.naver.iamhch24.dao.BoardDao;
import com.naver.iamhch24.entities.Board;
import com.naver.iamhch24.entities.BoardPaging;

@Controller
public class BoardController {

	@Autowired // new 객체로 안만들어줘도 됨.
	private SqlSession sqlSession; // sql 세션화 시킨 클래스 -- 로그인을 하면 그 정보가 연결됨. --> 세션 선언함. (로그인 정보) 다른 페이지에서 정보 사용가능

	@Autowired
	Board board;

	@Autowired
	BoardPaging boardpaging;

	static String find; // 프로젝트 전체에서 사용됨

	@RequestMapping(value = "/boardWrite", method = RequestMethod.GET)
	public String boardWrite(Locale locale, Model model, HttpSession session) {
		return "board/board_write";
	}

	@RequestMapping(value = "/board_writeSave", method = RequestMethod.POST)
	public String board_writeSave(HttpServletRequest request, Model model, @ModelAttribute Board board,
			@RequestParam("b_attachfile") MultipartFile b_attachfile) throws Exception {

		String filename = b_attachfile.getOriginalFilename();
		String path = "D:\\Code\\SpringBootSource\\aiappbootproject\\src\\main\\resources\\static\\uploadattaches\\";
		String realpath = "/uploadattaches/"; // static 아래에 폴더 생성
		if (!filename.equals("")) {
			byte bytes[] = b_attachfile.getBytes();
			try {
				BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(path + filename));
				output.write(bytes);
				output.flush();
				output.close();
				board.setB_attach(realpath + filename);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm:ss");
		Date date = new Date();
		String b_inputtime = df.format(date);
		String b_inputip = getIp(request);
		board.setB_inputtime(b_inputtime);
		board.setB_inputip(b_inputip);
		BoardDao dao = sqlSession.getMapper(BoardDao.class); // 세션에 매핑
		dao.insertRow(board);
		return "redirect:boardPageList";
	}

	@RequestMapping(value = "/boardDetail", method = RequestMethod.GET)
	public String boardDetail(Locale locale, Model model, HttpSession session, @RequestParam int b_seq)
			throws Exception {
		BoardDao dao = sqlSession.getMapper(BoardDao.class); // 세션에 매핑
		Board board = dao.selectOne(b_seq);
		String cursession = (String) session.getAttribute("sessionemail");
		if (!cursession.equals(board.getB_email())) {
			dao.addHit(b_seq);
		}
		model.addAttribute("board", board);
		return "board/board_detail";
	}

	@RequestMapping(value = "/board_updateSave", method = RequestMethod.POST)
	public String board_writeSave(HttpServletRequest request, Model model, @ModelAttribute Board board,
			@RequestParam Integer b_seq) throws Exception {
		BoardDao dao = sqlSession.getMapper(BoardDao.class); // 세션에 매핑
		dao.updateRow(board);

		return "redirect:boardPageList";
	}

	@RequestMapping(value = "/boardDelete", method = RequestMethod.GET)
	public String board_writeSave(HttpServletRequest request, Model model, @RequestParam Integer b_seq)
			throws Exception {
		BoardDao dao = sqlSession.getMapper(BoardDao.class); // 세션에 매핑
		dao.deleteRow(b_seq);
		return "redirect:boardPageList";
	}

	@RequestMapping(value = "/replyWrite", method = RequestMethod.GET)
	public String replyWrite(Locale locale, Model model, HttpSession session, @RequestParam int b_seq)
			throws Exception {
		BoardDao dao = sqlSession.getMapper(BoardDao.class); // 세션에 매핑
		board = dao.selectOne(b_seq);
		board.setB_title("[답글]" + board.getB_title());
		model.addAttribute("board", board);
		return "board/board_reply";
	}

	@RequestMapping(value = "/board_replySave", method = RequestMethod.POST)
	public String board_replySave(HttpServletRequest request, Model model, @ModelAttribute Board board,
			@RequestParam("b_attachfile") MultipartFile b_attachfile) throws Exception {
		String filename = b_attachfile.getOriginalFilename();
		String path = "D:\\Code\\SpringBootSource\\aiappbootproject\\src\\main\\resources\\static\\uploadattaches\\";
		String realpath = "/uploadattaches/"; // static 아래에 폴더 생성
		if (!filename.equals("")) {
			byte bytes[] = b_attachfile.getBytes();
			try {
				BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(path + filename));
				output.write(bytes);
				output.flush();
				output.close();
				board.setB_attach(realpath + filename);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm:ss");
		Date date = new Date();
		String b_inputtime = df.format(date);
		String b_inputip = getIp(request);
		board.setB_inputtime(b_inputtime);
		board.setB_inputip(b_inputip);
		BoardDao dao = sqlSession.getMapper(BoardDao.class); // 세션에 매핑
		dao.insertReplyRow(board);
		return "redirect:boardPageList";
	}

	@RequestMapping(value = "/boardPageList", method = RequestMethod.GET)
	public String boardPageList(Locale locale, Model model, HttpSession session,
			@RequestParam(required = false) Integer page, @RequestParam(required = false) String find)
			throws Exception {
//		System.out.println("== /boardPageList ==");
		if (page == null)
			page = 1;
		if (find == null)
			find = "";
		int pagesize = 10;
		int startrow = (page - 1) * pagesize;
		int endrow = 10;
		boardpaging.setFind(find);
		BoardDao dao = sqlSession.getMapper(BoardDao.class); // 세션에 매핑
		int rowcount = dao.selectCount(boardpaging); // 갯수를 구할때는 start와 end를 지정하지 않는다. 검색어에 맞는 row갯수
		int pagecount = (rowcount % pagesize > 0) ? (rowcount / pagesize + 1) : (rowcount / pagesize);
		int pages[] = new int[pagecount];
		for (int i = 0; i < pagecount; i++)
			pages[i] = i + 1;

		boardpaging.setStartrow(startrow);
		boardpaging.setEndrow(endrow);
		ArrayList<Board> boards = dao.selectPagingList(boardpaging); // 리스트를 구할 때는 start와 end를 설정함
		model.addAttribute("boards", boards);
		model.addAttribute("rowcount", rowcount);
		model.addAttribute("pages", pages);
		model.addAttribute("find", find);
//		System.out.println("== test == boards.size :: " + boards.size());
		return "board/board_page_list";
	}

	@RequestMapping(value = "/fileDownload")
	@ResponseBody
	public void fileDownload(@RequestParam String b_attach, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		request.setCharacterEncoding("UTF-8");
		File file = new File("D:\\Code\\SpringBootSource\\aiappbootproject\\src\\main\\resources\\static" + b_attach);
		String oriFileName = file.getName();
		String filePath = "D:\\Code\\SpringBootSource\\aiappbootproject\\src\\main\\resources\\static\\uploadattaches\\";
		InputStream in = null;
		OutputStream os = null;
		File newfile = null;
		boolean skip = false;
		String client = "";
		// 파일을 읽어 스트림에 담기
		try {
			newfile = new File(filePath, oriFileName);
			in = new FileInputStream(newfile);
		} catch (FileNotFoundException fe) {
			skip = true;
		}
		client = request.getHeader("User-Agent");
		response.reset();
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Description", "HTML Generated Data");
		if (!skip) {
			// IE
			if (client.indexOf("MSIE") != -1) {
				response.setHeader("Content-Disposition", "attachment; filename=\""
						+ java.net.URLEncoder.encode(oriFileName, "UTF-8").replaceAll("\\+", "\\ ") + "\"");
				// IE 11 이상.
			} else if (client.indexOf("Trident") != -1) {
				response.setHeader("Content-Disposition", "attachment; filename=\""
						+ java.net.URLEncoder.encode(oriFileName, "UTF-8").replaceAll("\\+", "\\ ") + "\"");
			} else {
				// 한글 파일명 처리
				response.setHeader("Content-Disposition",
						"attachment; filename=\"" + new String(oriFileName.getBytes("UTF-8"), "ISO8859_1") + "\"");
				response.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
			}
			response.setHeader("Content-Length", "" + file.length());
			os = response.getOutputStream();
			byte b[] = new byte[(int) file.length()];
			int leng = 0;
			while ((leng = in.read(b)) > 0) {
				os.write(b, 0, leng);
			}
		} else {
			response.setContentType("text/html;charset=UTF-8");
			System.out.println("<script language='javascript'>alert('파일을 찾을 수 없습니다');history.back();</script>");
			System.out.println("skip...........");
		}
		in.close();
		os.close();
	}

	private String getIp(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}