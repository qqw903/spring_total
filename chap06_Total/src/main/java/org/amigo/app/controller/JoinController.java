package org.amigo.app.controller;

import java.util.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.amigo.app.model.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping(path="/join")
public class JoinController {
	
	@Autowired
	MemberDao dao;
	
	@RequestMapping(path="/add", method=RequestMethod.GET)
	public String JoinForm(Model model) {
		model.addAttribute("section", "join");
		return "t_expr";
	}
	
	@RequestMapping(path="/add", method=RequestMethod.POST)
	public String JoinExec(@RequestParam Map map, HttpSession session, Model model){
		try {
			boolean r = dao.JoinAdd(map);
			session.setAttribute("auto", "on");
			return "/member/loginform";
			
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("temp", map);
			return "/member/joinform";
		}
	}
	
	@PostMapping(path="/signup_check/{mode}", produces="text/html;charset=utf-8")
	@ResponseBody
	public String signup_check(@PathVariable String mode){
		
		Map map = dao.checkId(mode);
		if(map != null) {
			return "<b style=\"color: red;\">이미 사용중인 아이디 입니다.</b>";
		}else {
			return "<b style=\"color: blue;\">사용가능한 아이디 입니다.</b>";
		}
	}
	
	@PostMapping(path="/signup_check2/{email}", produces="text/html;charset=utf-8")
	@ResponseBody
	public String signup_check2(@PathVariable String email){
		Map map = dao.checkEmail(email);
		if(map != null) {
			return "<b style=\"color: blue;\">이미 사용중인 이메일 입니다.</b>";
		}else {
			return "<b style=\"color: blue;\">사용가능한 이메일 입니다.</b>";
		}
	}
}

