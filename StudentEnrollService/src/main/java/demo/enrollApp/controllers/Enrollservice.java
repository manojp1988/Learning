package demo.enrollApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.app.daos.StudentDAO;
import demo.app.entities.Student;

@RestController
public class Enrollservice {

  @Autowired
  StudentDAO studentDao;

  @RequestMapping(value = "/listStudents", method = RequestMethod.GET
      )
  public List<Student> getStudents() {
    List<Student> students = studentDao.getStudents();
    return students;
  }

  @RequestMapping(value = "/firstStudent", method = RequestMethod.GET,
      produces = "application/json")
  public Student getFirstStudent() {
   
    Student student = studentDao.getFirstStudent();
    System.out.println(student.getPhone());
    return student;
  }


  @RequestMapping(value = "/addStudent", method = RequestMethod.POST,
      produces = "application/json", consumes = "application/json")
  public void addStudents(@RequestBody Student student) {
    System.out.println(student);
    studentDao.insertStudent(student);
  }

  
  
}
