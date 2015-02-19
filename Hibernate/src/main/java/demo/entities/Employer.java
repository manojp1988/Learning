package demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Employer {

  @Id
  @GeneratedValue
  private int id;
  private String name;
  @OneToMany(mappedBy="employer", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
  private List<Employee> employees;

}
