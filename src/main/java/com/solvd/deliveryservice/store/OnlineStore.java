package com.solvd.deliveryservice.store;

import com.solvd.deliveryservice.enums.BusinessWeek;
import com.solvd.deliveryservice.exceptions.InvalidDayOfTheWeekException;
import com.solvd.deliveryservice.exceptions.InvalidDiscountException;
import com.solvd.deliveryservice.person.Person;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class OnlineStore extends Store{
    private String url;
    private final static Logger LOGGER = LogManager.getLogger(OnlineStore.class);


    public OnlineStore(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    // uses class type enum
    public String workingTodayChecker(String day) {
        BusinessWeek inputDay = null;
        switch (StringUtils.upperCase(day)) {
            case "MONDAY":
                inputDay = BusinessWeek.MONDAY;
                break;

            case "TUESDAY":
                inputDay = BusinessWeek.TUESDAY;
                break;
            case "WEDNESDAY":
                inputDay = BusinessWeek.WEDNESDAY;
                break;

            case "THURSDAY":
                inputDay = BusinessWeek.THURSDAY;
                break;
            case "FRIDAY":
                inputDay = BusinessWeek.FRIDAY;
                break;

            case "SATURDAY":
                inputDay = BusinessWeek.SATURDAY;
                break;

            case "SUNDAY":
                inputDay = BusinessWeek.SUNDAY;
                break;
        }

        if (inputDay == null) {
            throw new InvalidDayOfTheWeekException("String type day of the week must be provided");
        } else {
            return "We are working 7 days a week";
        }
    }
}