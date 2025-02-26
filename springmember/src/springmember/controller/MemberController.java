package springmember.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import springmember.model.Member;
import springmember.service.MemberService;

@Controller("memberController")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	public List<Member> selectMember() {
		return memberService.selectMember();
	}
	
	public Member getMember(String mid) {
		return memberService.getMember(mid);
	}
	
	public int insertMember(Member member) {
		return memberService.insertMember(member);
	}
	
	public int updateMember(Member member) {
		return memberService.updateMember(member);
	}
	
	public int deleteMember(String mid) {
		return memberService.deleteMember(mid);
	}

}
