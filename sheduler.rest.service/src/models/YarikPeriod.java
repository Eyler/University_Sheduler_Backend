package models;

/**
 * Created by ykoby_000 on 09.05.2014.
 */
public class YarikPeriod {
    private String day;
    private int number;
    private String discipline;
    private YarikAuditorium auditorium;
    private String lecturer;

    public YarikPeriod(String day, int number, String discipline, YarikAuditorium auditorium, String lecturer) {
        this.day = day;
        this.number = number;
        this.discipline = discipline;
        this.auditorium = auditorium;
        this.lecturer = lecturer;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public YarikAuditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(YarikAuditorium auditorium) {
        this.auditorium = auditorium;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        YarikPeriod period = (YarikPeriod) o;

        if (number != period.number) return false;
        if (auditorium != null ? !auditorium.equals(period.auditorium) : period.auditorium != null) return false;
        if (day != null ? !day.equals(period.day) : period.day != null) return false;
        if (discipline != null ? !discipline.equals(period.discipline) : period.discipline != null) return false;
        if (lecturer != null ? !lecturer.equals(period.lecturer) : period.lecturer != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = day != null ? day.hashCode() : 0;
        result = 31 * result + number;
        result = 31 * result + (discipline != null ? discipline.hashCode() : 0);
        result = 31 * result + (auditorium != null ? auditorium.hashCode() : 0);
        result = 31 * result + (lecturer != null ? lecturer.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Period{" +
                "day='" + day + '\'' +
                ", number=" + number +
                ", discipline='" + discipline + '\'' +
                ", auditorium=" + auditorium +
                ", lecturer='" + lecturer + '\'' +
                '}';
    }
}
