package springjunit.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springjunit.model.Hobby;
import springjunit.model.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springjunit/conf/applicationContext.xml")
public class PersonTest {
	
	@Autowired
	private ApplicationContext context;
	
	@BeforeClass
	//�׽�Ʈ ����� ���� ���� �ѹ��� ����
	public static void beforeClass() {
		System.out.println("beforeClass!");
	}
	
	@Before
	//@Test(�׽�Ʈ�޼ҵ�) �������� ����
	public void before() {
		System.out.println("before!");
	}
	
	@Test
	public void test1() {
		Person hong = context.getBean("person", Person.class);
		//value.properties������ hongŰ�� �ش��ϴ� ȫ�浿
		System.out.println(hong.getName());
		
		System.out.println("test1!");
		
		//hobby ��ü �����ؼ� sort������Ƽ�� '�౸' ����
		Hobby hobby = (Hobby) context.getBean("hobby");
		//Hobby hobby = context.getBean("hobby", hobby.class); //��ó���ϰų� �̷����ϰų�
		hobby.setSort("�౸");
		
		//���� ������ �׽�Ʈ
		assertEquals("�౸", hobby.getSort()); //Success
		
		//junit ���� alt+shift+x, t
	}
	@Test
	public void test2() {
		System.out.println("test2!");
		int[] iArr1 = {1, 2, 3};
		int[] iArr2 = {1, 3, 5};
		//�� �迭�� ������ �׽�Ʈ
		assertArrayEquals(iArr1, iArr2); //�ٸ��ϱ� failure �ߴ°� ��
	}
	
	@Test
	public void test3() {
		System.out.println("test3!");
		Person person1 = context.getBean("person", Person.class);
		Person person2 = context.getBean("person", Person.class);
		
		//�������� �⺻������ ��� ��ü�� �̱���(singleton)���� ����
		//������ ������ = ���� ��ü���� �׽�Ʈ
		assertSame(person1, person2); //Success
		System.out.println(person1.hashCode());
		System.out.println(person2.hashCode()); //���Գ���
		
		person1.setName("ȫ�浿");
		
		System.out.println(person2.getName()); //ȫ�浿
		System.out.println(person2.getAge()); //20
	}
	
	@Test
	public void test4() {
		boolean bool = true;
		//true���� �׽�Ʈ
		assertTrue(bool); //Success
		
		Object obj = null;
		//null�� �ƴ��� �׽�Ʈ
		assertNotNull(obj); //Failure
	}
	@After
	//@Test(�׽�Ʈ�޼ҵ�) �����Ŀ� ����
	public void after() {
		System.out.println("after!");
	}
	
	@AfterClass
	//�׽�Ʈ�� �������� �ѹ��� ����
	public static void afterClass() {
		System.out.println("afterClass!");
	}

}
