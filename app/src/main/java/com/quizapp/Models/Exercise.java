package com.quizapp.Models;

public class Exercise {
    private String title,device,unit,icon;
    private double count;

    public Exercise() {
    }

    public Exercise(String title, String device, String unit, String icon, double count) {
        this.title = title;
        this.device = device;
        this.unit = unit;
        this.icon = icon;
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }
}
