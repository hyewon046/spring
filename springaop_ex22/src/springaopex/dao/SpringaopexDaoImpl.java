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
public class SpringaopexDaoImpl implements SpringaopexDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Springaopex> selectSpringaopex() {
		String sql = " select * from springaopex order by sid desc ";
		return jdbcTemplate.query(sql, new RowMapper<Springaopex>() {
			@Override
			public Springaopex mapRow(ResultSet rs, int rowNum) throws SQLException {
				Springaopex springaopex = new Springaopex(rs.getInt("sid"), rs.getString("spass"));
				return springaopex;
			}
		});
	}

	@Override
	public Springaopex getSpringaopex(int sid) {
		String sql = " select * from springaopex where sid=? ";
		return jdbcTemplate.queryForObject(sql, new RowMapper<Springaopex>() {
			@Override
			public Springaopex mapRow(ResultSet rs, int rowNum) throws SQLException {
				Springaopex springaopex = new Springaopex(rs.getInt("sid"), rs.getString("spass"));
				return springaopex;
			}
		}, sid);
	}

	@Override
	public int insertSpringaopex(Springaopex springaopex) {
		String sql = " insert into springaopex values(seq_springaopex.nextval, ?) ";
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
