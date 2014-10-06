package com.springtutorials.test1;
import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class CreateTableTest {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    /**
     * Initialize context and get the JdbcTemplate
     */
    ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    DataSource dataSource = (DataSource) appContext.getBean("dataSource");
    JdbcTemplate template = new JdbcTemplate(dataSource);

    /**
     * Create table.
     */
    template.execute("create table USERS (" +
        "id integer PRIMARY KEY, name varchar(60), " +
        "age integer, salary decimal )");
    
    System.out.println("Table created successfully");
  }

}