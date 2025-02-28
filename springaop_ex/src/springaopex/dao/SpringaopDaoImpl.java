package springaopex.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import springaopex.model.Springaopex;

@Repository
public class SpringaopDaoImpl implements SpringaopexDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Springaopex> selectSpringaopex() {
		String sql = " select * from springaopex ";
		return jdbcTemplate.query(sql, new RowMapper<Springaopex>() {
			@Override
			public Springaopex mapRow(ResultSet rs, int rowNum) throws SQLException {
				Springaopex springaopex = new Springaopex(
						rs.getInt("sid"),
						rs.getString("spass")
				);
				return springaopex;
			}
		});
	}
	
	@Override
	@Deprecated
	public Springaopex getSpringaopex(int sid) {
		String sql = " select * from springaopex where sid = ? ";
		return jdbcTemplate.queryForObject(sql, new Object[] {sid}, new RowMapper<Springaopex>() {
			@Override
			public Springaopex mapRow(ResultSet rs, int rowNum) throws SQLException {
				Springaopex springaopex = new Springaopex(
						rs.getInt("sid"),
						rs.getString("spass")
				);
				return springaopex;
			}
		});
	}
	@Override
	public int insertSpringaopex(Springaopex springaopex) {
		String sql = " insert into springaopex values (seq_springaopex.nextval, ?) ";
		return jdbcTemplate.update(sql, springaopex.getSpass());
	}
	
	@Override
	public int updateSpringaopex(Springaopex springaopex) {
		String sql = " update springaopex set spass=? where sid=? ";
		return jdbcTemplate.update(sql, springaopex.getSpass(), springaopex.getSid());
	}
	@Override
	public int deleteSpringaopex(int sid) {
		String sql = " delete springaopex where sid=? ";
		return jdbcTemplate.update(sql, sid);
	}

}
