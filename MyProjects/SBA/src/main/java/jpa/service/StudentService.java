package jpa.service;

import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
import java.util.List;

public class StudentService implements StudentDAO {


    @Override
    public List<Student> getAllStudents() {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        String hql = "FROM Student s";
        TypedQuery query = session.createQuery(hql);
        List<Student> results = query.getResultList();

        factory.close();
        session.close();
        return results;

    }

    @Override
    public Student getStudentByEmail(String sEmail) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Student student = session.get(Student.class, sEmail);
        factory.close();
        session.close();
        return student;
    }

    @Override
    public boolean validateStudent(String sEmail, String sPass) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Student student = session.get(Student.class, sEmail);

        factory.close();
        session.close();

        try {
            if (sPass.equals(student.getsPass())) {
                return true;
            } else {
                return false;
            }
        } catch (NullPointerException e) {
            System.out.println("Student is null.");
            return false;
        }
    }

    @Override
    public void registerStudentToCourse(String sEmail, int cId) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        CourseService courseService = new CourseService();
        Course courseById = courseService.getCourseById(cId);
        List<Course> studentCourses = getStudentCourses(sEmail);

        if (!studentCourses.contains(courseById)) {
            Query query = session.createSQLQuery("INSERT into student_course (Student_email, sCourses_id) VALUES (:value1, :value2)");
            query.setParameter("value1", sEmail);
            query.setParameter("value2", cId);
            query.executeUpdate();
            tx.commit();
        } else {
            System.out.println("You are already registered.");
        }

        factory.close();
        session.close();
    }

    @Override
    public List<Course> getStudentCourses(String sEmail) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Student student = session.get(Student.class, sEmail);
        List<Course> courses = student.getsCourses();

        session.close();
        factory.close();
        return courses;
    }
}
