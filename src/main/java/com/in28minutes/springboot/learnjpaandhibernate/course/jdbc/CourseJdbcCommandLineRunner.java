package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner
{
    //CommandLineRunner, spring ayağa kalkarken çalışasını sağlar
    //ayağa kalkarken bean oluşması için Autowired tsnımı yaptık ve
    @Autowired
    private CourseJdbcRepository courseJdbcRepository;

    //açışışta çalışması için buraya ekleme yaptık
    @Override
    public void run(String... args) throws Exception {

        courseJdbcRepository.insert();

        courseJdbcRepository.insert(new Course(2L,"C#","Emre"));

        Course course=courseJdbcRepository.selectById(1L);
        System.out.println(course);

        //Course nesnesine @Entity bu işlerden sonra eklendi
    }

}
