package sheduler.model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;



@Entity
@Table(name = "person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "person_ID")
	private int personID;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "password")
	private String password;
	
	@ManyToOne
	@Cascade({CascadeType.SAVE_UPDATE})
	@JoinColumn(name = "group_ID")
	private StudentGroup groupID;
	
	public int getPersonID() {
		return personID;
	}

	public Person(String role, String password, StudentGroup groupID) {
		super();
		this.role = role;
		this.password = password;
		this.groupID = groupID;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public StudentGroup getGroupID() {
		return groupID;
	}

	public void setGroupID(StudentGroup groupID) {
		this.groupID = groupID;
	}

}
