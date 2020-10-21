package com.gmstandingssim.gmstandingsapi.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GmApiResponseDTO {

    private List<TournamentDTO> requestedSeasonTournaments;

    private SeasonTimeDTO seasonEnd;

//    @Override
//    public String toString() {
//        return "GmApiResponse{" +
//                " seasonEnd='" + seasonEnd + '\'' +
//                '}';
//    }

}
