package com.solvd.deliveryservice.enums;

public enum BusinessWeek {
    MONDAY(true),
    TUESDAY(true),
    WEDNESDAY(true),
    THURSDAY(true),
    FRIDAY(true),
    SATURDAY(true),
    SUNDAY(false);

    private boolean  workingDay;

    private BusinessWeek(boolean workingDay){
        this.workingDay=workingDay;
    }

    public boolean isWorkingDay() {
        return workingDay;
    }
}
