package com.gmstandingssim.gmstandingsapi.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchDTO {
    private List<CompetitorInfoDTO> competitors;
    private CompetitorInfoDTO winner;
    private String timeZone;
    private Date startDate;
}
