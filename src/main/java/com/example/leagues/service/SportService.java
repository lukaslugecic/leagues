package com.example.leagues.service;

import com.example.leagues.dto.SportDTO;
import com.example.leagues.mapper.SportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.leagues.repository.SportRepository;
import com.example.leagues.model.Sport;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SportService {

    private final SportRepository sportRepository;

    @Autowired
    public SportService(SportRepository sportRepository) {
        this.sportRepository = sportRepository;
    }

    public List<SportDTO> getCountries() {
        return sportRepository.findAll().stream()
                .map(SportMapper::toDTO)
                .collect(Collectors.toList());
    }

    public SportDTO getSportById(Long id) {
        return SportMapper.toDTO(Objects.requireNonNull(sportRepository.findById(id).orElse(null)));
    }

    public SportDTO saveSport(SportDTO sportDTO) {
        Sport sport = SportMapper.toEntity(sportDTO);
        return SportMapper.toDTO(sportRepository.save(sport));
    }

    public SportDTO updateSport(Long id, SportDTO sportDTO) {
        Sport sport = SportMapper.toEntity(sportDTO);
        sport.setId(id);
        return SportMapper.toDTO(sportRepository.save(sport));
    }

    public void deleteSport(Long id) {
        sportRepository.deleteById(id);
    }

}
