package com.gmstandingssim.gmstandingsapi.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class SeasonTimeDTO {
    private Date time;
    private String timeZone;

    @Override
    public String toString() {
        return "SeasonTime{" +
                "time='" + time + '\'' +
                ", timeZone=" + timeZone +
                '}';
    }
}
