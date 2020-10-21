package com.gmstandingssim.gmstandingsapi.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BracketDTO {
    private String name;
    private List<CompetitorDTO> competitors;
}
