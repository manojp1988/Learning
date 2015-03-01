package demo.app.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Student_pk implements Serializable {
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  
  @Column(name="Id")
  private int id;

  @Column(name="Email")
  private String email;

  public int getId() {
    return id;
  }

  public void setId(int i) {
    this.id = i;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
  
  
}
