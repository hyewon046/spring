package springaopex.dao;

import java.util.List;

import springaopex.model.Springaopex;

public interface SpringaopexDao {
	
	public abstract List<Springaopex> selectSpringaopex();
	
	public abstract Springaopex getSpringaopex(int sid);
	
	public abstract int insertSpringaopex(Springaopex springaopex);
	
	public abstract int updateSpringaopex(Springaopex springaopex);
	
	public abstract int deleteSpringaopex(int sid);

}
