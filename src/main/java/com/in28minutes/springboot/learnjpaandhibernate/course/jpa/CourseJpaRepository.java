package com.in28minutes.springboot.learnjpaandhibernate.course.jpa;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional //eğer entityManager kullanılacaksa, transaction açılması ve yönetilmesi için bu annot kullanılmalı
public class CourseJpaRepository {
    //course classına @entity eklendikten sonra db işlemleri için entityManager kullanılır

    //@Autowired yerine
    @PersistenceContext
    /*
    Persistence Context, entity nesnelerini ve entity lifecycleını (yaşam döngüsü) yöneten yapıdır.
    Veritabanı ve uygulama arasındadır. Persistence Context, entity nesnelerinin referanslarını tutar.
    JPA’da EntityManager, Hibernate’de Session nesnesinin içerisinde Persistence Context internal (dahili)
    bir yapı olarak yer almaktadır.
    Persistence Context’de bulunan entitylere sonraki erişimlerde veritabanına gidilmez
    aynı entity referansı uygulamaya geri döndürülür. First level cache (birincil önbellek) olarak da bilinir.
     */
    private EntityManager entityManager;

    public void insert(Course course)
    {
        entityManager.merge(course); // merge ile alanları db ile eşleştirir ve kaydeder
    }

    public Course findById(Long id)
    {
        return entityManager.find(Course.class,id); //böylece direk class tipini merge edebildi
    }
    public void deleteById(Long id)
    {
        Course course= entityManager.find(Course.class,id); //önce nesneyi ara, bul
        entityManager.remove(course); // sonra direk remove et
    }
}
