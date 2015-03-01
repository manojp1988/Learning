package demo.app.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import demo.app.entities.Student;
import demo.app.utilities.AppHelper;

public class StudentDAO {



  public String insertStudent(Student student) {
    Session session = AppHelper.getInstance().getAppSession();
    Transaction t = session.beginTransaction();
    session.save(student);
    t.commit();
    session.close();
    return "success";
  }

  public List<Student> getStudents() {
    Session session = AppHelper.getInstance().getAppSession();
    Transaction t = session.beginTransaction();
    List<Student> students = session.createQuery("FROM Student").list();
    System.out.println(students);
    return students;
  }

  public Student getFirstStudent() {
    Session session = AppHelper.getInstance().getAppSession();
    Transaction t = session.beginTransaction();
    Student student = (Student) session.createQuery("FROM Student").list().get(0);
    System.out.println(student);
    return student;
  }

}
