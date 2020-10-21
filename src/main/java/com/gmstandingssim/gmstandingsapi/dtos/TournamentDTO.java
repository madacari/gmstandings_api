package com.gmstandingssim.gmstandingsapi.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TournamentDTO {
    private String title;
    private String region;
    private List<StageDTO> stages;
}
