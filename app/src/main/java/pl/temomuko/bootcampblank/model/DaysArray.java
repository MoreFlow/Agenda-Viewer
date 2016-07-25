package pl.temomuko.bootcampblank.model;

public class DaysArray {

    private Day[] days;

    public Day[] getDays() {
        return days;
    }

    public void setDays(Day[] days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return "ClassPojo [days = " + days + "]";
    }
}