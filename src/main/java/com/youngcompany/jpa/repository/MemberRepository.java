package com.youngcompany.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.youngcompany.jpa.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

	@Transactional  // 
	public void deleteAllByMid(String mid);
	
	public List<Member> findAllByOrderByMnumDesc(); // 모든 회원의 정보를 회원번호기준으로 내림차순으로 정렬해서 반환
	public List<Member> findByMnameLikeOrderByMnumDesc(String mname); // 이름에 특정 글자가 포함된 회원 번환
	public Member findByMidAndMpw(String mid, String mpw); // 아이디와 비번이 모두 일치하는 회원 검색
	public List<Member> findByMname(String mname);
}
