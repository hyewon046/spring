package springmember.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import springmember.model.Member;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	//연결하려면 datesource가 필요한데 applicationContext에 datasource를 만들고 jdbctemplate을 만들어?놔서 이거는 필요없어짐
//	@Autowired
//	public void setDataSource(DataSource dataSource) {
//		this.jdbcTemplate = new JdbcTemplate(dataSource);
//	}

	@Override
	public List<Member> selectMember() {
		
		//강제적으로 예외를 발생시켜봄
		//int result = 10/0;
		
		String sql = " select * from springmember ";
		return jdbcTemplate.query(sql, new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member(
						rs.getString("mid"),
						rs.getString("mname"),
						rs.getString("mgender"),
						rs.getString("mcity")
				);
				return member;
			}
		});
	}
	
	@Override
	@Deprecated
	public Member getMember(String mid) {
		String sql = " select * from springmember where mid = ? ";
		return jdbcTemplate.queryForObject(sql, new Object[] {mid},new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member(
						rs.getString("mid"),
						rs.getString("mname"),
						rs.getString("mgender"),
						rs.getString("mcity")
				);
				return member;
			}
		});
	}
	
	@Override
	public int insertMember(Member member) {
		String sql = " insert into springmember values (?, ?, ?, ?) ";
		int result =jdbcTemplate.update(
				sql, member.getMid(), member.getMname(), member.getMgender(), member.getMcity());
		return result;
	}
	
	@Override
	public int updateMember(Member member) {
		String sql = " update springmember set mname= ?, mcity=? where mid =? ";
		int result = jdbcTemplate.update(
				sql, member.getMname(), member.getMcity(), member.getMid());
		return result;
	}
	
	@Override
	public int deleteMember(String mid) {
		String sql = " delete springmember where mid = ? ";
		return jdbcTemplate.update(sql, mid);
	}

}
