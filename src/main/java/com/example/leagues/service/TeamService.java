package com.example.leagues.service;

import com.example.leagues.dto.TeamDTO;
import com.example.leagues.mapper.TeamMapper;
import com.example.leagues.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<TeamDTO> getTeams() {
        return teamRepository.findAll().stream()
        .map(TeamMapper::toDTO)
        .collect(Collectors.toList());
    }

    public TeamDTO getTeamById(Long id) {
        return TeamMapper.toDTO(Objects.requireNonNull(teamRepository.findById(id).orElse(null)));
    }

    public TeamDTO saveTeam(TeamDTO teamDTO) {
        return TeamMapper.toDTO(teamRepository.save(TeamMapper.toEntity(teamDTO)));
    }

    public TeamDTO updateTeam(Long id, TeamDTO teamDTO) {
        teamDTO.setId(id);
        return TeamMapper.toDTO(teamRepository.save(TeamMapper.toEntity(teamDTO)));
    }

    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }

}
