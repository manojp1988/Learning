package demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Employee {

  @Id
  @GeneratedValue
  private int id;
  private String name;

  @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
  private Employer employer;
  
}
