package DAO;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class StudenDao {
	@Id
	private int id;
	private String name;
	private String mail;
	private int marks;
	private String add;
	
	

}


