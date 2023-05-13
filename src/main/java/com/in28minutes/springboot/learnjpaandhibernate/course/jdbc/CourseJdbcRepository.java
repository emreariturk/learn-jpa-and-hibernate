package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//repository olarak db erişimi sağladık
@Repository
public class CourseJdbcRepository {
    //Autowired olarak private db erişimi tanımı yapıldı
    @Autowired
    private JdbcTemplate jdbcTemplate;


    //insert scripti tanımladık
    private static String INSERT_QUERY= """
            insert into course(id,name,author) values(1,'learn aws','in28minutes');
            """;

    private static String INSERT_QUERY_WITH_ENTITY= """
            insert into course(id,name,author) values(?,?,?);
            """;

    private static String DELETE_QUERY="Delete from course where id=?";

    private static String SELECT_QUERY="select * from course where id=?";

    //insert eden kodu ekledik
    public void insert()
    {
        jdbcTemplate.update(INSERT_QUERY);
    }

    public void insert(Course course)
    {
        jdbcTemplate.update(INSERT_QUERY_WITH_ENTITY,course.getId(),course.getName(),course.getAuthor());
    }

    public void deleteById(Long id)
    {
        jdbcTemplate.update(DELETE_QUERY,id);
    }

    public Course selectById(Long id)
    {
        return jdbcTemplate.queryForObject(SELECT_QUERY,new BeanPropertyRowMapper<>(Course.class),id);
        //ResultSet -> course Bean -> Row Mapper
        //new BeanPropertyRowMapper<>(Course.class) vererek, dönen result un tam olarak bu nesneye çevrilmesini sağlıyoruz
    }

}
