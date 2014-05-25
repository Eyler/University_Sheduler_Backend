package models;

import java.util.List;

/**
 * Created by ykoby_000 on 09.05.2014.
 */
public class StudentGroup {
    private String groupName;
    private String institute;
    private List<Period> schedule;

    public StudentGroup(String groupName, String institute, List<Period> schedule) {
        this.groupName = groupName;
        this.institute = institute;
        this.schedule = schedule;
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

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public List<Period> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Period> schedule) {
        this.schedule = schedule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentGroup that = (StudentGroup) o;

        if (groupName != null ? !groupName.equals(that.groupName) : that.groupName != null) return false;
        if (institute != null ? !institute.equals(that.institute) : that.institute != null) return false;
        if (schedule != null ? !schedule.equals(that.schedule) : that.schedule != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = groupName != null ? groupName.hashCode() : 0;
        result = 31 * result + (institute != null ? institute.hashCode() : 0);
        result = 31 * result + (schedule != null ? schedule.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StudentGroup{" +
                "groupName='" + groupName + '\'' +
                ", institute='" + institute + '\'' +
                ", schedule=" + schedule +
                '}';
    }
}
