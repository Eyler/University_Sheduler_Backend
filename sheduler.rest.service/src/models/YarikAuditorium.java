package models;

/**
 * Created by ykoby_000 on 09.05.2014.
 */
public class YarikAuditorium {
    private String location;
    private String number;
    private boolean isReserverd;

    public YarikAuditorium(String location, String number, boolean isReserverd) {
        this.location = location;
        this.number = number;
        this.isReserverd = isReserverd;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isReserverd() {
        return isReserverd;
    }

    public void setReserverd(boolean isReserverd) {
        this.isReserverd = isReserverd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        YarikAuditorium that = (YarikAuditorium) o;

        if (isReserverd != that.isReserverd) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = location != null ? location.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (isReserverd ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Auditorium{" +
                "location='" + location + '\'' +
                ", number='" + number + '\'' +
                ", isReserverd=" + isReserverd +
                '}';
    }
}
