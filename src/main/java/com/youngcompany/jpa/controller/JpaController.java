package com.youngcompany.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.youngcompany.jpa.entity.Member;
import com.youngcompany.jpa.repository.MemberRepository;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class JpaController {
	
	@Autowired
	MemberRepository memberRepository;
	
	@GetMapping(value = "/join")
	public String join() {
		return "join";
	}
	
	@GetMapping(value = "/delete")
	public String delete() {
		return "delete";
	}
	
	@GetMapping(value = "/delete2")
	public String delete2() {
		return "delete2";
	}
	
	@PostMapping(value = "/joinOk")
	public String joinOk(HttpServletRequest request) {
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		int mage = Integer.parseInt(request.getParameter("mage"));//int로 변환
		
		com.youngcompany.jpa.entity.Member member = new com.youngcompany.jpa.entity.Member();
		member.setMid(mid);
		member.setMpw(mpw);
		member.setMname(mname);
		member.setMage(mage);
		
		memberRepository.save(member);//save->insert 쿼리를 실행함 
		
		return "redirect:list";
		
	}
	
	@GetMapping(value = "/deleteOk")
	public String deleteOk(HttpServletRequest request) {
		
		Long mnum = Long.parseLong(request.getParameter("mnum"));
		
		memberRepository.deleteById(mnum);
		
		return "redirect:list";
	}
	
	@GetMapping(value = "/deleteOk2")
	public String deleteOk2(HttpServletRequest request) {
		
		String mid = request.getParameter("mid");
		
		memberRepository.deleteAllByMid(mid);
		
		return "redirect:list";
	}
	
	@GetMapping(value = "/list") // 모든 회원 목록 가져오기
	public String memberlist(Model model) {
		
		// List<Member> members = memberRepository.findAll();  // select * from jpamembertbl 이게 기본
		// select * from jpamembertbl order by bnum desc -> 회원번호의 내림차순 이렇게 할려면 만들어야 한다
		List<Member> members = memberRepository.findAllByOrderByMnumDesc(); // memberrepository 에 만듬
				
		model.addAttribute("members", members);
		
		return "list";
	}
	
	@GetMapping(value = "/mlist") // 이름에 특정 글자가 들어간 모든 회원 목록 가져오기
	public String mlist(Model model) {
		

		List<Member> members = memberRepository.findByMnameLikeOrderByMnumDesc("%호%"); // 호 자가 들어간 이름은 모두 검색
				
		model.addAttribute("members", members);
		
		return "list";
	}	

}