package springmember.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmember.dao.MemberDao;
import springmember.model.Member;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;

	@Override
	public List<Member> selectMember() {
		return memberDao.selectMember();
	}
	
	@Override
	public Member getMember(String mid) {
		return memberDao.getMember(mid);
	}
	
	@Override
	public int insertMember(Member member) {
		return memberDao.insertMember(member);
	}
	
	@Override
	public int updateMember(Member member) {
		return memberDao.updateMember(member);
	}
	
	@Override
	public int deleteMember(String mid) {
		return memberDao.deleteMember(mid);
	}
	

}
