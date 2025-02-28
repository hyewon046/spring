package springmybatis.mapper;

import java.util.List;

import springmybatis.model.Person;

@MapperMarker
public interface PersonMapper {
	
	public abstract List<Person> getPersonList();
	
	public abstract Person getPerson(int pid);
	
	public abstract int insertPerson(Person person);
	
	public abstract int updatePerson(Person person);
	
	public abstract int deletePerson(int pid);

}
