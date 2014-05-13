package sheduler.model.service.bean.builder;

import java.util.HashSet;
import java.util.Set;

import sheduler.model.bean.Person;
import sheduler.model.bean.StudentGroup;
import sheduler.model.service.bean.ServiceGroup;
import sheduler.model.service.bean.ServicePerson;

public class GroupBuilder {

	private StudentGroup group;

	private Set<ServicePerson> students;

	public GroupBuilder(StudentGroup group) {
		this.group = group;
	}

	public ServiceGroup build() {
		ServiceGroup serviceGroup = new ServiceGroup();
		serviceGroup.setGroupID(group.getGroupID());
		serviceGroup.setGroupName(group.getGroupName());
		serviceGroup.setInstitute(group.getInstitute());
		students = new HashSet<>();
		for (Person p : group.getStudents()) {
			students.add(new PersonBuilder().buildServicePerson(p));
		}
		serviceGroup.setStudents(students);
		return serviceGroup;

	}
}
