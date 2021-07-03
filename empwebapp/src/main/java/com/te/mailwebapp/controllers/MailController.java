package com.te.mailwebapp.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.mailwebapp.beans.User_info;
import com.te.mailwebapp.beans.mail_info;
import com.te.mailwebapp.service.MailService;

@Controller
public class MailController {

	String id1;
	String email1;
	
	
	@Autowired
	private MailService service;

	@GetMapping("/login")
	public String getEmpForm() {
		return "UserLogin";
	}// getEmpForm

	@PostMapping("/login")
	public String authenticate(String email, String password, HttpServletRequest request, ModelMap map) {
		User_info user = service.authenticate(email, password);
		if (user != null) {
			this.id1 = user.getUid();
			this.email1=user.getEmail();
			
			HttpSession session = request.getSession();
			session.setAttribute("loggedIn", user);
//			session.setMaxInactiveInterval(3600);
			map.addAttribute("name", user.getUsername());
			return "Home";
		} else {
			map.addAttribute("errMsg", "Invalid Credentials");
			return "UserLogin";
		}
	}// authenticate
	
	@GetMapping("/compose")
	public String getComposeFrom(@SessionAttribute(name = "loggedIn", required = false) User_info user,
			ModelMap map) {
		if (user != null) {
			return "insertMail";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "UserLogin";
		}

	}//

	@PostMapping("/add")
	public String sendMail(String mid ,String email,String subject,String message,String status,
			@SessionAttribute(name = "loggedIn", required = false) User_info user, ModelMap map) {
		System.out.println(mid+" "+email);
		if (user != null) {
			if (service.sendMail(mid,email,email1,subject,message,status,id1)) {
				map.addAttribute("msg", "Successfully sent");
			} else {
				map.addAttribute("msg", "Failed to send");
			}
			return "insertMail";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "UserLogin";
		}

	}// add Employee
	
	@GetMapping("/getAll")
	public String getAllRecords(@SessionAttribute(name = "loggedIn", required = false) User_info user,
			ModelMap map) {
		if (user != null) {
			List<mail_info> mail = service.getAllMails(id1);
			if (mail != null) {
				map.addAttribute("infos", mail);
			}else {
				map.addAttribute("errMsg", "No Records Found");
			}
			map.addAttribute("name", user.getUsername());	
			return "Home";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "UserLogin";
		}
	}
	
	@GetMapping("/getAllSent")
	public String getAllSentRecords(@SessionAttribute(name = "loggedIn", required = false) User_info user,
			ModelMap map) {
		if (user != null) {
			List<mail_info> mail = service.getAllSent(id1);
			if (mail != null) {
				
				map.addAttribute("infos", mail);
			}else {
				map.addAttribute("errMsg", "No Records Found");
			}
			map.addAttribute("name", user.getUsername());	
			return "SentMailPage";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "UserLogin";
		}
	}
	

	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap map) {
		session.invalidate();
		map.addAttribute("msg", "logout successfull");
		return "UserLogin";
	}// logout

	@GetMapping("/getDeleteForm")
	public String getDeleteForm(@SessionAttribute(name = "loggedIn", required = false) User_info user,
			ModelMap map) {
		if (user != null) {
			return "deleteSentMail";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "UserLogin";
		}
	}//
	
	//delete recived mails
	@GetMapping("/getDeleteForm1")
	public String getDeleteForm1(@SessionAttribute(name = "loggedIn", required = false) User_info user,
			ModelMap map) {
		if (user != null) {
			return "deleteInboxMail";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "UserLogin";
		}
	}//
	
	@GetMapping("/delete1")
	public String deleteData1(String mid, @SessionAttribute(name = "loggedIn", required = false) User_info user,
			ModelMap map) {
		if (user != null) {
			if (service.deleteMailData1(mid,id1)) {
				map.addAttribute("msg", "Mail Deleted successfully for id : " + mid);
			} else {
				map.addAttribute("msg", "Could not find Mail for id : " + mid);
			}
			return "deleteInboxMail";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "UserLogin";
		}

	}//

	@GetMapping("/delete")
	public String deleteData(String mid, @SessionAttribute(name = "loggedIn", required = false) User_info user,
			ModelMap map) {
		if (user != null) {
			if (service.deleteMailData(mid,id1)) {
				map.addAttribute("msg", "Mail Deleted successfully for id : " + mid);
			} else {
				map.addAttribute("msg", "Could not find mail for id : " + mid);
			}
			return "deleteSentMail";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "UserLogin";
		}

	}//

}
