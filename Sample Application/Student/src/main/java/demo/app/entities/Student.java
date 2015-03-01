package demo.app.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
@javax.persistence.Table(name = "STUDENT")
public class Student implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -443186180348743959L;


  @EmbeddedId
  Student_pk pk;

  @Column(name = "Name")
  private String name;



  @Column(name = "Phone")
  private String phone;



  public Student_pk getPk() {
    return pk;
  }



  public void setPk(Student_pk pk) {
    this.pk = pk;
  }



  public String getName() {
    return name;
  }



  public void setName(String name) {
    this.name = name;
  }



  public String getPhone() {
    return phone;
  }



  public void setPhone(String phone) {
    this.phone = phone;
  }



  @Override
  public String toString() {
    return "Student [pk=" + pk + ", name=" + name + ", phone=" + phone + "]";
  }




}
