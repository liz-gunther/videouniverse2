package jpa.service;

import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import java.util.List;

public class CourseService implements CourseDAO {

    @Override
    public List<Course> getAllCourses() {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        String hql = "FROM course c";
        TypedQuery query = session.createQuery(hql);
        List<Course> results = query.getResultList();

        factory.close();
        session.close();
        return results;
    }

    public Course getCourseById(int cId) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Course course = session.get(Course.class, cId);
        factory.close();
        session.close();
        return course;
    }
}
