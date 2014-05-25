package models.page_objects;

import models.Period;

import java.util.List;

/**
 * Created by ykoby_000 on 25.05.2014.
 */
public class Lecturer {
    private String department;
    private String credentials;
    private List<Period> schedule;

    public Lecturer(String department, String credentials, List<Period> schedule) {
        this.department = department;
        this.credentials = credentials;
        this.schedule = schedule;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
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

        Lecturer lecturer = (Lecturer) o;

        if (credentials != null ? !credentials.equals(lecturer.credentials) : lecturer.credentials != null)
            return false;
        if (department != null ? !department.equals(lecturer.department) : lecturer.department != null) return false;
        if (schedule != null ? !schedule.equals(lecturer.schedule) : lecturer.schedule != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = department != null ? department.hashCode() : 0;
        result = 31 * result + (credentials != null ? credentials.hashCode() : 0);
        result = 31 * result + (schedule != null ? schedule.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return department + "\n" + credentials + "\n\t" + schedule +
                '}';
    }
}
