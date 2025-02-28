package springaopex.test;

import static org.junit.Assert.assertEquals;
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
import springaopex.service.SpringaopexService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springaopex/conf/applicationContext.xml")
public class UnitTest {

	@Autowired
	private SpringaopexService service;
	
	//@Test
	@Ignore
	public void select() {
		List<Springaopex> list =  service.selectSpringaopex();
		assertNotNull(list);
	}
	
	//@Test
	@Ignore
	public void get() {
		Springaopex obj =  service.getSpringaopex(1);
		assertNotNull(obj);
	}
	
	@Test
	//@Ignore
	public void insert() {
		int result = service.insertSpringaopex(new Springaopex(0, "8959"));
		assertNotEquals(0, result);
	}
	
	//@Test
	//@Ignore
	public void update() {
		int result = service.updateSpringaopex(new Springaopex(1, "4944"));
		assertNotEquals(0, result);
	}
	
	//@Test
	//@Ignore
	public void delete() {
		int result = service.deleteSpringaopex(21);
		assertNotEquals(0, result);
	}	
	
	
}












