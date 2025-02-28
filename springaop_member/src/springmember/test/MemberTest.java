package springmember.test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springmember.controller.MemberController;
import springmember.model.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springmember/conf/applicationContext.xml")
public class MemberTest {
	
	@Autowired
	private MemberController memberController;
	
	@Test
	@Ignore
	public void testSelectMember() {
		List<Member> memberList = memberController.selectMember();
		assertNotNull(memberList);
		System.out.println(memberList);
	}
	
	@Test
	@Ignore
	public void testGetMember() {
		Member member =  memberController.getMember("HONG");
		assertNotNull(member);
		System.out.println(member);
	}
	
	@Test
	@Ignore
	public void testInsertMember() {
		Member member = new Member("jeon", "����", "M", "korea");
		int result = memberController.insertMember(member);
		assertNotEquals(0, result);
		if (result > 0) {
			System.out.println("��ϼ���");
		}
	}
	
	@Test
	@Ignore
	public void testUpdateMember() {
		Member member = new Member("HONG", "ȫ�浿(������)", "M", "�Ѿ�");
		int result = memberController.updateMember(member);
		assertNotEquals(0, result);
		if (result > 0) {
			System.out.println("���� ����");
		}
	}
	
	@Test
	//@Ignore
	public void testDeleteMember() {
		int result = memberController.deleteMember("jeon");
		assertNotEquals(0, result);
		if(result > 0) {
			System.out.println("���� ����!");
		}
	}

}
