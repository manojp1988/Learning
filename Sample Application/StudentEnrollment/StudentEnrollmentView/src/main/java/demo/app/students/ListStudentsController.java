package demo.app.students;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import demo.app.entities.Student;


@Controller
public class ListStudentsController {

  @RequestMapping(value = "/listStudents", method = RequestMethod.GET)
  public String getStudents(Model model) {

    RestTemplate restTemplate = new RestTemplate();
    String students =
        restTemplate.getForObject("http://localhost:8080/StudentEnrollService/listStudents",
            String.class);

    try {
      Student[] student = new Gson().fromJson(students, Student[].class);
      model.addAttribute("students", student);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return "summary";
  }

  @RequestMapping(value = "/userForm", method = RequestMethod.GET)
  public String viewRegistration(Map<String, Object> model) {
    Student userForm = new Student();
    model.put("userForm", userForm);

    return "Enrollment";
  }

  @RequestMapping(value = "/add", method = RequestMethod.POST)
  public String addStudents(@ModelAttribute("userForm") Student student, Map<String, Object> model) {
    System.out.println(student.getName());
    RestTemplate restTemplate = new RestTemplate();
    Map<String, String> vars = new HashMap<String, String>();
    vars.put("content-type", "application/json");
    String addStudent = new Gson().toJson(student);
    System.out.println(addStudent);
    String url = "http://localhost:8080/StudentEnrollService/addStudent";
    //String students = restTemplate.postForObject(url, addStudent, String.class, vars);

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<String> entity = new HttpEntity<String>(addStudent, headers);
    ResponseEntity<String> loginResponse =  restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
    return "redirect:listStudents";
  }
}
