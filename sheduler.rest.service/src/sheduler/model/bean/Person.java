package sheduler.model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@Column(name = "person_ID", nullable = true, updatable = true)
	private String personID;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "department")
	private String department;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@Cascade({CascadeType.ALL})
	@JoinColumn(name = "group_ID")
	private StudentGroup groupID;
	
	public Person(){
		
	}
	
	public Person(String personID, String role, String password, StudentGroup groupID) {
		super();
		this.personID = personID;
		this.role = role;
		this.password = password;
		this.groupID = groupID;
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

	@Override
	public String toString() {
		return "Person [personID=" + personID + ", role=" + role
				+ ", password=" + password + ", groupID=" + groupID + "]";
	}

	public String getPersonID() {
		return personID;
	}

	public void setPersonID(String personID) {
		this.personID = personID;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
