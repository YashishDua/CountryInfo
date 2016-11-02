package com.example.lenovo.countryinfo;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Lenovo on 10-07-2016.
 */
public class ContentResponse {



    @SerializedName("capital")
             String Country_capital ;

    @SerializedName("region")
    String Country_region ;

    @SerializedName("name")
    String Country_name ;

    @SerializedName("population")
    String Country_population ;


    @SerializedName("timezones")
    ArrayList<String> TimeZone  = new ArrayList<>();



    public ContentResponse(String country_capital, String country_region, String country_name, String country_population) {
        Country_capital = country_capital;
        Country_region = country_region;
        Country_name = country_name;

        Country_population = country_population;
    }

    public ContentResponse(ArrayList<String> timeZone) {
        TimeZone = timeZone;
    }

    public ArrayList<String> getTimeZone() {
        return TimeZone;
    }

    public void setTimeZone(ArrayList<String> timeZone) {
        TimeZone = timeZone;
    }

    public String getCountry_capital() {
        return Country_capital;
    }

    public void setCountry_capital(String country_capital) {
        Country_capital = country_capital;
    }

    public String getCountry_region() {
        return Country_region;
    }

    public void setCountry_region(String country_region) {
        Country_region = country_region;
    }

    public String getCountry_name() {
        return Country_name;
    }

    public void setCountry_name(String country_name) {
        Country_name = country_name;
    }

    public String getCountry_population() {
        return Country_population;
    }

    public void setCountry_population(String country_population) {
        Country_population = country_population;
    }
}



