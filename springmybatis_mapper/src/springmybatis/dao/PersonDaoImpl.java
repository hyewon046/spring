package springmybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springmybatis.mapper.PersonMapper;
import springmybatis.model.Person;

@Repository("personDao")
public class PersonDaoImpl implements PersonDao {
	
	//@Autowired
	//private SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	private PersonMapper personMapper;

	@Override
	public List<Person> getPersonList() {
		return personMapper.getPersonList();
	}

	@Override
	public Person getPerson(int pid) {
		return personMapper.getPerson(pid);
	}

	@Override
	public int insertPerson(Person person) {
		return personMapper.insertPerson(person);
	}

	@Override
	public int updatePerson(Person person) {
		return personMapper.updatePerson(person);
	}

	@Override
	public int deletePerson(int pid) {
		return personMapper.deletePerson(pid);
	}

}
