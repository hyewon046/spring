package springaop.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springaop.service.MemberService;

public class Test {
	
	public static void main(String[] args) {
		
		ApplicationContext context
			=new GenericXmlApplicationContext("/springaop/conf/applicationContext.xml");
		
		MemberService memberService 
		= (MemberService)context.getBean("memberService");
		
		 memberService.getMemberList();
	}
}
