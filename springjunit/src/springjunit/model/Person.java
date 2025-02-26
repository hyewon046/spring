package springjunit.model;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("person")
public class Person implements Serializable{
	
	private static final long serialVersionUID = 897489645L;
	
	@Value("${hong}")
	private String name;
	
	@Value("20")
	private int age;
	
	@Autowired
	private Hobby hobby;
	
	public Person() {
	}

	public Person(String name, int age, Hobby hobby) {
		this.name = name;
		this.age = age;
		this.hobby = hobby;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Hobby getHobby() {
		return hobby;
	}

	public void setHobby(Hobby hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", hobby=" + hobby + "]";
	}
	
	
	
	
	
	

}
