package DTO;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "emp")
public class EmpDTO {
	
	@Id
	@Column(name = "empno")
	private int id;
	@Column(name = "ename")
	private String name;
	@Column(name = "job")
	private String designation;
	@Column(name = "bounty")
	private int salary;

}
