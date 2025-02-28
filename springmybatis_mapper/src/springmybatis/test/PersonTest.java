package springmybatis.test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springmybatis.model.Person;
import springmybatis.service.PersonService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springmybatis/conf/applicationContext.xml")
public class PersonTest {
	@Autowired
	private PersonService personService;
	
	//insert
	//@Test
	public void insertPerson() throws Throwable {
		int result = personService.insertPerson(new Person(0, "정수지", 20));
		assertNotEquals(0, result);
		if (result>0) {
			System.out.println("등록완");
		}
	}
	
	//get
	//@Test
	public void getPerson() throws Throwable {
		Person person = personService.getPerson(3);
		assertNotNull(person);
	}
	
	//list
	//@Test
	public void getPersonList() throws Throwable {
		List<Person> personList = personService.getPersonList();
		assertNotEquals(0, personList.size());
		for (Person person : personList) {
			System.out.println(person);
		}
	}
	
	//update
	//@Test
	public void updatePerson() throws Throwable {
		int result = personService.updatePerson(new Person(1, "전수지", 30));
		assertNotEquals(0, result);
	}
	
	//delete
	@Test
	public void deletePerson() throws Throwable {
		int result = personService.deletePerson(4);
		assertNotEquals(0, result);
	}
	
	

	
}
