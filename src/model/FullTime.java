package model;

public class FullTime extends Employee {
   private int workDayFullTime;

    public FullTime(String id, String name, String dateOfBirth, double salary, int workDayFullTime) {
        super(id, name, dateOfBirth, salary);
        this.workDayFullTime = workDayFullTime;
    }

    public int getWorkDayFullTime() {
        return workDayFullTime;
    }

    public void setWorkDayFullTime(int workDayFullTime) {
        this.workDayFullTime = workDayFullTime;
    }

    @Override
    double getSalarynv() {
        return workDayFullTime * 1200.000 +800.000;
    }

    @Override
    public void showInfor() {
    }
}

