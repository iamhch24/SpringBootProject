package com.naver.iamhch24.controller;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.naver.iamhch24.dao.MemberDao;
import com.naver.iamhch24.entities.Member;

@Controller
public class MemberController {

	@Autowired // new 객체로 안만들어줘도 됨.
	private SqlSession sqlSession; // sql 세션화 시킨 클래스 -- 로그인을 하면 그 정보가 연결됨. --> 세션 선언함. (로그인 정보) 다른 페이지에서 정보 사용가능

//	@Autowired
//	BCryptPasswordEncoder passwordEncoder;

	@Autowired
	Member member;

//	@Autowired
//	private StorageService storageService;

	@RequestMapping(value = "/emailConfirmAjax", method = RequestMethod.POST)
	@ResponseBody
	public String emailConfirmAjax(@RequestParam String email) throws Exception {
		MemberDao dao = sqlSession.getMapper(MemberDao.class); // 세션에 매핑
		Member data = dao.selectOne(email);
		String row = "yes";
		if (data == null) {
			row = "no";
		} else {
//			System.out.println("-->ajax 호출 : " + data.getName());
		}
		return row;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Locale locale, Model model, HttpSession session) {
//		session.invalidate();
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
//		MemberDao dao = sqlSession.getMapper(MemberDao.class); // 세션에 매핑
		return "login/login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Locale locale, Model model, HttpSession session) {
		session.invalidate();
		return "redirect:index";
	}

	@RequestMapping(value = "/loginUp", method = RequestMethod.POST)
	public String loginup(Locale locale, Model model, @ModelAttribute Member member, HttpSession session)
			throws Exception {
		MemberDao dao = sqlSession.getMapper(MemberDao.class); // 세션에 매핑
		Member data = dao.selectOne(member.getEmail());
		if (data == null) {
			model.addAttribute("msg", "failed");
			return "login/login";
		} else {
			boolean passchk = BCrypt.checkpw(member.getPassword(), data.getPassword());
			if (passchk) {
				session.setAttribute("sessionemail", data.getEmail());
				session.setAttribute("sessionname", data.getName());
				session.setAttribute("sessionphoto", data.getPhoto());
				session.setAttribute("sessionlevel", data.getMemlevel());
				return "index";
			} else {
				model.addAttribute("msg", "failed");
				return "login/login";
			}
		}
	}

	@RequestMapping(value = "/memberInsert", method = RequestMethod.GET)
	public String memberInsert(Locale locale, Model model) throws Exception {
//		System.out.println("/memberInsert called");
		return "member/member_insert";
	}

	@RequestMapping(value = "/member_insertSave", method = RequestMethod.POST)
	public String member_insertSave(Model model, @ModelAttribute Member member) throws Exception {
		if (member.getPhoto() == null || member.getPhoto().equals("")) {
			member.setPhoto("/images/noimage.jpg");
		}
		MemberDao dao = sqlSession.getMapper(MemberDao.class); // 세션에 매핑
		String encodepassword = hashPassword(member.getPassword());
//		System.out.println("encode pw : " + encodepassword);
		member.setPassword(encodepassword);
		String authNum = randomNum();
		String content = "회원가입을 환영합니다." + "인증번호 : " + authNum;
		sendEmail(member.getEmail(), content, authNum);
		dao.insertRow(member);
		return "index";
	}

	private String hashPassword(String plainTextPassword) {
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}

	@RequestMapping(value = "/memberUpdate", method = RequestMethod.GET)
	public String memberUpdate(Locale locale, Model model, HttpSession session) throws Exception {
		String email = (String) session.getAttribute("sessionemail");
//		System.out.println("===============success:email" + email);
		MemberDao dao = sqlSession.getMapper(MemberDao.class); // 세션에 매핑
		Member row = dao.selectOne(email);
		model.addAttribute("row", row);
		return "member/member_update";
	}

	@RequestMapping(value = "/member_updateSave", method = RequestMethod.POST)
	public String member_updateSave(Model model, HttpSession session, Member member,
			@RequestParam("imgfile") MultipartFile imgfile) throws Exception {
		String filename = imgfile.getOriginalFilename();
		String path = "D:\\Code\\SpringBootSource\\aiappbootproject\\src\\main\\resources\\static\\uploadimages\\"; // 윈도우즈는
		String realpath = "/uploadimages/"; // static 아래에 폴더 생성
		if (filename.equals("")) {
			member.setPhoto(member.getOldphoto());
		} else {
			String cutemail = member.getEmail().substring(0, member.getEmail().indexOf("@"));
			byte bytes[] = imgfile.getBytes();
			try {
				BufferedOutputStream output = new BufferedOutputStream(
						new FileOutputStream(path + cutemail + filename));
				output.write(bytes);
				output.flush();
				output.close();
				member.setPhoto(realpath + cutemail + filename);
				if (!member.getPassword().equals(member.getOldpassword())) {
					String encodepassword = hashPassword(member.getPassword());
					member.setPassword(encodepassword);
				}
				MemberDao dao = sqlSession.getMapper(MemberDao.class);
				dao.updateRow(member);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		session.setAttribute("sessionemail", member.getEmail());
		session.setAttribute("sessionname", member.getName());
		session.setAttribute("sessionphoto", member.getPhoto());
		session.setAttribute("sessionlevel", member.getMemlevel());
		return "index";
	}

	@RequestMapping(value = "/memberList", method = RequestMethod.GET)
	public String memberList(Locale locale, Model model) throws Exception {
		MemberDao dao = sqlSession.getMapper(MemberDao.class); // 세션에 매핑
		ArrayList<Member> members = dao.selectAll();
//		for (Member member : members) {
//			System.out.println(member.getEmail());
//		}
		model.addAttribute("members", members);
		return "member/member_list";
	}

	@RequestMapping(value = "/memberUpdateAjax", method = RequestMethod.POST)
	@ResponseBody
	public String memberUpdateAjax(@RequestParam String email, @RequestParam int memlevel) throws Exception {
//		System.out.println("memberUpdateAjax :: email=" + email + ", memlevel=" + memlevel);
		member.setEmail(email);
		member.setMemlevel(memlevel);
		MemberDao dao = sqlSession.getMapper(MemberDao.class); // 세션에 매핑
		int result = dao.updateAjax(member);
//		System.out.println("memberUpdateAjax :: result=" + result);
		if (result > 0) {
			return "Y";
		} else {
			return "N";
		}
	}

	@RequestMapping(value = "/memberDeleteAjax", method = RequestMethod.POST)
	@ResponseBody
	public String memberDeleteAjax(@RequestParam String email) throws Exception {
//		System.out.println("memberDeleteAjax :: email=" + email);
		MemberDao dao = sqlSession.getMapper(MemberDao.class); // 세션에 매핑
		int result = dao.deleteAjax(email);
//		System.out.println("memberDeleteAjax :: result=" + result);
		if (result > 0) {
			return "Y";
		} else {
			return "N";
		}
	}

	private void sendEmail(String email, String content, String authNum) {
		String host = "smtp.gmail.com";
		String subject = "온라인토론 인증번호";
		String fromName = "토론 관리자";
		String from = "iamabcd718@gmail.com";
		String to1 = email;
		try {
			Properties props = new Properties();
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host", host);
			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.port", "587"); // or 465
			props.put("mail.smtp.user", from);
			props.put("mail.smtp.auth", "true");
			Session mailSession = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("iamabcd718", "vejihfbeeyujckca"); // 위 gmail에서 생성된 비밀번호 넣는다
				}
			});
			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(from, MimeUtility.encodeText(fromName, "UTF-8", "B")));
			InternetAddress[] address1 = { new InternetAddress(to1) };
			msg.setRecipients(Message.RecipientType.TO, address1);
			msg.setSubject(subject);
			msg.setSentDate(new java.util.Date());
			msg.setContent(content, "text/html;charset=euc-kr");
			Transport.send(msg);
		} catch (Exception e) {
		}
	}

	String randomNum() {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i <= 3; i++) {
			int n = (int) (Math.random() * 10);
			buffer.append(n);
		}
		return buffer.toString();
	}
}
