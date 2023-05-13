package com.in28minutes.springboot.learnjpaandhibernate.course.jpa;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import com.in28minutes.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJpaCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseSpringDataJpaRepository courseSpringDataJpaRepository;

    @Autowired
    private CourseJpaRepository courseJpaRepository;

    //açışışta çalışması için buraya ekleme yaptık
    @Override
    public void run(String... args) throws Exception {

        /*
        CourseJpaRepository kaldırılıp mainRepo olan CourseSpringDataJpaRepository tanımlandığında,
        artık veriler için courseJpaRepository içinde özel insert yazmaktansa, doğrudan CourseSpringDataJpaRepository
        içindeki save kullanılabilir.
        aşağıdaki kapalı blok courseJpaRepository un çaılması içindir.
        courseJpaRepository class olarak tanımlanır. ancak CourseSpringDataJpaRepository interfacedir ve ana jparepo dan türer
        courseJpaRepository class olduğu için entitymanager ile db ye bağlanmak durumunda kalıyoruz
        ancak CourseSpringDataJpaRepository ile sadece nesne ismini vererek herhangi bir db connection yönetimi yapmıyoruz
         */

        /*
        courseJpaRepository.insert(new Course(3L,"Amazon Ws","Ömer"));

        Course course=courseJpaRepository.findById(1L);
        System.out.println(course);
*/
        //Course nesnesine @Entity bu işlerden sonra eklendi

        courseSpringDataJpaRepository.save(new Course(4L,"Amazon Ws","Ömer"));

    }
}
