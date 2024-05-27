package com.example.leagues.service;

import com.example.leagues.dto.CountryDTO;
import com.example.leagues.mapper.CountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.leagues.repository.CountryRepository;
import com.example.leagues.model.Country;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<CountryDTO> getCountries() {
        return countryRepository.findAll().stream()
                .map(CountryMapper::toDTO)
                .collect(Collectors.toList());
    }

}
