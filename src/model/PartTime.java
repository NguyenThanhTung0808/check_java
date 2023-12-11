package model;

public class PartTime extends Employee {
    private int workDayPartTime;

    public PartTime(String id, String name, String dateOfBirth, double salary, int workDay) {
        super(id, name, dateOfBirth, salary);
        this.workDayPartTime = workDay;
    }

    public int getWorkDayPartTime() {
        return workDayPartTime;
    }

    public void setWorkDayPartTime(int workDayPartTime) {
        this.workDayPartTime = workDayPartTime;
    }

    @Override
    double getSalarynv() {
        return workDayPartTime*500.000;
    }

    @Override
    public void showInfor() {

    }

}
