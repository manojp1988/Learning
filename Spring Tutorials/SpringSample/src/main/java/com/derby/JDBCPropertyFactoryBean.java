package com.derby;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

public class JDBCPropertyFactoryBean extends AbstractFactoryBean<Properties> {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Class<?> getObjectType() {
		return Properties.class;
	}

	@Override
	protected Properties createInstance() throws Exception {
		
		final Properties props = new Properties();
		jdbcTemplate.query("SELECT PROP_KEY, PROP_VALUE FROM APP.CONFIG", new RowCallbackHandler() {
			
			public void processRow(ResultSet rs) throws SQLException {
					props.put(rs.getString(1), rs.getString(2));
			}
		});
		return props;
	}

}
