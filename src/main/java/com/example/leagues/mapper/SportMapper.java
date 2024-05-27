package com.example.leagues.mapper;

import com.example.leagues.dto.SportDTO;
import com.example.leagues.model.Sport;

public class SportMapper {

    public static SportDTO toDTO(Sport sport) {
        SportDTO sportDTO = new SportDTO();
        sportDTO.setId(sport.getId());
        sportDTO.setName(sport.getName());
        return sportDTO;
    }

    public static Sport toEntity(SportDTO sportDTO) {
        Sport sport = new Sport();
        sport.setId(sportDTO.getId());
        sport.setName(sportDTO.getName());
        return sport;
    }
}
