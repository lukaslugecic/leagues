package com.example.leagues.mapper;

import com.example.leagues.dto.LeagueDTO;
import com.example.leagues.model.League;

public class LeagueMapper {

    public static LeagueDTO toDTO(League league) {
        LeagueDTO leagueDTO = new LeagueDTO();
        leagueDTO.setId(league.getId());
        leagueDTO.setName(league.getName());
        leagueDTO.setCountryId(league.getCountry().getId());
        leagueDTO.setSportId(league.getSport().getId());
        return leagueDTO;
    }

    public static League toEntity(LeagueDTO leagueDTO) {
        League league = new League();
        league.setId(leagueDTO.getId());
        league.setName(leagueDTO.getName());
        // how to set country and sport?
        league.setCountry(null);
        league.setSport(null);
        return league;
    }
}
