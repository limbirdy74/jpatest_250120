package com.youngcompany.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.youngcompany.jpa.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

	@Transactional  // 
	public void deleteAllByMid(String mid);
}
