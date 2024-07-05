package com.example.leagues.mapper;

import com.example.leagues.dto.TeamDTO;
import com.example.leagues.model.League;
import com.example.leagues.model.Team;
import com.example.leagues.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TeamMapper {

    @Autowired
    private static LeagueRepository leagueRepository;

    public static TeamDTO toDTO(Team team) {
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setId(team.getId());
        teamDTO.setName(team.getName());
        teamDTO.setYearOfEstablishment(team.getYearOfEstablishment());
        teamDTO.setLeagueId(team.getLeague().getId());
        return teamDTO;
    }

    public static Team toEntity(TeamDTO teamDTO) {
        Team team = new Team();
        team.setId(teamDTO.getId());
        team.setName(teamDTO.getName());
        team.setYearOfEstablishment(teamDTO.getYearOfEstablishment());

        League league = leagueRepository.findById(teamDTO.getLeagueId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid league Id:" + teamDTO.getLeagueId()));

        team.setLeague(league);
        return team;
    }
}
