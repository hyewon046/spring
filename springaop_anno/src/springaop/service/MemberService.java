package springaop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class MemberService {
	
	public List<String> getMemberList() {
		List<String> memberList = new ArrayList();
		for (int i =1; i<10000001; i++) {
			memberList.add("¸â¹ö" + i );
		}
		return memberList;
	}

}
