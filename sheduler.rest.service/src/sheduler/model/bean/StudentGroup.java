package sheduler.model.bean;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "student_group")
public class StudentGroup {

	@Id
	@Column(name = "group_ID")
	private int groupID;
	
	@Column(name = "group_name")
	private String groupName;
	
	@Column(name = "institute")
	private String institute; 
	
	@OneToMany(mappedBy = "groupID", fetch = FetchType.EAGER)
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.REPLICATE})
	private Set<Person> students;

	public StudentGroup() {
		
	}

	public StudentGroup(String groupName, String institute) {
		super();
		this.groupName = groupName;
		this.institute = institute;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getInstitute() {
		return institute;
	}

	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public Set<Person> getStudents() {
		return students;
	}

	public void setStudents(Set<Person> students) {
		this.students = students;
	}

	public int getGroupID() {
		return groupID;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + groupID;
		result = prime * result + ((groupName == null) ? 0 : groupName.hashCode());
		result = prime * result + ((institute == null) ? 0 : institute.hashCode());
		result = prime * result + ((students == null) ? 0 : students.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentGroup other = (StudentGroup) obj;
		if (groupID != other.groupID)
			return false;
		if (groupName == null) {
			if (other.groupName != null)
				return false;
		} else if (!groupName.equals(other.groupName))
			return false;
		if (institute == null) {
			if (other.institute != null)
				return false;
		} else if (!institute.equals(other.institute))
			return false;
		if (students == null) {
			if (other.students != null)
				return false;
		} else if (!students.equals(other.students))
			return false;
		return true;
	}

	
}
