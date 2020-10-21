package com.gmstandingssim.gmstandingsapi.dtos;

import lombok.Data;

import java.util.List;

@Data
public class GmPlayersResponseDTO {
    private String tournamentTitle;
    private String region;
    private String stage;
    private String group;
    List<String> players;
}
