package com.solvd.deliveryservice.store;

public class OnlineStore extends Store{
    String url;

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
    public String workingTodayChecker(String currentDayOfTheWeek) {
        return "We are serving our customers 24/7!";
    }
}
