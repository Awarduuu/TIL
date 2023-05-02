package db.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmpDTO {
  private int empno;
  private String empName;//db는 ename
  private String job;
  private int sal;
  private String hiredate;
  
}
