package com.youngcompany.jpa;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.youngcompany.jpa.entity.Member;
import com.youngcompany.jpa.repository.MemberRepository;

@SpringBootTest
public class JpaMemberTest {
	
	@Autowired
	MemberRepository memberRepository;
	
	@Test
	@DisplayName("로그인 테스트 아이디 비번 확인")
	public void loginTest() {
//		Member member = memberRepository.findByMidAndMpw("tiger", "12345");
//		System.out.println(member.getMname());
		
		List<Member> members = memberRepository.findByMname("호랑이");
		for(Member member:members) {
			System.out.println(member.getMid());
		}
		
	}

}
