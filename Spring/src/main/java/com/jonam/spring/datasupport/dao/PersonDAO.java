package com.jonam.spring.datasupport.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.jonam.spring.datasupport.model.Person;

@Repository
public class PersonDAO extends JdbcDaoSupport{
	
	public int getTotalNoofPerson(){
		String sql = "SELECT COUNT(*) FROM APP.PERSON";
		return this.getJdbcTemplate().queryForInt(sql);
	}
	
	public void addPerson(Person person){
		String sql = "INSERT INTO APP.PERSON (ID, NAME) VALUES(?,?)";
		this.getJdbcTemplate().update(sql, person.getId(), person.getName());
	}
	
	public Person getSinglePerson(int id){
		String sql = "SELECT * FROM APP.PERSON WHERE ID=?";
		return this.getJdbcTemplate().queryForObject(sql, new Object[]{id}, new PersonRowMapper());
	}
	
	public List<Person> getAllPerson(){
		String sql = "SELECT * FROM APP.PERSON";
		return this.getJdbcTemplate().query(sql, new PersonRowMapper());
	}
	
	private  static final class PersonRowMapper implements RowMapper<Person>{

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			person.setId(rs.getInt("ID"));
			person.setName(rs.getString("NAME"));
			return person;
		}
		
	}

}


