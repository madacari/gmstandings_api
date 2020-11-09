package com.gmstandingssim.gmstandingsapi.services;

import com.gmstandingssim.gmstandingsapi.dtos.GmApiRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class GmPlayersService {
    public String getRequestUri(String season, String year) {
        String uri = "/";
        char parameterPrefix = '?';
        if (season != null) {
            uri = uri + "?season=" + season;
            parameterPrefix = '&';
        }
        if (year != null) {
            uri = uri + parameterPrefix + "year=" + year;
        }
        return uri;
    }
}
