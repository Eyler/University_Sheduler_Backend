package sheduler.model.bean;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "student_group")
public class StudentGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "group_ID")
	private int groupID;
	
	@Column(name = "group_name")
	private String groupName;
	
	@Column(name = "institute")
	private String institute;
	
	@Column(name = "shedule")
	private String shedule;
	
	@OneToMany(mappedBy = "groupID", fetch = FetchType.LAZY)
	@Cascade({CascadeType.SAVE_UPDATE})
	private Set<Person> students;
	
	@ManyToMany
	@Cascade({CascadeType.SAVE_UPDATE})
	@JoinTable(name = "group_auditorium", joinColumns = { @JoinColumn(name = "group_ID") }, inverseJoinColumns = { @JoinColumn(name = "Aud_ID") })  
	private Set<Auditorium> auditoriums;

	@ManyToMany
	@Cascade({CascadeType.SAVE_UPDATE})
	@JoinTable(name = "group_events", joinColumns = { @JoinColumn(name = "group_ID") }, inverseJoinColumns = { @JoinColumn(name = "event_ID") })  
	private Set<UniversityEvent> universityEvents;
	
	
	public StudentGroup() {
		
	}

	public StudentGroup(String groupName, String institute, String shedule) {
		super();
		this.groupName = groupName;
		this.institute = institute;
		this.shedule = shedule;
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

	public String getShedule() {
		return shedule;
	}

	public void setShedule(String shedule) {
		this.shedule = shedule;
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
	
	public Set<Auditorium> getAuditoriums() {
		return auditoriums;
	}

	public void setAuditoriums(Set<Auditorium> auditoriums) {
		this.auditoriums = auditoriums;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auditoriums == null) ? 0 : auditoriums.hashCode());
		result = prime * result + groupID;
		result = prime * result + ((groupName == null) ? 0 : groupName.hashCode());
		result = prime * result + ((institute == null) ? 0 : institute.hashCode());
		result = prime * result + ((shedule == null) ? 0 : shedule.hashCode());
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
		if (auditoriums == null) {
			if (other.auditoriums != null)
				return false;
		} else if (!auditoriums.equals(other.auditoriums))
			return false;
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
		if (shedule == null) {
			if (other.shedule != null)
				return false;
		} else if (!shedule.equals(other.shedule))
			return false;
		if (students == null) {
			if (other.students != null)
				return false;
		} else if (!students.equals(other.students))
			return false;
		return true;
	}

	
}
