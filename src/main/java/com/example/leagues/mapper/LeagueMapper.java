package com.example.leagues.mapper;

import com.example.leagues.dto.LeagueDTO;
import com.example.leagues.model.Country;
import com.example.leagues.model.League;
import com.example.leagues.model.Sport;
import com.example.leagues.repository.CountryRepository;
import com.example.leagues.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class LeagueMapper {

    @Autowired
    private static CountryRepository countryRepository;

    @Autowired
    private static SportRepository sportRepository;

    public static LeagueDTO toDTO(League league) {
        LeagueDTO leagueDTO = new LeagueDTO();
        leagueDTO.setId(league.getId());
        leagueDTO.setName(league.getName());
        System.out.println(league.getCountry().getId());
        leagueDTO.setCountryId(league.getCountry().getId());
        leagueDTO.setSportId(league.getSport().getId());
        return leagueDTO;
    }

    public static League toEntity(LeagueDTO leagueDTO) {
        League league = new League();
        league.setId(leagueDTO.getId());
        league.setName(leagueDTO.getName());

        Country country = countryRepository.findById(leagueDTO.getCountryId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid country Id:" + leagueDTO.getCountryId()));

        Sport sport = sportRepository.findById(leagueDTO.getSportId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid sport Id:" + leagueDTO.getSportId()));

        league.setCountry(country);
        league.setSport(sport);
        return league;
    }
}
