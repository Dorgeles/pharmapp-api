package com.wdyapplications.pharmapp.utils.dto.es;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.wdyapplications.pharmapp.utils.contract.SearchParam;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class EsStatsBase {
    protected String id;
    protected String date;
    protected String status;

    protected String year;
    protected String month;
    protected String week;
    protected String day;
    protected String hour;

    protected String key;


    protected String period;
    protected String format;



    // Search param
    private SearchParam<String> id_param;
    private SearchParam<String> date_param;
    private SearchParam<String> status_param;
    private SearchParam<String> year_param;
    private SearchParam<String> month_param;
    private SearchParam<String> week_param;
    private SearchParam<String> day_param;
    private SearchParam<String> hour_param;


    protected String orderField;
    protected String orderDirection;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public SearchParam<String> getId_param() {
        return id_param;
    }

    public void setId_param(SearchParam<String> id_param) {
        this.id_param = id_param;
    }

    public SearchParam<String> getDate_param() {
        return date_param;
    }

    public void setDate_param(SearchParam<String> date_param) {
        this.date_param = date_param;
    }

    public SearchParam<String> getStatus_param() {
        return status_param;
    }

    public void setStatus_param(SearchParam<String> status_param) {
        this.status_param = status_param;
    }

    public SearchParam<String> getYear_param() {
        return year_param;
    }

    public void setYear_param(SearchParam<String> year_param) {
        this.year_param = year_param;
    }

    public SearchParam<String> getMonth_param() {
        return month_param;
    }

    public void setMonth_param(SearchParam<String> month_param) {
        this.month_param = month_param;
    }

    public SearchParam<String> getWeek_param() {
        return week_param;
    }

    public void setWeek_param(SearchParam<String> week_param) {
        this.week_param = week_param;
    }

    public SearchParam<String> getDay_param() {
        return day_param;
    }

    public void setDay_param(SearchParam<String> day_param) {
        this.day_param = day_param;
    }

    public SearchParam<String> getHour_param() {
        return hour_param;
    }

    public void setHour_param(SearchParam<String> hour_param) {
        this.hour_param = hour_param;
    }

    public String getOrderField() {
        return orderField;
    }

    public void setOrderField(String orderField) {
        this.orderField = orderField;
    }

    public String getOrderDirection() {
        return orderDirection;
    }

    public void setOrderDirection(String orderDirection) {
        this.orderDirection = orderDirection;
    }
}
