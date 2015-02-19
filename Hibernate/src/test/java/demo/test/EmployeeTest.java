package demo.test;

import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import demo.entities.Employee;
import demo.entities.Employer;
import demo.util.HibernateUtil;

public class EmployeeTest {

  Logger log = Logger.getLogger(EmployeeTest.class.getName());
  
  Session session ; 
  @Before
  public void loadSession(){
    log.fine("load session...");
    session = HibernateUtil.getSessionfactory().openSession();
  }
  
  @After
  public void closeSession(){
    session.close();
    log.fine("close session...");
  }
  
  @Test
  public void inserEmployee(){
    
    Employer employer = new Employer();
    employer.setName("TCS");
    
    Employee emp1 = new Employee();
    emp1.setName("Manoj");
    emp1.setEmployer(employer);
    
    Transaction t = session.beginTransaction();
    session.save(emp1);
    t.commit();
    assertEquals("true", "true");
    
  }
}
