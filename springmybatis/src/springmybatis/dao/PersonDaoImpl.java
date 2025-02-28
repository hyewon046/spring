package springmybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springmybatis.model.Person;

@Repository("personDao")
public class PersonDaoImpl implements PersonDao {
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	@Override
	public List<Person> getPersonList() {
		return sqlSessionFactory.openSession().selectList("Person.getPersonList");
	}

	@Override
	public Person getPerson(int pid) {
		return sqlSessionFactory.openSession().selectOne("Person.getPerson", pid);
	}

	@Override
	public int insertPerson(Person person) {
		return sqlSessionFactory.openSession().insert("Person.insertPerson", person);
	}

	@Override
	public int updatePerson(Person person) {
		return sqlSessionFactory.openSession().update("Person.updatePerson", person);
	}

	@Override
	public int deletePerson(int pid) {
		return sqlSessionFactory.openSession().delete("Person.deletePerson", pid);
	}

}
