import au.com.bytecode.opencsv.CSVWriter;
import ch.qos.logback.core.net.AbstractSSLSocketAppender;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by manojperiathambi on 8/25/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan
public class OpenCSVWriterExample {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Before
    public void initTest(){
        Assert.assertNotNull(jdbcTemplate);
    }

    @Test
    public void test(){
        jdbcTemplate.query("select * from users", new ResultSetExtractor<Object>() {
            public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                String csv = "data.csv";
                try {
                    CSVWriter writer = new CSVWriter(new FileWriter(csv, true));
                    writer.writeAll(resultSet, true);
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });

    }

    @Configuration
    static class Config{
        @Bean
        public DataSource dataSource() {

            // no need shutdown, EmbeddedDatabaseFactoryBean will take care of this
            EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
            EmbeddedDatabase db = builder
                    .setType(EmbeddedDatabaseType.HSQL) //.H2 or .DERBY
                    .addScript("db/sql/create-db.sql")
                    .addScript("db/sql/insert-data.sql")
                    .build();
            return db;
        }

        @Bean
        public JdbcTemplate jdbcTemplate(){
            return new JdbcTemplate(dataSource());
        }
    }
}
