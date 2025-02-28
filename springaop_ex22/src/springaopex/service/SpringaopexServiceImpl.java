package springaopex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springaopex.dao.SpringaopexDao;
import springaopex.model.Springaopex;

@Service
public class SpringaopexServiceImpl implements SpringaopexService {
	
	@Autowired
	private SpringaopexDao springaopexDao;

	@Override
	public List<Springaopex> selectSpringaopex() {
		return springaopexDao.selectSpringaopex();
	}

	@Override
	public Springaopex getSpringaopex(int sid) {
		return springaopexDao.getSpringaopex(sid);
	}

	@Override
	public int insertSpringaopex(Springaopex springaopex) {
		return springaopexDao.insertSpringaopex(springaopex);
	}

	@Override
	public int updateSpringaopex(Springaopex springaopex) {
		return springaopexDao.updateSpringaopex(springaopex);
	}

	@Override
	public int deleteSpringaopex(int sid) {
		return springaopexDao.deleteSpringaopex(sid);
	}

}
