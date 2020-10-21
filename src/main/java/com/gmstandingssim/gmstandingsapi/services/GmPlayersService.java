package com.gmstandingssim.gmstandingsapi.services;

import com.gmstandingssim.gmstandingsapi.dtos.GmApiRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class GmPlayersService {
    public String getRequestUri(GmApiRequestDTO gmApiRequestDTO) {
        String uri = "/";
        char parameterPrefix = '?';
        if (gmApiRequestDTO!= null) {
            if (gmApiRequestDTO.getSeason() != null) {
                uri = uri + "?season=" + gmApiRequestDTO.getSeason();
                parameterPrefix = '&';
            }
            if (gmApiRequestDTO.getYear() != null) {
                uri = uri + parameterPrefix + "year=" + gmApiRequestDTO.getYear();
            }
        }
        return uri;
    }
}
