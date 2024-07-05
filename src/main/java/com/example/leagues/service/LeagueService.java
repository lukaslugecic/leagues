package com.example.leagues.service;

import com.example.leagues.dto.LeagueDTO;
import com.example.leagues.mapper.LeagueMapper;
import com.example.leagues.repository.CountryRepository;
import com.example.leagues.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.leagues.repository.LeagueRepository;
import com.example.leagues.model.League;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class LeagueService {


    private  final CountryRepository countryRepository;
    private final SportRepository sportRepository;
    private final LeagueRepository leagueRepository;

    @Autowired
    public LeagueService(LeagueRepository leagueRepository, CountryRepository countryRepository, SportRepository sportRepository) {
        this.leagueRepository = leagueRepository;
        this.countryRepository = countryRepository;
        this.sportRepository = sportRepository;
    }

    public List<LeagueDTO> getCountries() {
        return leagueRepository.findAll().stream()
                .map(LeagueMapper::toDTO)
                .collect(Collectors.toList());
    }

    public LeagueDTO getLeagueById(Long id) {
        return LeagueMapper.toDTO(Objects.requireNonNull(leagueRepository.findById(id).orElse(null)));
    }

    public LeagueDTO saveLeague(LeagueDTO leagueDTO) {
        League league = LeagueMapper.toEntity(leagueDTO);
        return LeagueMapper.toDTO(leagueRepository.save(league));
    }

    public LeagueDTO updateLeague(Long id, LeagueDTO leagueDTO) {
        League league = LeagueMapper.toEntity(leagueDTO);
        league.setId(id);
        return LeagueMapper.toDTO(leagueRepository.save(league));
    }

    public void deleteLeague(Long id) {
        leagueRepository.deleteById(id);
    }

    public LeagueDTO save(LeagueDTO leagueDTO) {
        League league = LeagueMapper.toEntity(leagueDTO);
        league.setCountry(countryRepository.findById(leagueDTO.getCountryId()).orElse(null));
        league.setSport(sportRepository.findById(leagueDTO.getSportId()).orElse(null));
        return LeagueMapper.toDTO(leagueRepository.save(league));
    }

}
