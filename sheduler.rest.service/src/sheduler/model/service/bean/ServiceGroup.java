package sheduler.model.service.bean;

import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ServiceGroup {

	private int groupID;
	
	private String groupName;

	private String institute; 
	
	private Set<ServicePerson> students;
	
	private Set<ServiceAuditorium> auditoriums;

	public ServiceGroup() {
		
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

	public Set<ServicePerson> getStudents() {
		return students;
	}

	public void setStudents(Set<ServicePerson> students) {
		this.students = students;
	}

	public int getGroupID() {
		return groupID;
	}
	
	public Set<ServiceAuditorium> getAuditoriums() {
		return auditoriums;
	}

	public void setAuditoriums(Set<ServiceAuditorium> auditoriums) {
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
		ServiceGroup other = (ServiceGroup) obj;
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
		if (students == null) {
			if (other.students != null)
				return false;
		} else if (!students.equals(other.students))
			return false;
		return true;
	}

}
