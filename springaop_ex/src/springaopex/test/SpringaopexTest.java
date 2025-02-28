package springaopex.test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springaopex.model.Springaopex;
import springaopex.service.SpringaopexServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springaopex/conf/applicationContext.xml")
public class SpringaopexTest {
	
	//@Autowired
	private SpringaopexServiceImpl springaopexServiceImpl = new SpringaopexServiceImpl();
	
	//@Test
	//@Ignore
	public void testSelectSpringaopex() {
		List<Springaopex> springaopexList = springaopexServiceImpl.selectSpringaopex();
		assertNotNull(springaopexList);
		System.out.println(springaopexList);
	}
	
	//@Test
	@Ignore
	public void testGetSpringaopex() {
		Springaopex springaopex =  springaopexServiceImpl.getSpringaopex(1);
		assertNotNull(springaopex);
		System.out.println(springaopex);
	}
	
	@Test
	//@Ignore
	public void testInsertSpringaopex() {
		Springaopex springaopex = new Springaopex(0, "4565");
		int result = springaopexServiceImpl.insertSpringaopex(springaopex);
		assertNotEquals(0, result);
		if (result > 0) {
			System.out.println("등록성공");
		}
	}
	
	//@Test
	@Ignore
	public void testUpdateSpringaopex() {
		Springaopex springaopex = new Springaopex(1, "수정비번");
		int result = springaopexServiceImpl.updateSpringaopex(springaopex);
		assertNotEquals(0, result);
		if (result > 0) {
			System.out.println("수정 성공");
		}
	}
	
	//@Test
	//@Ignore
	public void testDeleteSpringaopex() {
		int result = springaopexServiceImpl.deleteSpringaopex(2);
		assertNotEquals(0, result);
		if(result > 0) {
			System.out.println("삭제 성공!");
		}
	}

}
