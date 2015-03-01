package demo.app.daos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.junit.Ignore;
import org.junit.Test;

import demo.app.entities.Student;
import demo.app.entities.Student_pk;
import demo.app.utilities.AppHelper;

public class StudentDaoTest {
  Session session;

  {
    session = AppHelper.getInstance().getAppSession();

  }
  @Test
  @Ignore
  public void checkConnection() {
    assertNotNull(session);
  }
  
  @Test
  @Ignore
  public void insertStudent(){
    Student_pk pk = new Student_pk();
    pk.setEmail("manojp1218@gmail.com");
    pk.setId(2);
    
    Student student = new Student();
    student.setName("Manoj");
    student.setPhone("704-779-4410");
    student.setPk(pk);

    String status = new StudentDAO().insertStudent(student);
    assertEquals("success", status);
  }
  
  @Test
  public void retrieveStudents(){
      Student student = new StudentDAO().getFirstStudent();
      System.out.println(student.getPk().getEmail());
  }
  
  
}
